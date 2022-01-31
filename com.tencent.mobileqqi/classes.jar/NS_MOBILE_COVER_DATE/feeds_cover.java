package NS_MOBILE_COVER_DATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class feeds_cover
  extends JceStruct
{
  static Map cache_MulRelsotionUrl;
  static CoverPackageInfo cache_packageInfo;
  static ArrayList cache_vecUrls;
  public Map MulRelsotionUrl = null;
  public String id = "";
  public CoverPackageInfo packageInfo = null;
  public String type = "";
  public ArrayList vecUrls = null;
  
  public feeds_cover() {}
  
  public feeds_cover(String paramString1, Map paramMap, CoverPackageInfo paramCoverPackageInfo, ArrayList paramArrayList, String paramString2, int paramInt)
  {
    this.type = paramString1;
    this.MulRelsotionUrl = paramMap;
    this.packageInfo = paramCoverPackageInfo;
    this.vecUrls = paramArrayList;
    this.id = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.readString(0, false);
    if (cache_MulRelsotionUrl == null)
    {
      cache_MulRelsotionUrl = new HashMap();
      cache_MulRelsotionUrl.put("", "");
    }
    this.MulRelsotionUrl = ((Map)paramJceInputStream.read(cache_MulRelsotionUrl, 1, false));
    if (cache_packageInfo == null) {
      cache_packageInfo = new CoverPackageInfo();
    }
    this.packageInfo = ((CoverPackageInfo)paramJceInputStream.read(cache_packageInfo, 2, false));
    if (cache_vecUrls == null)
    {
      cache_vecUrls = new ArrayList();
      HashMap localHashMap = new HashMap();
      localHashMap.put(Integer.valueOf(0), "");
      cache_vecUrls.add(localHashMap);
    }
    this.vecUrls = ((ArrayList)paramJceInputStream.read(cache_vecUrls, 3, false));
    this.id = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.type != null) {
      paramJceOutputStream.write(this.type, 0);
    }
    if (this.MulRelsotionUrl != null) {
      paramJceOutputStream.write(this.MulRelsotionUrl, 1);
    }
    if (this.packageInfo != null) {
      paramJceOutputStream.write(this.packageInfo, 2);
    }
    if (this.vecUrls != null) {
      paramJceOutputStream.write(this.vecUrls, 3);
    }
    if (this.id != null) {
      paramJceOutputStream.write(this.id, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_COVER_DATE.feeds_cover
 * JD-Core Version:    0.7.0.1
 */