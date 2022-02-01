package oicq.wlogin_sdk.tlv_type;

import java.nio.ByteBuffer;

public class tlv_t508
  extends tlv_t
{
  public static boolean doFetch = true;
  public static int timeout = 1000;
  public static byte[] userBuf = new byte[0];
  
  public tlv_t508()
  {
    this._cmd = 1288;
  }
  
  public Boolean verify()
  {
    for (;;)
    {
      try
      {
        localObject1 = ByteBuffer.wrap(this._buf);
        ((ByteBuffer)localObject1).position(this._head_len);
        if (((ByteBuffer)localObject1).get() != 1) {
          continue;
        }
        bool = true;
        doFetch = bool;
        timeout = ((ByteBuffer)localObject1).getInt();
        userBuf = new byte[((ByteBuffer)localObject1).getShort()];
        ((ByteBuffer)localObject1).get(userBuf);
        if (timeout == 0) {
          timeout = 1000;
        }
        if (userBuf == null) {
          userBuf = new byte[0];
        }
        localObject1 = Boolean.valueOf(true);
      }
      catch (Exception localException)
      {
        Object localObject1;
        boolean bool;
        Boolean localBoolean = Boolean.valueOf(false);
        if (timeout != 0) {
          continue;
        }
        timeout = 1000;
        Object localObject2 = localBoolean;
        if (userBuf != null) {
          continue;
        }
        userBuf = new byte[0];
        return localBoolean;
      }
      finally
      {
        if (timeout != 0) {
          continue;
        }
        timeout = 1000;
        if (userBuf != null) {
          continue;
        }
        userBuf = new byte[0];
      }
      return localObject1;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t508
 * JD-Core Version:    0.7.0.1
 */