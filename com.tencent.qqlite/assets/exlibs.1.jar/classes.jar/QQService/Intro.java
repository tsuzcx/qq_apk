package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Intro
  extends JceStruct
{
  static byte[] cache_vContent;
  public short shType = 0;
  public byte[] vContent = null;
  
  public Intro() {}
  
  public Intro(short paramShort, byte[] paramArrayOfByte)
  {
    this.shType = paramShort;
    this.vContent = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shType = paramJceInputStream.read(this.shType, 0, true);
    if (cache_vContent == null)
    {
      cache_vContent = (byte[])new byte[1];
      ((byte[])cache_vContent)[0] = 0;
    }
    this.vContent = ((byte[])paramJceInputStream.read(cache_vContent, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shType, 0);
    paramJceOutputStream.write(this.vContent, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.Intro
 * JD-Core Version:    0.7.0.1
 */