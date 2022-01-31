package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_video
  extends JceStruct
{
  static Map cache_coverurl;
  static Map cache_videourls;
  public int actiontype = 0;
  public String actionurl = "";
  public String clientkey = "";
  public Map coverurl = null;
  public int filetype = 0;
  public String videoid = "";
  public long videotime = 0L;
  public byte videotype = 0;
  public String videourl = "";
  public Map videourls = null;
  
  public cell_video() {}
  
  public cell_video(String paramString1, String paramString2, Map paramMap1, int paramInt1, String paramString3, String paramString4, int paramInt2, byte paramByte, long paramLong, Map paramMap2)
  {
    this.videoid = paramString1;
    this.videourl = paramString2;
    this.coverurl = paramMap1;
    this.actiontype = paramInt1;
    this.actionurl = paramString3;
    this.clientkey = paramString4;
    this.filetype = paramInt2;
    this.videotype = paramByte;
    this.videotime = paramLong;
    this.videourls = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.videoid = paramJceInputStream.readString(0, false);
    this.videourl = paramJceInputStream.readString(1, false);
    Object localObject;
    if (cache_coverurl == null)
    {
      cache_coverurl = new HashMap();
      localObject = new s_picurl();
      cache_coverurl.put(Integer.valueOf(0), localObject);
    }
    this.coverurl = ((Map)paramJceInputStream.read(cache_coverurl, 2, false));
    this.actiontype = paramJceInputStream.read(this.actiontype, 3, false);
    this.actionurl = paramJceInputStream.readString(4, false);
    this.clientkey = paramJceInputStream.readString(5, false);
    this.filetype = paramJceInputStream.read(this.filetype, 6, false);
    this.videotype = paramJceInputStream.read(this.videotype, 7, false);
    this.videotime = paramJceInputStream.read(this.videotime, 8, false);
    if (cache_videourls == null)
    {
      cache_videourls = new HashMap();
      localObject = new s_videourl();
      cache_videourls.put(Integer.valueOf(0), localObject);
    }
    this.videourls = ((Map)paramJceInputStream.read(cache_videourls, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.videoid != null) {
      paramJceOutputStream.write(this.videoid, 0);
    }
    if (this.videourl != null) {
      paramJceOutputStream.write(this.videourl, 1);
    }
    if (this.coverurl != null) {
      paramJceOutputStream.write(this.coverurl, 2);
    }
    paramJceOutputStream.write(this.actiontype, 3);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 4);
    }
    if (this.clientkey != null) {
      paramJceOutputStream.write(this.clientkey, 5);
    }
    paramJceOutputStream.write(this.filetype, 6);
    paramJceOutputStream.write(this.videotype, 7);
    paramJceOutputStream.write(this.videotime, 8);
    if (this.videourls != null) {
      paramJceOutputStream.write(this.videourls, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_video
 * JD-Core Version:    0.7.0.1
 */