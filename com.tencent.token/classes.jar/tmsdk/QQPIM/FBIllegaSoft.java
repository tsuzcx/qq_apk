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
  
  static
  {
    if (!FBIllegaSoft.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
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
      paramObject = (FBIllegaSoft)paramObject;
    } while ((!JceUtil.equals(this.softkey, paramObject.softkey)) || (!JceUtil.equals(this.company, paramObject.company)) || (!JceUtil.equals(this.illreason, paramObject.illreason)) || (!JceUtil.equals(this.reporttype, paramObject.reporttype)));
    return true;
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