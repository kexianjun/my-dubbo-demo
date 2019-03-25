package marshalling;

import org.apache.dubbo.common.serialize.ObjectOutput;

import org.jboss.marshalling.Marshaller;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

import java.io.IOException;
import java.io.OutputStream;

public class MarshallingObjectOutput implements ObjectOutput {
    private final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");;
    private final MarshallingConfiguration configuration;
    private Marshaller marshaller;

    public MarshallingObjectOutput(OutputStream out) throws IOException {
        configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        marshaller = marshallerFactory.createMarshaller(configuration);
        marshaller.start(Marshalling.createByteOutput(out));

    }

    @Override
    public void writeObject(Object obj) throws IOException {
        marshaller.writeObject(obj);
    }

    @Override
    public void writeBool(boolean v) throws IOException {
        marshaller.writeBoolean(v);
    }

    @Override
    public void writeByte(byte v) throws IOException {
        marshaller.writeByte(v);
    }

    @Override
    public void writeShort(short v) throws IOException {
        marshaller.writeShort(v);
    }

    @Override
    public void writeInt(int v) throws IOException {
        marshaller.writeInt(v);
    }

    @Override
    public void writeLong(long v) throws IOException {
        marshaller.writeLong(v);
    }

    @Override
    public void writeFloat(float v) throws IOException {
        marshaller.writeFloat(v);
    }

    @Override
    public void writeDouble(double v) throws IOException {
        marshaller.writeDouble(v);
    }

    @Override
    public void writeUTF(String v) throws IOException {
        marshaller.writeUTF(v);
    }

    @Override
    public void writeBytes(byte[] v) throws IOException {
        marshaller.write(v);
    }

    @Override
    public void writeBytes(byte[] v, int off, int len) throws IOException {
        marshaller.write(v, off, len);
    }

    @Override
    public void flushBuffer() throws IOException {
        marshaller.finish();
    }
}
