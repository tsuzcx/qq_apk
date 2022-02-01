package com.tencent.mobileqq.freshnews.feed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import aomc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import wja;

public class NearbyImgLoader
{
  private static NearbyImgLoader jdField_a_of_type_ComTencentMobileqqFreshnewsFeedNearbyImgLoader = new NearbyImgLoader();
  public static int daA;
  public static int daz;
  public static int densityDpi;
  public List<URL> Cc = new ArrayList();
  aomc jdField_a_of_type_Aomc = new aomc();
  AtomicInteger bo = new AtomicInteger();
  ArrayList<a> callbacks = new ArrayList();
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    int i = ((WindowManager)localBaseApplication.getSystemService("window")).getDefaultDisplay().getWidth();
    daA = (i - wja.dp2px(2.0F, localBaseApplication.getResources())) / 2;
    daz = i;
    densityDpi = localBaseApplication.getResources().getDisplayMetrics().densityDpi;
  }
  
  public static NearbyImgLoader a()
  {
    return jdField_a_of_type_ComTencentMobileqqFreshnewsFeedNearbyImgLoader;
  }
  
  public Pair<Bitmap, Boolean> a(String paramString, Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return null;
    }
    paramBitmap.setDensity(densityDpi);
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      i = 0;
      j = 0;
    }
    int k;
    int m;
    for (;;)
    {
      k = paramBitmap.getWidth();
      m = paramBitmap.getHeight();
      if ((k != j) || (m != i)) {
        break;
      }
      return new Pair(paramBitmap, Boolean.valueOf(true));
      j = daz;
      i = daz * 3 / 4;
      continue;
      j = daz;
      i = daz / 2;
      continue;
      i = daA;
      j = daA;
    }
    float f;
    if (k > m) {
      if ((paramInt == 1) || (paramInt == 2))
      {
        f = j / k;
        paramString = paramBitmap;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new Matrix();
        paramString = paramBitmap;
        ((Matrix)localObject).setScale(f, f);
        paramString = paramBitmap;
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, k, m, (Matrix)localObject, false);
        if (paramBitmap != localObject) {
          paramString = (String)localObject;
        }
      }
      catch (Throwable paramBitmap)
      {
        Object localObject;
        continue;
      }
      try
      {
        paramBitmap.recycle();
        paramString = (String)localObject;
        ((Bitmap)localObject).getWidth();
        paramString = (String)localObject;
        paramInt = ((Bitmap)localObject).getHeight();
        paramString = (String)localObject;
        if (paramInt <= i) {
          break label794;
        }
        paramString = (String)localObject;
        paramBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, (paramInt - i) / 2, j, i);
        paramString = paramBitmap;
        if (localObject != paramBitmap) {
          paramString = paramBitmap;
        }
      }
      catch (Throwable paramBitmap)
      {
        continue;
        continue;
        continue;
      }
      try
      {
        ((Bitmap)localObject).recycle();
        paramString = paramBitmap;
        if (paramString != null) {
          paramString.setDensity(densityDpi);
        }
        return new Pair(paramString, Boolean.valueOf(true));
      }
      catch (Throwable paramBitmap) {}
      paramString = paramBitmap;
      if (paramInt != 3) {
        break label791;
      }
      f = i / m;
      paramString = paramBitmap;
      localObject = new Matrix();
      paramString = paramBitmap;
      ((Matrix)localObject).setScale(f, f);
      paramString = paramBitmap;
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, k, m, (Matrix)localObject, false);
      if (paramBitmap != localObject)
      {
        paramString = (String)localObject;
        paramBitmap.recycle();
      }
      paramString = (String)localObject;
      paramInt = ((Bitmap)localObject).getWidth();
      paramString = (String)localObject;
      ((Bitmap)localObject).getHeight();
      paramString = (String)localObject;
      if (paramInt <= j) {
        break label794;
      }
      paramString = (String)localObject;
      paramBitmap = Bitmap.createBitmap((Bitmap)localObject, (paramInt - j) / 2, 0, j, i);
      paramString = paramBitmap;
      if (localObject != paramBitmap)
      {
        paramString = paramBitmap;
        ((Bitmap)localObject).recycle();
        paramString = paramBitmap;
        continue;
        paramBitmap.printStackTrace();
        System.gc();
        return new Pair(paramString, Boolean.valueOf(false));
        f = j / k;
        paramString = paramBitmap;
        localObject = new Matrix();
        paramString = paramBitmap;
        ((Matrix)localObject).setScale(f, f);
        paramString = paramBitmap;
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, k, m, (Matrix)localObject, false);
        paramString = (String)localObject;
        i = ((Bitmap)localObject).getWidth();
        paramString = (String)localObject;
        j = ((Bitmap)localObject).getHeight();
        if (paramInt == 1)
        {
          paramString = (String)localObject;
          if (j / 3 >= i * 3 / 8)
          {
            paramString = (String)localObject;
            paramBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, j / 3 - i * 3 / 8, i, i * 3 / 4);
            paramString = paramBitmap;
            if (localObject != paramBitmap)
            {
              paramString = paramBitmap;
              ((Bitmap)localObject).recycle();
              paramString = paramBitmap;
            }
          }
          else
          {
            paramString = (String)localObject;
            paramBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, 0, i, i * 3 / 4);
            paramString = paramBitmap;
            if (localObject != paramBitmap)
            {
              paramString = paramBitmap;
              ((Bitmap)localObject).recycle();
              paramString = paramBitmap;
            }
          }
        }
        else if (paramInt == 2)
        {
          paramString = (String)localObject;
          paramBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, j / 3 - i / 4, i, i / 2);
          paramString = paramBitmap;
          if (localObject != paramBitmap)
          {
            paramString = paramBitmap;
            ((Bitmap)localObject).recycle();
            paramString = paramBitmap;
          }
        }
        else
        {
          paramString = (String)localObject;
          if (paramInt != 3) {
            break label791;
          }
          paramString = (String)localObject;
          if (i >= j * 2 / 3)
          {
            paramString = (String)localObject;
            paramBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, 0, i, i);
            paramString = paramBitmap;
            if (localObject != paramBitmap)
            {
              paramString = paramBitmap;
              ((Bitmap)localObject).recycle();
              paramString = paramBitmap;
            }
          }
          else
          {
            paramString = (String)localObject;
            paramBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, j * 1 / 3 - i / 2, i, i);
            paramString = paramBitmap;
            if (localObject != paramBitmap)
            {
              paramString = paramBitmap;
              ((Bitmap)localObject).recycle();
              paramString = paramBitmap;
            }
          }
        }
      }
    }
  }
  
  public void b(URL paramURL)
  {
    synchronized (this.Cc)
    {
      if (!this.Cc.contains(paramURL)) {
        this.Cc.add(paramURL);
      }
      dpp();
      return;
    }
  }
  
  void dpp()
  {
    if (this.bo.get() < 4) {}
    for (;;)
    {
      synchronized (this.Cc)
      {
        if (this.Cc.size() <= 0) {
          break label113;
        }
        URL localURL = (URL)this.Cc.remove(this.Cc.size() - 1);
        if (localURL != null)
        {
          ThreadManager.post(new RequestLoadedImgTask(localURL), 8, null, true);
          return;
        }
      }
      synchronized (this.Cc)
      {
        if (this.Cc.size() > 0) {
          dpp();
        }
        return;
      }
      label113:
      ??? = null;
    }
  }
  
  public void release()
  {
    synchronized (this.Cc)
    {
      this.Cc.clear();
    }
    synchronized (this.callbacks)
    {
      this.callbacks.clear();
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public class RequestLoadedImgTask
    implements Runnable
  {
    int daB = 0;
    URL url;
    
    public RequestLoadedImgTask(URL paramURL)
    {
      NearbyImgLoader.this.bo.getAndIncrement();
      this.url = paramURL;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 36	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:url	Ljava/net/URL;
      //   4: ifnull +270 -> 274
      //   7: new 44	com/tencent/image/DownloadParams
      //   10: dup
      //   11: invokespecial 45	com/tencent/image/DownloadParams:<init>	()V
      //   14: astore_1
      //   15: aload_1
      //   16: aload_0
      //   17: getfield 36	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:url	Ljava/net/URL;
      //   20: putfield 46	com/tencent/image/DownloadParams:url	Ljava/net/URL;
      //   23: aload_1
      //   24: aload_0
      //   25: getfield 36	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:url	Ljava/net/URL;
      //   28: invokevirtual 52	java/net/URL:toString	()Ljava/lang/String;
      //   31: putfield 56	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
      //   34: aload_1
      //   35: getfield 56	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
      //   38: astore_3
      //   39: new 58	ahpg
      //   42: dup
      //   43: aload_0
      //   44: invokespecial 61	ahpg:<init>	(Lcom/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask;)V
      //   47: astore_2
      //   48: aload_0
      //   49: getfield 19	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:this$0	Lcom/tencent/mobileqq/freshnews/feed/NearbyImgLoader;
      //   52: getfield 65	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader:a	Laomc;
      //   55: aload_1
      //   56: aload_2
      //   57: invokevirtual 71	aomc:loadImageFile	(Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
      //   60: astore 4
      //   62: aconst_null
      //   63: astore_2
      //   64: aload_2
      //   65: astore_1
      //   66: aload 4
      //   68: invokevirtual 77	java/io/File:exists	()Z
      //   71: ifeq +104 -> 175
      //   74: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   77: ifeq +34 -> 111
      //   80: ldc 84
      //   82: iconst_2
      //   83: new 86	java/lang/StringBuilder
      //   86: dup
      //   87: invokespecial 87	java/lang/StringBuilder:<init>	()V
      //   90: ldc 89
      //   92: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   95: aload_0
      //   96: getfield 36	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:url	Ljava/net/URL;
      //   99: invokevirtual 52	java/net/URL:toString	()Ljava/lang/String;
      //   102: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   105: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   108: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   111: new 100	android/graphics/BitmapFactory$Options
      //   114: dup
      //   115: invokespecial 101	android/graphics/BitmapFactory$Options:<init>	()V
      //   118: astore_1
      //   119: aload_1
      //   120: iconst_1
      //   121: putfield 105	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
      //   124: aload 4
      //   126: invokevirtual 108	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   129: aload_1
      //   130: invokestatic 113	aqhu:d	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   133: pop
      //   134: aload_1
      //   135: getfield 116	android/graphics/BitmapFactory$Options:outWidth	I
      //   138: i2l
      //   139: invokestatic 122	aqgz:hK	()J
      //   142: lcmp
      //   143: ifle +17 -> 160
      //   146: aload_1
      //   147: invokestatic 122	aqgz:hK	()J
      //   150: aload_1
      //   151: getfield 116	android/graphics/BitmapFactory$Options:outWidth	I
      //   154: i2l
      //   155: ldiv
      //   156: l2i
      //   157: putfield 125	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   160: aload_1
      //   161: iconst_0
      //   162: putfield 105	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
      //   165: aload 4
      //   167: invokevirtual 108	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   170: aload_1
      //   171: invokestatic 113	aqhu:d	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   174: astore_1
      //   175: aload_0
      //   176: getfield 19	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:this$0	Lcom/tencent/mobileqq/freshnews/feed/NearbyImgLoader;
      //   179: getfield 129	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader:callbacks	Ljava/util/ArrayList;
      //   182: astore_2
      //   183: aload_2
      //   184: monitorenter
      //   185: aload_0
      //   186: getfield 19	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:this$0	Lcom/tencent/mobileqq/freshnews/feed/NearbyImgLoader;
      //   189: getfield 129	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader:callbacks	Ljava/util/ArrayList;
      //   192: invokevirtual 135	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   195: astore 4
      //   197: aload 4
      //   199: invokeinterface 140 1 0
      //   204: ifeq +146 -> 350
      //   207: aload 4
      //   209: invokeinterface 144 1 0
      //   214: checkcast 146	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$a
      //   217: astore 5
      //   219: aload 5
      //   221: ifnull -24 -> 197
      //   224: aload_1
      //   225: ifnonnull +113 -> 338
      //   228: aload_0
      //   229: getfield 24	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:daB	I
      //   232: iconst_3
      //   233: if_icmpge +94 -> 327
      //   236: aload_0
      //   237: getfield 19	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:this$0	Lcom/tencent/mobileqq/freshnews/feed/NearbyImgLoader;
      //   240: new 48	java/net/URL
      //   243: dup
      //   244: aload_3
      //   245: invokespecial 149	java/net/URL:<init>	(Ljava/lang/String;)V
      //   248: invokevirtual 153	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader:b	(Ljava/net/URL;)V
      //   251: aload_0
      //   252: aload_0
      //   253: getfield 24	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:daB	I
      //   256: iconst_1
      //   257: iadd
      //   258: putfield 24	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:daB	I
      //   261: goto -64 -> 197
      //   264: astore_1
      //   265: aload_2
      //   266: monitorexit
      //   267: aload_1
      //   268: athrow
      //   269: astore_1
      //   270: aload_1
      //   271: invokevirtual 156	java/lang/Exception:printStackTrace	()V
      //   274: aload_0
      //   275: getfield 19	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:this$0	Lcom/tencent/mobileqq/freshnews/feed/NearbyImgLoader;
      //   278: getfield 28	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader:bo	Ljava/util/concurrent/atomic/AtomicInteger;
      //   281: invokevirtual 159	java/util/concurrent/atomic/AtomicInteger:getAndDecrement	()I
      //   284: pop
      //   285: aload_0
      //   286: getfield 19	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:this$0	Lcom/tencent/mobileqq/freshnews/feed/NearbyImgLoader;
      //   289: invokevirtual 162	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader:dpp	()V
      //   292: return
      //   293: astore 5
      //   295: aload 5
      //   297: invokevirtual 163	java/lang/OutOfMemoryError:printStackTrace	()V
      //   300: goto -166 -> 134
      //   303: astore_1
      //   304: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   307: ifeq +11 -> 318
      //   310: ldc 84
      //   312: iconst_2
      //   313: ldc 165
      //   315: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   318: aload_1
      //   319: invokevirtual 163	java/lang/OutOfMemoryError:printStackTrace	()V
      //   322: aload_2
      //   323: astore_1
      //   324: goto -149 -> 175
      //   327: aload 5
      //   329: aload_3
      //   330: invokeinterface 168 2 0
      //   335: goto -138 -> 197
      //   338: aload 5
      //   340: aload_3
      //   341: aload_1
      //   342: invokeinterface 172 3 0
      //   347: goto -150 -> 197
      //   350: aload_2
      //   351: monitorexit
      //   352: goto -78 -> 274
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	355	0	this	RequestLoadedImgTask
      //   14	211	1	localObject1	Object
      //   264	4	1	localObject2	Object
      //   269	2	1	localException	java.lang.Exception
      //   303	16	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
      //   323	19	1	localObject3	Object
      //   38	303	3	str	String
      //   60	148	4	localObject5	Object
      //   217	3	5	locala	NearbyImgLoader.a
      //   293	46	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
      // Exception table:
      //   from	to	target	type
      //   185	197	264	finally
      //   197	219	264	finally
      //   228	261	264	finally
      //   265	267	264	finally
      //   327	335	264	finally
      //   338	347	264	finally
      //   350	352	264	finally
      //   48	62	269	java/lang/Exception
      //   66	111	269	java/lang/Exception
      //   111	124	269	java/lang/Exception
      //   124	134	269	java/lang/Exception
      //   134	160	269	java/lang/Exception
      //   160	165	269	java/lang/Exception
      //   165	175	269	java/lang/Exception
      //   175	185	269	java/lang/Exception
      //   267	269	269	java/lang/Exception
      //   295	300	269	java/lang/Exception
      //   304	318	269	java/lang/Exception
      //   318	322	269	java/lang/Exception
      //   124	134	293	java/lang/OutOfMemoryError
      //   165	175	303	java/lang/OutOfMemoryError
    }
  }
  
  static abstract interface a
  {
    public abstract void Kq(String paramString);
    
    public abstract void t(String paramString, Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.feed.NearbyImgLoader
 * JD-Core Version:    0.7.0.1
 */