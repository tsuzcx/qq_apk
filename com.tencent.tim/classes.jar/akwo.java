import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.phonecontact.PermissionPageUtil.1;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class akwo
{
  private static String bUz;
  private Context mContext;
  private String mPackageName;
  
  public akwo(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.mPackageName = paramString;
    ThreadManager.excute(new PermissionPageUtil.1(this), 16, null, true);
    log(String.format("PermissionPageUtil [%s]", new Object[] { paramString }));
  }
  
  private void NN(String paramString)
  {
    Object localObject;
    try
    {
      paramString = this.mContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramString == null)
      {
        dDE();
        return;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
      localObject = new Intent("android.intent.action.MAIN", null);
      ((Intent)localObject).addCategory("android.intent.category.LAUNCHER");
      ((Intent)localObject).setPackage(paramString.packageName);
      paramString = this.mContext.getPackageManager().queryIntentActivities((Intent)localObject, 0);
      if (paramString == null) {
        break label158;
      }
    }
    if (paramString.size() > 0) {}
    label158:
    for (paramString = (ResolveInfo)paramString.get(0);; paramString = null)
    {
      if (paramString != null)
      {
        localObject = paramString.activityInfo.packageName;
        paramString = paramString.activityInfo.name;
        Intent localIntent = new Intent("android.intent.action.MAIN");
        localIntent.addCategory("android.intent.category.LAUNCHER");
        localIntent.setComponent(new ComponentName((String)localObject, paramString));
        startActivity(localIntent);
        return;
      }
      dDE();
      return;
    }
  }
  
  private void dDE()
  {
    log("goIntentSetting");
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(Uri.fromParts("package", this.mContext.getPackageName(), null));
    if ((this.mContext instanceof Activity))
    {
      ((Activity)this.mContext).startActivityForResult(localIntent, 99999);
      return;
    }
    this.mContext.startActivity(localIntent);
  }
  
  private void dDF()
  {
    Intent localIntent = new Intent(this.mPackageName);
    localIntent.setFlags(268435456);
    localIntent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
    startActivity(localIntent);
  }
  
  private void dDG()
  {
    Object localObject = xM();
    if (("V6".equals(localObject)) || ("V7".equals(localObject)))
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("miui.intent.action.APP_PERM_EDITOR");
      ((Intent)localObject).setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
      ((Intent)localObject).putExtra("extra_pkgname", this.mPackageName);
      startActivity((Intent)localObject);
      return;
    }
    if (("V8".equals(localObject)) || ("V9".equals(localObject)))
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("miui.intent.action.APP_PERM_EDITOR");
      ((Intent)localObject).setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
      ((Intent)localObject).putExtra("extra_pkgname", this.mPackageName);
      startActivity((Intent)localObject);
      return;
    }
    dDE();
  }
  
  public static void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PermissionPageUtil", 2, paramString);
    }
  }
  
  /* Error */
  public static String xM()
  {
    // Byte code:
    //   0: getstatic 216	akwo:bUz	Ljava/lang/String;
    //   3: ifnull +7 -> 10
    //   6: getstatic 216	akwo:bUz	Ljava/lang/String;
    //   9: areturn
    //   10: aconst_null
    //   11: astore_0
    //   12: new 218	java/io/BufferedReader
    //   15: dup
    //   16: new 220	java/io/InputStreamReader
    //   19: dup
    //   20: invokestatic 226	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   23: new 228	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   30: ldc 231
    //   32: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 237
    //   37: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokevirtual 244	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   46: invokevirtual 250	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   49: invokespecial 253	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   52: sipush 1024
    //   55: invokespecial 256	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   58: astore_1
    //   59: aload_1
    //   60: astore_0
    //   61: aload_1
    //   62: invokevirtual 259	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   65: putstatic 216	akwo:bUz	Ljava/lang/String;
    //   68: aload_1
    //   69: astore_0
    //   70: aload_1
    //   71: invokevirtual 262	java/io/BufferedReader:close	()V
    //   74: aload_1
    //   75: ifnull +7 -> 82
    //   78: aload_1
    //   79: invokevirtual 262	java/io/BufferedReader:close	()V
    //   82: getstatic 216	akwo:bUz	Ljava/lang/String;
    //   85: ifnonnull +9 -> 94
    //   88: ldc_w 264
    //   91: putstatic 216	akwo:bUz	Ljava/lang/String;
    //   94: ldc_w 266
    //   97: iconst_1
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: getstatic 216	akwo:bUz	Ljava/lang/String;
    //   106: aastore
    //   107: invokestatic 37	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   110: invokestatic 41	akwo:log	(Ljava/lang/String;)V
    //   113: getstatic 216	akwo:bUz	Ljava/lang/String;
    //   116: areturn
    //   117: astore_0
    //   118: aload_0
    //   119: invokevirtual 267	java/lang/Throwable:printStackTrace	()V
    //   122: goto -40 -> 82
    //   125: astore_2
    //   126: aconst_null
    //   127: astore_1
    //   128: aload_1
    //   129: astore_0
    //   130: aload_2
    //   131: invokevirtual 267	java/lang/Throwable:printStackTrace	()V
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 262	java/io/BufferedReader:close	()V
    //   142: getstatic 216	akwo:bUz	Ljava/lang/String;
    //   145: ifnonnull -51 -> 94
    //   148: ldc_w 264
    //   151: putstatic 216	akwo:bUz	Ljava/lang/String;
    //   154: goto -60 -> 94
    //   157: astore_0
    //   158: aload_0
    //   159: invokevirtual 267	java/lang/Throwable:printStackTrace	()V
    //   162: goto -20 -> 142
    //   165: astore_2
    //   166: aload_0
    //   167: astore_1
    //   168: aload_2
    //   169: astore_0
    //   170: aload_1
    //   171: ifnull +7 -> 178
    //   174: aload_1
    //   175: invokevirtual 262	java/io/BufferedReader:close	()V
    //   178: getstatic 216	akwo:bUz	Ljava/lang/String;
    //   181: ifnonnull +9 -> 190
    //   184: ldc_w 264
    //   187: putstatic 216	akwo:bUz	Ljava/lang/String;
    //   190: aload_0
    //   191: athrow
    //   192: astore_1
    //   193: aload_1
    //   194: invokevirtual 267	java/lang/Throwable:printStackTrace	()V
    //   197: goto -19 -> 178
    //   200: astore_2
    //   201: aload_0
    //   202: astore_1
    //   203: aload_2
    //   204: astore_0
    //   205: goto -35 -> 170
    //   208: astore_2
    //   209: goto -81 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   11	59	0	localObject1	Object
    //   117	2	0	localThrowable1	Throwable
    //   129	1	0	localObject2	Object
    //   157	10	0	localThrowable2	Throwable
    //   169	36	0	localObject3	Object
    //   58	117	1	localObject4	Object
    //   192	2	1	localThrowable3	Throwable
    //   202	1	1	localObject5	Object
    //   125	6	2	localThrowable4	Throwable
    //   165	4	2	localObject6	Object
    //   200	4	2	localObject7	Object
    //   208	1	2	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   78	82	117	java/lang/Throwable
    //   12	59	125	java/lang/Throwable
    //   138	142	157	java/lang/Throwable
    //   12	59	165	finally
    //   174	178	192	java/lang/Throwable
    //   61	68	200	finally
    //   70	74	200	finally
    //   130	134	200	finally
    //   61	68	208	java/lang/Throwable
    //   70	74	208	java/lang/Throwable
  }
  
  public void dDC()
  {
    log(String.format("jumpPermissionPage [brand: %s, model: %s, manufacture: %s]", new Object[] { Build.BRAND, Build.MODEL, Build.MANUFACTURER }));
    String str = Build.MANUFACTURER;
    if ("HUAWEI".equals(str))
    {
      dDF();
      return;
    }
    if ("vivo".equals(str))
    {
      NN("com.bairenkeji.icaller");
      return;
    }
    if ("OPPO".equals(str))
    {
      NN("com.coloros.safecenter");
      return;
    }
    if ("Xiaomi".equals(str))
    {
      dDG();
      return;
    }
    dDE();
  }
  
  public void dDD()
  {
    Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", "https://kf.qq.com/touch/faq/120307IVnEni150407eEv2IF.html?platform=14&_wv=0");
    if ((this.mContext instanceof Activity)) {
      ((Activity)this.mContext).startActivityForResult(localIntent, 99999);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PermissionPageUtil", 2, "openDefaultGuide");
      }
      return;
      this.mContext.startActivity(localIntent);
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    try
    {
      if ((this.mContext instanceof Activity))
      {
        ((Activity)this.mContext).startActivityForResult(paramIntent, 99999);
        return;
      }
      this.mContext.startActivity(paramIntent);
      return;
    }
    catch (Throwable paramIntent)
    {
      paramIntent.printStackTrace();
      log(String.format("doStartApplicationWithPackageName [%s]", new Object[] { paramIntent.getMessage() }));
      dDE();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akwo
 * JD-Core Version:    0.7.0.1
 */