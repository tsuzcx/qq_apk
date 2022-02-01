package com.tencent.token;

public final class ss
  implements ahp
{
  ahn a = null;
  private st b = null;
  private int c = 0;
  private sn d = null;
  
  public ss(sn paramsn)
  {
    this.d = paramsn;
    this.b = new st();
  }
  
  private static String a(sp paramsp)
  {
    if ((paramsp.c != null) && (paramsp.c.length() != 0)) {
      return paramsp.c;
    }
    Object localObject = new StringBuilder("其它错误：");
    ((StringBuilder)localObject).append(paramsp.b);
    localObject = ((StringBuilder)localObject).toString();
    int i = paramsp.b;
    switch (i)
    {
    default: 
      switch (i)
      {
      default: 
        localObject = new StringBuilder("其它错误：");
        ((StringBuilder)localObject).append(paramsp.b);
        xa.b(((StringBuilder)localObject).toString());
        localObject = new StringBuilder("其它错误：");
        ((StringBuilder)localObject).append(paramsp.b);
        return ((StringBuilder)localObject).toString();
      case 101: 
        xa.b("如果客户端收到此错误，测等待一段时间重新尝试请求。");
        return "如果客户端收到此错误，测等待一段时间重新尝试请求。";
      }
      xa.b("预留的错误码，如果客户端收到该错误码则无条件终止，并提示错误");
      return "预留的错误码，如果客户端收到该错误码则无条件终止，并提示错误";
    case 9: 
      xa.b("已经到令牌的最大绑定个数");
      return "已经到令牌的最大绑定个数";
    case 8: 
      xa.b("令牌序列号不存在");
      return "令牌序列号不存在";
    case 7: 
      xa.b("客户端输入错误");
      return "客户端输入错误";
    case 6: 
      xa.b("还没有密保手机");
      return "还没有密保手机";
    case 5: 
      xa.b("密保手机不正确");
      return "密保手机不正确";
    case 4: 
      xa.b("解除绑定时该号码还没有绑定qq");
      return "解除绑定时该号码还没有绑定qq";
    case 3: 
      xa.b("该号码已经绑定令牌");
      return "该号码已经绑定令牌";
    case 2: 
      xa.b("六位验证码验证错误");
      return "六位验证码验证错误";
    case 1: 
      xa.b("短信没有到达");
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
      i = sr.a(paramArrayOfByte, 20);
    } else {
      i = -1;
    }
    if (i == -1) {
      return;
    }
    Object localObject = new sp();
    switch (i)
    {
    case 103: 
    case 104: 
    default: 
      return;
    case 106: 
      st.a((sp)localObject, paramArrayOfByte);
      if (((sp)localObject).b == 0)
      {
        sz.a().h();
        this.d.b();
        return;
      }
      this.d.b(((sp)localObject).b, a((sp)localObject));
      return;
    case 105: 
      st.a((sp)localObject, paramArrayOfByte);
      if (((sp)localObject).b == 0)
      {
        sz.a().h();
        this.d.a();
        return;
      }
      this.d.a(((sp)localObject).b, a((sp)localObject));
      return;
    case 102: 
      localObject = new so();
      st.a((sp)localObject, paramArrayOfByte);
      ((so)localObject).a = sr.a(((so)localObject).f, 0, 32);
      if (((so)localObject).b == 0)
      {
        this.d.b(((so)localObject).a);
        return;
      }
      this.d.c(a((sp)localObject));
      return;
    }
    st.a((sp)localObject, paramArrayOfByte);
    if (((sp)localObject).b == 0)
    {
      paramArrayOfByte = new StringBuilder("服务器时间:");
      paramArrayOfByte.append(((sp)localObject).d);
      xa.b(paramArrayOfByte.toString());
      this.d.a(((sp)localObject).d);
      return;
    }
    this.d.a(a((sp)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ss
 * JD-Core Version:    0.7.0.1
 */