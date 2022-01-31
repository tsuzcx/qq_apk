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

public class vjz
{
  @GuardedBy("sPendingPreloadQueue")
  private static long jdField_a_of_type_Long;
  private static Context jdField_a_of_type_AndroidContentContext;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static TVK_ICacheMgr.IPreloadCallback jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCallback = new vkb();
  private static TVK_ICacheMgr.IPreloadCompleteCallback jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCompleteCallback;
  @GuardedBy("sPendingPreloadQueue")
  private static final Queue<vkf> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private static final CopyOnWriteArraySet<vkg> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet;
  @GuardedBy("sPendingPreloadQueue")
  private static vkf jdField_a_of_type_Vkf;
  
  static
  {
    jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication();
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCompleteCallback = new vka();
  }
  
  public static int a(vkf paramvkf)
  {
    int i = 1;
    if (paramvkf == null) {
      throw new NullPointerException("preloadItem is null");
    }
    paramvkf = new File(paramvkf.c);
    if (ujb.a(paramvkf)) {
      return 1;
    }
    if ((paramvkf.isFile()) && (paramvkf.length() >= 409600L)) {}
    while (i != 0)
    {
      return 2;
      i = 0;
    }
    if (paramvkf.length() > 0L) {
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
        vkf localvkf = (vkf)((Iterator)localObject1).next();
        jdField_a_of_type_AndroidOsHandler.post(new TVKPreloader.4(localvkf));
      }
    }
  }
  
  public static void a(String paramString)
  {
    a(paramString, vst.a(BaseApplicationImpl.getContext()).a());
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      File localFile = ujb.a(paramString, 0, true, true);
      if (localFile != null) {
        ((uid)urr.a(28)).a(paramString, 0, new vkc(localFile, paramString));
      }
    }
  }
  
  public static void a(vkf paramvkf)
  {
    if (paramvkf == null) {
      throw new IllegalArgumentException("item should not be null");
    }
    synchronized (jdField_a_of_type_JavaUtilQueue)
    {
      if (!jdField_a_of_type_JavaUtilQueue.contains(paramvkf)) {
        jdField_a_of_type_JavaUtilQueue.offer(paramvkf);
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
      if (jdField_a_of_type_Vkf != null) {
        ((List)localObject2).add(0, jdField_a_of_type_Vkf);
      }
      jdField_a_of_type_Vkf = null;
      jdField_a_of_type_JavaUtilQueue.clear();
      localObject2 = ((List)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        vkf localvkf = (vkf)((Iterator)localObject2).next();
        jdField_a_of_type_AndroidOsHandler.post(new TVKPreloader.5(localvkf));
      }
    }
  }
  
  private static void b(TVK_ICacheMgr paramTVK_ICacheMgr, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString, vkf paramvkf)
  {
    paramString = paramString.replace("https://", "http://");
    paramTVK_ICacheMgr.setOnPreLoadCompleteCallback(jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCompleteCallback);
    paramTVK_ICacheMgr.setPreloadCallback(jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCallback);
    jdField_a_of_type_Long = SystemClock.uptimeMillis();
    paramTVK_ICacheMgr.preLoadVideoByUrl(BaseApplicationImpl.getContext(), paramString, null, paramTVK_PlayerVideoInfo);
    jdField_a_of_type_AndroidOsHandler.post(new TVKPreloader.10(paramvkf));
  }
  
  /* Error */
  private static void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 27	vjz:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: iload_0
    //   7: ifne +9 -> 16
    //   10: getstatic 119	vjz:jdField_a_of_type_Vkf	Lvkf;
    //   13: ifnonnull +45 -> 58
    //   16: getstatic 27	vjz:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   19: invokeinterface 260 1 0
    //   24: checkcast 76	vkf
    //   27: putstatic 119	vjz:jdField_a_of_type_Vkf	Lvkf;
    //   30: getstatic 119	vjz:jdField_a_of_type_Vkf	Lvkf;
    //   33: ifnull +22 -> 55
    //   36: invokestatic 266	com/tribe/async/async/Bosses:get	()Lcom/tribe/async/async/Boss;
    //   39: new 268	vkd
    //   42: dup
    //   43: ldc_w 270
    //   46: invokespecial 271	vkd:<init>	(Ljava/lang/String;)V
    //   49: invokeinterface 277 2 0
    //   54: pop
    //   55: aload_1
    //   56: monitorexit
    //   57: return
    //   58: ldc_w 270
    //   61: ldc_w 279
    //   64: getstatic 119	vjz:jdField_a_of_type_Vkf	Lvkf;
    //   67: invokestatic 284	wsv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
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
  
  private static void c(@NonNull vkf paramvkf)
  {
    TVK_ICacheMgr localTVK_ICacheMgr;
    switch (a(paramvkf))
    {
    default: 
      localTVK_ICacheMgr = a();
      if (localTVK_ICacheMgr == null)
      {
        jdField_a_of_type_AndroidOsHandler.post(new TVKPreloader.8(paramvkf));
        b(true);
        return;
      }
      break;
    case 1: 
    case 2: 
      jdField_a_of_type_AndroidOsHandler.post(new TVKPreloader.7(paramvkf));
      b(true);
      return;
    }
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramvkf.b;
    int i = ((Integer)((urk)urr.a(10)).b("key_story_video_preload_duration", Integer.valueOf(2))).intValue();
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = vsd.a(paramvkf.a, paramvkf.c);
    localTVK_PlayerVideoInfo.setConfigMap("cache_duration", String.valueOf(i));
    if (arrayOfString[0].contains("qqstocdnd"))
    {
      uhx localuhx = (uhx)urr.a(4);
      String str = localuhx.b();
      if (!TextUtils.isEmpty(str))
      {
        arrayOfString[0] = bhos.a(arrayOfString[0], "authkey", str);
        b(localTVK_ICacheMgr, localTVK_PlayerVideoInfo, arrayOfString[0], paramvkf);
        return;
      }
      Bosses.get().postJob(new vke("Q.qqstory.playernew.TVKPreloader", localuhx, arrayOfString, i, paramvkf, localTVK_ICacheMgr, localTVK_PlayerVideoInfo));
      return;
    }
    b(localTVK_ICacheMgr, localTVK_PlayerVideoInfo, arrayOfString[0], paramvkf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vjz
 * JD-Core Version:    0.7.0.1
 */