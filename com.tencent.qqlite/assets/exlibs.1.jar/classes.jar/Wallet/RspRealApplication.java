package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class RspRealApplication
  extends JceStruct
  implements Cloneable
{
  static BindBankCard cache_bindBankCard;
  public BindBankCard bindBankCard = null;
  public String msg = "";
  public int ret = 0;
  
  static
  {
    if (!RspRealApplication.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public String className()
  {
    return "Wallet.RspRealApplication";
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
      paramObject = (RspRealApplication)paramObject;
    } while ((!JceUtil.equals(this.ret, paramObject.ret)) || (!JceUtil.equals(this.msg, paramObject.msg)) || (!JceUtil.equals(this.bindBankCard, paramObject.bindBankCard)));
    return true;
  }
  
  public String fullClassName()
  {
    return "Wallet.RspRealApplication";
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
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    if (cache_bindBankCard == null) {
      cache_bindBankCard = new BindBankCard();
    }
    this.bindBankCard = ((BindBankCard)paramJceInputStream.read(cache_bindBankCard, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.bindBankCard != null) {
      paramJceOutputStream.write(this.bindBankCard, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     Wallet.RspRealApplication
 * JD-Core Version:    0.7.0.1
 */