package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class STSmsInfo
  extends JceStruct
  implements Cloneable
{
  static stAdditionInfo eN;
  static stStateInfo eP;
  public stAdditionInfo additionalInfo = null;
  public boolean bAuto = true;
  public int nCollocateNum = 0;
  public int nSys = 0;
  public int nrework = 0;
  public int ntime = 0;
  public int ntrafficnum = 0;
  public String sender = "";
  public String sms = "";
  public stStateInfo stateinfo = null;
  public String strHardInfo = "";
  public String strarea = "";
  public String strqueryorder = "";
  public String strsimtype = "";
  public String strversion = "";
  
  public STSmsInfo() {}
  
  public STSmsInfo(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, String paramString6, int paramInt4, boolean paramBoolean, String paramString7, stStateInfo paramstStateInfo, int paramInt5, stAdditionInfo paramstAdditionInfo)
  {
    this.ntime = paramInt1;
    this.sender = paramString1;
    this.sms = paramString2;
    this.strarea = paramString3;
    this.strsimtype = paramString4;
    this.strqueryorder = paramString5;
    this.nrework = paramInt2;
    this.ntrafficnum = paramInt3;
    this.strHardInfo = paramString6;
    this.nCollocateNum = paramInt4;
    this.bAuto = paramBoolean;
    this.strversion = paramString7;
    this.stateinfo = paramstStateInfo;
    this.nSys = paramInt5;
    this.additionalInfo = paramstAdditionInfo;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.STSmsInfo";
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
    paramObject = (STSmsInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.ntime, paramObject.ntime))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.sender, paramObject.sender))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.sms, paramObject.sms))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.strarea, paramObject.strarea))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.strsimtype, paramObject.strsimtype))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.strqueryorder, paramObject.strqueryorder))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.nrework, paramObject.nrework))
                {
                  bool1 = bool2;
                  if (JceUtil.equals(this.ntrafficnum, paramObject.ntrafficnum))
                  {
                    bool1 = bool2;
                    if (JceUtil.equals(this.strHardInfo, paramObject.strHardInfo))
                    {
                      bool1 = bool2;
                      if (JceUtil.equals(this.nCollocateNum, paramObject.nCollocateNum))
                      {
                        bool1 = bool2;
                        if (JceUtil.equals(this.bAuto, paramObject.bAuto))
                        {
                          bool1 = bool2;
                          if (JceUtil.equals(this.strversion, paramObject.strversion))
                          {
                            bool1 = bool2;
                            if (JceUtil.equals(this.stateinfo, paramObject.stateinfo))
                            {
                              bool1 = bool2;
                              if (JceUtil.equals(this.nSys, paramObject.nSys))
                              {
                                bool1 = bool2;
                                if (JceUtil.equals(this.additionalInfo, paramObject.additionalInfo)) {
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
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.STSmsInfo";
  }
  
  public stAdditionInfo getAdditionalInfo()
  {
    return this.additionalInfo;
  }
  
  public boolean getBAuto()
  {
    return this.bAuto;
  }
  
  public int getNCollocateNum()
  {
    return this.nCollocateNum;
  }
  
  public int getNSys()
  {
    return this.nSys;
  }
  
  public int getNrework()
  {
    return this.nrework;
  }
  
  public int getNtime()
  {
    return this.ntime;
  }
  
  public int getNtrafficnum()
  {
    return this.ntrafficnum;
  }
  
  public String getSender()
  {
    return this.sender;
  }
  
  public String getSms()
  {
    return this.sms;
  }
  
  public stStateInfo getStateinfo()
  {
    return this.stateinfo;
  }
  
  public String getStrHardInfo()
  {
    return this.strHardInfo;
  }
  
  public String getStrarea()
  {
    return this.strarea;
  }
  
  public String getStrqueryorder()
  {
    return this.strqueryorder;
  }
  
  public String getStrsimtype()
  {
    return this.strsimtype;
  }
  
  public String getStrversion()
  {
    return this.strversion;
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
    this.ntime = paramJceInputStream.read(this.ntime, 0, true);
    this.sender = paramJceInputStream.readString(1, true);
    this.sms = paramJceInputStream.readString(2, true);
    this.strarea = paramJceInputStream.readString(3, false);
    this.strsimtype = paramJceInputStream.readString(4, false);
    this.strqueryorder = paramJceInputStream.readString(5, false);
    this.nrework = paramJceInputStream.read(this.nrework, 6, false);
    this.ntrafficnum = paramJceInputStream.read(this.ntrafficnum, 7, false);
    this.strHardInfo = paramJceInputStream.readString(8, false);
    this.nCollocateNum = paramJceInputStream.read(this.nCollocateNum, 9, false);
    this.bAuto = paramJceInputStream.read(this.bAuto, 10, false);
    this.strversion = paramJceInputStream.readString(11, false);
    if (eP == null) {
      eP = new stStateInfo();
    }
    this.stateinfo = ((stStateInfo)paramJceInputStream.read(eP, 12, false));
    this.nSys = paramJceInputStream.read(this.nSys, 13, false);
    if (eN == null) {
      eN = new stAdditionInfo();
    }
    this.additionalInfo = ((stAdditionInfo)paramJceInputStream.read(eN, 14, false));
  }
  
  public void setAdditionalInfo(stAdditionInfo paramstAdditionInfo)
  {
    this.additionalInfo = paramstAdditionInfo;
  }
  
  public void setBAuto(boolean paramBoolean)
  {
    this.bAuto = paramBoolean;
  }
  
  public void setNCollocateNum(int paramInt)
  {
    this.nCollocateNum = paramInt;
  }
  
  public void setNSys(int paramInt)
  {
    this.nSys = paramInt;
  }
  
  public void setNrework(int paramInt)
  {
    this.nrework = paramInt;
  }
  
  public void setNtime(int paramInt)
  {
    this.ntime = paramInt;
  }
  
  public void setNtrafficnum(int paramInt)
  {
    this.ntrafficnum = paramInt;
  }
  
  public void setSender(String paramString)
  {
    this.sender = paramString;
  }
  
  public void setSms(String paramString)
  {
    this.sms = paramString;
  }
  
  public void setStateinfo(stStateInfo paramstStateInfo)
  {
    this.stateinfo = paramstStateInfo;
  }
  
  public void setStrHardInfo(String paramString)
  {
    this.strHardInfo = paramString;
  }
  
  public void setStrarea(String paramString)
  {
    this.strarea = paramString;
  }
  
  public void setStrqueryorder(String paramString)
  {
    this.strqueryorder = paramString;
  }
  
  public void setStrsimtype(String paramString)
  {
    this.strsimtype = paramString;
  }
  
  public void setStrversion(String paramString)
  {
    this.strversion = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ntime, 0);
    paramJceOutputStream.write(this.sender, 1);
    paramJceOutputStream.write(this.sms, 2);
    Object localObject = this.strarea;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.strsimtype;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.strqueryorder;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    paramJceOutputStream.write(this.nrework, 6);
    paramJceOutputStream.write(this.ntrafficnum, 7);
    localObject = this.strHardInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    paramJceOutputStream.write(this.nCollocateNum, 9);
    paramJceOutputStream.write(this.bAuto, 10);
    localObject = this.strversion;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    localObject = this.stateinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 12);
    }
    paramJceOutputStream.write(this.nSys, 13);
    localObject = this.additionalInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.STSmsInfo
 * JD-Core Version:    0.7.0.1
 */