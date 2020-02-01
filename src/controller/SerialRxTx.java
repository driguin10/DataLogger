package controller;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.TooManyListenersException;

public class SerialRxTx {
    public SerialPort serialPort;
    private OutputStream output;

    public SerialRxTx(String nomePorta) {   
        init(nomePorta);
    }
    
    public SerialRxTx() {   
    }

    public List<String> listaPortas() {
        CommPortIdentifier portid = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
        List<String> aux = new ArrayList<>();
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            if (currPortId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                aux.add(currPortId.getName());
            }
        }
        return aux;
    }

    public void init(String nomePorta) {
        SerialPort porta = null;
        try {
            CommPortIdentifier portid = null;
            Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
            while (portid == null && portEnum.hasMoreElements()) {
                CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
                if (currPortId.getName().equals(nomePorta) || currPortId.getName().startsWith(nomePorta)) {
                    porta = (SerialPort) currPortId.open("DataLogger", 1000);
                    portid = currPortId;
                }
            }

            if (portid == null || porta == null) {
                serialPort = null;
                return;
            }

            porta.notifyOnDataAvailable(true);
            porta.notifyOnBreakInterrupt(true);
            porta.setSerialPortParams(9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            porta.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            serialPort = porta;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("erroo:" + e);
            }
        } catch (PortInUseException | UnsupportedCommOperationException pe) {
            System.out.println("erroo:" + pe);
        }
    }

    public SerialPort getSerialPort() {
        if (serialPort != null) {
            return serialPort;
        } else {
            return null;
        }
    }

    public void sendData(String data) {
        try {
            output = serialPort.getOutputStream();
            output.write(data.getBytes());
        } catch (IOException e) {
            System.out.println("erroo:" + e);
        }
    }

    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
            serialPort = null;
        }
    }

    public String leitura(SerialPortEvent spe) {
        try {
            if (spe.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
                String inputLine = new BufferedReader(new InputStreamReader(serialPort.getInputStream())).readLine();
                if (inputLine != null && !inputLine.isEmpty()) {
                    return inputLine;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (IOException e) {
            close();
            return "x-close";
        }
    }
    
    public void addListener(SerialPortEventListener listener) {
        try {
            serialPort.addEventListener(listener);
        } catch (TooManyListenersException e) {
        }
    }
    
    
}
