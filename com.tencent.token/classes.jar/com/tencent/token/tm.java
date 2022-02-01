package com.tencent.token;

public final class tm
  implements akk
{
  aki a = null;
  private tn b = null;
  private int c = 0;
  private th d = null;
  
  public tm(th paramth)
  {
    this.d = paramth;
    this.b = new tn();
  }
  
  private static String a(tj paramtj)
  {
    if ((paramtj.c != null) && (paramtj.c.length() != 0)) {
      return paramtj.c;
    }
    Object localObject = new StringBuilder("其它错误：");
    ((StringBuilder)localObject).append(paramtj.b);
    localObject = ((StringBuilder)localObject).toString();
    int i = paramtj.b;
    switch (i)
    {
    default: 
      switch (i)
      {
      default: 
        localObject = new StringBuilder("其它错误：");
        ((StringBuilder)localObject).append(paramtj.b);
        xv.b(((StringBuilder)localObject).toString());
        localObject = new StringBuilder("其它错误：");
        ((StringBuilder)localObject).append(paramtj.b);
        return ((StringBuilder)localObject).toString();
      case 101: 
        xv.b("如果客户端收到此错误，测等待一段时间重新尝试请求。");
        return "如果客户端收到此错误，测等待一段时间重新尝试请求。";
      }
      xv.b("预留的错误码，如果客户端收到该错误码则无条件终止，并提示错误");
      return "预留的错误码，如果客户端收到该错误码则无条件终止，并提示错误";
    case 9: 
      xv.b("已经到令牌的最大绑定个数");
      return "已经到令牌的最大绑定个数";
    case 8: 
      xv.b("令牌序列号不存在");
      return "令牌序列号不存在";
    case 7: 
      xv.b("客户端输入错误");
      return "客户端输入错误";
    case 6: 
      xv.b("还没有密保手机");
      return "还没有密保手机";
    case 5: 
      xv.b("密保手机不正确");
      return "密保手机不正确";
    case 4: 
      xv.b("解除绑定时该号码还没有绑定qq");
      return "解除绑定时该号码还没有绑定qq";
    case 3: 
      xv.b("该号码已经绑定令牌");
      return "该号码已经绑定令牌";
    case 2: 
      xv.b("六位验证码验证错误");
      return "六位验证码验证错误";
    case 1: 
      xv.b("短信没有到达");
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
      i = tl.a(paramArrayOfByte, 20);
    } else {
      i = -1;
    }
    if (i == -1) {
      return;
    }
    Object localObject = new tj();
    switch (i)
    {
    case 103: 
    case 104: 
    default: 
      return;
    case 106: 
      tn.a((tj)localObject, paramArrayOfByte);
      if (((tj)localObject).b == 0)
      {
        tt.a().h();
        this.d.b();
        return;
      }
      this.d.b(((tj)localObject).b, a((tj)localObject));
      return;
    case 105: 
      tn.a((tj)localObject, paramArrayOfByte);
      if (((tj)localObject).b == 0)
      {
        tt.a().h();
        this.d.a();
        return;
      }
      this.d.a(((tj)localObject).b, a((tj)localObject));
      return;
    case 102: 
      localObject = new ti();
      tn.a((tj)localObject, paramArrayOfByte);
      ((ti)localObject).a = tl.a(((ti)localObject).f, 0, 32);
      if (((ti)localObject).b == 0)
      {
        this.d.b(((ti)localObject).a);
        return;
      }
      this.d.c(a((tj)localObject));
      return;
    }
    tn.a((tj)localObject, paramArrayOfByte);
    if (((tj)localObject).b == 0)
    {
      paramArrayOfByte = new StringBuilder("服务器时间:");
      paramArrayOfByte.append(((tj)localObject).d);
      xv.b(paramArrayOfByte.toString());
      this.d.a(((tj)localObject).d);
      return;
    }
    this.d.a(a((tj)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tm
 * JD-Core Version:    0.7.0.1
 */