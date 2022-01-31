package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class AndroidCategoryExpand
  extends JceStruct
  implements Cloneable
{
  public int agree = 0;
  public int createtime = 0;
  public int disagree = 0;
  public int ispush = ECategoryPushType.CPUSH_NONE.value();
  public int updatetime = 0;
  
  static
  {
    if (!AndroidCategoryExpand.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public AndroidCategoryExpand()
  {
    setCreatetime(this.createtime);
    setAgree(this.agree);
    setDisagree(this.disagree);
    setIspush(this.ispush);
    setUpdatetime(this.updatetime);
  }
  
  public AndroidCategoryExpand(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    setCreatetime(paramInt1);
    setAgree(paramInt2);
    setDisagree(paramInt3);
    setIspush(paramInt4);
    setUpdatetime(paramInt5);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.AndroidCategoryExpand";
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
      paramObject = (AndroidCategoryExpand)paramObject;
    } while ((!JceUtil.equals(this.createtime, paramObject.createtime)) || (!JceUtil.equals(this.agree, paramObject.agree)) || (!JceUtil.equals(this.disagree, paramObject.disagree)) || (!JceUtil.equals(this.ispush, paramObject.ispush)) || (!JceUtil.equals(this.updatetime, paramObject.updatetime)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.AndroidCategoryExpand";
  }
  
  public int getAgree()
  {
    return this.agree;
  }
  
  public int getCreatetime()
  {
    return this.createtime;
  }
  
  public int getDisagree()
  {
    return this.disagree;
  }
  
  public int getIspush()
  {
    return this.ispush;
  }
  
  public int getUpdatetime()
  {
    return this.updatetime;
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
    setCreatetime(paramJceInputStream.read(this.createtime, 0, false));
    setAgree(paramJceInputStream.read(this.agree, 1, false));
    setDisagree(paramJceInputStream.read(this.disagree, 2, false));
    setIspush(paramJceInputStream.read(this.ispush, 3, false));
    setUpdatetime(paramJceInputStream.read(this.updatetime, 4, false));
  }
  
  public void setAgree(int paramInt)
  {
    this.agree = paramInt;
  }
  
  public void setCreatetime(int paramInt)
  {
    this.createtime = paramInt;
  }
  
  public void setDisagree(int paramInt)
  {
    this.disagree = paramInt;
  }
  
  public void setIspush(int paramInt)
  {
    this.ispush = paramInt;
  }
  
  public void setUpdatetime(int paramInt)
  {
    this.updatetime = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.createtime, 0);
    paramJceOutputStream.write(this.agree, 1);
    paramJceOutputStream.write(this.disagree, 2);
    paramJceOutputStream.write(this.ispush, 3);
    paramJceOutputStream.write(this.updatetime, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.AndroidCategoryExpand
 * JD-Core Version:    0.7.0.1
 */