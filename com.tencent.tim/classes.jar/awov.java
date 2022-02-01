import android.app.Application;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.AppInfo;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.UploadServerInfoCallback;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadFile.UploadBatch;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.transmission.upload.UploadType;
import cooperation.weiyun.TransmissionHelper.5;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskPicBackupReq;
import cooperation.weiyun.channel.pb.WeiyunPB.FileExtInfo;
import cooperation.weiyun.channel.pb.WeiyunPB.QqSdkFileUploadMsgReq;
import cooperation.weiyun.upload.WyUploadJob;
import mqq.app.AppRuntime;

public final class awov
{
  private static volatile boolean isInit;
  private static String sQua;
  
  public static void T(boolean paramBoolean, long paramLong)
  {
    WeiyunTransmissionStatus localWeiyunTransmissionStatus = WeiyunTransmissionStatus.getInstance();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localWeiyunTransmissionStatus.setLoginStatus(i, Long.toString(paramLong));
      awph.eEM();
      return;
    }
  }
  
  public static awpy a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString4))) {
      return null;
    }
    if (TextUtils.isEmpty(paramString3)) {
      paramString3 = "0";
    }
    for (;;)
    {
      return awpy.a(10, paramString1, paramString2, paramString3, paramLong, paramInt, BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramString4, paramString5);
    }
  }
  
  public static UploadFile a(String paramString, UploadFile.UploadBatch paramUploadBatch, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramUploadBatch == null) || (paramInt < 0)) {
      return null;
    }
    String str = Build.MODEL;
    paramString = UploadFile.createUploadFile(1, BaseApplicationImpl.getApplication().getRuntime().getAccount(), str, str, str, paramString, false, paramUploadBatch, paramInt);
    paramString.autoBackupFlag = false;
    return paramString;
  }
  
  public static void a(Application paramApplication, boolean paramBoolean)
  {
    if (isInit) {
      return;
    }
    WeiyunTransmissionGlobal.AppInfo localAppInfo = new WeiyunTransmissionGlobal.AppInfo(getQUA(), 1000269, "mobileqq", aonc.getVersionCode(), 0, "unknown");
    WeiyunTransmissionGlobal localWeiyunTransmissionGlobal = WeiyunTransmissionGlobal.getInstance();
    if (paramBoolean) {}
    for (String str = "weiyun_";; str = "qq_")
    {
      localWeiyunTransmissionGlobal.initTransmission(localAppInfo, paramApplication, new awov.a(str), awrj.a());
      WeiyunTransmissionGlobal.getInstance().getUploadManager().setSpareUploader(new WyUploadJob());
      WeiyunTransmissionStatus.getInstance().setTranOnlyWifi(0, true, BaseApplicationImpl.getApplication().getRuntime().getAccount());
      WeiyunTransmissionStatus.getInstance().setLoginStatus(0, BaseApplicationImpl.getApplication().getRuntime().getAccount());
      AppNetConnInfo.registerNetChangeReceiver(null, new awow());
      awqd.a().a(new awox(), paramApplication);
      awqd.a().b(new awoz());
      WeiyunTransmissionGlobal.getInstance().getUploadManager().addGlobalObserver(new awpa());
      isInit = true;
      return;
    }
  }
  
  public static void acV(int paramInt)
  {
    new Thread(new TransmissionHelper.5(paramInt)).start();
  }
  
  public static UploadFile b(String paramString, UploadFile.UploadBatch paramUploadBatch, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramUploadBatch == null) || (paramInt < 0)) {
      return null;
    }
    String[] arrayOfString = awph.ad();
    paramString = UploadFile.createUploadFile(0, BaseApplicationImpl.getApplication().getRuntime().getAccount(), "QQ", arrayOfString[1], arrayOfString[0], paramString, false, paramUploadBatch, paramInt);
    paramString.autoBackupFlag = false;
    return paramString;
  }
  
  private static String getQUA()
  {
    if (sQua == null) {
      sQua = "V1_AND_WY_VersionName_" + aonc.getVersionCode() + "_ChannelId_" + "B";
    }
    return sQua;
  }
  
  static class a
    implements WeiyunTransmissionGlobal.HostInterface
  {
    private final String cRV;
    
    a(String paramString)
    {
      this.cRV = paramString;
    }
    
    public void fetchUploadServerInfo(UploadFile paramUploadFile, UploadType paramUploadType, WeiyunTransmissionGlobal.UploadServerInfoCallback paramUploadServerInfoCallback)
    {
      if (paramUploadFile.cmdType == 1)
      {
        localObject = new WeiyunPB.DiskPicBackupReq();
        if (paramUploadFile.fileName != null) {
          ((WeiyunPB.DiskPicBackupReq)localObject).filename.set(paramUploadFile.fileName);
        }
        ((WeiyunPB.DiskPicBackupReq)localObject).file_exist_option.set(paramUploadType.ordinal());
        ((WeiyunPB.DiskPicBackupReq)localObject).upload_type.set(0);
        ((WeiyunPB.DiskPicBackupReq)localObject).auto_create_user.set(false);
        ((WeiyunPB.DiskPicBackupReq)localObject).auto_flag.set(paramUploadFile.autoBackupFlag);
        ((WeiyunPB.DiskPicBackupReq)localObject).backup_dir_name.set(Build.MODEL);
        if ((paramUploadFile.isCompress) && (!TextUtils.isEmpty(paramUploadFile.compressedPath)))
        {
          if (paramUploadFile.compressedSha != null) {
            ((WeiyunPB.DiskPicBackupReq)localObject).file_sha.set(awrh.d(paramUploadFile.compressedSha));
          }
          ((WeiyunPB.DiskPicBackupReq)localObject).file_size.set(paramUploadFile.compressedSize);
          ((WeiyunPB.DiskPicBackupReq)localObject).first_256k_crc.set((int)awrb.o(paramUploadFile.compressedPath, 262144L));
          if (!TextUtils.isEmpty(paramUploadFile.mimeType))
          {
            paramUploadType = new WeiyunPB.FileExtInfo();
            paramUploadType.take_time.set(paramUploadFile.takenTime);
            paramUploadType.latitude.set(paramUploadFile.latitude);
            paramUploadType.longitude.set(paramUploadFile.longitude);
            if (!paramUploadFile.mimeType.startsWith("image")) {
              break label311;
            }
            paramUploadType.group_id.set(1);
            ((WeiyunPB.DiskPicBackupReq)localObject).ext_info.set(paramUploadType);
          }
          awpx.a((WeiyunPB.DiskPicBackupReq)localObject, new awpb(this, paramUploadServerInfoCallback, paramUploadFile));
        }
      }
      label311:
      while (paramUploadFile.cmdType != 0) {
        for (;;)
        {
          return;
          if (paramUploadFile.sha != null) {
            ((WeiyunPB.DiskPicBackupReq)localObject).file_sha.set(awrh.d(paramUploadFile.sha));
          }
          ((WeiyunPB.DiskPicBackupReq)localObject).file_size.set(paramUploadFile.fileSize);
          ((WeiyunPB.DiskPicBackupReq)localObject).first_256k_crc.set((int)awrb.o(paramUploadFile.localPath, 262144L));
          continue;
          if (!paramUploadFile.mimeType.startsWith("video")) {}
        }
      }
      Object localObject = new WeiyunPB.QqSdkFileUploadMsgReq();
      if (paramUploadFile.fileName != null) {
        ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).filename.set(paramUploadFile.fileName);
      }
      ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).file_exist_option.set(paramUploadType.ordinal());
      ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).upload_type.set(0);
      ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).auto_create_user.set(false);
      ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).pdir_key.set(awrh.d(paramUploadFile.pDirKey));
      ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).ppdir_key.set(awrh.d(paramUploadFile.pPDirKey));
      ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).use_mutil_channel.set(WeiyunTransmissionGlobal.getInstance().isNativeUpload());
      if ((paramUploadFile.isCompress) && (!TextUtils.isEmpty(paramUploadFile.compressedPath)))
      {
        if (paramUploadFile.compressedSha != null) {
          ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).file_sha.set(awrh.d(paramUploadFile.compressedSha));
        }
        ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).file_size.set(paramUploadFile.compressedSize);
        if (!TextUtils.isEmpty(paramUploadFile.mimeType))
        {
          paramUploadType = new WeiyunPB.FileExtInfo();
          paramUploadType.take_time.set(paramUploadFile.takenTime);
          paramUploadType.latitude.set(paramUploadFile.latitude);
          paramUploadType.longitude.set(paramUploadFile.longitude);
          if (!paramUploadFile.mimeType.startsWith("image")) {
            break label619;
          }
          paramUploadType.group_id.set(1);
        }
      }
      for (;;)
      {
        ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).ext_info.set(paramUploadType);
        awpx.a((WeiyunPB.QqSdkFileUploadMsgReq)localObject, new awpc(this, paramUploadServerInfoCallback, paramUploadFile));
        return;
        if (paramUploadFile.sha != null) {
          ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).file_sha.set(awrh.d(paramUploadFile.sha));
        }
        ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).file_size.set(paramUploadFile.fileSize);
        break;
        label619:
        if (!paramUploadFile.mimeType.startsWith("video")) {}
      }
    }
    
    public int getCurrentIsp()
    {
      return 0;
    }
    
    public String getCurrentUid()
    {
      return this.cRV + BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }
    
    public long getCurrentUin()
    {
      return BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    }
    
    public NetworkInfo getRecentNetworkInfo()
    {
      return AppNetConnInfo.getRecentNetworkInfo();
    }
    
    public SharedPreferences getSharedPreferences(String paramString, int paramInt)
    {
      return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awov
 * JD-Core Version:    0.7.0.1
 */