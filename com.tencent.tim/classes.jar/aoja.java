import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.animation.AnimationUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.GifDrawable;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import mqq.app.AccountNotMatchException;

public abstract class aoja
  extends aoiz
{
  public static int dOG;
  public static int dOH;
  private static int dOI = 1048576;
  private static int dOJ = dOI * 2;
  protected BaseApplicationImpl b;
  protected String tag;
  
  public aoja(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.tag = paramString;
    this.b = paramBaseApplicationImpl;
  }
  
  private void a(Application paramApplication, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        paramApplication = ((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString2)).getCurrentAccountUin();
      }
      catch (AccountNotMatchException paramApplication)
      {
        return;
      }
      paramString2 = new HashMap();
      paramString2.put("param_FailCode", Integer.toString(paramInt2 * 7 + paramInt1 + 88000));
      anpc.a(BaseApplication.getContext()).collectPerformance(paramApplication, paramString1, bool, 0L, 0L, paramString2, "");
      return;
      boolean bool = false;
      continue;
      paramApplication = paramString2;
      if (paramInt2 == 0) {
        bool = true;
      }
    }
  }
  
  private void a(Application paramApplication, String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    paramInt *= 4;
    try
    {
      if (paramInt < dOI)
      {
        paramInt = i;
        if (!paramBoolean) {
          break label182;
        }
        paramInt = 1;
      }
      for (;;)
      {
        paramApplication = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString);
        paramString = new HashMap();
        paramString.put("param_FailCode", Integer.toString(paramInt + 88050));
        anpc.a(BaseApplication.getContext()).collectPerformance(paramApplication.getCurrentAccountUin(), "report_aio_photo_size", false, 0L, 0L, paramString, "");
        return;
        paramInt /= dOJ;
        if (paramInt >= 10)
        {
          if (paramBoolean) {}
          for (paramInt = 17;; paramInt = 16) {
            break;
          }
        }
        if (paramInt >= 8)
        {
          if (paramBoolean) {}
          for (paramInt = 15;; paramInt = 14) {
            break;
          }
        }
        if (paramInt >= 6)
        {
          if (paramBoolean) {}
          for (paramInt = 13;; paramInt = 12) {
            break;
          }
        }
        if (paramBoolean) {}
        for (paramInt = paramInt * 2 + 3;; paramInt = paramInt * 2 + 2) {
          break;
        }
      }
    }
    catch (AccountNotMatchException paramApplication) {}
  }
  
  public static void a(aoja.d paramd, boolean paramBoolean, int paramInt1, int paramInt2, String paramString, aoko.a parama1, aoko.a parama2, aoko.b paramb)
  {
    System.currentTimeMillis();
    long l1;
    if (paramb != null)
    {
      l1 = paramb.apN;
      if (paramb == null) {
        break label42;
      }
    }
    label42:
    for (long l2 = paramb.contentSize;; l2 = 0L)
    {
      if (!aona.lQ(paramInt2)) {
        break label48;
      }
      return;
      l1 = 0L;
      break;
    }
    label48:
    HashMap localHashMap = new HashMap();
    a(localHashMap, paramInt2, paramString, parama2, paramb, paramBoolean, parama1);
    localHashMap.put("param_uuid", paramd.uuid);
    localHashMap.put("flow", String.valueOf(l1));
    localHashMap.put("msgTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramd.msgTime * 1000L)));
    localHashMap.put("client_exist", String.valueOf(paramd.cLI));
    if (parama2 != null) {
      localHashMap.put("param_RequestUrl", parama2.AM());
    }
    if (paramb != null) {
      localHashMap.put("param_HttpTran", paramb.AM());
    }
    if (paramb != null)
    {
      localHashMap.put("param_retry", String.valueOf(paramb.retryCount));
      if (paramb.result)
      {
        localHashMap.put("serverip", paramb.clD);
        localHashMap.put("param_Server", paramb.clD);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label366;
      }
      if ((!paramd.ckQ.equals("actC2CPicDownloadV1")) && (!paramd.ckQ.equals("actC2CPicSmallDownV1"))) {
        break label351;
      }
      localHashMap.put("param_toUin", paramd.peerUin);
    }
    for (;;)
    {
      anpc.a(BaseApplication.getContext()).collectPerformance(null, paramd.ckQ, true, paramInt1, l1, localHashMap, "");
      return;
      localHashMap.put("serverip", paramb.clE);
      localHashMap.put("param_Server", paramb.clE);
      if (paramInt2 != -9527) {
        break;
      }
      localHashMap.put("param_rspHeader", paramb.clF);
      break;
      label351:
      localHashMap.put("param_grpUin", paramd.peerUin);
    }
    label366:
    if (paramInt2 == 9301) {
      localHashMap.put("param_connecttrycount", paramString);
    }
    if ((paramd.ckT != null) && (!paramd.ckT.equals(""))) {
      localHashMap.put("param_MsgTime", paramd.ckT);
    }
    long l3 = paramInt1;
    if ((paramd.ckQ.equals("actC2CPicDownloadV1")) || (paramd.ckQ.equals("actC2CPicSmallDownV1")))
    {
      localHashMap.put("param_toUin", paramd.peerUin);
      localHashMap.put("param_url", paramd.ckS);
      localHashMap.put("param_fsized", l1 + "");
      localHashMap.put("param_fsizeo", l2 + "");
    }
    for (;;)
    {
      anpc.a(BaseApplication.getContext()).collectPerformance(null, paramd.ckQ, false, 0L, 0L, localHashMap, "");
      return;
      localHashMap.put("param_grpUin", paramd.peerUin);
      localHashMap.put("param_url", paramd.ckS);
      localHashMap.put("param_fsized", l1 + "");
      localHashMap.put("param_fsizeo", l2 + "");
    }
  }
  
  private void a(DownloadParams paramDownloadParams)
  {
    MessageForPic localMessageForPic;
    Object localObject;
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof MessageForPic)))
    {
      localMessageForPic = (MessageForPic)paramDownloadParams.tag;
      localObject = localMessageForPic.selfuin;
    }
    try
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime((String)localObject);
      ((QQAppInterface)localObject).a().a.c(localMessageForPic, localMessageForPic.size);
      ((QQAppInterface)localObject).a().consume();
      return;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      c(paramDownloadParams, "payPicFlow", "FAIL,exceptionmsg:" + localAccountNotMatchException);
    }
  }
  
  private void a(DownloadParams paramDownloadParams, File paramFile, String paramString1, BitmapFactory.Options paramOptions, int paramInt, boolean paramBoolean, String paramString2)
  {
    if (paramBoolean) {
      if (QLog.isColorLevel()) {
        c(paramDownloadParams, "DecodeFile", "DecodeFile SUCCESS,retryCount=" + paramInt + ",options.inSampleSize=" + paramOptions.inSampleSize + ",cacheFile=" + paramFile.getAbsolutePath() + ",url=" + paramString1 + ",extraMsg=" + paramString2);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    c(paramDownloadParams, "DecodeFile", "DecodeFile FAIL,retryCount=" + paramInt + ",options.inSampleSize=" + paramOptions.inSampleSize + ",cacheFile=" + paramFile.getAbsolutePath() + ",url=" + paramString1 + ",extraMsg=" + paramString2);
  }
  
  /* Error */
  protected static void a(OutputStream paramOutputStream, File paramFile, URLDrawableHandler paramURLDrawableHandler)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 326	java/io/File:length	()J
    //   4: lstore 6
    //   6: new 328	java/io/FileInputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 331	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore_1
    //   15: lconst_0
    //   16: lstore 4
    //   18: sipush 8192
    //   21: newarray byte
    //   23: astore 8
    //   25: aload_1
    //   26: aload 8
    //   28: invokevirtual 335	java/io/FileInputStream:read	([B)I
    //   31: istore_3
    //   32: iload_3
    //   33: iconst_m1
    //   34: if_icmpeq +94 -> 128
    //   37: aload_0
    //   38: aload 8
    //   40: iconst_0
    //   41: iload_3
    //   42: invokevirtual 341	java/io/OutputStream:write	([BII)V
    //   45: aload_0
    //   46: invokevirtual 344	java/io/OutputStream:flush	()V
    //   49: lload 4
    //   51: iload_3
    //   52: i2l
    //   53: ladd
    //   54: lstore 4
    //   56: aload_2
    //   57: lload 4
    //   59: l2f
    //   60: lload 6
    //   62: l2f
    //   63: fdiv
    //   64: ldc_w 345
    //   67: fmul
    //   68: f2i
    //   69: invokeinterface 351 2 0
    //   74: goto -49 -> 25
    //   77: astore_2
    //   78: aload_1
    //   79: astore_0
    //   80: aload_2
    //   81: invokevirtual 354	java/io/IOException:getMessage	()Ljava/lang/String;
    //   84: ldc_w 356
    //   87: invokevirtual 360	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   90: ifeq +47 -> 137
    //   93: new 362	com/tencent/mobileqq/transfile/FileDownloadFailedException
    //   96: dup
    //   97: sipush 9040
    //   100: ldc2_w 363
    //   103: aload_2
    //   104: invokevirtual 354	java/io/IOException:getMessage	()Ljava/lang/String;
    //   107: iconst_0
    //   108: iconst_0
    //   109: invokespecial 367	com/tencent/mobileqq/transfile/FileDownloadFailedException:<init>	(IJLjava/lang/String;ZZ)V
    //   112: athrow
    //   113: astore_2
    //   114: aload_0
    //   115: astore_1
    //   116: aload_2
    //   117: astore_0
    //   118: aload_1
    //   119: ifnull +7 -> 126
    //   122: aload_1
    //   123: invokevirtual 370	java/io/FileInputStream:close	()V
    //   126: aload_0
    //   127: athrow
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 370	java/io/FileInputStream:close	()V
    //   136: return
    //   137: new 362	com/tencent/mobileqq/transfile/FileDownloadFailedException
    //   140: dup
    //   141: sipush 9301
    //   144: ldc2_w 371
    //   147: aload_2
    //   148: invokevirtual 354	java/io/IOException:getMessage	()Ljava/lang/String;
    //   151: iconst_0
    //   152: iconst_0
    //   153: invokespecial 367	com/tencent/mobileqq/transfile/FileDownloadFailedException:<init>	(IJLjava/lang/String;ZZ)V
    //   156: athrow
    //   157: astore_0
    //   158: aconst_null
    //   159: astore_1
    //   160: goto -42 -> 118
    //   163: astore_0
    //   164: goto -46 -> 118
    //   167: astore_2
    //   168: aconst_null
    //   169: astore_0
    //   170: goto -90 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramOutputStream	OutputStream
    //   0	173	1	paramFile	File
    //   0	173	2	paramURLDrawableHandler	URLDrawableHandler
    //   31	21	3	i	int
    //   16	42	4	l1	long
    //   4	57	6	l2	long
    //   23	16	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	25	77	java/io/IOException
    //   25	32	77	java/io/IOException
    //   37	49	77	java/io/IOException
    //   56	74	77	java/io/IOException
    //   80	113	113	finally
    //   137	157	113	finally
    //   6	15	157	finally
    //   18	25	163	finally
    //   25	32	163	finally
    //   37	49	163	finally
    //   56	74	163	finally
    //   6	15	167	java/io/IOException
  }
  
  public static void a(HashMap<String, String> paramHashMap, int paramInt, String paramString, aoko.a parama1, aoko.b paramb, boolean paramBoolean, aoko.a parama2)
  {
    String str;
    if (!aojn.a(paramInt, paramHashMap))
    {
      paramHashMap.put("param_FailCode", Integer.toString(paramInt));
      if ((paramInt == -9527) || (paramInt == 9311) || (paramInt == 9044) || (paramInt == 9350) || (paramInt == 9351))
      {
        paramHashMap.put(aojn.cle, paramString);
        str = "";
        if ((!paramBoolean) || (parama2 != null) || (parama1 != null) || (paramb != null)) {
          break label157;
        }
        paramString = "1_-1_0_0_0;2_-1_0_0_0;3_-1_0_0_0";
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("reportResult", 2, "parmStep: " + paramString);
      }
      paramHashMap.put("param_step", paramString);
      return;
      paramHashMap.put("param_errorDesc", paramString);
      break;
      paramHashMap.put("param_errorDesc", paramString);
      break;
      label157:
      paramString = str;
      if (parama2 != null)
      {
        paramString = str;
        if (parama1 != null)
        {
          paramString = str;
          if (paramb != null) {
            paramString = parama2.fE(1) + ";" + parama1.fE(2) + ";" + paramb.fE(3);
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2, String paramString, boolean paramBoolean5)
  {
    if (paramInt2 == 3)
    {
      paramInt2 = paramInt1 - 1;
      if (paramInt1 != 1) {
        break label51;
      }
      a(this.b, "big_img_decode", 0, paramString, paramInt2);
      a(this.b, "big_img_decode_long", 0, paramString, paramInt2);
    }
    label51:
    do
    {
      for (;;)
      {
        return;
        if (!paramBoolean5) {
          break;
        }
        if (!paramBoolean1) {
          if (paramBoolean3)
          {
            a(this.b, "big_img_decode", -1, paramString, paramInt2);
            if (!paramBoolean2) {
              break label159;
            }
            a(this.b, "big_img_decode_long", 3, paramString, paramInt2);
          }
        }
        for (;;)
        {
          if (!paramBoolean2) {
            break label176;
          }
          a(this.b, "big_img_decode_slice", 0, paramString, paramInt2);
          return;
          a(this.b, "big_img_decode", 2, paramString, paramInt2);
          break;
          a(this.b, "big_img_decode", 1, paramString, paramInt2);
          break;
          a(this.b, "big_img_decode_long", 4, paramString, paramInt2);
        }
      }
      if (paramBoolean1) {
        a(this.b, "big_img_decode", 5, paramString, paramInt2);
      }
      if (paramBoolean2) {
        a(this.b, "big_img_decode_long", 6, paramString, paramInt2);
      }
    } while (!paramBoolean4);
    label159:
    label176:
    a(this.b, "big_img_decode_slice", 6, paramString, paramInt2);
  }
  
  private void c(Object paramObject, String paramString1, String paramString2)
  {
    if ((paramObject instanceof DownloadParams))
    {
      localObject = (DownloadParams)paramObject;
      if ((((DownloadParams)localObject).tag instanceof akxw))
      {
        paramObject = (akxw)((DownloadParams)localObject).tag;
        localObject = ((DownloadParams)localObject).url.getProtocol();
        if (paramObject.isSendFromLocal())
        {
          i = aonc.gC(aoop.n((String)localObject, false));
          paramObject = paramObject.getPicUploadInfo();
          aonc.a(paramObject.uinType, false, i, String.valueOf(paramObject.uniseq), paramString1, paramString2);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      int i;
      return;
      paramObject = paramObject.getPicDownloadInfo();
      if (paramObject.fileSizeFlag == 1) {}
      for (boolean bool = true;; bool = false)
      {
        i = aonc.gC(aoop.n((String)localObject, bool));
        aonc.a(paramObject.uinType, false, i, String.valueOf(paramObject.uniseq), paramString1, paramString2);
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("obj").append(paramObject);
    ((StringBuilder)localObject).append(" \tstep:").append(paramString1);
    ((StringBuilder)localObject).append(" \tcontent:").append(paramString2);
    QLog.d("Q.richmedia.", 2, ((StringBuilder)localObject).toString());
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    return Utils.calculateInSampleSize(paramOptions, paramInt1, paramInt2);
  }
  
  public static String e(Exception paramException)
  {
    int i = 8;
    if (paramException == null) {
      return "Exception e is null";
    }
    Object localObject = paramException.getMessage();
    StackTraceElement[] arrayOfStackTraceElement = paramException.getStackTrace();
    if (arrayOfStackTraceElement != null)
    {
      localObject = new StringBuilder(":");
      int j = arrayOfStackTraceElement.length;
      if (j > 8) {}
      for (;;)
      {
        ((StringBuilder)localObject).append("\n");
        j = 0;
        while (j < i)
        {
          ((StringBuilder)localObject).append(arrayOfStackTraceElement[j].toString()).append("\n");
          j += 1;
        }
        i = j;
      }
      return paramException.toString() + ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  protected RoundRectBitmap a(Bitmap paramBitmap, DownloadParams paramDownloadParams)
  {
    for (;;)
    {
      float f3;
      int j;
      int n;
      int k;
      int i1;
      try
      {
        f3 = this.b.getResources().getDisplayMetrics().density;
        int m = this.b.getResources().getDisplayMetrics().densityDpi;
        boolean bool = avfp.ns(paramDownloadParams.mImgType);
        j = aoop.H(bool);
        i = aoop.G(bool);
        n = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        paramDownloadParams = new Paint(1);
        paramDownloadParams.setColor(-16777216);
        i1 = aoop.I(bool);
        int i2 = aoop.J(bool);
        if ((n >= i2) && (k >= i2)) {
          break label362;
        }
        if (n < k)
        {
          k = (int)(j / n * k + 0.5F);
          if (k <= i) {
            break label333;
          }
          Bitmap localBitmap = Bitmap.createBitmap(j, i, aoop.f);
          localBitmap.setDensity(m);
          new Canvas(localBitmap).drawBitmap(paramBitmap, null, new Rect(0, 0, j, i), paramDownloadParams);
          return new RoundRectBitmap(localBitmap, 6.0F * f3);
        }
        k = (int)(j / k * n + 0.5F);
        if (k <= i) {
          break label355;
        }
      }
      catch (OutOfMemoryError paramDownloadParams)
      {
        float f1;
        float f2;
        return new RoundRectBitmap(paramBitmap, 6.0F);
      }
      if (n > k)
      {
        f1 = i / n;
        if (n > k)
        {
          f2 = j / k;
          f1 = Math.max(f1, f2);
          j = (int)(n * f1 + 0.5F);
          i = (int)(f1 * k + 0.5F);
        }
      }
      else
      {
        f1 = i / k;
        continue;
      }
      f2 = j / n;
      continue;
      label333:
      int i = k;
      continue;
      for (;;)
      {
        k = i;
        i = j;
        j = k;
        break;
        label355:
        i = k;
      }
      label362:
      if ((n < i1) && (k < i1))
      {
        j = (int)(n * f3 + 0.5F);
        i = (int)(k * f3 + 0.5F);
      }
    }
  }
  
  public Object a(File paramFile, DownloadParams paramDownloadParams, BitmapFactory.Options paramOptions)
    throws Exception
  {
    String str1 = paramDownloadParams.urlStr;
    for (;;)
    {
      try
      {
        localObject1 = paramFile.getAbsolutePath();
        paramOptions.inPreferredConfig = aoop.f;
        paramOptions.inJustDecodeBounds = false;
        localObject2 = paramFile.getName();
        if (!((String)localObject2).endsWith("_hd"))
        {
          localObject2 = new File((String)localObject1 + "_hd");
          bool = ((File)localObject2).exists();
          if (!bool) {
            continue;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        Object localObject1;
        Object localObject2;
        boolean bool;
        Object localObject3;
        continue;
        int i = 0;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          c(paramDownloadParams, "DecodeFile", "DecodeFile hd thumb instead,cacheFile=" + ((File)localObject2).getAbsolutePath() + ", url=" + str1);
        }
        paramFile = (File)localObject2;
        i = 1;
      }
      catch (OutOfMemoryError localOutOfMemoryError3)
      {
        paramFile = (File)localObject2;
        continue;
        i = 0;
        continue;
      }
      try
      {
        localObject2 = SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramOptions);
        localObject3 = localObject2;
        if (localObject2 == null)
        {
          localObject3 = localObject2;
          if (i != 0)
          {
            bool = aqhq.fileExists((String)localObject1);
            if (bool)
            {
              localObject3 = SafeBitmapFactory.decodeFile((String)localObject1, paramOptions);
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                String str2 = arwv.encodeFileHexStr((String)localObject1);
                aqhq.deleteFile((String)localObject1);
                localObject2 = localObject3;
                if (QLog.isColorLevel())
                {
                  c(paramDownloadParams, "DecodeFile", "delete err thumb md5=" + str2);
                  localObject2 = localObject3;
                }
              }
            }
            localObject3 = localObject2;
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder().append("decode hd failed, try decode thumb ").append((String)localObject1).append(" exist=").append(bool).append(" result=");
              if (localObject2 == null) {
                continue;
              }
              bool = true;
              c(paramDownloadParams, "DecodeFile", bool);
              localObject3 = localObject2;
            }
          }
        }
        if (localObject3 != null)
        {
          if (i != 0) {
            aqhq.deleteFile((String)localObject1);
          }
          localObject1 = localObject3;
          if (paramDownloadParams.mDecodeHandler != null) {
            localObject1 = paramDownloadParams.mDecodeHandler.run(paramDownloadParams, (Bitmap)localObject3);
          }
          if (paramDownloadParams.tag != null)
          {
            if ((paramDownloadParams.tag instanceof MessageForPic)) {
              if (((MessageForPic)paramDownloadParams.tag).subMsgType != 2)
              {
                bool = str1.endsWith("?noRound");
                if (!bool) {}
              }
              else
              {
                return localObject1;
                if (((String)localObject2).length() <= 3) {
                  continue;
                }
                if (QLog.isColorLevel()) {
                  c(paramDownloadParams, "DecodeFile", "DecodeFile hd ,hdPath=" + (String)localObject1);
                }
                localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 3);
                i = 1;
                continue;
                bool = false;
                continue;
              }
            }
            if ((paramDownloadParams.tag instanceof aoox)) {
              return ((aoox)paramDownloadParams.tag).createBitmap((Bitmap)localObject1);
            }
          }
          localObject2 = a((Bitmap)localObject1, paramDownloadParams);
          if (!localObject1.equals(((RoundRectBitmap)localObject2).mBitmap)) {
            ((Bitmap)localObject1).recycle();
          }
          localObject1 = new RoundRectBitmap(new aooy(paramFile.getAbsolutePath()).Q(((RoundRectBitmap)localObject2).mBitmap), ((RoundRectBitmap)localObject2).mCornerRadius, ((RoundRectBitmap)localObject2).mBoardColor, ((RoundRectBitmap)localObject2).mBorderWidth);
          if (this.b != null)
          {
            ((RoundRectBitmap)localObject1).mDisplayWidth = this.b.getResources().getDisplayMetrics().widthPixels;
            ((RoundRectBitmap)localObject1).mDisplayHeight = this.b.getResources().getDisplayMetrics().heightPixels;
          }
          a(paramDownloadParams, paramFile, str1, paramOptions, 1, true, "step:create roundBitmap");
          return localObject1;
        }
        if (!((akxw)paramDownloadParams.tag).isSendFromLocal())
        {
          localObject1 = arwv.encodeFileHexStr(paramFile.getAbsolutePath());
          localObject2 = ((akxw)paramDownloadParams.tag).getPicDownloadInfo();
          QLog.i("Q.richmedia." + aonc.fG(((akxl)localObject2).uinType) + ".dw", 1, "id:" + String.valueOf(((akxl)localObject2).uniseq) + "step: UIDecoder FAIL srcPicMD5:" + (String)localObject1);
        }
        paramFile.delete();
        a(paramDownloadParams, paramFile, str1, paramOptions, 1, false, "step:decode error, not valid pic");
        throw new IOException("step:decode error, not valid pic");
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        a(paramDownloadParams, paramFile, str1, paramOptions, 1, false, "step:create roundBitmap, " + localOutOfMemoryError1.getMessage());
        throw localOutOfMemoryError1;
      }
    }
  }
  
  /* Error */
  public Object a(URL paramURL, File paramFile, DownloadParams paramDownloadParams, BitmapFactory.Options paramOptions)
    throws IOException
  {
    // Byte code:
    //   0: aload_3
    //   1: getfield 597	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   4: astore 17
    //   6: aload 4
    //   8: aload 4
    //   10: aload_3
    //   11: getfield 750	com/tencent/image/DownloadParams:reqWidth	I
    //   14: aload_3
    //   15: getfield 753	com/tencent/image/DownloadParams:reqHeight	I
    //   18: invokestatic 754	aoja:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   21: putfield 307	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   24: aload 4
    //   26: getfield 757	android/graphics/BitmapFactory$Options:outWidth	I
    //   29: istore 7
    //   31: aload 4
    //   33: getfield 760	android/graphics/BitmapFactory$Options:outHeight	I
    //   36: istore 8
    //   38: aload 4
    //   40: iconst_0
    //   41: putfield 603	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   44: iconst_0
    //   45: istore 10
    //   47: aconst_null
    //   48: astore 16
    //   50: iconst_1
    //   51: istore 6
    //   53: aload_1
    //   54: invokevirtual 422	java/net/URL:getProtocol	()Ljava/lang/String;
    //   57: ldc_w 762
    //   60: invokevirtual 201	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   63: ifne +55 -> 118
    //   66: aload_1
    //   67: invokevirtual 422	java/net/URL:getProtocol	()Ljava/lang/String;
    //   70: ldc_w 764
    //   73: invokevirtual 201	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   76: ifne +42 -> 118
    //   79: aload_1
    //   80: invokevirtual 422	java/net/URL:getProtocol	()Ljava/lang/String;
    //   83: ldc_w 766
    //   86: invokevirtual 201	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   89: ifne +29 -> 118
    //   92: aload_1
    //   93: invokevirtual 422	java/net/URL:getProtocol	()Ljava/lang/String;
    //   96: ldc_w 768
    //   99: invokevirtual 201	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifne +16 -> 118
    //   105: aload_1
    //   106: invokevirtual 422	java/net/URL:getProtocol	()Ljava/lang/String;
    //   109: ldc_w 770
    //   112: invokevirtual 201	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: ifeq +754 -> 869
    //   118: iconst_3
    //   119: istore 5
    //   121: aload 16
    //   123: astore_1
    //   124: iload 6
    //   126: iload 5
    //   128: if_icmpgt +730 -> 858
    //   131: aload_2
    //   132: invokevirtual 314	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   135: aload 4
    //   137: invokestatic 626	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   140: astore 16
    //   142: aload 16
    //   144: astore_1
    //   145: ldc_w 772
    //   148: aload_3
    //   149: getfield 775	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   152: invokevirtual 201	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   155: ifeq +708 -> 863
    //   158: aload 16
    //   160: astore_1
    //   161: new 693	aooy
    //   164: dup
    //   165: aload_2
    //   166: invokevirtual 314	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   169: invokespecial 694	aooy:<init>	(Ljava/lang/String;)V
    //   172: aload 16
    //   174: invokevirtual 697	aooy:Q	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   177: astore 16
    //   179: aload 16
    //   181: astore_1
    //   182: aload_1
    //   183: ifnonnull +258 -> 441
    //   186: iload 10
    //   188: istore 11
    //   190: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +60 -> 253
    //   196: iload 10
    //   198: istore 11
    //   200: aload_0
    //   201: aload_3
    //   202: ldc_w 295
    //   205: new 234	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 777
    //   215: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload 17
    //   220: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: ldc_w 779
    //   226: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: iload 6
    //   231: invokevirtual 300	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: ldc_w 781
    //   237: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_2
    //   241: invokevirtual 314	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   244: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokespecial 286	aoja:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   253: iload 10
    //   255: istore 11
    //   257: new 500	java/lang/OutOfMemoryError
    //   260: dup
    //   261: new 234	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   268: ldc_w 777
    //   271: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload 17
    //   276: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc_w 779
    //   282: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: iload 6
    //   287: invokevirtual 300	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: ldc_w 781
    //   293: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_2
    //   297: invokevirtual 314	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   300: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokespecial 782	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   309: athrow
    //   310: astore 16
    //   312: iload 11
    //   314: istore 10
    //   316: aload_1
    //   317: ifnull +7 -> 324
    //   320: aload_1
    //   321: invokevirtual 691	android/graphics/Bitmap:recycle	()V
    //   324: aload 16
    //   326: ifnull +468 -> 794
    //   329: aload 16
    //   331: invokevirtual 746	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   334: astore 16
    //   336: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +81 -> 420
    //   342: aload_0
    //   343: aload_3
    //   344: ldc_w 295
    //   347: new 234	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   354: ldc_w 784
    //   357: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: iload 6
    //   362: invokevirtual 300	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   365: ldc_w 302
    //   368: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload 4
    //   373: getfield 307	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   376: invokevirtual 300	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   379: ldc_w 309
    //   382: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: aload_2
    //   386: invokevirtual 314	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   389: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: ldc_w 316
    //   395: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload 17
    //   400: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: ldc_w 786
    //   406: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: aload 16
    //   411: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokespecial 286	aoja:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   420: iload 6
    //   422: iconst_1
    //   423: iadd
    //   424: istore 6
    //   426: aload 4
    //   428: aload 4
    //   430: getfield 307	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   433: iconst_2
    //   434: imul
    //   435: putfield 307	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   438: goto -314 -> 124
    //   441: iload 10
    //   443: istore 11
    //   445: getstatic 791	android/os/Build$VERSION:SDK_INT	I
    //   448: bipush 11
    //   450: if_icmplt +341 -> 791
    //   453: iload 10
    //   455: istore 11
    //   457: aload_1
    //   458: invokestatic 797	com/tencent/image/SliceBitmap:needSlice	(Landroid/graphics/Bitmap;)Z
    //   461: istore 12
    //   463: iload 12
    //   465: ifeq +326 -> 791
    //   468: iload 10
    //   470: istore 11
    //   472: new 793	com/tencent/image/SliceBitmap
    //   475: dup
    //   476: aload_1
    //   477: invokespecial 798	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   480: astore 16
    //   482: iconst_1
    //   483: istore 10
    //   485: aload_1
    //   486: invokevirtual 691	android/graphics/Bitmap:recycle	()V
    //   489: aload_0
    //   490: aload_3
    //   491: aload_2
    //   492: aload 17
    //   494: aload 4
    //   496: iload 6
    //   498: iconst_1
    //   499: ldc_w 800
    //   502: invokespecial 725	aoja:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   505: aload 16
    //   507: astore_1
    //   508: iconst_1
    //   509: istore 10
    //   511: aload_1
    //   512: ifnull +288 -> 800
    //   515: iconst_1
    //   516: istore 11
    //   518: aload_0
    //   519: aload_3
    //   520: aload_2
    //   521: aload 17
    //   523: aload 4
    //   525: iload 6
    //   527: iload 11
    //   529: ldc 88
    //   531: invokespecial 725	aoja:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   534: aload_3
    //   535: getfield 252	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   538: ifnull +185 -> 723
    //   541: aload_3
    //   542: getfield 252	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   545: instanceof 254
    //   548: ifeq +175 -> 723
    //   551: aload_3
    //   552: getfield 252	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   555: checkcast 254	com/tencent/mobileqq/data/MessageForPic
    //   558: astore_2
    //   559: aload_2
    //   560: getfield 257	com/tencent/mobileqq/data/MessageForPic:selfuin	Ljava/lang/String;
    //   563: astore_3
    //   564: aload_2
    //   565: invokevirtual 801	com/tencent/mobileqq/data/MessageForPic:isSendFromLocal	()Z
    //   568: istore 15
    //   570: aload_1
    //   571: ifnull +235 -> 806
    //   574: iconst_1
    //   575: istore 11
    //   577: iload 7
    //   579: iload 8
    //   581: imul
    //   582: istore 9
    //   584: iload 9
    //   586: getstatic 804	com/tencent/common/app/BaseApplicationImpl:sImageCacheSize	I
    //   589: if_icmple +223 -> 812
    //   592: iconst_1
    //   593: istore 12
    //   595: iload 7
    //   597: sipush 2048
    //   600: if_icmpgt +11 -> 611
    //   603: iload 8
    //   605: sipush 2048
    //   608: if_icmple +210 -> 818
    //   611: iconst_1
    //   612: istore 13
    //   614: getstatic 806	aoja:dOG	I
    //   617: ifeq +9 -> 626
    //   620: getstatic 808	aoja:dOH	I
    //   623: ifne +35 -> 658
    //   626: aload_0
    //   627: getfield 40	aoja:b	Lcom/tencent/common/app/BaseApplicationImpl;
    //   630: invokevirtual 504	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   633: invokevirtual 510	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   636: getfield 712	android/util/DisplayMetrics:widthPixels	I
    //   639: putstatic 806	aoja:dOG	I
    //   642: aload_0
    //   643: getfield 40	aoja:b	Lcom/tencent/common/app/BaseApplicationImpl;
    //   646: invokevirtual 504	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   649: invokevirtual 510	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   652: getfield 718	android/util/DisplayMetrics:heightPixels	I
    //   655: putstatic 808	aoja:dOH	I
    //   658: getstatic 806	aoja:dOG	I
    //   661: getstatic 808	aoja:dOH	I
    //   664: if_icmple +160 -> 824
    //   667: getstatic 806	aoja:dOG	I
    //   670: istore 7
    //   672: iload 9
    //   674: getstatic 811	aoop:dQS	I
    //   677: if_icmpgt +155 -> 832
    //   680: iload 7
    //   682: sipush 1000
    //   685: if_icmple +147 -> 832
    //   688: iconst_1
    //   689: istore 14
    //   691: aload_0
    //   692: iload 12
    //   694: iload 13
    //   696: iload 14
    //   698: iload 10
    //   700: iload 6
    //   702: iload 5
    //   704: aload_3
    //   705: iload 11
    //   707: invokespecial 813	aoja:a	(ZZZZIILjava/lang/String;Z)V
    //   710: aload_0
    //   711: aload_0
    //   712: getfield 40	aoja:b	Lcom/tencent/common/app/BaseApplicationImpl;
    //   715: aload_3
    //   716: iload 9
    //   718: iload 15
    //   720: invokespecial 815	aoja:a	(Landroid/app/Application;Ljava/lang/String;IZ)V
    //   723: aload_1
    //   724: ifnonnull +114 -> 838
    //   727: new 323	java/io/IOException
    //   730: dup
    //   731: ldc_w 817
    //   734: invokespecial 743	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   737: athrow
    //   738: astore 16
    //   740: iload 10
    //   742: istore 11
    //   744: aload_0
    //   745: aload_3
    //   746: ldc_w 295
    //   749: new 234	java/lang/StringBuilder
    //   752: dup
    //   753: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   756: ldc_w 819
    //   759: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: aload 16
    //   764: invokevirtual 484	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   767: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: invokespecial 286	aoja:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   776: iload 10
    //   778: istore 11
    //   780: new 500	java/lang/OutOfMemoryError
    //   783: dup
    //   784: ldc_w 821
    //   787: invokespecial 782	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   790: athrow
    //   791: goto -280 -> 511
    //   794: aconst_null
    //   795: astore 16
    //   797: goto -461 -> 336
    //   800: iconst_0
    //   801: istore 11
    //   803: goto -285 -> 518
    //   806: iconst_0
    //   807: istore 11
    //   809: goto -232 -> 577
    //   812: iconst_0
    //   813: istore 12
    //   815: goto -220 -> 595
    //   818: iconst_0
    //   819: istore 13
    //   821: goto -207 -> 614
    //   824: getstatic 808	aoja:dOH	I
    //   827: istore 7
    //   829: goto -157 -> 672
    //   832: iconst_0
    //   833: istore 14
    //   835: goto -144 -> 691
    //   838: aload_1
    //   839: areturn
    //   840: astore 16
    //   842: goto -526 -> 316
    //   845: astore 16
    //   847: goto -531 -> 316
    //   850: astore 16
    //   852: iconst_1
    //   853: istore 10
    //   855: goto -115 -> 740
    //   858: aconst_null
    //   859: astore_1
    //   860: goto -349 -> 511
    //   863: aload 16
    //   865: astore_1
    //   866: goto -684 -> 182
    //   869: iconst_1
    //   870: istore 5
    //   872: aload 16
    //   874: astore_1
    //   875: goto -751 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	878	0	this	aoja
    //   0	878	1	paramURL	URL
    //   0	878	2	paramFile	File
    //   0	878	3	paramDownloadParams	DownloadParams
    //   0	878	4	paramOptions	BitmapFactory.Options
    //   119	752	5	i	int
    //   51	650	6	j	int
    //   29	799	7	k	int
    //   36	573	8	m	int
    //   582	135	9	n	int
    //   45	809	10	bool1	boolean
    //   188	620	11	bool2	boolean
    //   461	353	12	bool3	boolean
    //   612	208	13	bool4	boolean
    //   689	145	14	bool5	boolean
    //   568	151	15	bool6	boolean
    //   48	132	16	localBitmap	Bitmap
    //   310	20	16	localOutOfMemoryError1	OutOfMemoryError
    //   334	172	16	localObject1	Object
    //   738	25	16	localException1	Exception
    //   795	1	16	localObject2	Object
    //   840	1	16	localOutOfMemoryError2	OutOfMemoryError
    //   845	1	16	localOutOfMemoryError3	OutOfMemoryError
    //   850	23	16	localException2	Exception
    //   4	518	17	str	String
    // Exception table:
    //   from	to	target	type
    //   190	196	310	java/lang/OutOfMemoryError
    //   200	253	310	java/lang/OutOfMemoryError
    //   257	310	310	java/lang/OutOfMemoryError
    //   445	453	310	java/lang/OutOfMemoryError
    //   457	463	310	java/lang/OutOfMemoryError
    //   472	482	310	java/lang/OutOfMemoryError
    //   744	776	310	java/lang/OutOfMemoryError
    //   780	791	310	java/lang/OutOfMemoryError
    //   472	482	738	java/lang/Exception
    //   131	142	840	java/lang/OutOfMemoryError
    //   145	158	840	java/lang/OutOfMemoryError
    //   161	179	840	java/lang/OutOfMemoryError
    //   485	505	845	java/lang/OutOfMemoryError
    //   485	505	850	java/lang/Exception
  }
  
  protected boolean a(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return GifDrawable.isGifFile(paramFile);
  }
  
  protected boolean b(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return "lbsthumb".equals(paramDownloadParams.url.getProtocol());
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    if (QLog.isColorLevel()) {
      c(paramDownloadParams, "DecodeFile", "decodeFile config.tag " + paramDownloadParams.tag);
    }
    URL localURL;
    BitmapFactory.Options localOptions;
    try
    {
      String str = paramDownloadParams.urlStr;
      localURL = paramDownloadParams.url;
      if (QLog.isColorLevel()) {
        c(paramDownloadParams, "DecodeFile", "DecodeFile START,cacheFile=" + paramFile.getAbsolutePath() + ",url=" + str);
      }
      localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = aoop.mConfig;
      localOptions.inDensity = 160;
      localOptions.inTargetDensity = 160;
      localOptions.inScreenDensity = 160;
      localOptions.inJustDecodeBounds = true;
      if (a(paramFile, paramDownloadParams, paramURLDrawableHandler))
      {
        a(paramDownloadParams);
        if (!QLog.isColorLevel()) {
          break label422;
        }
        c(paramDownloadParams, "DecodeFile", "DecodeFile END,GIF image,cacheFile=" + paramFile.getAbsolutePath() + ",url=" + str);
        break label422;
      }
      if (b(paramFile, paramDownloadParams, paramURLDrawableHandler)) {
        return a(paramFile, paramDownloadParams, localOptions);
      }
      a(paramDownloadParams);
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
      if ((localOptions.outHeight == 0) || (localOptions.outWidth == 0))
      {
        paramFile.delete();
        a(paramDownloadParams, paramFile, str, localOptions, 1, false, "step:decode bounds error, not valid pic");
        throw new IOException("step:decode bounds error, not valid pic");
      }
    }
    catch (Exception localException)
    {
      paramURLDrawableHandler = e(localException);
      if (paramURLDrawableHandler != null)
      {
        paramFile = paramURLDrawableHandler;
        if (paramURLDrawableHandler.length() != 0) {}
      }
      else
      {
        paramFile = localException.toString();
      }
      if (QLog.isColorLevel())
      {
        QLog.e(this.tag, 2, paramFile);
        c(paramDownloadParams, "DecodeFile", "DecodeFile FAIL,exceptionmsg:" + paramFile);
      }
      paramDownloadParams = new HashMap();
      paramDownloadParams.put("params_failDesc", paramFile);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actPicUIDecoder", false, -1L, 0L, paramDownloadParams, "", true);
      throw localException;
    }
    paramFile = a(localURL, paramFile, paramDownloadParams, localOptions);
    return paramFile;
    label422:
    return null;
  }
  
  public static class a
    extends aqog
  {
    boolean successed = false;
    
    public a(String paramString, byte[] paramArrayOfByte, aqoi paramaqoi, boolean paramBoolean)
    {
      super(paramArrayOfByte, paramaqoi, paramBoolean);
    }
  }
  
  public static class b
    implements aqoi
  {
    private URLDrawableHandler a;
    long apf = 0L;
    QQAppInterface app;
    String bUJ = "";
    boolean cLG = false;
    boolean cLH = false;
    int dOK = 0;
    long mContentSize = -1L;
    private OutputStream mOut;
    int progress = 0;
    String tag = "ImageDownloaderProcesser";
    
    public b(OutputStream paramOutputStream, URLDrawableHandler paramURLDrawableHandler, QQAppInterface paramQQAppInterface)
    {
      this.mOut = paramOutputStream;
      this.a = paramURLDrawableHandler;
      this.app = paramQQAppInterface;
    }
    
    private void bz(byte[] paramArrayOfByte)
    {
      boolean bool2 = false;
      if (this.dOK == 0)
      {
        paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
        byte[] arrayOfByte = new byte[2];
        paramArrayOfByte.get(arrayOfByte);
        paramArrayOfByte = aqhq.estimateFileType(arrayOfByte);
        bool1 = bool2;
        if (paramArrayOfByte != null)
        {
          bool1 = bool2;
          if (paramArrayOfByte.length() > 0) {
            if (!paramArrayOfByte.contains(aqhq.unKnownFileTypeMark)) {
              break label112;
            }
          }
        }
      }
      label112:
      for (boolean bool1 = bool2;; bool1 = true)
      {
        if (!bool1)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "verifyPhotofile verify:" + bool1);
          }
          this.cLH = true;
          throw new RuntimeException("unKnownFileTypeMark");
        }
        return;
      }
    }
    
    public void Hp(String paramString) {}
    
    public void a(aqog paramaqog1, aqog paramaqog2)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "decode mHandler.isCancelled:" + this.a.isCancelled());
        }
        if (this.a.isCancelled())
        {
          this.app.getHttpCommunicatort().f(paramaqog1);
          this.a.doCancel();
          return;
        }
        if ((paramaqog2.getResponseCode() == 206) || (paramaqog2.getResponseCode() == 200))
        {
          paramaqog1 = paramaqog2.aB();
          bz(paramaqog1);
          this.mOut.write(paramaqog1);
          this.mOut.flush();
          this.dOK += paramaqog1.length;
          this.mContentSize = paramaqog2.hR();
          if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "dataLen:" + paramaqog1.length + ",totalLen:" + paramaqog2.hR());
          }
          if (AnimationUtils.currentAnimationTimeMillis() - this.apf > 100L)
          {
            this.progress = ((int)(this.dOK / (float)this.mContentSize * 8500.0F));
            this.a.publishProgress(this.progress);
            return;
          }
        }
      }
      catch (IOException paramaqog1)
      {
        this.cLG = true;
        this.bUJ = paramaqog1.getMessage();
        throw new RuntimeException();
      }
    }
    
    public boolean a(aqog paramaqog1, aqog paramaqog2, int paramInt)
    {
      return true;
    }
    
    public void b(aqog paramaqog1, aqog paramaqog2) {}
  }
  
  public static class c
    extends achq
  {
    long Qw;
    String downUrl;
    int errCode;
    boolean finished;
    int retryCount;
    boolean successed;
    
    /* Error */
    protected void a(boolean paramBoolean, QQService.RespTmpChatPicDownload paramRespTmpChatPicDownload)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iload_1
      //   4: putfield 26	aoja$c:successed	Z
      //   7: iload_1
      //   8: ifeq +56 -> 64
      //   11: aload_2
      //   12: ifnull +35 -> 47
      //   15: aload_2
      //   16: getfield 31	QQService/RespTmpChatPicDownload:lReplyCode	I
      //   19: ifne +28 -> 47
      //   22: aload_2
      //   23: getfield 34	QQService/RespTmpChatPicDownload:strDownloadURL	Ljava/lang/String;
      //   26: ifnull +21 -> 47
      //   29: aload_2
      //   30: getfield 34	QQService/RespTmpChatPicDownload:strDownloadURL	Ljava/lang/String;
      //   33: invokevirtual 40	java/lang/String:length	()I
      //   36: ifle +11 -> 47
      //   39: aload_0
      //   40: aload_2
      //   41: getfield 34	QQService/RespTmpChatPicDownload:strDownloadURL	Ljava/lang/String;
      //   44: putfield 42	aoja$c:downUrl	Ljava/lang/String;
      //   47: aload_0
      //   48: iconst_1
      //   49: putfield 44	aoja$c:retryCount	I
      //   52: aload_0
      //   53: iconst_1
      //   54: putfield 46	aoja$c:finished	Z
      //   57: aload_0
      //   58: invokevirtual 51	java/lang/Object:notify	()V
      //   61: aload_0
      //   62: monitorexit
      //   63: return
      //   64: aload_0
      //   65: sipush 9006
      //   68: putfield 53	aoja$c:errCode	I
      //   71: goto -19 -> 52
      //   74: astore_2
      //   75: aload_0
      //   76: monitorexit
      //   77: aload_2
      //   78: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	79	0	this	c
      //   0	79	1	paramBoolean	boolean
      //   0	79	2	paramRespTmpChatPicDownload	QQService.RespTmpChatPicDownload
      // Exception table:
      //   from	to	target	type
      //   2	7	74	finally
      //   15	47	74	finally
      //   47	52	74	finally
      //   52	63	74	finally
      //   64	71	74	finally
      //   75	77	74	finally
    }
  }
  
  public static class d
  {
    boolean cLI;
    String ckQ;
    String ckR;
    String ckS;
    String ckT;
    long fileSize;
    String logTag;
    String md5;
    long msgTime;
    String peerUin;
    String uuid;
    
    public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7)
    {
      this.peerUin = paramString1;
      this.logTag = paramString2;
      this.ckQ = paramString3;
      this.ckR = paramString4;
      this.ckS = paramString5;
      this.uuid = paramString6;
      this.fileSize = paramLong;
      this.md5 = paramString7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoja
 * JD-Core Version:    0.7.0.1
 */