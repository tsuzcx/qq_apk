package com.tencent.qqmail.utilities.osslog;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.deviceid.DeviceInfo;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMFileEntity;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest.QMHttpMethod;
import com.tencent.qqmail.utilities.thread.QMSchedulers;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import moai.io.Files;
import moai.io.Sdcards;
import rx.Observable;

public class CovFileClient
{
  private static final String OS = Build.BRAND + "_" + Build.MODEL + "__" + Build.VERSION.RELEASE + "&&" + BrandUtil.getRom();
  private static final String TAG = "CovFileClient";
  private static final String URL = "https://oss.mail.qq.com/cgi-bin/log_upload?inputc=utf-8&outputc=utf-8&func=PerformanceLogSaveLocal";
  private static final String USER_AGENT = "QQMail/" + VERSION + " " + System.getProperty("http.agent");
  private static final String VERSION = AppConfig.getCodeVersion();
  private static CovFileClient sInstance = new CovFileClient();
  private JSONObject mBaseInfoJson;
  private HashMap<String, String> mHeaders;
  
  private void UploadTask()
  {
    QMLog.log(4, "CovFileClient", "start to upload covtest ");
    Object localObject1 = getCovLogPath();
    String str = getNewCovPath(String.valueOf(AppConfig.getSystemVersionCode()));
    if ((!Files.isFileExist((String)localObject1)) || (Files.getFileSize((String)localObject1) <= 0L)) {
      QMLog.log(4, "CovFileClient", "cov file not exists ");
    }
    for (;;)
    {
      localObject1 = new File(str);
      str = getFileName(str);
      QMLog.log(4, "CovFileClient", "upload covtest file " + str);
      Object localObject2 = Lists.newArrayList();
      ((List)localObject2).add(new QMFileEntity((File)localObject1, "application/octet-stream", str));
      Observable.just(buildRequest(getBaseInfo(), (List)localObject2)).observeOn(QMSchedulers.network()).flatMap(new CovFileClient.4(this)).onErrorReturn(new CovFileClient.3(this)).observeOn(QMSchedulers.io()).map(new CovFileClient.2(this)).map(new CovFileClient.1(this)).subscribe();
      return;
      QMLog.log(4, "CovFileClient", "cov file revision: " + str);
      if ((!Files.isFileExist(str)) || (Files.getFileSize(str) <= 0L))
      {
        localObject2 = new File(str);
        new File((String)localObject1).renameTo((File)localObject2);
      }
    }
  }
  
  private QMNetworkRequest buildRequest(String paramString, List<QMFileEntity> paramList)
  {
    QMNetworkRequest localQMNetworkRequest = new QMNetworkRequest("https://oss.mail.qq.com/cgi-bin/log_upload?inputc=utf-8&outputc=utf-8&func=PerformanceLogSaveLocal", QMNetworkRequest.QMHttpMethod.QMHttpMethod_MULTIPART);
    localQMNetworkRequest.setRequestParams(paramString);
    localQMNetworkRequest.setFileParams(paramList);
    localQMNetworkRequest.setMultiPartCustomName("UploadFile");
    return localQMNetworkRequest;
  }
  
