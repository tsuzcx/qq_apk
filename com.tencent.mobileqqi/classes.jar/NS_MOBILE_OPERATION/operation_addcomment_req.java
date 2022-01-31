package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_addcomment_req
  extends JceStruct
{
  static Map cache_busi_param;
  static MediaInfo cache_mediainfo;
  public int appid = 0;
  public Map busi_param = null;
  public String content = "";
  public int isverified = 0;
  public int mediabittype = 0;
  public MediaInfo mediainfo = null;
  public long ownuin = 0L;
  public String srcId = "";
  public String srcSubid = "";
  public long uin = 0L;
  
  public operation_addcomment_req() {}
  
  public operation_addcomment_req(int paramInt1, long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt2, Map paramMap, String paramString3, MediaInfo paramMediaInfo, int paramInt3)
  {
    this.appid = paramInt1;
    this.uin = paramLong1;
    this.ownuin = paramLong2;
    this.srcId = paramString1;
    this.content = paramString2;
    this.isverified = paramInt2;
    this.busi_param = paramMap;
    this.srcSubid = paramString3;
    this.mediainfo = paramMediaInfo;
    this.mediabittype = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.ownuin = paramJceInputStream.read(this.ownuin, 2, false);
    this.srcId = paramJceInputStream.readString(3, false);
    this.content = paramJceInputStream.readString(4, false);
    this.isverified = paramJceInputStream.read(this.isverified, 5, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 6, false));
    this.srcSubid = paramJceInputStream.readString(7, false);
    if (cache_mediainfo == null) {
      cache_mediainfo = new MediaInfo();
    }
    this.mediainfo = ((MediaInfo)paramJceInputStream.read(cache_mediainfo, 8, false));
    this.mediabittype = paramJceInputStream.read(this.mediabittype, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.ownuin, 2);
    if (this.srcId != null) {
      paramJceOutputStream.write(this.srcId, 3);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 4);
    }
    paramJceOutputStream.write(this.isverified, 5);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 6);
    }
    if (this.srcSubid != null) {
      paramJceOutputStream.write(this.srcSubid, 7);
    }
    if (this.mediainfo != null) {
      paramJceOutputStream.write(this.mediainfo, 8);
    }
    paramJceOutputStream.write(this.mediabittype, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_addcomment_req
 * JD-Core Version:    0.7.0.1
 */