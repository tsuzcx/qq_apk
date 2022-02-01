package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TCoverInfo
  extends JceStruct
{
  static byte[] cache_vTagInfo = (byte[])new byte[1];
  public byte[] vTagInfo;
  
  static
  {
    ((byte[])cache_vTagInfo)[0] = 0;
  }
  
  public TCoverInfo() {}
  
  public TCoverInfo(byte[] paramArrayOfByte)
  {
    this.vTagInfo = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vTagInfo = ((byte[])paramJceInputStream.read(cache_vTagInfo, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vTagInfo != null) {
      paramJceOutputStream.write(this.vTagInfo, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SummaryCard.TCoverInfo
 * JD-Core Version:    0.7.0.1
 */