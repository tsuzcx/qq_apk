import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.10;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.4;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.5;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.7;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.8;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.concurrent.GuardedBy;

public class wmz
{
  @GuardedBy("sPendingPreloadQueue")
  private static long jdField_a_of_type_Long;
  private static Context jdField_a_of_type_AndroidContentContext;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static TVK_ICacheMgr.IPreloadCallback jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCallback = new wnb();
  private static TVK_ICacheMgr.IPreloadCompleteCallback jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCompleteCallback;
  @GuardedBy("sPendingPreloadQueue")
  private static final Queue<wnf> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private static final CopyOnWriteArraySet<wng> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet;
  @GuardedBy("sPendingPreloadQueue")
  private static wnf jdField_a_of_type_Wnf;
  
  static
  {
    jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication();
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCompleteCallback = new wna();
  }
  
  public static int a(wnf paramwnf)
  {
    int i = 1;
    if (paramwnf == null) {
      throw new NullPointerException("preloadItem is null");
    }
    paramwnf = new File(paramwnf.c);
    if (vmq.a(paramwnf)) {
      return 1;
    }
    if ((paramwnf.isFile()) && (paramwnf.length() >= 409600L)) {}
    while (i != 0)
    {
      return 2;
      i = 0;
    }
    if (paramwnf.length() > 0L) {
      return 3;
    }
    return 4;
  }
  
