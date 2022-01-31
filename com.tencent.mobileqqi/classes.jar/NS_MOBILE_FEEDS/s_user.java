package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_user
  extends JceStruct
{
  public int from = 1;
  public int level = 0;
  public String logo = "";
  public String nickname = "";
  public String qzonedesc = "";
  public int timestamp = 0;
  public long uin = 0L;
  public String uinkey = "";
  public int vip = 0;
  public int viplevel = 0;
  public int viptype = 0;
  
  public s_user() {}
  
  public s_user(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString4)
  {
    this.uin = paramLong;
    this.nickname = paramString1;
    this.timestamp = paramInt1;
    this.from = paramInt2;
    this.uinkey = paramString2;
    this.logo = paramString3;
    this.vip = paramInt3;
    this.level = paramInt4;
    this.viplevel = paramInt5;
    this.viptype = paramInt6;
    this.qzonedesc = paramString4;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (s_user)paramObject;
    } while (this.uin == paramObject.uin);
    return false;
  }
  
  public int hashCode()
  {
    return (int)(this.uin ^ this.uin >>> 32) + 31;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.nickname = paramJceInputStream.readString(1, false);
    this.timestamp = paramJceInputStream.read(this.timestamp, 2, false);
    this.from = paramJceInputStream.read(this.from, 3, false);
    this.uinkey = paramJceInputStream.readString(4, false);
    this.logo = paramJceInputStream.readString(5, false);
    this.vip = paramJceInputStream.read(this.vip, 6, false);
    this.level = paramJceInputStream.read(this.level, 7, false);
    this.viplevel = paramJceInputStream.read(this.viplevel, 8, false);
    this.viptype = paramJceInputStream.read(this.viptype, 9, false);
    this.qzonedesc = paramJceInputStream.readString(10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 1);
    }
    paramJceOutputStream.write(this.timestamp, 2);
    paramJceOutputStream.write(this.from, 3);
    if (this.uinkey != null) {
      paramJceOutputStream.write(this.uinkey, 4);
    }
    if (this.logo != null) {
      paramJceOutputStream.write(this.logo, 5);
    }
    paramJceOutputStream.write(this.vip, 6);
    paramJceOutputStream.write(this.level, 7);
    paramJceOutputStream.write(this.viplevel, 8);
    paramJceOutputStream.write(this.viptype, 9);
    if (this.qzonedesc != null) {
      paramJceOutputStream.write(this.qzonedesc, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_user
 * JD-Core Version:    0.7.0.1
 */