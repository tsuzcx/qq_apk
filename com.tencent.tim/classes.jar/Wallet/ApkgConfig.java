package Wallet;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ApkgConfig
  extends JceStruct
{
  private static final int BIT_DEBUG_RUNTIME = 4;
  private static final int BIT_INNER_USER = 2;
  private static final int BIT_RISK_SWITCH = 1;
  static ArrayList<AllowDomainInfo> cache_allow_domains;
  static Map<String, String> cache_sub_apkg_urls = new HashMap();
  public ArrayList<AllowDomainInfo> allow_domains;
  public String apkg_url = "";
  public String app_name = "";
  public int bit_control;
  public String cos_sign = "";
  public String desc_info = "";
  public String icon_url = "";
  public String mini_appid = "";
  public int mini_version;
  public String qq_qr_code = "";
  public String share_pic_url = "";
  public Map<String, String> sub_apkg_urls;
  public String union_id = "";
  public String wx_qr_code = "";
  
  static
  {
    cache_sub_apkg_urls.put("", "");
    cache_allow_domains = new ArrayList();
    AllowDomainInfo localAllowDomainInfo = new AllowDomainInfo();
    cache_allow_domains.add(localAllowDomainInfo);
  }
  
  public ApkgConfig() {}
  
  public ApkgConfig(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, Map<String, String> paramMap, String paramString6, String paramString7, int paramInt2, ArrayList<AllowDomainInfo> paramArrayList, String paramString8, String paramString9, String paramString10)
  {
    this.mini_appid = paramString1;
    this.union_id = paramString2;
    this.app_name = paramString3;
    this.mini_version = paramInt1;
    this.icon_url = paramString4;
    this.apkg_url = paramString5;
    this.sub_apkg_urls = paramMap;
    this.desc_info = paramString6;
    this.share_pic_url = paramString7;
    this.bit_control = paramInt2;
    this.allow_domains = paramArrayList;
    this.wx_qr_code = paramString8;
    this.qq_qr_code = paramString9;
    this.cos_sign = paramString10;
  }
  
  public int getRuntimeType()
  {
    if ((this.bit_control & 0x4) != 0) {
      return 1;
    }
    return 0;
  }
  
  public boolean isInnerUser()
  {
    return (this.bit_control & 0x2) != 0;
  }
  
  public boolean isRiskOpen()
  {
    return (this.bit_control & 0x1) != 0;
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.mini_appid)) && (!TextUtils.isEmpty(this.app_name)) && (!TextUtils.isEmpty(this.icon_url)) && (!TextUtils.isEmpty(this.apkg_url));
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mini_appid = paramJceInputStream.readString(0, false);
    this.union_id = paramJceInputStream.readString(1, false);
    this.app_name = paramJceInputStream.readString(2, false);
    this.mini_version = paramJceInputStream.read(this.mini_version, 3, false);
    this.icon_url = paramJceInputStream.readString(4, false);
    this.apkg_url = paramJceInputStream.readString(5, false);
    this.sub_apkg_urls = ((Map)paramJceInputStream.read(cache_sub_apkg_urls, 6, false));
    this.desc_info = paramJceInputStream.readString(7, false);
    this.share_pic_url = paramJceInputStream.readString(8, false);
    this.bit_control = paramJceInputStream.read(this.bit_control, 9, false);
    this.allow_domains = ((ArrayList)paramJceInputStream.read(cache_allow_domains, 10, false));
    this.wx_qr_code = paramJceInputStream.readString(11, false);
    this.qq_qr_code = paramJceInputStream.readString(12, false);
    this.cos_sign = paramJceInputStream.readString(13, false);
  }
  
  public String toString()
  {
    return "ApkgConfig{mini_appid='" + this.mini_appid + '\'' + ", union_id='" + this.union_id + '\'' + ", app_name='" + this.app_name + '\'' + ", mini_version=" + this.mini_version + ", icon_url='" + this.icon_url + '\'' + ", downloadUrl='" + this.apkg_url + '\'' + ", sub_apkg_urls=" + this.sub_apkg_urls + ", desc_info='" + this.desc_info + '\'' + ", share_pic_url='" + this.share_pic_url + '\'' + ", bit_control=" + this.bit_control + ", allow_domains=" + this.allow_domains + ", wx_qr_code='" + this.wx_qr_code + '\'' + ", qq_qr_code='" + this.qq_qr_code + '\'' + ", cos_sign='" + this.cos_sign + '\'' + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mini_appid != null) {
      paramJceOutputStream.write(this.mini_appid, 0);
    }
    if (this.union_id != null) {
      paramJceOutputStream.write(this.union_id, 1);
    }
    if (this.app_name != null) {
      paramJceOutputStream.write(this.app_name, 2);
    }
    paramJceOutputStream.write(this.mini_version, 3);
    if (this.icon_url != null) {
      paramJceOutputStream.write(this.icon_url, 4);
    }
    if (this.apkg_url != null) {
      paramJceOutputStream.write(this.apkg_url, 5);
    }
    if (this.sub_apkg_urls != null) {
      paramJceOutputStream.write(this.sub_apkg_urls, 6);
    }
    if (this.desc_info != null) {
      paramJceOutputStream.write(this.desc_info, 7);
    }
    if (this.share_pic_url != null) {
      paramJceOutputStream.write(this.share_pic_url, 8);
    }
    paramJceOutputStream.write(this.bit_control, 9);
    if (this.allow_domains != null) {
      paramJceOutputStream.write(this.allow_domains, 10);
    }
    if (this.wx_qr_code != null) {
      paramJceOutputStream.write(this.wx_qr_code, 11);
    }
    if (this.qq_qr_code != null) {
      paramJceOutputStream.write(this.qq_qr_code, 12);
    }
    if (this.cos_sign != null) {
      paramJceOutputStream.write(this.cos_sign, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     Wallet.ApkgConfig
 * JD-Core Version:    0.7.0.1
 */