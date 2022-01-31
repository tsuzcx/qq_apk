package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class RuleTypeID
  extends JceStruct
  implements Cloneable
{
  public int ucRuleType = 0;
  public int uiRuleID = 0;
  
  static
  {
    if (!RuleTypeID.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RuleTypeID()
  {
    setUcRuleType(this.ucRuleType);
    setUiRuleID(this.uiRuleID);
  }
  
  public RuleTypeID(int paramInt1, int paramInt2)
  {
    setUcRuleType(paramInt1);
    setUiRuleID(paramInt2);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.RuleTypeID";
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
      paramObject = (RuleTypeID)paramObject;
    } while ((!JceUtil.equals(this.ucRuleType, paramObject.ucRuleType)) || (!JceUtil.equals(this.uiRuleID, paramObject.uiRuleID)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.RuleTypeID";
  }
  
  public int getUcRuleType()
  {
    return this.ucRuleType;
  }
  
  public int getUiRuleID()
  {
    return this.uiRuleID;
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
    setUcRuleType(paramJceInputStream.read(this.ucRuleType, 0, true));
    setUiRuleID(paramJceInputStream.read(this.uiRuleID, 1, true));
  }
  
  public void setUcRuleType(int paramInt)
  {
    this.ucRuleType = paramInt;
  }
  
  public void setUiRuleID(int paramInt)
  {
    this.uiRuleID = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ucRuleType, 0);
    paramJceOutputStream.write(this.uiRuleID, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.RuleTypeID
 * JD-Core Version:    0.7.0.1
 */