package com.tencent.mobileqq.profile.like;

import alen;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class PraiseManager
  implements Manager
{
  public final List<String> ER;
  public final Vector<Integer> Q;
  public QQAppInterface mApp;
  public Context mContext;
  public final List<WeakReference<a>> mListeners;
  public QQLruCache<Integer, alen> o;
  
  public PraiseManager(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramQQAppInterface.getApp().getApplicationContext();
    this.o = new QQLruCache(2007, 21, 120000);
    this.Q = new Vector();
    this.mListeners = new ArrayList(3);
    this.ER = new ArrayList();
  }
  
  public static void E(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.getApplication().getSharedPreferences("VipPersonalLike", 0).edit().putInt("ProfilePersonalLikeCurrentId_" + paramQQAppInterface.getCurrentAccountUin(), paramInt).commit();
  }
  
  public static int f(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return 0;
    }
    return paramAppInterface.getApplication().getSharedPreferences("VipPersonalLike", 0).getInt("ProfilePersonalLikeCurrentId_" + paramAppInterface.getCurrentAccountUin(), 0);
  }
  
  public alen a(int paramInt, boolean paramBoolean, String paramString)
  {
    Object localObject;
    if (paramInt <= 0) {
      localObject = null;
    }
    alen localalen;
    do
    {
      return localObject;
      localalen = (alen)this.o.get(Integer.valueOf(paramInt));
      if (localalen == null) {
        break;
      }
      localObject = localalen;
    } while (!QLog.isColorLevel());
    QLog.d("PraiseManager", 2, "get praise info from cache, id=" + paramInt + " from:" + paramString);
    return localalen;
    if (!this.Q.contains(Integer.valueOf(paramInt)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PraiseManager", 2, "start create praise info, id=" + paramInt);
      }
      this.Q.add(Integer.valueOf(paramInt));
      ThreadManager.executeOnFileThread(new PraiseManager.1(this, paramInt, paramBoolean, paramString));
    }
    return null;
  }
  
  public void a(a parama)
  {
    synchronized (this.mListeners)
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() == parama)) {
          return;
        }
      }
      this.mListeners.add(new WeakReference(parama));
      return;
    }
  }
  
  boolean a(alen paramalen)
  {
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inDensity = 320;
    ((BitmapFactory.Options)localObject1).inTargetDensity = this.mContext.getResources().getDisplayMetrics().densityDpi;
    Object localObject2 = BubbleManager.decodeFile(paramalen.bWa, (BitmapFactory.Options)localObject1);
    if (localObject2 == null) {}
    do
    {
      return false;
      paramalen.fQ = ((Bitmap)localObject2);
      localObject2 = BubbleManager.decodeFile(paramalen.bWb, (BitmapFactory.Options)localObject1);
    } while (localObject2 == null);
    paramalen.fR = ((Bitmap)localObject2);
    paramalen.fS = BubbleManager.decodeFile(paramalen.bWc, (BitmapFactory.Options)localObject1);
    localObject1 = f(paramalen.id).getAbsolutePath();
    localObject2 = (String)localObject1 + File.separator + "dynamicImg.png";
    if (new File((String)localObject2).exists()) {
      paramalen.bWd = ((String)localObject2);
    }
    localObject1 = (String)localObject1 + File.separator + "goldDynamicImg.png";
    if (new File((String)localObject1).exists()) {
      paramalen.bWe = ((String)localObject1);
    }
    return true;
  }
  
  public boolean a(Set<Integer> paramSet, a parama)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return true;
    }
    c localc = new c();
    localc.total = paramSet.size();
    localc.a = parama;
    parama = paramSet.iterator();
    while (parama.hasNext())
    {
      int i = ((Integer)parama.next()).intValue();
      if (this.o.get(Integer.valueOf(i)) == null)
      {
        a(localc);
        a(i, true, "from_load_all");
      }
      else
      {
        localc.count += 1;
      }
    }
    return localc.count == paramSet.size();
  }
  
  public void b(a parama)
  {
    List localList = this.mListeners;
    Object localObject = null;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.mListeners.iterator();
        if (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference != null) && (localWeakReference.get() == parama)) {
            localObject = localWeakReference;
          }
        }
        else
        {
          this.mListeners.remove(localObject);
          return;
        }
      }
      finally {}
    }
  }
  
  boolean b(alen paramalen)
  {
    return (new File(paramalen.bWa).exists()) && (new File(paramalen.bWb).exists());
  }
  
  public int dI(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("\\.");
      if (paramString.length == 5)
      {
        paramString = paramString[2];
        try
        {
          int i = Integer.parseInt(paramString);
          return i;
        }
        catch (NumberFormatException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PraiseManager", 2, "getBubbleIdFromScid: parse bubbleId error", paramString);
          }
        }
      }
    }
    return 0;
  }
  
  void dw(int paramInt, String paramString)
  {
    if (paramInt == 0) {}
    String str;
    VasQuickUpdateManager localVasQuickUpdateManager;
    do
    {
      return;
      str = "praise.android." + paramInt + "." + "config.zip";
      localVasQuickUpdateManager = (VasQuickUpdateManager)this.mApp.getManager(184);
    } while (localVasQuickUpdateManager == null);
    synchronized (this.ER)
    {
      if (this.ER.contains(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PraiseManager", 2, str + " is downloading, remove duplicate download.");
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PraiseManager", 2, str + " is not download, start download.");
    }
    this.ER.add(str);
    localVasQuickUpdateManager.downloadItem(20L, str, paramString);
  }
  
  /* Error */
  public void e(String paramString1, String arg2, String paramString3, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +31 -> 34
    //   6: ldc 154
    //   8: iconst_2
    //   9: ldc_w 391
    //   12: iconst_2
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload_1
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: iload 4
    //   24: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: invokestatic 395	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   31: invokestatic 398	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_1
    //   35: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifne +324 -> 362
    //   41: aload_1
    //   42: ldc_w 365
    //   45: invokevirtual 402	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   48: ifne +4 -> 52
    //   51: return
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual 404	com/tencent/mobileqq/profile/like/PraiseManager:dI	(Ljava/lang/String;)I
    //   57: istore 5
    //   59: aload_0
    //   60: getfield 77	com/tencent/mobileqq/profile/like/PraiseManager:ER	Ljava/util/List;
    //   63: astore_2
    //   64: aload_2
    //   65: monitorenter
    //   66: aload_0
    //   67: getfield 77	com/tencent/mobileqq/profile/like/PraiseManager:ER	Ljava/util/List;
    //   70: aload_1
    //   71: invokeinterface 376 2 0
    //   76: ifeq +46 -> 122
    //   79: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +29 -> 111
    //   85: ldc 154
    //   87: iconst_2
    //   88: new 100	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   95: aload_1
    //   96: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc_w 406
    //   102: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_0
    //   112: getfield 77	com/tencent/mobileqq/profile/like/PraiseManager:ER	Ljava/util/List;
    //   115: aload_1
    //   116: invokeinterface 335 2 0
    //   121: pop
    //   122: aload_2
    //   123: monitorexit
    //   124: iload 4
    //   126: ifne +186 -> 312
    //   129: aload_0
    //   130: iload 5
    //   132: invokevirtual 269	com/tencent/mobileqq/profile/like/PraiseManager:f	(I)Ljava/io/File;
    //   135: invokevirtual 274	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   138: astore_1
    //   139: iload 5
    //   141: invokestatic 279	wja:b	()Ljava/lang/StringBuilder;
    //   144: aload_1
    //   145: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: getstatic 282	java/io/File:separator	Ljava/lang/String;
    //   151: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 408
    //   157: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 411	alen:a	(ILjava/lang/String;)Lalen;
    //   166: astore_2
    //   167: aload_2
    //   168: ifnull +144 -> 312
    //   171: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +30 -> 204
    //   177: ldc 154
    //   179: iconst_2
    //   180: new 100	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   187: ldc_w 413
    //   190: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: iload 5
    //   195: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload_2
    //   205: invokestatic 279	wja:b	()Ljava/lang/StringBuilder;
    //   208: aload_1
    //   209: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: getstatic 282	java/io/File:separator	Ljava/lang/String;
    //   215: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 415
    //   221: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: putfield 241	alen:bWa	Ljava/lang/String;
    //   230: aload_2
    //   231: invokestatic 279	wja:b	()Ljava/lang/StringBuilder;
    //   234: aload_1
    //   235: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: getstatic 282	java/io/File:separator	Ljava/lang/String;
    //   241: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc_w 417
    //   247: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: putfield 254	alen:bWb	Ljava/lang/String;
    //   256: aload_2
    //   257: invokestatic 279	wja:b	()Ljava/lang/StringBuilder;
    //   260: aload_1
    //   261: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: getstatic 282	java/io/File:separator	Ljava/lang/String;
    //   267: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc_w 419
    //   273: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: putfield 260	alen:bWc	Ljava/lang/String;
    //   282: aload_0
    //   283: aload_2
    //   284: invokevirtual 421	com/tencent/mobileqq/profile/like/PraiseManager:b	(Lalen;)Z
    //   287: ifeq +25 -> 312
    //   290: aload_0
    //   291: aload_2
    //   292: invokevirtual 423	com/tencent/mobileqq/profile/like/PraiseManager:a	(Lalen;)Z
    //   295: ifeq +17 -> 312
    //   298: aload_0
    //   299: getfield 62	com/tencent/mobileqq/profile/like/PraiseManager:o	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   302: iload 5
    //   304: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   307: aload_2
    //   308: invokevirtual 427	com/tencent/commonsdk/cache/QQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   311: pop
    //   312: aload_0
    //   313: getfield 40	com/tencent/mobileqq/profile/like/PraiseManager:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   316: new 8	com/tencent/mobileqq/profile/like/PraiseManager$LoadCallback
    //   319: dup
    //   320: aload_0
    //   321: iload 5
    //   323: iconst_1
    //   324: aload_3
    //   325: invokespecial 430	com/tencent/mobileqq/profile/like/PraiseManager$LoadCallback:<init>	(Lcom/tencent/mobileqq/profile/like/PraiseManager;IILjava/lang/String;)V
    //   328: invokevirtual 433	com/tencent/mobileqq/app/QQAppInterface:runOnUiThread	(Ljava/lang/Runnable;)V
    //   331: aload_0
    //   332: getfield 67	com/tencent/mobileqq/profile/like/PraiseManager:Q	Ljava/util/Vector;
    //   335: iload 5
    //   337: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   340: invokevirtual 436	java/util/Vector:removeElement	(Ljava/lang/Object;)Z
    //   343: pop
    //   344: return
    //   345: astore_1
    //   346: ldc 154
    //   348: iconst_1
    //   349: ldc_w 438
    //   352: aload_1
    //   353: invokestatic 361	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   356: return
    //   357: astore_1
    //   358: aload_2
    //   359: monitorexit
    //   360: aload_1
    //   361: athrow
    //   362: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	PraiseManager
    //   0	363	1	paramString1	String
    //   0	363	3	paramString3	String
    //   0	363	4	paramInt1	int
    //   0	363	5	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   0	34	345	java/lang/Exception
    //   34	51	345	java/lang/Exception
    //   52	66	345	java/lang/Exception
    //   129	167	345	java/lang/Exception
    //   171	204	345	java/lang/Exception
    //   204	312	345	java/lang/Exception
    //   312	344	345	java/lang/Exception
    //   360	362	345	java/lang/Exception
    //   66	111	357	finally
    //   111	122	357	finally
    //   122	124	357	finally
    //   358	360	357	finally
  }
  
  public File f(int paramInt)
  {
    File localFile = new File(new File(this.mContext.getFilesDir(), "praise_info"), String.valueOf(paramInt));
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  void f(int paramInt, boolean paramBoolean, String paramString)
  {
    String str = f(paramInt).getAbsolutePath();
    alen localalen = alen.a(paramInt, str + File.separator + "config.json");
    Boolean localBoolean = null;
    if (localalen != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PraiseManager", 2, "createPraiseInfo from local, id=" + paramInt + " from:" + paramString);
      }
      localalen.bWa = (str + File.separator + "whiteBlackImg.png");
      localalen.bWb = (str + File.separator + "colorImg.png");
      localalen.bWc = (str + File.separator + "goldImg.png");
      if (!b(localalen)) {
        if (paramBoolean) {
          dw(paramInt, paramString);
        }
      }
    }
    for (;;)
    {
      if (localBoolean != null)
      {
        this.mApp.runOnUiThread(new LoadCallback(paramInt, 0, paramString));
        this.Q.removeElement(Integer.valueOf(paramInt));
      }
      return;
      localBoolean = Boolean.valueOf(false);
      continue;
      if (a(localalen))
      {
        this.o.put(Integer.valueOf(paramInt), localalen);
        localBoolean = Boolean.valueOf(true);
      }
      else
      {
        localBoolean = Boolean.valueOf(false);
        continue;
        if (paramBoolean) {
          dw(paramInt, paramString);
        } else {
          localBoolean = Boolean.valueOf(false);
        }
      }
    }
  }
  
  public boolean isFileExists(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PraiseManager", 2, "scid isFileExists: " + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("praise.android."))) {}
    do
    {
      int i;
      do
      {
        return false;
        i = dI(paramString);
      } while (i <= 0);
      paramString = f(i);
    } while ((!new File(paramString, "config.json").exists()) || (!new File(paramString, "whiteBlackImg.png").exists()) || (!new File(paramString, "colorImg.png").exists()));
    return true;
  }
  
  public void onDestroy()
  {
    this.o.evictAll();
  }
  
  public class LoadCallback
    implements Runnable
  {
    public int dsG;
    public String from;
    public int id;
    
    public LoadCallback(int paramInt1, int paramInt2, String paramString)
    {
      this.id = paramInt1;
      this.dsG = paramInt2;
      this.from = paramString;
    }
    
    public void run()
    {
      for (;;)
      {
        WeakReference[] arrayOfWeakReference;
        synchronized (PraiseManager.this.mListeners)
        {
          if (PraiseManager.this.mListeners.isEmpty()) {
            break label186;
          }
          arrayOfWeakReference = (WeakReference[])Array.newInstance(((WeakReference)PraiseManager.this.mListeners.get(0)).getClass(), PraiseManager.this.mListeners.size());
          PraiseManager.this.mListeners.toArray(arrayOfWeakReference);
          if (arrayOfWeakReference == null) {
            break label185;
          }
        }
        try
        {
          int j = arrayOfWeakReference.length;
          int i = 0;
          while (i < j)
          {
            ??? = arrayOfWeakReference[i];
            if ((??? != null) && (???.get() != null)) {
              ((PraiseManager.a)???.get()).a(this.id, (alen)PraiseManager.this.o.get(Integer.valueOf(this.id)), this.dsG, this.from);
            }
            i += 1;
            continue;
            localObject1 = finally;
            throw localObject1;
          }
        }
        catch (Exception localException)
        {
          QLog.e("PraiseManager", 1, "LoadCallback failed", localException);
        }
        label185:
        return;
        label186:
        Object localObject2 = null;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, alen paramalen, int paramInt2, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle);
  }
  
  class c
    implements PraiseManager.a
  {
    public PraiseManager.a a;
    public int count;
    public int total;
    
    c() {}
    
    public void a(int paramInt1, alen paramalen, int paramInt2, String paramString)
    {
      paramInt1 = this.count + 1;
      this.count = paramInt1;
      if (paramInt1 == this.total)
      {
        PraiseManager.this.b(this);
        if (this.a != null) {
          this.a.a(0, null, 0, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.like.PraiseManager
 * JD-Core Version:    0.7.0.1
 */