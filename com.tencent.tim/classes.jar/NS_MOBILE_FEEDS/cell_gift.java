package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_gift
  extends JceStruct
{
  static int cache_giftactiontype = 0;
  static Map<Integer, String> cache_gifturl = new HashMap();
  public String actionurl = "";
  public int giftactiontype = 1;
  public String giftbackid = "";
  public String giftdesc = "";
  public String giftid = "";
  public String giftname = "";
  public String gifttype = "";
  public Map<Integer, String> gifturl;
  
  static
  {
    cache_gifturl.put(Integer.valueOf(0), "");
  }
  
  public cell_gift() {}
  
  public cell_gift(String paramString1, String paramString2, String paramString3, Map<Integer, String> paramMap, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    this.giftname = paramString1;
    this.gifttype = paramString2;
    this.giftid = paramString3;
    this.gifturl = paramMap;
    this.giftdesc = paramString4;
    this.giftbackid = paramString5;
    this.giftactiontype = paramInt;
    this.actionurl = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.giftname = paramJceInputStream.readString(0, false);
    this.gifttype = paramJceInputStream.readString(1, false);
    this.giftid = paramJceInputStream.readString(2, false);
    this.gifturl = ((Map)paramJceInputStream.read(cache_gifturl, 3, false));
    this.giftdesc = paramJceInputStream.readString(4, false);
    this.giftbackid = paramJceInputStream.readString(5, false);
    this.giftactiontype = paramJceInputStream.read(this.giftactiontype, 6, false);
    this.actionurl = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.giftname != null) {
      paramJceOutputStream.write(this.giftname, 0);
    }
    if (this.gifttype != null) {
      paramJceOutputStream.write(this.gifttype, 1);
    }
    if (this.giftid != null) {
      paramJceOutputStream.write(this.giftid, 2);
    }
    if (this.gifturl != null) {
      paramJceOutputStream.write(this.gifturl, 3);
    }
    if (this.giftdesc != null) {
      paramJceOutputStream.write(this.giftdesc, 4);
    }
    if (this.giftbackid != null) {
      paramJceOutputStream.write(this.giftbackid, 5);
    }
    paramJceOutputStream.write(this.giftactiontype, 6);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_gift
 * JD-Core Version:    0.7.0.1
 */