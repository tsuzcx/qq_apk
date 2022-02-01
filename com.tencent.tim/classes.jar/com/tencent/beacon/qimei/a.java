package com.tencent.beacon.qimei;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.base.util.d;
import com.tencent.beacon.pack.QimeiPackage;
import java.util.HashMap;
import java.util.Map;

public class a
{
  private static a a;
  private String b = "";
  private Qimei c;
  
  private a()
  {
    d();
  }
  
  public static a a()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  private void d()
  {
    try
    {
      this.c = new Qimei();
      Object localObject1 = e.a(com.tencent.beacon.a.c.c.d().c());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.b = ((String)localObject1);
      }
      com.tencent.beacon.base.util.c.a("[qimei] final jceRequest qimeiJson: " + this.b, new Object[0]);
      localObject1 = e.a(this.b);
      if (localObject1 != null)
      {
        this.c.b((String)((HashMap)localObject1).get("A3"));
        this.c.a((String)((HashMap)localObject1).get("A153"));
        this.c.a((Map)localObject1);
        com.tencent.beacon.base.util.c.a("[qimei] showQimei: " + this.c.toString(), new Object[0]);
      }
      return;
    }
    finally {}
  }
  
  public void a(Qimei paramQimei)
  {
    try
    {
      this.c = paramQimei;
      return;
    }
    finally
    {
      paramQimei = finally;
      throw paramQimei;
    }
  }
  
  public Qimei b()
  {
    return this.c;
  }
  
  public QimeiPackage c()
  {
    f localf = f.e();
    QimeiPackage localQimeiPackage = new QimeiPackage();
    localQimeiPackage.androidId = localf.a();
    localQimeiPackage.imei = localf.b();
    localQimeiPackage.imsi = localf.d();
    localQimeiPackage.mac = localf.f();
    String str = this.b;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localQimeiPackage.qimei = ((String)localObject);
    localQimeiPackage.model = localf.h();
    localQimeiPackage.brand = Build.BRAND;
    localObject = com.tencent.beacon.a.c.e.l();
    localQimeiPackage.osVersion = ((com.tencent.beacon.a.c.e)localObject).s();
    localQimeiPackage.broot = d.d();
    localQimeiPackage.qq = "";
    localQimeiPackage.cid = ((com.tencent.beacon.a.c.e)localObject).p();
    return localQimeiPackage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.qimei.a
 * JD-Core Version:    0.7.0.1
 */