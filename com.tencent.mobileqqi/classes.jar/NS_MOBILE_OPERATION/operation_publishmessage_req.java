package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_publishmessage_req
  extends JceStruct
{
  static Map cache_busi_param;
  static MediaInfo cache_mediainfo;
  public Map busi_param = null;
  public String content = "";
  public int iMsgType = 0;
  public boolean isverified = true;
  public int mediabittype = 0;
  public MediaInfo mediainfo = null;
  public long ownuin = 0L;
  public long uin = 0L;
  
  public operation_publishmessage_req() {}
  
  public operation_publishmessage_req(long paramLong1, long paramLong2, String paramString, boolean paramBoolean, int paramInt1, MediaInfo paramMediaInfo, Map paramMap, int paramInt2)
  {
    this.uin = paramLong1;
    this.ownuin = paramLong2;
    this.content = paramString;
    this.isverified = paramBoolean;
    this.mediabittype = paramInt1;
    this.mediainfo = paramMediaInfo;
    this.busi_param = paramMap;
    this.iMsgType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.ownuin = paramJceInputStream.read(this.ownuin, 1, false);
    this.content = paramJceInputStream.readString(2, false);
    this.isverified = paramJceInputStream.read(this.isverified, 3, false);
    this.mediabittype = paramJceInputStream.read(this.mediabittype, 4, false);
    if (cache_mediainfo == null) {
      cache_mediainfo = new MediaInfo();
    }
    this.mediainfo = ((MediaInfo)paramJceInputStream.read(cache_mediainfo, 5, false));
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 6, false));
    this.iMsgType = paramJceInputStream.read(this.iMsgType, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.ownuin, 1);
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 2);
    }
    paramJceOutputStream.write(this.isverified, 3);
    paramJceOutputStream.write(this.mediabittype, 4);
    if (this.mediainfo != null) {
      paramJceOutputStream.write(this.mediainfo, 5);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 6);
    }
    paramJceOutputStream.write(this.iMsgType, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_publishmessage_req
 * JD-Core Version:    0.7.0.1
 */