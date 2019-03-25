package marshalling;

import org.apache.dubbo.common.serialize.ObjectInput;

import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.Unmarshaller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

public class MarshallingObjectInput implements ObjectInput {
    private static final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
    private final MarshallingConfiguration configuration;

    private Unmarshaller unmarshaller;

    public MarshallingObjectInput(InputStream in) throws IOException {
        configuration = new MarshallingConfiguration();
        int available = in.available();
        if (available <= 0) {
            System.out.println("===========EOF==============");
        }

        configuration.setVersion(5);
        unmarshaller = marshallerFactory.createUnmarshaller(configuration);
        unmarshaller.start(Marshalling.createByteInput(in));

    }

    @Override
    public Object readObject() throws IOException, ClassNotFoundException {
        return unmarshaller.readObject();
    }

    @Override
    public <T> T readObject(Class<T> cls) throws IOException, ClassNotFoundException {
        return unmarshaller.readObject(cls);
    }

    @Override
    public <T> T readObject(Class<T> cls, Type type) throws IOException, ClassNotFoundException {
        return unmarshaller.readObject(cls);
    }

    @Override
    public boolean readBool() throws IOException {
        return unmarshaller.readBoolean();
    }

    @Override
    public byte readByte() throws IOException {
        return unmarshaller.readByte();
}

    @Override
    public short readShort() throws IOException {
        return unmarshaller.readShort();
    }

    @Override
    public int readInt() throws IOException {
        return unmarshaller.readInt();
    }

    @Override
    public long readLong() throws IOException {
        return unmarshaller.readLong();
    }

    @Override
    public float readFloat() throws IOException {
        return unmarshaller.readFloat();
    }

    @Override
    public double readDouble() throws IOException {
        return unmarshaller.readDouble();
    }

    @Override
    public String readUTF() throws IOException {
        return unmarshaller.readUTF();
    }

    @Override
    public byte[] readBytes() throws IOException {
        int available = unmarshaller.available();
        byte[] bytes = new byte[available];
        unmarshaller.read(bytes);

        return bytes;
    }

}
