package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class UserActionTime
  extends JceStruct
  implements Cloneable
{
  public int time = 0;
  public int userAction = 0;
  
  static
  {
    if (!UserActionTime.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UserActionTime()
  {
    setUserAction(this.userAction);
    setTime(this.time);
  }
  
  public UserActionTime(int paramInt1, int paramInt2)
  {
    setUserAction(paramInt1);
    setTime(paramInt2);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.UserActionTime";
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
      paramObject = (UserActionTime)paramObject;
    } while ((!JceUtil.equals(this.userAction, paramObject.userAction)) || (!JceUtil.equals(this.time, paramObject.time)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.UserActionTime";
  }
  
  public int getTime()
  {
    return this.time;
  }
  
  public int getUserAction()
  {
    return this.userAction;
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
    setUserAction(paramJceInputStream.read(this.userAction, 0, true));
    setTime(paramJceInputStream.read(this.time, 1, true));
  }
  
  public void setTime(int paramInt)
  {
    this.time = paramInt;
  }
  
  public void setUserAction(int paramInt)
  {
    this.userAction = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.userAction, 0);
    paramJceOutputStream.write(this.time, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.UserActionTime
 * JD-Core Version:    0.7.0.1
 */