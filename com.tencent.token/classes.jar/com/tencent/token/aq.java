package com.tencent.token;

import com.tencent.token.global.b;
import com.tencent.token.global.e;

public final class aq
  implements gu
{
  private gr a = null;
  private ar b = null;
  private int c = 0;
  private al d = null;
  
  public aq(al paramal)
  {
    this.d = paramal;
    this.b = new ar();
  }
  
  private static String a(an paraman)
  {
    if ((paraman.c != null) && (paraman.c.length() != 0))
    {
      str = paraman.c;
      return str;
    }
    String str = "其它错误：" + paraman.b;
    switch (paraman.b)
    {
    case 0: 
    default: 
      e.b("其它错误：" + paraman.b);
      return "其它错误：" + paraman.b;
    case 1: 
      e.b("短信没有到达");
      return "短信没有到达";
    case 2: 
      e.b("六位验证码验证错误");
      return "六位验证码验证错误";
    case 3: 
      e.b("该号码已经绑定令牌");
      return "该号码已经绑定令牌";
    case 4: 
      e.b("解除绑定时该号码还没有绑定qq");
      return "解除绑定时该号码还没有绑定qq";
    case 5: 
      e.b("密保手机不正确");
      return "密保手机不正确";
    case 6: 
      e.b("还没有密保手机");
      return "还没有密保手机";
    case 7: 
      e.b("客户端输入错误");
      return "客户端输入错误";
    case 8: 
      e.b("令牌序列号不存在");
      return "令牌序列号不存在";
    case 9: 
      e.b("已经到令牌的最大绑定个数");
      return "已经到令牌的最大绑定个数";
    case 100: 
      e.b("预留的错误码，如果客户端收到该错误码则无条件终止，并提示错误");
      return "预留的错误码，如果客户端收到该错误码则无条件终止，并提示错误";
    }
    e.b("如果客户端收到此错误，测等待一段时间重新尝试请求。");
    return "如果客户端收到此错误，测等待一段时间重新尝试请求。";
  }
  
  public final void a()
  {
    int i = this.c;
    Object localObject = new ao();
    int j = (int)(System.currentTimeMillis() / 1000L);
    ((ao)localObject).g = 86630087L;
    ((ao)localObject).l = i;
    ((ao)localObject).m = j;
    ((ao)localObject).n = 1;
    ((ao)localObject).o = 4;
    ((ao)localObject).p = 2;
    ((ao)localObject).q = b.b();
    byte[] arrayOfByte1 = ((ao)localObject).r.getBytes();
    int k = arrayOfByte1.length;
    if ((((ao)localObject).f != null) && (((ao)localObject).f.length > 0)) {}
    for (i = ((ao)localObject).f.length;; i = 0)
    {
      j = ((ao)localObject).t.length + 92 + i + 32 + 1;
      ((ao)localObject).h = ((short)j);
      byte[] arrayOfByte2 = new byte[j];
      arrayOfByte2[0] = 2;
      ap.a(arrayOfByte2, 1, ((ao)localObject).g);
      j = ((ao)localObject).h;
      arrayOfByte2[5] = ((byte)(j >> 8));
      arrayOfByte2[6] = ((byte)j);
      arrayOfByte2[7] = ((ao)localObject).i;
      j = ((ao)localObject).j;
      arrayOfByte2[8] = ((byte)(j >> 8));
      arrayOfByte2[9] = ((byte)j);
      j = ((ao)localObject).k;
      arrayOfByte2[10] = ((byte)(j >> 8));
      arrayOfByte2[11] = ((byte)j);
      ap.a(arrayOfByte2, 12, ((ao)localObject).l);
      ap.a(arrayOfByte2, 16, ((ao)localObject).m);
      j = ((ao)localObject).n;
      arrayOfByte2[20] = ((byte)(j >> 8));
      arrayOfByte2[21] = ((byte)j);
      j = ((ao)localObject).o;
      arrayOfByte2[22] = ((byte)(j >> 8));
      arrayOfByte2[23] = ((byte)j);
      j = ((ao)localObject).p;
      arrayOfByte2[24] = ((byte)(j >> 8));
      arrayOfByte2[25] = ((byte)j);
      j = ((ao)localObject).q;
      arrayOfByte2[26] = ((byte)(j >> 8));
      arrayOfByte2[27] = ((byte)j);
      byte[] arrayOfByte3 = new byte[64];
      if (k > 0)
      {
        j = k;
        if (k > 64) {
          j = 64;
        }
        System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 0, j);
      }
      System.arraycopy(arrayOfByte3, 0, arrayOfByte2, 28, 64);
      System.arraycopy(((ao)localObject).t, 0, arrayOfByte2, 92, ((ao)localObject).t.length);
      j = ((ao)localObject).t.length + 92;
      if (i > 0)
      {
        System.arraycopy(((ao)localObject).f, 0, arrayOfByte2, j, i);
        i += j;
      }
      for (;;)
      {
        System.arraycopy(((ao)localObject).s, 0, arrayOfByte2, i, ((ao)localObject).s.length);
        arrayOfByte2[(i + localObject.s.length)] = 3;
        localObject = new gt(ag.a() + "/cn/manage/token/gprs_get_svr_time_req", arrayOfByte2, this);
        ((gt)localObject).a("POST");
        this.a.a((gt)localObject);
        this.c += 1;
        return;
        i = j;
      }
    }
  }
  
  public final void a(gr paramgr)
  {
    this.a = paramgr;
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2) || (paramArrayOfByte[0] != 2) || (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 3)) {}
    for (int i = -1; i == -1; i = (short)(((paramArrayOfByte[20] & 0xFF) << 8) + ((paramArrayOfByte[21] & 0xFF) << 0))) {
      return;
    }
    Object localObject = new an();
    switch (i)
    {
    case 103: 
    case 104: 
    default: 
      return;
    case 101: 
      ar.a((an)localObject, paramArrayOfByte);
      if (((an)localObject).b == 0)
      {
        e.b("服务器时间:" + ((an)localObject).d);
        this.d.a(((an)localObject).d);
        return;
      }
      this.d.a(a((an)localObject));
      return;
    case 102: 
      localObject = new am();
      ar.a((an)localObject, paramArrayOfByte);
      ((am)localObject).a = ap.a(((am)localObject).f, 0, 32);
      if (((am)localObject).b == 0)
      {
        this.d.b(((am)localObject).a);
        return;
      }
      this.d.c(a((an)localObject));
      return;
    case 105: 
      ar.a((an)localObject, paramArrayOfByte);
      if (((an)localObject).b == 0)
      {
        ax.a().n();
        this.d.a();
        return;
      }
      this.d.a(((an)localObject).b, a((an)localObject));
      return;
    }
    ar.a((an)localObject, paramArrayOfByte);
    if (((an)localObject).b == 0)
    {
      ax.a().n();
      this.d.b();
      return;
    }
    this.d.b(((an)localObject).b, a((an)localObject));
  }
  
  public final void b()
  {
    this.d.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aq
 * JD-Core Version:    0.7.0.1
 */