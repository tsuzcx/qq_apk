package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MeasureReportInfo
  extends JceStruct
{
  static MeasureInfo cache_stMeasureInfo;
  public int iGIP = 0;
  public int iLinkTime = 0;
  public int iReceiveTime = 0;
  public String sExtend = "";
  public MeasureInfo stMeasureInfo = null;
  
  public MeasureReportInfo() {}
  
  public MeasureReportInfo(int paramInt1, MeasureInfo paramMeasureInfo, int paramInt2, int paramInt3, String paramString)
  {
    this.iGIP = paramInt1;
    this.stMeasureInfo = paramMeasureInfo;
    this.iLinkTime = paramInt2;
    this.iReceiveTime = paramInt3;
    this.sExtend = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iGIP = paramJceInputStream.read(this.iGIP, 1, true);
    if (cache_stMeasureInfo == null) {
      cache_stMeasureInfo = new MeasureInfo();
    }
    this.stMeasureInfo = ((MeasureInfo)paramJceInputStream.read(cache_stMeasureInfo, 2, true));
    this.iLinkTime = paramJceInputStream.read(this.iLinkTime, 3, true);
    this.iReceiveTime = paramJceInputStream.read(this.iReceiveTime, 4, true);
    this.sExtend = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iGIP, 1);
    paramJceOutputStream.write(this.stMeasureInfo, 2);
    paramJceOutputStream.write(this.iLinkTime, 3);
    paramJceOutputStream.write(this.iReceiveTime, 4);
    if (this.sExtend != null) {
      paramJceOutputStream.write(this.sExtend, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     protocol.KQQConfig.MeasureReportInfo
 * JD-Core Version:    0.7.0.1
 */