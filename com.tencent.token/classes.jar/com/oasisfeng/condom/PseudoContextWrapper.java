package com.oasisfeng.condom;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.Keep;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.view.Display;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

@Keep
@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
class PseudoContextWrapper
  extends Context
{
  final Context mBase;
  
  public PseudoContextWrapper(Context paramContext)
  {
    this.mBase = paramContext;
  }
  
  public boolean bindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    return this.mBase.bindService(paramIntent, paramServiceConnection, paramInt);
  }
  
  public int checkCallingOrSelfPermission(String paramString)
  {
    return this.mBase.checkCallingOrSelfPermission(paramString);
  }
  
  public int checkCallingOrSelfUriPermission(Uri paramUri, int paramInt)
  {
    return this.mBase.checkCallingOrSelfUriPermission(paramUri, paramInt);
  }
  
  public int checkCallingPermission(String paramString)
  {
    return this.mBase.checkCallingPermission(paramString);
  }
  
  public int checkCallingUriPermission(Uri paramUri, int paramInt)
  {
    return this.mBase.checkCallingUriPermission(paramUri, paramInt);
  }
  
  public int checkPermission(String paramString, int paramInt1, int paramInt2)
  {
    return this.mBase.checkPermission(paramString, paramInt1, paramInt2);
  }
  
  @RequiresApi(23)
  public int checkSelfPermission(String paramString)
  {
    return this.mBase.checkSelfPermission(paramString);
  }
  
  public int checkUriPermission(Uri paramUri, int paramInt1, int paramInt2, int paramInt3)
  {
    return this.mBase.checkUriPermission(paramUri, paramInt1, paramInt2, paramInt3);
  }
  
  public int checkUriPermission(Uri paramUri, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    return this.mBase.checkUriPermission(paramUri, paramString1, paramString2, paramInt1, paramInt2, paramInt3);
  }
  
  @Deprecated
  public void clearWallpaper()
  {
    this.mBase.clearWallpaper();
  }
  
  @RequiresApi(17)
  public Context createConfigurationContext(Configuration paramConfiguration)
  {
    return this.mBase.createConfigurationContext(paramConfiguration);
  }
  
  @RequiresApi(26)
  public Context createContextForSplit(String paramString)
  {
    return this.mBase.createContextForSplit(paramString);
  }
  
  @RequiresApi(24)
  public Context createDeviceProtectedStorageContext()
  {
    return this.mBase.createDeviceProtectedStorageContext();
  }
  
  @RequiresApi(17)
  public Context createDisplayContext(Display paramDisplay)
  {
    return this.mBase.createDisplayContext(paramDisplay);
  }
  
  public Context createPackageContext(String paramString, int paramInt)
  {
    return this.mBase.createPackageContext(paramString, paramInt);
  }
  
  public String[] databaseList()
  {
    return this.mBase.databaseList();
  }
  
  public boolean deleteDatabase(String paramString)
  {
    return this.mBase.deleteDatabase(paramString);
  }
  
  public boolean deleteFile(String paramString)
  {
    return this.mBase.deleteFile(paramString);
  }
  
  @RequiresApi(24)
  public boolean deleteSharedPreferences(String paramString)
  {
    return this.mBase.deleteSharedPreferences(paramString);
  }
  
  public void enforceCallingOrSelfPermission(String paramString1, String paramString2)
  {
    this.mBase.enforceCallingOrSelfPermission(paramString1, paramString2);
  }
  
  public void enforceCallingOrSelfUriPermission(Uri paramUri, int paramInt, String paramString)
  {
    this.mBase.enforceCallingOrSelfUriPermission(paramUri, paramInt, paramString);
  }
  
  public void enforceCallingPermission(String paramString1, String paramString2)
  {
    this.mBase.enforceCallingPermission(paramString1, paramString2);
  }
  
  public void enforceCallingUriPermission(Uri paramUri, int paramInt, String paramString)
  {
    this.mBase.enforceCallingUriPermission(paramUri, paramInt, paramString);
  }
  
  public void enforcePermission(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.mBase.enforcePermission(paramString1, paramInt1, paramInt2, paramString2);
  }
  
  public void enforceUriPermission(Uri paramUri, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.mBase.enforceUriPermission(paramUri, paramInt1, paramInt2, paramInt3, paramString);
  }
  
  public void enforceUriPermission(Uri paramUri, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    this.mBase.enforceUriPermission(paramUri, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3);
  }
  
  public String[] fileList()
  {
    return this.mBase.fileList();
  }
  
  public Context getApplicationContext()
  {
    return this.mBase.getApplicationContext();
  }
  
  public ApplicationInfo getApplicationInfo()
  {
    return this.mBase.getApplicationInfo();
  }
  
  public AssetManager getAssets()
  {
    return this.mBase.getAssets();
  }
  
  public File getCacheDir()
  {
    return this.mBase.getCacheDir();
  }
  
  public ClassLoader getClassLoader()
  {
    return this.mBase.getClassLoader();
  }
  
  @RequiresApi(21)
  public File getCodeCacheDir()
  {
    return this.mBase.getCodeCacheDir();
  }
  
  public ContentResolver getContentResolver()
  {
    return this.mBase.getContentResolver();
  }
  
  @RequiresApi(24)
  public File getDataDir()
  {
    return this.mBase.getDataDir();
  }
  
  public File getDatabasePath(String paramString)
  {
    return this.mBase.getDatabasePath(paramString);
  }
  
  public File getDir(String paramString, int paramInt)
  {
    return this.mBase.getDir(paramString, paramInt);
  }
  
  public File getExternalCacheDir()
  {
    return this.mBase.getExternalCacheDir();
  }
  
  @RequiresApi(19)
  public File[] getExternalCacheDirs()
  {
    return this.mBase.getExternalCacheDirs();
  }
  
  public File getExternalFilesDir(String paramString)
  {
    return this.mBase.getExternalFilesDir(paramString);
  }
  
  @RequiresApi(19)
  public File[] getExternalFilesDirs(String paramString)
  {
    return this.mBase.getExternalFilesDirs(paramString);
  }
  
  @RequiresApi(21)
  public File[] getExternalMediaDirs()
  {
    return this.mBase.getExternalMediaDirs();
  }
  
  public File getFileStreamPath(String paramString)
  {
    return this.mBase.getFileStreamPath(paramString);
  }
  
  public File getFilesDir()
  {
    return this.mBase.getFilesDir();
  }
  
  public Looper getMainLooper()
  {
    return this.mBase.getMainLooper();
  }
  
  @RequiresApi(21)
  public File getNoBackupFilesDir()
  {
    return this.mBase.getNoBackupFilesDir();
  }
  
  @RequiresApi(11)
  public File getObbDir()
  {
    return this.mBase.getObbDir();
  }
  
  @RequiresApi(19)
  public File[] getObbDirs()
  {
    return this.mBase.getObbDirs();
  }
  
  public String getPackageCodePath()
  {
    return this.mBase.getPackageCodePath();
  }
  
  public PackageManager getPackageManager()
  {
    return this.mBase.getPackageManager();
  }
  
  public String getPackageName()
  {
    return this.mBase.getPackageName();
  }
  
  public String getPackageResourcePath()
  {
    return this.mBase.getPackageResourcePath();
  }
  
  public Resources getResources()
  {
    return this.mBase.getResources();
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return this.mBase.getSharedPreferences(paramString, paramInt);
  }
  
  public Object getSystemService(String paramString)
  {
    return this.mBase.getSystemService(paramString);
  }
  
  @RequiresApi(23)
  public String getSystemServiceName(Class<?> paramClass)
  {
    return this.mBase.getSystemServiceName(paramClass);
  }
  
  public Resources.Theme getTheme()
  {
    return this.mBase.getTheme();
  }
  
  @Deprecated
  public Drawable getWallpaper()
  {
    return this.mBase.getWallpaper();
  }
  
  @Deprecated
  public int getWallpaperDesiredMinimumHeight()
  {
    return this.mBase.getWallpaperDesiredMinimumHeight();
  }
  
  @Deprecated
  public int getWallpaperDesiredMinimumWidth()
  {
    return this.mBase.getWallpaperDesiredMinimumWidth();
  }
  
  public void grantUriPermission(String paramString, Uri paramUri, int paramInt)
  {
    this.mBase.grantUriPermission(paramString, paramUri, paramInt);
  }
  
  @RequiresApi(24)
  public boolean isDeviceProtectedStorage()
  {
    return this.mBase.isDeviceProtectedStorage();
  }
  
  public boolean isRestricted()
  {
    return this.mBase.isRestricted();
  }
  
  @RequiresApi(24)
  public boolean moveDatabaseFrom(Context paramContext, String paramString)
  {
    return this.mBase.moveDatabaseFrom(paramContext, paramString);
  }
  
  @RequiresApi(24)
  public boolean moveSharedPreferencesFrom(Context paramContext, String paramString)
  {
    return this.mBase.moveSharedPreferencesFrom(paramContext, paramString);
  }
  
  public FileInputStream openFileInput(String paramString)
  {
    return this.mBase.openFileInput(paramString);
  }
  
  public FileOutputStream openFileOutput(String paramString, int paramInt)
  {
    return this.mBase.openFileOutput(paramString, paramInt);
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return this.mBase.openOrCreateDatabase(paramString, paramInt, paramCursorFactory);
  }
  
  @RequiresApi(11)
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return this.mBase.openOrCreateDatabase(paramString, paramInt, paramCursorFactory, paramDatabaseErrorHandler);
  }
  
  @Deprecated
  public Drawable peekWallpaper()
  {
    return this.mBase.peekWallpaper();
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    return this.mBase.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
  }
  
  @RequiresApi(26)
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, int paramInt)
  {
    return this.mBase.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramInt);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler)
  {
    return this.mBase.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler);
  }
  
  @RequiresApi(26)
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler, int paramInt)
  {
    return this.mBase.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler, paramInt);
  }
  
  @SuppressLint({"MissingPermission"})
  public void removeStickyBroadcast(Intent paramIntent)
  {
    this.mBase.removeStickyBroadcast(paramIntent);
  }
  
  @Deprecated
  @SuppressLint({"MissingPermission"})
  @RequiresApi(17)
  public void removeStickyBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle)
  {
    this.mBase.removeStickyBroadcastAsUser(paramIntent, paramUserHandle);
  }
  
  public void revokeUriPermission(Uri paramUri, int paramInt)
  {
    this.mBase.revokeUriPermission(paramUri, paramInt);
  }
  
  @RequiresApi(26)
  public void revokeUriPermission(String paramString, Uri paramUri, int paramInt)
  {
    this.mBase.revokeUriPermission(paramString, paramUri, paramInt);
  }
  
  public void sendBroadcast(Intent paramIntent)
  {
    this.mBase.sendBroadcast(paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent, String paramString)
  {
    this.mBase.sendBroadcast(paramIntent, paramString);
  }
  
  @SuppressLint({"MissingPermission"})
  @RequiresApi(17)
  public void sendBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle)
  {
    this.mBase.sendBroadcastAsUser(paramIntent, paramUserHandle);
  }
  
  @SuppressLint({"MissingPermission"})
  @RequiresApi(17)
  public void sendBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle, String paramString)
  {
    this.mBase.sendBroadcastAsUser(paramIntent, paramUserHandle, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString)
  {
    this.mBase.sendOrderedBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle)
  {
    this.mBase.sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
  }
  
  @SuppressLint({"MissingPermission"})
  @RequiresApi(17)
  public void sendOrderedBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle)
  {
    this.mBase.sendOrderedBroadcastAsUser(paramIntent, paramUserHandle, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
  }
  
  @SuppressLint({"MissingPermission"})
  public void sendStickyBroadcast(Intent paramIntent)
  {
    this.mBase.sendStickyBroadcast(paramIntent);
  }
  
  @SuppressLint({"MissingPermission"})
  @RequiresApi(17)
  public void sendStickyBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle)
  {
    this.mBase.sendStickyBroadcastAsUser(paramIntent, paramUserHandle);
  }
  
  @SuppressLint({"MissingPermission"})
  public void sendStickyOrderedBroadcast(Intent paramIntent, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString, Bundle paramBundle)
  {
    this.mBase.sendStickyOrderedBroadcast(paramIntent, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
  }
  
  @SuppressLint({"MissingPermission"})
  @RequiresApi(17)
  public void sendStickyOrderedBroadcastAsUser(Intent paramIntent, UserHandle paramUserHandle, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString, Bundle paramBundle)
  {
    this.mBase.sendStickyOrderedBroadcastAsUser(paramIntent, paramUserHandle, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
  }
  
  public void setTheme(int paramInt)
  {
    this.mBase.setTheme(paramInt);
  }
  
  @Deprecated
  public void setWallpaper(Bitmap paramBitmap)
  {
    this.mBase.setWallpaper(paramBitmap);
  }
  
  @Deprecated
  public void setWallpaper(InputStream paramInputStream)
  {
    this.mBase.setWallpaper(paramInputStream);
  }
  
  @RequiresApi(11)
  public void startActivities(Intent[] paramArrayOfIntent)
  {
    this.mBase.startActivities(paramArrayOfIntent);
  }
  
  @RequiresApi(16)
  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    this.mBase.startActivities(paramArrayOfIntent, paramBundle);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.mBase.startActivity(paramIntent);
  }
  
  @RequiresApi(16)
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    this.mBase.startActivity(paramIntent, paramBundle);
  }
  
  @RequiresApi(26)
  public ComponentName startForegroundService(Intent paramIntent)
  {
    return this.mBase.startForegroundService(paramIntent);
  }
  
  public boolean startInstrumentation(ComponentName paramComponentName, String paramString, Bundle paramBundle)
  {
    return this.mBase.startInstrumentation(paramComponentName, paramString, paramBundle);
  }
  
  public void startIntentSender(IntentSender paramIntentSender, Intent paramIntent, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mBase.startIntentSender(paramIntentSender, paramIntent, paramInt1, paramInt2, paramInt3);
  }
  
  @RequiresApi(16)
  public void startIntentSender(IntentSender paramIntentSender, Intent paramIntent, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    this.mBase.startIntentSender(paramIntentSender, paramIntent, paramInt1, paramInt2, paramInt3, paramBundle);
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    return this.mBase.startService(paramIntent);
  }
  
  public boolean stopService(Intent paramIntent)
  {
    return this.mBase.stopService(paramIntent);
  }
  
  public void unbindService(ServiceConnection paramServiceConnection)
  {
    this.mBase.unbindService(paramServiceConnection);
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    this.mBase.unregisterReceiver(paramBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.oasisfeng.condom.PseudoContextWrapper
 * JD-Core Version:    0.7.0.1
 */