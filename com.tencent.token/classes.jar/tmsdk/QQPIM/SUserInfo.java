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
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (SUserInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.imei, paramObject.imei))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.qq, paramObject.qq))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.phone, paramObject.phone))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.ip, paramObject.ip))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.lc, paramObject.lc))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.imsi, paramObject.imsi))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.version, paramObject.version))
                {
                  bool1 = bool2;
                  if (JceUtil.equals(this.buildno, paramObject.buildno))
                  {
                    bool1 = bool2;
                    if (JceUtil.equals(this.productid, paramObject.productid))
                    {
                      bool1 = bool2;
                      if (JceUtil.equals(this.ruletime, paramObject.ruletime)) {
                        bool1 = true;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
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
    String str = this.qq;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.phone;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.ip;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.lc;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.imsi;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.version;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
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