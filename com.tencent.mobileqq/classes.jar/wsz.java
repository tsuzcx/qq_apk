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
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mm.vfs.VFSFileReader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.util.Pair;
import java.io.BufferedReader;

public class wsz
{
  public static String a;
  private static wsz jdField_a_of_type_Wsz;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private String b = ajsf.cU;
  private String c = ajsf.cV;
  private String d = ".draft";
  
  static
  {
    jdField_a_of_type_JavaLangString = "SubscribeDraftManager";
  }
  
  private wsz()
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("SubscribeDraftManager", 0);
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
  }
  
  private Pair<String, String> a(String paramString)
  {
    String str = bdhv.d(paramString);
    paramString = this.b + str;
    str = this.c + str;
    QLog.d(jdField_a_of_type_JavaLangString, 2, "createDraftDirectory currentFolder:" + paramString + " currentSimpleFolder:" + str);
    try
    {
      bbdj.a(paramString);
      bbdj.a(str);
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
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      paramString = new BufferedReader(new VFSFileReader(new VFSFile(paramString)));
      for (;;)
      {
        String str = paramString.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      return localStringBuilder.toString();
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    for (;;)
    {
      paramString.close();
    }
  }
  
  public static wsz a()
  {
    try
    {
      if (jdField_a_of_type_Wsz == null) {
        jdField_a_of_type_Wsz = new wsz();
      }
      wsz localwsz = jdField_a_of_type_Wsz;
      return localwsz;
    }
    finally {}
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, wtd paramwtd)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = akwg.a(paramActivity);
    }
    if (!bool)
    {
      bbcv.b(paramActivity);
      return;
    }
    if ((!TextUtils.isEmpty(paramString1)) || (!TextUtils.isEmpty(paramString2)) || (!TextUtils.isEmpty(paramString3)) || (!TextUtils.isEmpty(paramString4)))
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeDraftManager.1(this, paramString1, paramString2, paramString3, paramString4, paramwtd));
      return;
    }
    if (paramwtd != null) {
      paramwtd.a(3, false, paramString2, new Object[0]);
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "modifyDraft failed because something is empty");
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, wtk paramwtk)
  {
    if (paramContext == null) {}
    do
    {
      return;
      paramContext = bfol.a(paramContext);
      paramContext.a(paramInt, 3);
      paramContext.c(2131690596);
      paramContext.a(new wta(this, paramwtk, paramString1, paramContext));
      paramContext.a(new wtb(this, paramString1, paramString2, paramwtk, paramContext));
    } while (paramContext.isShowing());
    paramContext.show();
  }
  
  public void a(String paramString1, String paramString2, wtd paramwtd)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "deletDraft failed because uin or draftID is empty");
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeDraftManager.4(this, paramString1, paramString2, paramwtd));
  }
  
  public void a(String paramString, wtd paramwtd)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "qureyAllSimpleDraft failed because uin is empty");
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeDraftManager.2(this, paramString, paramwtd));
  }
  
  public boolean a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      paramString = new VFSFile((String)paramString.second);
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
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 5
    //   8: astore_3
    //   9: new 147	com/tencent/mm/vfs/VFSFile
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 150	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   17: astore_1
    //   18: aload 5
    //   20: astore_3
    //   21: aload_1
    //   22: invokevirtual 259	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   25: ifne +11 -> 36
    //   28: aload 5
    //   30: astore_3
    //   31: aload_1
    //   32: invokevirtual 272	com/tencent/mm/vfs/VFSFile:createNewFile	()Z
    //   35: pop
    //   36: aload 5
    //   38: astore_3
    //   39: new 274	com/tencent/mm/vfs/VFSFileOutputStream
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 275	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   47: astore_1
    //   48: aload_1
    //   49: aload_2
    //   50: invokevirtual 279	java/lang/String:getBytes	()[B
    //   53: invokevirtual 283	com/tencent/mm/vfs/VFSFileOutputStream:write	([B)V
    //   56: aload_1
    //   57: ifnull +7 -> 64
    //   60: aload_1
    //   61: invokevirtual 284	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   64: iconst_1
    //   65: ireturn
    //   66: astore_1
    //   67: aload_1
    //   68: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   71: iconst_1
    //   72: ireturn
    //   73: astore_2
    //   74: aload 4
    //   76: astore_1
    //   77: aload_1
    //   78: astore_3
    //   79: getstatic 17	wsz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   82: iconst_1
    //   83: ldc_w 287
    //   86: aload_2
    //   87: invokestatic 290	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   90: aload_1
    //   91: ifnull +7 -> 98
    //   94: aload_1
    //   95: invokevirtual 284	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   98: iconst_0
    //   99: ireturn
    //   100: astore_1
    //   101: aload_1
    //   102: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   105: goto -7 -> 98
    //   108: astore_1
    //   109: aload_3
    //   110: ifnull +7 -> 117
    //   113: aload_3
    //   114: invokevirtual 284	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   117: aload_1
    //   118: athrow
    //   119: astore_2
    //   120: aload_2
    //   121: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   124: goto -7 -> 117
    //   127: astore_2
    //   128: aload_1
    //   129: astore_3
    //   130: aload_2
    //   131: astore_1
    //   132: goto -23 -> 109
    //   135: astore_2
    //   136: goto -59 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	wsz
    //   0	139	1	paramString1	String
    //   0	139	2	paramString2	String
    //   8	122	3	localObject1	Object
    //   4	71	4	localObject2	Object
    //   1	36	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   60	64	66	java/io/IOException
    //   9	18	73	java/lang/Exception
    //   21	28	73	java/lang/Exception
    //   31	36	73	java/lang/Exception
    //   39	48	73	java/lang/Exception
    //   94	98	100	java/io/IOException
    //   9	18	108	finally
    //   21	28	108	finally
    //   31	36	108	finally
    //   39	48	108	finally
    //   79	90	108	finally
    //   113	117	119	java/io/IOException
    //   48	56	127	finally
    //   48	56	135	java/lang/Exception
  }
  
  public void b(String paramString1, String paramString2, wtd paramwtd)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "deletDraft failed because uin or draftID is empty");
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeDraftManager.5(this, paramString1, paramString2, paramwtd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wsz
 * JD-Core Version:    0.7.0.1
 */