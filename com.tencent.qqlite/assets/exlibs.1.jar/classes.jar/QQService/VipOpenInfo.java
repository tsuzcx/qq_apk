package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class VipOpenInfo
  extends JceStruct
  implements Cloneable
{
  public boolean bOpen = false;
  public int iVipFlag = 0;
  public int iVipLevel = -1;
  public int iVipType = -1;
  
  static
  {
    if (!VipOpenInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public VipOpenInfo() {}
  
  public VipOpenInfo(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.bOpen = paramBoolean;
    this.iVipType = paramInt1;
    this.iVipLevel = paramInt2;
    this.iVipFlag = paramInt3;
  }
  
  public String className()
  {
    return "QQService.VipOpenInfo";
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
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.bOpen, "bOpen");
    paramStringBuilder.display(this.iVipType, "iVipType");
    paramStringBuilder.display(this.iVipLevel, "iVipLevel");
    paramStringBuilder.display(this.iVipFlag, "iVipFlag");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.bOpen, true);
    paramStringBuilder.displaySimple(this.iVipType, true);
    paramStringBuilder.displaySimple(this.iVipLevel, true);
    paramStringBuilder.displaySimple(this.iVipFlag, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (VipOpenInfo)paramObject;
    } while ((!JceUtil.equals(this.bOpen, paramObject.bOpen)) || (!JceUtil.equals(this.iVipType, paramObject.iVipType)) || (!JceUtil.equals(this.iVipLevel, paramObject.iVipLevel)) || (!JceUtil.equals(this.iVipFlag, paramObject.iVipFlag)));
    return true;
  }
  
  public String fullClassName()
  {
    return "QQService.VipOpenInfo";
  }
  
  public boolean getBOpen()
  {
    return this.bOpen;
  }
  
  public int getIVipFlag()
  {
    return this.iVipFlag;
  }
  
  public int getIVipLevel()
  {
    return this.iVipLevel;
  }
  
  public int getIVipType()
  {
    return this.iVipType;
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
    this.bOpen = paramJceInputStream.read(this.bOpen, 0, true);
    this.iVipType = paramJceInputStream.read(this.iVipType, 1, true);
    this.iVipLevel = paramJceInputStream.read(this.iVipLevel, 2, true);
    this.iVipFlag = paramJceInputStream.read(this.iVipFlag, 3, false);
  }
  
  public void setBOpen(boolean paramBoolean)
  {
    this.bOpen = paramBoolean;
  }
  
  public void setIVipFlag(int paramInt)
  {
    this.iVipFlag = paramInt;
  }
  
  public void setIVipLevel(int paramInt)
  {
    this.iVipLevel = paramInt;
  }
  
  public void setIVipType(int paramInt)
  {
    this.iVipType = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bOpen, 0);
    paramJceOutputStream.write(this.iVipType, 1);
    paramJceOutputStream.write(this.iVipLevel, 2);
    paramJceOutputStream.write(this.iVipFlag, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.VipOpenInfo
 * JD-Core Version:    0.7.0.1
 */