import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

public abstract class swr
{
  public HashMap<String, Integer> gh = new HashMap();
  
  public static long J(long paramLong)
  {
    Object localObject = new ByteArrayOutputStream(8);
    DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
    try
    {
      localDataOutputStream.writeLong(paramLong);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      localObject[0] = 0;
      localObject[1] = 0;
      paramLong = new DataInputStream(new ByteArrayInputStream((byte[])localObject)).readLong();
      return paramLong;
    }
    catch (IOException localIOException) {}
    return 0L;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return null;
  }
  
  public abstract boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket);
  
  public byte[] a(ToServiceMsg paramToServiceMsg)
  {
    return null;
  }
  
  public final <T> T decodePacket(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramT);
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public void destroy() {}
  
  public void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public abstract String[] y();
  
  public boolean yg()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     swr
 * JD-Core Version:    0.7.0.1
 */