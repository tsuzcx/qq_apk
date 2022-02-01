package io.flutter.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.view.WindowManager;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.util.PathUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlutterMain
{
  private static final String AOT_SHARED_LIBRARY_NAME = "aot-shared-library-name";
  private static final String DEFAULT_AOT_SHARED_LIBRARY_NAME = "libapp.so";
  private static final String DEFAULT_FLUTTER_ASSETS_DIR = "flutter_assets";
  private static final String DEFAULT_ISOLATE_SNAPSHOT_DATA = "isolate_snapshot_data";
  private static final String DEFAULT_KERNEL_BLOB = "kernel_blob.bin";
  private static final String DEFAULT_LIBRARY = "libflutter.so";
  private static final String DEFAULT_VM_SNAPSHOT_DATA = "vm_snapshot_data";
  private static final String FLUTTER_ASSETS_DIR_KEY = "flutter-assets-dir";
  private static final String ISOLATE_SNAPSHOT_DATA_KEY = "isolate-snapshot-data";
  public static final String PUBLIC_AOT_SHARED_LIBRARY_NAME;
  public static final String PUBLIC_FLUTTER_ASSETS_DIR_KEY;
  public static final String PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY;
  public static final String PUBLIC_VM_SNAPSHOT_DATA_KEY;
  private static final String SNAPSHOT_ASSET_PATH_KEY = "snapshot-asset-path";
  private static final String TAG = "FlutterMain";
  private static final String VM_SNAPSHOT_DATA_KEY = "vm-snapshot-data";
  private static boolean isRunningInRobolectricTest;
  private static String sAotSharedLibraryName;
  private static String sAotSharedLibraryPath = null;
  private static String sFlutterAssetsDir;
  private static boolean sInitialized;
  private static String sIsolateSnapshotData;
  private static String sNativeLibDir;
  @Nullable
  private static ResourceExtractor sResourceExtractor;
  @Nullable
  private static Settings sSettings;
  private static String sVmSnapshotData;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FlutterMain.class.getName());
    localStringBuilder.append('.');
    localStringBuilder.append("aot-shared-library-name");
    PUBLIC_AOT_SHARED_LIBRARY_NAME = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(FlutterMain.class.getName());
    localStringBuilder.append('.');
    localStringBuilder.append("vm-snapshot-data");
    PUBLIC_VM_SNAPSHOT_DATA_KEY = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(FlutterMain.class.getName());
    localStringBuilder.append('.');
    localStringBuilder.append("isolate-snapshot-data");
    PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(FlutterMain.class.getName());
    localStringBuilder.append('.');
    localStringBuilder.append("flutter-assets-dir");
    PUBLIC_FLUTTER_ASSETS_DIR_KEY = localStringBuilder.toString();
    isRunningInRobolectricTest = false;
    sAotSharedLibraryName = "libapp.so";
    sVmSnapshotData = "vm_snapshot_data";
    sIsolateSnapshotData = "isolate_snapshot_data";
    sFlutterAssetsDir = "flutter_assets";
    sInitialized = false;
    sNativeLibDir = null;
  }
  
  public static void ensureInitializationComplete(@NonNull Context paramContext, @Nullable String[] paramArrayOfString)
  {
    if (isRunningInRobolectricTest) {}
    do
    {
      return;
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label481;
      }
      if (sSettings == null) {
        break;
      }
    } while (sInitialized);
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        if (sResourceExtractor != null) {
          sResourceExtractor.waitForCompletion();
        }
        localArrayList = new ArrayList();
        localArrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
        Object localObject = getApplicationInfo(paramContext);
        if (sNativeLibDir == null)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("--icu-native-lib-path=");
          localStringBuilder.append(((ApplicationInfo)localObject).nativeLibraryDir);
          localStringBuilder.append(File.separator);
          localStringBuilder.append("libflutter.so");
          localArrayList.add(localStringBuilder.toString());
          if (paramArrayOfString != null) {
            Collections.addAll(localArrayList, paramArrayOfString);
          }
          if (sNativeLibDir != null) {
            break label418;
          }
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append("--aot-shared-library-name=");
          paramArrayOfString.append(sAotSharedLibraryName);
          localArrayList.add(paramArrayOfString.toString());
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append("--aot-shared-library-name=");
          paramArrayOfString.append(((ApplicationInfo)localObject).nativeLibraryDir);
          paramArrayOfString.append(File.separator);
          paramArrayOfString.append(sAotSharedLibraryName);
          localArrayList.add(paramArrayOfString.toString());
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append("--cache-dir-path=");
          paramArrayOfString.append(PathUtils.getCacheDirectory(paramContext));
          localArrayList.add(paramArrayOfString.toString());
          if (sSettings.getLogTag() != null)
          {
            paramArrayOfString = new StringBuilder();
            paramArrayOfString.append("--log-tag=");
            paramArrayOfString.append(sSettings.getLogTag());
            localArrayList.add(paramArrayOfString.toString());
          }
          paramArrayOfString = PathUtils.getFilesDir(paramContext);
          localObject = PathUtils.getCacheDirectory(paramContext);
          FlutterJNI.nativeInit(paramContext, (String[])localArrayList.toArray(new String[0]), null, paramArrayOfString, (String)localObject);
          sInitialized = true;
          return;
        }
      }
      catch (Exception paramContext)
      {
        Log.e("FlutterMain", "Flutter initialization failed.", paramContext);
        throw new RuntimeException(paramContext);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--icu-native-lib-path=");
      localStringBuilder.append(sNativeLibDir);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("libflutter.so");
      localArrayList.add(localStringBuilder.toString());
      continue;
      label418:
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("--aot-shared-library-name=");
      paramArrayOfString.append(sNativeLibDir);
      paramArrayOfString.append(File.separator);
      paramArrayOfString.append(sAotSharedLibraryName);
      localArrayList.add(paramArrayOfString.toString());
    }
    throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
    label481:
    throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
  }
  
  public static void ensureInitializationCompleteAsync(@NonNull Context paramContext, @Nullable String[] paramArrayOfString, @NonNull Handler paramHandler, @NonNull Runnable paramRunnable)
  {
    if (isRunningInRobolectricTest) {}
    do
    {
      return;
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label60;
      }
      if (sSettings == null) {
        break;
      }
    } while (sInitialized);
    new Thread(new FlutterMain.1(paramContext, paramArrayOfString, paramHandler, paramRunnable)).start();
    return;
    throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
    label60:
    throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
  }
  
  @NonNull
  public static String findAppBundlePath()
  {
    return sFlutterAssetsDir;
  }
  
  @Deprecated
  @Nullable
  public static String findAppBundlePath(@NonNull Context paramContext)
  {
    return sFlutterAssetsDir;
  }
  
  @NonNull
  private static String fromFlutterAssets(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(sFlutterAssetsDir);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  @NonNull
  private static ApplicationInfo getApplicationInfo(@NonNull Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new RuntimeException(paramContext);
    }
  }
  
  @NonNull
  public static String getLookupKeyForAsset(@NonNull String paramString)
  {
    return fromFlutterAssets(paramString);
  }
  
  @NonNull
  public static String getLookupKeyForAsset(@NonNull String paramString1, @NonNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("packages");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    return getLookupKeyForAsset(localStringBuilder.toString());
  }
  
  private static void initConfig(@NonNull Context paramContext)
  {
    paramContext = getApplicationInfo(paramContext).metaData;
    if (paramContext == null) {
      return;
    }
    sAotSharedLibraryName = paramContext.getString(PUBLIC_AOT_SHARED_LIBRARY_NAME, "libapp.so");
    sFlutterAssetsDir = paramContext.getString(PUBLIC_FLUTTER_ASSETS_DIR_KEY, "flutter_assets");
    sVmSnapshotData = paramContext.getString(PUBLIC_VM_SNAPSHOT_DATA_KEY, "vm_snapshot_data");
    sIsolateSnapshotData = paramContext.getString(PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY, "isolate_snapshot_data");
  }
  
  private static void initResources(@NonNull Context paramContext)
  {
    new ResourceCleaner(paramContext).start();
  }
  
  @VisibleForTesting
  public static void setIsRunningInRobolectricTest(boolean paramBoolean)
  {
    isRunningInRobolectricTest = paramBoolean;
  }
  
  public static void setNativeLibDir(String paramString)
  {
    sNativeLibDir = paramString;
  }
  
  public static void startInitialization(@NonNull Context paramContext)
  {
    if (isRunningInRobolectricTest) {
      return;
    }
    startInitialization(paramContext, new Settings());
  }
  
  public static void startInitialization(@NonNull Context paramContext, @NonNull Settings paramSettings)
  {
    if (isRunningInRobolectricTest) {}
    do
    {
      return;
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break;
      }
    } while (sSettings != null);
    sSettings = paramSettings;
    long l = SystemClock.uptimeMillis();
    initConfig(paramContext);
    initResources(paramContext);
    if (sNativeLibDir == null) {
      System.loadLibrary("flutter");
    }
    for (;;)
    {
      VsyncWaiter.getInstance((WindowManager)paramContext.getSystemService("window")).init();
      FlutterJNI.nativeRecordStartTimestamp(SystemClock.uptimeMillis() - l);
      return;
      paramSettings = new StringBuilder();
      paramSettings.append(sNativeLibDir);
      paramSettings.append(File.separator);
      paramSettings.append("libflutter.so");
      System.load(paramSettings.toString());
    }
    throw new IllegalStateException("startInitialization must be called on the main thread");
  }
  
  public static class Settings
  {
    private String logTag;
    
    @Nullable
    public String getLogTag()
    {
      return this.logTag;
    }
    
    public void setLogTag(String paramString)
    {
      this.logTag = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.view.FlutterMain
 * JD-Core Version:    0.7.0.1
 */