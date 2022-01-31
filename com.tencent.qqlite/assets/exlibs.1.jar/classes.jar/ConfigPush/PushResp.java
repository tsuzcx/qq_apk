package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PushResp
  extends JceStruct
{
  static byte[] cache_jcebuf;
  public byte[] jcebuf = null;
  public long lSeq = 0L;
  public int type = 0;
  
  public PushResp() {}
  
  public PushResp(int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    this.type = paramInt;
    this.lSeq = paramLong;
    this.jcebuf = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 1, true);
    this.lSeq = paramJceInputStream.read(this.lSeq, 2, true);
    if (cache_jcebuf == null)
    {
      cache_jcebuf = (byte[])new byte[1];
      ((byte[])cache_jcebuf)[0] = 0;
    }
    this.jcebuf = ((byte[])paramJceInputStream.read(cache_jcebuf, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 1);
    paramJceOutputStream.write(this.lSeq, 2);
    if (this.jcebuf != null) {
      paramJceOutputStream.write(this.jcebuf, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ConfigPush.PushResp
 * JD-Core Version:    0.7.0.1
 */