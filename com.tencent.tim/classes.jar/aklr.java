import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.ocr.OCRManager.1;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.a;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.b;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.c;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class aklr
  implements Manager
{
  public OcrConfig a;
  aklt b = new akls(this);
  private Object lock = new Object();
  public QQAppInterface mApp;
  EntityManager mEntityManager;
  
  public aklr(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mApp.addDefaultObservers(this.b);
    this.mEntityManager = paramQQAppInterface.a().createEntityManager();
    ThreadManager.post(new OCRManager.1(this), 5, null, false);
  }
  
  public static void a(String paramString, OcrConfig paramOcrConfig)
  {
    boolean bool2 = true;
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences(paramString + "ocr", 4).edit();
    if (paramOcrConfig == null)
    {
      paramString.putBoolean("is_aio_support", false);
      paramString.putBoolean("is_chat_file_support", false);
      paramString.putBoolean("is_qzone_support", false);
      paramString.putBoolean("is_scan_support", false);
      paramString.putBoolean("question_result_enter", false);
      paramString.putBoolean("question_scan_enter", false);
      paramString.putString("ocr_aio_text", "");
      paramString.commit();
      return;
    }
    if (paramOcrConfig.aioOcrOpen == 1)
    {
      bool1 = true;
      label127:
      paramString.putBoolean("is_aio_support", bool1);
      if (paramOcrConfig.chatFileOcrOpen != 1) {
        break label268;
      }
      bool1 = true;
      label147:
      paramString.putBoolean("is_chat_file_support", bool1);
      if (paramOcrConfig.qzoneOcrOpen != 1) {
        break label273;
      }
      bool1 = true;
      label167:
      paramString.putBoolean("is_qzone_support", bool1);
      if (paramOcrConfig.scanOcrOpen != 1) {
        break label278;
      }
      bool1 = true;
      label187:
      paramString.putBoolean("is_scan_support", bool1);
      if (!TextUtils.isEmpty(paramOcrConfig.iconText)) {
        paramString.putString("ocr_aio_text", paramOcrConfig.aioText);
      }
      if (paramOcrConfig.questionResultOpen != 1) {
        break label283;
      }
      bool1 = true;
      label230:
      paramString.putBoolean("question_result_enter", bool1);
      if (paramOcrConfig.questionScanOpen != 1) {
        break label288;
      }
    }
    label268:
    label273:
    label278:
    label283:
    label288:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramString.putBoolean("question_scan_enter", bool1);
      break;
      bool1 = false;
      break label127;
      bool1 = false;
      break label147;
      bool1 = false;
      break label167;
      bool1 = false;
      break label187;
      bool1 = false;
      break label230;
    }
  }
  
  public static boolean ae(String paramString, int paramInt)
  {
    boolean bool3 = true;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(paramString + "ocr", 4);
    boolean bool1;
    if (paramInt == 1) {
      bool1 = localSharedPreferences.getBoolean("is_aio_support", false);
    }
    for (;;)
    {
      boolean bool2;
      if (aknv.a().dnP == 1)
      {
        bool2 = true;
        label68:
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr", 2, "isSupportOcr, uin:" + paramString + "form:" + paramInt + ",isSupport:" + bool1 + ",dpcSwitch:" + bool2 + ",sdcard:" + akng.cte);
        }
        if ((!bool1) || (!bool2) || (!akng.cte)) {
          break label218;
        }
      }
      label218:
      for (bool1 = bool3;; bool1 = false)
      {
        return bool1;
        if (paramInt == 2)
        {
          bool1 = localSharedPreferences.getBoolean("is_qzone_support", false);
          break;
        }
        if (paramInt == 0)
        {
          bool1 = localSharedPreferences.getBoolean("is_scan_support", false);
          break;
        }
        if (paramInt != 7) {
          break label223;
        }
        bool1 = localSharedPreferences.getBoolean("is_chat_file_support", false);
        break;
        bool2 = false;
        break label68;
      }
      label223:
      bool1 = false;
    }
  }
  
  public static String mw(String paramString)
  {
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences(paramString + "ocr", 4).getString("ocr_aio_text", "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr", 2, "getAIOText " + paramString);
    }
    return paramString;
  }
  
  public static boolean nI(String paramString)
  {
    return ae(paramString, 2);
  }
  
  public static String y(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getCurrentAccountUin() + "_" + SystemClock.uptimeMillis();
  }
  
  public OCRTextSearchInfo.c a(List<OCRTextSearchInfo.SougouSearchInfo> paramList)
  {
    OCRTextSearchInfo.c localc = new OCRTextSearchInfo.c();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localc.qT = new ArrayList();
      OCRTextSearchInfo.a locala = new OCRTextSearchInfo.a();
      locala.groupType = 2049;
      locala.groupName = acfp.m(2131709342);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        OCRTextSearchInfo.SougouSearchInfo localSougouSearchInfo = (OCRTextSearchInfo.SougouSearchInfo)paramList.next();
        OCRTextSearchInfo.b localb = new OCRTextSearchInfo.b();
        localb.data = localSougouSearchInfo;
        locala.cB.add(localb);
      }
      localc.qT.add(locala);
    }
    return localc;
  }
  
  public OcrConfig a(boolean paramBoolean)
  {
    if ((this.a == null) && (paramBoolean))
    {
      loadConfigFromFile();
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.manager", 2, "getOCRConfig:" + this.a);
      }
    }
    return this.a;
  }
  
  /* Error */
  public void a(boolean paramBoolean, OcrConfig paramOcrConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +40 -> 45
    //   8: ldc_w 298
    //   11: iconst_2
    //   12: new 69	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 306
    //   22: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_1
    //   26: invokevirtual 187	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: ldc_w 308
    //   32: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: iload_1
    //   46: ifeq +31 -> 77
    //   49: aload_0
    //   50: getfield 30	aklr:lock	Ljava/lang/Object;
    //   53: astore_3
    //   54: aload_3
    //   55: monitorenter
    //   56: aload_0
    //   57: aload_2
    //   58: putfield 293	aklr:a	Lcom/tencent/mobileqq/ocr/data/OcrConfig;
    //   61: aload_0
    //   62: getfield 32	aklr:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   65: invokevirtual 218	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   68: aload_0
    //   69: getfield 293	aklr:a	Lcom/tencent/mobileqq/ocr/data/OcrConfig;
    //   72: invokestatic 310	aklr:a	(Ljava/lang/String;Lcom/tencent/mobileqq/ocr/data/OcrConfig;)V
    //   75: aload_3
    //   76: monitorexit
    //   77: new 312	com/tencent/mobileqq/ocr/OCRManager$3
    //   80: dup
    //   81: aload_0
    //   82: iload_1
    //   83: invokespecial 315	com/tencent/mobileqq/ocr/OCRManager$3:<init>	(Laklr;Z)V
    //   86: bipush 8
    //   88: aconst_null
    //   89: iconst_0
    //   90: invokestatic 58	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: astore_2
    //   97: aload_3
    //   98: monitorexit
    //   99: aload_2
    //   100: athrow
    //   101: astore_2
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_2
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	aklr
    //   0	106	1	paramBoolean	boolean
    //   0	106	2	paramOcrConfig	OcrConfig
    // Exception table:
    //   from	to	target	type
    //   56	77	96	finally
    //   97	99	96	finally
    //   2	45	101	finally
    //   49	56	101	finally
    //   77	93	101	finally
    //   99	101	101	finally
  }
  
  public int lA()
  {
    OcrConfig localOcrConfig = a(true);
    if (localOcrConfig == null) {}
    for (int i = 0;; i = localOcrConfig.version)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.manager", 2, "getConfigVersion:" + i);
      }
      return i;
    }
  }
  
  public void loadConfigFromFile()
  {
    synchronized (this.lock)
    {
      if (this.a == null)
      {
        this.a = OcrConfig.readFromFile(this.mApp.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.manager", 2, "loadConfigFromFile,mOcrConfig =   " + this.a);
        }
        if (this.a != null) {
          a(this.mApp.getCurrentAccountUin(), this.a);
        }
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    this.mApp.removeObserver(this.b);
    this.a = null;
  }
  
  public void r(String paramString1, String paramString2, long paramLong)
  {
    if (!aqiw.isNetworkAvailable(this.mApp.getApp())) {
      ((aklq)this.mApp.getBusinessHandler(113)).notifyUI(3, false, new Object[] { Integer.valueOf(-2), paramString1, null });
    }
    while ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    String str = paramString2;
    if (paramString2.length() > 300) {
      str = paramString2.substring(0, 300);
    }
    ((aklq)this.mApp.getBusinessHandler(113)).r(paramString1, str, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aklr
 * JD-Core Version:    0.7.0.1
 */