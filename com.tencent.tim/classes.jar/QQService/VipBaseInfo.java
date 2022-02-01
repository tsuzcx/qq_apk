package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

public final class VipBaseInfo
  extends JceStruct
  implements Cloneable
{
  static Map<Integer, VipOpenInfo> cache_mOpenInfo;
  public int iGrayNameplateFlag;
  public int iNameplateVipType;
  public Map<Integer, VipOpenInfo> mOpenInfo;
  
  static
  {
    if (!VipBaseInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      cache_mOpenInfo = new HashMap();
      VipOpenInfo localVipOpenInfo = new VipOpenInfo();
      cache_mOpenInfo.put(Integer.valueOf(0), localVipOpenInfo);
      return;
    }
  }
  
  public VipBaseInfo() {}
  
  public VipBaseInfo(Map<Integer, VipOpenInfo> paramMap, int paramInt1, int paramInt2)
  {
    this.mOpenInfo = paramMap;
    this.iNameplateVipType = paramInt1;
    this.iGrayNameplateFlag = paramInt2;
  }
  
  public String className()
  {
    return "QQService.VipBaseInfo";
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
    paramStringBuilder.display(this.mOpenInfo, "mOpenInfo");
    paramStringBuilder.display(this.iNameplateVipType, "iNameplateVipType");
    paramStringBuilder.display(this.iGrayNameplateFlag, "iGrayNameplateFlag");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.mOpenInfo, true);
    paramStringBuilder.displaySimple(this.iNameplateVipType, true);
    paramStringBuilder.displaySimple(this.iGrayNameplateFlag, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (VipBaseInfo)paramObject;
    } while ((!JceUtil.equals(this.mOpenInfo, paramObject.mOpenInfo)) || (!JceUtil.equals(this.iNameplateVipType, paramObject.iNameplateVipType)) || (!JceUtil.equals(this.iGrayNameplateFlag, paramObject.iGrayNameplateFlag)));
    return true;
  }
  
  public String fullClassName()
  {
    return "QQService.VipBaseInfo";
  }
  
  public int getIGrayNameplateFlag()
  {
    return this.iGrayNameplateFlag;
  }
  
  public int getINameplateVipType()
  {
    return this.iNameplateVipType;
  }
  
  public Map<Integer, VipOpenInfo> getMOpenInfo()
  {
    return this.mOpenInfo;
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
    this.mOpenInfo = ((Map)paramJceInputStream.read(cache_mOpenInfo, 0, true));
    this.iNameplateVipType = paramJceInputStream.read(this.iNameplateVipType, 1, false);
    this.iGrayNameplateFlag = paramJceInputStream.read(this.iGrayNameplateFlag, 2, false);
  }
  
  public void setIGrayNameplateFlag(int paramInt)
  {
    this.iGrayNameplateFlag = paramInt;
  }
  
  public void setINameplateVipType(int paramInt)
  {
    this.iNameplateVipType = paramInt;
  }
  
  public void setMOpenInfo(Map<Integer, VipOpenInfo> paramMap)
  {
    this.mOpenInfo = paramMap;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mOpenInfo, 0);
    paramJceOutputStream.write(this.iNameplateVipType, 1);
    paramJceOutputStream.write(this.iGrayNameplateFlag, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.VipBaseInfo
 * JD-Core Version:    0.7.0.1
 */