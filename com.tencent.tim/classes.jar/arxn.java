import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import org.xmlpull.v1.XmlPullParserException;

public class arxn
{
  protected static Map<String, String> oO = new HashMap();
  
  public static int Ni()
  {
    int j = 1;
    Object localObject = new String[5];
    localObject[0] = "/system/xbin/";
    localObject[1] = "/system/bin/";
    localObject[2] = "/system/sbin/";
    localObject[3] = "/sbin/";
    localObject[4] = "/vendor/bin/";
    int i = 0;
    try
    {
      while (i < localObject.length)
      {
        String str = localObject[i] + "su";
        File localFile = new File(str);
        if ((localFile != null) && (localFile.exists()))
        {
          localObject = j(new String[] { "ls", "-l", str });
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            int k = ((String)localObject).indexOf("root");
            int m = ((String)localObject).lastIndexOf("root");
            i = j;
            if (k != m) {}
          }
          else
          {
            i = 0;
          }
          return i;
        }
        i += 1;
      }
      return 2;
    }
    catch (Exception localException) {}
  }
  
  public static Bitmap S(String paramString)
  {
    try
    {
      PackageManager localPackageManager = aroi.a().getContext().getPackageManager();
      paramString = localPackageManager.getPackageInfo(paramString, 1);
      if ((paramString != null) && (paramString.applicationInfo != null))
      {
        paramString = paramString.applicationInfo.loadIcon(localPackageManager);
        if (paramString != null)
        {
          paramString = arwr.h(paramString);
          return paramString;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void Xp(String paramString)
    throws IOException
  {
    i = 0;
    try
    {
      long l1 = new File(paramString).length();
      localQZipFile = new QZipFile(paramString);
      try
      {
        paramString = localQZipFile.entries();
        j = 0;
        do
        {
          if (!paramString.hasMoreElements()) {
            break;
          }
          localZipEntry = (ZipEntry)paramString.nextElement();
        } while (localZipEntry.isDirectory());
        l2 = localZipEntry.getCompressedSize();
        l3 = localZipEntry.getSize();
        if ((l2 >= -1L) && (l2 <= l1) && (l3 >= -1L) && (l3 <= 1500L * l2)) {
          break label136;
        }
        throw new RuntimeException("Invalid entry size!");
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        ZipEntry localZipEntry;
        long l2;
        long l3;
        QZipFile localQZipFile = null;
        continue;
        int k = i;
        i = j;
        int j = k;
      }
    }
    if (localQZipFile != null) {
      localQZipFile.close();
    }
    throw paramString;
    label136:
    if ((localZipEntry.getName() != null) && (localZipEntry.getName().contains("AndroidManifest.xml")))
    {
      if ((l2 == 0L) || (l3 == 0L)) {
        throw new RuntimeException("Invalid AndroidManifest!");
      }
      a(localQZipFile, localZipEntry, false);
      k = 1;
      i = j;
      j = k;
      label195:
      if ((i == 0) || (j == 0)) {
        break label252;
      }
      if (localQZipFile != null) {
        localQZipFile.close();
      }
    }
    label252:
    do
    {
      return;
      if ((localZipEntry.getName() == null) || (!localZipEntry.getName().contains("classes.dex"))) {
        break label279;
      }
      a(localQZipFile, localZipEntry, false);
      k = 1;
      j = i;
      i = k;
      break label195;
      k = j;
      j = i;
      i = k;
      break;
    } while (localQZipFile == null);
    localQZipFile.close();
  }
  
  public static java.lang.Process a()
  {
    Object localObject = new ProcessBuilder(new String[] { "su" });
    ((ProcessBuilder)localObject).redirectErrorStream(false);
    try
    {
      localObject = ((ProcessBuilder)localObject).start();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static void a(QZipFile paramQZipFile, ZipEntry paramZipEntry, boolean paramBoolean)
    throws IOException
  {
    // Byte code:
    //   0: sipush 4096
    //   3: newarray byte
    //   5: astore 5
    //   7: aconst_null
    //   8: astore 4
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 205	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   15: astore_0
    //   16: iload_2
    //   17: ifeq +27 -> 44
    //   20: aload_0
    //   21: astore 4
    //   23: aload_0
    //   24: aload 5
    //   26: invokevirtual 211	java/io/InputStream:read	([B)I
    //   29: istore_3
    //   30: iconst_m1
    //   31: iload_3
    //   32: if_icmpne -12 -> 20
    //   35: aload_0
    //   36: ifnull +7 -> 43
    //   39: aload_0
    //   40: invokevirtual 212	java/io/InputStream:close	()V
    //   43: return
    //   44: aload_0
    //   45: astore 4
    //   47: aload_0
    //   48: aload 5
    //   50: invokevirtual 211	java/io/InputStream:read	([B)I
    //   53: pop
    //   54: goto -19 -> 35
    //   57: astore_0
    //   58: aload 4
    //   60: ifnull +8 -> 68
    //   63: aload 4
    //   65: invokevirtual 212	java/io/InputStream:close	()V
    //   68: aload_0
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramQZipFile	QZipFile
    //   0	70	1	paramZipEntry	ZipEntry
    //   0	70	2	paramBoolean	boolean
    //   29	4	3	i	int
    //   8	56	4	localQZipFile	QZipFile
    //   5	44	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   10	16	57	finally
    //   23	30	57	finally
    //   47	54	57	finally
  }
  
  public static boolean a(Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
    if (localIntent == null)
    {
      localIntent = new Intent(paramString);
      localIntent.addCategory("android.intent.category.DEFAULT");
      try
      {
        for (;;)
        {
          localIntent.addFlags(paramInt);
          localIntent.putExtras(paramBundle);
          try
          {
            ((acly)((BaseActivity)paramContext).app.getBusinessHandler(23)).b(paramString.trim(), paramContext, localIntent);
            return true;
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              try
              {
                new acly((QQAppInterface)null).a(paramString.trim(), paramContext, localIntent);
              }
              catch (Exception paramString)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler Failed!");
                }
                paramContext.startActivity(localIntent);
              }
            }
          }
        }
      }
      catch (Exception paramString)
      {
        Toast.makeText(paramContext, acfp.m(2131702770), 0).show();
        return false;
      }
    }
  }
  
  public static boolean aHi()
  {
    try
    {
      Object localObject = new ProcessBuilder(new String[] { "su" });
      ((ProcessBuilder)localObject).redirectErrorStream(false);
      localObject = ((ProcessBuilder)localObject).start();
      DataOutputStream localDataOutputStream = new DataOutputStream(((java.lang.Process)localObject).getOutputStream());
      DataInputStream localDataInputStream = new DataInputStream(((java.lang.Process)localObject).getInputStream());
      if ((localDataInputStream != null) && (localDataOutputStream != null))
      {
        localDataOutputStream.flush();
        localDataOutputStream.writeBytes("id\n");
        localDataOutputStream.flush();
        localDataOutputStream.writeBytes("exit\n");
        localDataOutputStream.flush();
        ((java.lang.Process)localObject).waitFor();
        localObject = localDataInputStream.readLine();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          boolean bool = ((String)localObject).contains("uid=0");
          if (bool) {
            return true;
          }
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public static boolean aZ(Context paramContext, String paramString)
  {
    try
    {
      paramContext.startActivity(new Intent("android.intent.action.DELETE", Uri.parse("package:" + paramString)));
      return true;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static void an(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramString1);
      localIntent.putExtra("platformId", "qzone_m");
      arwt.d("add", ">>has add platformid=qzone_m");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      new Intent();
      paramString1 = g(paramContext, paramString1);
      if (paramString1 != null)
      {
        paramString1.setAction("android.intent.action.MAIN");
        paramString1.putExtra("platformId", "qzone_m");
        paramString1.putExtra("big_brother_source_key", paramString2);
        arwt.d("add", ">>has add platformid=qzone_m");
        try
        {
          paramContext.startActivity(paramString1);
          return;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
          Toast.makeText(paramContext, acfp.m(2131702767), 0).show();
          return;
        }
      }
      Toast.makeText(paramContext, acfp.m(2131702768), 0).show();
    }
  }
  
  public static boolean appIsExists(String paramString)
  {
    return aqiz.isAppInstalled(aroi.a().getContext(), paramString);
  }
  
  public static String aq(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      if (paramContext != null)
      {
        paramContext = paramContext.signatures;
        if ((paramContext != null) && (paramContext.length > 0))
        {
          paramContext = arwv.toMD5(paramContext[(paramContext.length - 1)].toCharsString());
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return "";
    }
    return "";
  }
  
  public static String bI(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static int bt(String paramString)
  {
    arwt.i("AppUtil", "getAppVersionCode: " + paramString);
    localObject1 = null;
    try
    {
      Xp(paramString);
      Object localObject2 = (AssetManager)AssetManager.class.newInstance();
      Method localMethod = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localObject2, new Object[] { paramString });
      localObject2 = ((AssetManager)localObject2).openXmlResourceParser("AndroidManifest.xml");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        arwt.e("AppUtil", "openManifest failed: " + localException.getMessage());
      }
    }
    if (localObject1 == null) {
      return 0;
    }
    for (;;)
    {
      try
      {
        i = localObject1.getEventType();
      }
      catch (XmlPullParserException paramString)
      {
        String str;
        arwt.e("AppUtil", "error: " + paramString.getMessage());
        localObject1.close();
        return 0;
      }
      catch (IOException paramString)
      {
        arwt.e("AppUtil", "error: " + paramString.getMessage());
        continue;
      }
      catch (Exception paramString)
      {
        int i;
        arwt.e("AppUtil", "error: " + paramString.getMessage());
        continue;
        if (i == 1) {
          continue;
        }
        switch (i)
        {
        }
        continue;
      }
      i = localObject1.nextToken();
      continue;
      str = localObject1.getName();
      if ((!TextUtils.isEmpty(str)) && (str.equals("manifest")))
      {
        i = 0;
        if (i < localObject1.getAttributeCount())
        {
          if (localObject1.getAttributeName(i).equals("versionCode"))
          {
            str = localObject1.getAttributeValue(i);
            localObject1.close();
            arwt.i("AppUtil", "apkPath:" + paramString + ",versionCode:" + str);
            i = Integer.parseInt(str);
            return i;
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean ct(Context paramContext)
  {
    if (paramContext == null)
    {
      arwt.e("AppUtil", "isPackageScanAllowed context is null");
      return true;
    }
    try
    {
      boolean bool = aroi.a().getContext().getSharedPreferences("package_scan", 0).getBoolean("qqsetting_package_scan_flag", true);
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return true;
  }
  
  public static boolean d(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        return false;
      }
      if (new File(paramString1).exists())
      {
        TMAssistantDownloadManager.getInstance(paramContext.getApplicationContext()).hookAM4Install();
        paramString1 = FileProvider7Helper.openApkIntent(paramContext, paramString1);
        if (GlobalUtil.isVivo()) {
          paramString1.putExtra("installDir", true);
        }
        if (!TextUtils.isEmpty(paramString2))
        {
          arwt.i("AppUtil", "installApp>>> put source " + paramString2);
          paramString1.putExtra("big_brother_source_key", paramString2);
        }
        if (!TextUtils.isEmpty(paramString3))
        {
          arwt.i("AppUtil", "installApp>>> put ref id " + paramString3);
          paramString1.putExtra("big_brother_ref_source_key", paramString3);
        }
        paramContext.startActivity(paramString1);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      arwt.e("AppUtil", "installApp>>>", paramContext);
    }
    return false;
  }
  
  public static void db(Context paramContext, String paramString)
  {
    an(paramContext, paramString, "");
  }
  
  public static int fA(String paramString)
  {
    PackageManager localPackageManager = aroi.a().getContext().getPackageManager();
    try
    {
      paramString = localPackageManager.getPackageInfo(paramString, 1);
      if (paramString != null)
      {
        int i = paramString.versionCode;
        return i;
      }
    }
    catch (Exception paramString)
    {
      arwt.w("AppUtil", "getApkVersonCode>>>", paramString);
    }
    return 0;
  }
  
  public static int fB(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return 0;
      try
      {
        paramString = aroi.a().getContext().getPackageManager().getPackageArchiveInfo(paramString, 1);
        if (paramString != null)
        {
          int i = paramString.versionCode;
          return i;
        }
      }
      catch (Exception paramString)
      {
        arwt.e("AppUtil", "getApkVersonCodeFromApkFile>>>", paramString);
      }
    }
    return 0;
  }
  
  public static Intent g(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN", null);
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.addFlags(1073741824);
    if (!oO.containsKey(paramString))
    {
      paramContext = paramContext.getPackageManager().queryIntentActivities(localIntent, 0).iterator();
      while (paramContext.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)paramContext.next();
        if (!oO.containsKey(localResolveInfo.activityInfo.applicationInfo.packageName)) {
          oO.put(localResolveInfo.activityInfo.applicationInfo.packageName, localResolveInfo.activityInfo.name);
        }
      }
    }
    paramContext = (String)oO.get(paramString);
    if (paramContext != null)
    {
      localIntent.setComponent(new ComponentName(paramString, paramContext));
      return localIntent;
    }
    return null;
  }
  
  public static String getCurProcessName(Context paramContext)
  {
    try
    {
      int i = android.os.Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i)
        {
          paramContext = localRunningAppProcessInfo.processName;
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      arwt.w("AppUtil", "getCurProcessName err", paramContext);
    }
    return null;
  }
  
  public static boolean installApp(Context paramContext, String paramString)
  {
    return v(paramContext, paramString, "");
  }
  
  /* Error */
  public static String j(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 190	java/lang/ProcessBuilder
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 193	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: iconst_0
    //   11: invokevirtual 197	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   14: pop
    //   15: aload_0
    //   16: invokevirtual 200	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   19: astore_1
    //   20: new 295	java/io/DataOutputStream
    //   23: dup
    //   24: aload_1
    //   25: invokevirtual 301	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   28: invokespecial 304	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore_2
    //   32: new 306	java/io/DataInputStream
    //   35: dup
    //   36: aload_1
    //   37: invokevirtual 309	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   40: invokespecial 312	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_0
    //   44: aload_0
    //   45: ifnull +90 -> 135
    //   48: aload_2
    //   49: ifnull +86 -> 135
    //   52: aload_0
    //   53: invokevirtual 328	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   56: astore_0
    //   57: aload_2
    //   58: ldc_w 322
    //   61: invokevirtual 320	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   64: aload_2
    //   65: invokevirtual 315	java/io/DataOutputStream:flush	()V
    //   68: aload_1
    //   69: invokevirtual 325	java/lang/Process:waitFor	()I
    //   72: pop
    //   73: aload_0
    //   74: astore_2
    //   75: aload_1
    //   76: ifnull +9 -> 85
    //   79: aload_1
    //   80: invokevirtual 669	java/lang/Process:destroy	()V
    //   83: aload_0
    //   84: astore_2
    //   85: aload_2
    //   86: areturn
    //   87: astore_0
    //   88: aconst_null
    //   89: astore_1
    //   90: ldc_w 404
    //   93: astore_0
    //   94: aload_0
    //   95: astore_2
    //   96: aload_1
    //   97: ifnull -12 -> 85
    //   100: aload_1
    //   101: invokevirtual 669	java/lang/Process:destroy	()V
    //   104: aload_0
    //   105: areturn
    //   106: astore_0
    //   107: aconst_null
    //   108: astore_1
    //   109: aload_1
    //   110: ifnull +7 -> 117
    //   113: aload_1
    //   114: invokevirtual 669	java/lang/Process:destroy	()V
    //   117: aload_0
    //   118: athrow
    //   119: astore_0
    //   120: goto -11 -> 109
    //   123: astore_0
    //   124: ldc_w 404
    //   127: astore_0
    //   128: goto -34 -> 94
    //   131: astore_2
    //   132: goto -38 -> 94
    //   135: ldc_w 404
    //   138: astore_0
    //   139: goto -82 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramArrayOfString	String[]
    //   19	95	1	localProcess	java.lang.Process
    //   31	65	2	localObject	Object
    //   131	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	20	87	java/lang/Exception
    //   0	20	106	finally
    //   20	44	119	finally
    //   52	57	119	finally
    //   57	73	119	finally
    //   20	44	123	java/lang/Exception
    //   52	57	123	java/lang/Exception
    //   57	73	131	java/lang/Exception
  }
  
  public static String lh(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = aroi.a().getContext().getPackageManager().getPackageArchiveInfo(paramString, 1);
        if (paramString != null)
        {
          paramString = paramString.applicationInfo.packageName;
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        arwt.e("AppUtil", "getApkName>>>", paramString);
      }
    }
    return null;
  }
  
  public static boolean sr(String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    java.lang.Process localProcess = a();
    if (localProcess == null) {}
    for (;;)
    {
      return bool2;
      try
      {
        DataOutputStream localDataOutputStream = new DataOutputStream(localProcess.getOutputStream());
        Object localObject = new BufferedReader(new InputStreamReader(localProcess.getInputStream(), "UTF-8"));
        boolean bool1 = bool3;
        int i;
        if (localObject != null)
        {
          bool1 = bool3;
          if (localDataOutputStream != null)
          {
            File localFile = new File(paramString);
            String str1 = localFile.getParent();
            String str2 = new File(str1).getParent();
            String str3 = new File(str2).getParent();
            localDataOutputStream.write(("chmod 777 " + localFile.getAbsolutePath() + "\n").getBytes());
            localDataOutputStream.flush();
            localDataOutputStream.writeBytes("chmod 777 " + str1 + "\n");
            localDataOutputStream.flush();
            localDataOutputStream.writeBytes("chmod 777 " + str2 + "\n");
            localDataOutputStream.flush();
            localDataOutputStream.writeBytes("chmod 777 " + str3 + "\n");
            localDataOutputStream.flush();
            localDataOutputStream.write(("LD_LIBRARY_PATH=/vendor/lib:/system/lib pm install -r " + paramString + "\n").getBytes());
            localDataOutputStream.flush();
            localDataOutputStream.close();
            paramString = new char[1024];
            i = ((BufferedReader)localObject).read(paramString);
            localObject = new StringBuilder();
            if (i == -1) {
              break label399;
            }
          }
        }
        for (paramString = ((StringBuilder)localObject).append(paramString, 0, i).toString();; paramString = new String(paramString, 0, localProcess.getErrorStream().read(paramString)))
        {
          bool1 = bool3;
          if (!TextUtils.isEmpty(paramString))
          {
            boolean bool4 = paramString.toLowerCase().contains("success");
            bool1 = bool3;
            if (bool4) {
              bool1 = true;
            }
          }
          bool2 = bool1;
          return bool1;
          label399:
          paramString = new byte[1024];
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return false;
      }
      finally
      {
        if (localProcess != null) {
          localProcess.destroy();
        }
      }
    }
  }
  
  public static List<PackageInfo> u(Context paramContext)
  {
    return null;
  }
  
  public static void v(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramString2);
    paramString1 = localIntent;
    if (localIntent == null)
    {
      paramString1 = new Intent(paramString2);
      paramString1.addCategory("android.intent.category.DEFAULT");
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1.putExtra("appCustom", paramString3);
      arwt.d("add", ">>has add appCustom=" + paramString3);
    }
    paramString1.putExtra("platformId", "qzone_m");
    arwt.d("add", ">>has add platformid=qzone_m");
    try
    {
      if (!(paramContext instanceof Activity)) {
        paramString1.addFlags(268435456);
      }
      paramContext.startActivity(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      Toast.makeText(paramContext, acfp.m(2131702769), 0).show();
    }
  }
  
  public static boolean v(Context paramContext, String paramString1, String paramString2)
  {
    return d(paramContext, paramString1, paramString2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arxn
 * JD-Core Version:    0.7.0.1
 */