package com.tencent.mobileqq.msf.sdk;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class l
  extends JceStruct
  implements Cloneable
{
  static NotifyRegisterInfo f;
  static CommandCallbackerInfo g;
  public int a = 0;
  public String b = "";
  public String c = "";
  public NotifyRegisterInfo d = null;
  public CommandCallbackerInfo e = null;
  
  static
  {
    if (!l.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      h = bool;
      return;
    }
  }
  
  public l()
  {
    a(this.a);
    a(this.b);
    b(this.c);
    a(this.d);
    a(this.e);
  }
  
  public l(int paramInt, String paramString1, String paramString2, NotifyRegisterInfo paramNotifyRegisterInfo, CommandCallbackerInfo paramCommandCallbackerInfo)
  {
    a(paramInt);
    a(paramString1);
    b(paramString2);
    a(paramNotifyRegisterInfo);
    a(paramCommandCallbackerInfo);
  }
  
  public String a()
  {
    return "clientPushInfo.ProxyRegisterInfo";
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(CommandCallbackerInfo paramCommandCallbackerInfo)
  {
    this.e = paramCommandCallbackerInfo;
  }
  
  public void a(NotifyRegisterInfo paramNotifyRegisterInfo)
  {
    this.d = paramNotifyRegisterInfo;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public String b()
  {
    return "clientPushInfo.ProxyRegisterInfo";
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public int c()
  {
    return this.a;
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
      while (h) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public String d()
  {
    return this.b;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.a, "appid");
    paramStringBuilder.display(this.b, "registerProcessName");
    paramStringBuilder.display(this.c, "registerBootBoradcastName");
    paramStringBuilder.display(this.d, "notifyRegisterInfo");
    paramStringBuilder.display(this.e, "proCmdCallbacker");
  }
  
  public String e()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (l)paramObject;
    } while ((!JceUtil.equals(this.a, paramObject.a)) || (!JceUtil.equals(this.b, paramObject.b)) || (!JceUtil.equals(this.c, paramObject.c)) || (!JceUtil.equals(this.d, paramObject.d)) || (!JceUtil.equals(this.e, paramObject.e)));
    return true;
  }
  
  public NotifyRegisterInfo f()
  {
    return this.d;
  }
  
  public CommandCallbackerInfo g()
  {
    return this.e;
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
    a(paramJceInputStream.read(this.a, 1, true));
    a(paramJceInputStream.readString(2, true));
    b(paramJceInputStream.readString(3, true));
    if (f == null) {
      f = new NotifyRegisterInfo();
    }
    a((NotifyRegisterInfo)paramJceInputStream.read(f, 4, true));
    if (g == null) {
      g = new CommandCallbackerInfo();
    }
    a((CommandCallbackerInfo)paramJceInputStream.read(g, 5, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
    paramJceOutputStream.write(this.d, 4);
    paramJceOutputStream.write(this.e, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.l
 * JD-Core Version:    0.7.0.1
 */