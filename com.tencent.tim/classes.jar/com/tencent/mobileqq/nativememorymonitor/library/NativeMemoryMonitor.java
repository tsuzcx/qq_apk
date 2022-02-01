package com.tencent.mobileqq.nativememorymonitor.library;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class NativeMemoryMonitor
{
  public static final String ALL_SO_HOOK = "all_so_hook";
  public static final long FLAG_JNI_CALLXXMETHOD_MONITOR = 32L;
  public static final long FLAG_JNI_GLOBAL_REF_MONITOR = 1L;
  public static final long FLAG_JNI_LOCAL_REF_MONITOR = 2L;
  public static final long FLAG_JNI_LONG_SET_FIELD_MONITOR = 8L;
  public static final long FLAG_JNI_NATIVE_THREAD_MONITOR = 64L;
  public static final long FLAG_JNI_PRIMITIVE_ARRAY_MONITOR = 4L;
  public static final long FLAG_JNI_WEAK_GLOBAL_REF_MONITOR = 16L;
  public static final long FLAG_LARGE_OBJECT_ALLOC_MONITOR = 4294967296L;
  public static final long FLAG_LOG_ALL = 4611686018427387904L;
  public static final long FLAG_OVER_ALLOCATE_PER_TIME_MONITOR = 2147483648L;
  private static final String TAG = "NativeMemoryMonitor";
  private static ExternalProvider externalProvider;
  private static volatile boolean sFileHooked;
  private static volatile boolean sOpenFileHooked;
  private static volatile boolean sSoLoadRes = false;
  private static volatile boolean sSoLoaded = false;
  private static volatile boolean soLoadHooked;
  private final Set<IFileMonitor> fileMonitors = new HashSet();
  private ReadWriteLock fileMonitorsLock = new ReentrantReadWriteLock();
  private boolean mInit = false;
  private boolean mInitThreadHook = false;
  
  private native boolean applyHiddenApiPolicyCrack(ApplicationInfo paramApplicationInfo);
  
  public static NativeMemoryMonitor getInstance(Context paramContext)
  {
    loadSoIfNeeded(paramContext);
    return Holder.INSTANCE;
  }
  
  private static void loadSoIfNeeded(Context paramContext)
  {
    if (!sSoLoaded) {
      if ((!SoLoadUtilNew.loadSoByName(paramContext, "c++_shared")) || (!SoLoadUtilNew.loadSoByName(paramContext, "native-memory-library-lib"))) {
        break label59;
      }
    }
    label59:
    for (boolean bool = true;; bool = false)
    {
      sSoLoadRes = bool;
      logErrorFromNative("load so res: " + sSoLoadRes);
      sSoLoaded = true;
      return;
    }
  }
  
  private static void logErrorFromNative(String paramString)
  {
    try
    {
      QLog.e("NativeMemoryMonitor", 1, paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.d("NativeMemoryMonitor", "try to log " + paramString + " but QLog is not found");
    }
  }
  
  private static void logInfoFromNative(String paramString)
  {
    try
    {
      QLog.i("NativeMemoryMonitor", 2, paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.d("NativeMemoryMonitor", "try to log " + paramString + " but QLog is not found");
    }
  }
  
  private native void nativeDump();
  
  private native void nativeFileHook(long paramLong1, long paramLong2);
  
  private native int nativeGetJavaThreadPeakCount();
  
  private native void nativeInit(long paramLong1, String[] paramArrayOfString, long paramLong2, long paramLong3, long paramLong4);
  
  private native void nativeJniHookInit(long paramLong1, long paramLong2);
  
  private native void nativeOpenFileHook(long paramLong);
  
  private native void nativeSoLoadHook(String paramString1, String paramString2, long paramLong);
  
  private native void nativeThreadCreateHookInit(String paramString);
  
  private native void nativeThreadHook();
  
  private void onFileOpen(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      this.fileMonitorsLock.readLock().lock();
      Iterator localIterator = this.fileMonitors.iterator();
      while (localIterator.hasNext())
      {
        IFileMonitor localIFileMonitor = (IFileMonitor)localIterator.next();
        try
        {
          localIFileMonitor.onFileOpen(paramString, paramInt1, paramInt2);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("NativeMemoryMonitor", 1, localThrowable, new Object[0]);
        }
      }
    }
    finally
    {
      this.fileMonitorsLock.readLock().unlock();
    }
  }
  
  private void onFileRemove(String paramString)
  {
    try
    {
      this.fileMonitorsLock.readLock().lock();
      Iterator localIterator = this.fileMonitors.iterator();
      while (localIterator.hasNext())
      {
        IFileMonitor localIFileMonitor = (IFileMonitor)localIterator.next();
        try
        {
          localIFileMonitor.onFileRemove(paramString);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("NativeMemoryMonitor", 1, localThrowable, new Object[0]);
        }
      }
    }
    finally
    {
      this.fileMonitorsLock.readLock().unlock();
    }
  }
  
  private void onFileRename(String paramString1, String paramString2)
  {
    try
    {
      this.fileMonitorsLock.readLock().lock();
      Iterator localIterator = this.fileMonitors.iterator();
      while (localIterator.hasNext())
      {
        IFileMonitor localIFileMonitor = (IFileMonitor)localIterator.next();
        try
        {
          localIFileMonitor.onFileRename(paramString1, paramString2);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("NativeMemoryMonitor", 1, localThrowable, new Object[0]);
        }
      }
    }
    finally
    {
      this.fileMonitorsLock.readLock().unlock();
    }
  }
  
  private static void onSoLoad(String paramString1, String paramString2)
  {
    ExternalProvider localExternalProvider = externalProvider;
    if (localExternalProvider != null)
    {
      String str = paramString2.replaceAll("\\t", " ");
      paramString2 = str;
      if (str.startsWith("java.lang.Throwable: \n")) {
        paramString2 = str.substring("java.lang.Throwable: \n".length());
      }
      localExternalProvider.onSoLoad(paramString1, paramString2);
    }
  }
  
  private void setupOpenHook()
  {
    if (!sOpenFileHooked)
    {
      sOpenFileHooked = true;
      if (Build.VERSION.SDK_INT > 28) {
        nativeOpenFileHook(Utils.getHiddenArtMethod("libcore.io.Linux", "open", new Class[] { String.class, Integer.TYPE, Integer.TYPE }));
      }
    }
    else
    {
      return;
    }
    nativeOpenFileHook(0L);
  }
  
  private void setupRemoveHook()
  {
    if (!sFileHooked)
    {
      sFileHooked = true;
      if (Build.VERSION.SDK_INT > 28) {
        nativeFileHook(Utils.getHiddenArtMethod("libcore.io.Linux", "remove", new Class[] { String.class }), Utils.getHiddenArtMethod("libcore.io.Linux", "rename", new Class[] { String.class, String.class }));
      }
    }
    else
    {
      return;
    }
    if (Build.VERSION.SDK_INT == 28)
    {
      nativeFileHook(Utils.getHiddenArtMethod("java.io.UnixFileSystem", "delete0", new Class[] { File.class }), Utils.getHiddenArtMethod("java.io.UnixFileSystem", "rename0", new Class[] { File.class, File.class }));
      return;
    }
    nativeFileHook(0L, 0L);
  }
  
  public boolean applyHiddenApiPolicyCrack(Context paramContext)
  {
    return applyHiddenApiPolicyCrack(paramContext.getApplicationInfo());
  }
  
  public void dump()
  {
    try
    {
      nativeDump();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getJavaThreadPeakCount()
  {
    if (!sSoLoadRes) {
      return 0;
    }
    return nativeGetJavaThreadPeakCount();
  }
  
  public native String getUndetachThreads();
  
  public void init(long paramLong1, String[] paramArrayOfString, long paramLong2, long paramLong3, long paramLong4)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.mInit;
        if (bool) {
          return;
        }
        if (!sSoLoadRes)
        {
          logErrorFromNative("SoLoad fail");
          continue;
        }
        logErrorFromNative("init");
      }
      finally {}
      logInfoFromNative("init");
      nativeInit(paramLong1, paramArrayOfString, paramLong2, paramLong3, paramLong4);
      this.mInit = true;
    }
  }
  
  /* Error */
  public void initThreadHook(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 66	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:sSoLoadRes	Z
    //   5: istore_2
    //   6: iload_2
    //   7: ifne +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: getfield 74	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:mInitThreadHook	Z
    //   17: ifne -7 -> 10
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 74	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:mInitThreadHook	Z
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial 313	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:nativeThreadCreateHookInit	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: invokespecial 315	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:nativeThreadHook	()V
    //   34: goto -24 -> 10
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	NativeMemoryMonitor
    //   0	42	1	paramString	String
    //   5	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	6	37	finally
    //   13	34	37	finally
  }
  
  public void removeFileMonitor(IFileMonitor paramIFileMonitor)
  {
    try
    {
      this.fileMonitorsLock.writeLock().lock();
      this.fileMonitors.remove(paramIFileMonitor);
      return;
    }
    finally
    {
      this.fileMonitorsLock.writeLock().unlock();
    }
  }
  
  public native void setupASanCallback();
  
  public void setupFileHook(@NonNull IFileMonitor paramIFileMonitor, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 29) {
        break label17;
      }
    }
    finally
    {
      try
      {
        for (;;)
        {
          label17:
          this.fileMonitorsLock.writeLock().lock();
          this.fileMonitors.add(paramIFileMonitor);
          this.fileMonitorsLock.writeLock().unlock();
          ClassToFindJniOffset.initFromJava();
          nativeJniHookInit(ClassToFindJniOffset.markArtMethod, ClassToFindJniOffset.mark2ArtMethod);
          if (paramBoolean1) {
            setupRemoveHook();
          }
          if (paramBoolean2) {
            setupOpenHook();
          }
        }
      }
      finally
      {
        this.fileMonitorsLock.writeLock().unlock();
      }
      paramIFileMonitor = finally;
    }
  }
  
  /* Error */
  public void setupSoLoadHook(Context paramContext, ExternalProvider paramExternalProvider)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: putstatic 213	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:externalProvider	Lcom/tencent/mobileqq/nativememorymonitor/library/ExternalProvider;
    //   6: getstatic 352	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:soLoadHooked	Z
    //   9: istore_3
    //   10: iload_3
    //   11: ifeq +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_1
    //   18: invokevirtual 293	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   21: astore_2
    //   22: invokestatic 335	com/tencent/mobileqq/nativememorymonitor/library/ClassToFindJniOffset:initFromJava	()V
    //   25: aload_0
    //   26: getstatic 338	com/tencent/mobileqq/nativememorymonitor/library/ClassToFindJniOffset:markArtMethod	J
    //   29: getstatic 341	com/tencent/mobileqq/nativememorymonitor/library/ClassToFindJniOffset:mark2ArtMethod	J
    //   32: invokespecial 343	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:nativeJniHookInit	(JJ)V
    //   35: aload_1
    //   36: invokevirtual 355	android/content/Context:getPackageName	()Ljava/lang/String;
    //   39: astore_1
    //   40: aload_2
    //   41: getfield 360	android/content/pm/ApplicationInfo:nativeLibraryDir	Ljava/lang/String;
    //   44: astore_2
    //   45: getstatic 249	android/os/Build$VERSION:SDK_INT	I
    //   48: bipush 29
    //   50: if_icmpge +26 -> 76
    //   53: lconst_0
    //   54: lstore 4
    //   56: aload_0
    //   57: aload_1
    //   58: aload_2
    //   59: lload 4
    //   61: invokespecial 362	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:nativeSoLoadHook	(Ljava/lang/String;Ljava/lang/String;J)V
    //   64: iconst_1
    //   65: putstatic 352	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:soLoadHooked	Z
    //   68: goto -54 -> 14
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    //   76: ldc_w 364
    //   79: ldc_w 366
    //   82: iconst_3
    //   83: anewarray 255	java/lang/Class
    //   86: dup
    //   87: iconst_0
    //   88: ldc 219
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: ldc_w 368
    //   96: aastore
    //   97: dup
    //   98: iconst_2
    //   99: ldc 255
    //   101: aastore
    //   102: invokestatic 372	com/tencent/mobileqq/nativememorymonitor/library/Utils:getArtMethod	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)J
    //   105: lstore 4
    //   107: goto -51 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	NativeMemoryMonitor
    //   0	110	1	paramContext	Context
    //   0	110	2	paramExternalProvider	ExternalProvider
    //   9	2	3	bool	boolean
    //   54	52	4	l	long
    // Exception table:
    //   from	to	target	type
    //   2	10	71	finally
    //   17	53	71	finally
    //   56	68	71	finally
    //   76	107	71	finally
  }
  
  static class Holder
  {
    private static NativeMemoryMonitor INSTANCE = new NativeMemoryMonitor(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nativememorymonitor.library.NativeMemoryMonitor
 * JD-Core Version:    0.7.0.1
 */