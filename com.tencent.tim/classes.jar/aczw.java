import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class aczw
{
  public static byte[] b(Serializable paramSerializable)
    throws Exception
  {
    if (paramSerializable == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    new ObjectOutputStream(localByteArrayOutputStream).writeObject(paramSerializable);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static Object c(byte[] paramArrayOfByte)
    throws Exception
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    return new ObjectInputStream(new ByteArrayInputStream(paramArrayOfByte)).readObject();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aczw
 * JD-Core Version:    0.7.0.1
 */