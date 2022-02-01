import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.cloudfile.AirCopyExtInfo;
import com.tencent.cloudfile.BatchRequest;
import com.tencent.cloudfile.CloudAIORecentFileExt;
import com.tencent.cloudfile.CloudBase;
import com.tencent.cloudfile.CloudFileCallback;
import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.cloudfile.CloudFileContext;
import com.tencent.cloudfile.CloudFileSDK;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.cloudfile.CloudOnlineFileExt;
import com.tencent.cloudfile.CloudSearchReq;
import com.tencent.cloudfile.FileInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class atgi
{
  private static volatile atgi jdField_a_of_type_Atgi;
  private static volatile boolean dhB;
  static boolean isStop = true;
  private atgh jdField_a_of_type_Atgh = new atgh();
  private CloudFileContext jdField_a_of_type_ComTencentCloudfileCloudFileContext = new atgk(this, new atgj(this));
  private CloudFileSDK jdField_a_of_type_ComTencentCloudfileCloudFileSDK;
  private INetInfoHandler b;
  private BroadcastReceiver bS;
  
  private atgi()
  {
    a(this.jdField_a_of_type_Atgh, this.jdField_a_of_type_ComTencentCloudfileCloudFileContext);
  }
  
  /* Error */
  public static atgi a()
  {
    // Byte code:
    //   0: getstatic 51	atgi:jdField_a_of_type_Atgi	Latgi;
    //   3: ifnonnull +68 -> 71
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 53	atgi:dhB	Z
    //   12: istore_0
    //   13: iload_0
    //   14: ifne +38 -> 52
    //   17: invokestatic 59	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   20: ldc 61
    //   22: invokestatic 67	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   25: putstatic 53	atgi:dhB	Z
    //   28: ldc 69
    //   30: iconst_1
    //   31: iconst_2
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: ldc 71
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: getstatic 53	atgi:dhB	Z
    //   45: invokestatic 77	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   48: aastore
    //   49: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   52: getstatic 51	atgi:jdField_a_of_type_Atgi	Latgi;
    //   55: ifnonnull +13 -> 68
    //   58: new 2	atgi
    //   61: dup
    //   62: invokespecial 84	atgi:<init>	()V
    //   65: putstatic 51	atgi:jdField_a_of_type_Atgi	Latgi;
    //   68: ldc 2
    //   70: monitorexit
    //   71: getstatic 20	atgi:isStop	Z
    //   74: ifeq +3 -> 77
    //   77: getstatic 51	atgi:jdField_a_of_type_Atgi	Latgi;
    //   80: invokevirtual 87	atgi:start	()V
    //   83: getstatic 51	atgi:jdField_a_of_type_Atgi	Latgi;
    //   86: areturn
    //   87: astore_1
    //   88: ldc 69
    //   90: iconst_1
    //   91: aload_1
    //   92: invokevirtual 91	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   95: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: goto -46 -> 52
    //   101: astore_1
    //   102: ldc 2
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 98	java/lang/Exception:printStackTrace	()V
    //   112: goto -60 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	2	0	bool	boolean
    //   87	5	1	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   101	5	1	localObject	Object
    //   107	2	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   17	52	87	java/lang/UnsatisfiedLinkError
    //   9	13	101	finally
    //   17	52	101	finally
    //   52	68	101	finally
    //   68	71	101	finally
    //   88	98	101	finally
    //   102	105	101	finally
    //   108	112	101	finally
    //   17	52	107	java/lang/Exception
  }
  
  private void a(CloudFileCallbackCenter paramCloudFileCallbackCenter, CloudFileContext paramCloudFileContext)
  {
    if (!dhB)
    {
      QLog.e("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileSDKWrapper", 2, "cloud file sdk load success, init");
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK = CloudFileSDK.getInstance();
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.registerContext(paramCloudFileCallbackCenter, paramCloudFileContext);
  }
  
  private boolean aJf()
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return false;
    }
    return true;
  }
  
  private void b(CloudFileCallbackCenter paramCloudFileCallbackCenter)
  {
    this.jdField_a_of_type_Atgh.b(paramCloudFileCallbackCenter);
  }
  
  public static void c(CloudFileCallbackCenter paramCloudFileCallbackCenter)
  {
    if (jdField_a_of_type_Atgi != null) {
      jdField_a_of_type_Atgi.b(paramCloudFileCallbackCenter);
    }
  }
  
  private void dfh()
  {
    if (this.b == null)
    {
      this.b = new atgm(this);
      AppNetConnInfo.registerConnectionChangeReceiver(null, this.b);
    }
  }
  
  private void elV()
  {
    if (this.b != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.b);
      this.b = null;
    }
  }
  
  private void etq()
  {
    if (this.bS != null)
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.bS);
      this.bS = null;
    }
  }
  
  private void registerAccountReceiver()
  {
    if (this.bS == null)
    {
      this.bS = new atgl(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
      localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
      localIntentFilter.addAction("mqq.intent.action.LOGOUT");
      localIntentFilter.addAction("mqq.intent.action.EXIT_" + BaseApplicationImpl.getApplication().getPackageName());
      localIntentFilter.addAction("com.tencent.tim.kickedLogin.otherDevice");
      BaseApplicationImpl.getApplication().registerReceiver(this.bS, localIntentFilter);
    }
  }
  
  public static void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileSDKWrapper", 2, "stop");
    }
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    if (jdField_a_of_type_Atgi != null)
    {
      jdField_a_of_type_Atgi.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.stop();
      jdField_a_of_type_Atgi.elV();
      jdField_a_of_type_Atgi.etq();
    }
    aths.a().clear();
    isStop = true;
  }
  
  public long a(CloudSearchReq paramCloudSearchReq, atgg paramatgg)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.searchFileList(paramCloudSearchReq, paramatgg);
  }
  
  public FileManagerEntity a(FileInfo paramFileInfo)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return null;
    }
    return athu.a(this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.createUploadTaskForAutoUpload(paramFileInfo));
  }
  
  public FileManagerEntity a(String paramString, byte[] paramArrayOfByte, FileInfo paramFileInfo)
  {
    if (!aJf()) {
      return null;
    }
    return athu.a(this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.createUploadTaskForTeam(paramString, paramArrayOfByte, paramFileInfo));
  }
  
  public FileManagerEntity a(byte[] paramArrayOfByte, CloudOnlineFileExt paramCloudOnlineFileExt)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return null;
    }
    return athu.a(this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.createUploadTaskForOnline(paramArrayOfByte, paramCloudOnlineFileExt));
  }
  
  public FileManagerEntity a(byte[] paramArrayOfByte, FileInfo paramFileInfo)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return null;
    }
    return athu.a(this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.createUploadTask(paramArrayOfByte, paramFileInfo));
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, CloudFileCallback paramCloudFileCallback)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "fetchRecentFileHistoryList : cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.fetchRecentHistoryList(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, paramCloudFileCallback);
  }
  
  public void a(int paramInt, boolean paramBoolean, atgg paramatgg)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.refreshFeedsList(paramInt, paramBoolean, paramatgg);
  }
  
  public void a(long paramLong, CloudFileCallback paramCloudFileCallback)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "deleteRecentFileHistory : cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.deleteRecentHistory(paramLong, paramCloudFileCallback);
  }
  
  public void a(CloudAIORecentFileExt paramCloudAIORecentFileExt, atgg paramatgg)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.checkFileExistInAIORecentFolder(paramCloudAIORecentFileExt, paramatgg);
  }
  
  public void a(CloudFileCallbackCenter paramCloudFileCallbackCenter)
  {
    this.jdField_a_of_type_Atgh.a(paramCloudFileCallbackCenter);
  }
  
  public void a(CloudHistoryInfo paramCloudHistoryInfo, CloudFileCallback paramCloudFileCallback)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "addRecentFileHistory : cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.addRecentHsitoryInfo(paramCloudHistoryInfo, paramCloudFileCallback);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString, boolean paramBoolean)
  {
    if (!dhB) {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramFileManagerEntity == null) || (paramFileManagerEntity.pDirKey == null) || (paramFileManagerEntity.cloudId == null) || (TextUtils.isEmpty(paramString)));
      this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.setDownloadSucStatus(paramFileManagerEntity.pDirKey, paramFileManagerEntity.cloudId, paramString, paramBoolean);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject = (atgc)localQQAppInterface.getManager(373);
      if (Arrays.equals(paramFileManagerEntity.pDirKey, ((atgc)localObject).aF()))
      {
        localObject = localQQAppInterface.a().a(paramFileManagerEntity.cloudId);
        if (localObject != null)
        {
          ((FileManagerEntity)localObject).strFilePath = paramString;
          ((FileManagerEntity)localObject).status = 1;
          ((FileManagerEntity)localObject).setCloudType(3);
          localQQAppInterface.a().u((FileManagerEntity)localObject);
        }
      }
    } while ((paramFileManagerEntity.nFileType != 2) || (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath)));
    aths.a().U(paramFileManagerEntity);
  }
  
  public void a(Object paramObject, int paramInt, boolean paramBoolean, atgg paramatgg)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramObject != null)
    {
      if (((paramObject instanceof FileManagerEntity)) && (((FileManagerEntity)paramObject).combinePhotoList == null)) {
        localObject1 = ((FileManagerEntity)paramObject).cloudFile;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.fetchFeedsList((CloudBase)localObject1, paramInt, paramBoolean, paramatgg);
      return;
    }
    if (((paramObject instanceof FileManagerEntity)) && (((FileManagerEntity)paramObject).combinePhotoList != null))
    {
      paramObject = ((FileManagerEntity)paramObject).combinePhotoList;
      int i = paramObject.size();
      if (i <= 0) {
        break label162;
      }
      paramObject = (FileManagerEntity)paramObject.get(i - 1);
      if (paramObject == null) {
        break label162;
      }
    }
    label162:
    for (paramObject = paramObject.cloudFile;; paramObject = null)
    {
      localObject1 = paramObject;
      break;
      localObject1 = localObject2;
      if (!(paramObject instanceof atin)) {
        break;
      }
      localObject1 = ((atin)paramObject).a;
      break;
    }
  }
  
  public void a(String paramString, int paramInt, CloudFileCallback paramCloudFileCallback)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "searchRecentFileHistory : cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.searchRecentHistory(paramString, paramInt, 0L, paramCloudFileCallback);
  }
  
  public void a(List<BatchRequest> paramList, int paramInt, atgg paramatgg)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.deleteFolderFile(paramList, paramInt, paramatgg);
  }
  
  public void a(List<CloudAIORecentFileExt> paramList, atgg paramatgg)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.batchCheckFileExistInAIORecentFolder(paramList, paramatgg);
  }
  
  public void a(List<BatchRequest> paramList, byte[] paramArrayOfByte, atgg paramatgg)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.moveFolderFile(paramList, paramArrayOfByte, paramatgg);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, atgg paramatgg)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.refreshDirFileList(paramArrayOfByte, paramInt, paramatgg);
  }
  
  public void a(byte[] paramArrayOfByte, CloudFileCallback paramCloudFileCallback)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "IsDirKeyMatchedUploadDirKeyList : cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.IsDirKeyMatchedUploadDirKeyList(paramArrayOfByte, paramCloudFileCallback);
  }
  
  public void a(byte[] paramArrayOfByte, Object paramObject, boolean paramBoolean, int paramInt, atgg paramatgg)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    Object localObject = null;
    if (paramObject != null) {
      if (!(paramObject instanceof FileManagerEntity)) {
        break label62;
      }
    }
    label62:
    for (paramObject = ((FileManagerEntity)paramObject).cloudFile;; paramObject = ((atin)paramObject).a)
    {
      localObject = paramObject;
      this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.fetchDirFileList(paramArrayOfByte, localObject, paramBoolean, paramInt, paramatgg);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, String paramString, atgg paramatgg)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.createFolder(paramArrayOfByte, paramString, paramatgg);
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, atgg paramatgg)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.renameFolder(paramArrayOfByte1, paramArrayOfByte2, paramString, paramatgg);
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt, CloudFileCallback paramCloudFileCallback)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.copyTMCFile(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt, paramCloudFileCallback);
  }
  
  public void aao(int paramInt)
  {
    QLog.i("CloudFileSDKWrapper", 1, "stopAllTask network changed, stop all uploading tasks");
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.stopAllFileUpload(paramInt);
  }
  
  public void airCopyToOtherBiz(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, long paramLong1, long paramLong2, byte[] paramArrayOfByte3, String paramString, AirCopyExtInfo paramAirCopyExtInfo, CloudFileCallback paramCloudFileCallback)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.airCopyToOtherBiz(paramArrayOfByte1, paramArrayOfByte2, paramInt, paramLong1, paramLong2, paramArrayOfByte3, paramString, paramAirCopyExtInfo, paramCloudFileCallback);
  }
  
  public void autoAirCopyReportData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, FileInfo paramFileInfo, int paramInt)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.autoAirCopyReportData(paramArrayOfByte1, paramArrayOfByte2, paramFileInfo, paramInt);
  }
  
  public void b(atgg paramatgg)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.fetchUserInfo(paramatgg);
  }
  
  public void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, atgg paramatgg)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.renameFile(paramArrayOfByte1, paramArrayOfByte2, paramString, paramatgg);
  }
  
  public void c(atgg paramatgg)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.fetchSpace(paramatgg);
  }
  
  public void checkPreviewFile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, CloudFileCallback paramCloudFileCallback)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.checkPreviewFile(paramArrayOfByte1, paramArrayOfByte2, paramCloudFileCallback);
  }
  
  public void d(atgg paramatgg)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.fetchDownloadedListFromAIORecent(paramatgg);
  }
  
  public void deleteUploadFile(List<Long> paramList)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.deleteUploadFile(paramList);
  }
  
  public void e(atgg paramatgg)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.fetchUploadFileList(paramatgg);
  }
  
  public String encodeFileNameForAirCopy(String paramString1, String paramString2, long paramLong)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return "";
    }
    return this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.encodeFileNameForAirCopy(paramString1, paramString2, paramLong);
  }
  
  public void fetchDirFileList(int paramInt1, byte[] paramArrayOfByte, CloudBase paramCloudBase, boolean paramBoolean, int paramInt2, CloudFileCallback paramCloudFileCallback)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.fetchDirFileList(paramInt1, paramArrayOfByte, paramCloudBase, paramBoolean, paramInt2, paramCloudFileCallback);
  }
  
  public void getAllItemCount(CloudFileCallback paramCloudFileCallback)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.getAllItemCount(paramCloudFileCallback);
  }
  
  public void getCloudItemById(byte[] paramArrayOfByte, CloudFileCallback paramCloudFileCallback)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.getCloudItemById(paramArrayOfByte, paramCloudFileCallback);
  }
  
  public String getErrorMsgOf(int paramInt)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return "";
    }
    return this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.getErrorMsgOf(paramInt);
  }
  
  public void getThumbList(byte[] paramArrayOfByte, List<byte[]> paramList, int paramInt)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.getThumbList(paramArrayOfByte, paramList, paramInt);
  }
  
  public void manualAirCopyReportData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, FileInfo paramFileInfo, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.manualAirCopyReportData(paramArrayOfByte1, paramArrayOfByte2, paramFileInfo, paramInt1, paramInt2, paramLong, paramInt3);
  }
  
  public void notifyAirCopySuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, FileInfo paramFileInfo)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.notifyAirCopySuccess(paramArrayOfByte1, paramArrayOfByte2, paramFileInfo);
  }
  
  public void recvResponse(int paramInt, byte[] paramArrayOfByte, long paramLong)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    int i;
    if (paramInt == 1000) {
      i = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.recvResponse(i, paramArrayOfByte, paramLong);
      return;
      i = paramInt;
      if (paramInt == 1002) {
        i = -233;
      }
    }
  }
  
  public void refreshDirFileList(int paramInt1, byte[] paramArrayOfByte, int paramInt2, CloudFileCallback paramCloudFileCallback)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.refreshDirFileList(paramInt1, paramArrayOfByte, paramInt2, paramCloudFileCallback);
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 53	atgi:dhB	Z
    //   5: ifne +20 -> 25
    //   8: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +11 -> 22
    //   14: ldc 69
    //   16: iconst_2
    //   17: ldc 100
    //   19: invokestatic 123	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 116	atgi:jdField_a_of_type_ComTencentCloudfileCloudFileSDK	Lcom/tencent/cloudfile/CloudFileSDK;
    //   29: invokevirtual 524	com/tencent/cloudfile/CloudFileSDK:start	()V
    //   32: getstatic 51	atgi:jdField_a_of_type_Atgi	Latgi;
    //   35: invokespecial 526	atgi:dfh	()V
    //   38: getstatic 51	atgi:jdField_a_of_type_Atgi	Latgi;
    //   41: invokespecial 528	atgi:registerAccountReceiver	()V
    //   44: iconst_0
    //   45: putstatic 20	atgi:isStop	Z
    //   48: goto -26 -> 22
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	atgi
    //   51	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	51	finally
    //   25	48	51	finally
  }
  
  public void startDownloadFile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.startDownloadFile(paramArrayOfByte1, paramArrayOfByte2, paramString);
  }
  
  public void startUploadFile(List<Long> paramList)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.startUploadFile(paramList);
  }
  
  public void stopDownloadFile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.stopDownloadFile(paramArrayOfByte1, paramArrayOfByte2, paramInt);
  }
  
  public void stopUploadFile(List<Long> paramList, int paramInt)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.stopUploadFile(paramList, paramInt);
  }
  
  public void updateOnlineInfo(CloudOnlineFileExt paramCloudOnlineFileExt)
  {
    if (!dhB)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CloudFileSDKWrapper", 2, "cloud file sdk load failed!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCloudfileCloudFileSDK.updateOnlineInfo(paramCloudOnlineFileExt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atgi
 * JD-Core Version:    0.7.0.1
 */