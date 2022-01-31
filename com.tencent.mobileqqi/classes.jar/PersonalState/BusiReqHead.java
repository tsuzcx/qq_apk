package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BusiReqHead
  extends JceStruct
{
  public int iSeq = 0;
  public short shVersion = 0;
  
  public BusiReqHead() {}
  
  public BusiReqHead(short paramShort, int paramInt)
  {
    this.shVersion = paramShort;
    this.iSeq = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.iSeq = paramJceInputStream.read(this.iSeq, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.iSeq, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     PersonalState.BusiReqHead
 * JD-Core Version:    0.7.0.1
 */