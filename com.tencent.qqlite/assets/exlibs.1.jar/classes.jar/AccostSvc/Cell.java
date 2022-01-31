package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Cell
  extends JceStruct
{
  public int iCellId = -1;
  public int iLac = -1;
  public short shMcc = -1;
  public short shMnc = -1;
  
  public Cell() {}
  
  public Cell(short paramShort1, short paramShort2, int paramInt1, int paramInt2)
  {
    this.shMcc = paramShort1;
    this.shMnc = paramShort2;
    this.iLac = paramInt1;
    this.iCellId = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shMcc = paramJceInputStream.read(this.shMcc, 0, true);
    this.shMnc = paramJceInputStream.read(this.shMnc, 1, true);
    this.iLac = paramJceInputStream.read(this.iLac, 2, true);
    this.iCellId = paramJceInputStream.read(this.iCellId, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shMcc, 0);
    paramJceOutputStream.write(this.shMnc, 1);
    paramJceOutputStream.write(this.iLac, 2);
    paramJceOutputStream.write(this.iCellId, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     AccostSvc.Cell
 * JD-Core Version:    0.7.0.1
 */