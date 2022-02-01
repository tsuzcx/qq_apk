import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.OcrControl.1;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class akne
{
  public static final HashMap<String, String> mf = new HashMap();
  private HandlerThread R;
  public aklr a;
  adgp.a jdField_b_of_type_Adgp$a = new aknf(this);
  private akne.a jdField_b_of_type_Akne$a;
  adgp c;
  private Handler cE;
  private Object cV = new Object();
  AppInterface mApp;
  int mFrom;
  Handler mHandler;
  public HashMap<String, adhv> me;
  
  static
  {
    mf.put("zh", acfp.m(2131709318));
    mf.put("en", acfp.m(2131709337));
    mf.put("af", acfp.m(2131709341));
    mf.put("ar", acfp.m(2131709294));
    mf.put("eu", acfp.m(2131709329));
    mf.put("be", acfp.m(2131709292));
    mf.put("hr", acfp.m(2131709299));
    mf.put("da", acfp.m(2131709286));
    mf.put("nl", acfp.m(2131709322));
    mf.put("fo", acfp.m(2131709312));
    mf.put("fi", acfp.m(2131709303));
    mf.put("fr", acfp.m(2131709296));
    mf.put("gd", acfp.m(2131709335));
    mf.put("de", acfp.m(2131709287));
    mf.put("he", acfp.m(2131709317));
    mf.put("hu", acfp.m(2131709331));
    mf.put("id", acfp.m(2131709313));
    mf.put("it", acfp.m(2131709304));
    mf.put("kr", acfp.m(2131709327));
    mf.put("lv", acfp.m(2131709306));
    mf.put("mk", acfp.m(2131709339));
    mf.put("mt", acfp.m(2131709308));
    mf.put("no", acfp.m(2131709295));
    mf.put("pt", acfp.m(2131709319));
    mf.put("rm", acfp.m(2131709302));
    mf.put("ro", acfp.m(2131709300));
    mf.put("sr", acfp.m(2131709324));
    mf.put("sk", acfp.m(2131709326));
    mf.put("sb", acfp.m(2131709285));
    mf.put("es", acfp.m(2131709298));
    mf.put("sx", acfp.m(2131709307));
    mf.put("sv", acfp.m(2131709309));
    mf.put("ts", acfp.m(2131709291));
    mf.put("tr", acfp.m(2131709316));
    mf.put("ur", acfp.m(2131709340));
    mf.put("vi", acfp.m(2131709289));
    mf.put("ji", acfp.m(2131709282));
    mf.put("sq", acfp.m(2131709288));
    mf.put("bg", acfp.m(2131709297));
    mf.put("ca", acfp.m(2131709305));
    mf.put("cs", acfp.m(2131709332));
    mf.put("et", acfp.m(2131709330));
    mf.put("fa", acfp.m(2131709328));
    mf.put("ga", acfp.m(2131709325));
    mf.put("el", acfp.m(2131709334));
    mf.put("hi", acfp.m(2131709323));
    mf.put("is", acfp.m(2131709284));
    mf.put("jp", acfp.m(2131709338));
    mf.put("lt", acfp.m(2131709314));
    mf.put("ms", acfp.m(2131709283));
    mf.put("pl", acfp.m(2131709293));
    mf.put("ru", acfp.m(2131709290));
    mf.put("sz", acfp.m(2131709315));
    mf.put("sl", acfp.m(2131709321));
    mf.put("th", acfp.m(2131709311));
    mf.put("tn", acfp.m(2131709333));
    mf.put("uk", acfp.m(2131709310));
    mf.put("ve", acfp.m(2131709301));
    mf.put("xh", acfp.m(2131709336));
    mf.put("zu", acfp.m(2131709320));
  }
  
  public akne(AppInterface paramAppInterface, akne.a parama, int paramInt)
  {
    this.mApp = paramAppInterface;
    this.jdField_b_of_type_Akne$a = parama;
    this.c = new adgp(paramAppInterface);
    this.c.preConnect();
    this.me = new HashMap();
    this.a = ((aklr)this.mApp.getManager(228));
    this.mHandler = new Handler();
    this.mFrom = paramInt;
  }
  
  private adhv a(String paramString)
  {
    adhv localadhv = null;
    synchronized (this.me)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "req had been remove, sessionId:" + paramString);
        }
        localadhv = (adhv)this.me.remove(paramString);
      }
      return localadhv;
    }
  }
  
  private void aa(Runnable paramRunnable)
  {
    synchronized (this.cV)
    {
      if (this.cE != null) {
        this.cE.post(paramRunnable);
      }
      return;
    }
  }
  
  /* Error */
  private void b(adhv paramadhv)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 256	akne:me	Ljava/util/HashMap;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnull +62 -> 72
    //   13: aload_1
    //   14: getfield 328	adhv:sessionId	Ljava/lang/String;
    //   17: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +52 -> 72
    //   23: aload_0
    //   24: getfield 256	akne:me	Ljava/util/HashMap;
    //   27: aload_1
    //   28: getfield 328	adhv:sessionId	Ljava/lang/String;
    //   31: aload_1
    //   32: invokevirtual 51	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +33 -> 72
    //   42: ldc_w 291
    //   45: iconst_2
    //   46: new 293	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 294	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 330
    //   56: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: getfield 328	adhv:sessionId	Ljava/lang/String;
    //   63: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 308	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_2
    //   73: monitorexit
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore_1
    //   78: aload_2
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	akne
    //   0	87	1	paramadhv	adhv
    //   6	73	2	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   13	72	77	finally
    //   72	74	77	finally
    //   78	80	77	finally
    //   2	9	82	finally
    //   80	82	82	finally
  }
  
  /* Error */
  public void a(adhu paramadhu, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 314	adhv
    //   5: dup
    //   6: invokespecial 332	adhv:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: aload_0
    //   12: invokevirtual 335	akne:sw	()Ljava/lang/String;
    //   15: putfield 328	adhv:sessionId	Ljava/lang/String;
    //   18: aload_3
    //   19: aload_1
    //   20: putfield 338	adhv:jdField_a_of_type_Adhu	Ladhu;
    //   23: aload_3
    //   24: ldc_w 339
    //   27: putfield 342	adhv:latitude	I
    //   30: aload_3
    //   31: ldc_w 339
    //   34: putfield 345	adhv:longitude	I
    //   37: aload_3
    //   38: ldc2_w 346
    //   41: putfield 351	adhv:Sl	J
    //   44: aload_3
    //   45: iconst_0
    //   46: putfield 354	adhv:businessType	I
    //   49: aload_3
    //   50: aload_0
    //   51: getfield 242	akne:mApp	Lcom/tencent/common/app/AppInterface;
    //   54: invokevirtual 358	com/tencent/common/app/AppInterface:getAppid	()I
    //   57: invokestatic 363	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   60: putfield 366	adhv:appid	Ljava/lang/String;
    //   63: aload_3
    //   64: aload_0
    //   65: getfield 242	akne:mApp	Lcom/tencent/common/app/AppInterface;
    //   68: invokevirtual 369	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   71: invokestatic 375	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   74: putfield 378	adhv:uin	J
    //   77: aload_3
    //   78: invokestatic 384	java/lang/System:currentTimeMillis	()J
    //   81: putfield 387	adhv:Tb	J
    //   84: new 389	aklp
    //   87: dup
    //   88: invokespecial 390	aklp:<init>	()V
    //   91: astore 4
    //   93: aload_2
    //   94: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifne +9 -> 106
    //   100: aload 4
    //   102: aload_2
    //   103: putfield 393	aklp:language	Ljava/lang/String;
    //   106: aload_3
    //   107: aload 4
    //   109: putfield 396	adhv:jdField_a_of_type_Aklp	Laklp;
    //   112: aload_0
    //   113: aload_3
    //   114: invokespecial 398	akne:b	(Ladhv;)V
    //   117: aload_3
    //   118: getfield 328	adhv:sessionId	Ljava/lang/String;
    //   121: astore_2
    //   122: aload_0
    //   123: getfield 271	akne:mHandler	Landroid/os/Handler;
    //   126: new 400	com/tencent/mobileqq/ocr/OcrControl$2
    //   129: dup
    //   130: aload_0
    //   131: aload_2
    //   132: invokespecial 403	com/tencent/mobileqq/ocr/OcrControl$2:<init>	(Lakne;Ljava/lang/String;)V
    //   135: ldc2_w 404
    //   138: invokevirtual 409	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   141: pop
    //   142: aload_0
    //   143: getfield 251	akne:c	Ladgp;
    //   146: aload_3
    //   147: aload_0
    //   148: getfield 240	akne:jdField_b_of_type_Adgp$a	Ladgp$a;
    //   151: invokevirtual 412	adgp:a	(Ladhv;Ladgp$a;)Z
    //   154: ifeq +42 -> 196
    //   157: aload_0
    //   158: getfield 271	akne:mHandler	Landroid/os/Handler;
    //   161: new 414	com/tencent/mobileqq/ocr/OcrControl$3
    //   164: dup
    //   165: aload_0
    //   166: aload_2
    //   167: aload_1
    //   168: invokespecial 417	com/tencent/mobileqq/ocr/OcrControl$3:<init>	(Lakne;Ljava/lang/String;Ladhu;)V
    //   171: ldc2_w 418
    //   174: invokevirtual 409	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   177: pop
    //   178: new 421	com/tencent/mobileqq/ocr/OcrControl$4
    //   181: dup
    //   182: aload_0
    //   183: aload_1
    //   184: invokespecial 424	com/tencent/mobileqq/ocr/OcrControl$4:<init>	(Lakne;Ladhu;)V
    //   187: iconst_5
    //   188: aconst_null
    //   189: iconst_0
    //   190: invokestatic 429	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   193: aload_0
    //   194: monitorexit
    //   195: return
    //   196: aload_0
    //   197: getfield 244	akne:jdField_b_of_type_Akne$a	Lakne$a;
    //   200: iconst_3
    //   201: aconst_null
    //   202: aload_1
    //   203: getfield 434	adhu:bsZ	Ljava/lang/String;
    //   206: lconst_0
    //   207: invokeinterface 437 6 0
    //   212: goto -34 -> 178
    //   215: astore_1
    //   216: aload_0
    //   217: monitorexit
    //   218: aload_1
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	akne
    //   0	220	1	paramadhu	adhu
    //   0	220	2	paramString	String
    //   9	138	3	localadhv	adhv
    //   91	17	4	localaklp	aklp
    // Exception table:
    //   from	to	target	type
    //   2	106	215	finally
    //   106	178	215	finally
    //   178	193	215	finally
    //   196	212	215	finally
  }
  
  public void cD(String paramString, boolean paramBoolean)
  {
    h(paramString, paramBoolean, null);
  }
  
  public void cRG()
  {
    try
    {
      QLog.i("Q.ocr.control", 1, "startUploadThread.");
      if (this.R == null)
      {
        this.R = ThreadManager.newFreeHandlerThread("ocr_upload_thread" + System.currentTimeMillis(), 0);
        this.R.start();
        this.cE = new Handler(this.R.getLooper());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void cRH()
  {
    try
    {
      QLog.i("Q.ocr.control", 1, "stopUploadThread.");
      if (this.cE != null) {
        this.cE.removeCallbacksAndMessages(null);
      }
      this.cE = null;
      if (this.R != null)
      {
        this.R.quit();
        this.R.interrupt();
      }
      this.R = null;
      return;
    }
    finally {}
  }
  
  public void dCk()
  {
    synchronized (this.me)
    {
      this.me.clear();
      if (this.c != null) {
        this.c.BC();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "stopRecog...");
      }
      return;
    }
  }
  
  public void h(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.control", 2, "recogPic picPath:" + paramString1 + ",needCompress:" + paramBoolean);
    }
    aa(new OcrControl.1(this, paramString1, paramBoolean, paramString2));
  }
  
  public void start()
  {
    cRG();
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.control", 2, "Ocr control start");
    }
  }
  
  public void stop()
  {
    cRH();
    if (this.c != null) {
      this.c.BC();
    }
    if (this.me != null) {
      this.me.clear();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.control", 2, "Ocr control stop");
    }
  }
  
  public String sw()
  {
    return String.format("%s_%s_%05d", new Object[] { this.mApp.getCurrentAccountUin(), new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis())), Integer.valueOf(new Random().nextInt(100000)) });
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, OcrRecogResult paramOcrRecogResult, String paramString, long paramLong);
    
    public abstract void dCd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akne
 * JD-Core Version:    0.7.0.1
 */