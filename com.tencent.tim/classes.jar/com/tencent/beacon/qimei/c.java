package com.tencent.beacon.qimei;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.b.e.a;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.base.net.call.JceRequestEntity.a;
import com.tencent.beacon.base.net.call.j;
import com.tencent.beacon.pack.QimeiPackage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
  implements e.a, Callback<byte[]>, Runnable
{
  private final Context a;
  private AtomicInteger b = new AtomicInteger();
  
  public c(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void a(HashMap<String, String> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("q_m", paramHashMap);
    com.tencent.beacon.a.a.b.a().a(new com.tencent.beacon.a.a.c(1, localHashMap));
  }
  
  private void d()
  {
    com.tencent.beacon.base.util.c.a("[Qimei]", 4, "stop netListen.", new Object[0]);
    com.tencent.beacon.base.net.b.e.a(this);
  }
  
  public void a()
  {
    this.b.set(0);
    com.tencent.beacon.a.b.a.a().a(this);
  }
  
  public void a(String paramString)
  {
    Qimei localQimei = a.a().b();
    HashMap localHashMap = e.a(paramString);
    paramString = localQimei;
    if (localHashMap != null)
    {
      paramString = new Qimei((String)localHashMap.get("A3"), (String)localHashMap.get("A153"), localHashMap);
      com.tencent.beacon.base.util.c.a("[qimei] showQimei: " + paramString.toString(), new Object[0]);
    }
    a.a().a(paramString);
    a(localHashMap);
  }
  
  public void a(@NonNull byte[] paramArrayOfByte)
  {
    com.tencent.beacon.base.util.c.a("[Qimei]", 1, "onResponse length: %d. ", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    paramArrayOfByte = new com.tencent.beacon.pack.a(paramArrayOfByte);
    QimeiPackage localQimeiPackage = new QimeiPackage();
    localQimeiPackage.readFrom(paramArrayOfByte);
    paramArrayOfByte = localQimeiPackage.qimei;
    com.tencent.beacon.base.util.c.a("[Qimei]", 2, "get new qimei: %s", new Object[] { paramArrayOfByte });
    if (!TextUtils.isEmpty(paramArrayOfByte))
    {
      com.tencent.beacon.base.util.c.a("[Qimei]", 3, "dispatch qimei to listener and save qimei!", new Object[0]);
      a(paramArrayOfByte);
      e.a(this.a, paramArrayOfByte);
      e.a(System.currentTimeMillis());
      d();
    }
  }
  
  public void b() {}
  
  public void c()
  {
    com.tencent.beacon.a.b.a.a().a(300L, new b(this));
  }
  
  public void onFailure(com.tencent.beacon.base.net.d paramd)
  {
    com.tencent.beacon.base.util.c.a("[Qimei]", 1, "onFailure msg: %s. Waiting next query.", new Object[] { paramd.toString() });
    com.tencent.beacon.a.b.d.b().a("498", paramd.toString());
    if (a.a().b().isEmpty()) {
      com.tencent.beacon.a.b.a.a().a(10000L, this);
    }
  }
  
  public void run()
  {
    com.tencent.beacon.base.net.b.e.a(this.a, this);
    if (!com.tencent.beacon.base.net.b.d.d()) {
      return;
    }
    if (!com.tencent.beacon.a.c.b.f(this.a))
    {
      c();
      return;
    }
    Object localObject = QimeiSDK.getInstance();
    localObject = JceRequestEntity.builder().a(RequestType.QIMEI).a(com.tencent.beacon.base.net.b.b.b(true), 8081).b(com.tencent.beacon.base.net.b.b.b(false)).a(((QimeiSDK)localObject).getAppKey()).a(102).b(103).a(a.a().c()).b("A141", ((QimeiSDK)localObject).getBeaconIdInfo()).b("A142", String.valueOf(((QimeiSDK)localObject).getContext().getApplicationInfo().targetSdkVersion)).b("A143", ((QimeiSDK)localObject).getOmgID()).b("A144", f.e().i()).b("A23", com.tencent.beacon.a.c.c.d().a()).a();
    com.tencent.beacon.base.net.c.c().b((JceRequestEntity)localObject).a(this);
    com.tencent.beacon.base.util.c.a("[Qimei]", 0, "QimeiQueryTask start. RequestEntity: %s", new Object[] { ((JceRequestEntity)localObject).toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.qimei.c
 * JD-Core Version:    0.7.0.1
 */