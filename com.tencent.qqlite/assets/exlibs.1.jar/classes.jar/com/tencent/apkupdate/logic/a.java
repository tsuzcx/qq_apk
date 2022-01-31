package com.tencent.apkupdate.logic;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.apkupdate.ApkUpdateListener;
import com.tencent.apkupdate.ApkUpdateParam;
import com.tencent.apkupdate.logic.protocol.jce.ApkFileInfo;
import com.tencent.apkupdate.logic.protocol.jce.AppInfoForUpdate;
import com.tencent.apkupdate.logic.protocol.jce.AppUpdateInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  extends Handler
{
  private static HandlerThread a;
  private static a b;
  private final ArrayList c = new ArrayList();
  private ConcurrentHashMap d = new ConcurrentHashMap();
  private final HashMap e = new HashMap();
  
  private a(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private int a(List paramList)
  {
    int j = 0;
    int i = j;
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        i = paramList.size();
        if (i <= 0)
        {
          i = j;
          return i;
        }
        PackageManager localPackageManager = com.tencent.apkupdate.logic.protocol.b.a().b().getPackageManager();
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          paramList = (AppUpdateInfo)localIterator.next();
          boolean bool = this.e.containsKey(paramList.packageName);
          if (!bool) {
            try
            {
              PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramList.packageName, 0);
              com.tencent.apkupdate.a.a locala = new com.tencent.apkupdate.a.a();
              locala.a(localPackageInfo.applicationInfo.sourceDir);
              ApkFileInfo localApkFileInfo = new ApkFileInfo();
              localApkFileInfo.packageName = localPackageInfo.packageName;
              localApkFileInfo.apkId = paramList.apkId;
              String str = (String)this.d.get(localPackageInfo.packageName);
              paramList = str;
              if (TextUtils.isEmpty(str)) {
                paramList = com.tencent.apkupdate.logic.protocol.b.a(localPackageInfo.packageName).toLowerCase();
              }
              localApkFileInfo.manifestMd5 = paramList;
              localApkFileInfo.fileCRC32 = locala.a();
              this.e.put(localApkFileInfo.packageName, localApkFileInfo);
            }
            catch (PackageManager.NameNotFoundException paramList)
            {
              paramList.printStackTrace();
            }
          }
        }
        else
        {
          i = this.e.size();
        }
      }
      finally {}
    }
  }
  
  public static a a()
  {
    try
    {
      if (b == null)
      {
        localObject1 = new HandlerThread("apkupdate_asyctask");
        a = (HandlerThread)localObject1;
        ((HandlerThread)localObject1).setPriority(10);
        a.start();
        b = new a(a.getLooper());
      }
      Object localObject1 = b;
      return localObject1;
    }
    finally {}
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/tencent/apkupdate/logic/a:e	Ljava/util/HashMap;
    //   6: invokevirtual 153	java/util/HashMap:size	()I
    //   9: istore_1
    //   10: iload_1
    //   11: ifgt +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: new 20	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 23	java/util/ArrayList:<init>	()V
    //   24: astore_2
    //   25: aload_2
    //   26: aload_0
    //   27: getfield 35	com/tencent/apkupdate/logic/a:e	Ljava/util/HashMap;
    //   30: aload_0
    //   31: getfield 35	com/tencent/apkupdate/logic/a:e	Ljava/util/HashMap;
    //   34: invokevirtual 180	java/util/HashMap:keySet	()Ljava/util/Set;
    //   37: invokeinterface 183 1 0
    //   42: invokeinterface 73 1 0
    //   47: invokevirtual 184	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   50: checkcast 108	com/tencent/apkupdate/logic/protocol/jce/ApkFileInfo
    //   53: invokevirtual 187	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   56: pop
    //   57: invokestatic 50	com/tencent/apkupdate/logic/protocol/b:a	()Lcom/tencent/apkupdate/logic/protocol/b;
    //   60: new 189	com/tencent/apkupdate/logic/protocol/a/b
    //   63: dup
    //   64: aload_2
    //   65: invokespecial 192	com/tencent/apkupdate/logic/protocol/a/b:<init>	(Ljava/util/List;)V
    //   68: invokevirtual 195	com/tencent/apkupdate/logic/protocol/b:a	(Ljava/lang/Runnable;)V
    //   71: goto -57 -> 14
    //   74: astore_2
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_2
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	a
    //   9	2	1	i	int
    //   24	41	2	localArrayList	ArrayList
    //   74	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	74	finally
    //   17	71	74	finally
  }
  
  public final void a(ApkUpdateListener paramApkUpdateListener)
  {
    if (!this.c.contains(paramApkUpdateListener)) {
      this.c.add(paramApkUpdateListener);
    }
  }
  
  public final void b(ApkUpdateListener paramApkUpdateListener)
  {
    if (paramApkUpdateListener == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        if ((ApkUpdateListener)localIterator.next() == paramApkUpdateListener) {
          localIterator.remove();
        }
      }
    }
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    label404:
    do
    {
      Object localObject1;
      do
      {
        do
        {
          for (;;)
          {
            return;
            localObject1 = this.c.iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((ApkUpdateListener)((Iterator)localObject1).next()).onCheckUpdateSucceed((ArrayList)paramMessage.obj);
            }
            continue;
            paramMessage = this.c.iterator();
            while (paramMessage.hasNext()) {
              ((ApkUpdateListener)paramMessage.next()).onCheckUpdateFailed("UNKOWN");
            }
          }
          localObject2 = (List)paramMessage.obj;
        } while (localObject2 == null);
        paramMessage = new ArrayList();
        localObject1 = com.tencent.apkupdate.logic.protocol.b.a().b().getPackageManager();
        long l1 = System.currentTimeMillis();
        Object localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (ApkUpdateParam)((Iterator)localObject2).next();
          String str = ((ApkUpdateParam)localObject3).packageName;
          int i = ((ApkUpdateParam)localObject3).actionFlag;
          int j = ((ApkUpdateParam)localObject3).targetVersionCode;
          int k = ((ApkUpdateParam)localObject3).targetGrayVersionCode;
          if (!TextUtils.isEmpty(str)) {
            for (;;)
            {
              AppInfoForUpdate localAppInfoForUpdate;
              try
              {
                localObject3 = ((PackageManager)localObject1).getPackageInfo(str, 0);
                if (localObject3 == null) {
                  break;
                }
                localAppInfoForUpdate = new AppInfoForUpdate();
                localAppInfoForUpdate.packageName = str;
                localAppInfoForUpdate.versionCode = ((PackageInfo)localObject3).versionCode;
                localAppInfoForUpdate.signatureMd5 = com.tencent.apkupdate.logic.protocol.b.a().b(str);
                localAppInfoForUpdate.manifestMd5 = com.tencent.apkupdate.logic.protocol.b.a(str).toLowerCase();
                this.d.put(str, localAppInfoForUpdate.manifestMd5);
                if ((((PackageInfo)localObject3).applicationInfo.flags & 0x1) > 0) {
                  break label404;
                }
                localAppInfoForUpdate.appType = 1;
                localAppInfoForUpdate.versionName = ((PackageInfo)localObject3).versionName;
                localAppInfoForUpdate.actionFlag = ((byte)i);
                localAppInfoForUpdate.grayVersionCode = com.tencent.apkupdate.c.b.a().a(str);
                localAppInfoForUpdate.targetVersionCode = j;
                localAppInfoForUpdate.targetGrayVersionCode = k;
                paramMessage.add(localAppInfoForUpdate);
              }
              catch (PackageManager.NameNotFoundException localNameNotFoundException)
              {
                localNameNotFoundException.printStackTrace();
              }
              break;
              localAppInfoForUpdate.appType = 2;
            }
          }
        }
        long l2 = System.currentTimeMillis();
        Log.i("updatecost----------", "updatecost=" + (l2 - l1));
        if (paramMessage.size() > 0)
        {
          localObject1 = a().obtainMessage();
          ((Message)localObject1).what = 6;
          ((Message)localObject1).obj = paramMessage;
          ((Message)localObject1).sendToTarget();
          return;
        }
        paramMessage = a().obtainMessage();
        paramMessage.what = 2;
        paramMessage.sendToTarget();
        return;
        paramMessage = (ArrayList)paramMessage.obj;
        com.tencent.apkupdate.logic.protocol.b.a().a(new com.tencent.apkupdate.logic.protocol.a.a(paramMessage));
        return;
      } while (a((ArrayList)paramMessage.obj) <= 0);
      paramMessage = a().obtainMessage();
      paramMessage.what = 8;
      paramMessage.obj = null;
      paramMessage.sendToTarget();
      return;
      if (paramMessage.obj == null)
      {
        b();
        return;
      }
      paramMessage = ((ArrayList)paramMessage.obj).iterator();
      while (paramMessage.hasNext())
      {
        localObject1 = (String)paramMessage.next();
        a().e.remove(localObject1);
      }
    } while (a().e.isEmpty());
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.apkupdate.logic.a
 * JD-Core Version:    0.7.0.1
 */