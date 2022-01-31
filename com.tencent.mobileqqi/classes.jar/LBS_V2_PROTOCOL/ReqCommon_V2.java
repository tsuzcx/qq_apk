package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqCommon_V2
  extends JceStruct
{
  public int iAppId = 0;
  public int iDeviceType = 0;
  
  public ReqCommon_V2() {}
  
  public ReqCommon_V2(int paramInt1, int paramInt2)
  {
    this.iAppId = paramInt1;
    this.iDeviceType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAppId = paramJceInputStream.read(this.iAppId, 0, true);
    this.iDeviceType = paramJceInputStream.read(this.iDeviceType, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAppId, 0);
    paramJceOutputStream.write(this.iDeviceType, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     LBS_V2_PROTOCOL.ReqCommon_V2
 * JD-Core Version:    0.7.0.1
 */