package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QueryADBannerReq
  extends JceStruct
{
  static int cache_eBoardID;
  public int detail_info = 0;
  public int eBoardID = 0;
  public long iAppSourceID = 0L;
  public long iUin = 0L;
  public String strPhoneQua = "";
  
  public QueryADBannerReq() {}
  
  public QueryADBannerReq(long paramLong1, int paramInt1, String paramString, long paramLong2, int paramInt2)
  {
    this.iUin = paramLong1;
    this.eBoardID = paramInt1;
    this.strPhoneQua = paramString;
    this.iAppSourceID = paramLong2;
    this.detail_info = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUin = paramJceInputStream.read(this.iUin, 0, true);
    this.eBoardID = paramJceInputStream.read(this.eBoardID, 1, true);
    this.strPhoneQua = paramJceInputStream.readString(2, true);
    this.iAppSourceID = paramJceInputStream.read(this.iAppSourceID, 3, true);
    this.detail_info = paramJceInputStream.read(this.detail_info, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUin, 0);
    paramJceOutputStream.write(this.eBoardID, 1);
    paramJceOutputStream.write(this.strPhoneQua, 2);
    paramJceOutputStream.write(this.iAppSourceID, 3);
    paramJceOutputStream.write(this.detail_info, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_AD_BANNER.QueryADBannerReq
 * JD-Core Version:    0.7.0.1
 */