package com.tencent.token;

import com.tencent.token.global.g;

public class cl
  implements fb
{
  private ez a = null;
  private cm b = null;
  private int c = 0;
  private cg d = null;
  
  public cl(cg paramcg)
  {
    this.d = paramcg;
    this.b = new cm();
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(cd.a());
    localStringBuilder.append("/cn/manage/token/gprs_get_svr_time_req");
    return localStringBuilder.toString();
  }
  
  private String a(ci paramci)
  {
    if ((paramci.c != null) && (paramci.c.length() != 0)) {
      return paramci.c;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("其它错误：");
    ((StringBuilder)localObject).append(paramci.b);
    localObject = ((StringBuilder)localObject).toString();
    int i = paramci.b;
    switch (i)
    {
    default: 
      switch (i)
      {
      default: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("其它错误：");
        ((StringBuilder)localObject).append(paramci.b);
        g.b(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("其它错误：");
        ((StringBuilder)localObject).append(paramci.b);
        return ((StringBuilder)localObject).toString();
      case 101: 
        g.b("如果客户端收到此错误，测等待一段时间重新尝试请求。");
        return "如果客户端收到此错误，测等待一段时间重新尝试请求。";
      }
      g.b("预留的错误码，如果客户端收到该错误码则无条件终止，并提示错误");
      return "预留的错误码，如果客户端收到该错误码则无条件终止，并提示错误";
    case 9: 
      g.b("已经到令牌的最大绑定个数");
      return "已经到令牌的最大绑定个数";
    case 8: 
      g.b("令牌序列号不存在");
      return "令牌序列号不存在";
    case 7: 
      g.b("客户端输入错误");
      return "客户端输入错误";
    case 6: 
      g.b("还没有密保手机");
      return "还没有密保手机";
    case 5: 
      g.b("密保手机不正确");
      return "密保手机不正确";
    case 4: 
      g.b("解除绑定时该号码还没有绑定qq");
      return "解除绑定时该号码还没有绑定qq";
    case 3: 
      g.b("该号码已经绑定令牌");
      return "该号码已经绑定令牌";
    case 2: 
      g.b("六位验证码验证错误");
      return "六位验证码验证错误";
    case 1: 
      g.b("短信没有到达");
      return "短信没有到达";
    }
    return localObject;
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.b.a(paramLong, this.c);
    localObject = new fa(a(), (byte[])localObject, this, true);
    ((fa)localObject).a("POST");
    this.a.a((fa)localObject);
    this.c += 1;
  }
  
  public void a(ez paramez)
  {
    this.a = paramez;
  }
  
  public void a(fa paramfa, String paramString)
  {
    this.d.c();
  }
  
  public void a(fa paramfa, byte[] paramArrayOfByte)
  {
    int i = this.b.a(paramArrayOfByte);
    if (i == -1) {
      return;
    }
    paramfa = new ci();
    switch (i)
    {
    case 103: 
    case 104: 
    default: 
      return;
    case 106: 
      this.b.a(paramfa, paramArrayOfByte);
      if (paramfa.b == 0)
      {
        cs.a().n();
        this.d.b();
        return;
      }
      this.d.b(paramfa.b, a(paramfa));
      return;
    case 105: 
      this.b.a(paramfa, paramArrayOfByte);
      if (paramfa.b == 0)
      {
        cs.a().n();
        this.d.a();
        return;
      }
      this.d.a(paramfa.b, a(paramfa));
      return;
    case 102: 
      paramfa = new ch();
      this.b.a(paramfa, paramArrayOfByte);
      this.b.a(paramfa);
      if (paramfa.b == 0)
      {
        this.d.b(paramfa.a);
        return;
      }
      this.d.c(a(paramfa));
      return;
    }
    this.b.a(paramfa, paramArrayOfByte);
    if (paramfa.b == 0)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("服务器时间:");
      paramArrayOfByte.append(paramfa.d);
      g.b(paramArrayOfByte.toString());
      this.d.a(paramfa.d);
      return;
    }
    this.d.a(a(paramfa));
  }
  
  public boolean a(fa paramfa, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cl
 * JD-Core Version:    0.7.0.1
 */