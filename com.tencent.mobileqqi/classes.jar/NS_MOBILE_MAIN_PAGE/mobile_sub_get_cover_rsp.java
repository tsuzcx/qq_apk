package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_COVER_DATE.CoverPackageInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class mobile_sub_get_cover_rsp
  extends JceStruct
{
  static Map cache_MulRelsotionUrl;
  static CoverPackageInfo cache_packageInfo;
  static ArrayList cache_vecUrls;
  public Map MulRelsotionUrl = null;
  public String cover = "";
  public String id = "";
  public CoverPackageInfo packageInfo = null;
  public String type = "";
  public ArrayList vecUrls = null;
  
  public mobile_sub_get_cover_rsp() {}
  
  public mobile_sub_get_cover_rsp(String paramString1, String paramString2, Map paramMap, CoverPackageInfo paramCoverPackageInfo, ArrayList paramArrayList, String paramString3, int paramInt)
  {
    this.cover = paramString1;
    this.type = paramString2;
    this.MulRelsotionUrl = paramMap;
    this.packageInfo = paramCoverPackageInfo;
    this.vecUrls = paramArrayList;
    this.id = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cover = paramJceInputStream.readString(0, false);
    this.type = paramJceInputStream.readString(1, false);
    if (cache_MulRelsotionUrl == null)
    {
      cache_MulRelsotionUrl = new HashMap();
      cache_MulRelsotionUrl.put("", "");
    }
    this.MulRelsotionUrl = ((Map)paramJceInputStream.read(cache_MulRelsotionUrl, 2, false));
    if (cache_packageInfo == null) {
      cache_packageInfo = new CoverPackageInfo();
    }
    this.packageInfo = ((CoverPackageInfo)paramJceInputStream.read(cache_packageInfo, 3, false));
    if (cache_vecUrls == null)
    {
      cache_vecUrls = new ArrayList();
      HashMap localHashMap = new HashMap();
      localHashMap.put(Integer.valueOf(0), "");
      cache_vecUrls.add(localHashMap);
    }
    this.vecUrls = ((ArrayList)paramJceInputStream.read(cache_vecUrls, 4, false));
    this.id = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.cover != null) {
      paramJceOutputStream.write(this.cover, 0);
    }
    if (this.type != null) {
      paramJceOutputStream.write(this.type, 1);
    }
    if (this.MulRelsotionUrl != null) {
      paramJceOutputStream.write(this.MulRelsotionUrl, 2);
    }
    if (this.packageInfo != null) {
      paramJceOutputStream.write(this.packageInfo, 3);
    }
    if (this.vecUrls != null) {
      paramJceOutputStream.write(this.vecUrls, 4);
    }
    if (this.id != null) {
      paramJceOutputStream.write(this.id, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp
 * JD-Core Version:    0.7.0.1
 */