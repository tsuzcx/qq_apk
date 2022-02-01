import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import mqq.app.MobileQQ;

public class ahcs
  implements aqoi
{
  public static String TAG = "UniformDownloaderGenWorker<FileAssistant>";
  public static int cZn = 1;
  public static int cZo = 2;
  public static int cZp = 3;
  private long YD;
  long YF = 0L;
  private final long Zd;
  private ahcq.a a;
  private int cXr;
  private int cXs;
  private Object dP = new Object();
  private Object dU = new Object();
  private Object dW = new Object();
  private Object dX = new Object();
  private Object dY = new Object();
  private aqog jdField_e_of_type_Aqog;
  private OutputStream jdField_e_of_type_JavaIoOutputStream;
  private String mCookie;
  private String mFilePath;
  private int mStatus = cZo;
  private final String mUrl;
  private long nFileSize;
  long startTime = 0L;
  
  public ahcs(long paramLong1, QQAppInterface paramQQAppInterface, String paramString1, long paramLong2, String paramString2, ahcq.a parama)
  {
    this.Zd = paramLong1;
    this.mUrl = new aglb(paramQQAppInterface, paramString1).vg();
    this.a = parama;
    this.nFileSize = paramLong2;
    this.mCookie = paramString2;
  }
  
  private void N(int paramInt, String paramString1, String paramString2)
  {
    dmr();
    QQAppInterface localQQAppInterface = aglz.a().getApp();
    if (localQQAppInterface != null)
    {
      ahav.a(localQQAppInterface, this.Zd, "actFileUfGenDownload", this.startTime, "", "", "", "", paramInt, paramString1, this.YF, this.YD, this.nFileSize, this.mUrl, "", this.cXr, paramString2, null);
      ahav.a(localQQAppInterface, this.Zd, "actFileUfGenDownloadDetail", this.startTime, "", "", "", "", paramInt, paramString1, this.YF, this.YD, this.nFileSize, this.mUrl, "", this.cXr, paramString2, null);
      anpb.F(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
    }
    for (;;)
    {
      paramString2 = a();
      if (paramString2 != null) {
        paramString2.b(paramInt, paramString1, null);
      }
      return;
      QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "].report failed - 3");
    }
  }
  
  private ahcq.a a()
  {
    synchronized (this.dY)
    {
      ahcq.a locala = this.a;
      return locala;
    }
  }
  
  private aqog a()
  {
    synchronized (this.dX)
    {
      aqog localaqog = this.jdField_e_of_type_Aqog;
      return localaqog;
    }
  }
  
  private void a(ahcq.a parama)
  {
    synchronized (this.dY)
    {
      this.a = parama;
      return;
    }
  }
  
  private boolean a(aqog paramaqog1, aqog paramaqog2)
  {
    if (paramaqog1 == null) {
      return false;
    }
    if (paramaqog2 == null) {
      return true;
    }
    return paramaqog2.aFq();
  }
  
  private boolean amQ()
  {
    for (;;)
    {
      synchronized (this.dW)
      {
        OutputStream localOutputStream = this.jdField_e_of_type_JavaIoOutputStream;
        if (localOutputStream == null) {
          try
          {
            this.jdField_e_of_type_JavaIoOutputStream = new FileOutputStream(this.mFilePath, true);
            QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "]. openFileStream: filepath:" + this.mFilePath);
            return true;
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. openFileStream: exception");
            localFileNotFoundException.printStackTrace();
            return false;
          }
        }
      }
      QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "]. openFileStream: had be opened");
    }
  }
  
  private boolean amR()
  {
    synchronized (this.dW)
    {
      try
      {
        if (this.jdField_e_of_type_JavaIoOutputStream != null)
        {
          this.jdField_e_of_type_JavaIoOutputStream.close();
          this.jdField_e_of_type_JavaIoOutputStream = null;
          QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "]. closeFileStream: filepath:" + this.mFilePath);
        }
        for (;;)
        {
          return true;
          QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "]. closeFileStream.had closed: stream = null:");
        }
        localObject2 = finally;
      }
      catch (IOException localIOException)
      {
        QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. closeFileStream: exception");
        localIOException.printStackTrace();
        return false;
      }
    }
  }
  
  private void b(aqog paramaqog)
  {
    synchronized (this.dX)
    {
      this.jdField_e_of_type_Aqog = paramaqog;
      return;
    }
  }
  
  /* Error */
  private boolean ci(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: lload_1
    //   6: invokespecial 230	ahcs:setDownloadSize	(J)V
    //   9: new 150	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   16: ldc 232
    //   18: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: lload_1
    //   22: invokevirtual 160	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: ldc 234
    //   27: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 5
    //   35: aload_0
    //   36: getfield 81	ahcs:mUrl	Ljava/lang/String;
    //   39: ifnull +245 -> 284
    //   42: aload_0
    //   43: getfield 81	ahcs:mUrl	Ljava/lang/String;
    //   46: ldc 236
    //   48: invokevirtual 242	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   51: ifne +233 -> 284
    //   54: new 150	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   61: aload_0
    //   62: getfield 81	ahcs:mUrl	Ljava/lang/String;
    //   65: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 244
    //   70: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: lload_1
    //   74: invokestatic 248	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   77: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore 4
    //   85: new 178	aqog
    //   88: dup
    //   89: aload 4
    //   91: aconst_null
    //   92: aload_0
    //   93: iconst_1
    //   94: invokespecial 251	aqog:<init>	(Ljava/lang/String;[BLaqoi;Z)V
    //   97: astore 6
    //   99: ldc 253
    //   101: astore 4
    //   103: invokestatic 259	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   106: invokestatic 265	aqiw:getNetworkType	(Landroid/content/Context;)I
    //   109: iconst_1
    //   110: if_icmpne +8 -> 118
    //   113: ldc_w 267
    //   116: astore 4
    //   118: aload 6
    //   120: ldc_w 269
    //   123: aload 4
    //   125: invokevirtual 273	aqog:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload 6
    //   130: ldc_w 275
    //   133: aload 5
    //   135: invokevirtual 273	aqog:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload 6
    //   140: iconst_1
    //   141: invokevirtual 279	aqog:setPriority	(I)V
    //   144: aload_0
    //   145: getfield 87	ahcs:mCookie	Ljava/lang/String;
    //   148: invokestatic 284	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   151: ifne +15 -> 166
    //   154: aload 6
    //   156: ldc_w 286
    //   159: aload_0
    //   160: getfield 87	ahcs:mCookie	Ljava/lang/String;
    //   163: invokevirtual 273	aqog:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aload 6
    //   168: iconst_1
    //   169: invokevirtual 290	aqog:SP	(Z)V
    //   172: aload 6
    //   174: iconst_5
    //   175: putfield 293	aqog:fileType	I
    //   178: aload 6
    //   180: iconst_0
    //   181: putfield 296	aqog:busiType	I
    //   184: aload 6
    //   186: invokestatic 302	java/lang/System:currentTimeMillis	()J
    //   189: invokestatic 248	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   192: putfield 305	aqog:msgId	Ljava/lang/String;
    //   195: aload 6
    //   197: ldc_w 307
    //   200: ldc_w 309
    //   203: invokevirtual 273	aqog:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload_0
    //   207: aload 6
    //   209: invokespecial 311	ahcs:b	(Laqog;)V
    //   212: invokestatic 97	aglz:a	()Laglz;
    //   215: invokevirtual 101	aglz:getApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   218: astore 4
    //   220: aload 4
    //   222: ifnonnull +97 -> 319
    //   225: getstatic 41	ahcs:TAG	Ljava/lang/String;
    //   228: iconst_1
    //   229: new 150	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   236: ldc 153
    //   238: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_0
    //   242: getfield 70	ahcs:Zd	J
    //   245: invokevirtual 160	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   248: ldc_w 313
    //   251: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: lload_1
    //   255: invokevirtual 160	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   258: ldc_w 315
    //   261: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: lload_1
    //   265: aload_0
    //   266: getfield 85	ahcs:nFileSize	J
    //   269: ldiv
    //   270: l2i
    //   271: invokevirtual 318	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   274: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: aload_0
    //   281: monitorexit
    //   282: iload_3
    //   283: ireturn
    //   284: new 150	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   291: aload_0
    //   292: getfield 81	ahcs:mUrl	Ljava/lang/String;
    //   295: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: ldc_w 320
    //   301: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: lload_1
    //   305: invokestatic 248	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   308: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: astore 4
    //   316: goto -231 -> 85
    //   319: aload 4
    //   321: invokevirtual 324	com/tencent/mobileqq/app/QQAppInterface:getHttpCommunicatort	()Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;
    //   324: aload 6
    //   326: invokevirtual 329	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Laqog;)I
    //   329: pop
    //   330: getstatic 41	ahcs:TAG	Ljava/lang/String;
    //   333: iconst_1
    //   334: new 150	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   341: ldc 153
    //   343: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload_0
    //   347: getfield 70	ahcs:Zd	J
    //   350: invokevirtual 160	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   353: ldc_w 331
    //   356: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: lload_1
    //   360: invokevirtual 160	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   363: ldc_w 315
    //   366: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: lload_1
    //   370: aload_0
    //   371: getfield 85	ahcs:nFileSize	J
    //   374: ldiv
    //   375: l2i
    //   376: invokevirtual 318	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   379: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: iconst_1
    //   386: istore_3
    //   387: goto -107 -> 280
    //   390: astore 4
    //   392: aload_0
    //   393: monitorexit
    //   394: aload 4
    //   396: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	ahcs
    //   0	397	1	paramLong	long
    //   1	386	3	bool	boolean
    //   83	237	4	localObject1	Object
    //   390	5	4	localObject2	Object
    //   33	101	5	str	String
    //   97	228	6	localaqog	aqog
    // Exception table:
    //   from	to	target	type
    //   4	85	390	finally
    //   85	99	390	finally
    //   103	113	390	finally
    //   118	166	390	finally
    //   166	220	390	finally
    //   225	280	390	finally
    //   284	316	390	finally
    //   319	385	390	finally
  }
  
  private void dmr()
  {
    try
    {
      setStatus(cZo);
      dms();
      amR();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void dms()
  {
    aqog localaqog = a();
    if (localaqog != null)
    {
      QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "]. stopHttpRequest");
      b(null);
      QQAppInterface localQQAppInterface = aglz.a().getApp();
      if (localQQAppInterface == null)
      {
        QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. stopHttpRequest failed.APP=null");
        return;
      }
      localQQAppInterface.getHttpCommunicatort().f(localaqog);
      return;
    }
    QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "]. stopHttpRequest: no request");
  }
  
  private long getDownloadSize()
  {
    synchronized (this.dP)
    {
      long l = this.YD;
      return l;
    }
  }
  
  private int getStatus()
  {
    int i = cZo;
    synchronized (this.dU)
    {
      i = this.mStatus;
      return i;
    }
  }
  
  private boolean isStop()
  {
    return cZo == getStatus();
  }
  
  private boolean m(byte[] paramArrayOfByte)
  {
    synchronized (this.dW)
    {
      try
      {
        if (this.jdField_e_of_type_JavaIoOutputStream == null)
        {
          QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. writeFileStream: stream = null:");
          return false;
        }
        this.jdField_e_of_type_JavaIoOutputStream.write(paramArrayOfByte);
        return true;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return false;
      }
    }
  }
  
  private void setDownloadSize(long paramLong)
  {
    synchronized (this.dP)
    {
      this.YD = paramLong;
      return;
    }
  }
  
  private void setStatus(int paramInt)
  {
    synchronized (this.dU)
    {
      QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "]. setStatus: " + this.mStatus + " -> " + paramInt);
      this.mStatus = paramInt;
      return;
    }
  }
  
  public void Hp(String paramString) {}
  
  public void a(aqog paramaqog1, aqog paramaqog2)
  {
    if (isStop()) {
      QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. decode. but had stoped");
    }
    int i;
    do
    {
      long l1;
      do
      {
        for (;;)
        {
          return;
          try
          {
            if ((paramaqog2.getResponseCode() == 206) || (paramaqog2.getResponseCode() == 200)) {
              if (!m(paramaqog2.aB()))
              {
                i = 3;
                paramaqog1 = ahcj.em(3);
                l1 = 0L;
                if (aqfo.isExistSDCard()) {
                  l1 = aqfo.getSDCardAvailableSize() * 1024L;
                }
                if (l1 < this.nFileSize - getDownloadSize())
                {
                  QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "] write file failed. sd card space is no enough:[" + this.nFileSize + " " + getDownloadSize() + " " + l1 + "]");
                  i = 9;
                  paramaqog1 = ahcj.em(9);
                }
                N(i, paramaqog1, paramaqog1);
                return;
              }
            }
          }
          catch (Exception paramaqog1)
          {
            paramaqog1.printStackTrace();
            paramaqog1 = ahcj.em(12);
            N(12, paramaqog1, paramaqog1);
            return;
          }
        }
        l1 = getDownloadSize() + paramaqog2.aB().length;
        long l2 = paramaqog2.hR();
        if (this.nFileSize != l2) {
          this.nFileSize = l2;
        }
        setDownloadSize(l1);
        this.YF += paramaqog2.aB().length;
        if (l1 < this.nFileSize) {
          break;
        }
        if (!amR())
        {
          QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "].closeFileStream falied.path=" + this.mFilePath);
          paramaqog1 = ahcj.em(4);
          N(4, paramaqog1, paramaqog1);
          return;
        }
        QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "].decode >>>>>>>. SUCESSFUL!!!");
        paramaqog1 = a();
      } while (paramaqog1 == null);
      paramaqog2 = new Bundle();
      paramaqog2.putLong("EXT_TRANS_SIZE ", this.YD);
      paramaqog2.putLong("EXT_TTRANS_SIZE ", this.YF);
      paramaqog2.putInt("EXT_AUTOTRY_COUNT", this.cXr);
      paramaqog1.a(this.mFilePath, this.nFileSize, paramaqog2);
      return;
      i = (int)((float)l1 / (float)this.nFileSize * 100.0F);
      paramaqog1 = a();
    } while (paramaqog1 == null);
    paramaqog1.q(i, null);
  }
  
  public boolean a(aqog paramaqog1, aqog paramaqog2, int paramInt)
  {
    QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "]. HttpCommunicator statusChanged. status:" + paramInt);
    if ((5 == paramInt) && (getDownloadSize() < this.nFileSize))
    {
      dmr();
      paramaqog1 = ahcj.em(14);
      QQAppInterface localQQAppInterface = aglz.a().getApp();
      if (localQQAppInterface == null) {
        break label226;
      }
      ahav.a(localQQAppInterface, this.Zd, "actFileUfGenDownload", this.startTime, "", "", "", "", 14, paramaqog1, this.YF, this.YD, this.nFileSize, paramaqog2.getRealUrl(), paramaqog2.cuw, this.cXr, paramaqog1, null);
      ahav.a(localQQAppInterface, this.Zd, "actFileUfGenDownloadDetail", this.startTime, "", "", "", "", 14, paramaqog1, this.YF, this.YD, this.nFileSize, paramaqog2.getRealUrl(), paramaqog2.cuw, this.cXr, paramaqog1, null);
      anpb.F(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
    }
    for (;;)
    {
      paramaqog1 = a();
      if (paramaqog1 != null) {
        paramaqog1.b(14, "downloader fialed", null);
      }
      return true;
      label226:
      QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "].report failed - 2");
    }
  }
  
  public void b(aqog paramaqog1, aqog paramaqog2)
  {
    if (isStop())
    {
      QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "]. handleError..user puase");
      return;
    }
    if (paramaqog2 == null)
    {
      QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. handleError.. response=NULL:");
      dmr();
      paramaqog1 = ahcj.em(5);
      paramaqog2 = aglz.a().getApp();
      if (paramaqog2 != null)
      {
        ahav.a(paramaqog2, this.Zd, "actFileUfGenDownload", this.startTime, "", "", "", "", 5, paramaqog1, this.YF, this.YD, this.nFileSize, this.mUrl, "", 0, paramaqog1, null);
        ahav.a(paramaqog2, this.Zd, "actFileUfGenDownloadDetail", this.startTime, "", "", "", "", 5, paramaqog1, this.YF, this.YD, this.nFileSize, this.mUrl, "", 0, paramaqog1, null);
        anpb.F(paramaqog2.getApplication().getApplicationContext(), paramaqog2.getCurrentAccountUin(), "Stop_download_2-0_3-1");
      }
      for (;;)
      {
        paramaqog2 = a();
        if (paramaqog2 == null) {
          break;
        }
        paramaqog2.b(5, paramaqog1, null);
        return;
        QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "].report failed - 111");
      }
    }
    Object localObject2 = paramaqog2.getErrorString();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. handleError.. errString:" + (String)localObject1);
    if (cZp == getStatus())
    {
      QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "]. handleError.. slience pause. may app destroy!!");
      amR();
      return;
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      dmr();
      paramaqog1 = ahcj.em(2);
      paramaqog2 = aglz.a().getApp();
      if (paramaqog2 != null)
      {
        ahav.a(paramaqog2, this.Zd, "actFileUfGenDownload", this.startTime, "", "", "", "", 2, paramaqog1, this.YF, this.YD, this.nFileSize, this.mUrl, "", 0, paramaqog1, null);
        ahav.a(paramaqog2, this.Zd, "actFileUfGenDownloadDetail", this.startTime, "", "", "", "", 2, paramaqog1, this.YF, this.YD, this.nFileSize, this.mUrl, "", 0, paramaqog1, null);
        anpb.F(paramaqog2.getApplication().getApplicationContext(), paramaqog2.getCurrentAccountUin(), "Stop_download_2-0_3-1");
      }
      for (;;)
      {
        paramaqog2 = a();
        if (paramaqog2 == null) {
          break;
        }
        paramaqog2.b(2, paramaqog1, null);
        return;
        QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "].report failed - 11");
      }
    }
    long l = paramaqog2.errCode;
    int i = paramaqog2.Mk();
    localObject1 = paramaqog2.getErrorString();
    if ((a(paramaqog1, paramaqog2)) && (this.cXr < 3))
    {
      this.cXr += 1;
      if ((this.cXs < 3) && (paramaqog2.errCode == 9056))
      {
        this.cXs += 1;
        this.cXr -= 1;
        label655:
        QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "]. handleError. auto retry to download. autoRetry=" + this.cXr + " eofRetry=" + this.cXs);
        dms();
        if (ci(getDownloadSize())) {
          break label995;
        }
        QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. auto retry dowload failed.");
        localObject1 = ahcj.em((int)13L);
        paramaqog1 = (aqog)localObject1;
        l = 13L;
      }
    }
    for (;;)
    {
      this.cXr = 0;
      this.cXs = 0;
      dmr();
      localObject2 = aglz.a().getApp();
      if (localObject2 != null)
      {
        if (13L == l) {
          break label1179;
        }
        l = 11L;
        localObject1 = ahcj.em((int)11L);
        paramaqog1 = (aqog)localObject1;
      }
      label1179:
      for (;;)
      {
        ahav.a((QQAppInterface)localObject2, this.Zd, "actFileUfGenDownload", this.startTime, "", "", "", "", l, paramaqog1, this.YF, this.YD, this.nFileSize, paramaqog2.getRealUrl(), paramaqog2.cuw, this.cXr, (String)localObject1, null);
        ahav.a((QQAppInterface)localObject2, this.Zd, "actFileUfGenDownloadDetail", this.startTime, "", "", "", "", paramaqog2.errCode, String.valueOf(paramaqog2.Mk()), this.YF, this.YD, this.nFileSize, paramaqog2.getRealUrl(), paramaqog2.cuw, this.cXr, paramaqog2.getErrorString(), null);
        anpb.F(((QQAppInterface)localObject2).getApplication().getApplicationContext(), ((QQAppInterface)localObject2).getCurrentAccountUin(), "Stop_download_2-0_3-1");
        for (;;)
        {
          paramaqog1 = a();
          if (paramaqog1 == null) {
            break;
          }
          paramaqog1.b(6, "downloader fialed", null);
          return;
          this.cXs = 0;
          break label655;
          label995:
          QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "]. auto retry dowload started.");
          paramaqog1 = aglz.a().getApp();
          if (paramaqog1 != null)
          {
            ahav.a(paramaqog1, this.Zd, "actFileUfGenDownloadDetail", this.startTime, "", "", "", "", paramaqog2.errCode, String.valueOf(paramaqog2.Mk()), this.YF, this.YD, this.nFileSize, paramaqog2.getRealUrl(), paramaqog2.cuw, this.cXr, paramaqog2.getErrorString(), null);
            return;
          }
          QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "].report failed - 1");
          return;
          QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "].report failed - 2");
        }
      }
      paramaqog1 = String.valueOf(i);
    }
  }
  
  public void dmt()
  {
    setStatus(cZp);
  }
  
  public void stop()
  {
    dmr();
    a(null);
  }
  
  public boolean u(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. start failed. filepath = null. POS:" + paramLong);
      return false;
    }
    if (cZn == getStatus())
    {
      QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "]. start. is runing. POS:" + paramLong);
      return true;
    }
    this.mFilePath = paramString;
    if (!amQ())
    {
      QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "]. start failed. openFileStream failed. POS:" + paramLong);
      paramString = ahcj.em(8);
      N(8, paramString, paramString);
      return false;
    }
    if (!ci(paramLong))
    {
      QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. start download failed. POS:" + paramLong);
      paramString = ahcj.em(6);
      N(6, paramString, paramString);
      return false;
    }
    setStatus(cZn);
    this.startTime = System.currentTimeMillis();
    QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "]. start to run download . POS:" + paramLong);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahcs
 * JD-Core Version:    0.7.0.1
 */