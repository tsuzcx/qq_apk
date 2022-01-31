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

public class voi
{
  @GuardedBy("sPendingPreloadQueue")
  private static long jdField_a_of_type_Long;
  private static Context jdField_a_of_type_AndroidContentContext;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static TVK_ICacheMgr.IPreloadCallback jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCallback = new vok();
  private static TVK_ICacheMgr.IPreloadCompleteCallback jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCompleteCallback;
  @GuardedBy("sPendingPreloadQueue")
  private static final Queue<voo> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private static final CopyOnWriteArraySet<vop> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet;
  @GuardedBy("sPendingPreloadQueue")
  private static voo jdField_a_of_type_Voo;
  
  static
  {
    jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication();
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCompleteCallback = new voj();
  }
  
  public static int a(voo paramvoo)
  {
    int i = 1;
    if (paramvoo == null) {
      throw new NullPointerException("preloadItem is null");
    }
    paramvoo = new File(paramvoo.c);
    if (unk.a(paramvoo)) {
      return 1;
    }
    if ((paramvoo.isFile()) && (paramvoo.length() >= 409600L)) {}
    while (i != 0)
    {
      return 2;
      i = 0;
    }
    if (paramvoo.length() > 0L) {
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
        voo localvoo = (voo)((Iterator)localObject1).next();
        jdField_a_of_type_AndroidOsHandler.post(new TVKPreloader.4(localvoo));
      }
    }
  }
  
  public static void a(String paramString)
  {
    a(paramString, vxc.a(BaseApplicationImpl.getContext()).a());
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      File localFile = unk.a(paramString, 0, true, true);
      if (localFile != null) {
        ((umm)uwa.a(28)).a(paramString, 0, new vol(localFile, paramString));
      }
    }
  }
  
  public static void a(voo paramvoo)
  {
    if (paramvoo == null) {
      throw new IllegalArgumentException("item should not be null");
    }
    synchronized (jdField_a_of_type_JavaUtilQueue)
    {
      if (!jdField_a_of_type_JavaUtilQueue.contains(paramvoo)) {
        jdField_a_of_type_JavaUtilQueue.offer(paramvoo);
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
      if (jdField_a_of_type_Voo != null) {
        ((List)localObject2).add(0, jdField_a_of_type_Voo);
      }
      jdField_a_of_type_Voo = null;
      jdField_a_of_type_JavaUtilQueue.clear();
      localObject2 = ((List)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        voo localvoo = (voo)((Iterator)localObject2).next();
        jdField_a_of_type_AndroidOsHandler.post(new TVKPreloader.5(localvoo));
      }
    }
  }
  
  private static void b(TVK_ICacheMgr paramTVK_ICacheMgr, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString, voo paramvoo)
  {
    paramString = paramString.replace("https://", "http://");
    paramTVK_ICacheMgr.setOnPreLoadCompleteCallback(jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCompleteCallback);
    paramTVK_ICacheMgr.setPreloadCallback(jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCallback);
    jdField_a_of_type_Long = SystemClock.uptimeMillis();
    paramTVK_ICacheMgr.preLoadVideoByUrl(BaseApplicationImpl.getContext(), paramString, null, paramTVK_PlayerVideoInfo);
    jdField_a_of_type_AndroidOsHandler.post(new TVKPreloader.10(paramvoo));
  }
  
  /* Error */
  private static void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 27	voi:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: iload_0
    //   7: ifne +9 -> 16
    //   10: getstatic 119	voi:jdField_a_of_type_Voo	Lvoo;
    //   13: ifnonnull +45 -> 58
    //   16: getstatic 27	voi:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   19: invokeinterface 260 1 0
    //   24: checkcast 76	voo
    //   27: putstatic 119	voi:jdField_a_of_type_Voo	Lvoo;
    //   30: getstatic 119	voi:jdField_a_of_type_Voo	Lvoo;
    //   33: ifnull +22 -> 55
    //   36: invokestatic 266	com/tribe/async/async/Bosses:get	()Lcom/tribe/async/async/Boss;
    //   39: new 268	vom
    //   42: dup
    //   43: ldc_w 270
    //   46: invokespecial 271	vom:<init>	(Ljava/lang/String;)V
    //   49: invokeinterface 277 2 0
    //   54: pop
    //   55: aload_1
    //   56: monitorexit
    //   57: return
    //   58: ldc_w 270
    //   61: ldc_w 279
    //   64: getstatic 119	voi:jdField_a_of_type_Voo	Lvoo;
    //   67: invokestatic 284	wxe:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
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
  
  private static void c(@NonNull voo paramvoo)
  {
    TVK_ICacheMgr localTVK_ICacheMgr;
    switch (a(paramvoo))
    {
    default: 
      localTVK_ICacheMgr = a();
      if (localTVK_ICacheMgr == null)
      {
        jdField_a_of_type_AndroidOsHandler.post(new TVKPreloader.8(paramvoo));
        b(true);
        return;
      }
      break;
    case 1: 
    case 2: 
      jdField_a_of_type_AndroidOsHandler.post(new TVKPreloader.7(paramvoo));
      b(true);
      return;
    }
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramvoo.b;
    int i = ((Integer)((uvt)uwa.a(10)).b("key_story_video_preload_duration", Integer.valueOf(2))).intValue();
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = vwm.a(paramvoo.a, paramvoo.c);
    localTVK_PlayerVideoInfo.setConfigMap("cache_duration", String.valueOf(i));
    if (arrayOfString[0].contains("qqstocdnd"))
    {
      umg localumg = (umg)uwa.a(4);
      String str = localumg.b();
      if (!TextUtils.isEmpty(str))
      {
        arrayOfString[0] = bhsz.a(arrayOfString[0], "authkey", str);
        b(localTVK_ICacheMgr, localTVK_PlayerVideoInfo, arrayOfString[0], paramvoo);
        return;
      }
      Bosses.get().postJob(new von("Q.qqstory.playernew.TVKPreloader", localumg, arrayOfString, i, paramvoo, localTVK_ICacheMgr, localTVK_PlayerVideoInfo));
      return;
    }
    b(localTVK_ICacheMgr, localTVK_PlayerVideoInfo, arrayOfString[0], paramvoo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     voi
 * JD-Core Version:    0.7.0.1
 */