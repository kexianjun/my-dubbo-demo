package marshalling;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.serialize.ObjectInput;
import org.apache.dubbo.common.serialize.ObjectOutput;
import org.apache.dubbo.common.serialize.Serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MarshallingSerialization implements Serialization {
    @Override
    public byte getContentTypeId() {
        return 20;
    }

    @Override
    public String getContentType() {
        return "x-application/marshalling";
    }

    @Override
    public ObjectOutput serialize(URL url, OutputStream output) throws IOException {
        return new MarshallingObjectOutput(output);
    }

    @Override
    public ObjectInput deserialize(URL url, InputStream input) throws IOException {
        return new MarshallingObjectInput(input);
    }
}
