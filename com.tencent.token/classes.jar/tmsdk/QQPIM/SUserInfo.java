package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class SUserInfo
  extends JceStruct
  implements Cloneable
{
  public int buildno = 0;
  public String imei = "";
  public String imsi = "";
  public String ip = "";
  public String lc = "";
  public String phone = "";
  public int productid = 0;
  public String qq = "";
  public int ruletime = 0;
  public String version = "";
  
  static
  {
    if (!SUserInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SUserInfo()
  {
    setImei(this.imei);
    setQq(this.qq);
    setPhone(this.phone);
    setIp(this.ip);
    setLc(this.lc);
    setImsi(this.imsi);
    setVersion(this.version);
    setBuildno(this.buildno);
    setProductid(this.productid);
    setRuletime(this.ruletime);
  }
  
  public SUserInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, int paramInt2, int paramInt3)
  {
    setImei(paramString1);
    setQq(paramString2);
    setPhone(paramString3);
    setIp(paramString4);
    setLc(paramString5);
    setImsi(paramString6);
    setVersion(paramString7);
    setBuildno(paramInt1);
    setProductid(paramInt2);
    setRuletime(paramInt3);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.SUserInfo";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (SUserInfo)paramObject;
    } while ((!JceUtil.equals(this.imei, paramObject.imei)) || (!JceUtil.equals(this.qq, paramObject.qq)) || (!JceUtil.equals(this.phone, paramObject.phone)) || (!JceUtil.equals(this.ip, paramObject.ip)) || (!JceUtil.equals(this.lc, paramObject.lc)) || (!JceUtil.equals(this.imsi, paramObject.imsi)) || (!JceUtil.equals(this.version, paramObject.version)) || (!JceUtil.equals(this.buildno, paramObject.buildno)) || (!JceUtil.equals(this.productid, paramObject.productid)) || (!JceUtil.equals(this.ruletime, paramObject.ruletime)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.SUserInfo";
  }
  
  public int getBuildno()
  {
    return this.buildno;
  }
  
  public String getImei()
  {
    return this.imei;
  }
  
  public String getImsi()
  {
    return this.imsi;
  }
  
  public String getIp()
  {
    return this.ip;
  }
  
  public String getLc()
  {
    return this.lc;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public int getProductid()
  {
    return this.productid;
  }
  
  public String getQq()
  {
    return this.qq;
  }
  
  public int getRuletime()
  {
    return this.ruletime;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    setImei(paramJceInputStream.readString(0, true));
    setQq(paramJceInputStream.readString(1, false));
    setPhone(paramJceInputStream.readString(2, false));
    setIp(paramJceInputStream.readString(3, false));
    setLc(paramJceInputStream.readString(4, false));
    setImsi(paramJceInputStream.readString(5, false));
    setVersion(paramJceInputStream.readString(6, false));
    setBuildno(paramJceInputStream.read(this.buildno, 7, false));
    setProductid(paramJceInputStream.read(this.productid, 8, false));
    setRuletime(paramJceInputStream.read(this.ruletime, 9, false));
  }
  
  public void setBuildno(int paramInt)
  {
    this.buildno = paramInt;
  }
  
  public void setImei(String paramString)
  {
    this.imei = paramString;
  }
  
  public void setImsi(String paramString)
  {
    this.imsi = paramString;
  }
  
  public void setIp(String paramString)
  {
    this.ip = paramString;
  }
  
  public void setLc(String paramString)
  {
    this.lc = paramString;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setProductid(int paramInt)
  {
    this.productid = paramInt;
  }
  
  public void setQq(String paramString)
  {
    this.qq = paramString;
  }
  
  public void setRuletime(int paramInt)
  {
    this.ruletime = paramInt;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.imei, 0);
    if (this.qq != null) {
      paramJceOutputStream.write(this.qq, 1);
    }
    if (this.phone != null) {
      paramJceOutputStream.write(this.phone, 2);
    }
    if (this.ip != null) {
      paramJceOutputStream.write(this.ip, 3);
    }
    if (this.lc != null) {
      paramJceOutputStream.write(this.lc, 4);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 5);
    }
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 6);
    }
    paramJceOutputStream.write(this.buildno, 7);
    paramJceOutputStream.write(this.productid, 8);
    paramJceOutputStream.write(this.ruletime, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SUserInfo
 * JD-Core Version:    0.7.0.1
 */