package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ReqGetOpenId
  extends JceStruct
  implements Cloneable
{
  static BaseInfo cache_baseInfo;
  public BaseInfo baseInfo = null;
  public String sessionKey = "";
  public long uin = 0L;
  
  static
  {
    if (!ReqGetOpenId.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public String className()
  {
    return "VIP.ReqGetOpenId";
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
      paramObject = (ReqGetOpenId)paramObject;
    } while ((!JceUtil.equals(this.baseInfo, paramObject.baseInfo)) || (!JceUtil.equals(this.uin, paramObject.uin)) || (!JceUtil.equals(this.sessionKey, paramObject.sessionKey)));
    return true;
  }
  
  public String fullClassName()
  {
    return "VIP.ReqGetOpenId";
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
    this.uin = paramJceInputStream.read(this.uin, 1, true);
    this.sessionKey = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.baseInfo, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.sessionKey, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     VIP.ReqGetOpenId
 * JD-Core Version:    0.7.0.1
 */