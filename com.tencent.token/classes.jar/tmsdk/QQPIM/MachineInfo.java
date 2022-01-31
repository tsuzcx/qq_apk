package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class MachineInfo
  extends JceStruct
  implements Cloneable
{
  static ProductVersion dX;
  static PhoneType eB;
  public int buildno = 0;
  public String channelid = "";
  public int ct = ConnectType.CT_NONE.value();
  public String guid = "";
  public String imei = "";
  public String imsi = "";
  public String ip = "";
  public int isbuildin = 0;
  public int isroot = 0;
  public short lang = 0;
  public String lc = "";
  public String machine = "";
  public PhoneType phonetype = null;
  public int product = 0;
  public int sdkversion = 0;
  public int sp = 0;
  public String uuid = "";
  public ProductVersion version = null;
  
  static
  {
    if (!MachineInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public MachineInfo()
  {
    setLc(this.lc);
    setImei(this.imei);
    setSp(this.sp);
    setProduct(this.product);
    setChannelid(this.channelid);
    setIp(this.ip);
    setPhonetype(this.phonetype);
    setMachine(this.machine);
    setImsi(this.imsi);
    setIsbuildin(this.isbuildin);
    setIsroot(this.isroot);
    setCt(this.ct);
    setVersion(this.version);
    setGuid(this.guid);
    setSdkversion(this.sdkversion);
    setBuildno(this.buildno);
    setUuid(this.uuid);
    setLang(this.lang);
  }
  
  public MachineInfo(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, PhoneType paramPhoneType, String paramString5, String paramString6, int paramInt3, int paramInt4, int paramInt5, ProductVersion paramProductVersion, String paramString7, int paramInt6, int paramInt7, String paramString8, short paramShort)
  {
    setLc(paramString1);
    setImei(paramString2);
    setSp(paramInt1);
    setProduct(paramInt2);
    setChannelid(paramString3);
    setIp(paramString4);
    setPhonetype(paramPhoneType);
    setMachine(paramString5);
    setImsi(paramString6);
    setIsbuildin(paramInt3);
    setIsroot(paramInt4);
    setCt(paramInt5);
    setVersion(paramProductVersion);
    setGuid(paramString7);
    setSdkversion(paramInt6);
    setBuildno(paramInt7);
    setUuid(paramString8);
    setLang(paramShort);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.MachineInfo";
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
      paramObject = (MachineInfo)paramObject;
    } while ((!JceUtil.equals(this.lc, paramObject.lc)) || (!JceUtil.equals(this.imei, paramObject.imei)) || (!JceUtil.equals(this.sp, paramObject.sp)) || (!JceUtil.equals(this.product, paramObject.product)) || (!JceUtil.equals(this.channelid, paramObject.channelid)) || (!JceUtil.equals(this.ip, paramObject.ip)) || (!JceUtil.equals(this.phonetype, paramObject.phonetype)) || (!JceUtil.equals(this.machine, paramObject.machine)) || (!JceUtil.equals(this.imsi, paramObject.imsi)) || (!JceUtil.equals(this.isbuildin, paramObject.isbuildin)) || (!JceUtil.equals(this.isroot, paramObject.isroot)) || (!JceUtil.equals(this.ct, paramObject.ct)) || (!JceUtil.equals(this.version, paramObject.version)) || (!JceUtil.equals(this.guid, paramObject.guid)) || (!JceUtil.equals(this.sdkversion, paramObject.sdkversion)) || (!JceUtil.equals(this.buildno, paramObject.buildno)) || (!JceUtil.equals(this.uuid, paramObject.uuid)) || (!JceUtil.equals(this.lang, paramObject.lang)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.MachineInfo";
  }
  
  public int getBuildno()
  {
    return this.buildno;
  }
  
  public String getChannelid()
  {
    return this.channelid;
  }
  
  public int getCt()
  {
    return this.ct;
  }
  
  public String getGuid()
  {
    return this.guid;
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
  
  public int getIsbuildin()
  {
    return this.isbuildin;
  }
  
  public int getIsroot()
  {
    return this.isroot;
  }
  
  public short getLang()
  {
    return this.lang;
  }
  
  public String getLc()
  {
    return this.lc;
  }
  
  public String getMachine()
  {
    return this.machine;
  }
  
  public PhoneType getPhonetype()
  {
    return this.phonetype;
  }
  
  public int getProduct()
  {
    return this.product;
  }
  
  public int getSdkversion()
  {
    return this.sdkversion;
  }
  
  public int getSp()
  {
    return this.sp;
  }
  
  public String getUuid()
  {
    return this.uuid;
  }
  
  public ProductVersion getVersion()
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
    setLc(paramJceInputStream.readString(0, true));
    setImei(paramJceInputStream.readString(1, true));
    setSp(paramJceInputStream.read(this.sp, 2, true));
    setProduct(paramJceInputStream.read(this.product, 3, false));
    setChannelid(paramJceInputStream.readString(4, false));
    setIp(paramJceInputStream.readString(5, false));
    if (eB == null) {
      eB = new PhoneType();
    }
    setPhonetype((PhoneType)paramJceInputStream.read(eB, 6, false));
    setMachine(paramJceInputStream.readString(7, false));
    setImsi(paramJceInputStream.readString(8, false));
    setIsbuildin(paramJceInputStream.read(this.isbuildin, 9, false));
    setIsroot(paramJceInputStream.read(this.isroot, 10, false));
    setCt(paramJceInputStream.read(this.ct, 11, false));
    if (dX == null) {
      dX = new ProductVersion();
    }
    setVersion((ProductVersion)paramJceInputStream.read(dX, 12, false));
    setGuid(paramJceInputStream.readString(13, false));
    setSdkversion(paramJceInputStream.read(this.sdkversion, 14, false));
    setBuildno(paramJceInputStream.read(this.buildno, 15, false));
    setUuid(paramJceInputStream.readString(16, false));
    setLang(paramJceInputStream.read(this.lang, 17, false));
  }
  
  public void setBuildno(int paramInt)
  {
    this.buildno = paramInt;
  }
  
  public void setChannelid(String paramString)
  {
    this.channelid = paramString;
  }
  
  public void setCt(int paramInt)
  {
    this.ct = paramInt;
  }
  
  public void setGuid(String paramString)
  {
    this.guid = paramString;
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
  
  public void setIsbuildin(int paramInt)
  {
    this.isbuildin = paramInt;
  }
  
  public void setIsroot(int paramInt)
  {
    this.isroot = paramInt;
  }
  
  public void setLang(short paramShort)
  {
    this.lang = paramShort;
  }
  
  public void setLc(String paramString)
  {
    this.lc = paramString;
  }
  
  public void setMachine(String paramString)
  {
    this.machine = paramString;
  }
  
  public void setPhonetype(PhoneType paramPhoneType)
  {
    this.phonetype = paramPhoneType;
  }
  
  public void setProduct(int paramInt)
  {
    this.product = paramInt;
  }
  
  public void setSdkversion(int paramInt)
  {
    this.sdkversion = paramInt;
  }
  
  public void setSp(int paramInt)
  {
    this.sp = paramInt;
  }
  
  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }
  
  public void setVersion(ProductVersion paramProductVersion)
  {
    this.version = paramProductVersion;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lc, 0);
    paramJceOutputStream.write(this.imei, 1);
    paramJceOutputStream.write(this.sp, 2);
    paramJceOutputStream.write(this.product, 3);
    if (this.channelid != null) {
      paramJceOutputStream.write(this.channelid, 4);
    }
    if (this.ip != null) {
      paramJceOutputStream.write(this.ip, 5);
    }
    if (this.phonetype != null) {
      paramJceOutputStream.write(this.phonetype, 6);
    }
    if (this.machine != null) {
      paramJceOutputStream.write(this.machine, 7);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 8);
    }
    paramJceOutputStream.write(this.isbuildin, 9);
    paramJceOutputStream.write(this.isroot, 10);
    paramJceOutputStream.write(this.ct, 11);
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 12);
    }
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 13);
    }
    paramJceOutputStream.write(this.sdkversion, 14);
    paramJceOutputStream.write(this.buildno, 15);
    if (this.uuid != null) {
      paramJceOutputStream.write(this.uuid, 16);
    }
    paramJceOutputStream.write(this.lang, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.MachineInfo
 * JD-Core Version:    0.7.0.1
 */