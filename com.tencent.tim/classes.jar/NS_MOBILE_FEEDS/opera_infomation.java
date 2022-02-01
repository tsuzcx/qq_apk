package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class opera_infomation
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param = new HashMap();
  public Map<Integer, String> busi_param;
  public String strFeedsKey = "";
  public String strOperaData = "";
  public String strSummary = "";
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
  }
  
  public opera_infomation() {}
  
  public opera_infomation(Map<Integer, String> paramMap, String paramString1, String paramString2, String paramString3)
  {
    this.busi_param = paramMap;
    this.strFeedsKey = paramString1;
    this.strOperaData = paramString2;
    this.strSummary = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 0, false));
    this.strFeedsKey = paramJceInputStream.readString(1, false);
    this.strOperaData = paramJceInputStream.readString(2, false);
    this.strSummary = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 0);
    }
    if (this.strFeedsKey != null) {
      paramJceOutputStream.write(this.strFeedsKey, 1);
    }
    if (this.strOperaData != null) {
      paramJceOutputStream.write(this.strOperaData, 2);
    }
    if (this.strSummary != null) {
      paramJceOutputStream.write(this.strSummary, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.opera_infomation
 * JD-Core Version:    0.7.0.1
 */