  private static TVK_ICacheMgr a()
  {
    if (TVK_SDKMgr.isInstalled(BaseApplicationImpl.getApplication())) {
      return TVK_SDKMgr.getProxyFactory().getCacheMgr(BaseApplicationImpl.getApplication());
    }
    return null;
  }
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaUtilQueue)
    {
      Object localObject1 = new ArrayList(jdField_a_of_type_JavaUtilQueue);
      jdField_a_of_type_JavaUtilQueue.clear();
      localObject1 = ((List)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        wnf localwnf = (wnf)((Iterator)localObject1).next();
        jdField_a_of_type_AndroidOsHandler.post(new TVKPreloader.4(localwnf));
      }
    }
  }
  
  public static void a(String paramString)
  {
    a(paramString, wvt.a(BaseApplicationImpl.getContext()).a());
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      File localFile = vmq.a(paramString, 0, true, true);
      if (localFile != null) {
        ((vls)vux.a(28)).a(paramString, 0, new wnc(localFile, paramString));
      }
    }
  }
  
  public static void a(wnf paramwnf)
  {
    if (paramwnf == null) {
      throw new IllegalArgumentException("item should not be null");
    }
    synchronized (jdField_a_of_type_JavaUtilQueue)
    {
      if (!jdField_a_of_type_JavaUtilQueue.contains(paramwnf)) {
        jdField_a_of_type_JavaUtilQueue.offer(paramwnf);
      }
      b(false);
      return;
    }
  }
  
  public static void b()
  {
    ??? = a();
    if (??? != null)
    {
      ((TVK_ICacheMgr)???).removePreloadCallback();
      ((TVK_ICacheMgr)???).releasePreload(20161223);
    }
    synchronized (jdField_a_of_type_JavaUtilQueue)
    {
      Object localObject2 = new ArrayList(jdField_a_of_type_JavaUtilQueue);
      if (jdField_a_of_type_Wnf != null) {
        ((List)localObject2).add(0, jdField_a_of_type_Wnf);
      }
      jdField_a_of_type_Wnf = null;
      jdField_a_of_type_JavaUtilQueue.clear();
      localObject2 = ((List)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        wnf localwnf = (wnf)((Iterator)localObject2).next();
        jdField_a_of_type_AndroidOsHandler.post(new TVKPreloader.5(localwnf));
      }
    }
  }
  
  private static void b(TVK_ICacheMgr paramTVK_ICacheMgr, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString, wnf paramwnf)
  {
    paramString = paramString.replace("https://", "http://");
    paramTVK_ICacheMgr.setOnPreLoadCompleteCallback(jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCompleteCallback);
    paramTVK_ICacheMgr.setPreloadCallback(jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCallback);
    jdField_a_of_type_Long = SystemClock.uptimeMillis();
    paramTVK_ICacheMgr.preLoadVideoByUrl(BaseApplicationImpl.getContext(), paramString, null, paramTVK_PlayerVideoInfo);
    jdField_a_of_type_AndroidOsHandler.post(new TVKPreloader.10(paramwnf));
  }
  
  /* Error */
  private static void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 27	wmz:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: iload_0
    //   7: ifne +9 -> 16
    //   10: getstatic 119	wmz:jdField_a_of_type_Wnf	Lwnf;
    //   13: ifnonnull +45 -> 58
    //   16: getstatic 27	wmz:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   19: invokeinterface 260 1 0
    //   24: checkcast 76	wnf
    //   27: putstatic 119	wmz:jdField_a_of_type_Wnf	Lwnf;
    //   30: getstatic 119	wmz:jdField_a_of_type_Wnf	Lwnf;
    //   33: ifnull +22 -> 55
    //   36: invokestatic 266	com/tribe/async/async/Bosses:get	()Lcom/tribe/async/async/Boss;
    //   39: new 268	wnd
    //   42: dup
    //   43: ldc_w 270
    //   46: invokespecial 271	wnd:<init>	(Ljava/lang/String;)V
    //   49: invokeinterface 277 2 0
    //   54: pop
    //   55: aload_1
    //   56: monitorexit
    //   57: return
    //   58: ldc_w 270
    //   61: ldc_w 279
    //   64: getstatic 119	wmz:jdField_a_of_type_Wnf	Lwnf;
    //   67: invokestatic 284	xvv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   70: goto -15 -> 55
    //   73: astore_2
    //   74: aload_1
    //   75: monitorexit
    //   76: aload_2
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramBoolean	boolean
    //   3	72	1	localQueue	Queue
    //   73	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	16	73	finally
    //   16	55	73	finally
    //   55	57	73	finally
    //   58	70	73	finally
    //   74	76	73	finally
  }
  
  private static void c(@NonNull wnf paramwnf)
  {
    TVK_ICacheMgr localTVK_ICacheMgr;
    switch (a(paramwnf))
    {
    default: 
      localTVK_ICacheMgr = a();
      if (localTVK_ICacheMgr == null)
      {
        jdField_a_of_type_AndroidOsHandler.post(new TVKPreloader.8(paramwnf));
        b(true);
        return;
      }
      break;
    case 1: 
    case 2: 
      jdField_a_of_type_AndroidOsHandler.post(new TVKPreloader.7(paramwnf));
      b(true);
      return;
    }
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramwnf.b;
    int i = ((Integer)((vuq)vux.a(10)).b("key_story_video_preload_duration", Integer.valueOf(2))).intValue();
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = wvd.a(paramwnf.a, paramwnf.c);
    localTVK_PlayerVideoInfo.setConfigMap("cache_duration", String.valueOf(i));
    if (arrayOfString[0].contains("qqstocdnd"))
    {
      vlm localvlm = (vlm)vux.a(4);
      String str = localvlm.b();
      if (!TextUtils.isEmpty(str))
      {
        arrayOfString[0] = bjnd.a(arrayOfString[0], "authkey", str);
        b(localTVK_ICacheMgr, localTVK_PlayerVideoInfo, arrayOfString[0], paramwnf);
        return;
      }
      Bosses.get().postJob(new wne("Q.qqstory.playernew.TVKPreloader", localvlm, arrayOfString, i, paramwnf, localTVK_ICacheMgr, localTVK_PlayerVideoInfo));
      return;
    }
    b(localTVK_ICacheMgr, localTVK_PlayerVideoInfo, arrayOfString[0], paramwnf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmz
 * JD-Core Version:    0.7.0.1
 */