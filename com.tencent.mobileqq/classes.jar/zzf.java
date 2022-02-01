import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.biz.subscribe.utils.SubscribeDraftManager.1;
import com.tencent.biz.subscribe.utils.SubscribeDraftManager.2;
import com.tencent.biz.subscribe.utils.SubscribeDraftManager.4;
import com.tencent.biz.subscribe.utils.SubscribeDraftManager.5;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.util.Pair;
import java.io.File;

public class zzf
{
  public static String a;
  private static zzf jdField_a_of_type_Zzf;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private String b = AppConstants.SUBSCRIBE_DRAFT;
  private String c = AppConstants.SUBSCRIBE_DRAFT_SIMPLE;
  private String d = ".draft";
  
  static
  {
    jdField_a_of_type_JavaLangString = "SubscribeDraftManager";
  }
  
  private zzf()
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("SubscribeDraftManager", 0);
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
  }
  
  private Pair<String, String> a(String paramString)
  {
    String str = MD5Utils.toMD5(paramString);
    paramString = this.b + str;
    str = this.c + str;
    QLog.d(jdField_a_of_type_JavaLangString, 2, "createDraftDirectory currentFolder:" + paramString + " currentSimpleFolder:" + str);
    try
    {
      FileUtils.createDirectory(paramString);
      FileUtils.createDirectory(str);
      paramString = new Pair(paramString, str);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private Pair<String, String> a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "generate draft failed UID is empty");
      return null;
    }
    Pair localPair = a(paramString1);
    if (localPair != null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "generate draft id:" + paramString2 + "\n,mUid =" + paramString1 + ", md5 = " + Md5Utils.getMD5(paramString1));
      return new Pair((String)localPair.first + "/" + paramString2 + this.d, (String)localPair.second + "/" + paramString2 + this.d);
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "generate draft failed UID ,SDCARD generate folder failed");
    return null;
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: new 70	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_3
    //   11: new 145	java/io/BufferedReader
    //   14: dup
    //   15: new 147	java/io/FileReader
    //   18: dup
    //   19: new 149	java/io/File
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 152	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: invokespecial 155	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   30: invokespecial 158	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   33: astore_2
    //   34: aload_2
    //   35: astore_1
    //   36: aload_2
    //   37: invokevirtual 161	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore_3
    //   41: aload_3
    //   42: ifnull +36 -> 78
    //   45: aload_2
    //   46: astore_1
    //   47: aload 4
    //   49: aload_3
    //   50: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: goto -20 -> 34
    //   57: astore_3
    //   58: aload_2
    //   59: astore_1
    //   60: aload_3
    //   61: invokevirtual 102	java/lang/Exception:printStackTrace	()V
    //   64: aload_2
    //   65: ifnull +7 -> 72
    //   68: aload_2
    //   69: invokevirtual 164	java/io/BufferedReader:close	()V
    //   72: aload 4
    //   74: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: areturn
    //   78: aload_2
    //   79: ifnull -7 -> 72
    //   82: aload_2
    //   83: invokevirtual 164	java/io/BufferedReader:close	()V
    //   86: goto -14 -> 72
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 102	java/lang/Exception:printStackTrace	()V
    //   94: goto -22 -> 72
    //   97: astore_1
    //   98: aload_1
    //   99: invokevirtual 102	java/lang/Exception:printStackTrace	()V
    //   102: goto -30 -> 72
    //   105: astore_1
    //   106: aload_3
    //   107: astore_2
    //   108: aload_2
    //   109: ifnull +7 -> 116
    //   112: aload_2
    //   113: invokevirtual 164	java/io/BufferedReader:close	()V
    //   116: aload_1
    //   117: athrow
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 102	java/lang/Exception:printStackTrace	()V
    //   123: goto -7 -> 116
    //   126: astore_3
    //   127: aload_1
    //   128: astore_2
    //   129: aload_3
    //   130: astore_1
    //   131: goto -23 -> 108
    //   134: astore_3
    //   135: aconst_null
    //   136: astore_2
    //   137: goto -79 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	zzf
    //   0	140	1	paramString	String
    //   33	80	2	localObject1	Object
    //   118	2	2	localException1	Exception
    //   128	9	2	str1	String
    //   10	40	3	str2	String
    //   57	50	3	localException2	Exception
    //   126	4	3	localObject2	Object
    //   134	1	3	localException3	Exception
    //   7	66	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   36	41	57	java/lang/Exception
    //   47	54	57	java/lang/Exception
    //   82	86	89	java/lang/Exception
    //   68	72	97	java/lang/Exception
    //   11	34	105	finally
    //   112	116	118	java/lang/Exception
    //   36	41	126	finally
    //   47	54	126	finally
    //   60	64	126	finally
    //   11	34	134	java/lang/Exception
  }
  
  public static zzf a()
  {
    try
    {
      if (jdField_a_of_type_Zzf == null) {
        jdField_a_of_type_Zzf = new zzf();
      }
      zzf localzzf = jdField_a_of_type_Zzf;
      return localzzf;
    }
    finally {}
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, zzj paramzzj)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = PermissionUtils.isStorePermissionEnable(paramActivity);
    }
    if (!bool)
    {
      bhdj.a(paramActivity);
      return;
    }
    if ((!TextUtils.isEmpty(paramString1)) || (!TextUtils.isEmpty(paramString2)) || (!TextUtils.isEmpty(paramString3)) || (!TextUtils.isEmpty(paramString4)))
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeDraftManager.1(this, paramString1, paramString2, paramString3, paramString4, paramzzj));
      return;
    }
    if (paramzzj != null) {
      paramzzj.a(3, false, paramString2, new Object[0]);
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "modifyDraft failed because something is empty");
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, zzq paramzzq)
  {
    if (paramContext == null) {}
    do
    {
      return;
      paramContext = bkzi.a(paramContext);
      paramContext.a(paramInt, 3);
      paramContext.c(2131690697);
      paramContext.a(new zzg(this, paramzzq, paramString1, paramContext));
      paramContext.a(new zzh(this, paramString1, paramString2, paramzzq, paramContext));
    } while (paramContext.isShowing());
    paramContext.show();
  }
  
  public void a(String paramString1, String paramString2, zzj paramzzj)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "deletDraft failed because uin or draftID is empty");
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeDraftManager.4(this, paramString1, paramString2, paramzzj));
  }
  
  public void a(String paramString, zzj paramzzj)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "qureyAllSimpleDraft failed because uin is empty");
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeDraftManager.2(this, paramString, paramzzj));
  }
  
  public boolean a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      paramString = new File((String)paramString.second);
      if ((paramString.exists()) && (paramString.isDirectory()))
      {
        paramString = paramString.listFiles();
        return (paramString != null) && (paramString.length > 0);
      }
    }
    return false;
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 149	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 152	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 262	java/io/File:exists	()Z
    //   18: ifne +35 -> 53
    //   21: aload_1
    //   22: invokevirtual 277	java/io/File:createNewFile	()Z
    //   25: pop
    //   26: new 279	java/io/FileWriter
    //   29: dup
    //   30: aload_1
    //   31: iconst_0
    //   32: invokespecial 282	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   35: astore_1
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 285	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   41: aload_1
    //   42: invokevirtual 288	java/io/FileWriter:flush	()V
    //   45: aload_1
    //   46: invokevirtual 289	java/io/FileWriter:close	()V
    //   49: iconst_1
    //   50: istore_3
    //   51: iload_3
    //   52: ireturn
    //   53: aload_1
    //   54: invokevirtual 292	java/io/File:delete	()Z
    //   57: pop
    //   58: aload_1
    //   59: invokevirtual 277	java/io/File:createNewFile	()Z
    //   62: pop
    //   63: goto -37 -> 26
    //   66: astore_1
    //   67: aload 4
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull -20 -> 51
    //   74: aload_1
    //   75: invokevirtual 289	java/io/FileWriter:close	()V
    //   78: iconst_0
    //   79: ireturn
    //   80: astore_1
    //   81: iconst_0
    //   82: ireturn
    //   83: astore_2
    //   84: goto -14 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	zzf
    //   0	87	1	paramString1	String
    //   0	87	2	paramString2	String
    //   1	51	3	bool	boolean
    //   3	65	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	26	66	java/lang/Throwable
    //   26	36	66	java/lang/Throwable
    //   53	63	66	java/lang/Throwable
    //   74	78	80	java/io/IOException
    //   36	49	83	java/lang/Throwable
  }
  
  public void b(String paramString1, String paramString2, zzj paramzzj)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "deletDraft failed because uin or draftID is empty");
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeDraftManager.5(this, paramString1, paramString2, paramzzj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzf
 * JD-Core Version:    0.7.0.1
 */