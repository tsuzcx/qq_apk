package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ProductVersion
  extends JceStruct
  implements Cloneable
{
  public int cversion = 0;
  public int hotfix = 0;
  public int pversion = 0;
  
  static
  {
    if (!ProductVersion.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ProductVersion()
  {
    setPversion(this.pversion);
    setCversion(this.cversion);
    setHotfix(this.hotfix);
  }
  
  public ProductVersion(int paramInt1, int paramInt2, int paramInt3)
  {
    setPversion(paramInt1);
    setCversion(paramInt2);
    setHotfix(paramInt3);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.ProductVersion";
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
      paramObject = (ProductVersion)paramObject;
    } while ((!JceUtil.equals(this.pversion, paramObject.pversion)) || (!JceUtil.equals(this.cversion, paramObject.cversion)) || (!JceUtil.equals(this.hotfix, paramObject.hotfix)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.ProductVersion";
  }
  
  public int getCversion()
  {
    return this.cversion;
  }
  
  public int getHotfix()
  {
    return this.hotfix;
  }
  
  public int getPversion()
  {
    return this.pversion;
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
    setPversion(paramJceInputStream.read(this.pversion, 1, true));
    setCversion(paramJceInputStream.read(this.cversion, 2, true));
    setHotfix(paramJceInputStream.read(this.hotfix, 3, true));
  }
  
  public void setCversion(int paramInt)
  {
    this.cversion = paramInt;
  }
  
  public void setHotfix(int paramInt)
  {
    this.hotfix = paramInt;
  }
  
  public void setPversion(int paramInt)
  {
    this.pversion = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.pversion, 1);
    paramJceOutputStream.write(this.cversion, 2);
    paramJceOutputStream.write(this.hotfix, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ProductVersion
 * JD-Core Version:    0.7.0.1
 */