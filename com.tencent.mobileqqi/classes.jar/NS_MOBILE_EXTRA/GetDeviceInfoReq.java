package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetDeviceInfoReq
  extends JceStruct
{
  public long iUin = 0L;
  
  public GetDeviceInfoReq() {}
  
  public GetDeviceInfoReq(long paramLong)
  {
    this.iUin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUin = paramJceInputStream.read(this.iUin, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUin, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_EXTRA.GetDeviceInfoReq
 * JD-Core Version:    0.7.0.1
 */