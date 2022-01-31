package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QmfBusiControl
  extends JceStruct
{
  public int compFlag = 0;
  public long lenBeforeComp = 0L;
  public int rspCompFlag = 0;
  
  public QmfBusiControl() {}
  
  public QmfBusiControl(int paramInt1, long paramLong, int paramInt2)
  {
    this.compFlag = paramInt1;
    this.lenBeforeComp = paramLong;
    this.rspCompFlag = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.compFlag = paramJceInputStream.read(this.compFlag, 0, true);
    this.lenBeforeComp = paramJceInputStream.read(this.lenBeforeComp, 1, true);
    this.rspCompFlag = paramJceInputStream.read(this.rspCompFlag, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.compFlag, 0);
    paramJceOutputStream.write(this.lenBeforeComp, 1);
    paramJceOutputStream.write(this.rspCompFlag, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QMF_PROTOCAL.QmfBusiControl
 * JD-Core Version:    0.7.0.1
 */