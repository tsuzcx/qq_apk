package com.tencent.securemodule;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.qq.jce.wup.UniPacket;
import com.tencent.securemodule.jni.SecureEngine;
import java.util.concurrent.atomic.AtomicReference;

public final class ab
{
  private static String a = null;
  private static ac.a[] b = { new ac.a("info", "getGuid"), new ac.a("info", "getUpdatesV2"), new ac.a("info", "reportTipsRes"), new ac.a("cloudcheck", "tinyCloudCheck"), new ac.a("cloudcheck", "cloudCheck") };
  private String c = null;
  private String d = null;
  private Context e;
  private k f;
  private q g;
  private h h;
  
  public ab(Context paramContext)
  {
    this.e = paramContext;
    a = this.e.getSharedPreferences("secure_config", 0).getString(String.format("%5d", new Object[] { Integer.valueOf(20001) }), null);
    Object localObject = ((TelephonyManager)this.e.getSystemService("phone")).getDeviceId();
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = "";
    }
    this.c = paramContext;
    paramContext = ((WifiManager)this.e.getSystemService("wifi")).getConnectionInfo();
    if (paramContext != null) {}
    for (paramContext = paramContext.getMacAddress();; paramContext = null)
    {
      localObject = paramContext;
      if (paramContext == null) {
        localObject = "";
      }
      this.d = ((String)localObject);
      return;
    }
  }
  
  public static String a(int paramInt)
  {
    return b[paramInt].a;
  }
  
  public static String b(int paramInt)
  {
    return b[paramInt].b;
  }
  
  public final k a()
  {
    if (this.f == null)
    {
      this.f = new k();
      this.f.a(2);
      this.f.b(this.e.getSharedPreferences("secure_config", 0).getInt(String.format("%5d", new Object[] { Integer.valueOf(30005) }), 201));
    }
    return this.f;
  }
  
  public final q b()
  {
    int j = 2;
    if (this.g == null)
    {
      this.g = new q();
      this.g.a(this.c);
      this.g.c("0000000000000000");
      this.g.d(this.e.getSharedPreferences("secure_config", 0).getString(String.format("%5d", new Object[] { Integer.valueOf(30002) }), ""));
      q localq = this.g;
      String str = Build.MODEL;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localq.e((String)localObject);
      this.g.b(this.e.getSharedPreferences("secure_config", 0).getInt(String.format("%5d", new Object[] { Integer.valueOf(30003) }), 6));
      localObject = this.e.getSharedPreferences("secure_config", 0).getString(String.format("%5d", new Object[] { Integer.valueOf(30001) }), "0.0.0").trim().split("[\\.]");
      if (localObject.length >= 3) {
        this.g.a(new l(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1]), Integer.parseInt(localObject[2])));
      }
      this.g.f(a);
      localq = this.g;
      str = ((TelephonyManager)this.e.getSystemService("phone")).getSubscriberId();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localq.g((String)localObject);
      localObject = this.g;
      if (aa.a(this.e) == aa.a.a)
      {
        i = 2;
        ((q)localObject).a(i);
        localObject = this.g;
        if (!s.a(this.e)) {
          break label459;
        }
        i = 1;
        label326:
        ((q)localObject).c(i);
        localObject = this.g;
        if (!SecureEngine.a(this.e)) {
          break label464;
        }
      }
      label459:
      label464:
      for (i = 1;; i = 0)
      {
        ((q)localObject).d(i);
        this.g.e(Integer.parseInt(Build.VERSION.SDK));
        this.g.f(this.e.getSharedPreferences("secure_config", 0).getInt(String.format("%5d", new Object[] { Integer.valueOf(30004) }), 0));
        this.g.b(this.e.getSharedPreferences("secure_config", 0).getString(String.format("%5d", new Object[] { Integer.valueOf(30006) }), ""));
        return this.g;
        i = 1;
        break;
        i = 0;
        break label326;
      }
    }
    this.g.f(a);
    this.g.a(this.c);
    Object localObject = this.g;
    if (SecureEngine.a(this.e))
    {
      i = 1;
      label507:
      ((q)localObject).d(i);
      localObject = this.g;
      if (aa.a(this.e) != aa.a.a) {
        break label587;
      }
    }
    label587:
    for (int i = j;; i = 1)
    {
      ((q)localObject).a(i);
      this.g.b(this.e.getSharedPreferences("secure_config", 0).getString(String.format("%5d", new Object[] { Integer.valueOf(30006) }), ""));
      break;
      i = 0;
      break label507;
    }
  }
  
  public final int c()
  {
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if ((a != null) && (!a.equals("")))
    {
      localObject2 = ((TelephonyManager)this.e.getSystemService("phone")).getDeviceId();
      if (localObject2 != null) {
        break label609;
      }
      localObject2 = "";
      localObject3 = ((WifiManager)this.e.getSystemService("wifi")).getConnectionInfo();
      localObject1 = null;
      if (localObject3 != null) {
        localObject1 = ((WifiInfo)localObject3).getMacAddress();
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = "";
      }
      this.c = this.e.getSharedPreferences("secure_config", 0).getString(String.format("%5d", new Object[] { Integer.valueOf(20002) }), (String)localObject2);
      this.d = this.e.getSharedPreferences("secure_config", 0).getString(String.format("%5d", new Object[] { Integer.valueOf(20003) }), (String)localObject3);
      if ((((String)localObject2).equals(this.c)) && (((String)localObject3).equals(this.d))) {
        break label726;
      }
      this.c = ((String)localObject2);
      this.d = ((String)localObject3);
    }
    label394:
    label559:
    label723:
    label726:
    for (int i = 1;; i = 0)
    {
      UniPacket localUniPacket2;
      if (i != 0) {
        if (this.h == null)
        {
          this.h = new h();
          this.h.a(this.c);
          localObject3 = this.h;
          localObject2 = ((TelephonyManager)this.e.getSystemService("phone")).getSubscriberId();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((h)localObject3).b((String)localObject1);
          this.h.c(this.d);
          localObject3 = this.h;
          localObject2 = ((TelephonyManager)this.e.getSystemService("phone")).getSimSerialNumber();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((h)localObject3).d((String)localObject1);
          this.h.e("android_id");
          this.h.a(Integer.parseInt(Build.VERSION.SDK));
          localObject3 = this.h;
          localObject2 = Build.MODEL;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((h)localObject3).f((String)localObject1);
          localObject3 = this.h;
          localObject2 = Build.PRODUCT;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((h)localObject3).g((String)localObject1);
          this.h.h(a);
          localObject2 = this.h;
          localObject1 = new AtomicReference();
          localObject3 = this.e;
          if (ac.a == null) {
            ac.a = new ac((Context)localObject3);
          }
          localObject3 = ac.a;
          UniPacket localUniPacket1 = new UniPacket(true);
          localUniPacket2 = new UniPacket(true);
          localUniPacket1.setRequestId(0);
          localUniPacket1.setServantName(b[0].a);
          localUniPacket1.setFuncName(b[0].b);
          localUniPacket1.setEncodeName("UTF-8");
          localUniPacket2.setEncodeName("UTF-8");
          localUniPacket1.put("phonetype", ((ac)localObject3).b.a());
          localUniPacket1.put("userinfo", ((ac)localObject3).b.b());
          localUniPacket1.put("deviceinfo", localObject2);
          i = ((ac)localObject3).a(localUniPacket1, localUniPacket2);
          if (i == 0) {
            break label647;
          }
          if (i != 0) {
            break label723;
          }
          localObject1 = (i)((AtomicReference)localObject1).get();
          if (localObject1 == null) {
            break label723;
          }
          localObject1 = ((i)localObject1).a();
          a = (String)localObject1;
          if ((localObject1 != null) && (!a.equals(""))) {
            break label723;
          }
          i = -2001;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          return i;
          label609:
          break;
          this.h.h(a);
          this.h.a(this.c);
          this.h.c(this.d);
          break label394;
          localObject2 = (i)localUniPacket2.getByClass("guidinfo", new i());
          if (localObject2 != null) {
            ((AtomicReference)localObject1).set(localObject2);
          }
          i = 0;
          break label559;
        }
        y.a.a(this.e, 20002, this.c);
        y.a.a(this.e, 20003, this.d);
        y.a.a(this.e, 20001, a);
        return 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.ab
 * JD-Core Version:    0.7.0.1
 */