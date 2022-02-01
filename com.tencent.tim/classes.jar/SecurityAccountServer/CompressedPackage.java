package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CompressedPackage
  extends JceStruct
{
  static byte[] cache_buffer;
  static int cache_command;
  public byte[] buffer;
  public int command;
  public boolean compressed = true;
  
  public CompressedPackage() {}
  
  public CompressedPackage(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    this.compressed = paramBoolean;
    this.command = paramInt;
    this.buffer = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.compressed = paramJceInputStream.read(this.compressed, 0, true);
    this.command = paramJceInputStream.read(this.command, 1, true);
    if (cache_buffer == null)
    {
      cache_buffer = (byte[])new byte[1];
      ((byte[])cache_buffer)[0] = 0;
    }
    this.buffer = ((byte[])paramJceInputStream.read(cache_buffer, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.compressed, 0);
    paramJceOutputStream.write(this.command, 1);
    paramJceOutputStream.write(this.buffer, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SecurityAccountServer.CompressedPackage
 * JD-Core Version:    0.7.0.1
 */