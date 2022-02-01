package com.tencent.token;

import com.tencent.token.global.g;

public class ck
  implements ey
{
  private ew a = null;
  private cl b = null;
  private int c = 0;
  private cf d = null;
  
  public ck(cf paramcf)
  {
    this.d = paramcf;
    this.b = new cl();
  }
  
  private String a()
  {
    return cc.a() + "/cn/manage/token/gprs_get_svr_time_req";
  }
  
  private String a(ch paramch)
  {
    if ((paramch.c != null) && (paramch.c.length() != 0))
    {
      str = paramch.c;
      return str;
    }
    String str = "其它错误：" + paramch.b;
    switch (paramch.b)
    {
    case 0: 
    default: 
      g.b("其它错误：" + paramch.b);
      return "其它错误：" + paramch.b;
    case 1: 
      g.b("短信没有到达");
      return "短信没有到达";
    case 2: 
      g.b("六位验证码验证错误");
      return "六位验证码验证错误";
    case 3: 
      g.b("该号码已经绑定令牌");
      return "该号码已经绑定令牌";
    case 4: 
      g.b("解除绑定时该号码还没有绑定qq");
      return "解除绑定时该号码还没有绑定qq";
    case 5: 
      g.b("密保手机不正确");
      return "密保手机不正确";
    case 6: 
      g.b("还没有密保手机");
      return "还没有密保手机";
    case 7: 
      g.b("客户端输入错误");
      return "客户端输入错误";
    case 8: 
      g.b("令牌序列号不存在");
      return "令牌序列号不存在";
    case 9: 
      g.b("已经到令牌的最大绑定个数");
      return "已经到令牌的最大绑定个数";
    case 100: 
      g.b("预留的错误码，如果客户端收到该错误码则无条件终止，并提示错误");
      return "预留的错误码，如果客户端收到该错误码则无条件终止，并提示错误";
    }
    g.b("如果客户端收到此错误，测等待一段时间重新尝试请求。");
    return "如果客户端收到此错误，测等待一段时间重新尝试请求。";
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.b.a(paramLong, this.c);
    localObject = new ex(a(), (byte[])localObject, this, true);
    ((ex)localObject).a("POST");
    this.a.a((ex)localObject);
    this.c += 1;
  }
  
  public void a(ew paramew)
  {
    this.a = paramew;
  }
  
  public void a(ex paramex, String paramString)
  {
    this.d.c();
  }
  
  public void a(ex paramex, byte[] paramArrayOfByte)
  {
    int i = this.b.a(paramArrayOfByte);
    if (i == -1) {
      return;
    }
    paramex = new ch();
    switch (i)
    {
    case 103: 
    case 104: 
    default: 
      return;
    case 101: 
      this.b.a(paramex, paramArrayOfByte);
      if (paramex.b == 0)
      {
        g.b("服务器时间:" + paramex.d);
        this.d.a(paramex.d);
        return;
      }
      this.d.a(a(paramex));
      return;
    case 102: 
      paramex = new cg();
      this.b.a(paramex, paramArrayOfByte);
      this.b.a(paramex);
      if (paramex.b == 0)
      {
        this.d.b(paramex.a);
        return;
      }
      this.d.c(a(paramex));
      return;
    case 105: 
      this.b.a(paramex, paramArrayOfByte);
      if (paramex.b == 0)
      {
        cr.a().n();
        this.d.a();
        return;
      }
      this.d.a(paramex.b, a(paramex));
      return;
    }
    this.b.a(paramex, paramArrayOfByte);
    if (paramex.b == 0)
    {
      cr.a().n();
      this.d.b();
      return;
    }
    this.d.b(paramex.b, a(paramex));
  }
  
  public boolean a(ex paramex, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ck
 * JD-Core Version:    0.7.0.1
 */