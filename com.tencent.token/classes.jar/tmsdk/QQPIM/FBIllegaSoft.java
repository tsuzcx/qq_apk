package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class FBIllegaSoft
  extends JceStruct
  implements Cloneable
{
  static SoftKey dw;
  public String company = "";
  public int illreason = 0;
  public int reporttype = FBIReportType.FBI_REPORT.value();
  public SoftKey softkey = null;
  
  public FBIllegaSoft()
  {
    setSoftkey(this.softkey);
    setCompany(this.company);
    setIllreason(this.illreason);
    setReporttype(this.reporttype);
  }
  
  public FBIllegaSoft(SoftKey paramSoftKey, String paramString, int paramInt1, int paramInt2)
  {
    setSoftkey(paramSoftKey);
    setCompany(paramString);
    setIllreason(paramInt1);
    setReporttype(paramInt2);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.FBIllegaSoft";
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
    paramObject = (FBIllegaSoft)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.softkey, paramObject.softkey))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.company, paramObject.company))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.illreason, paramObject.illreason))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.reporttype, paramObject.reporttype)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.FBIllegaSoft";
  }
  
  public String getCompany()
  {
    return this.company;
  }
  
  public int getIllreason()
  {
    return this.illreason;
  }
  
  public int getReporttype()
  {
    return this.reporttype;
  }
  
  public SoftKey getSoftkey()
  {
    return this.softkey;
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
    if (dw == null) {
      dw = new SoftKey();
    }
    setSoftkey((SoftKey)paramJceInputStream.read(dw, 0, true));
    setCompany(paramJceInputStream.readString(1, true));
    setIllreason(paramJceInputStream.read(this.illreason, 2, true));
    setReporttype(paramJceInputStream.read(this.reporttype, 3, false));
  }
  
  public void setCompany(String paramString)
  {
    this.company = paramString;
  }
  
  public void setIllreason(int paramInt)
  {
    this.illreason = paramInt;
  }
  
  public void setReporttype(int paramInt)
  {
    this.reporttype = paramInt;
  }
  
  public void setSoftkey(SoftKey paramSoftKey)
  {
    this.softkey = paramSoftKey;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.softkey, 0);
    paramJceOutputStream.write(this.company, 1);
    paramJceOutputStream.write(this.illreason, 2);
    paramJceOutputStream.write(this.reporttype, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.FBIllegaSoft
 * JD-Core Version:    0.7.0.1
 */