  private String getBaseInfo()
  {
    try
    {
      String str1 = ((QQMailAccount)AccountManager.shareInstance().getAccountList().getDefaultMailAccount()).getSid();
      String str3 = "" + "appid=1&appversion=" + VERSION + "&authtpe=1&channelid=0&device=" + Build.BRAND + "_" + Build.MODEL;
      str1 = str3 + "&deviceid=" + DeviceUtil.getDeviceInfos().DEVICE_ID + "&imei=" + DeviceUtil.getDeviceInfos().IMEI + "&os=" + OS + "&platform=1&sid=" + str1;
      return str1 + "&vid=" + QMApplicationContext.sharedInstance().getVid() + "&devicename=android&clitime=" + nowSeconds();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "CovFileClient", localException.toString());
        String str2 = "";
      }
    }
  }
  
  private JSONObject getBaseInfoLocked()
  {
    try
    {
      String str1 = ((QQMailAccount)AccountManager.shareInstance().getAccountList().getDefaultMailAccount()).getSid();
      if (this.mBaseInfoJson == null)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("appid", Integer.valueOf(1));
        localJSONObject.put("appversion", VERSION);
        localJSONObject.put("authtype", Integer.valueOf(1));
        localJSONObject.put("channelid", Integer.valueOf(0));
        localJSONObject.put("device", Build.BRAND + "_" + Build.MODEL);
        localJSONObject.put("deviceid", DeviceUtil.getDeviceInfos().DEVICE_ID);
        localJSONObject.put("imei", DeviceUtil.getDeviceInfos().IMEI);
        localJSONObject.put("os", OS);
        localJSONObject.put("platform", Integer.valueOf(1));
        localJSONObject.put("sid", str1);
        localJSONObject.put("vid", Long.valueOf(QMApplicationContext.sharedInstance().getVid()));
        localJSONObject.put("devicename", "android");
        this.mBaseInfoJson = localJSONObject;
      }
      this.mBaseInfoJson.put("clitime", Long.valueOf(nowSeconds()));
      this.mBaseInfoJson.put("vid", Long.valueOf(QMApplicationContext.sharedInstance().getVid()));
      return this.mBaseInfoJson;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "CovFileClient", localException.toString());
        String str2 = "";
      }
    }
  }
  
  private byte[] getContent(String paramString)
    throws IOException
  {
    paramString = new File(paramString);
    long l = paramString.length();
    if (l > 2147483647L)
    {
      System.out.println("file too big...");
      return null;
    }
    FileInputStream localFileInputStream = new FileInputStream(paramString);
    byte[] arrayOfByte = new byte[(int)l];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      int j = localFileInputStream.read(arrayOfByte, i, arrayOfByte.length - i);
      if (j < 0) {
        break;
      }
      i += j;
    }
    if (i != arrayOfByte.length) {
      throw new IOException("Could not completely read file " + paramString.getName());
    }
    localFileInputStream.close();
    return arrayOfByte;
  }
  
  public static String getCovLogPath()
  {
    Object localObject2;
    if (FileUtil.hasSdcard())
    {
      localObject1 = Environment.getExternalStorageDirectory();
      localObject1 = ((File)localObject1).getAbsolutePath() + File.separator + "cov.txt";
      localObject2 = new File((String)localObject1);
      if (localObject2 != null) {}
    }
    for (Object localObject1 = ((File)localObject2).getAbsolutePath() + File.separator + "sdcard" + File.separator + "tencent" + File.separator + "cov.txt";; localObject1 = QMApplicationContext.sharedInstance().getApplicationInfo().dataDir + "/cov.txt")
    {
      localObject2 = localObject1;
      if (!new File((String)localObject1).exists()) {
        localObject2 = "";
      }
      return localObject2;
    }
  }
  
  private String getFileName(String paramString)
  {
    int i = paramString.lastIndexOf("/");
    int j = paramString.lastIndexOf(".");
    if ((i != -1) && (j != -1)) {
      return paramString.substring(i + 1, j);
    }
    return null;
  }
  
  public static CovFileClient getInstance()
  {
    return sInstance;
  }
  
  private static String getNewCovPath(String paramString)
  {
    String str = String.valueOf(System.currentTimeMillis() / 1000L);
    if (Sdcards.hasSdcard())
    {
      File localFile = Environment.getExternalStorageDirectory();
      return localFile.getAbsolutePath() + File.separator + paramString + "_" + str + "_" + "cov.txt";
    }
    return QMApplicationContext.sharedInstance().getApplicationInfo().dataDir + File.separator + paramString + "_" + str + "_" + "cov.txt";
  }
  
  private long nowSeconds()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  public void submit()
  {
    String str = getCovLogPath();
    if (!TextUtils.isEmpty(str))
    {
      QMLog.log(4, "CovFileClient", "覆盖率文件路径 " + str);
      getInstance().UploadTask();
      return;
    }
    QMLog.log(5, "CovFileClient", "没有覆盖率文件 ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.osslog.CovFileClient
 * JD-Core Version:    0.7.0.1
 */