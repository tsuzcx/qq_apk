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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.util.Pair;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class shg
{
  public static String TAG = "SubscribeDraftManager";
  private static shg a;
  private String aEd = acbn.bnM;
  private String aEe = ".draft";
  private String alm = acbn.bnL;
  private Handler mThreadHandler;
  
  private shg()
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("SubscribeDraftManager", 0);
    localHandlerThread.start();
    this.mThreadHandler = new Handler(localHandlerThread.getLooper());
  }
  
  private Pair<String, String> a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d(TAG, 4, "generate draft failed UID is empty");
      return null;
    }
    Pair localPair = b(paramString1);
    if (localPair != null)
    {
      QLog.d(TAG, 4, "generate draft id:" + paramString2 + "\n,mUid =" + paramString1 + ", md5 = " + Md5Utils.getMD5(paramString1));
      return new Pair((String)localPair.first + "/" + paramString2 + this.aEe, (String)localPair.second + "/" + paramString2 + this.aEe);
    }
    QLog.d(TAG, 4, "generate draft failed UID ,SDCARD generate folder failed");
    return null;
  }
  
  public static shg a()
  {
    try
    {
      if (a == null) {
        a = new shg();
      }
      shg localshg = a;
      return localshg;
    }
    finally {}
  }
  
  private Pair<String, String> b(String paramString)
  {
    String str = arwv.toMD5(paramString);
    paramString = this.alm + str;
    str = this.aEd + str;
    QLog.d(TAG, 2, "createDraftDirectory currentFolder:" + paramString + " currentSimpleFolder:" + str);
    try
    {
      aqhq.m(paramString);
      aqhq.m(str);
      paramString = new Pair(paramString, str);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private String gB(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      paramString = new BufferedReader(new FileReader(new File(paramString)));
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
  
  /* Error */
  public boolean S(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 164	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 167	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 189	java/io/File:exists	()Z
    //   18: ifne +35 -> 53
    //   21: aload_1
    //   22: invokevirtual 192	java/io/File:createNewFile	()Z
    //   25: pop
    //   26: new 194	java/io/FileWriter
    //   29: dup
    //   30: aload_1
    //   31: iconst_0
    //   32: invokespecial 197	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   35: astore_1
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 200	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   41: aload_1
    //   42: invokevirtual 203	java/io/FileWriter:flush	()V
    //   45: aload_1
    //   46: invokevirtual 204	java/io/FileWriter:close	()V
    //   49: iconst_1
    //   50: istore_3
    //   51: iload_3
    //   52: ireturn
    //   53: aload_1
    //   54: invokevirtual 207	java/io/File:delete	()Z
    //   57: pop
    //   58: aload_1
    //   59: invokevirtual 192	java/io/File:createNewFile	()Z
    //   62: pop
    //   63: goto -37 -> 26
    //   66: astore_1
    //   67: aload 4
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull -20 -> 51
    //   74: aload_1
    //   75: invokevirtual 204	java/io/FileWriter:close	()V
    //   78: iconst_0
    //   79: ireturn
    //   80: astore_1
    //   81: iconst_0
    //   82: ireturn
    //   83: astore_2
    //   84: goto -14 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	shg
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
  
  public void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, shg.a parama)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = aczy.bd(paramActivity);
    }
    if (!bool)
    {
      aqha.b(paramActivity);
      return;
    }
    if ((!TextUtils.isEmpty(paramString1)) || (!TextUtils.isEmpty(paramString2)) || (!TextUtils.isEmpty(paramString3)) || (!TextUtils.isEmpty(paramString4)))
    {
      this.mThreadHandler.post(new SubscribeDraftManager.1(this, paramString1, paramString2, paramString3, paramString4, parama));
      return;
    }
    if (parama != null) {
      parama.b(3, false, paramString2, new Object[0]);
    }
    QLog.d(TAG, 4, "modifyDraft failed because something is empty");
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, shk.c paramc)
  {
    if (paramContext == null) {}
    do
    {
      return;
      paramContext = ausj.b(paramContext);
      paramContext.addButton(paramInt, 3);
      paramContext.addCancelButton(2131721058);
      paramContext.setOnBottomCancelListener(new shh(this, paramc, paramString1, paramContext));
      paramContext.a(new shi(this, paramString1, paramString2, paramc, paramContext));
    } while (paramContext.isShowing());
    paramContext.show();
  }
  
  public void a(String paramString1, String paramString2, shg.a parama)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.d(TAG, 4, "deletDraft failed because uin or draftID is empty");
      return;
    }
    this.mThreadHandler.post(new SubscribeDraftManager.4(this, paramString1, paramString2, parama));
  }
  
  public void a(String paramString, shg.a parama)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d(TAG, 4, "qureyAllSimpleDraft failed because uin is empty");
      return;
    }
    this.mThreadHandler.post(new SubscribeDraftManager.2(this, paramString, parama));
  }
  
  public void b(String paramString1, String paramString2, shg.a parama)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.d(TAG, 4, "deletDraft failed because uin or draftID is empty");
      return;
    }
    this.mThreadHandler.post(new SubscribeDraftManager.5(this, paramString1, paramString2, parama));
  }
  
  public boolean fV(String paramString)
  {
    paramString = b(paramString);
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
  
  public static abstract interface a
  {
    public abstract void b(int paramInt, boolean paramBoolean, String paramString, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     shg
 * JD-Core Version:    0.7.0.1
 */