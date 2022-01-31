package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class VirusScanPeriod
  extends JceStruct
{
  public int days = 0;
  
  public VirusScanPeriod() {}
  
  public VirusScanPeriod(int paramInt)
  {
    this.days = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.days = paramJceInputStream.read(this.days, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.days, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.VirusScanPeriod
 * JD-Core Version:    0.7.0.1
 */