package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class yellow_info
  extends JceStruct
{
  public int iYellowLevel = 0;
  public int iYellowType = 0;
  
  public yellow_info() {}
  
  public yellow_info(int paramInt1, int paramInt2)
  {
    this.iYellowType = paramInt1;
    this.iYellowLevel = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iYellowType = paramJceInputStream.read(this.iYellowType, 0, false);
    this.iYellowLevel = paramJceInputStream.read(this.iYellowLevel, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iYellowType, 0);
    paramJceOutputStream.write(this.iYellowLevel, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_COMM.yellow_info
 * JD-Core Version:    0.7.0.1
 */