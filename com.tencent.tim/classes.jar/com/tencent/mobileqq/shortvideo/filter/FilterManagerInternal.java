package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.sveffects.SLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

final class FilterManagerInternal
{
  public static final String TAG = "FilterManagerInternal";
  private volatile boolean isCaptureMode = false;
  private final FilterCacheQueue mCacheQueue = new FilterCacheQueue();
  private Stack<FilterChain> mChains = new Stack();
  private QQFilterRenderManager mCommonParam;
  private QQFaceDetectBase mFaceDetect;
  private volatile boolean mReleased = false;
  private boolean needFaceDetect = false;
  
  private void checkStackIsLeakage()
  {
    Object localObject2;
    for (;;)
    {
      try
      {
        if (this.mChains.size() < 10) {
          break label256;
        }
        HashMap localHashMap = new HashMap();
        localIterator = this.mChains.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (FilterChain)localIterator.next();
        if (localHashMap.containsKey(((FilterChain)localObject2).getId()))
        {
          i = ((Integer)localHashMap.get(((FilterChain)localObject2).getId())).intValue();
          localHashMap.put(((FilterChain)localObject2).getId(), Integer.valueOf(i + 1));
        }
        else
        {
          localObject1.put(((FilterChain)localObject2).getId(), Integer.valueOf(1));
        }
      }
      finally {}
    }
    int i = 0;
    Iterator localIterator = localObject1.keySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        int j = ((Integer)localObject1.get(localObject2)).intValue();
        if (j >= 2)
        {
          printLog("checkStackIsLeakage", " key=" + (String)localObject2 + " value=" + j, null);
          i += 1;
        }
      }
      else
      {
        String str = generateStackTrace();
        printLog("checkStackIsLeakage", " count=" + i + " traceInfo=" + str, null);
        label256:
        return;
      }
    }
  }
  
  private void checkThreadSecurity(String paramString)
  {
    if (!isExeInGlThread()) {
      throw new RuntimeException("在非渲染线程执行: [" + paramString + "] threadName=" + Thread.currentThread().getName());
    }
  }
  
  private void decQuote(FilterChain paramFilterChain)
  {
    if (paramFilterChain.mFilters != null)
    {
      Iterator localIterator = paramFilterChain.mHighCache.iterator();
      while (localIterator.hasNext()) {
        ((QQBaseFilter)localIterator.next()).mQuoteCount.decrementAndGet();
      }
    }
    paramFilterChain.mHighCache.clear();
  }
  
  private void initHighCache(FilterChain paramFilterChain)
  {
    if (paramFilterChain.mFilters != null)
    {
      int i = 0;
      while (i < paramFilterChain.mFilters.length)
      {
        int j = paramFilterChain.mFilters[i];
        QQBaseFilter localQQBaseFilter = this.mCacheQueue.getFilterByType(j);
        paramFilterChain.mHighCache.add(localQQBaseFilter);
        i += 1;
      }
    }
  }
  
  private void insertFollowSerial(int paramInt, Object paramObject, ArrayList<Integer> paramArrayList, ArrayList<Object> paramArrayList1)
  {
    int k = paramArrayList.size();
    int j = 0;
    int i = 0;
    while ((j < k) && (paramInt >= ((Integer)paramArrayList.get(j)).intValue()))
    {
      i = j + 1;
      j += 1;
    }
    paramArrayList.add(i, Integer.valueOf(paramInt));
    if (i > paramArrayList1.size())
    {
      j = paramArrayList1.size();
      paramInt = 0;
      while (paramInt < i - j)
      {
        paramArrayList1.add(null);
        paramInt += 1;
      }
    }
    paramArrayList1.add(i, paramObject);
  }
  
  @TargetApi(17)
  private boolean isExeInGlThread()
  {
    return EGL14.eglGetCurrentContext() != EGL14.EGL_NO_CONTEXT;
  }
  
  private boolean isOldChainFollowSerial(ArrayList<Integer> paramArrayList)
  {
    boolean bool2 = true;
    int j = ((Integer)paramArrayList.get(0)).intValue();
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      int k;
      if (i < paramArrayList.size())
      {
        k = ((Integer)paramArrayList.get(i)).intValue();
        if (j > k) {
          bool1 = false;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
      j = k;
    }
  }
  
  private void newAddQuote(FilterChain paramFilterChain)
  {
    if (paramFilterChain.mFilters != null)
    {
      int i = 0;
      while (i < paramFilterChain.mFilters.length)
      {
        int j = paramFilterChain.mFilters[i];
        QQBaseFilter localQQBaseFilter = this.mCacheQueue.getFilterByTypeWithCreate(j, this.mCommonParam);
        localQQBaseFilter.mQuoteCount.getAndIncrement();
        localQQBaseFilter.setSpecificParam(paramFilterChain.getParam(i));
        i += 1;
      }
    }
  }
  
  private void popAndReleaseInternal(String paramString, boolean paramBoolean)
  {
    FilterChain localFilterChain;
    for (;;)
    {
      try
      {
        checkThreadSecurity("popAndReleaseInternal");
        try
        {
          localFilterChain = (FilterChain)this.mChains.peek();
          if (localFilterChain != null) {
            break label59;
          }
          this.mChains.pop();
          printLog("popAndReleaseInternal", "currentChain=null", null);
        }
        catch (EmptyStackException paramString)
        {
          printLog("popAndReleaseInternal", "EmptyStackException", paramString);
          continue;
        }
        return;
      }
      finally {}
      label59:
      if (TextUtils.isEmpty(paramString)) {
        throw new RuntimeException("popAndRelease Id=" + paramString + " needRelease=" + paramBoolean + " realID=" + localFilterChain.mId);
      }
      if (!localFilterChain.mId.equalsIgnoreCase(paramString)) {
        break;
      }
      this.mChains.pop();
      printLog("popAndReleaseInternal", "pop " + localFilterChain.info, null);
      runChainPauseInternal(localFilterChain);
      decQuote(localFilterChain);
      recoveryTopChainParams();
      printLog("popAndReleaseInternal", "needRelease " + paramBoolean, null);
      if (paramBoolean) {
        releaseChainResource(localFilterChain);
      }
    }
    throw new RuntimeException("popAndRelease Id=" + paramString + " currentChain.mId=" + localFilterChain.mId);
  }
  
  private static void printLog(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramThrowable != null) {
      if (SLog.isEnable()) {
        SLog.e("FilterManagerInternal", paramString1 + ": " + paramString2, paramThrowable);
      }
    }
    while (!SLog.isEnable()) {
      return;
    }
    SLog.i("FilterManagerInternal", paramString1 + ": " + paramString2);
  }
  
  /* Error */
  private void printStackReleaseInfo()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:mChains	Ljava/util/Stack;
    //   6: invokevirtual 242	java/util/Stack:peek	()Ljava/lang/Object;
    //   9: checkcast 6	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +33 -> 47
    //   17: ldc_w 308
    //   20: new 104	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 310
    //   30: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: getfield 276	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain:info	Ljava/lang/String;
    //   37: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: aconst_null
    //   44: invokestatic 123	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:printLog	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   47: aload_0
    //   48: getfield 42	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:mChains	Ljava/util/Stack;
    //   51: invokevirtual 50	java/util/Stack:size	()I
    //   54: ifle +81 -> 135
    //   57: aload_0
    //   58: getfield 42	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:mChains	Ljava/util/Stack;
    //   61: invokevirtual 57	java/util/Stack:iterator	()Ljava/util/Iterator;
    //   64: astore_1
    //   65: aload_1
    //   66: invokeinterface 63 1 0
    //   71: ifeq +61 -> 132
    //   74: aload_1
    //   75: invokeinterface 67 1 0
    //   80: checkcast 6	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain
    //   83: astore_2
    //   84: aload_2
    //   85: ifnull -20 -> 65
    //   88: ldc_w 308
    //   91: new 104	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 312
    //   101: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_2
    //   105: getfield 276	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain:info	Ljava/lang/String;
    //   108: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: aconst_null
    //   115: invokestatic 123	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:printLog	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   118: goto -53 -> 65
    //   121: astore_1
    //   122: ldc_w 308
    //   125: ldc_w 314
    //   128: aconst_null
    //   129: invokestatic 123	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:printLog	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: aload_0
    //   133: monitorexit
    //   134: return
    //   135: ldc_w 308
    //   138: ldc_w 316
    //   141: aconst_null
    //   142: invokestatic 123	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:printLog	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   145: goto -13 -> 132
    //   148: astore_1
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	FilterManagerInternal
    //   12	63	1	localObject1	Object
    //   121	1	1	localEmptyStackException	EmptyStackException
    //   148	4	1	localObject2	Object
    //   83	22	2	localFilterChain	FilterChain
    // Exception table:
    //   from	to	target	type
    //   2	13	121	java/util/EmptyStackException
    //   17	47	121	java/util/EmptyStackException
    //   47	65	121	java/util/EmptyStackException
    //   65	84	121	java/util/EmptyStackException
    //   88	118	121	java/util/EmptyStackException
    //   135	145	121	java/util/EmptyStackException
    //   2	13	148	finally
    //   17	47	148	finally
    //   47	65	148	finally
    //   65	84	148	finally
    //   88	118	148	finally
    //   122	132	148	finally
    //   135	145	148	finally
  }
  
  private String pushChainInternal(int[] paramArrayOfInt, Object[] paramArrayOfObject)
  {
    try
    {
      FilterChain localFilterChain = (FilterChain)this.mChains.peek();
      paramArrayOfInt = new FilterChain(paramArrayOfInt, paramArrayOfObject);
      paramArrayOfInt.oldTopChain = localFilterChain;
      newAddQuote(paramArrayOfInt);
      this.mChains.push(paramArrayOfInt);
      printLog("pushChainInternal", paramArrayOfInt.info, null);
      checkStackIsLeakage();
      paramArrayOfInt = paramArrayOfInt.getId();
      return paramArrayOfInt;
    }
    catch (EmptyStackException localEmptyStackException)
    {
      for (;;)
      {
        localEmptyStackException.printStackTrace();
        printLog("pushChainInternal", " EmptyStackException[First push] size=" + this.mChains.size(), null);
        Object localObject = null;
      }
    }
    finally {}
  }
  
  private void pushChainRunSecurity(FilterChain paramFilterChain1, FilterChain paramFilterChain2)
  {
    initHighCache(paramFilterChain1);
    if (paramFilterChain2 != null) {
      runChainPauseInternal(paramFilterChain2);
    }
  }
  
  private void recoveryTopChainParams()
  {
    try
    {
      FilterChain localFilterChain = (FilterChain)this.mChains.peek();
      if (localFilterChain == null)
      {
        this.mChains.pop();
        printLog("recoveryTopChainParams", "peek currentChain=null", null);
        return;
      }
    }
    catch (EmptyStackException localEmptyStackException)
    {
      while (!SLog.isEnable()) {}
      SLog.e("FilterManagerInternal", "recoveryTopChainParams: peek=null", localEmptyStackException);
      return;
    }
    printLog("recoveryTopChainParams", "peek " + localEmptyStackException.info, null);
    if (localEmptyStackException.mFilters != null)
    {
      int i = 0;
      while (i < localEmptyStackException.mFilters.length)
      {
        ((QQBaseFilter)localEmptyStackException.mHighCache.get(i)).setSpecificParam(localEmptyStackException.getParam(i));
        i += 1;
      }
    }
    runChainResumeInternal(localEmptyStackException);
  }
  
  private void releaseChainResource(FilterChain paramFilterChain)
  {
    printLog("releaseChainResource", paramFilterChain.info, null);
    if (paramFilterChain.mFilters != null)
    {
      paramFilterChain = paramFilterChain.mFilters;
      int j = paramFilterChain.length;
      int i = 0;
      while (i < j)
      {
        int k = paramFilterChain[i];
        QQBaseFilter localQQBaseFilter = this.mCacheQueue.getFilterByType(k);
        if (localQQBaseFilter.mQuoteCount.get() == 0)
        {
          printLog("releaseChainResource", " [cnt=0] name=" + localQQBaseFilter.getClass().getName(), null);
          localQQBaseFilter.onSurfaceDestroy();
          localQQBaseFilter.mStatus = 0;
          this.mCacheQueue.removeFilter(k);
        }
        i += 1;
      }
    }
  }
  
  private void runChainPauseInternal(FilterChain paramFilterChain)
  {
    if ((paramFilterChain != null) && (paramFilterChain.mFilters != null))
    {
      Iterator localIterator = paramFilterChain.mHighCache.iterator();
      while (localIterator.hasNext()) {
        ((QQBaseFilter)localIterator.next()).onPause();
      }
      printLog("runChainPauseInternal ", paramFilterChain.info, null);
    }
  }
  
  private void runChainResumeInternal(FilterChain paramFilterChain)
  {
    if ((paramFilterChain != null) && (paramFilterChain.mFilters != null))
    {
      Iterator localIterator = paramFilterChain.mHighCache.iterator();
      while (localIterator.hasNext()) {
        ((QQBaseFilter)localIterator.next()).onResume();
      }
      printLog("runChainResumeInternal ", paramFilterChain.info, null);
    }
  }
  
  void changeCamera(int paramInt)
  {
    if (!this.mReleased)
    {
      Iterator localIterator = this.mCacheQueue.getFilterList().iterator();
      while (localIterator.hasNext()) {
        ((QQBaseFilter)localIterator.next()).onChangeCamera(paramInt);
      }
    }
  }
  
  QQBaseFilter currentChainGetFilter(int paramInt)
  {
    try
    {
      Object localObject = (FilterChain)this.mChains.peek();
      if ((localObject != null) && (((FilterChain)localObject).hasFilterType(paramInt)))
      {
        localObject = this.mCacheQueue.getFilterByType(paramInt);
        return localObject;
      }
    }
    catch (EmptyStackException localEmptyStackException)
    {
      if (SLog.isEnable()) {
        SLog.e("FilterManagerInternal", "currentChainGetFilter: EmptyStackException ", null);
      }
    }
    return null;
  }
  
  boolean currentChinaHasFilter(int paramInt)
  {
    try
    {
      FilterChain localFilterChain = (FilterChain)this.mChains.peek();
      if (localFilterChain != null)
      {
        boolean bool = localFilterChain.hasFilterType(paramInt);
        return bool;
      }
    }
    catch (EmptyStackException localEmptyStackException)
    {
      if (SLog.isEnable()) {
        SLog.e("FilterManagerInternal", "currentChinaHasFilter: EmptyStackException ", localEmptyStackException);
      }
    }
    return false;
  }
  
  /* Error */
  final String generateStackTrace()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 104	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   9: astore_2
    //   10: aload_0
    //   11: getfield 42	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:mChains	Ljava/util/Stack;
    //   14: invokevirtual 242	java/util/Stack:peek	()Ljava/lang/Object;
    //   17: checkcast 6	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain
    //   20: astore_3
    //   21: aload_2
    //   22: ldc_w 408
    //   25: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_3
    //   30: ifnull +96 -> 126
    //   33: aload_2
    //   34: aload_3
    //   35: getfield 276	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain:info	Ljava/lang/String;
    //   38: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: ldc_w 410
    //   46: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_2
    //   51: ldc_w 412
    //   54: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_0
    //   59: getfield 42	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:mChains	Ljava/util/Stack;
    //   62: invokevirtual 50	java/util/Stack:size	()I
    //   65: istore_1
    //   66: aload_2
    //   67: iload_1
    //   68: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: iload_1
    //   73: ifle +73 -> 146
    //   76: aload_0
    //   77: getfield 42	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:mChains	Ljava/util/Stack;
    //   80: invokevirtual 50	java/util/Stack:size	()I
    //   83: iconst_1
    //   84: isub
    //   85: istore_1
    //   86: iload_1
    //   87: iflt +59 -> 146
    //   90: aload_0
    //   91: getfield 42	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:mChains	Ljava/util/Stack;
    //   94: iload_1
    //   95: invokevirtual 413	java/util/Stack:get	(I)Ljava/lang/Object;
    //   98: checkcast 6	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain
    //   101: astore_3
    //   102: aload_2
    //   103: ldc_w 410
    //   106: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_2
    //   111: aload_3
    //   112: getfield 276	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain:info	Ljava/lang/String;
    //   115: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: iload_1
    //   120: iconst_1
    //   121: isub
    //   122: istore_1
    //   123: goto -37 -> 86
    //   126: aload_2
    //   127: ldc_w 415
    //   130: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: goto -92 -> 42
    //   137: astore_3
    //   138: aload_2
    //   139: ldc_w 417
    //   142: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_2
    //   147: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: astore_2
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_2
    //   154: areturn
    //   155: astore_2
    //   156: aload_0
    //   157: monitorexit
    //   158: aload_2
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	FilterManagerInternal
    //   65	58	1	i	int
    //   9	145	2	localObject1	Object
    //   155	4	2	localObject2	Object
    //   20	92	3	localFilterChain	FilterChain
    //   137	1	3	localEmptyStackException	EmptyStackException
    // Exception table:
    //   from	to	target	type
    //   10	29	137	java/util/EmptyStackException
    //   33	42	137	java/util/EmptyStackException
    //   42	72	137	java/util/EmptyStackException
    //   76	86	137	java/util/EmptyStackException
    //   90	119	137	java/util/EmptyStackException
    //   126	134	137	java/util/EmptyStackException
    //   2	10	155	finally
    //   10	29	155	finally
    //   33	42	155	finally
    //   42	72	155	finally
    //   76	86	155	finally
    //   90	119	155	finally
    //   126	134	155	finally
    //   138	146	155	finally
    //   146	151	155	finally
  }
  
  void getAllActiveFilter(List<QQBaseFilter> paramList)
  {
    Iterator localIterator = this.mCacheQueue.getFilterList().iterator();
    while (localIterator.hasNext())
    {
      QQBaseFilter localQQBaseFilter = (QQBaseFilter)localIterator.next();
      if (localQQBaseFilter.isFilterWork()) {
        paramList.add(localQQBaseFilter);
      }
    }
  }
  
  String getCacheFilterInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.mCacheQueue.getFilterList();
    int i = ((Collection)localObject).size();
    localStringBuilder.append(i);
    localStringBuilder.append(" : ");
    if (i > 0)
    {
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStringBuilder.append(FilterCreateFactory.getFilterTag(((QQBaseFilter)((Iterator)localObject).next()).mFilterType));
        localStringBuilder.append('|');
      }
      return localStringBuilder.substring(0, localStringBuilder.length() - 1);
    }
    return "empty!";
  }
  
  final boolean getCurrentChainData(ArrayList<Integer> paramArrayList, ArrayList<Object> paramArrayList1)
  {
    try
    {
      FilterChain localFilterChain = (FilterChain)this.mChains.peek();
      if (localFilterChain != null)
      {
        localFilterChain.getFilterTypes(paramArrayList);
        localFilterChain.getFilterParams(paramArrayList1);
        return true;
      }
    }
    catch (EmptyStackException paramArrayList)
    {
      if (SLog.isEnable()) {
        SLog.e("FilterManagerInternal", "getCurrentChainData: EmptyStackException ", paramArrayList);
      }
    }
    return false;
  }
  
  final String getCurrentChainId()
  {
    try
    {
      Object localObject = (FilterChain)this.mChains.peek();
      if (localObject != null)
      {
        localObject = ((FilterChain)localObject).getId();
        return localObject;
      }
    }
    catch (EmptyStackException localEmptyStackException)
    {
      if (SLog.isEnable()) {
        SLog.e("FilterManagerInternal", "getCurrentChainId: EmptyStackException ", localEmptyStackException);
      }
    }
    return null;
  }
  
  Object getFilterSpecificParam(int paramInt)
  {
    try
    {
      Object localObject = (FilterChain)this.mChains.peek();
      if ((localObject != null) && (((FilterChain)localObject).hasFilterType(paramInt)))
      {
        localObject = this.mCacheQueue.getFilterByType(paramInt).getSpecificParam();
        return localObject;
      }
    }
    catch (EmptyStackException localEmptyStackException)
    {
      if (SLog.isEnable()) {
        SLog.e("FilterManagerInternal", "getFilterSpecificParam: EmptyStackException ", localEmptyStackException);
      }
    }
    return null;
  }
  
  final boolean hasAllResourceActiveFilter()
  {
    Iterator localIterator = this.mCacheQueue.getFilterList().iterator();
    while (localIterator.hasNext()) {
      if (((QQBaseFilter)localIterator.next()).isFilterWork()) {
        return true;
      }
    }
    return false;
  }
  
  String insertNewFilterToOldChain_pushChain(int paramInt, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((getCurrentChainData(localArrayList1, localArrayList2)) && (localArrayList1.size() > 0)) {
      if (isOldChainFollowSerial(localArrayList1)) {
        insertFollowSerial(paramInt, paramObject, localArrayList1, localArrayList2);
      }
    }
    for (;;)
    {
      return push(localArrayList1, localArrayList2);
      int j = localArrayList1.size();
      int k = localArrayList2.size();
      int i = 0;
      while (i < j - k)
      {
        localArrayList2.add(null);
        i += 1;
      }
      localArrayList1.add(Integer.valueOf(paramInt));
      localArrayList2.add(paramObject);
      continue;
      localArrayList1.add(Integer.valueOf(paramInt));
      localArrayList2.add(paramObject);
    }
  }
  
  boolean isFilterWork(int paramInt)
  {
    try
    {
      FilterChain localFilterChain = (FilterChain)this.mChains.peek();
      if ((localFilterChain != null) && (localFilterChain.hasFilterType(paramInt)))
      {
        boolean bool = this.mCacheQueue.getFilterByType(paramInt).isFilterWork();
        return bool;
      }
    }
    catch (EmptyStackException localEmptyStackException)
    {
      if (SLog.isEnable()) {
        SLog.e("FilterManagerInternal", "isFilterWork: EmptyStackException ", localEmptyStackException);
      }
    }
    return false;
  }
  
  boolean needFaceDetect()
  {
    return this.needFaceDetect;
  }
  
  final void onCurrentChainPause()
  {
    try
    {
      checkThreadSecurity("onCurrentChainPause");
      runChainPauseInternal((FilterChain)this.mChains.peek());
      return;
    }
    catch (EmptyStackException localEmptyStackException)
    {
      while (!SLog.isEnable()) {}
      SLog.e("FilterManagerInternal", "onCurrentChainPause: EmptyStackException ", localEmptyStackException);
    }
  }
  
  final void onCurrentChainResume()
  {
    try
    {
      checkThreadSecurity("onCurrentChainResume");
      runChainResumeInternal((FilterChain)this.mChains.peek());
      return;
    }
    catch (EmptyStackException localEmptyStackException)
    {
      while (!SLog.isEnable()) {}
      SLog.e("FilterManagerInternal", "onCurrentChainResume: EmptyStackException ", localEmptyStackException);
    }
  }
  
  void pop(String paramString)
  {
    popAndReleaseInternal(paramString, false);
  }
  
  void popAndRelease(String paramString)
  {
    popAndReleaseInternal(paramString, true);
  }
  
  String push(ArrayList<Integer> paramArrayList, ArrayList<Object> paramArrayList1)
  {
    Object localObject = null;
    if (paramArrayList != null)
    {
      localObject = new int[paramArrayList.size()];
      int i = 0;
      while (i < paramArrayList.size())
      {
        localObject[i] = ((Integer)paramArrayList.get(i)).intValue();
        i += 1;
      }
      if (paramArrayList1 == null) {
        break label68;
      }
    }
    label68:
    for (paramArrayList = paramArrayList1.toArray();; paramArrayList = null)
    {
      localObject = push((int[])localObject, paramArrayList);
      return localObject;
    }
  }
  
  String push(int[] paramArrayOfInt)
  {
    return push(paramArrayOfInt, null);
  }
  
  String push(int[] paramArrayOfInt, Object[] paramArrayOfObject)
  {
    return pushChainInternal(paramArrayOfInt, paramArrayOfObject);
  }
  
  void releaseAllResource()
  {
    printLog("releaseAllResource", "releaseAllResource currentThreadName=" + Thread.currentThread().getName(), null);
    this.mReleased = true;
    printStackReleaseInfo();
    this.mChains.clear();
    Iterator localIterator = this.mCacheQueue.getFilterList().iterator();
    while (localIterator.hasNext())
    {
      QQBaseFilter localQQBaseFilter = (QQBaseFilter)localIterator.next();
      localQQBaseFilter.onSurfaceDestroy();
      localQQBaseFilter.mStatus = 0;
      printLog("releaseAllResource", "releaseAllResource " + localQQBaseFilter.getClass().getName(), null);
    }
    this.mCacheQueue.clearAll();
  }
  
  int runChain(int paramInt)
  {
    printLog("runChain", "runChain currentThreadName=" + Thread.currentThread().getName(), null);
    if (this.mReleased) {
      SLog.e("FilterManagerInternal", "runChain: mReleased=true");
    }
    Object localObject1;
    do
    {
      return paramInt;
      try
      {
        FilterChain localFilterChain = (FilterChain)this.mChains.peek();
        if (localFilterChain == null)
        {
          printLog("runChain", "peek currentChain=null", null);
          return paramInt;
        }
      }
      catch (EmptyStackException localEmptyStackException)
      {
        for (;;)
        {
          printLog("FilterManagerInternal", "peek == null", null);
          localObject1 = null;
        }
      }
    } while (((FilterChain)localObject1).mFilters == null);
    if (((FilterChain)localObject1).mCreateResume) {
      pushChainRunSecurity((FilterChain)localObject1, ((FilterChain)localObject1).oldTopChain);
    }
    Object localObject2 = ((FilterChain)localObject1).mHighCache.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      QQBaseFilter localQQBaseFilter = (QQBaseFilter)((Iterator)localObject2).next();
      if (localQQBaseFilter.mStatus == 0)
      {
        localQQBaseFilter.onSurfaceCreate();
        localQQBaseFilter.onSurfaceChange(this.mCommonParam.getFilterWidth(), this.mCommonParam.getFilterHeight());
        localQQBaseFilter.mStatus = 2;
      }
      else if (localQQBaseFilter.mStatus == 1)
      {
        localQQBaseFilter.onSurfaceChange(this.mCommonParam.getFilterWidth(), this.mCommonParam.getFilterHeight());
        localQQBaseFilter.mStatus = 2;
      }
    }
    if (((FilterChain)localObject1).mCreateResume)
    {
      runChainResumeInternal((FilterChain)localObject1);
      ((FilterChain)localObject1).mCreateResume = false;
    }
    this.needFaceDetect = false;
    localObject2 = ((FilterChain)localObject1).mHighCache.iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (((QQBaseFilter)((Iterator)localObject2).next()).needFaceDetect()) {
        this.needFaceDetect = true;
      }
    }
    QQFilterLogManager.setLogStart("mFaceDetect");
    localObject2 = this.mFaceDetect;
    if (this.needFaceDetect) {}
    for (int i = 1;; i = 2)
    {
      ((QQFaceDetectBase)localObject2).setFaceDetectType(i);
      this.mFaceDetect.setCaptureMode(this.isCaptureMode);
      i = paramInt;
      if (this.needFaceDetect)
      {
        this.mFaceDetect.setInputTextureID(paramInt);
        this.mFaceDetect.onDrawFrame();
        i = this.mFaceDetect.getOutputTextureID();
      }
      QQFilterLogManager.setLogEnd("mFaceDetect: needFaceDetect=" + this.needFaceDetect);
      localObject1 = ((FilterChain)localObject1).mHighCache.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (QQBaseFilter)((Iterator)localObject1).next();
        ((QQBaseFilter)localObject2).setCaptureMode(this.isCaptureMode);
        QQFilterLogManager.setOnDrawFilterStart();
        ((QQBaseFilter)localObject2).setInputTextureID(i);
        ((QQBaseFilter)localObject2).onDrawFrame();
        i = ((QQBaseFilter)localObject2).getOutputTextureID();
        QQFilterLogManager.setOnDrawFilterEnd("runChain: " + localObject2.getClass().getName());
      }
    }
    GLES20.glDisable(2929);
    FrameBufferCache.getInstance().forceRecycle();
    return i;
  }
  
  public void setCaptureMode(boolean paramBoolean)
  {
    this.isCaptureMode = paramBoolean;
  }
  
  void setCommonParam(QQFilterRenderManager paramQQFilterRenderManager)
  {
    this.mCommonParam = paramQQFilterRenderManager;
    this.mFaceDetect = new QQFaceDetectBase(paramQQFilterRenderManager);
  }
  
  void setFilterSpecificParam(int paramInt, Object paramObject)
  {
    try
    {
      FilterChain localFilterChain = (FilterChain)this.mChains.peek();
      if ((localFilterChain != null) && (localFilterChain.hasFilterType(paramInt))) {
        this.mCacheQueue.getFilterByType(paramInt).setSpecificParam(paramObject);
      }
      return;
    }
    catch (EmptyStackException localEmptyStackException)
    {
      for (;;)
      {
        if (SLog.isEnable()) {
          SLog.e("FilterManagerInternal", "setFilterSpecificParam: EmptyStackException ", localEmptyStackException);
        }
        Object localObject = null;
      }
    }
  }
  
  void setNeedFaceDetectFlip(boolean paramBoolean)
  {
    this.mFaceDetect.setNeedFlip(paramBoolean);
  }
  
  class FilterChain
  {
    String info;
    boolean mCreateResume = true;
    int[] mFilters;
    ArrayList<QQBaseFilter> mHighCache = new ArrayList();
    String mId;
    Object[] mParams;
    FilterChain oldTopChain = null;
    
    FilterChain(int[] paramArrayOfInt, Object[] paramArrayOfObject)
    {
      this.mFilters = paramArrayOfInt;
      this.mParams = paramArrayOfObject;
      generateID();
      this.info = FilterCreateFactory.getLogInfo(this.mFilters);
    }
    
    void generateID()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.mFilters != null)
      {
        int[] arrayOfInt = this.mFilters;
        int j = arrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          localStringBuilder.append(arrayOfInt[i]);
          localStringBuilder.append("_");
          i += 1;
        }
      }
      this.mId = localStringBuilder.toString();
    }
    
    void getFilterParams(ArrayList<Object> paramArrayList)
    {
      if (this.mParams != null) {
        paramArrayList.addAll(Arrays.asList(this.mParams));
      }
    }
    
    void getFilterTypes(ArrayList<Integer> paramArrayList)
    {
      if (this.mFilters != null)
      {
        int[] arrayOfInt = this.mFilters;
        int j = arrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          paramArrayList.add(Integer.valueOf(arrayOfInt[i]));
          i += 1;
        }
      }
    }
    
    String getId()
    {
      return this.mId;
    }
    
    Object getParam(int paramInt)
    {
      if ((this.mParams != null) && (paramInt >= 0) && (paramInt < this.mParams.length)) {
        return this.mParams[paramInt];
      }
      return null;
    }
    
    boolean hasFilterType(int paramInt)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      int[] arrayOfInt;
      int j;
      int i;
      if (this.mFilters != null)
      {
        arrayOfInt = this.mFilters;
        j = arrayOfInt.length;
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < j)
        {
          if (arrayOfInt[i] == paramInt) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.FilterManagerInternal
 * JD-Core Version:    0.7.0.1
 */