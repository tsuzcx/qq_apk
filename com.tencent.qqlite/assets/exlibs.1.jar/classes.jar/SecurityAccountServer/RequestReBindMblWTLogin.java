package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestReBindMblWTLogin
  extends JceStruct
{
  static byte[] cache_encryptBuffer;
  public byte[] encryptBuffer = null;
  
  public RequestReBindMblWTLogin() {}
  
  public RequestReBindMblWTLogin(byte[] paramArrayOfByte)
  {
    this.encryptBuffer = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_encryptBuffer == null)
    {
      cache_encryptBuffer = (byte[])new byte[1];
      ((byte[])cache_encryptBuffer)[0] = 0;
    }
    this.encryptBuffer = ((byte[])paramJceInputStream.read(cache_encryptBuffer, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.encryptBuffer, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     SecurityAccountServer.RequestReBindMblWTLogin
 * JD-Core Version:    0.7.0.1
 */