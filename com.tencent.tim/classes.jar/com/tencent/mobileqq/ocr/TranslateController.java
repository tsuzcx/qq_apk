package com.tencent.mobileqq.ocr;

import adgp;
import adhu;
import adhv;
import adhx;
import ahbj;
import aklq;
import akng;
import aknh;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class TranslateController
{
  private HandlerThread R;
  private aklq b;
  private Handler cE;
  private adgp d;
  private QQAppInterface mApp;
  HashMap<String, ImageTranslateTask> me;
  
  public TranslateController(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.d = new adgp(paramQQAppInterface);
    this.d.preConnect();
    this.R = new HandlerThread("TranslateFileUpload_" + System.currentTimeMillis());
    this.R.start();
    this.cE = new Handler(this.R.getLooper());
    this.me = new HashMap();
    this.b = ((aklq)this.mApp.getBusinessHandler(113));
  }
  
  private void a(boolean paramBoolean, String paramString, TranslateResult arg3)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.b == null) {
      return;
    }
    if (??? != null) {
      ???.imagePath = paramString;
    }
    this.b.notifyUI(2, paramBoolean, new Object[] { Integer.valueOf(2), ??? });
    synchronized (this.me)
    {
      this.me.remove(paramString);
      return;
    }
  }
  
  public void aL(String paramString1, String paramString2, String paramString3)
  {
    if (this.b != null) {
      this.b.aL(paramString1, paramString2, paramString3);
    }
  }
  
  /* Error */
  public void j(String paramString1, String arg2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 85	com/tencent/mobileqq/ocr/TranslateController:me	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 140	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifeq +21 -> 31
    //   13: ldc 142
    //   15: iconst_1
    //   16: ldc 144
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 150	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   25: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +38 -> 72
    //   37: ldc 142
    //   39: iconst_2
    //   40: ldc 161
    //   42: iconst_4
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: aload_1
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: aload_2
    //   53: aastore
    //   54: dup
    //   55: iconst_2
    //   56: aload_3
    //   57: aastore
    //   58: dup
    //   59: iconst_3
    //   60: iload 4
    //   62: invokestatic 166	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   65: aastore
    //   66: invokestatic 150	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   69: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: new 6	com/tencent/mobileqq/ocr/TranslateController$ImageTranslateTask
    //   75: dup
    //   76: aload_0
    //   77: aload_1
    //   78: aload_2
    //   79: aload_3
    //   80: iload 4
    //   82: invokespecial 169	com/tencent/mobileqq/ocr/TranslateController$ImageTranslateTask:<init>	(Lcom/tencent/mobileqq/ocr/TranslateController;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   85: astore_3
    //   86: aload_0
    //   87: getfield 85	com/tencent/mobileqq/ocr/TranslateController:me	Ljava/util/HashMap;
    //   90: astore_2
    //   91: aload_2
    //   92: monitorenter
    //   93: aload_0
    //   94: getfield 85	com/tencent/mobileqq/ocr/TranslateController:me	Ljava/util/HashMap;
    //   97: aload_1
    //   98: aload_3
    //   99: invokevirtual 173	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   102: pop
    //   103: aload_2
    //   104: monitorexit
    //   105: aload_0
    //   106: getfield 80	com/tencent/mobileqq/ocr/TranslateController:cE	Landroid/os/Handler;
    //   109: aload_3
    //   110: invokevirtual 177	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   113: pop
    //   114: goto -86 -> 28
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload_2
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	TranslateController
    //   0	127	1	paramString1	String
    //   0	127	3	paramString3	String
    //   0	127	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	28	117	finally
    //   31	72	117	finally
    //   72	93	117	finally
    //   105	114	117	finally
    //   125	127	117	finally
    //   93	105	122	finally
    //   123	125	122	finally
  }
  
  public void release()
  {
    if (this.cE != null)
    {
      this.cE.removeCallbacksAndMessages(null);
      this.cE = null;
    }
    if (this.R != null)
    {
      this.R.quit();
      this.R = null;
    }
    if (this.d != null)
    {
      this.d.BC();
      this.d.destroy();
      this.d = null;
    }
  }
  
  public class ImageTranslateTask
    implements Runnable
  {
    String bta;
    String btb;
    String imagePath;
    boolean needCompress;
    
    public ImageTranslateTask(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      this.imagePath = paramString1;
      this.bta = paramString2;
      this.btb = paramString3;
      this.needCompress = paramBoolean;
    }
    
    private String sw()
    {
      return String.format("%s_%s_%05d", new Object[] { TranslateController.a(TranslateController.this).getCurrentAccountUin(), new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis())), Integer.valueOf(new Random().nextInt(100000)) });
    }
    
    public void run()
    {
      if (!ahbj.isFileExists(this.imagePath))
      {
        QLog.d("TranslateController", 1, "picTranslate, file is not exists: " + this.imagePath);
        localObject1 = new TranslateResult(2);
        ((TranslateResult)localObject1).errCode = 1001;
        TranslateController.a(TranslateController.this, false, this.imagePath, (TranslateResult)localObject1);
        return;
      }
      Object localObject1 = this.imagePath;
      if (this.needCompress)
      {
        localObject2 = akng.mA(this.imagePath);
        localObject1 = localObject2;
        if (!akng.bk(this.imagePath, (String)localObject2))
        {
          localObject1 = this.imagePath;
          QLog.d("TranslateController", 1, "compress image failed!");
        }
      }
      Object localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
      int i = ((BitmapFactory.Options)localObject2).outHeight;
      int j = ((BitmapFactory.Options)localObject2).outWidth;
      localObject2 = new adhu();
      ((adhu)localObject2).bsZ = this.imagePath;
      ((adhu)localObject2).fileName = ((String)localObject1);
      ((adhu)localObject2).fileFormat = 0;
      ((adhu)localObject2).height = i;
      ((adhu)localObject2).width = j;
      adhx localadhx = new adhx();
      localadhx.bta = this.bta;
      localadhx.btb = this.btb;
      localadhx.uuid = sw();
      adhv localadhv = new adhv();
      localadhv.sessionId = sw();
      localadhv.jdField_a_of_type_Adhu = ((adhu)localObject2);
      localadhv.jdField_a_of_type_Adhx = localadhx;
      localadhv.latitude = 900000000;
      localadhv.longitude = 900000000;
      localadhv.Sl = 8192L;
      localadhv.businessType = 0;
      localadhv.appid = String.valueOf(TranslateController.a(TranslateController.this).getAppid());
      localadhv.uin = Long.parseLong(TranslateController.a(TranslateController.this).getCurrentAccountUin());
      localadhv.Tb = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject1 = new File((String)localObject1);
        QLog.d("TranslateController", 2, String.format("picTranslate, fileInfo:%s, fileSize:%s", new Object[] { ((adhu)localObject2).toString(), ((File)localObject1).length() / 1024L + "KB" }));
      }
      if (QLog.isColorLevel()) {
        QLog.d("TranslateController", 2, "picTranslate reqInfo:" + localadhv);
      }
      if (TranslateController.a(TranslateController.this) == null) {
        TranslateController.a(TranslateController.this, new adgp(TranslateController.a(TranslateController.this)));
      }
      TranslateController.a(TranslateController.this).a(localadhv, new aknh(this, localadhv));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateController
 * JD-Core Version:    0.7.0.1
 */