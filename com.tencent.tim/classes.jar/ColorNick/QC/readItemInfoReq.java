package ColorNick.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class readItemInfoReq
  extends JceStruct
{
  public long implat;
  public int index;
  public String qqver = "";
  
  public readItemInfoReq() {}
  
  public readItemInfoReq(long paramLong, String paramString, int paramInt)
  {
    this.implat = paramLong;
    this.qqver = paramString;
    this.index = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.implat = paramJceInputStream.read(this.implat, 0, false);
    this.qqver = paramJceInputStream.readString(1, false);
    this.index = paramJceInputStream.read(this.index, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.implat, 0);
    if (this.qqver != null) {
      paramJceOutputStream.write(this.qqver, 1);
    }
    paramJceOutputStream.write(this.index, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ColorNick.QC.readItemInfoReq
 * JD-Core Version:    0.7.0.1
 */