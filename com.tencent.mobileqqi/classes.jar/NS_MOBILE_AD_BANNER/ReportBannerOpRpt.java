package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReportBannerOpRpt
  extends JceStruct
{
  static ArrayList cache_vecBannerOp;
  public long iAppSourceID = 0L;
  public long iUin = 0L;
  public String strPhoneQua = "";
  public ArrayList vecBannerOp = null;
  
  public ReportBannerOpRpt() {}
  
  public ReportBannerOpRpt(long paramLong1, ArrayList paramArrayList, String paramString, long paramLong2)
  {
    this.iUin = paramLong1;
    this.vecBannerOp = paramArrayList;
    this.strPhoneQua = paramString;
    this.iAppSourceID = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUin = paramJceInputStream.read(this.iUin, 0, true);
    if (cache_vecBannerOp == null)
    {
      cache_vecBannerOp = new ArrayList();
      ReportBannerOpUnit localReportBannerOpUnit = new ReportBannerOpUnit();
      cache_vecBannerOp.add(localReportBannerOpUnit);
    }
    this.vecBannerOp = ((ArrayList)paramJceInputStream.read(cache_vecBannerOp, 1, true));
    this.strPhoneQua = paramJceInputStream.readString(2, true);
    this.iAppSourceID = paramJceInputStream.read(this.iAppSourceID, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUin, 0);
    paramJceOutputStream.write(this.vecBannerOp, 1);
    paramJceOutputStream.write(this.strPhoneQua, 2);
    paramJceOutputStream.write(this.iAppSourceID, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_AD_BANNER.ReportBannerOpRpt
 * JD-Core Version:    0.7.0.1
 */