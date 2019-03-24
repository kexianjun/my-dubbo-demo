package marshalling;

import org.apache.dubbo.common.serialize.ObjectOutput;

import org.jboss.marshalling.Marshaller;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

import java.io.IOException;
import java.io.OutputStream;

public class MarshallingObjectOutput implements ObjectOutput {
    private final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("river");;
    private final MarshallingConfiguration configuration;
    private OutputStream outputStream;
    private Marshaller marshaller;

    public MarshallingObjectOutput(OutputStream out) throws IOException {
        configuration = new MarshallingConfiguration();
        configuration.setVersion(3);
        this.outputStream = out;
        marshaller = marshallerFactory.createMarshaller(configuration);
        marshaller.start(Marshalling.createByteOutput(outputStream));

    }

    @Override
    public void writeObject(Object obj) throws IOException {
        System.out.println("write :" + obj);
        marshaller.writeObject(obj);
    }

    @Override
    public void writeBool(boolean v) throws IOException {
        writeObject(v);
    }

    @Override
    public void writeByte(byte v) throws IOException {
        writeObject(v);
    }

    @Override
    public void writeShort(short v) throws IOException {
        writeObject(v);
    }

    @Override
    public void writeInt(int v) throws IOException {
        writeObject(v);
    }

    @Override
    public void writeLong(long v) throws IOException {
        writeObject(v);
    }

    @Override
    public void writeFloat(float v) throws IOException {
        writeObject(v);
    }

    @Override
    public void writeDouble(double v) throws IOException {
        writeObject(v);
    }

    @Override
    public void writeUTF(String v) throws IOException {
        writeObject(v);
    }

    @Override
    public void writeBytes(byte[] v) throws IOException {
        writeObject(v);
    }

    @Override
    public void writeBytes(byte[] v, int off, int len) throws IOException {
        marshaller.write(v, off, len);
    }

    @Override
    public void flushBuffer() throws IOException {
        outputStream.flush();
        marshaller.finish();
    }
}
