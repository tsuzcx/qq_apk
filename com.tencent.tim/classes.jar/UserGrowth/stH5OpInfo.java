package UserGrowth;

import NS_KING_SOCIALIZE_META.stMetaTag;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stH5OpInfo
  extends JceStruct
{
  static Map<String, String> cache_exp;
  static stMetaTag cache_tag = new stMetaTag();
  public Map<String, String> exp;
  public String h5Url = "";
  public int id;
  public String maskImgUrl = "";
  public String scheme_url = "";
  public stMetaTag tag;
  public String text = "";
  public int type;
  
  static
  {
    cache_exp = new HashMap();
    cache_exp.put("", "");
  }
  
  public stH5OpInfo() {}
  
  public stH5OpInfo(int paramInt1, String paramString1, stMetaTag paramstMetaTag, String paramString2, int paramInt2, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    this.id = paramInt1;
    this.h5Url = paramString1;
    this.tag = paramstMetaTag;
    this.text = paramString2;
    this.type = paramInt2;
    this.scheme_url = paramString3;
    this.maskImgUrl = paramString4;
    this.exp = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.read(this.id, 0, false);
    this.h5Url = paramJceInputStream.readString(1, false);
    this.tag = ((stMetaTag)paramJceInputStream.read(cache_tag, 2, false));
    this.text = paramJceInputStream.readString(3, false);
    this.type = paramJceInputStream.read(this.type, 4, false);
    this.scheme_url = paramJceInputStream.readString(5, false);
    this.maskImgUrl = paramJceInputStream.readString(6, false);
    this.exp = ((Map)paramJceInputStream.read(cache_exp, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    if (this.h5Url != null) {
      paramJceOutputStream.write(this.h5Url, 1);
    }
    if (this.tag != null) {
      paramJceOutputStream.write(this.tag, 2);
    }
    if (this.text != null) {
      paramJceOutputStream.write(this.text, 3);
    }
    paramJceOutputStream.write(this.type, 4);
    if (this.scheme_url != null) {
      paramJceOutputStream.write(this.scheme_url, 5);
    }
    if (this.maskImgUrl != null) {
      paramJceOutputStream.write(this.maskImgUrl, 6);
    }
    if (this.exp != null) {
      paramJceOutputStream.write(this.exp, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.stH5OpInfo
 * JD-Core Version:    0.7.0.1
 */