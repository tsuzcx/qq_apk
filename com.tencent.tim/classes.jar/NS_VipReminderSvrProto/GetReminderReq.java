package NS_VipReminderSvrProto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class GetReminderReq
  extends JceStruct
{
  static Map<String, String> cache_MapUserInfo;
  public Map<String, String> MapUserInfo;
  public int iZoneId;
  public String sIp = "";
  public String sQua = "";
  public long uiUin;
  
  public GetReminderReq() {}
  
  public GetReminderReq(long paramLong, int paramInt, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    this.uiUin = paramLong;
    this.iZoneId = paramInt;
    this.sQua = paramString1;
    this.sIp = paramString2;
    this.MapUserInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uiUin = paramJceInputStream.read(this.uiUin, 0, true);
    this.iZoneId = paramJceInputStream.read(this.iZoneId, 1, true);
    this.sQua = paramJceInputStream.readString(2, false);
    this.sIp = paramJceInputStream.readString(3, false);
    if (cache_MapUserInfo == null)
    {
      cache_MapUserInfo = new HashMap();
      cache_MapUserInfo.put("", "");
    }
    this.MapUserInfo = ((Map)paramJceInputStream.read(cache_MapUserInfo, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uiUin, 0);
    paramJceOutputStream.write(this.iZoneId, 1);
    if (this.sQua != null) {
      paramJceOutputStream.write(this.sQua, 2);
    }
    if (this.sIp != null) {
      paramJceOutputStream.write(this.sIp, 3);
    }
    if (this.MapUserInfo != null) {
      paramJceOutputStream.write(this.MapUserInfo, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_VipReminderSvrProto.GetReminderReq
 * JD-Core Version:    0.7.0.1
 */