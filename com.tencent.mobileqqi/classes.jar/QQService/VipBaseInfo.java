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
  static Map cache_mOpenInfo;
  public Map mOpenInfo = null;
  
  static
  {
    if (!VipBaseInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public VipBaseInfo() {}
  
  public VipBaseInfo(Map paramMap)
  {
    this.mOpenInfo = paramMap;
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
    new JceDisplayer(paramStringBuilder, paramInt).display(this.mOpenInfo, "mOpenInfo");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    new JceDisplayer(paramStringBuilder, paramInt).displaySimple(this.mOpenInfo, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (VipBaseInfo)paramObject;
    return JceUtil.equals(this.mOpenInfo, paramObject.mOpenInfo);
  }
  
  public String fullClassName()
  {
    return "QQService.VipBaseInfo";
  }
  
  public Map getMOpenInfo()
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
    if (cache_mOpenInfo == null)
    {
      cache_mOpenInfo = new HashMap();
      VipOpenInfo localVipOpenInfo = new VipOpenInfo();
      cache_mOpenInfo.put(Integer.valueOf(0), localVipOpenInfo);
    }
    this.mOpenInfo = ((Map)paramJceInputStream.read(cache_mOpenInfo, 0, true));
  }
  
  public void setMOpenInfo(Map paramMap)
  {
    this.mOpenInfo = paramMap;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mOpenInfo, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.VipBaseInfo
 * JD-Core Version:    0.7.0.1
 */