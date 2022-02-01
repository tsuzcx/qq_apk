package com.tencent.token;

public final class st
  implements ahq
{
  aho a = null;
  private su b = null;
  private int c = 0;
  private so d = null;
  
  public st(so paramso)
  {
    this.d = paramso;
    this.b = new su();
  }
  
  private static String a(sq paramsq)
  {
    if ((paramsq.c != null) && (paramsq.c.length() != 0)) {
      return paramsq.c;
    }
    Object localObject = new StringBuilder("其它错误：");
    ((StringBuilder)localObject).append(paramsq.b);
    localObject = ((StringBuilder)localObject).toString();
    int i = paramsq.b;
    switch (i)
    {
    default: 
      switch (i)
      {
      default: 
        localObject = new StringBuilder("其它错误：");
        ((StringBuilder)localObject).append(paramsq.b);
        xb.b(((StringBuilder)localObject).toString());
        localObject = new StringBuilder("其它错误：");
        ((StringBuilder)localObject).append(paramsq.b);
        return ((StringBuilder)localObject).toString();
      case 101: 
        xb.b("如果客户端收到此错误，测等待一段时间重新尝试请求。");
        return "如果客户端收到此错误，测等待一段时间重新尝试请求。";
      }
      xb.b("预留的错误码，如果客户端收到该错误码则无条件终止，并提示错误");
      return "预留的错误码，如果客户端收到该错误码则无条件终止，并提示错误";
    case 9: 
      xb.b("已经到令牌的最大绑定个数");
      return "已经到令牌的最大绑定个数";
    case 8: 
      xb.b("令牌序列号不存在");
      return "令牌序列号不存在";
    case 7: 
      xb.b("客户端输入错误");
      return "客户端输入错误";
    case 6: 
      xb.b("还没有密保手机");
      return "还没有密保手机";
    case 5: 
      xb.b("密保手机不正确");
      return "密保手机不正确";
    case 4: 
      xb.b("解除绑定时该号码还没有绑定qq");
      return "解除绑定时该号码还没有绑定qq";
    case 3: 
      xb.b("该号码已经绑定令牌");
      return "该号码已经绑定令牌";
    case 2: 
      xb.b("六位验证码验证错误");
      return "六位验证码验证错误";
    case 1: 
      xb.b("短信没有到达");
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
      i = ss.a(paramArrayOfByte, 20);
    } else {
      i = -1;
    }
    if (i == -1) {
      return;
    }
    Object localObject = new sq();
    switch (i)
    {
    case 103: 
    case 104: 
    default: 
      return;
    case 106: 
      su.a((sq)localObject, paramArrayOfByte);
      if (((sq)localObject).b == 0)
      {
        ta.a().h();
        this.d.b();
        return;
      }
      this.d.b(((sq)localObject).b, a((sq)localObject));
      return;
    case 105: 
      su.a((sq)localObject, paramArrayOfByte);
      if (((sq)localObject).b == 0)
      {
        ta.a().h();
        this.d.a();
        return;
      }
      this.d.a(((sq)localObject).b, a((sq)localObject));
      return;
    case 102: 
      localObject = new sp();
      su.a((sq)localObject, paramArrayOfByte);
      ((sp)localObject).a = ss.a(((sp)localObject).f, 0, 32);
      if (((sp)localObject).b == 0)
      {
        this.d.b(((sp)localObject).a);
        return;
      }
      this.d.c(a((sq)localObject));
      return;
    }
    su.a((sq)localObject, paramArrayOfByte);
    if (((sq)localObject).b == 0)
    {
      paramArrayOfByte = new StringBuilder("服务器时间:");
      paramArrayOfByte.append(((sq)localObject).d);
      xb.b(paramArrayOfByte.toString());
      this.d.a(((sq)localObject).d);
      return;
    }
    this.d.a(a((sq)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.st
 * JD-Core Version:    0.7.0.1
 */