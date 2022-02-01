package com.tencent.biz.qqstory.takevideo.slideshow.core;

import ahbj;
import android.app.Activity;
import android.opengl.EGLContext;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import aurp;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rlt;
import rmi;
import rmk;
import rml;
import rmn;
import rmn.a;
import rmn.b;
import rmo;

public class SlideShowProcessor
{
  public static final String ROOT_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.tencent.mobileqq/qq/video/imagevideo/";
  public static final String aBl = ROOT_PATH + "cache/";
  private EglHandlerThreadEx jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx;
  private Task jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$Task;
  private boolean aIM = true;
  private AtomicLong t = new AtomicLong(0L);
  
  private void a(List<SlideItemInfo> paramList, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, b paramb)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label281;
      }
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)paramList.next();
      if (localSlideItemInfo != null)
      {
        rlt localrlt = new rlt();
        localrlt.mID = this.t.addAndGet(1L);
        localrlt.aBm = localSlideItemInfo.mSrcPath;
        if (QLog.isColorLevel()) {
          QLog.d("SlideShowProcessor", 2, "start, taskId:" + localrlt.mID + ", image:" + localSlideItemInfo.mSrcPath + ", widht:" + paramInt1 + " height:" + paramInt2 + " duration:" + paramLong);
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SlideShowProcessor", 2, "thread not init");
          }
          localrlt.mResult = 3;
          if (paramb == null) {
            break;
          }
          paramb.c(localrlt);
          return;
        }
        if (TextUtils.isEmpty(localSlideItemInfo.mSrcPath))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SlideShowProcessor", 2, "strImage == null");
          }
          localrlt.mResult = 4;
          if (paramb == null) {
            break;
          }
          paramb.c(localrlt);
          return;
        }
        localrlt.mResult = 1;
        localArrayList.add(new a(localrlt.mID, localSlideItemInfo, paramInt1, paramInt2, paramLong, paramb, paramBoolean));
      }
    }
    label281:
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$Task.fa(localArrayList);
  }
  
  public static File[] a(String paramString)
  {
    paramString = new File(paramString).listFiles(new rmk());
    if (paramString != null) {
      Arrays.sort(paramString, new rml());
    }
    return paramString;
  }
  
  public static void clearCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowProcessor", 2, "clearCache start");
    }
    File[] arrayOfFile = a(aBl);
    int j = 100;
    if ((arrayOfFile != null) && (arrayOfFile.length > 100))
    {
      int i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("SlideShowProcessor", 2, "clear cache delete file over 100");
        i = j;
      }
      while (i < arrayOfFile.length)
      {
        ahbj.deleteFile(arrayOfFile[i]);
        ahbj.deleteFile(arrayOfFile[i] + ".dat");
        i += 1;
      }
    }
  }
  
  public rlt a(SlideItemInfo paramSlideItemInfo, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, b paramb)
  {
    rlt localrlt = new rlt();
    localrlt.mID = this.t.addAndGet(1L);
    localrlt.aBm = paramSlideItemInfo.mSrcPath;
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowProcessor", 2, "start, taskId:" + localrlt.mID + ", image:" + paramSlideItemInfo.mSrcPath + ", widht:" + paramInt1 + " height:" + paramInt2 + " duration:" + paramLong);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowProcessor", 2, "thread not init");
      }
      localrlt.mResult = 3;
      if (paramb != null) {
        paramb.c(localrlt);
      }
      return localrlt;
    }
    if (TextUtils.isEmpty(paramSlideItemInfo.mSrcPath))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowProcessor", 2, "strImage == null");
      }
      localrlt.mResult = 4;
      if (paramb != null) {
        paramb.c(localrlt);
      }
      return localrlt;
    }
    localrlt.mResult = 1;
    paramSlideItemInfo = new a(localrlt.mID, paramSlideItemInfo, paramInt1, paramInt2, paramLong, paramb, paramBoolean);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$Task.a(paramSlideItemInfo);
    return localrlt;
  }
  
  public void a(SlideItemInfo paramSlideItemInfo, b paramb)
  {
    if (paramb == null) {}
    a(paramSlideItemInfo, 720, 1280, 2000L, this.aIM, paramb);
  }
  
  public void a(List<SlideItemInfo> paramList, b paramb)
  {
    if (paramb == null) {}
    a(paramList, 720, 1280, 2000L, this.aIM, paramb);
  }
  
  public void a(List<SlideItemInfo> paramList, rmn.b paramb, Activity paramActivity, Handler paramHandler, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      rmn.a locala = new rmn.a();
      locala.mItemList = paramList;
      locala.a = paramb;
      locala.mContext = paramActivity;
      locala.mHandler = paramHandler;
      locala.btp = paramInt1;
      locala.texId = paramInt2;
      locala.aBq = paramString;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$Task.a(locala);
    }
  }
  
  public boolean fw(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$Task.fx(paramString);
  }
  
  /* Error */
  public boolean init()
  {
    // Byte code:
    //   0: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 119
    //   8: iconst_2
    //   9: ldc_w 269
    //   12: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: getstatic 274	android/os/Build$VERSION:SDK_INT	I
    //   18: bipush 18
    //   20: if_icmpge +14 -> 34
    //   23: ldc 119
    //   25: iconst_2
    //   26: ldc_w 276
    //   29: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: iconst_0
    //   33: ireturn
    //   34: aload_0
    //   35: invokevirtual 279	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:unInit	()V
    //   38: aload_0
    //   39: monitorenter
    //   40: aload_0
    //   41: new 6	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx
    //   44: dup
    //   45: ldc_w 281
    //   48: aconst_null
    //   49: aload_0
    //   50: invokespecial 284	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:<init>	(Ljava/lang/String;Landroid/opengl/EGLContext;Ljava/lang/Object;)V
    //   53: putfield 141	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   56: aload_0
    //   57: new 9	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task
    //   60: dup
    //   61: invokespecial 285	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:<init>	()V
    //   64: putfield 167	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$Task	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task;
    //   67: aload_0
    //   68: getfield 141	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   71: invokevirtual 288	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:start	()V
    //   74: aload_0
    //   75: getfield 141	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   78: invokevirtual 291	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:isInitSuccess	()Z
    //   81: istore_1
    //   82: iload_1
    //   83: ifne +10 -> 93
    //   86: aload_0
    //   87: ldc2_w 292
    //   90: invokevirtual 296	java/lang/Object:wait	(J)V
    //   93: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +51 -> 147
    //   99: ldc 119
    //   101: iconst_2
    //   102: new 32	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   109: ldc_w 298
    //   112: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_0
    //   116: getfield 141	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   119: invokevirtual 291	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:isInitSuccess	()Z
    //   122: invokevirtual 301	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   125: ldc_w 303
    //   128: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_0
    //   132: getfield 141	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   135: invokevirtual 307	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:getHandler	()Landroid/os/Handler;
    //   138: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: aload_0
    //   148: getfield 141	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   151: invokevirtual 307	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:getHandler	()Landroid/os/Handler;
    //   154: ifnull +18 -> 172
    //   157: aload_0
    //   158: getfield 141	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   161: invokevirtual 307	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:getHandler	()Landroid/os/Handler;
    //   164: aload_0
    //   165: getfield 167	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$Task	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task;
    //   168: invokevirtual 313	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   171: pop
    //   172: aload_0
    //   173: monitorexit
    //   174: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +12 -> 189
    //   180: ldc 119
    //   182: iconst_2
    //   183: ldc_w 315
    //   186: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: iconst_1
    //   190: ireturn
    //   191: astore_2
    //   192: aload_0
    //   193: monitorexit
    //   194: aload_2
    //   195: athrow
    //   196: astore_2
    //   197: goto -104 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	SlideShowProcessor
    //   81	2	1	bool	boolean
    //   191	4	2	localObject	Object
    //   196	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   40	82	191	finally
    //   86	93	191	finally
    //   93	147	191	finally
    //   147	172	191	finally
    //   172	174	191	finally
    //   192	194	191	finally
    //   86	93	196	java/lang/InterruptedException
  }
  
  public void sC(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$Task.sC(paramString);
  }
  
  public void stopAll()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowProcessor", 2, "stopALl , " + aurp.getStackTraceAsString(new Throwable()));
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$Task.stopAll();
  }
  
  public void unInit()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowProcessor", 2, "uninit..");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx.quitSafely();
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx = null;
      }
      return;
    }
    finally {}
  }
  
  public static class EglHandlerThreadEx
    extends EglHandlerThread
  {
    private WeakReference<Object> mSynObjectRef;
    
    public EglHandlerThreadEx(String paramString, EGLContext paramEGLContext, Object paramObject)
    {
      super(paramEGLContext);
      if (paramObject != null) {
        this.mSynObjectRef = new WeakReference(paramObject);
      }
    }
    
    public void onLooperPrepared()
    {
      super.onLooperPrepared();
      if (this.mSynObjectRef != null)
      {
        Object localObject1 = this.mSynObjectRef.get();
        if (localObject1 != null) {
          try
          {
            localObject1.notify();
            return;
          }
          finally {}
        }
      }
    }
  }
  
  public static class Task
    implements Runnable
  {
    long Cl;
    public SlideShowProcessor.c a;
    private rmn jdField_a_of_type_Rmn = new rmn();
    private rmo jdField_a_of_type_Rmo = new rmo();
    private rmi b = new rmi(true);
    long fR;
    private boolean isRun = true;
    protected AtomicLong u = new AtomicLong(0L);
    private Queue<SlideShowProcessor.c> y = new LinkedList();
    
    /* Error */
    private SlideShowProcessor.c a()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 41	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:y	Ljava/util/Queue;
      //   6: astore_1
      //   7: aload_1
      //   8: ifnonnull +9 -> 17
      //   11: aconst_null
      //   12: astore_1
      //   13: aload_0
      //   14: monitorexit
      //   15: aload_1
      //   16: areturn
      //   17: aload_0
      //   18: getfield 41	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:y	Ljava/util/Queue;
      //   21: invokeinterface 68 1 0
      //   26: ifeq +13 -> 39
      //   29: aload_0
      //   30: aload_0
      //   31: getfield 41	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:y	Ljava/util/Queue;
      //   34: ldc 70
      //   36: invokespecial 73	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:a	(Ljava/util/Queue;Ljava/lang/String;)V
      //   39: aload_0
      //   40: getfield 41	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:y	Ljava/util/Queue;
      //   43: invokeinterface 76 1 0
      //   48: checkcast 78	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c
      //   51: astore_1
      //   52: goto -39 -> 13
      //   55: astore_1
      //   56: aload_0
      //   57: monitorexit
      //   58: aload_1
      //   59: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	60	0	this	Task
      //   6	46	1	localObject1	Object
      //   55	4	1	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	55	finally
      //   17	39	55	finally
      //   39	52	55	finally
    }
    
    private void a(Queue<SlideShowProcessor.c> paramQueue, String paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PendingTask : " + paramString);
      if ((paramQueue != null) && (paramQueue.size() > 0))
      {
        paramQueue = paramQueue.iterator();
        while (paramQueue.hasNext())
        {
          paramString = (SlideShowProcessor.c)paramQueue.next();
          localStringBuilder.append("\n");
          if ((paramString instanceof SlideShowProcessor.a))
          {
            paramString = (SlideShowProcessor.a)paramString;
            if ((paramString.a != null) && (paramString.a.mSrcPath != null)) {
              localStringBuilder.append(paramString.a.mSrcPath);
            } else {
              localStringBuilder.append("null");
            }
          }
          else if ((paramString instanceof rmn.a))
          {
            paramString = new rmn.a();
            localStringBuilder.append("merge task");
            if ((paramString.mItemList != null) && (paramString.mItemList.size() > 0))
            {
              localStringBuilder.append(" : ");
              paramString = paramString.mItemList.iterator();
              while (paramString.hasNext())
              {
                localStringBuilder.append(((SlideItemInfo)paramString.next()).mSrcPath);
                localStringBuilder.append("  ----  ");
              }
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowProcessorTask", 2, localStringBuilder.toString());
      }
    }
    
    public void a(SlideShowProcessor.c paramc)
    {
      for (;;)
      {
        try
        {
          this.y.add(paramc);
          if (QLog.isColorLevel())
          {
            if ((paramc instanceof rmn.a)) {
              QLog.d("SlideShowProcessorTask", 2, "add merge context");
            }
          }
          else {
            return;
          }
          if ((paramc instanceof SlideShowProcessor.a)) {
            if (((SlideShowProcessor.a)paramc).a == null) {
              QLog.d("SlideShowProcessorTask", 2, "add convertContext itemInfo is null");
            } else {
              QLog.d("SlideShowProcessorTask", 2, "add convertContext : " + ((SlideShowProcessor.a)paramc).a.mSrcPath);
            }
          }
        }
        finally {}
      }
    }
    
    public void bvz()
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("SlideShowProcessorTask", 2, "stopPeek begin");
        }
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c.isRun == true) && (this.isRun))
        {
          SlideShowProcessor.c localc = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c;
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c.isRun = false;
          rlt localrlt = new rlt();
          localrlt.mID = localc.Cj;
          localrlt.mHasAudioTrack = false;
          localrlt.bth = 1;
          if (localc.a != null) {
            localc.a.c(localrlt);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SlideShowProcessorTask", 2, "stopPeek end");
        }
        a(this.y, "stopPeek");
        return;
      }
      finally {}
    }
    
    public void fa(List<SlideShowProcessor.c> paramList)
    {
      try
      {
        this.y.addAll(paramList);
        return;
      }
      finally
      {
        paramList = finally;
        throw paramList;
      }
    }
    
    /* Error */
    public boolean fx(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_1
      //   3: invokestatic 210	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   6: istore_2
      //   7: iload_2
      //   8: ifeq +9 -> 17
      //   11: iconst_0
      //   12: istore_2
      //   13: aload_0
      //   14: monitorexit
      //   15: iload_2
      //   16: ireturn
      //   17: aload_0
      //   18: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   21: ifnull +51 -> 72
      //   24: aload_0
      //   25: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   28: instanceof 108
      //   31: ifeq +41 -> 72
      //   34: aload_0
      //   35: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   38: checkcast 108	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a
      //   41: getfield 111	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a:a	Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;
      //   44: ifnull +28 -> 72
      //   47: aload_1
      //   48: aload_0
      //   49: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   52: checkcast 108	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a
      //   55: getfield 111	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a:a	Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;
      //   58: getfield 117	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mSrcPath	Ljava/lang/String;
      //   61: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   64: ifeq +8 -> 72
      //   67: iconst_1
      //   68: istore_2
      //   69: goto -56 -> 13
      //   72: aload_0
      //   73: getfield 41	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:y	Ljava/util/Queue;
      //   76: invokeinterface 95 1 0
      //   81: astore_3
      //   82: aload_3
      //   83: invokeinterface 101 1 0
      //   88: ifeq +47 -> 135
      //   91: aload_3
      //   92: invokeinterface 104 1 0
      //   97: checkcast 78	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c
      //   100: astore 4
      //   102: aload 4
      //   104: instanceof 108
      //   107: ifeq -25 -> 82
      //   110: aload 4
      //   112: checkcast 108	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a
      //   115: getfield 111	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a:a	Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;
      //   118: getfield 117	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mSrcPath	Ljava/lang/String;
      //   121: aload_1
      //   122: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   125: istore_2
      //   126: iload_2
      //   127: ifeq -45 -> 82
      //   130: iconst_1
      //   131: istore_2
      //   132: goto -119 -> 13
      //   135: iconst_0
      //   136: istore_2
      //   137: goto -124 -> 13
      //   140: astore_1
      //   141: aload_0
      //   142: monitorexit
      //   143: aload_1
      //   144: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	145	0	this	Task
      //   0	145	1	paramString	String
      //   6	131	2	bool	boolean
      //   81	11	3	localIterator	Iterator
      //   100	11	4	localc	SlideShowProcessor.c
      // Exception table:
      //   from	to	target	type
      //   2	7	140	finally
      //   17	67	140	finally
      //   72	82	140	finally
      //   82	126	140	finally
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   3: ifeq +11 -> 14
      //   6: ldc 143
      //   8: iconst_2
      //   9: ldc 222
      //   11: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   14: aload_0
      //   15: getfield 43	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:isRun	Z
      //   18: ifeq +510 -> 528
      //   21: aload_0
      //   22: monitorenter
      //   23: aload_0
      //   24: aload_0
      //   25: invokespecial 224	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:a	()Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   28: putfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   31: aload_0
      //   32: monitorexit
      //   33: aload_0
      //   34: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   37: ifnull +132 -> 169
      //   40: aload_0
      //   41: monitorenter
      //   42: aload_0
      //   43: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   46: iconst_1
      //   47: putfield 166	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c:isRun	Z
      //   50: aload_0
      //   51: monitorexit
      //   52: aload_0
      //   53: getfield 36	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:u	Ljava/util/concurrent/atomic/AtomicLong;
      //   56: lconst_1
      //   57: invokevirtual 228	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
      //   60: lstore_1
      //   61: aload_0
      //   62: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   65: lload_1
      //   66: putfield 172	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c:Cj	J
      //   69: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   72: ifeq +28 -> 100
      //   75: ldc 143
      //   77: iconst_2
      //   78: new 80	java/lang/StringBuilder
      //   81: dup
      //   82: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   85: ldc 230
      //   87: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   90: lload_1
      //   91: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   94: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   97: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   100: aload_0
      //   101: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   104: instanceof 121
      //   107: ifeq +219 -> 326
      //   110: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   113: ifeq +11 -> 124
      //   116: ldc 143
      //   118: iconst_2
      //   119: ldc 235
      //   121: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   124: aload_0
      //   125: getfield 60	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Rmn	Lrmn;
      //   128: aload_0
      //   129: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   132: checkcast 121	rmn$a
      //   135: invokevirtual 238	rmn:a	(Lrmn$a;)V
      //   138: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   141: ifeq +11 -> 152
      //   144: ldc 143
      //   146: iconst_2
      //   147: ldc 240
      //   149: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   152: aload_0
      //   153: monitorenter
      //   154: aload_0
      //   155: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   158: iconst_0
      //   159: putfield 166	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c:isRun	Z
      //   162: aload_0
      //   163: aconst_null
      //   164: putfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   167: aload_0
      //   168: monitorexit
      //   169: aload_0
      //   170: monitorenter
      //   171: aload_0
      //   172: invokevirtual 243	java/lang/Object:notifyAll	()V
      //   175: aload_0
      //   176: monitorexit
      //   177: ldc2_w 244
      //   180: invokestatic 250	java/lang/Thread:sleep	(J)V
      //   183: goto -169 -> 14
      //   186: astore_3
      //   187: aload_3
      //   188: invokestatic 256	aurp:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   191: astore_3
      //   192: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   195: ifeq -181 -> 14
      //   198: ldc 143
      //   200: iconst_2
      //   201: aload_3
      //   202: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   205: goto -191 -> 14
      //   208: astore_3
      //   209: aload_3
      //   210: invokestatic 256	aurp:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   213: astore_3
      //   214: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   217: ifeq +29 -> 246
      //   220: ldc 143
      //   222: iconst_2
      //   223: new 80	java/lang/StringBuilder
      //   226: dup
      //   227: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   230: ldc_w 258
      //   233: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   236: aload_3
      //   237: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   240: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   243: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   246: aload_0
      //   247: monitorenter
      //   248: aload_0
      //   249: invokevirtual 243	java/lang/Object:notifyAll	()V
      //   252: aload_0
      //   253: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   256: ifnull +16 -> 272
      //   259: aload_0
      //   260: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   263: iconst_0
      //   264: putfield 166	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c:isRun	Z
      //   267: aload_0
      //   268: aconst_null
      //   269: putfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   272: aload_0
      //   273: monitorexit
      //   274: aload_0
      //   275: iconst_0
      //   276: putfield 43	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:isRun	Z
      //   279: return
      //   280: astore_3
      //   281: aload_0
      //   282: monitorexit
      //   283: aload_3
      //   284: athrow
      //   285: astore_3
      //   286: aload_0
      //   287: monitorenter
      //   288: aload_0
      //   289: invokevirtual 243	java/lang/Object:notifyAll	()V
      //   292: aload_0
      //   293: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   296: ifnull +16 -> 312
      //   299: aload_0
      //   300: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   303: iconst_0
      //   304: putfield 166	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c:isRun	Z
      //   307: aload_0
      //   308: aconst_null
      //   309: putfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   312: aload_0
      //   313: monitorexit
      //   314: aload_0
      //   315: iconst_0
      //   316: putfield 43	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:isRun	Z
      //   319: aload_3
      //   320: athrow
      //   321: astore_3
      //   322: aload_0
      //   323: monitorexit
      //   324: aload_3
      //   325: athrow
      //   326: aload_0
      //   327: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   330: checkcast 108	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a
      //   333: getfield 111	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a:a	Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;
      //   336: getfield 261	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mediaType	I
      //   339: ifne +91 -> 430
      //   342: aload_0
      //   343: invokestatic 267	java/lang/System:currentTimeMillis	()J
      //   346: putfield 269	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:Cl	J
      //   349: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   352: ifeq +29 -> 381
      //   355: ldc 143
      //   357: iconst_2
      //   358: new 80	java/lang/StringBuilder
      //   361: dup
      //   362: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   365: ldc_w 271
      //   368: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   371: lload_1
      //   372: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   375: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   378: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   381: aload_0
      //   382: getfield 50	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:b	Lrmi;
      //   385: aload_0
      //   386: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   389: checkcast 108	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a
      //   392: invokevirtual 274	rmi:a	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a;)V
      //   395: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   398: ifeq -246 -> 152
      //   401: ldc 143
      //   403: iconst_2
      //   404: new 80	java/lang/StringBuilder
      //   407: dup
      //   408: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   411: ldc_w 276
      //   414: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   417: lload_1
      //   418: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   421: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   424: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   427: goto -275 -> 152
      //   430: aload_0
      //   431: invokestatic 267	java/lang/System:currentTimeMillis	()J
      //   434: putfield 278	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:fR	J
      //   437: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   440: ifeq +29 -> 469
      //   443: ldc 143
      //   445: iconst_2
      //   446: new 80	java/lang/StringBuilder
      //   449: dup
      //   450: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   453: ldc_w 280
      //   456: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   459: lload_1
      //   460: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   463: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   466: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   469: aload_0
      //   470: getfield 55	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Rmo	Lrmo;
      //   473: aload_0
      //   474: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   477: checkcast 108	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a
      //   480: invokevirtual 282	rmo:b	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a;)V
      //   483: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   486: ifeq -334 -> 152
      //   489: ldc 143
      //   491: iconst_2
      //   492: new 80	java/lang/StringBuilder
      //   495: dup
      //   496: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   499: ldc_w 284
      //   502: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   505: lload_1
      //   506: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   509: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   512: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   515: goto -363 -> 152
      //   518: astore_3
      //   519: aload_0
      //   520: monitorexit
      //   521: aload_3
      //   522: athrow
      //   523: astore_3
      //   524: aload_0
      //   525: monitorexit
      //   526: aload_3
      //   527: athrow
      //   528: aload_0
      //   529: monitorenter
      //   530: aload_0
      //   531: invokevirtual 243	java/lang/Object:notifyAll	()V
      //   534: aload_0
      //   535: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   538: ifnull +16 -> 554
      //   541: aload_0
      //   542: getfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   545: iconst_0
      //   546: putfield 166	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c:isRun	Z
      //   549: aload_0
      //   550: aconst_null
      //   551: putfield 165	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$c;
      //   554: aload_0
      //   555: monitorexit
      //   556: aload_0
      //   557: iconst_0
      //   558: putfield 43	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:isRun	Z
      //   561: return
      //   562: astore_3
      //   563: aload_0
      //   564: monitorexit
      //   565: aload_3
      //   566: athrow
      //   567: astore_3
      //   568: aload_0
      //   569: monitorexit
      //   570: aload_3
      //   571: athrow
      //   572: astore_3
      //   573: aload_0
      //   574: monitorexit
      //   575: aload_3
      //   576: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	577	0	this	Task
      //   60	446	1	l	long
      //   186	2	3	localInterruptedException	java.lang.InterruptedException
      //   191	11	3	str1	String
      //   208	2	3	localException	java.lang.Exception
      //   213	24	3	str2	String
      //   280	4	3	localObject1	Object
      //   285	35	3	localObject2	Object
      //   321	4	3	localObject3	Object
      //   518	4	3	localObject4	Object
      //   523	4	3	localObject5	Object
      //   562	4	3	localObject6	Object
      //   567	4	3	localObject7	Object
      //   572	4	3	localObject8	Object
      // Exception table:
      //   from	to	target	type
      //   177	183	186	java/lang/InterruptedException
      //   14	23	208	java/lang/Exception
      //   33	42	208	java/lang/Exception
      //   52	100	208	java/lang/Exception
      //   100	124	208	java/lang/Exception
      //   124	152	208	java/lang/Exception
      //   152	154	208	java/lang/Exception
      //   169	171	208	java/lang/Exception
      //   177	183	208	java/lang/Exception
      //   187	205	208	java/lang/Exception
      //   283	285	208	java/lang/Exception
      //   324	326	208	java/lang/Exception
      //   326	381	208	java/lang/Exception
      //   381	427	208	java/lang/Exception
      //   430	469	208	java/lang/Exception
      //   469	515	208	java/lang/Exception
      //   521	523	208	java/lang/Exception
      //   526	528	208	java/lang/Exception
      //   23	33	280	finally
      //   281	283	280	finally
      //   14	23	285	finally
      //   33	42	285	finally
      //   52	100	285	finally
      //   100	124	285	finally
      //   124	152	285	finally
      //   152	154	285	finally
      //   169	171	285	finally
      //   177	183	285	finally
      //   187	205	285	finally
      //   209	246	285	finally
      //   283	285	285	finally
      //   324	326	285	finally
      //   326	381	285	finally
      //   381	427	285	finally
      //   430	469	285	finally
      //   469	515	285	finally
      //   521	523	285	finally
      //   526	528	285	finally
      //   42	52	321	finally
      //   322	324	321	finally
      //   154	169	518	finally
      //   519	521	518	finally
      //   171	177	523	finally
      //   524	526	523	finally
      //   530	554	562	finally
      //   554	556	562	finally
      //   563	565	562	finally
      //   248	272	567	finally
      //   272	274	567	finally
      //   568	570	567	finally
      //   288	312	572	finally
      //   312	314	572	finally
      //   573	575	572	finally
    }
    
    public void sC(String paramString)
    {
      boolean bool;
      for (;;)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("SlideShowProcessorTask", 2, "stopByPath begin");
          }
          bool = TextUtils.isEmpty(paramString);
          if (bool) {
            label26:
            return;
          }
          if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c != null) && ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c instanceof SlideShowProcessor.a)) && (((SlideShowProcessor.a)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$c).a.mSrcPath.equals(paramString)))
          {
            bvz();
            label69:
            a(this.y, "stopByPath");
            break label26;
          }
          localIterator = this.y.iterator();
        }
        finally {}
        Iterator localIterator;
        if (localIterator.hasNext())
        {
          SlideShowProcessor.c localc = (SlideShowProcessor.c)localIterator.next();
          if ((!(localc instanceof SlideShowProcessor.a)) || (!((SlideShowProcessor.a)localc).a.mSrcPath.equals(paramString))) {
            break label69;
          }
          this.y.remove(localc);
        }
      }
    }
    
    public void stopAll()
    {
      for (;;)
      {
        SlideShowProcessor.c localc;
        try
        {
          Iterator localIterator = this.y.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localc = (SlideShowProcessor.c)localIterator.next();
          rlt localrlt = new rlt();
          localrlt.mResult = 2;
          localrlt.mID = localc.Cj;
          localrlt.mHasAudioTrack = false;
          localrlt.bth = 1;
          if (localc.a != null)
          {
            localc.a.c(localrlt);
            continue;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
        }
        finally {}
        QLog.d("SlideShowProcessorTask", 2, "listener is null, taskContext Type : " + localc.getClass().getSimpleName());
      }
      a(this.y, "stopAll");
      this.y.clear();
      bvz();
    }
  }
  
  public static class a
    extends SlideShowProcessor.c
  {
    public SlideItemInfo a;
    public String aBh;
    private boolean aIM;
    public boolean aIP;
    public boolean mCanceled;
    public long mDuration;
    public boolean mFinished;
    public int mHeight;
    public int mWidth;
    
    public a() {}
    
    public a(long paramLong1, SlideItemInfo paramSlideItemInfo, int paramInt1, int paramInt2, long paramLong2, SlideShowProcessor.b paramb, boolean paramBoolean)
    {
      this.Cj = paramLong1;
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      this.mDuration = paramLong2;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo = paramSlideItemInfo;
      this.aBh = paramSlideItemInfo.mSrcPath;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$b = paramb;
      this.aIM = paramBoolean;
    }
  }
  
  public static abstract interface b
  {
    public abstract void c(rlt paramrlt);
  }
  
  public static class c
  {
    public long Cj;
    public SlideShowProcessor.b a;
    public boolean isRun;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor
 * JD-Core Version:    0.7.0.1
 */