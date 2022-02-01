package com.tencent.securemodule.impl;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Process;
import com.qq.jce.wup.UniAttribute;
import com.tencent.securemodule.aa;
import com.tencent.securemodule.ab;
import com.tencent.securemodule.ac;
import com.tencent.securemodule.ae;
import com.tencent.securemodule.ah;
import com.tencent.securemodule.as;
import com.tencent.securemodule.at;
import com.tencent.securemodule.ax;
import com.tencent.securemodule.c;
import com.tencent.securemodule.e;
import com.tencent.securemodule.o;
import com.tencent.securemodule.service.ICallback;
import com.tencent.securemodule.service.IControlService;
import com.tencent.securemodule.ui.SecureEventReceiver;
import com.tencent.securemodule.w;
import com.tencent.securemodule.x;
import com.tencent.securemodule.z;
import java.io.File;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SecureService
  extends Service
{
  private Context a;
  private int b = 0;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private a f = new a();
  
  private int a(String paramString)
  {
    this.b += 1;
    int i = -2;
    if (paramString == null) {
      return -6;
    }
    Object localObject1 = new UniAttribute();
    ((UniAttribute)localObject1).setEncodeName("UTF-8");
    ((UniAttribute)localObject1).decode(ax.b(paramString));
    paramString = (e)((UniAttribute)localObject1).getByClass("data", new e());
    if ((paramString == null) || (paramString.c() == null)) {
      return -6;
    }
    Object localObject2 = paramString.c();
    localObject1 = x.a(this.a.getApplicationContext());
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      int j = ((x)localObject1).a(paramString, (c)((Iterator)localObject2).next());
      i = j;
      if (j != 0) {
        i = j;
      }
    }
    this.b -= 1;
    return i;
  }
  
  private void a()
  {
    this.b += 1;
    new w(this.a).a(new ab(this));
    this.b -= 1;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, SecureService.class);
    localIntent.setAction(paramString);
    paramContext.startService(localIntent);
  }
  
  private void a(String paramString, Parcelable paramParcelable)
  {
    if (this.e)
    {
      paramString = new Intent(paramString);
      if (paramParcelable != null) {
        paramString.putExtra("data", paramParcelable);
      }
      sendBroadcast(paramString);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this, SecureEventReceiver.class);
    localIntent.setAction(paramString);
    if (paramParcelable != null) {
      localIntent.putExtra("data", paramParcelable);
    }
    sendBroadcast(localIntent);
  }
  
  private void a(String paramString, Serializable paramSerializable)
  {
    if (!at.a(this.a, 10002, true)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this, SecureEventReceiver.class);
    localIntent.setAction(paramString);
    if (paramSerializable != null) {
      localIntent.putExtra("data", paramSerializable);
    }
    sendBroadcast(localIntent);
  }
  
  private void a(ArrayList<o> paramArrayList, int paramInt)
  {
    o localo = new o();
    localo.a = paramInt;
    localo.c = "1";
    localo.b = ((int)(System.currentTimeMillis() / 1000L));
    paramArrayList.add(localo);
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool1 = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 64).signatures;
      Object localObject = MessageDigest.getInstance("MD5");
      if ((paramContext != null) && (paramContext.length > 0)) {
        ((MessageDigest)localObject).update(paramContext[0].toByteArray());
      }
      paramContext = ((MessageDigest)localObject).digest();
      localObject = new char[16];
      Object tmp58_56 = localObject;
      tmp58_56[0] = 48;
      Object tmp63_58 = tmp58_56;
      tmp63_58[1] = 49;
      Object tmp68_63 = tmp63_58;
      tmp68_63[2] = 50;
      Object tmp73_68 = tmp68_63;
      tmp73_68[3] = 51;
      Object tmp78_73 = tmp73_68;
      tmp78_73[4] = 52;
      Object tmp83_78 = tmp78_73;
      tmp83_78[5] = 53;
      Object tmp88_83 = tmp83_78;
      tmp88_83[6] = 54;
      Object tmp94_88 = tmp88_83;
      tmp94_88[7] = 55;
      Object tmp100_94 = tmp94_88;
      tmp100_94[8] = 56;
      Object tmp106_100 = tmp100_94;
      tmp106_100[9] = 57;
      Object tmp112_106 = tmp106_100;
      tmp112_106[10] = 65;
      Object tmp118_112 = tmp112_106;
      tmp118_112[11] = 66;
      Object tmp124_118 = tmp118_112;
      tmp124_118[12] = 67;
      Object tmp130_124 = tmp124_118;
      tmp130_124[13] = 68;
      Object tmp136_130 = tmp130_124;
      tmp136_130[14] = 69;
      Object tmp142_136 = tmp136_130;
      tmp142_136[15] = 70;
      tmp142_136;
      StringBuilder localStringBuilder = new StringBuilder(paramContext.length * 2);
      int i = 0;
      while (i < paramContext.length)
      {
        localStringBuilder.append(localObject[((paramContext[i] & 0xF0) >>> 4)]);
        localStringBuilder.append(localObject[(paramContext[i] & 0xF)]);
        i += 1;
      }
      if (!"00B1208638DE0FCD3E920886D658DAF6".equalsIgnoreCase(localStringBuilder.toString()))
      {
        boolean bool2 = "7CC749CFC0FB5677E6ABA342EDBDBA5A".equalsIgnoreCase(localStringBuilder.toString());
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private void b()
  {
    this.b += 1;
    x localx = x.a(this.a);
    localx.b();
    this.d = localx.a();
    this.b -= 1;
  }
  
  private void b(String paramString)
  {
    if (this.c) {
      return;
    }
    this.c = true;
    this.b += 1;
    a("1000024", null);
    Object localObject = new ae(this.a);
    ((ae)localObject).a(new aa(this));
    ((ae)localObject).a(1);
    int i;
    do
    {
      i = ((ae)localObject).a(paramString, false);
    } while (i == -7);
    if (i == 0)
    {
      paramString = ((ae)localObject).b();
      localObject = new Bundle();
      ((Bundle)localObject).putString("key_path", paramString);
      a("1000027", (Parcelable)localObject);
      localObject = new Intent("android.intent.action.VIEW");
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
      this.a.startActivity((Intent)localObject);
    }
    this.b -= 1;
    this.c = false;
    this.e = false;
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext()) {
          if ("com.tencent.qqpimsecure".equalsIgnoreCase(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void c()
  {
    try
    {
      Thread.sleep(500L);
      Process.killProcess(Process.myPid());
      System.exit(0);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public static void c(Context paramContext)
  {
    if (paramContext != null)
    {
      Intent localIntent = new Intent();
      localIntent.setClassName("com.tencent.qqpimsecure", "com.tencent.qqpimsecure.service.TMSLiteService");
      paramContext.startService(localIntent);
    }
  }
  
  private void d()
  {
    ah.a(this.a).a(as.b(this.a));
  }
  
  private void e()
  {
    boolean bool1 = a(this.a);
    boolean bool2 = b(this.a);
    ArrayList localArrayList = new ArrayList();
    if (bool1)
    {
      if (!bool2) {
        break label105;
      }
      a(localArrayList, 235002);
    }
    for (;;)
    {
      if ((x.a(this.a).c()) && (bool1) && (!bool2)) {
        c(this.a);
      }
      try
      {
        Thread.sleep(15000L);
        if (b(this.a))
        {
          a(localArrayList, 235006);
          ah.a(this.a).a(localArrayList);
          return;
          label105:
          a(localArrayList, 235003);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
          continue;
          a(localArrayList, 235007);
        }
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.f;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = getApplicationContext();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    if ((paramIntent == null) || ("1000012".equals(paramIntent.getAction()))) {
      return;
    }
    if (!ax.a(getApplicationContext(), "sm_mq"))
    {
      stopSelf();
      c();
      return;
    }
    try
    {
      new Thread(new z(this, paramIntent)).start();
      return;
    }
    finally {}
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (this.b == 0)
    {
      stopSelf();
      c();
    }
    return super.onUnbind(paramIntent);
  }
  
  public class a
    extends Binder
    implements IControlService
  {
    public a() {}
    
    public void doRemoteTask(String paramString, ICallback paramICallback)
    {
      if (!ax.a(SecureService.this.getApplicationContext(), "sm_mq")) {
        return;
      }
      try
      {
        new Thread(new ac(this, paramString, paramICallback)).start();
        return;
      }
      finally {}
    }
    
    public void setIsShowingTips(boolean paramBoolean1, boolean paramBoolean2)
    {
      SecureService.a(SecureService.this, paramBoolean1);
      if (paramBoolean2)
      {
        SecureService.this.stopSelf();
        SecureService.a(SecureService.this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.securemodule.impl.SecureService
 * JD-Core Version:    0.7.0.1
 */