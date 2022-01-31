package com.tencent.uncompress;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

public class UncompressSo
{
  private static UncompressSo DecRawsoSingleton = null;
  private static final int HDL_MSGBASE = 54321;
  public static final int HDL_MSGDECEND = 54322;
  public static final int SZ_ERROR_MEM = 2;
  public static final int SZ_ERROR_WRITE = 9;
  private static String sFilter = null;
  private static String sFix = null;
  private String abi = null;
  private boolean bWorkat7z = false;
  private ProgressDialog dProDlg;
  private long lasttime = 0L;
  private int localVersion = 0;
  private Context mAppContext;
  private Thread mDec7zLibThread = null;
  private Handler mHdl;
  private UtilsFunc mUtils = new UtilsFunc();
  private String sAppFilePath = null;
  private String sPathName = null;
  
  private UncompressSo() {}
  
  private UncompressSo(Context paramContext)
  {
    this.bWorkat7z = false;
    this.localVersion = 0;
    this.dProDlg = null;
    this.mDec7zLibThread = null;
    this.mHdl = null;
    this.mAppContext = paramContext.getApplicationContext();
    this.sAppFilePath = paramContext.getFilesDir().getAbsolutePath();
    this.sPathName = (this.sAppFilePath + "/../lib/");
    Object localObject1 = null;
    this.abi = Build.CPU_ABI;
    if ((!this.abi.contains("arm")) && (!this.abi.contains("x86")) && (!this.abi.contains("mips")) && (!this.abi.contains("x32"))) {
      this.abi = "armeabi";
    }
    Object localObject2 = getX86abi();
    if (localObject2 != null)
    {
      this.abi = ((String)localObject2);
      if (this.abi.contains("x32")) {
        this.abi = "x86";
      }
    }
    localObject2 = this.mAppContext.getAssets();
    try
    {
      localObject2 = ((AssetManager)localObject2).openFd("compressedso.jpg");
      localObject1 = localObject2;
      ((AssetFileDescriptor)localObject2).close();
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      try
      {
        paramContext = paramContext.getApplicationContext().getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
        this.localVersion = paramContext.versionCode;
        if (Build.VERSION.SDK_INT < 9) {
          break label283;
        }
        this.lasttime = GetLastTime(paramContext);
        paramContext = new File(this.sAppFilePath + "/UncompressedSoLibs/decdone_" + this.localVersion + "_" + this.lasttime);
        if (!paramContext.exists()) {
          break label396;
        }
        this.sPathName = (this.sAppFilePath + "/UncompressedSoLibs/");
        this.bWorkat7z = true;
        new CrashHandler();
        return;
        localIOException = localIOException;
        localIOException.printStackTrace();
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          continue;
          try
          {
            Thread.sleep(200L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    if (localObject1 == null) {}
  }
  
  private UncompressSo(Context paramContext, Handler paramHandler, boolean paramBoolean)
  {
    int j = 0;
    this.bWorkat7z = false;
    this.localVersion = 0;
    this.dProDlg = null;
    this.mDec7zLibThread = null;
    this.mHdl = paramHandler;
    this.mAppContext = paramContext.getApplicationContext();
    this.sAppFilePath = paramContext.getFilesDir().getAbsolutePath();
    this.sPathName = (this.sAppFilePath + "/../lib/");
    this.abi = Build.CPU_ABI;
    if ((!this.abi.contains("arm")) && (!this.abi.contains("x86")) && (!this.abi.contains("mips")) && (!this.abi.contains("x32"))) {
      this.abi = "armeabi";
    }
    paramHandler = getX86abi();
    if (paramHandler != null)
    {
      this.abi = paramHandler;
      if (this.abi.contains("x32")) {
        this.abi = "x86";
      }
    }
    try
    {
      paramHandler = paramContext.getApplicationContext().getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      this.localVersion = paramHandler.versionCode;
      if (Build.VERSION.SDK_INT >= 9) {
        this.lasttime = GetLastTime(paramHandler);
      }
      localFile = new File(this.sAppFilePath + "/UncompressedSoLibs/decdone_" + this.localVersion + "_" + this.lasttime);
      paramHandler = new File(this.sAppFilePath + "/UncompressedSoLibs/");
      if (!localFile.exists())
      {
        bool2 = true;
        bool1 = true;
        if (!paramHandler.exists())
        {
          paramHandler.mkdir();
          bool2 = bool1;
          this.sPathName = (this.sAppFilePath + "/UncompressedSoLibs/");
          this.bWorkat7z = true;
          Dec7zLib(paramBoolean, bool2, paramContext);
          i = 1;
          new CrashHandler();
          if (i == 0) {
            SendDecEndMsg(0);
          }
          return;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramHandler)
    {
      for (;;)
      {
        File localFile;
        boolean bool2;
        paramHandler.printStackTrace();
        this.localVersion = 0;
        this.lasttime = 0L;
        continue;
        boolean bool1 = bool2;
        if (new File(this.sAppFilePath + "/UncompressedSoLibs/_FORCEARM_.tmp").exists())
        {
          bool1 = bool2;
          if (this.abi.contains("x86"))
          {
            this.abi = "armeabi-v7a";
            bool1 = false;
          }
        }
        paramHandler = paramHandler.listFiles();
        j = paramHandler.length;
        int i = 0;
        for (;;)
        {
          bool2 = bool1;
          if (i >= j) {
            break;
          }
          paramHandler[i].delete();
          i += 1;
        }
        this.sPathName = (this.sAppFilePath + "/UncompressedSoLibs/");
        this.bWorkat7z = true;
        i = j;
        if (!new File(this.sAppFilePath + "/UncompressedSoLibs/cloud.txt").exists())
        {
          localFile = new File(this.sAppFilePath + "/UncompressedSoLibsCld/");
          if (localFile.exists())
          {
            i = j;
            if (new File(this.sAppFilePath + "/UncompressedSoLibsCld/decdone_" + this.localVersion + "_" + this.lasttime).exists())
            {
              paramContext = new File(this.sAppFilePath + "/UncompressedSoLibsClTmp/");
              paramHandler.renameTo(paramContext);
              localFile.renameTo(new File(this.sAppFilePath + "/UncompressedSoLibs/"));
              paramHandler = paramContext.listFiles();
              int k = paramHandler.length;
              i = 0;
              for (;;)
              {
                if (i >= k)
                {
                  paramContext.delete();
                  i = j;
                  break;
                }
                paramHandler[i].delete();
                i += 1;
              }
            }
          }
          else
          {
            i = j;
            if (new File(this.sAppFilePath + "/UncompressedSoLibs/cloudrawso").exists())
            {
              Dec7zCloudLib();
              i = j;
            }
          }
        }
      }
    }
  }
  
  public static void ConfigureFilter(String paramString1, String paramString2)
  {
    sFilter = paramString1;
    sFix = paramString2;
    if (DecRawsoSingleton != null) {
      DecRawsoSingleton.delteFilter();
    }
  }
  
  private void Dec7zLib(boolean paramBoolean1, boolean paramBoolean2, Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 9) {
      System.loadLibrary("CompressedSo22");
    }
    for (;;)
    {
      if (sFilter != null) {
        SetFilter(sFilter, sFix);
      }
      if (paramBoolean1) {}
      try
      {
        this.dProDlg = ProgressDialog.show(paramContext, paramContext.getResources().getString(this.mUtils.getIdByName(this.mAppContext, "string", "DecRawso_Initializing")), paramContext.getResources().getString(this.mUtils.getIdByName(this.mAppContext, "string", "DecRawso_Wait")));
        label90:
        this.mDec7zLibThread = new Thread(new Dec7zLibThread(paramBoolean2));
        this.mDec7zLibThread.start();
        return;
        System.loadLibrary("CompressedSo");
      }
      catch (Exception paramContext)
      {
        break label90;
      }
    }
  }
  
  public static UncompressSo GetInstance()
  {
    return DecRawsoSingleton;
  }
  
  @TargetApi(9)
  private long GetLastTime(PackageInfo paramPackageInfo)
  {
    return paramPackageInfo.lastUpdateTime;
  }
  
  private native boolean IsArmMode();
  
  public static boolean NewInstance(Context paramContext, Handler paramHandler, boolean paramBoolean)
  {
    if (DecRawsoSingleton == null)
    {
      DecRawsoSingleton = new UncompressSo(paramContext, paramHandler, paramBoolean);
      return true;
    }
    DecRawsoSingleton.UpdateHdl(paramHandler);
    DecRawsoSingleton.SendDecEndMsg(0);
    return false;
  }
  
  public static boolean NewInstanceInService(Context paramContext)
  {
    if (DecRawsoSingleton == null)
    {
      DecRawsoSingleton = new UncompressSo(paramContext);
      return true;
    }
    return false;
  }
  
  private void ProDlg_Dismiss()
  {
    if (this.dProDlg != null)
    {
      if (this.dProDlg.isShowing()) {
        this.dProDlg.dismiss();
      }
      this.dProDlg = null;
    }
  }
  
  private void SendDecEndMsg(int paramInt)
  {
    ProDlg_Dismiss();
    if (this.mHdl != null) {
      this.mHdl.sendMessage(this.mHdl.obtainMessage(54322, paramInt, 0));
    }
  }
  
  private native void SetFilter(String paramString1, String paramString2);
  
  private native int Uncompress(AssetManager paramAssetManager, String paramString1, String paramString2, String paramString3);
  
  private void UpdateHdl(Handler paramHandler)
  {
    this.mHdl = paramHandler;
  }
  
  private void delteFilter()
  {
    int m = 0;
    waitdecoding();
    int j;
    File[] arrayOfFile;
    int i;
    if (this.bWorkat7z)
    {
      j = 0;
      arrayOfFile = new File(this.sAppFilePath + "/UncompressedSoLibs/").listFiles();
      int n = arrayOfFile.length;
      i = 0;
      if (i < n) {
        break label81;
      }
      if (j != 0)
      {
        j = arrayOfFile.length;
        i = m;
      }
    }
    for (;;)
    {
      if (i >= j)
      {
        return;
        label81:
        localFile = arrayOfFile[i];
        int k = j;
        if (localFile.isFile())
        {
          k = j;
          if (localFile.getName().startsWith(sFilter))
          {
            k = j;
            if (localFile.getName().compareTo(sFix) == 0) {
              k = 1;
            }
          }
        }
        i += 1;
        j = k;
        break;
      }
      File localFile = arrayOfFile[i];
      if ((localFile.isFile()) && (localFile.getName().startsWith(sFilter)) && (localFile.getName().compareTo(sFix) != 0)) {
        localFile.delete();
      }
      i += 1;
    }
  }
  
  public static boolean getX86Cpu()
  {
    boolean bool1 = false;
    Object localObject = Build.CPU_ABI;
    if ((((String)localObject).contains("x86")) || (((String)localObject).contains("x32"))) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      try
      {
        localObject = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream()));
        String str = ((BufferedReader)localObject).readLine();
        ((BufferedReader)localObject).close();
        if (!str.contains("x86"))
        {
          boolean bool2 = str.contains("x32");
          if (!bool2) {}
        }
        else
        {
          return true;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    return false;
  }
  
  private String getX86abi()
  {
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream()));
      String str = localBufferedReader.readLine();
      localBufferedReader.close();
      if (!str.contains("x86"))
      {
        boolean bool = str.contains("x32");
        if (!bool) {}
      }
      else
      {
        return str;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }
  
  private String geterror(int paramInt)
  {
    return "启动失败,空间不足";
  }
  
  private void myreboot()
  {
    System.exit(0);
  }
  
  void Dec7zCloudLib()
  {
    if (sFilter != null) {
      SetFilter(sFilter, sFix);
    }
    new Thread(new Dec7zCloudLibThread()).start();
  }
  
  public String GetPath(String paramString)
  {
    waitdecoding();
    File localFile1;
    if ((this.bWorkat7z) && (!new File(this.sPathName + "lib" + paramString + ".so").exists()))
    {
      localFile1 = new File(this.sPathName + "decdone_" + this.localVersion + "_" + this.lasttime);
      if (localFile1.exists()) {
        break label153;
      }
      myreboot();
    }
    for (;;)
    {
      return this.sPathName + "lib" + paramString + ".so";
      label153:
      if ((!this.abi.contains("x86")) || (new File(this.sAppFilePath + "/UncompressedSoLibs/armmode").exists())) {
        continue;
      }
      File localFile2 = new File(this.sPathName + "_FORCEARM_.tmp");
      try
      {
        localFile2.createNewFile();
        localFile1.delete();
        myreboot();
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  public String GetStorePath()
  {
    return this.sPathName;
  }
  
  public boolean ShowError(Context paramContext, int paramInt)
  {
    this.mHdl = null;
    if (paramInt == 0) {
      return false;
    }
    String str = geterror(paramInt);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
    localBuilder.setTitle(paramContext.getResources().getString(this.mUtils.getIdByName(this.mAppContext, "string", "DecRawso_Initial_Error"))).setMessage(str).setPositiveButton(paramContext.getResources().getString(this.mUtils.getIdByName(this.mAppContext, "string", "DecRawso_Quit")), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        System.exit(0);
      }
    });
    localBuilder.create().show();
    return true;
  }
  
  public boolean waitdecoding()
  {
    if (this.mDec7zLibThread != null) {
      try
      {
        this.mDec7zLibThread.join();
        this.mDec7zLibThread = null;
        return true;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    return false;
  }
  
  private class CrashHandler
    implements Thread.UncaughtExceptionHandler
  {
    private Thread.UncaughtExceptionHandler mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    
    public CrashHandler()
    {
      Thread.setDefaultUncaughtExceptionHandler(this);
    }
    
    private boolean handleException(Throwable paramThrowable)
    {
      if ((paramThrowable instanceof UnsatisfiedLinkError))
      {
        if (UncompressSo.this.abi.contains("x86"))
        {
          paramThrowable = paramThrowable.getMessage().split(" ");
          if ((paramThrowable[0].compareTo("Couldn't") == 0) && (paramThrowable[1].compareTo("load") == 0)) {
            UncompressSo.this.GetPath(paramThrowable[2]);
          }
        }
        while (UncompressSo.this.waitdecoding()) {
          return true;
        }
        return false;
      }
      return false;
    }
    
    public void uncaughtException(Thread paramThread, Throwable paramThrowable)
    {
      if ((!handleException(paramThrowable)) && (this.mDefaultHandler != null))
      {
        this.mDefaultHandler.uncaughtException(paramThread, paramThrowable);
        return;
      }
      UncompressSo.this.mUtils.showToastInThread(UncompressSo.this.mAppContext.getResources().getString(UncompressSo.this.mUtils.getIdByName(UncompressSo.this.mAppContext, "string", "DecRawso_ReStrat")), UncompressSo.this.mAppContext);
      System.exit(1);
    }
  }
  
  class Dec7zCloudLibThread
    implements Runnable
  {
    int res;
    
    Dec7zCloudLibThread() {}
    
    public void run()
    {
      this.res = UncompressSo.this.Uncompress(null, UncompressSo.this.sAppFilePath + "/UncompressedSoLibs/cloudrawso", UncompressSo.this.sAppFilePath + "/UncompressedSoLibsCld/", UncompressSo.this.abi);
      new File(UncompressSo.this.sAppFilePath + "/UncompressedSoLibs/cloudrawso").delete();
      Object localObject;
      if (this.res == 0) {
        localObject = new File(UncompressSo.this.sAppFilePath + "/UncompressedSoLibsCld/decdone_" + UncompressSo.this.localVersion + "_" + UncompressSo.this.lasttime);
      }
      try
      {
        ((File)localObject).createNewFile();
        if (UncompressSo.this.IsArmMode()) {
          localObject = new File(UncompressSo.this.sAppFilePath + "/UncompressedSoLibsCld/armmode");
        }
      }
      catch (IOException localIOException2)
      {
        try
        {
          ((File)localObject).createNewFile();
        }
        catch (IOException localIOException2)
        {
          try
          {
            for (;;)
            {
              Thread.sleep(1000L);
              localObject = ((ActivityManager)UncompressSo.this.mAppContext.getSystemService("activity")).getRunningTasks(1);
              if (((List)localObject).size() > 0)
              {
                if (!UncompressSo.this.mAppContext.getPackageName().equals(((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getPackageName())) {
                  System.exit(0);
                }
              }
              else
              {
                return;
                localIOException1 = localIOException1;
                localIOException1.printStackTrace();
                continue;
                localIOException2 = localIOException2;
                localIOException2.printStackTrace();
              }
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  class Dec7zLibThread
    implements Runnable
  {
    private boolean bCloudDownload;
    
    public Dec7zLibThread(boolean paramBoolean)
    {
      this.bCloudDownload = paramBoolean;
    }
    
    private int readRawso(String paramString)
    {
      Object localObject = UncompressSo.this.mAppContext.getAssets();
      try
      {
        localObject = new BufferedInputStream(((AssetManager)localObject).open("compressedso.jpg"));
        paramString = new BufferedOutputStream(new FileOutputStream(new File(paramString)));
        if ((localObject != null) && (paramString != null))
        {
          byte[] arrayOfByte = new byte[4096];
          for (;;)
          {
            int i = ((BufferedInputStream)localObject).read(arrayOfByte);
            if (i == -1)
            {
              paramString.flush();
              ((BufferedInputStream)localObject).close();
              paramString.close();
              return 0;
            }
            paramString.write(arrayOfByte, 0, i);
          }
        }
        return 9;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return 9;
      }
    }
    
    public void run()
    {
      int i;
      if (Build.VERSION.SDK_INT < 9)
      {
        System.out.println("spooner 1");
        int j = readRawso(UncompressSo.this.sAppFilePath + "/UncompressedSoLibs/compressedso.jpg");
        System.out.println("spooner 2 res = " + j);
        i = j;
        if (j == 0)
        {
          System.out.println("spooner 3");
          i = UncompressSo.this.Uncompress(null, UncompressSo.this.sAppFilePath + "/UncompressedSoLibs/compressedso.jpg", UncompressSo.this.sPathName, UncompressSo.this.abi);
          System.out.println("spooner 4 res= " + i);
        }
      }
      for (;;)
      {
        File localFile;
        if (i == 0)
        {
          System.out.println("spooner 6");
          localFile = new File(UncompressSo.this.sAppFilePath + "/UncompressedSoLibs/decdone_" + UncompressSo.this.localVersion + "_" + UncompressSo.this.lasttime);
        }
        try
        {
          localFile.createNewFile();
          if (UncompressSo.this.IsArmMode())
          {
            System.out.println("spooner 7");
            localFile = new File(UncompressSo.this.sAppFilePath + "/UncompressedSoLibs/armmode");
          }
        }
        catch (IOException localIOException1)
        {
          try
          {
            localFile.createNewFile();
            localFile = new File(UncompressSo.this.sAppFilePath + "/UncompressedSoLibs/cloud.txt");
            if (localFile.exists()) {
              localFile.delete();
            }
            if (Build.VERSION.SDK_INT < 9)
            {
              localFile = new File(UncompressSo.this.sAppFilePath + "/UncompressedSoLibs/CompressedSo22");
              if (localFile.exists()) {
                localFile.delete();
              }
            }
            if ((UncompressSo.this.mHdl != null) && (i == 0))
            {
              System.out.println("spooner 8");
              UncompressSo.this.SendDecEndMsg(i);
              return;
              System.out.println("spooner 5");
              i = UncompressSo.this.Uncompress(UncompressSo.this.mAppContext.getAssets(), null, UncompressSo.this.sPathName, UncompressSo.this.abi);
              continue;
              localIOException1 = localIOException1;
              localIOException1.printStackTrace();
            }
          }
          catch (IOException localIOException2)
          {
            do
            {
              for (;;)
              {
                localIOException2.printStackTrace();
              }
              System.out.println("spooner 9 code=" + i);
            } while (i == 0);
            UncompressSo.this.mUtils.showToastInThread(UncompressSo.this.geterror(i), UncompressSo.this.mAppContext);
            System.exit(0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.uncompress.UncompressSo
 * JD-Core Version:    0.7.0.1
 */