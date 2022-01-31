package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class STQuery
  extends JceStruct
  implements Cloneable
{
  static stAdditionInfo eN;
  public stAdditionInfo additionalInfo = null;
  public String nArea = "";
  public String nOperator = "";
  public int nQuerytype = 0;
  public int nSys = 0;
  public String nType = "";
  public String strHardinfo = "";
  
  static
  {
    if (!STQuery.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public STQuery() {}
  
  public STQuery(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, stAdditionInfo paramstAdditionInfo)
  {
    this.nArea = paramString1;
    this.nOperator = paramString2;
    this.nType = paramString3;
    this.nQuerytype = paramInt1;
    this.strHardinfo = paramString4;
    this.nSys = paramInt2;
    this.additionalInfo = paramstAdditionInfo;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.STQuery";
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
      paramObject = (STQuery)paramObject;
    } while ((!JceUtil.equals(this.nArea, paramObject.nArea)) || (!JceUtil.equals(this.nOperator, paramObject.nOperator)) || (!JceUtil.equals(this.nType, paramObject.nType)) || (!JceUtil.equals(this.nQuerytype, paramObject.nQuerytype)) || (!JceUtil.equals(this.strHardinfo, paramObject.strHardinfo)) || (!JceUtil.equals(this.nSys, paramObject.nSys)) || (!JceUtil.equals(this.additionalInfo, paramObject.additionalInfo)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.STQuery";
  }
  
  public stAdditionInfo getAdditionalInfo()
  {
    return this.additionalInfo;
  }
  
  public String getNArea()
  {
    return this.nArea;
  }
  
  public String getNOperator()
  {
    return this.nOperator;
  }
  
  public int getNQuerytype()
  {
    return this.nQuerytype;
  }
  
  public int getNSys()
  {
    return this.nSys;
  }
  
  public String getNType()
  {
    return this.nType;
  }
  
  public String getStrHardinfo()
  {
    return this.strHardinfo;
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
    this.nArea = paramJceInputStream.readString(0, true);
    this.nOperator = paramJceInputStream.readString(1, true);
    this.nType = paramJceInputStream.readString(2, true);
    this.nQuerytype = paramJceInputStream.read(this.nQuerytype, 3, true);
    this.strHardinfo = paramJceInputStream.readString(4, false);
    this.nSys = paramJceInputStream.read(this.nSys, 5, false);
    if (eN == null) {
      eN = new stAdditionInfo();
    }
    this.additionalInfo = ((stAdditionInfo)paramJceInputStream.read(eN, 6, false));
  }
  
  public void setAdditionalInfo(stAdditionInfo paramstAdditionInfo)
  {
    this.additionalInfo = paramstAdditionInfo;
  }
  
  public void setNArea(String paramString)
  {
    this.nArea = paramString;
  }
  
  public void setNOperator(String paramString)
  {
    this.nOperator = paramString;
  }
  
  public void setNQuerytype(int paramInt)
  {
    this.nQuerytype = paramInt;
  }
  
  public void setNSys(int paramInt)
  {
    this.nSys = paramInt;
  }
  
  public void setNType(String paramString)
  {
    this.nType = paramString;
  }
  
  public void setStrHardinfo(String paramString)
  {
    this.strHardinfo = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nArea, 0);
    paramJceOutputStream.write(this.nOperator, 1);
    paramJceOutputStream.write(this.nType, 2);
    paramJceOutputStream.write(this.nQuerytype, 3);
    if (this.strHardinfo != null) {
      paramJceOutputStream.write(this.strHardinfo, 4);
    }
    paramJceOutputStream.write(this.nSys, 5);
    if (this.additionalInfo != null) {
      paramJceOutputStream.write(this.additionalInfo, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.STQuery
 * JD-Core Version:    0.7.0.1
 */