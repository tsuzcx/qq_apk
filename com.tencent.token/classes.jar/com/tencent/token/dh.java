package com.tencent.token;

import com.tencent.token.global.h;

public class dh
  implements gj
{
  private gg a = null;
  private di b = null;
  private int c = 0;
  private dc d = null;
  
  public dh(dc paramdc)
  {
    this.d = paramdc;
    this.b = new di();
  }
  
  private String a()
  {
    return cx.a() + "/cn/manage/token/gprs_get_svr_time_req";
  }
  
  private String a(de paramde)
  {
    if ((paramde.c != null) && (paramde.c.length() != 0))
    {
      str = paramde.c;
      return str;
    }
    String str = "其它错误：" + paramde.b;
    switch (paramde.b)
    {
    case 0: 
    default: 
      h.b("其它错误：" + paramde.b);
      return "其它错误：" + paramde.b;
    case 1: 
      h.b("短信没有到达");
      return "短信没有到达";
    case 2: 
      h.b("六位验证码验证错误");
      return "六位验证码验证错误";
    case 3: 
      h.b("该号码已经绑定令牌");
      return "该号码已经绑定令牌";
    case 4: 
      h.b("解除绑定时该号码还没有绑定qq");
      return "解除绑定时该号码还没有绑定qq";
    case 5: 
      h.b("密保手机不正确");
      return "密保手机不正确";
    case 6: 
      h.b("还没有密保手机");
      return "还没有密保手机";
    case 7: 
      h.b("客户端输入错误");
      return "客户端输入错误";
    case 8: 
      h.b("令牌序列号不存在");
      return "令牌序列号不存在";
    case 9: 
      h.b("已经到令牌的最大绑定个数");
      return "已经到令牌的最大绑定个数";
    case 100: 
      h.b("预留的错误码，如果客户端收到该错误码则无条件终止，并提示错误");
      return "预留的错误码，如果客户端收到该错误码则无条件终止，并提示错误";
    }
    h.b("如果客户端收到此错误，测等待一段时间重新尝试请求。");
    return "如果客户端收到此错误，测等待一段时间重新尝试请求。";
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.b.a(paramLong, this.c);
    localObject = new gi(a(), (byte[])localObject, this, true);
    ((gi)localObject).a("POST");
    this.a.a((gi)localObject);
    this.c += 1;
  }
  
  public void a(gg paramgg)
  {
    this.a = paramgg;
  }
  
  public void a(gi paramgi, String paramString)
  {
    this.d.c();
  }
  
  public void a(gi paramgi, byte[] paramArrayOfByte)
  {
    int i = this.b.a(paramArrayOfByte);
    if (i == -1) {
      return;
    }
    paramgi = new de();
    switch (i)
    {
    case 103: 
    case 104: 
    default: 
      return;
    case 101: 
      this.b.a(paramgi, paramArrayOfByte);
      if (paramgi.b == 0)
      {
        h.b("服务器时间:" + paramgi.d);
        this.d.a(paramgi.d);
        return;
      }
      this.d.a(a(paramgi));
      return;
    case 102: 
      paramgi = new dd();
      this.b.a(paramgi, paramArrayOfByte);
      this.b.a(paramgi);
      if (paramgi.b == 0)
      {
        this.d.b(paramgi.a);
        return;
      }
      this.d.c(a(paramgi));
      return;
    case 105: 
      this.b.a(paramgi, paramArrayOfByte);
      if (paramgi.b == 0)
      {
        do.a().n();
        this.d.a();
        return;
      }
      this.d.a(paramgi.b, a(paramgi));
      return;
    }
    this.b.a(paramgi, paramArrayOfByte);
    if (paramgi.b == 0)
    {
      do.a().n();
      this.d.b();
      return;
    }
    this.d.b(paramgi.b, a(paramgi));
  }
  
  public boolean a(gi paramgi, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dh
 * JD-Core Version:    0.7.0.1
 */