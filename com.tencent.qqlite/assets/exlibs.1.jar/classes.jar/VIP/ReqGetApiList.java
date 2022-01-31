package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ReqGetApiList
  extends JceStruct
  implements Cloneable
{
  static BaseInfo cache_baseInfo;
  public BaseInfo baseInfo = null;
  public String domain = "";
  
  static
  {
    if (!ReqGetApiList.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public String className()
  {
    return "VIP.ReqGetApiList";
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
      paramObject = (ReqGetApiList)paramObject;
    } while ((!JceUtil.equals(this.baseInfo, paramObject.baseInfo)) || (!JceUtil.equals(this.domain, paramObject.domain)));
    return true;
  }
  
  public String fullClassName()
  {
    return "VIP.ReqGetApiList";
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
    if (cache_baseInfo == null) {
      cache_baseInfo = new BaseInfo();
    }
    this.baseInfo = ((BaseInfo)paramJceInputStream.read(cache_baseInfo, 0, true));
    this.domain = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.baseInfo, 0);
    paramJceOutputStream.write(this.domain, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     VIP.ReqGetApiList
 * JD-Core Version:    0.7.0.1
 */