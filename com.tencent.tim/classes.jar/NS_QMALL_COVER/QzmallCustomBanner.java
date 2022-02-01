package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallCustomBanner
  extends JceStruct
{
  static BannerStyleConf cache_stBannerStyle = new BannerStyleConf();
  public int iBannerConfType;
  public int iBannerType;
  public BannerStyleConf stBannerStyle;
  public String strBannerUrl = "";
  public String strJumpUrl = "";
  public String strQbossTraceinfo = "";
  
  public QzmallCustomBanner() {}
  
  public QzmallCustomBanner(int paramInt1, String paramString1, String paramString2, int paramInt2, BannerStyleConf paramBannerStyleConf, String paramString3)
  {
    this.iBannerType = paramInt1;
    this.strBannerUrl = paramString1;
    this.strJumpUrl = paramString2;
    this.iBannerConfType = paramInt2;
    this.stBannerStyle = paramBannerStyleConf;
    this.strQbossTraceinfo = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iBannerType = paramJceInputStream.read(this.iBannerType, 0, false);
    this.strBannerUrl = paramJceInputStream.readString(1, false);
    this.strJumpUrl = paramJceInputStream.readString(2, false);
    this.iBannerConfType = paramJceInputStream.read(this.iBannerConfType, 3, false);
    this.stBannerStyle = ((BannerStyleConf)paramJceInputStream.read(cache_stBannerStyle, 4, false));
    this.strQbossTraceinfo = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iBannerType, 0);
    if (this.strBannerUrl != null) {
      paramJceOutputStream.write(this.strBannerUrl, 1);
    }
    if (this.strJumpUrl != null) {
      paramJceOutputStream.write(this.strJumpUrl, 2);
    }
    paramJceOutputStream.write(this.iBannerConfType, 3);
    if (this.stBannerStyle != null) {
      paramJceOutputStream.write(this.stBannerStyle, 4);
    }
    if (this.strQbossTraceinfo != null) {
      paramJceOutputStream.write(this.strQbossTraceinfo, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallCustomBanner
 * JD-Core Version:    0.7.0.1
 */