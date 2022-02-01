package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class Funcall
  extends JceStruct
{
  static ArrayList<Long> cache_rptUins = new ArrayList();
  public int funcallId;
  public int ringId;
  public ArrayList<Long> rptUins;
  
  static
  {
    cache_rptUins.add(Long.valueOf(0L));
  }
  
  public Funcall() {}
  
  public Funcall(int paramInt1, int paramInt2, ArrayList<Long> paramArrayList)
  {
    this.funcallId = paramInt1;
    this.ringId = paramInt2;
    this.rptUins = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.funcallId = paramJceInputStream.read(this.funcallId, 0, false);
    this.ringId = paramJceInputStream.read(this.ringId, 1, false);
    this.rptUins = ((ArrayList)paramJceInputStream.read(cache_rptUins, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.funcallId, 0);
    paramJceOutputStream.write(this.ringId, 1);
    if (this.rptUins != null) {
      paramJceOutputStream.write(this.rptUins, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QC.Funcall
 * JD-Core Version:    0.7.0.1
 */