import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.utils.ApolloGameRscVerify.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class abya
{
  public long OT;
  private abya.a a;
  private String awu;
  private AtomicBoolean ax = new AtomicBoolean(false);
  private String bjW;
  private JSONObject bq;
  public int ctB;
  private int ctC;
  private AtomicBoolean cw = new AtomicBoolean(false);
  private int mGameId;
  private SharedPreferences mPref;
  private int mRet = 0;
  
  public abya(int paramInt)
  {
    this(paramInt, 0, "", "");
  }
  
  public abya(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.awu = paramString1;
    this.ctC = paramInt2;
    this.bjW = paramString2;
    this.ctB = 0;
    this.OT = 0L;
    this.mGameId = paramInt1;
    this.mPref = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 4);
  }
  
  private boolean Zo()
  {
    for (;;)
    {
      try
      {
        if (!aE(this.mGameId, this.ctC))
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.ApolloGameRscVerify", 2, "Verifying switch is off in debug mode.");
          }
          this.cw.set(false);
          if (this.a == null) {
            break;
          }
          this.a.HM(0);
          return false;
        }
        new ApolloGameData().gameId = this.mGameId;
        File localFile = new File(getRootPath(), rs());
        if (!localFile.exists())
        {
          QLog.w("cmgame_process.ApolloGameRscVerify", 1, "game checklist NOT exist, gameId:" + this.mGameId);
          jdMethod_do("checkList", 2);
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.ApolloGameRscVerify", 1, "[ApolloGameRscVerify], errInfo->", localThrowable);
        return true;
      }
      if (((this.ctC == 0) || (this.ctC == 1)) && (!new abzb(getRootPath() + "/checkList.sig", localThrowable.getAbsolutePath()).il(0)))
      {
        jdMethod_do("checkList.sig", 3);
        return false;
      }
      this.bq = new JSONObject(aqhq.readFileToString(localThrowable));
      this.ax.set(true);
    }
    return false;
  }
  
  public static boolean c(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    try
    {
      if (abkj.hN(paramInt))
      {
        paramBoolean = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 4).getBoolean("game_whitelist_verify_switch", true);
        QLog.i("cmgame_process.ApolloGameRscVerify", 1, "game_rsc_verify_switch:" + paramBoolean);
        return paramBoolean;
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.ApolloGameRscVerify", 1, localThrowable, new Object[0]);
    }
    return true;
  }
  
  private void jdMethod_do(String paramString, int paramInt)
  {
    QLog.w("cmgame_process.ApolloGameRscVerify", 1, "gameId:" + this.mGameId + ",failType:" + paramInt + ",fileName:" + paramString);
    if ((this.mPref == null) || (this.cw == null)) {
      QLog.e("cmgame_process.ApolloGameRscVerify", 1, "[onVerifyFailure] fails, param is wrong");
    }
    do
    {
      return;
      this.mRet = paramInt;
      if (this.a != null) {
        this.a.HM(paramInt);
      }
    } while ((this.ctC == 3) || (this.ctC == 4));
    this.mPref.edit().putBoolean("apollo_sp_game_rsc_verify_" + getItemId(), true).commit();
    this.cw.set(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("gameId", Integer.toString(this.mGameId));
    localHashMap.put("rscPath", paramString);
    localHashMap.put("errType", Integer.toString(paramInt));
    paramString = getSelfUin();
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramString, "cmshow_game_rsc_error", true, -1L, -1L, localHashMap, "", true);
  }
  
  private String getRootPath()
  {
    StringBuilder localStringBuilder = new StringBuilder(500);
    if (this.ctC == 0) {
      localStringBuilder.append(abxi.biF).append(this.mGameId);
    }
    do
    {
      for (;;)
      {
        return localStringBuilder.toString();
        if (this.ctC != 1) {
          break;
        }
        localStringBuilder.append(abxi.biF).append(this.mGameId).append("/").append(this.bjW);
      }
    } while ((this.ctC != 3) && (this.ctC != 4));
    return aurl.jg();
  }
  
  public static boolean ia(int paramInt)
  {
    try
    {
      Object localObject = abmt.a(paramInt);
      if (localObject == null)
      {
        QLog.w("cmgame_process.ApolloGameRscVerify", 1, "[isNeedVerify], launcher is null.");
        return false;
      }
      CmGameInitParams localCmGameInitParams = ((abos)localObject).c();
      if (localCmGameInitParams != null) {
        return c(localCmGameInitParams.isWhiteUsr, paramInt);
      }
      localObject = ((abos)localObject).a();
      if (localObject != null)
      {
        QLog.w("cmgame_process.ApolloGameRscVerify", 1, "[isNeedVerify], initParams is null use startCheckParam check");
        return c(((CmGameStartChecker.StartCheckParam)localObject).isWhiteUsr, paramInt);
      }
      QLog.w("cmgame_process.ApolloGameRscVerify", 1, "[isNeedVerify], initParams and startCheckParam is null.");
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.ApolloGameRscVerify", 1, localThrowable, new Object[0]);
    }
    return true;
  }
  
  private String rs()
  {
    if (this.ctC == 4) {
      return "checkList_jsc";
    }
    return "checkList";
  }
  
  public boolean Zp()
  {
    try
    {
      long l = System.currentTimeMillis();
      if (!aE(this.mGameId, this.ctC))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.ApolloGameRscVerify", 2, "Verifying switch is off in debug mode.");
        }
        this.cw.set(false);
        if (this.a != null) {
          this.a.HM(0);
        }
      }
      else
      {
        if (!Zo()) {
          return false;
        }
        if (this.bq == null) {
          return false;
        }
        Iterator localIterator = this.bq.keys();
        StringBuilder localStringBuilder = new StringBuilder(200);
        while (localIterator.hasNext())
        {
          this.ctB += 1;
          String str = (String)localIterator.next();
          localStringBuilder.delete(0, localStringBuilder.length());
          localStringBuilder.append(getRootPath());
          localStringBuilder.append("/").append(str);
          if (!as(localStringBuilder.toString(), str)) {
            return false;
          }
        }
        this.OT = (System.currentTimeMillis() - l);
        if (this.a != null) {
          this.a.HM(0);
        }
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.ApolloGameRscVerify", 1, localThrowable, new Object[0]);
      return false;
    }
    return true;
  }
  
  public boolean Zq()
  {
    return Zo();
  }
  
  public void a(abya.a parama)
  {
    this.a = parama;
  }
  
  public boolean aE(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 4) || (paramInt2 == 3)) {
      return true;
    }
    return ia(paramInt1);
  }
  
  /* Error */
  public boolean as(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	abya:ax	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 365	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: ifeq +41 -> 48
    //   10: aload_0
    //   11: getfield 180	abya:bq	Lorg/json/JSONObject;
    //   14: ifnull +34 -> 48
    //   17: aload_2
    //   18: invokestatic 371	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +27 -> 48
    //   24: aload_1
    //   25: invokestatic 371	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +20 -> 48
    //   31: aload_0
    //   32: getfield 45	abya:cw	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   35: ifnull +13 -> 48
    //   38: aload_0
    //   39: getfield 45	abya:cw	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   42: invokevirtual 365	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   45: ifeq +5 -> 50
    //   48: iconst_0
    //   49: ireturn
    //   50: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   53: pop2
    //   54: aconst_null
    //   55: astore 4
    //   57: aconst_null
    //   58: astore 5
    //   60: new 110	java/io/File
    //   63: dup
    //   64: aload_1
    //   65: invokespecial 372	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore 7
    //   70: aload 4
    //   72: astore_3
    //   73: aload 7
    //   75: invokevirtual 123	java/io/File:exists	()Z
    //   78: ifne +37 -> 115
    //   81: aload 4
    //   83: astore_3
    //   84: aload_0
    //   85: aload_2
    //   86: iconst_1
    //   87: invokespecial 147	abya:do	(Ljava/lang/String;I)V
    //   90: iconst_0
    //   91: ifeq -43 -> 48
    //   94: new 374	java/lang/NullPointerException
    //   97: dup
    //   98: invokespecial 375	java/lang/NullPointerException:<init>	()V
    //   101: athrow
    //   102: astore_1
    //   103: ldc 88
    //   105: iconst_1
    //   106: ldc_w 377
    //   109: aload_1
    //   110: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: iconst_0
    //   114: ireturn
    //   115: aload 4
    //   117: astore_3
    //   118: aload_0
    //   119: getfield 180	abya:bq	Lorg/json/JSONObject;
    //   122: aload_2
    //   123: invokevirtual 381	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   126: astore 6
    //   128: aload 4
    //   130: astore_3
    //   131: new 383	java/io/FileInputStream
    //   134: dup
    //   135: aload_1
    //   136: invokespecial 384	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   139: astore 4
    //   141: aload 4
    //   143: aload 7
    //   145: invokevirtual 386	java/io/File:length	()J
    //   148: invokestatic 392	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   151: invokestatic 398	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   154: astore_3
    //   155: aload_3
    //   156: invokestatic 371	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   159: ifne +57 -> 216
    //   162: aload 6
    //   164: invokestatic 371	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   167: ifne +49 -> 216
    //   170: aload_3
    //   171: invokevirtual 401	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   174: aload 6
    //   176: invokevirtual 401	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   179: invokevirtual 405	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   182: ifne +34 -> 216
    //   185: aload_0
    //   186: aload_2
    //   187: iconst_4
    //   188: invokespecial 147	abya:do	(Ljava/lang/String;I)V
    //   191: aload 4
    //   193: ifnull -145 -> 48
    //   196: aload 4
    //   198: invokevirtual 408	java/io/FileInputStream:close	()V
    //   201: iconst_0
    //   202: ireturn
    //   203: astore_1
    //   204: ldc 88
    //   206: iconst_1
    //   207: ldc_w 377
    //   210: aload_1
    //   211: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   214: iconst_0
    //   215: ireturn
    //   216: aload 4
    //   218: ifnull +8 -> 226
    //   221: aload 4
    //   223: invokevirtual 408	java/io/FileInputStream:close	()V
    //   226: iconst_1
    //   227: ireturn
    //   228: astore_1
    //   229: ldc 88
    //   231: iconst_1
    //   232: ldc_w 377
    //   235: aload_1
    //   236: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   239: goto -13 -> 226
    //   242: astore_3
    //   243: aload 5
    //   245: astore 4
    //   247: aload_3
    //   248: astore 5
    //   250: aload 4
    //   252: astore_3
    //   253: ldc 88
    //   255: iconst_1
    //   256: bipush 6
    //   258: anewarray 4	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: ldc_w 410
    //   266: aastore
    //   267: dup
    //   268: iconst_1
    //   269: aload 5
    //   271: aastore
    //   272: dup
    //   273: iconst_2
    //   274: ldc_w 412
    //   277: aastore
    //   278: dup
    //   279: iconst_3
    //   280: aload_1
    //   281: aastore
    //   282: dup
    //   283: iconst_4
    //   284: ldc_w 414
    //   287: aastore
    //   288: dup
    //   289: iconst_5
    //   290: aload_2
    //   291: aastore
    //   292: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   295: aload 4
    //   297: ifnull -71 -> 226
    //   300: aload 4
    //   302: invokevirtual 408	java/io/FileInputStream:close	()V
    //   305: goto -79 -> 226
    //   308: astore_1
    //   309: ldc 88
    //   311: iconst_1
    //   312: ldc_w 377
    //   315: aload_1
    //   316: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   319: goto -93 -> 226
    //   322: astore_1
    //   323: aload_3
    //   324: ifnull +7 -> 331
    //   327: aload_3
    //   328: invokevirtual 408	java/io/FileInputStream:close	()V
    //   331: aload_1
    //   332: athrow
    //   333: astore_2
    //   334: ldc 88
    //   336: iconst_1
    //   337: ldc_w 377
    //   340: aload_2
    //   341: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   344: goto -13 -> 331
    //   347: astore_1
    //   348: aload 4
    //   350: astore_3
    //   351: goto -28 -> 323
    //   354: astore 5
    //   356: goto -106 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	abya
    //   0	359	1	paramString1	String
    //   0	359	2	paramString2	String
    //   72	99	3	localObject1	Object
    //   242	6	3	localThrowable1	Throwable
    //   252	99	3	localObject2	Object
    //   55	294	4	localObject3	Object
    //   58	212	5	localObject4	Object
    //   354	1	5	localThrowable2	Throwable
    //   126	49	6	str	String
    //   68	76	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   94	102	102	java/io/IOException
    //   196	201	203	java/io/IOException
    //   221	226	228	java/io/IOException
    //   73	81	242	java/lang/Throwable
    //   84	90	242	java/lang/Throwable
    //   118	128	242	java/lang/Throwable
    //   131	141	242	java/lang/Throwable
    //   300	305	308	java/io/IOException
    //   73	81	322	finally
    //   84	90	322	finally
    //   118	128	322	finally
    //   131	141	322	finally
    //   253	295	322	finally
    //   327	331	333	java/io/IOException
    //   141	191	347	finally
    //   141	191	354	java/lang/Throwable
  }
  
  public void cGh()
  {
    ThreadManager.post(new ApolloGameRscVerify.1(this), 5, null, true);
  }
  
  public void cGi()
  {
    if (this.ctB == 0)
    {
      QLog.w("cmgame_process.ApolloGameRscVerify", 1, "mTotalFiles is 0.");
      return;
    }
    Object localObject = new StringBuilder(200);
    float f = 1.0F * (float)this.OT / this.ctB;
    ((StringBuilder)localObject).append("gameId:").append(this.mGameId).append(",totalCost:").append(this.OT).append(",totalFiles:").append(this.ctB).append(",avgCost:").append(f);
    QLog.i("cmgame_process.ApolloGameRscVerify", 1, ((StringBuilder)localObject).toString());
    localObject = new HashMap();
    ((HashMap)localObject).put("gameId", Integer.toString(this.mGameId));
    ((HashMap)localObject).put("avgCost", Float.toString(f));
    String str = getSelfUin();
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(str, "cmshow_game_rsc_avg_cost", true, -1L, -1L, (HashMap)localObject, "", true);
  }
  
  public String getItemId()
  {
    if (this.ctC == 0) {
      return String.valueOf(this.mGameId);
    }
    return this.mGameId + "_" + this.awu;
  }
  
  public String getSelfUin()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)localAppRuntime).getCurrentAccountUin();
    }
    return "";
  }
  
  public boolean jH(String paramString)
  {
    return (this.bq != null) && (!TextUtils.isEmpty(this.bq.optString(paramString)));
  }
  
  public static abstract interface a
  {
    public abstract void HM(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abya
 * JD-Core Version:    0.7.0.1
 */