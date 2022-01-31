package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportBannerOpUnit
  extends JceStruct
{
  static int cache_eBoardID;
  static int cache_eOpType;
  public int detail_info = 0;
  public int eBoardID = 0;
  public int eOpType = 0;
  public long iAdID = 0L;
  public long iTraceID = 0L;
  public String report_info = "";
  
  public ReportBannerOpUnit() {}
  
  public ReportBannerOpUnit(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, String paramString)
  {
    this.iAdID = paramLong1;
    this.eBoardID = paramInt1;
    this.iTraceID = paramLong2;
    this.eOpType = paramInt2;
    this.detail_info = paramInt3;
    this.report_info = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAdID = paramJceInputStream.read(this.iAdID, 0, true);
    this.eBoardID = paramJceInputStream.read(this.eBoardID, 1, true);
    this.iTraceID = paramJceInputStream.read(this.iTraceID, 2, true);
    this.eOpType = paramJceInputStream.read(this.eOpType, 3, true);
    this.detail_info = paramJceInputStream.read(this.detail_info, 4, false);
    this.report_info = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAdID, 0);
    paramJceOutputStream.write(this.eBoardID, 1);
    paramJceOutputStream.write(this.iTraceID, 2);
    paramJceOutputStream.write(this.eOpType, 3);
    paramJceOutputStream.write(this.detail_info, 4);
    if (this.report_info != null) {
      paramJceOutputStream.write(this.report_info, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_AD_BANNER.ReportBannerOpUnit
 * JD-Core Version:    0.7.0.1
 */