package marshalling;

import org.apache.dubbo.common.serialize.ObjectInput;

import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.Unmarshaller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

public class MarshallingObjectInput implements ObjectInput {
    private static final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("river");;
    private final MarshallingConfiguration configuration;
    private InputStream inputStream;

    private Unmarshaller unmarshaller;

    public MarshallingObjectInput(InputStream in) throws IOException {
        configuration = new MarshallingConfiguration();
        this.inputStream = new BufferedInputStream(in);
        unmarshaller = marshallerFactory.createUnmarshaller(configuration);
        unmarshaller.start(Marshalling.createByteInput(inputStream));

    }

    @Override
    public Object readObject() throws IOException, ClassNotFoundException {
        return read(null);
    }

    @Override
    public <T> T readObject(Class<T> cls) throws IOException, ClassNotFoundException {
        return read(cls);
    }

    @Override
    public <T> T readObject(Class<T> cls, Type type) throws IOException, ClassNotFoundException {
        return read(cls);
    }

    @Override
    public boolean readBool() throws IOException {
        return read(Boolean.class);
    }

    @Override
    public byte readByte() throws IOException {
        return read(Byte.class);
    }

    @Override
    public short readShort() throws IOException {
        return read(Short.class);
    }

    @Override
    public int readInt() throws IOException {
        return read(Integer.class);
    }

    @Override
    public long readLong() throws IOException {
        return read(Long.class);
    }

    @Override
    public float readFloat() throws IOException {
        return read(Float.class);
    }

    @Override
    public double readDouble() throws IOException {
        return read(Double.class);
    }

    @Override
    public String readUTF() throws IOException {
        return read(String.class);
    }

    @Override
    public byte[] readBytes() throws IOException {

        int available = unmarshaller.available();
        byte[] bytes = new byte[available];
        unmarshaller.read(bytes);

        return bytes;
    }

    private <T> T read(Class<T> cls) throws IOException{
        T object;
        try {
            if (null == cls) {
                object = (T) unmarshaller.readObject();
            } else {
                object = unmarshaller.readObject(cls);
            }
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
        System.out.println("read :" + object);
        return object;
    }
}
