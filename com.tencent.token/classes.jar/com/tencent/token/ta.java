package com.tencent.token;

public final class ta
  implements ajm
{
  ajk a = null;
  private tb b = null;
  private int c = 0;
  private sv d = null;
  
  public ta(sv paramsv)
  {
    this.d = paramsv;
    this.b = new tb();
  }
  
  private static String a(sx paramsx)
  {
    if ((paramsx.c != null) && (paramsx.c.length() != 0)) {
      return paramsx.c;
    }
    Object localObject = new StringBuilder("其它错误：");
    ((StringBuilder)localObject).append(paramsx.b);
    localObject = ((StringBuilder)localObject).toString();
    int i = paramsx.b;
    switch (i)
    {
    default: 
      switch (i)
      {
      default: 
        localObject = new StringBuilder("其它错误：");
        ((StringBuilder)localObject).append(paramsx.b);
        xj.b(((StringBuilder)localObject).toString());
        localObject = new StringBuilder("其它错误：");
        ((StringBuilder)localObject).append(paramsx.b);
        return ((StringBuilder)localObject).toString();
      case 101: 
        xj.b("如果客户端收到此错误，测等待一段时间重新尝试请求。");
        return "如果客户端收到此错误，测等待一段时间重新尝试请求。";
      }
      xj.b("预留的错误码，如果客户端收到该错误码则无条件终止，并提示错误");
      return "预留的错误码，如果客户端收到该错误码则无条件终止，并提示错误";
    case 9: 
      xj.b("已经到令牌的最大绑定个数");
      return "已经到令牌的最大绑定个数";
    case 8: 
      xj.b("令牌序列号不存在");
      return "令牌序列号不存在";
    case 7: 
      xj.b("客户端输入错误");
      return "客户端输入错误";
    case 6: 
      xj.b("还没有密保手机");
      return "还没有密保手机";
    case 5: 
      xj.b("密保手机不正确");
      return "密保手机不正确";
    case 4: 
      xj.b("解除绑定时该号码还没有绑定qq");
      return "解除绑定时该号码还没有绑定qq";
    case 3: 
      xj.b("该号码已经绑定令牌");
      return "该号码已经绑定令牌";
    case 2: 
      xj.b("六位验证码验证错误");
      return "六位验证码验证错误";
    case 1: 
      xj.b("短信没有到达");
      return "短信没有到达";
    }
    return localObject;
  }
  
  public final void a()
  {
    this.d.c();
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    int i;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2) && (paramArrayOfByte[0] == 2) && (paramArrayOfByte[(paramArrayOfByte.length - 1)] == 3)) {
      i = sz.a(paramArrayOfByte, 20);
    } else {
      i = -1;
    }
    if (i == -1) {
      return;
    }
    Object localObject = new sx();
    switch (i)
    {
    case 103: 
    case 104: 
    default: 
      return;
    case 106: 
      tb.a((sx)localObject, paramArrayOfByte);
      if (((sx)localObject).b == 0)
      {
        th.a().h();
        this.d.b();
        return;
      }
      this.d.b(((sx)localObject).b, a((sx)localObject));
      return;
    case 105: 
      tb.a((sx)localObject, paramArrayOfByte);
      if (((sx)localObject).b == 0)
      {
        th.a().h();
        this.d.a();
        return;
      }
      this.d.a(((sx)localObject).b, a((sx)localObject));
      return;
    case 102: 
      localObject = new sw();
      tb.a((sx)localObject, paramArrayOfByte);
      ((sw)localObject).a = sz.a(((sw)localObject).f, 0, 32);
      if (((sw)localObject).b == 0)
      {
        this.d.b(((sw)localObject).a);
        return;
      }
      this.d.c(a((sx)localObject));
      return;
    }
    tb.a((sx)localObject, paramArrayOfByte);
    if (((sx)localObject).b == 0)
    {
      paramArrayOfByte = new StringBuilder("服务器时间:");
      paramArrayOfByte.append(((sx)localObject).d);
      xj.b(paramArrayOfByte.toString());
      this.d.a(((sx)localObject).d);
      return;
    }
    this.d.a(a((sx)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ta
 * JD-Core Version:    0.7.0.1
 */