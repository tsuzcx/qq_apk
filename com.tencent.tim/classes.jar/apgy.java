import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.homework.config.BeginnerGuideDownloadManager.1;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class apgy
{
  private String coV;
  private QQAppInterface mApp;
  private String mFileName;
  private String mUrl;
  
  public apgy(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    this.mApp = paramQQAppInterface;
    this.mUrl = paramString1;
    this.mFileName = paramString2;
    this.coV = paramString3;
    int i = j;
    if (!TextUtils.isEmpty(this.mFileName))
    {
      if (!TextUtils.isEmpty(this.coV)) {
        break label71;
      }
      i = j;
    }
    while (i != 0)
    {
      throw new IllegalArgumentException("args error");
      label71:
      i = j;
      if (qy(this.mUrl)) {
        i = 0;
      }
    }
  }
  
  private static File J()
  {
    return new File(acbn.SDCARD_PATH + "homework_troop");
  }
  
  private void a(Handler paramHandler, int paramInt, boolean paramBoolean)
  {
    ThreadManager.postImmediately(new BeginnerGuideDownloadManager.1(this, paramHandler, paramInt, paramBoolean), null, true);
    paramHandler.sendEmptyMessage(1111);
  }
  
  private boolean b(Handler paramHandler, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager.postDownload");
    }
    File localFile1 = J();
    File localFile2 = new File(localFile1, this.mFileName);
    Object localObject = this.mFileName.substring(0, this.mFileName.lastIndexOf("."));
    localFile1 = new File(localFile1, (String)localObject + "_src");
    if ((!localFile1.exists()) && (!localFile1.mkdirs()))
    {
      paramHandler.sendEmptyMessage(1120);
      return false;
    }
    localObject = new ArrayList();
    String[] arrayOfString = localFile1.list();
    String str = localFile1.getAbsolutePath();
    Message localMessage = Message.obtain();
    localMessage.what = 1110;
    localMessage.arg1 = paramInt;
    localMessage.obj = str;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager.postDownload begin unzip");
      }
      ((ArrayList)localObject).addAll(jqp.a(localFile2));
      if (Arrays.asList(arrayOfString).containsAll((Collection)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BeginnerGuideDownloadManager", 2, "zip file already unzip");
        }
        x(str, paramInt, paramBoolean);
        paramHandler.sendMessage(localMessage);
        return true;
      }
      jqp.k(localFile2.getAbsolutePath(), localFile1.getAbsolutePath());
      if (Arrays.asList(localFile1.list()).containsAll((Collection)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BeginnerGuideDownloadManager", 2, "zip file unzip success");
        }
        x(str, paramInt, paramBoolean);
        paramHandler.sendMessage(localMessage);
        return true;
      }
      throw new Exception("trigger catch");
    }
    catch (Exception localException)
    {
      paramHandler.sendEmptyMessage(1120);
      if (QLog.isColorLevel()) {
        QLog.d("BeginnerGuideDownloadManager", 2, "zip file unzip error ", localException);
      }
      paramHandler = ((ArrayList)localObject).iterator();
      while (paramHandler.hasNext())
      {
        File localFile3 = new File(localFile1, (String)paramHandler.next());
        if ((localFile3.exists()) && (!localFile3.delete()) && (QLog.isColorLevel())) {
          QLog.d("BeginnerGuideDownloadManager", 2, "zip file unzip del error");
        }
      }
    }
    return false;
  }
  
  private static String calcMD5(String paramString)
  {
    long l = System.currentTimeMillis();
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      paramString = str1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        paramString = new File(paramString);
        if (!paramString.exists()) {
          break;
        }
        try
        {
          String str2 = aszr.getFileMD5String(paramString);
          paramString = str2;
          if (str2 == null) {
            paramString = "";
          }
        }
        catch (IOException paramString)
        {
          paramString = "";
        }
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = "";
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideDownloadManager", 2, new Object[] { "BeginnerGuideDownloadManager$calcMD5", " md5:" + paramString + ", cost:" + (System.currentTimeMillis() - l) });
    }
    return paramString;
  }
  
  private boolean qy(String paramString)
  {
    try
    {
      new URL(paramString);
      return true;
    }
    catch (MalformedURLException paramString) {}
    return false;
  }
  
  private void x(String paramString, int paramInt, boolean paramBoolean)
  {
    label168:
    label201:
    for (;;)
    {
      TroopManager localTroopManager;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager.parseConfig");
        }
        localTroopManager = (TroopManager)this.mApp.getManager(52);
        paramString = apgz.a(paramString, "config.cfg");
        if (!paramBoolean) {
          break label168;
        }
        switch (paramInt)
        {
        case 5: 
        case 6: 
          if (QLog.isColorLevel()) {
            QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager.parseConfig Publish not match");
          }
          label91:
          return;
        }
      }
      finally {}
      localTroopManager.a.a = paramString;
      continue;
      localTroopManager.a.b = paramString;
      continue;
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label201;
        }
        QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager.parseConfig Submit not match");
        break label91;
        localTroopManager.a.c = paramString;
        break label91;
        localTroopManager.a.d = paramString;
        break label91;
        break;
        switch (paramInt)
        {
        }
      }
    }
  }
  
  public boolean a(Handler paramHandler, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager.startDownload");
    }
    File localFile = J();
    if ((!localFile.exists()) && (!localFile.mkdirs())) {
      return false;
    }
    localFile = new File(localFile, this.mFileName);
    if ((localFile.exists()) && (this.coV.equalsIgnoreCase(calcMD5(localFile.getAbsolutePath()))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager.startDownload: file exists, no need to start download again");
      }
      a(paramHandler, paramInt, paramBoolean);
      return true;
    }
    aolm localaolm = this.mApp.getNetEngine(0);
    aoll localaoll = new aoll();
    localaoll.cMG = true;
    localaoll.cMK = true;
    localaoll.f = new apgy.a(paramHandler, paramInt, paramBoolean);
    localaoll.mHttpMethod = 0;
    localaoll.bZ = this.mUrl;
    localaoll.atY = localFile.getAbsolutePath();
    localaoll.dPo = 0;
    localaolm.a(localaoll);
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager.startDownload sendReq success");
    }
    return true;
  }
  
  class a
    implements aolm.b
  {
    private boolean aMH;
    private int dUh;
    private Handler mHandler;
    
    a(Handler paramHandler, int paramInt, boolean paramBoolean)
    {
      this.mHandler = paramHandler;
      this.dUh = paramInt;
      this.aMH = paramBoolean;
    }
    
    public void onResp(aomh paramaomh)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener onResp: " + paramaomh.mResult + ", desc: " + paramaomh.clO);
      }
      if (paramaomh.mResult == 3) {
        return;
      }
      if (paramaomh.mResult == 0)
      {
        paramaomh = apgy.calcMD5(paramaomh.b.atY);
        if (apgy.a(apgy.this).equalsIgnoreCase(paramaomh))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener download success");
          }
          apgy.a(apgy.this, this.mHandler, this.dUh, this.aMH);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener download success, md5 check failed");
        }
        this.mHandler.sendEmptyMessage(1112);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener onResp error");
      }
      this.mHandler.sendEmptyMessage(1113);
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener Dowloading " + paramLong1 + "/" + paramLong2 + " " + 100L * paramLong1 / paramLong2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apgy
 * JD-Core Version:    0.7.0.1
 */