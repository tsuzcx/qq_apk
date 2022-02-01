package com.tencent.mm.vfs;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class FileSystemManager
  implements Handler.Callback
{
  private static final int BROADCAST_FILE_VERSION = 2;
  private static final String FILE_BROADCAST = "fs.bin";
  private static final String FILE_MAINTENANCE_TIMESTAMP = "maintain.timestamp";
  private static final int MSG_MAINTENANCE = 2;
  private static final int MSG_REFRESH_VFS = 1;
  private static final String TAG = "VFS.FileSystemManager";
  private static final String VFS_DIR = ".vfs";
  @SuppressLint({"StaticFieldLeak"})
  private static volatile Context sContext = null;
  private static volatile KeyGen sKeyGen = null;
  private static volatile boolean sLoadBroadcast = true;
  private static StatisticsCallback sStatisticsCallback;
  private final Context mContext = sContext;
  private final ResolverState mInitialState;
  private Resolution mInvalidResolution;
  private final Object mLock = new Object();
  private final Handler mMaintenanceHandler;
  private volatile long mMaintenanceInterval;
  private final MaintenanceBroadcastReceiver mMaintenanceReceiver;
  private final HandlerThread mMaintenanceThread;
  private volatile boolean mMaintenanceUseWakeLock;
  private volatile long mMaintenanceWaitTime;
  private volatile boolean mPublishOnEditorCommit;
  private volatile BroadcastReceiver mRefreshReceiver;
  private int mRevision;
  private ResolverState mState;
  private final File mVFSDir;
  
  private FileSystemManager()
  {
    if (this.mContext == null) {
      throw new IllegalStateException("Call FileSystemManager.setContext(Context) before calling instance()");
    }
    File localFile2 = this.mContext.getFilesDir().getParentFile();
    File localFile1 = localFile2;
    if (localFile2 == null) {
      localFile1 = this.mContext.getCacheDir();
    }
    this.mVFSDir = new File(localFile1, ".vfs");
    this.mMaintenanceThread = new HandlerThread("VFS.Maintenance", 4);
    this.mMaintenanceThread.start();
    VFSTrack.track(null, "constructor_time");
    this.mMaintenanceHandler = new Handler(this.mMaintenanceThread.getLooper(), this);
    this.mMaintenanceReceiver = new MaintenanceBroadcastReceiver(null);
    this.mMaintenanceWaitTime = -1L;
    this.mMaintenanceInterval = 9223372036854775807L;
    this.mPublishOnEditorCommit = true;
    this.mInitialState = generateInitialState(this.mContext);
    this.mState = this.mInitialState;
    this.mRevision = 0;
    this.mInvalidResolution = new Resolution(null, null, this.mRevision, null);
    VFSTrack.track("constructor_time", null);
  }
  
  private void clearInvalidFiles(CancellationSignalCompat paramCancellationSignalCompat)
  {
    if (sStatisticsCallback != null) {
      sStatisticsCallback.deleteFiles(paramCancellationSignalCompat);
    }
  }
  
  private void doMaintenance(CancellationSignalCompat paramCancellationSignalCompat)
  {
    boolean bool2 = false;
    long l1 = this.mMaintenanceInterval;
    Object localObject = new File(this.mVFSDir, "maintain.timestamp");
    long l2 = System.currentTimeMillis();
    long l3 = ((File)localObject).lastModified();
    if (l2 - l3 < l1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VFS.FileSystemManager", 2, String.format("Maintenance interval not match, skip maintenance. ct=%d, ts=%d, int=%d", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1) }));
      }
      return;
    }
    boolean bool3 = this.mMaintenanceUseWakeLock;
    boolean bool1 = bool3;
    if (bool3)
    {
      bool1 = bool2;
      if (this.mContext.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
        bool1 = true;
      }
    }
    if (bool1) {}
    for (localObject = ((PowerManager)this.mContext.getSystemService("power")).newWakeLock(1, "VFS:Maintenance");; localObject = null) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VFS.FileSystemManager", 2, "Maintenance started. WakeLock: " + bool1);
        }
        if (localObject != null) {
          ((PowerManager.WakeLock)localObject).acquire(1200000L);
        }
        maintain(paramCancellationSignalCompat);
        clearInvalidFiles(paramCancellationSignalCompat);
        if (QLog.isColorLevel()) {
          QLog.d("VFS.FileSystemManager", 2, "Maintenance finished.");
        }
        return;
      }
      catch (OperationCanceledException paramCancellationSignalCompat)
      {
        QLog.e("VFS.FileSystemManager", 1, "Maintenance cancelled.");
        return;
      }
      catch (Exception paramCancellationSignalCompat)
      {
        QLog.e("VFS.FileSystemManager", 1, "Maintenance failed.");
        return;
      }
      finally
      {
        if ((localObject != null) && (((PowerManager.WakeLock)localObject).isHeld())) {
          ((PowerManager.WakeLock)localObject).release();
        }
      }
    }
  }
  
  private static ResolverState generateInitialState(Context paramContext)
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put(null, FileSchemeResolver.instance());
    localHashMap1.put("", FileSchemeResolver.instance());
    localHashMap1.put("file", FileSchemeResolver.instance());
    localHashMap1.put("wcf", WcfSchemeResolver.instance());
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("data", paramContext.getCacheDir().getParent());
    localHashMap2.put("dataCache", paramContext.getCacheDir().getPath());
    paramContext = paramContext.getExternalCacheDir();
    if (paramContext != null)
    {
      localHashMap2.put("extData", paramContext.getParent());
      localHashMap2.put("extCache", paramContext.getPath());
    }
    paramContext = Environment.getExternalStorageDirectory();
    if (paramContext != null) {
      localHashMap2.put("storage", paramContext.getPath());
    }
    return new ResolverState().update(localHashMap1, Collections.emptyMap(), new TreeMap(), localHashMap2, null);
  }
  
  static KeyGen getKeyGenerator()
  {
    return sKeyGen;
  }
  
  /* Error */
  private void initialize()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: iconst_0
    //   4: istore_1
    //   5: getstatic 83	com/tencent/mm/vfs/FileSystemManager:sLoadBroadcast	Z
    //   8: istore 4
    //   10: aconst_null
    //   11: ldc_w 381
    //   14: invokestatic 137	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 117	com/tencent/mm/vfs/FileSystemManager:mVFSDir	Ljava/io/File;
    //   21: invokevirtual 384	java/io/File:mkdir	()Z
    //   24: pop
    //   25: ldc 37
    //   27: iconst_1
    //   28: new 268	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 386
    //   38: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokestatic 392	android/os/Process:myPid	()I
    //   44: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: iload 4
    //   55: ifeq +84 -> 139
    //   58: invokestatic 401	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   61: astore 10
    //   63: new 106	java/io/File
    //   66: dup
    //   67: aload_0
    //   68: getfield 117	com/tencent/mm/vfs/FileSystemManager:mVFSDir	Ljava/io/File;
    //   71: ldc 28
    //   73: invokespecial 115	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   76: astore 7
    //   78: aload 7
    //   80: invokevirtual 404	java/io/File:length	()J
    //   83: lstore 5
    //   85: lload 5
    //   87: ldc2_w 405
    //   90: lcmp
    //   91: ifgt +12 -> 103
    //   94: lload 5
    //   96: ldc2_w 407
    //   99: lcmp
    //   100: ifgt +57 -> 157
    //   103: ldc 37
    //   105: iconst_1
    //   106: new 268	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 410
    //   116: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: lload 5
    //   121: invokevirtual 413	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   124: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aconst_null
    //   131: invokestatic 419	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   134: aload 10
    //   136: invokevirtual 422	android/os/Parcel:recycle	()V
    //   139: aload_0
    //   140: iload 4
    //   142: invokevirtual 426	com/tencent/mm/vfs/FileSystemManager:setBroadcastReceivingEnabled	(Z)V
    //   145: aload_0
    //   146: invokevirtual 429	com/tencent/mm/vfs/FileSystemManager:enableMaintenance	()V
    //   149: ldc_w 381
    //   152: aconst_null
    //   153: invokestatic 137	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: return
    //   157: lload 5
    //   159: l2i
    //   160: iconst_4
    //   161: isub
    //   162: istore_2
    //   163: iload_2
    //   164: newarray byte
    //   166: astore 11
    //   168: new 431	java/io/DataInputStream
    //   171: dup
    //   172: new 433	java/io/FileInputStream
    //   175: dup
    //   176: aload 7
    //   178: invokespecial 436	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   181: invokespecial 439	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   184: astore 8
    //   186: aload 8
    //   188: astore 7
    //   190: aload 8
    //   192: invokevirtual 442	java/io/DataInputStream:readInt	()I
    //   195: istore_3
    //   196: iload_3
    //   197: iconst_2
    //   198: if_icmpeq +69 -> 267
    //   201: aload 8
    //   203: astore 7
    //   205: new 378	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   208: dup
    //   209: ldc 2
    //   211: iload_3
    //   212: iconst_2
    //   213: invokespecial 445	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException:<init>	(Ljava/lang/Class;II)V
    //   216: athrow
    //   217: astore 9
    //   219: aload 8
    //   221: astore 7
    //   223: ldc 37
    //   225: iconst_1
    //   226: aload 9
    //   228: invokevirtual 448	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException:getMessage	()Ljava/lang/String;
    //   231: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload 8
    //   236: astore 7
    //   238: aload_0
    //   239: new 380	java/lang/Throwable
    //   242: dup
    //   243: ldc_w 450
    //   246: aload 9
    //   248: invokespecial 453	java/lang/Throwable:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   251: invokespecial 457	com/tencent/mm/vfs/FileSystemManager:reportErrorInner	(Ljava/lang/Throwable;)V
    //   254: aload 8
    //   256: invokestatic 419	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   259: aload 10
    //   261: invokevirtual 422	android/os/Parcel:recycle	()V
    //   264: goto -125 -> 139
    //   267: iload_1
    //   268: iload_2
    //   269: if_icmpge +26 -> 295
    //   272: aload 8
    //   274: astore 7
    //   276: iload_1
    //   277: aload 8
    //   279: aload 11
    //   281: iload_1
    //   282: aload 11
    //   284: arraylength
    //   285: iload_1
    //   286: isub
    //   287: invokevirtual 461	java/io/DataInputStream:read	([BII)I
    //   290: iadd
    //   291: istore_1
    //   292: goto -25 -> 267
    //   295: aload 8
    //   297: astore 7
    //   299: aload 8
    //   301: invokevirtual 464	java/io/DataInputStream:close	()V
    //   304: aload 10
    //   306: aload 11
    //   308: iconst_0
    //   309: iload_1
    //   310: invokevirtual 468	android/os/Parcel:unmarshall	([BII)V
    //   313: aload 10
    //   315: iconst_0
    //   316: invokevirtual 472	android/os/Parcel:setDataPosition	(I)V
    //   319: aload_0
    //   320: aload 10
    //   322: ldc_w 474
    //   325: invokevirtual 480	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   328: invokevirtual 484	android/os/Parcel:readBundle	(Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    //   331: invokespecial 488	com/tencent/mm/vfs/FileSystemManager:loadFromBundle	(Landroid/os/Bundle;)V
    //   334: goto -204 -> 130
    //   337: astore 9
    //   339: aconst_null
    //   340: astore 8
    //   342: goto -123 -> 219
    //   345: astore 9
    //   347: aconst_null
    //   348: astore 8
    //   350: aload 8
    //   352: astore 7
    //   354: aload_0
    //   355: aload 9
    //   357: invokespecial 457	com/tencent/mm/vfs/FileSystemManager:reportErrorInner	(Ljava/lang/Throwable;)V
    //   360: aload 8
    //   362: astore 7
    //   364: ldc 37
    //   366: iconst_1
    //   367: new 380	java/lang/Throwable
    //   370: dup
    //   371: ldc_w 450
    //   374: aload 9
    //   376: invokespecial 453	java/lang/Throwable:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   379: iconst_0
    //   380: anewarray 4	java/lang/Object
    //   383: invokestatic 491	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   386: aload 8
    //   388: invokestatic 419	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   391: aload 10
    //   393: invokevirtual 422	android/os/Parcel:recycle	()V
    //   396: goto -257 -> 139
    //   399: astore 7
    //   401: aload 9
    //   403: astore 8
    //   405: aload 8
    //   407: invokestatic 419	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   410: aload 10
    //   412: invokevirtual 422	android/os/Parcel:recycle	()V
    //   415: aload 7
    //   417: athrow
    //   418: astore 9
    //   420: aload 7
    //   422: astore 8
    //   424: aload 9
    //   426: astore 7
    //   428: goto -23 -> 405
    //   431: astore 9
    //   433: goto -83 -> 350
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	436	0	this	FileSystemManager
    //   4	306	1	i	int
    //   162	108	2	j	int
    //   195	17	3	k	int
    //   8	133	4	bool	boolean
    //   83	75	5	l	long
    //   76	287	7	localObject1	Object
    //   399	22	7	localObject2	Object
    //   426	1	7	localObject3	Object
    //   184	239	8	localObject4	Object
    //   1	1	9	localObject5	Object
    //   217	30	9	localFileSystemVersionException1	VFSUtils.FileSystemVersionException
    //   337	1	9	localFileSystemVersionException2	VFSUtils.FileSystemVersionException
    //   345	57	9	localThrowable1	Throwable
    //   418	7	9	localObject6	Object
    //   431	1	9	localThrowable2	Throwable
    //   61	350	10	localParcel	android.os.Parcel
    //   166	141	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   190	196	217	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   205	217	217	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   276	292	217	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   299	304	217	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   63	85	337	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   103	130	337	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   163	186	337	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   304	334	337	com/tencent/mm/vfs/VFSUtils$FileSystemVersionException
    //   63	85	345	java/lang/Throwable
    //   103	130	345	java/lang/Throwable
    //   163	186	345	java/lang/Throwable
    //   304	334	345	java/lang/Throwable
    //   63	85	399	finally
    //   103	130	399	finally
    //   163	186	399	finally
    //   304	334	399	finally
    //   190	196	418	finally
    //   205	217	418	finally
    //   223	234	418	finally
    //   238	254	418	finally
    //   276	292	418	finally
    //   299	304	418	finally
    //   354	360	418	finally
    //   364	386	418	finally
    //   190	196	431	java/lang/Throwable
    //   205	217	431	java/lang/Throwable
    //   276	292	431	java/lang/Throwable
    //   299	304	431	java/lang/Throwable
  }
  
  public static FileSystemManager instance()
  {
    return SingletonHolder.INSTANCE;
  }
  
  private void loadFromBundle(Bundle paramBundle)
  {
    ??? = paramBundle;
    if (paramBundle == null) {
      ??? = new Bundle();
    }
    if (((Bundle)???).getInt("pid") == Process.myPid()) {
      if (QLog.isColorLevel()) {
        QLog.d("VFS.FileSystemManager", 2, "Ignore filesystem change broadcast from the same process.");
      }
    }
    do
    {
      return;
      paramBundle = ResolverState.loadFromBundle((Bundle)???);
      Map localMap = paramBundle.envVars();
      synchronized (this.mLock)
      {
        this.mState = paramBundle;
        this.mRevision += 1;
        this.mInvalidResolution = new Resolution(null, null, this.mRevision, null);
        VFSTrack.track(null, "migrate_configure_time_bundle");
        paramBundle.mRootFileSystem.configure(localMap);
        localIterator = paramBundle.mSchemeResolvers.values().iterator();
        if (localIterator.hasNext()) {
          ((SchemeResolver)localIterator.next()).configure(localMap);
        }
      }
      Iterator localIterator = paramBundle.mFileSystems.values().iterator();
      while (localIterator.hasNext()) {
        ((FileSystem)localIterator.next()).configure(localMap);
      }
      QLog.d("VFS.FileSystemManager", 1, "loadFromBundle. fileSystem size" + paramBundle.mFileSystems.size());
      VFSTrack.track("migrate_configure_time_bundle", null);
      ??? = new StringBuilder(2048);
      ((StringBuilder)???).append("[Schemes]\n");
      printChange(paramBundle.mSchemeResolvers, (StringBuilder)???);
      ((StringBuilder)???).append("[File systems]\n");
      printChange(paramBundle.mFileSystems, (StringBuilder)???);
      ((StringBuilder)???).append("[Mount points]\n");
      printChange(paramBundle.mMountPoints, (StringBuilder)???);
      ((StringBuilder)???).append("[Environment]\n");
      printChange(paramBundle.mEnvVars, (StringBuilder)???);
      ((StringBuilder)???).append("[Root]\n  ").append(paramBundle.mRootFileSystem.toString()).append('\n');
    } while (!QLog.isColorLevel());
    QLog.d("VFS.FileSystemManager", 2, "Loaded file system from bundle:\n" + ((StringBuilder)???).toString());
  }
  
  private static <K, V> void printChange(Map<K, V> paramMap, StringBuilder paramStringBuilder)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramStringBuilder.append("  ").append(localEntry.getKey());
      if (localEntry.getValue() == null) {
        paramStringBuilder.append(" (deleted)\n");
      } else {
        paramStringBuilder.append(" => ").append(localEntry.getValue().toString()).append('\n');
      }
    }
  }
  
  /* Error */
  private void publishFileSystems(ResolverState paramResolverState)
  {
    // Byte code:
    //   0: aconst_null
    //   1: ldc_w 619
    //   4: invokestatic 137	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_1
    //   8: invokevirtual 623	com/tencent/mm/vfs/ResolverState:writeToBundle	()Landroid/os/Bundle;
    //   11: astore 5
    //   13: invokestatic 401	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   16: astore_2
    //   17: aload_2
    //   18: aload 5
    //   20: invokevirtual 626	android/os/Parcel:writeBundle	(Landroid/os/Bundle;)V
    //   23: aload_2
    //   24: invokevirtual 630	android/os/Parcel:marshall	()[B
    //   27: astore 4
    //   29: aload_2
    //   30: invokevirtual 422	android/os/Parcel:recycle	()V
    //   33: new 106	java/io/File
    //   36: dup
    //   37: aload_0
    //   38: getfield 117	com/tencent/mm/vfs/FileSystemManager:mVFSDir	Ljava/io/File;
    //   41: ldc 28
    //   43: invokespecial 115	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   46: astore_2
    //   47: aload_2
    //   48: invokevirtual 633	java/io/File:exists	()Z
    //   51: ifne +8 -> 59
    //   54: aload_2
    //   55: invokevirtual 636	java/io/File:createNewFile	()Z
    //   58: pop
    //   59: new 638	java/io/DataOutputStream
    //   62: dup
    //   63: new 640	java/io/FileOutputStream
    //   66: dup
    //   67: aload_2
    //   68: invokespecial 641	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   71: invokespecial 644	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   74: astore_3
    //   75: aload_3
    //   76: astore_2
    //   77: aload_3
    //   78: iconst_2
    //   79: invokevirtual 647	java/io/DataOutputStream:writeInt	(I)V
    //   82: aload_3
    //   83: astore_2
    //   84: aload_3
    //   85: aload 4
    //   87: invokevirtual 651	java/io/DataOutputStream:write	([B)V
    //   90: aload_3
    //   91: invokestatic 419	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   94: aload_0
    //   95: getfield 91	com/tencent/mm/vfs/FileSystemManager:mContext	Landroid/content/Context;
    //   98: invokevirtual 654	android/content/Context:getPackageName	()Ljava/lang/String;
    //   101: astore_2
    //   102: new 656	android/content/Intent
    //   105: dup
    //   106: new 268	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   113: aload_2
    //   114: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc_w 658
    //   120: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokespecial 659	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   129: astore_2
    //   130: aload_2
    //   131: aload 5
    //   133: invokevirtual 663	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   136: pop
    //   137: aload_2
    //   138: ldc_w 501
    //   141: invokestatic 392	android/os/Process:myPid	()I
    //   144: invokevirtual 667	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   147: pop
    //   148: aload_0
    //   149: getfield 91	com/tencent/mm/vfs/FileSystemManager:mContext	Landroid/content/Context;
    //   152: aload_2
    //   153: invokevirtual 671	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   156: new 268	java/lang/StringBuilder
    //   159: dup
    //   160: sipush 2048
    //   163: invokespecial 560	java/lang/StringBuilder:<init>	(I)V
    //   166: astore_2
    //   167: aload_2
    //   168: ldc_w 562
    //   171: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_1
    //   176: getfield 526	com/tencent/mm/vfs/ResolverState:mSchemeResolvers	Ljava/util/Map;
    //   179: aload_2
    //   180: invokestatic 566	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   183: aload_2
    //   184: ldc_w 568
    //   187: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_1
    //   192: getfield 553	com/tencent/mm/vfs/ResolverState:mFileSystems	Ljava/util/Map;
    //   195: aload_2
    //   196: invokestatic 566	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   199: aload_2
    //   200: ldc_w 570
    //   203: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload_1
    //   208: getfield 574	com/tencent/mm/vfs/ResolverState:mMountPoints	Ljava/util/SortedMap;
    //   211: aload_2
    //   212: invokestatic 566	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   215: aload_2
    //   216: ldc_w 576
    //   219: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_1
    //   224: getfield 579	com/tencent/mm/vfs/ResolverState:mEnvVars	Ljava/util/Map;
    //   227: aload_2
    //   228: invokestatic 566	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   231: aload_2
    //   232: ldc_w 581
    //   235: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_1
    //   239: getfield 518	com/tencent/mm/vfs/ResolverState:mRootFileSystem	Lcom/tencent/mm/vfs/FileSystem;
    //   242: invokevirtual 582	java/lang/Object:toString	()Ljava/lang/String;
    //   245: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: bipush 10
    //   250: invokevirtual 585	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq +32 -> 289
    //   260: ldc 37
    //   262: iconst_2
    //   263: new 268	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 673
    //   273: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_2
    //   277: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: ldc_w 619
    //   292: aconst_null
    //   293: invokestatic 137	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: return
    //   297: astore 4
    //   299: aconst_null
    //   300: astore_3
    //   301: aload_3
    //   302: astore_2
    //   303: aload_0
    //   304: new 380	java/lang/Throwable
    //   307: dup
    //   308: ldc_w 450
    //   311: aload 4
    //   313: invokespecial 453	java/lang/Throwable:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   316: invokespecial 457	com/tencent/mm/vfs/FileSystemManager:reportErrorInner	(Ljava/lang/Throwable;)V
    //   319: aload_3
    //   320: astore_2
    //   321: ldc 37
    //   323: iconst_1
    //   324: new 268	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   331: ldc_w 675
    //   334: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload 4
    //   339: invokevirtual 676	java/io/IOException:getMessage	()Ljava/lang/String;
    //   342: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: aload_3
    //   352: invokestatic 419	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   355: goto -261 -> 94
    //   358: astore_1
    //   359: aconst_null
    //   360: astore_2
    //   361: aload_2
    //   362: invokestatic 419	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   365: aload_1
    //   366: athrow
    //   367: astore_1
    //   368: goto -7 -> 361
    //   371: astore 4
    //   373: goto -72 -> 301
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	this	FileSystemManager
    //   0	376	1	paramResolverState	ResolverState
    //   16	346	2	localObject	Object
    //   74	278	3	localDataOutputStream	java.io.DataOutputStream
    //   27	59	4	arrayOfByte	byte[]
    //   297	41	4	localIOException1	IOException
    //   371	1	4	localIOException2	IOException
    //   11	121	5	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   33	59	297	java/io/IOException
    //   59	75	297	java/io/IOException
    //   33	59	358	finally
    //   59	75	358	finally
    //   77	82	367	finally
    //   84	90	367	finally
    //   303	319	367	finally
    //   321	351	367	finally
    //   77	82	371	java/io/IOException
    //   84	90	371	java/io/IOException
  }
  
  private void reportErrorInner(Throwable paramThrowable)
  {
    if (sStatisticsCallback != null) {
      sStatisticsCallback.reportError(paramThrowable);
    }
  }
  
  public static void setContext(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null) {}
    for (;;)
    {
      sContext = paramContext;
      return;
      paramContext = localContext;
    }
  }
  
  public static void setKeyGenerator(KeyGen paramKeyGen)
  {
    sKeyGen = paramKeyGen;
  }
  
  public static void setLoadBroadcast(boolean paramBoolean)
  {
    sLoadBroadcast = paramBoolean;
  }
  
  public static void setStatisticsCallback(StatisticsCallback paramStatisticsCallback)
  {
    sStatisticsCallback = paramStatisticsCallback;
  }
  
  public static StatisticsCallback statisticsCallback()
  {
    return sStatisticsCallback;
  }
  
  /* Error */
  private void updateFileSystems(Editor paramEditor, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 696	com/tencent/mm/vfs/FileSystemManager$Editor:access$800	(Lcom/tencent/mm/vfs/FileSystemManager$Editor;)Ljava/util/HashMap;
    //   4: astore 6
    //   6: aload_1
    //   7: invokestatic 699	com/tencent/mm/vfs/FileSystemManager$Editor:access$900	(Lcom/tencent/mm/vfs/FileSystemManager$Editor;)Ljava/util/HashMap;
    //   10: astore 5
    //   12: aload_1
    //   13: invokestatic 703	com/tencent/mm/vfs/FileSystemManager$Editor:access$1000	(Lcom/tencent/mm/vfs/FileSystemManager$Editor;)Ljava/util/TreeMap;
    //   16: astore 7
    //   18: aload_1
    //   19: invokestatic 706	com/tencent/mm/vfs/FileSystemManager$Editor:access$1100	(Lcom/tencent/mm/vfs/FileSystemManager$Editor;)Ljava/util/HashMap;
    //   22: astore 8
    //   24: aload_1
    //   25: invokestatic 710	com/tencent/mm/vfs/FileSystemManager$Editor:access$1200	(Lcom/tencent/mm/vfs/FileSystemManager$Editor;)Lcom/tencent/mm/vfs/FileSystem;
    //   28: astore 9
    //   30: aload_1
    //   31: invokestatic 714	com/tencent/mm/vfs/FileSystemManager$Editor:access$1300	(Lcom/tencent/mm/vfs/FileSystemManager$Editor;)Z
    //   34: istore 4
    //   36: new 268	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   43: astore_1
    //   44: iload 4
    //   46: ifeq +11 -> 57
    //   49: aload_1
    //   50: ldc_w 716
    //   53: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 6
    //   59: invokeinterface 719 1 0
    //   64: ifne +17 -> 81
    //   67: aload_1
    //   68: ldc_w 721
    //   71: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 6
    //   77: aload_1
    //   78: invokestatic 566	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   81: aload 5
    //   83: invokeinterface 719 1 0
    //   88: ifne +17 -> 105
    //   91: aload_1
    //   92: ldc_w 568
    //   95: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 5
    //   101: aload_1
    //   102: invokestatic 566	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   105: aload 7
    //   107: invokeinterface 724 1 0
    //   112: ifne +17 -> 129
    //   115: aload_1
    //   116: ldc_w 570
    //   119: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 7
    //   125: aload_1
    //   126: invokestatic 566	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   129: ldc 37
    //   131: iconst_1
    //   132: new 268	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 726
    //   142: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload 5
    //   147: invokeinterface 558 1 0
    //   152: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: ldc_w 728
    //   158: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 7
    //   163: invokeinterface 729 1 0
    //   168: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: ldc_w 731
    //   174: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: iload_2
    //   178: invokevirtual 278	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   181: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload 8
    //   189: invokeinterface 719 1 0
    //   194: ifne +17 -> 211
    //   197: aload_1
    //   198: ldc_w 576
    //   201: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 8
    //   207: aload_1
    //   208: invokestatic 566	com/tencent/mm/vfs/FileSystemManager:printChange	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   211: aload 9
    //   213: ifnull +21 -> 234
    //   216: aload_1
    //   217: ldc_w 581
    //   220: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload 9
    //   225: invokevirtual 604	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   228: bipush 10
    //   230: invokevirtual 585	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq +32 -> 269
    //   240: ldc 37
    //   242: iconst_2
    //   243: new 268	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   250: ldc_w 733
    //   253: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_1
    //   257: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: aload_0
    //   270: getfield 89	com/tencent/mm/vfs/FileSystemManager:mLock	Ljava/lang/Object;
    //   273: astore 10
    //   275: aload 10
    //   277: monitorenter
    //   278: iload 4
    //   280: ifeq +128 -> 408
    //   283: aload_0
    //   284: getfield 169	com/tencent/mm/vfs/FileSystemManager:mInitialState	Lcom/tencent/mm/vfs/ResolverState;
    //   287: astore_1
    //   288: aload_0
    //   289: getfield 173	com/tencent/mm/vfs/FileSystemManager:mRevision	I
    //   292: istore_3
    //   293: aload 10
    //   295: monitorexit
    //   296: aconst_null
    //   297: ldc_w 734
    //   300: invokestatic 137	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: aload_1
    //   304: aload 6
    //   306: aload 5
    //   308: aload 7
    //   310: aload 8
    //   312: aload 9
    //   314: invokevirtual 374	com/tencent/mm/vfs/ResolverState:update	(Ljava/util/Map;Ljava/util/Map;Ljava/util/SortedMap;Ljava/util/Map;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/ResolverState;
    //   317: astore_1
    //   318: ldc_w 734
    //   321: aconst_null
    //   322: invokestatic 137	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: aload_1
    //   326: invokevirtual 512	com/tencent/mm/vfs/ResolverState:envVars	()Ljava/util/Map;
    //   329: astore 11
    //   331: ldc 37
    //   333: iconst_1
    //   334: new 268	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   341: ldc_w 736
    //   344: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: iload_3
    //   348: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: ldc_w 738
    //   354: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload_0
    //   358: getfield 173	com/tencent/mm/vfs/FileSystemManager:mRevision	I
    //   361: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   364: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: aload_0
    //   371: getfield 89	com/tencent/mm/vfs/FileSystemManager:mLock	Ljava/lang/Object;
    //   374: astore 10
    //   376: aload 10
    //   378: monitorenter
    //   379: iload_3
    //   380: aload_0
    //   381: getfield 173	com/tencent/mm/vfs/FileSystemManager:mRevision	I
    //   384: if_icmpeq +46 -> 430
    //   387: iload 4
    //   389: ifeq +33 -> 422
    //   392: aload_0
    //   393: getfield 169	com/tencent/mm/vfs/FileSystemManager:mInitialState	Lcom/tencent/mm/vfs/ResolverState;
    //   396: astore_1
    //   397: aload_0
    //   398: getfield 173	com/tencent/mm/vfs/FileSystemManager:mRevision	I
    //   401: istore_3
    //   402: aload 10
    //   404: monitorexit
    //   405: goto -109 -> 296
    //   408: aload_0
    //   409: getfield 171	com/tencent/mm/vfs/FileSystemManager:mState	Lcom/tencent/mm/vfs/ResolverState;
    //   412: astore_1
    //   413: goto -125 -> 288
    //   416: astore_1
    //   417: aload 10
    //   419: monitorexit
    //   420: aload_1
    //   421: athrow
    //   422: aload_0
    //   423: getfield 171	com/tencent/mm/vfs/FileSystemManager:mState	Lcom/tencent/mm/vfs/ResolverState;
    //   426: astore_1
    //   427: goto -30 -> 397
    //   430: aload_0
    //   431: aload_1
    //   432: putfield 171	com/tencent/mm/vfs/FileSystemManager:mState	Lcom/tencent/mm/vfs/ResolverState;
    //   435: aload_0
    //   436: iload_3
    //   437: iconst_1
    //   438: iadd
    //   439: putfield 173	com/tencent/mm/vfs/FileSystemManager:mRevision	I
    //   442: aload_0
    //   443: new 17	com/tencent/mm/vfs/FileSystemManager$Resolution
    //   446: dup
    //   447: aconst_null
    //   448: aconst_null
    //   449: aload_0
    //   450: getfield 173	com/tencent/mm/vfs/FileSystemManager:mRevision	I
    //   453: aconst_null
    //   454: invokespecial 176	com/tencent/mm/vfs/FileSystemManager$Resolution:<init>	(Lcom/tencent/mm/vfs/FileSystem;Ljava/lang/String;ILcom/tencent/mm/vfs/FileSystemManager$1;)V
    //   457: putfield 178	com/tencent/mm/vfs/FileSystemManager:mInvalidResolution	Lcom/tencent/mm/vfs/FileSystemManager$Resolution;
    //   460: aconst_null
    //   461: ldc_w 740
    //   464: invokestatic 137	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   467: iload 4
    //   469: ifne +13 -> 482
    //   472: aload 8
    //   474: invokeinterface 719 1 0
    //   479: ifne +112 -> 591
    //   482: aload_1
    //   483: getfield 518	com/tencent/mm/vfs/ResolverState:mRootFileSystem	Lcom/tencent/mm/vfs/FileSystem;
    //   486: aload 11
    //   488: invokeinterface 522 2 0
    //   493: aload_1
    //   494: getfield 526	com/tencent/mm/vfs/ResolverState:mSchemeResolvers	Ljava/util/Map;
    //   497: invokeinterface 532 1 0
    //   502: invokeinterface 538 1 0
    //   507: astore 5
    //   509: aload 5
    //   511: invokeinterface 543 1 0
    //   516: ifeq +29 -> 545
    //   519: aload 5
    //   521: invokeinterface 547 1 0
    //   526: checkcast 549	com/tencent/mm/vfs/SchemeResolver
    //   529: aload 11
    //   531: invokeinterface 550 2 0
    //   536: goto -27 -> 509
    //   539: astore_1
    //   540: aload 10
    //   542: monitorexit
    //   543: aload_1
    //   544: athrow
    //   545: aload_1
    //   546: getfield 553	com/tencent/mm/vfs/ResolverState:mFileSystems	Ljava/util/Map;
    //   549: invokeinterface 532 1 0
    //   554: invokeinterface 538 1 0
    //   559: astore 5
    //   561: aload 5
    //   563: invokeinterface 543 1 0
    //   568: ifeq +145 -> 713
    //   571: aload 5
    //   573: invokeinterface 547 1 0
    //   578: checkcast 474	com/tencent/mm/vfs/FileSystem
    //   581: aload 11
    //   583: invokeinterface 522 2 0
    //   588: goto -27 -> 561
    //   591: aload 9
    //   593: ifnull +14 -> 607
    //   596: aload_1
    //   597: getfield 518	com/tencent/mm/vfs/ResolverState:mRootFileSystem	Lcom/tencent/mm/vfs/FileSystem;
    //   600: aload 11
    //   602: invokeinterface 522 2 0
    //   607: aload 6
    //   609: invokeinterface 532 1 0
    //   614: invokeinterface 538 1 0
    //   619: astore 6
    //   621: aload 6
    //   623: invokeinterface 543 1 0
    //   628: ifeq +32 -> 660
    //   631: aload 6
    //   633: invokeinterface 547 1 0
    //   638: checkcast 549	com/tencent/mm/vfs/SchemeResolver
    //   641: astore 7
    //   643: aload 7
    //   645: ifnull -24 -> 621
    //   648: aload 7
    //   650: aload 11
    //   652: invokeinterface 550 2 0
    //   657: goto -36 -> 621
    //   660: aload 5
    //   662: invokeinterface 532 1 0
    //   667: invokeinterface 538 1 0
    //   672: astore 5
    //   674: aload 5
    //   676: invokeinterface 543 1 0
    //   681: ifeq +32 -> 713
    //   684: aload 5
    //   686: invokeinterface 547 1 0
    //   691: checkcast 474	com/tencent/mm/vfs/FileSystem
    //   694: astore 6
    //   696: aload 6
    //   698: ifnull -24 -> 674
    //   701: aload 6
    //   703: aload 11
    //   705: invokeinterface 522 2 0
    //   710: goto -36 -> 674
    //   713: ldc_w 740
    //   716: aconst_null
    //   717: invokestatic 137	com/tencent/mm/vfs/VFSTrack:track	(Ljava/lang/String;Ljava/lang/String;)V
    //   720: aload 10
    //   722: monitorexit
    //   723: iload_2
    //   724: ifeq +8 -> 732
    //   727: aload_0
    //   728: aload_1
    //   729: invokespecial 742	com/tencent/mm/vfs/FileSystemManager:publishFileSystems	(Lcom/tencent/mm/vfs/ResolverState;)V
    //   732: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	733	0	this	FileSystemManager
    //   0	733	1	paramEditor	Editor
    //   0	733	2	paramBoolean	boolean
    //   292	147	3	i	int
    //   34	434	4	bool	boolean
    //   10	675	5	localObject1	Object
    //   4	698	6	localObject2	Object
    //   16	633	7	localObject3	Object
    //   22	451	8	localHashMap	HashMap
    //   28	564	9	localFileSystem	FileSystem
    //   329	375	11	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   283	288	416	finally
    //   288	296	416	finally
    //   408	413	416	finally
    //   417	420	416	finally
    //   379	387	539	finally
    //   392	397	539	finally
    //   397	405	539	finally
    //   422	427	539	finally
    //   430	467	539	finally
    //   472	482	539	finally
    //   482	509	539	finally
    //   509	536	539	finally
    //   540	543	539	finally
    //   545	561	539	finally
    //   561	588	539	finally
    //   596	607	539	finally
    //   607	621	539	finally
    //   621	643	539	finally
    //   648	657	539	finally
    //   660	674	539	finally
    //   674	696	539	finally
    //   701	710	539	finally
    //   713	723	539	finally
  }
  
  public void disableMaintenance()
  {
    enableMaintenance(-1L, 9223372036854775807L, false);
  }
  
  public Editor edit()
  {
    return new Editor();
  }
  
  public void enableMaintenance()
  {
    VFSTrack.track(null, "enableMaintenance");
    enableMaintenance(420000L, 259200000L, true);
    VFSTrack.track("enableMaintenance", null);
  }
  
  public void enableMaintenance(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    long l = this.mMaintenanceWaitTime;
    if ((paramLong1 >= 0L) && (l < 0L))
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      this.mContext.registerReceiver(this.mMaintenanceReceiver, localIntentFilter);
      this.mMaintenanceReceiver.refreshIdleStatus(this.mContext);
    }
    for (;;)
    {
      this.mMaintenanceWaitTime = paramLong1;
      this.mMaintenanceInterval = paramLong2;
      this.mMaintenanceUseWakeLock = paramBoolean;
      return;
      if ((paramLong1 < 0L) && (l >= 0L)) {
        this.mContext.unregisterReceiver(this.mMaintenanceReceiver);
      }
    }
  }
  
  public Map<String, String> environmentVariables()
  {
    synchronized (this.mLock)
    {
      Map localMap = this.mState.envVars();
      return localMap;
    }
  }
  
  Uri exportUri(Uri paramUri)
  {
    ResolverState localResolverState;
    synchronized (this.mLock)
    {
      localResolverState = this.mState;
      ??? = paramUri.getScheme();
      ??? = (SchemeResolver)localResolverState.mSchemeResolvers.get(???);
      if (??? == null) {
        return null;
      }
    }
    return ((SchemeResolver)???).exportUri(localResolverState, paramUri);
  }
  
  public Map<String, FileSystem> fileSystems()
  {
    synchronized (this.mLock)
    {
      Map localMap = this.mState.fileSystems();
      return localMap;
    }
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      paramMessage = (Intent)paramMessage.obj;
      paramMessage.setExtrasClassLoader(FileSystem.class.getClassLoader());
      if (QLog.isColorLevel()) {
        QLog.d("VFS.FileSystemManager", 2, "Refresh file system from broadcast.");
      }
      try
      {
        loadFromBundle(paramMessage.getExtras());
        return true;
      }
      catch (Throwable paramMessage)
      {
        for (;;)
        {
          QLog.e("VFS.FileSystemManager", 1, "Failed to refresh file system from broadcast.", paramMessage);
        }
      }
    }
    doMaintenance((CancellationSignalCompat)paramMessage.obj);
    return true;
  }
  
  public boolean isValidConfigFile(Context paramContext)
  {
    if (paramContext != null)
    {
      File localFile2 = paramContext.getFilesDir().getParentFile();
      File localFile1 = localFile2;
      if (localFile2 == null) {
        localFile1 = paramContext.getCacheDir();
      }
      paramContext = new File(new File(localFile1, ".vfs"), "fs.bin");
      if (!paramContext.exists()) {
        reportErrorInner(new Throwable("VFSSystemManager isValidConfigFile broadcastFile not exist!"));
      }
      long l = paramContext.length();
      if ((l > 1048576L) || (l <= 4L))
      {
        reportErrorInner(new Throwable("VFSSystemManager Invalid parcel file size: " + l));
        return false;
      }
      return true;
    }
    return false;
  }
  
  public void maintain(CancellationSignalCompat paramCancellationSignalCompat)
    throws OperationCanceledException
  {
    File localFile = new File(this.mVFSDir, "maintain.timestamp");
    Object localObject3;
    synchronized (this.mLock)
    {
      localObject1 = this.mState;
      ??? = ((ResolverState)localObject1).mSchemeResolvers.entrySet().iterator();
      if (((Iterator)???).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)???).next();
        SchemeResolver localSchemeResolver = (SchemeResolver)((Map.Entry)localObject3).getValue();
        if (QLog.isColorLevel()) {
          QLog.i("VFS.FileSystemManager", 2, "[Maintenance] " + (String)((Map.Entry)localObject3).getKey() + " => " + localSchemeResolver.toString());
        }
        localSchemeResolver.maintain(paramCancellationSignalCompat);
      }
    }
    Object localObject1 = ((ResolverState)localObject1).mFileSystems.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ??? = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (FileSystem)((Map.Entry)???).getValue();
      if (QLog.isColorLevel()) {
        QLog.i("VFS.FileSystemManager", 2, "[Maintenance] " + (String)((Map.Entry)???).getKey() + " => " + localObject3.toString());
      }
      ((FileSystem)localObject3).maintain(paramCancellationSignalCompat);
    }
    try
    {
      localFile.createNewFile();
      localFile.setLastModified(System.currentTimeMillis());
      return;
    }
    catch (IOException paramCancellationSignalCompat)
    {
      reportErrorInner(new Throwable("VFSSystemManager maintain error", paramCancellationSignalCompat));
      QLog.e("VFS.FileSystemManager", 1, "Unable to update maintenance timestamp: " + paramCancellationSignalCompat.getMessage());
    }
  }
  
  Looper maintenanceLooper()
  {
    return this.mMaintenanceThread.getLooper();
  }
  
  public void publish()
  {
    synchronized (this.mLock)
    {
      ResolverState localResolverState = this.mState;
      publishFileSystems(localResolverState);
      return;
    }
  }
  
  public void publishOnEditorCommit(boolean paramBoolean)
  {
    this.mPublishOnEditorCommit = paramBoolean;
  }
  
  Resolution resolve(Uri paramUri)
  {
    return resolve(paramUri, null);
  }
  
  Resolution resolve(Uri paramUri, Resolution paramResolution)
  {
    Object localObject = this.mLock;
    if (paramResolution != null) {}
    ResolverState localResolverState;
    int i;
    try
    {
      if (paramResolution.revision == this.mRevision) {
        return paramResolution;
      }
      localResolverState = this.mState;
      i = this.mRevision;
      paramResolution = this.mInvalidResolution;
      localObject = paramUri.getScheme();
      localObject = (SchemeResolver)localResolverState.mSchemeResolvers.get(localObject);
      if (localObject == null)
      {
        QLog.e("VFS.FileSystemManager", 1, "resolve is wrong! revoler is null,  resolvers size = " + localResolverState.mSchemeResolvers.size());
        return paramResolution;
      }
    }
    finally {}
    localObject = ((SchemeResolver)localObject).resolve(localResolverState, paramUri);
    paramUri = paramResolution;
    if (localObject != null) {
      paramUri = new Resolution((FileSystem)((Pair)localObject).first, (String)((Pair)localObject).second, i, null);
    }
    return paramUri;
  }
  
  public void setBroadcastReceivingEnabled(boolean paramBoolean)
  {
    VFSTrack.track(null, "setBroadcastReceivingEnabled");
    Object localObject = this.mRefreshReceiver;
    if ((localObject == null) && (paramBoolean))
    {
      localObject = new FileSystemManager.1(this);
      this.mRefreshReceiver = ((BroadcastReceiver)localObject);
      String str = this.mContext.getPackageName();
      this.mContext.registerReceiver((BroadcastReceiver)localObject, new IntentFilter(str + ".REFRESH_VFS"), "com.tencent.mobileqq.permission.MM_MESSAGE", null);
      if (QLog.isColorLevel()) {
        QLog.d("VFS.FileSystemManager", 2, "Broadcast receiving enabled.");
      }
    }
    for (;;)
    {
      VFSTrack.track("setBroadcastReceivingEnabled", null);
      return;
      if ((localObject != null) && (!paramBoolean))
      {
        this.mContext.unregisterReceiver((BroadcastReceiver)localObject);
        this.mRefreshReceiver = null;
        if (QLog.isColorLevel()) {
          QLog.d("VFS.FileSystemManager", 2, "Broadcast receiving disabled.");
        }
      }
    }
  }
  
  Map<String, String> staticEnvironment()
  {
    return this.mInitialState.envVars();
  }
  
  public final class Editor
  {
    private boolean mClean = false;
    private final HashMap<String, String> mEnvVars = new HashMap();
    private final HashMap<String, FileSystem> mFileSystems = new HashMap();
    private final TreeMap<String, String> mMountPoints = new TreeMap();
    private FileSystem mRoot = null;
    private final HashMap<String, SchemeResolver> mSchemeResolvers = new HashMap();
    
    public Editor() {}
    
    public Editor clear()
    {
      this.mFileSystems.clear();
      this.mMountPoints.clear();
      this.mEnvVars.clear();
      this.mRoot = null;
      this.mClean = true;
      return this;
    }
    
    public void commit()
    {
      commit(FileSystemManager.this.mPublishOnEditorCommit);
    }
    
    public void commit(boolean paramBoolean)
    {
      FileSystemManager.this.updateFileSystems(this, paramBoolean);
      this.mFileSystems.clear();
      this.mMountPoints.clear();
      this.mEnvVars.clear();
      this.mClean = false;
    }
    
    public Editor install(String paramString, FileSystem paramFileSystem)
    {
      this.mFileSystems.put(paramString, paramFileSystem);
      return this;
    }
    
    public Editor mount(String paramString1, String paramString2)
    {
      paramString1 = VFSUtils.normalizePath(paramString1, true, false);
      this.mMountPoints.put(paramString1, paramString2);
      return this;
    }
    
    public Editor root(FileSystem paramFileSystem)
    {
      this.mRoot = paramFileSystem;
      return this;
    }
    
    public Editor scheme(String paramString, SchemeResolver paramSchemeResolver)
    {
      this.mSchemeResolvers.put(paramString, paramSchemeResolver);
      return this;
    }
    
    public Editor setEnv(String paramString1, String paramString2)
    {
      this.mEnvVars.put(paramString1, paramString2);
      return this;
    }
    
    public Editor uninstall(String paramString)
    {
      this.mFileSystems.put(paramString, null);
      return this;
    }
    
    public Editor unmount(String paramString)
    {
      paramString = VFSUtils.normalizePath(paramString, true, false);
      this.mMountPoints.put(paramString, null);
      return this;
    }
    
    public Editor unsetEnv(String paramString)
    {
      this.mEnvVars.put(paramString, null);
      return this;
    }
  }
  
  public static abstract interface KeyGen
  {
    public abstract Key generate(String paramString, Map<String, String> paramMap);
  }
  
  final class MaintenanceBroadcastReceiver
    extends BroadcastReceiver
  {
    private CancellationSignalCompat mCancellationSignal;
    private boolean mIsCharging;
    private boolean mIsInteractive;
    
    private MaintenanceBroadcastReceiver() {}
    
    private void triggerIdle()
    {
      if (QLog.isColorLevel()) {
        QLog.i("VFS.FileSystemManager", 2, "Idle status changed: charging = " + this.mIsCharging + ", interactive = " + this.mIsInteractive);
      }
      long l;
      if ((this.mIsCharging) && (!this.mIsInteractive) && (this.mCancellationSignal == null))
      {
        l = FileSystemManager.this.mMaintenanceWaitTime;
        if (l >= 0L) {}
      }
      do
      {
        do
        {
          do
          {
            return;
            this.mCancellationSignal = new CancellationSignalCompat();
            FileSystemManager.this.mMaintenanceHandler.sendMessageDelayed(Message.obtain(FileSystemManager.this.mMaintenanceHandler, 2, this.mCancellationSignal), l);
          } while (!QLog.isColorLevel());
          QLog.i("VFS.FileSystemManager", 2, "System idle, trigger maintenance timer for " + l / 1000L + " seconds.");
          return;
        } while (((this.mIsCharging) && (!this.mIsInteractive)) || (this.mCancellationSignal == null));
        FileSystemManager.this.mMaintenanceHandler.removeMessages(2);
        this.mCancellationSignal.cancel();
        this.mCancellationSignal = null;
      } while (!QLog.isColorLevel());
      QLog.i("VFS.FileSystemManager", 2, "Exit idle state, maintenance cancelled.");
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if (paramContext == null) {
        return;
      }
      int i = -1;
      switch (paramContext.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        triggerIdle();
        return;
        if (!paramContext.equals("android.intent.action.SCREEN_ON")) {
          break;
        }
        i = 0;
        break;
        if (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
          break;
        }
        i = 1;
        break;
        if (!paramContext.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
          break;
        }
        i = 2;
        break;
        if (!paramContext.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
          break;
        }
        i = 3;
        break;
        this.mIsInteractive = true;
        continue;
        this.mIsInteractive = false;
        continue;
        this.mIsCharging = true;
        continue;
        this.mIsCharging = false;
      }
    }
    
    void refreshIdleStatus(Context paramContext)
    {
      this.mIsInteractive = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
      paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (paramContext != null)
      {
        int i = paramContext.getIntExtra("status", -1);
        if ((i != 2) && (i != 5)) {
          break label61;
        }
      }
      label61:
      for (boolean bool = true;; bool = false)
      {
        this.mIsCharging = bool;
        return;
      }
    }
  }
  
  static final class Resolution
  {
    final FileSystem fileSystem;
    final String path;
    final int revision;
    
    private Resolution(FileSystem paramFileSystem, String paramString, int paramInt)
    {
      this.fileSystem = paramFileSystem;
      this.path = paramString;
      this.revision = paramInt;
    }
    
    public String toString()
    {
      return this.path + " -> " + this.fileSystem.toString();
    }
    
    boolean valid()
    {
      return this.fileSystem != null;
    }
  }
  
  static final class SingletonHolder
  {
    @SuppressLint({"StaticFieldLeak"})
    static final FileSystemManager INSTANCE = new FileSystemManager(null);
    
    static
    {
      INSTANCE.initialize();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystemManager
 * JD-Core Version:    0.7.0.1
 */