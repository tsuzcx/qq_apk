package tmsdk.QQPIM;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class SUIKey
  extends JceStruct
  implements Cloneable
{
  public String channelid = "";
  public String guid = "";
  public String imei = "";
  public String imsi = "";
  public String ip = "";
  public int isbuildin = 0;
  public short lang = 0;
  public String lc = "";
  public String machineconf = "";
  public String machineuid = "";
  public String name = "";
  public String newguid = "";
  public String osversion = "";
  public String phone = "";
  public String qq = "";
  public String sdk = "";
  public String sid = "";
  public int subplatform = 0;
  public int type = EPhoneType.MPT_NONE.value();
  public String uuid = "";
  public String version = "";
  
  public SUIKey()
  {
    setLc(this.lc);
    setName(this.name);
    setVersion(this.version);
    setImei(this.imei);
    setImsi(this.imsi);
    setQq(this.qq);
    setIp(this.ip);
    setType(this.type);
    setOsversion(this.osversion);
    setMachineuid(this.machineuid);
    setMachineconf(this.machineconf);
    setPhone(this.phone);
    setSubplatform(this.subplatform);
    setChannelid(this.channelid);
    setIsbuildin(this.isbuildin);
    setUuid(this.uuid);
    setLang(this.lang);
    setGuid(this.guid);
    setSdk(this.sdk);
    setSid(this.sid);
    setNewguid(this.newguid);
  }
  
  public SUIKey(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, String paramString8, String paramString9, String paramString10, String paramString11, int paramInt2, String paramString12, int paramInt3, String paramString13, short paramShort, String paramString14, String paramString15, String paramString16, String paramString17)
  {
    setLc(paramString1);
    setName(paramString2);
    setVersion(paramString3);
    setImei(paramString4);
    setImsi(paramString5);
    setQq(paramString6);
    setIp(paramString7);
    setType(paramInt1);
    setOsversion(paramString8);
    setMachineuid(paramString9);
    setMachineconf(paramString10);
    setPhone(paramString11);
    setSubplatform(paramInt2);
    setChannelid(paramString12);
    setIsbuildin(paramInt3);
    setUuid(paramString13);
    setLang(paramShort);
    setGuid(paramString14);
    setSdk(paramString15);
    setSid(paramString16);
    setNewguid(paramString17);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.SUIKey";
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
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.lc, "lc");
    paramStringBuilder.display(this.name, "name");
    paramStringBuilder.display(this.version, "version");
    paramStringBuilder.display(this.imei, "imei");
    paramStringBuilder.display(this.imsi, "imsi");
    paramStringBuilder.display(this.qq, "com/qq");
    paramStringBuilder.display(this.ip, "ip");
    paramStringBuilder.display(this.type, "type");
    paramStringBuilder.display(this.osversion, "osversion");
    paramStringBuilder.display(this.machineuid, "machineuid");
    paramStringBuilder.display(this.machineconf, "machineconf");
    paramStringBuilder.display(this.phone, "phone");
    paramStringBuilder.display(this.subplatform, "subplatform");
    paramStringBuilder.display(this.channelid, "channelid");
    paramStringBuilder.display(this.isbuildin, "isbuildin");
    paramStringBuilder.display(this.uuid, "uuid");
    paramStringBuilder.display(this.lang, "lang");
    paramStringBuilder.display(this.guid, "guid");
    paramStringBuilder.display(this.sdk, "sdk");
    paramStringBuilder.display(this.sid, "sid");
    paramStringBuilder.display(this.newguid, "newguid");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (SUIKey)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.lc, paramObject.lc))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.name, paramObject.name))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.version, paramObject.version))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.imei, paramObject.imei))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.imsi, paramObject.imsi))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.qq, paramObject.qq))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.ip, paramObject.ip))
                {
                  bool1 = bool2;
                  if (JceUtil.equals(this.type, paramObject.type))
                  {
                    bool1 = bool2;
                    if (JceUtil.equals(this.osversion, paramObject.osversion))
                    {
                      bool1 = bool2;
                      if (JceUtil.equals(this.machineuid, paramObject.machineuid))
                      {
                        bool1 = bool2;
                        if (JceUtil.equals(this.machineconf, paramObject.machineconf))
                        {
                          bool1 = bool2;
                          if (JceUtil.equals(this.phone, paramObject.phone))
                          {
                            bool1 = bool2;
                            if (JceUtil.equals(this.subplatform, paramObject.subplatform))
                            {
                              bool1 = bool2;
                              if (JceUtil.equals(this.channelid, paramObject.channelid))
                              {
                                bool1 = bool2;
                                if (JceUtil.equals(this.isbuildin, paramObject.isbuildin))
                                {
                                  bool1 = bool2;
                                  if (JceUtil.equals(this.uuid, paramObject.uuid))
                                  {
                                    bool1 = bool2;
                                    if (JceUtil.equals(this.lang, paramObject.lang))
                                    {
                                      bool1 = bool2;
                                      if (JceUtil.equals(this.guid, paramObject.guid))
                                      {
                                        bool1 = bool2;
                                        if (JceUtil.equals(this.sdk, paramObject.sdk))
                                        {
                                          bool1 = bool2;
                                          if (JceUtil.equals(this.sid, paramObject.sid))
                                          {
                                            bool1 = bool2;
                                            if (JceUtil.equals(this.newguid, paramObject.newguid)) {
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
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.SUIKey";
  }
  
  public String getChannelid()
  {
    return this.channelid;
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
  
  public short getLang()
  {
    return this.lang;
  }
  
  public String getLc()
  {
    return this.lc;
  }
  
  public String getMachineconf()
  {
    return this.machineconf;
  }
  
  public String getMachineuid()
  {
    return this.machineuid;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getNewguid()
  {
    return this.newguid;
  }
  
  public String getOsversion()
  {
    return this.osversion;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public String getQq()
  {
    return this.qq;
  }
  
  public String getSdk()
  {
    return this.sdk;
  }
  
  public String getSid()
  {
    return this.sid;
  }
  
  public int getSubplatform()
  {
    return this.subplatform;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getUuid()
  {
    return this.uuid;
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
    setLc(paramJceInputStream.readString(0, true));
    setName(paramJceInputStream.readString(1, true));
    setVersion(paramJceInputStream.readString(2, true));
    setImei(paramJceInputStream.readString(3, true));
    setImsi(paramJceInputStream.readString(4, true));
    setQq(paramJceInputStream.readString(5, false));
    setIp(paramJceInputStream.readString(6, false));
    setType(paramJceInputStream.read(this.type, 7, false));
    setOsversion(paramJceInputStream.readString(8, false));
    setMachineuid(paramJceInputStream.readString(9, false));
    setMachineconf(paramJceInputStream.readString(10, false));
    setPhone(paramJceInputStream.readString(11, false));
    setSubplatform(paramJceInputStream.read(this.subplatform, 12, false));
    setChannelid(paramJceInputStream.readString(13, false));
    setIsbuildin(paramJceInputStream.read(this.isbuildin, 14, false));
    setUuid(paramJceInputStream.readString(15, false));
    setLang(paramJceInputStream.read(this.lang, 16, false));
    setGuid(paramJceInputStream.readString(17, false));
    setSdk(paramJceInputStream.readString(18, false));
    setSid(paramJceInputStream.readString(19, false));
    setNewguid(paramJceInputStream.readString(20, false));
  }
  
  public void setChannelid(String paramString)
  {
    this.channelid = paramString;
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
  
  public void setLang(short paramShort)
  {
    this.lang = paramShort;
  }
  
  public void setLc(String paramString)
  {
    this.lc = paramString;
  }
  
  public void setMachineconf(String paramString)
  {
    this.machineconf = paramString;
  }
  
  public void setMachineuid(String paramString)
  {
    this.machineuid = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setNewguid(String paramString)
  {
    this.newguid = paramString;
  }
  
  public void setOsversion(String paramString)
  {
    this.osversion = paramString;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setQq(String paramString)
  {
    this.qq = paramString;
  }
  
  public void setSdk(String paramString)
  {
    this.sdk = paramString;
  }
  
  public void setSid(String paramString)
  {
    this.sid = paramString;
  }
  
  public void setSubplatform(int paramInt)
  {
    this.subplatform = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lc, 0);
    paramJceOutputStream.write(this.name, 1);
    paramJceOutputStream.write(this.version, 2);
    paramJceOutputStream.write(this.imei, 3);
    paramJceOutputStream.write(this.imsi, 4);
    String str = this.qq;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.ip;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    paramJceOutputStream.write(this.type, 7);
    str = this.osversion;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    str = this.machineuid;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
    str = this.machineconf;
    if (str != null) {
      paramJceOutputStream.write(str, 10);
    }
    str = this.phone;
    if (str != null) {
      paramJceOutputStream.write(str, 11);
    }
    paramJceOutputStream.write(this.subplatform, 12);
    str = this.channelid;
    if (str != null) {
      paramJceOutputStream.write(str, 13);
    }
    paramJceOutputStream.write(this.isbuildin, 14);
    str = this.uuid;
    if (str != null) {
      paramJceOutputStream.write(str, 15);
    }
    paramJceOutputStream.write(this.lang, 16);
    str = this.guid;
    if (str != null) {
      paramJceOutputStream.write(str, 17);
    }
    str = this.sdk;
    if (str != null) {
      paramJceOutputStream.write(str, 18);
    }
    str = this.sid;
    if (str != null) {
      paramJceOutputStream.write(str, 19);
    }
    str = this.newguid;
    if (str != null) {
      paramJceOutputStream.write(str, 20);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SUIKey
 * JD-Core Version:    0.7.0.1
 */