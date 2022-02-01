package tmsdk.QQPIM;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class SoftListInfo
  extends JceStruct
  implements Cloneable
{
  public String riskDesc = "";
  public int riskLevel = 0;
  
  public SoftListInfo() {}
  
  public SoftListInfo(String paramString, int paramInt)
  {
    this.riskDesc = paramString;
    this.riskLevel = paramInt;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.SoftListInfo";
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
    paramStringBuilder.display(this.riskDesc, "riskDesc");
    paramStringBuilder.display(this.riskLevel, "riskLevel");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (SoftListInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.riskDesc, paramObject.riskDesc))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.riskLevel, paramObject.riskLevel)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.SoftListInfo";
  }
  
  public String getRiskDesc()
  {
    return this.riskDesc;
  }
  
  public int getRiskLevel()
  {
    return this.riskLevel;
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
    this.riskDesc = paramJceInputStream.readString(0, false);
    this.riskLevel = paramJceInputStream.read(this.riskLevel, 1, false);
  }
  
  public void setRiskDesc(String paramString)
  {
    this.riskDesc = paramString;
  }
  
  public void setRiskLevel(int paramInt)
  {
    this.riskLevel = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.riskDesc;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.riskLevel, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SoftListInfo
 * JD-Core Version:    0.7.0.1
 */