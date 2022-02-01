package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class DeviceInfo
  extends JceStruct
  implements Cloneable
{
  public String androidid = "";
  public String iccid = "";
  public String imei = "";
  public String imsi = "";
  public String lguid = "";
  public String mac = "";
  public String model = "";
  public String netfile = "";
  public String product = "";
  public int sdkversion = 0;
  
  public DeviceInfo()
  {
    setImei(this.imei);
    setImsi(this.imsi);
    setMac(this.mac);
    setIccid(this.iccid);
    setAndroidid(this.androidid);
    setSdkversion(this.sdkversion);
    setModel(this.model);
    setProduct(this.product);
    setNetfile(this.netfile);
    setLguid(this.lguid);
  }
  
  public DeviceInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    setImei(paramString1);
    setImsi(paramString2);
    setMac(paramString3);
    setIccid(paramString4);
    setAndroidid(paramString5);
    setSdkversion(paramInt);
    setModel(paramString6);
    setProduct(paramString7);
    setNetfile(paramString8);
    setLguid(paramString9);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.DeviceInfo";
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
    paramObject = (DeviceInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.imei, paramObject.imei))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.imsi, paramObject.imsi))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.mac, paramObject.mac))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.iccid, paramObject.iccid))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.androidid, paramObject.androidid))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.sdkversion, paramObject.sdkversion))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.model, paramObject.model))
                {
                  bool1 = bool2;
                  if (JceUtil.equals(this.product, paramObject.product))
                  {
                    bool1 = bool2;
                    if (JceUtil.equals(this.netfile, paramObject.netfile))
                    {
                      bool1 = bool2;
                      if (JceUtil.equals(this.lguid, paramObject.lguid)) {
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
    return "tmsdk.QQPIM.DeviceInfo";
  }
  
  public String getAndroidid()
  {
    return this.androidid;
  }
  
  public String getIccid()
  {
    return this.iccid;
  }
  
  public String getImei()
  {
    return this.imei;
  }
  
  public String getImsi()
  {
    return this.imsi;
  }
  
  public String getLguid()
  {
    return this.lguid;
  }
  
  public String getMac()
  {
    return this.mac;
  }
  
  public String getModel()
  {
    return this.model;
  }
  
  public String getNetfile()
  {
    return this.netfile;
  }
  
  public String getProduct()
  {
    return this.product;
  }
  
  public int getSdkversion()
  {
    return this.sdkversion;
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
    setImsi(paramJceInputStream.readString(1, false));
    setMac(paramJceInputStream.readString(2, false));
    setIccid(paramJceInputStream.readString(3, false));
    setAndroidid(paramJceInputStream.readString(4, false));
    setSdkversion(paramJceInputStream.read(this.sdkversion, 5, false));
    setModel(paramJceInputStream.readString(6, false));
    setProduct(paramJceInputStream.readString(7, false));
    setNetfile(paramJceInputStream.readString(8, false));
    setLguid(paramJceInputStream.readString(9, false));
  }
  
  public void setAndroidid(String paramString)
  {
    this.androidid = paramString;
  }
  
  public void setIccid(String paramString)
  {
    this.iccid = paramString;
  }
  
  public void setImei(String paramString)
  {
    this.imei = paramString;
  }
  
  public void setImsi(String paramString)
  {
    this.imsi = paramString;
  }
  
  public void setLguid(String paramString)
  {
    this.lguid = paramString;
  }
  
  public void setMac(String paramString)
  {
    this.mac = paramString;
  }
  
  public void setModel(String paramString)
  {
    this.model = paramString;
  }
  
  public void setNetfile(String paramString)
  {
    this.netfile = paramString;
  }
  
  public void setProduct(String paramString)
  {
    this.product = paramString;
  }
  
  public void setSdkversion(int paramInt)
  {
    this.sdkversion = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.imei, 0);
    String str = this.imsi;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.mac;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.iccid;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.androidid;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    paramJceOutputStream.write(this.sdkversion, 5);
    str = this.model;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.product;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    str = this.netfile;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    str = this.lguid;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */