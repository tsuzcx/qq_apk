package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PushReq
  extends JceStruct
{
  static byte[] cache_jcebuf;
  public byte[] jcebuf = null;
  public long lSeq = 0L;
  public int type = 0;
  
  public PushReq() {}
  
  public PushReq(int paramInt, byte[] paramArrayOfByte, long paramLong)
  {
    this.type = paramInt;
    this.jcebuf = paramArrayOfByte;
    this.lSeq = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 1, true);
    if (cache_jcebuf == null)
    {
      cache_jcebuf = (byte[])new byte[1];
      ((byte[])cache_jcebuf)[0] = 0;
    }
    this.jcebuf = ((byte[])paramJceInputStream.read(cache_jcebuf, 2, true));
    this.lSeq = paramJceInputStream.read(this.lSeq, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 1);
    paramJceOutputStream.write(this.jcebuf, 2);
    paramJceOutputStream.write(this.lSeq, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ConfigPush.PushReq
 * JD-Core Version:    0.7.0.1
 */