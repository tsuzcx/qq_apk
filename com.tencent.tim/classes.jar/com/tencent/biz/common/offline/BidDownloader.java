package com.tencent.biz.common.offline;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import aqhq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import jox;
import joz;
import jpa;
import jpe;
import jpk;
import jpl;
import jpn;
import jqi;
import jql;
import jqo;
import jqp;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class BidDownloader
  implements Handler.Callback
{
  public static String TAG = "BidDownloader";
  public static WifiListener a;
  public static jpk a;
  public static jpl a;
  public static boolean aaZ;
  public static HashMap<String, Integer> cO;
  public static ArrayList<BidDownloader> jk;
  public static Context mContext;
  public String TM;
  public jox a;
  public int aCy;
  public boolean aaT = true;
  public boolean aaU;
  public boolean aaV;
  public boolean aaW;
  public boolean aaX;
  public boolean aaY;
  public jox b;
  public int failCount;
  public String mBusinessId;
  public int mType;
  public Handler mUiHandler;
  public String url;
  public int ver;
  
  static
  {
    jdField_a_of_type_Jpl = new jql();
    jdField_a_of_type_Jpk = new jpn();
  }
  
  public BidDownloader(String paramString, AppRuntime paramAppRuntime, jox paramjox, boolean paramBoolean, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (jk == null)
    {
      jk = new ArrayList();
      cO = new HashMap();
      jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader$WifiListener = new WifiListener();
    }
    this.jdField_a_of_type_Jox = paramjox;
    mContext = paramAppRuntime.getApplication().getApplicationContext();
    this.mBusinessId = paramString;
    this.aaT = paramBoolean;
    if (paramInt == 1)
    {
      this.aaU = true;
      paramString = jpe.dP(this.mBusinessId);
      if (!TextUtils.isEmpty(paramString))
      {
        if (!this.aaX) {
          break label205;
        }
        this.TM = (paramString + this.mBusinessId + ".7z");
      }
    }
    for (;;)
    {
      this.mUiHandler = new Handler(Looper.getMainLooper(), this);
      this.mType = 0;
      return;
      if (paramInt == 3)
      {
        this.aaW = true;
        break;
      }
      if (paramInt == 4)
      {
        this.aaX = true;
        break;
      }
      if (paramInt != 2) {
        break;
      }
      this.aaV = true;
      break;
      label205:
      if ((this.aaW) || (this.aaV))
      {
        this.TM = (paramString + this.mBusinessId + ".zip");
      }
      else
      {
        QLog.e(TAG, 1, "do not know what format, use default zip name!");
        this.TM = (paramString + this.mBusinessId + ".zip");
      }
    }
  }
  
  private void ayR()
  {
    if (isDownloading(this.mBusinessId)) {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, this.mBusinessId + " is downloading");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, this.mBusinessId + "download");
      }
      if (cO.size() < 1) {
        break;
      }
      a(this);
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, cO + "," + this.mBusinessId + "add to queue");
    return;
    jpa.aC(mContext.getApplicationContext(), this.mBusinessId);
    ayQ();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, this.mBusinessId + this.url + this.b);
    }
    kZ(this.mBusinessId);
  }
  
  public static boolean cS(int paramInt)
  {
    return (paramInt == 0) || (paramInt == -1);
  }
  
  private void ch(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Jox != null) {
      this.jdField_a_of_type_Jox.loaded(null, paramInt1);
    }
  }
  
  /* Error */
  public static String dK(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +8 -> 12
    //   7: ldc 222
    //   9: astore_2
    //   10: aload_2
    //   11: areturn
    //   12: new 224	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 226	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: invokevirtual 229	java/io/File:exists	()Z
    //   25: ifne +38 -> 63
    //   28: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +29 -> 60
    //   34: getstatic 61	com/tencent/biz/common/offline/BidDownloader:TAG	Ljava/lang/String;
    //   37: iconst_2
    //   38: new 115	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   45: ldc 231
    //   47: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_0
    //   51: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: ldc 222
    //   62: areturn
    //   63: ldc 222
    //   65: astore 4
    //   67: new 233	java/io/RandomAccessFile
    //   70: dup
    //   71: aload_2
    //   72: ldc 235
    //   74: invokespecial 238	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   77: astore_3
    //   78: aload_3
    //   79: astore_2
    //   80: aload_3
    //   81: lconst_0
    //   82: invokevirtual 242	java/io/RandomAccessFile:seek	(J)V
    //   85: aload_3
    //   86: astore_2
    //   87: aload_3
    //   88: invokevirtual 245	java/io/RandomAccessFile:readInt	()I
    //   91: invokestatic 251	java/lang/Integer:reverseBytes	(I)I
    //   94: istore_1
    //   95: iload_1
    //   96: i2l
    //   97: ldc2_w 252
    //   100: lcmp
    //   101: ifne +21 -> 122
    //   104: ldc 255
    //   106: astore_0
    //   107: aload_0
    //   108: astore_2
    //   109: aload_3
    //   110: ifnull -100 -> 10
    //   113: aload_3
    //   114: invokevirtual 258	java/io/RandomAccessFile:close	()V
    //   117: aload_0
    //   118: areturn
    //   119: astore_2
    //   120: aload_0
    //   121: areturn
    //   122: aload 4
    //   124: astore_0
    //   125: iload_1
    //   126: i2l
    //   127: ldc2_w 259
    //   130: lcmp
    //   131: ifne -24 -> 107
    //   134: ldc_w 262
    //   137: astore_0
    //   138: goto -31 -> 107
    //   141: astore 5
    //   143: aconst_null
    //   144: astore_3
    //   145: aload_3
    //   146: astore_2
    //   147: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +34 -> 184
    //   153: aload_3
    //   154: astore_2
    //   155: getstatic 61	com/tencent/biz/common/offline/BidDownloader:TAG	Ljava/lang/String;
    //   158: iconst_2
    //   159: new 115	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   166: ldc_w 264
    //   169: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_0
    //   173: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: aload 5
    //   181: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   184: aload 4
    //   186: astore_2
    //   187: aload_3
    //   188: ifnull -178 -> 10
    //   191: aload_3
    //   192: invokevirtual 258	java/io/RandomAccessFile:close	()V
    //   195: ldc 222
    //   197: areturn
    //   198: astore_0
    //   199: ldc 222
    //   201: areturn
    //   202: astore_0
    //   203: aconst_null
    //   204: astore_2
    //   205: aload_2
    //   206: ifnull +7 -> 213
    //   209: aload_2
    //   210: invokevirtual 258	java/io/RandomAccessFile:close	()V
    //   213: aload_0
    //   214: athrow
    //   215: astore_2
    //   216: goto -3 -> 213
    //   219: astore_0
    //   220: goto -15 -> 205
    //   223: astore 5
    //   225: goto -80 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	paramString	String
    //   94	32	1	i	int
    //   9	100	2	localObject1	Object
    //   119	1	2	localException1	java.lang.Exception
    //   146	64	2	localObject2	Object
    //   215	1	2	localException2	java.lang.Exception
    //   77	115	3	localRandomAccessFile	java.io.RandomAccessFile
    //   65	120	4	str	String
    //   141	39	5	localException3	java.lang.Exception
    //   223	1	5	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   113	117	119	java/lang/Exception
    //   67	78	141	java/lang/Exception
    //   191	195	198	java/lang/Exception
    //   67	78	202	finally
    //   209	213	215	java/lang/Exception
    //   80	85	219	finally
    //   87	95	219	finally
    //   147	153	219	finally
    //   155	184	219	finally
    //   80	85	223	java/lang/Exception
    //   87	95	223	java/lang/Exception
  }
  
  public static boolean isDownloading(String paramString)
  {
    if (cO == null) {}
    while (cO.get(paramString) == null) {
      return false;
    }
    return true;
  }
  
  public static void kZ(String paramString)
  {
    if (cO == null) {
      cO = new HashMap();
    }
    if (cO.get(paramString) == null)
    {
      cO.put(paramString, Integer.valueOf(1));
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "addDownloadingState:" + paramString);
      }
    }
  }
  
  public static void la(String paramString)
  {
    if (cO == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (cO.get(paramString) != null)
          {
            cO.remove(paramString);
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "removeDownloadingState:" + paramString);
            }
          }
        } while ((jk == null) || (jk.isEmpty()));
        paramString = (BidDownloader)jk.get(0);
      } while (mContext == null);
      if ((paramString.aaY) && (jqi.getNetworkType(mContext) != 1) && (!aaZ))
      {
        paramString = new IntentFilter();
        paramString.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        mContext.registerReceiver(jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader$WifiListener, paramString);
        aaZ = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "start download from queue:" + paramString.mBusinessId);
      }
      paramString.download();
      jk.remove(0);
    } while ((!aaZ) || (jk.size() != 0));
    mContext.unregisterReceiver(jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader$WifiListener);
    aaZ = false;
  }
  
  protected static void resumeDownload()
  {
    if ((cO.size() == 0) && (jk != null) && (!jk.isEmpty()))
    {
      BidDownloader localBidDownloader = (BidDownloader)jk.remove(0);
      if (mContext != null) {
        localBidDownloader.download();
      }
    }
  }
  
  protected void a(BidDownloader paramBidDownloader)
  {
    int j = jk.size();
    int i = 0;
    while (i < j)
    {
      BidDownloader localBidDownloader = (BidDownloader)jk.get(i);
      if (paramBidDownloader.mBusinessId.equals(localBidDownloader.mBusinessId)) {
        return;
      }
      i += 1;
    }
    jk.add(paramBidDownloader);
  }
  
  public void ayQ()
  {
    jdField_a_of_type_Jpl.runOnSubThread(new BidDownloader.2(this));
  }
  
  public void download()
  {
    if (isDownloading(this.mBusinessId))
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, this.mBusinessId + " is downloading");
      }
      return;
    }
    jdField_a_of_type_Jpl.runOnSubThread(new BidDownloader.4(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      la(this.mBusinessId);
      continue;
      download();
      continue;
      ch(paramMessage.arg1, paramMessage.arg2);
      continue;
      ayR();
    }
  }
  
  @TargetApi(11)
  public boolean yh()
  {
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(this.TM)) {
      return false;
    }
    this.b = new joz(this, l);
    this.mUiHandler.sendEmptyMessage(1);
    return true;
  }
  
  public boolean yi()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    String str4;
    boolean bool2;
    Object localObject1;
    try
    {
      String str1 = this.mBusinessId;
      str4 = this.TM;
      bool2 = TextUtils.isEmpty(str1);
      if (bool2) {
        bool2 = bool1;
      }
      for (;;)
      {
        return bool2;
        bool2 = bool1;
        if (!TextUtils.isEmpty(jpe.dP(str1)))
        {
          localObject1 = new File(str4);
          if (((File)localObject1).exists()) {
            break;
          }
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.i(TAG, 2, "doUnzipZip: no zip ! : businessId:" + str1);
            bool2 = bool1;
          }
        }
      }
      l = System.currentTimeMillis();
    }
    finally {}
    long l;
    String str3 = ((File)localObject1).getParent() + File.separator + str2;
    Object localObject2 = dK(str4);
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "fileFormat: " + (String)localObject2 + ", path: " + str4);
    }
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      if (((String)localObject2).equals("zip"))
      {
        i = jqp.unZipFolder(str4, str3);
        label229:
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "now delete original download offline zip, path: " + str4);
        }
        jqo.deleteFile(str4);
        if (i <= 0) {
          break label471;
        }
        jpa.a(str2, 13, 0L, i, "lixian_update", "0");
        bool1 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.i(TAG, 2, "unZipFolder fail!");
          bool1 = bool3;
        }
      }
    }
    label692:
    for (;;)
    {
      jqo.dn(str3);
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(TAG, 2, "time of unzip zip：" + (System.currentTimeMillis() - l) + ", isSuccess: " + bool1);
      bool2 = bool1;
      break;
      if (((String)localObject2).equals("7z"))
      {
        i = LzmaUtils.m(BaseApplicationImpl.getApplication().getApplicationContext(), str4, str3);
        break label229;
        QLog.w(TAG, 1, "can not recognize download compress file format, " + this.TM);
        if (this.aaW)
        {
          i = jqp.unZipFolder(str4, str3);
          break label229;
        }
        if (this.aaX)
        {
          i = LzmaUtils.m(BaseApplicationImpl.getApplication().getApplicationContext(), str4, str3);
          break label229;
          label471:
          str4 = str3 + File.separator + str2 + ".zip";
          localObject2 = new File(str4);
          localObject1 = ((File)localObject1).getParent() + File.separator + str2 + ".zip";
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "now move zip file to location: " + (String)localObject1);
          }
          if (((File)localObject2).exists())
          {
            bool2 = ((File)localObject2).renameTo(new File((String)localObject1));
            bool1 = bool2;
            if (!bool2) {
              bool1 = aqhq.moveFile(str4, (String)localObject1);
            }
            if (!bool1)
            {
              jpa.a(str2, 13, 0L, i, "lixian_update", "0");
              bool1 = false;
              break label692;
            }
            jpa.a(str2, 13, 0L, i, "lixian_time", "0");
            bool1 = true;
            break label692;
          }
          jpa.a(str2, 13, 0L, i, "lixian_update", "0");
          bool1 = bool3;
          continue;
        }
      }
      i = 1;
      break label229;
    }
  }
  
  public static class WifiListener
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (jqi.getNetworkType(paramContext) == 1) {
        BidDownloader.resumeDownload();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.common.offline.BidDownloader
 * JD-Core Version:    0.7.0.1
 */