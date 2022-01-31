package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class STagStats
  extends JceStruct
{
  public int reportnum = 0;
  public int tagetype = 0;
  
  public STagStats() {}
  
  public STagStats(int paramInt1, int paramInt2)
  {
    this.tagetype = paramInt1;
    this.reportnum = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.tagetype = paramJceInputStream.read(this.tagetype, 0, true);
    this.reportnum = paramJceInputStream.read(this.reportnum, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.tagetype, 0);
    paramJceOutputStream.write(this.reportnum, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.STagStats
 * JD-Core Version:    0.7.0.1
 */