import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;

public class agmu
{
  private static agmu jdField_a_of_type_Agmu;
  public static String bIh;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new agmu.a("Module_WeiyunDownloadService");
  private ConcurrentHashMap<String, Long> fo = new ConcurrentHashMap();
  
  public static agmu a()
  {
    if (jdField_a_of_type_Agmu == null) {}
    try
    {
      jdField_a_of_type_Agmu = new agmu();
      return jdField_a_of_type_Agmu;
    }
    finally {}
  }
  
  private QQAppInterface getAppInterface()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public QIPCModule b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
  
  class a
    extends QIPCModule
  {
    public a(String paramString)
    {
      super();
    }
    
    public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
    {
      arwt.d("WeiyunDownloadServiceIPC", "onCall action|" + paramString + " params|" + paramBundle + " callbackId|" + paramInt);
      Object localObject;
      QQAppInterface localQQAppInterface;
      if (paramBundle == null)
      {
        localObject = null;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          agmu.bIh = (String)localObject;
        }
        if (!TextUtils.isEmpty(paramString))
        {
          localQQAppInterface = agmu.a(agmu.this);
          if (localQQAppInterface != null) {
            break label103;
          }
          arwt.d("WeiyunDownloadServiceIPC", "onCall action but appInterface is null");
        }
      }
      label103:
      do
      {
        do
        {
          return null;
          localObject = paramBundle.getString("process");
          break;
          if (((!"WeiyunDownloadServiceIPC_Action__Download".equals(paramString)) && (!"WeiyunDownloadServiceIPC_Action__Resume".equals(paramString))) || (paramBundle == null)) {
            break label394;
          }
          if (QLog.isColorLevel()) {
            QLog.d("WeiyunDownloadServiceIPC", 2, "AIDL : start weiyunDownload");
          }
          localObject = (String)paramBundle.get("file_id");
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            arwt.d("WeiyunDownloadServiceIPC", "onCall action but file_id is null");
            return null;
          }
          FileManagerEntity localFileManagerEntity = localQQAppInterface.a().c((String)localObject);
          localObject = localFileManagerEntity;
          if (localFileManagerEntity != null) {
            break label213;
          }
        } while ("WeiyunDownloadServiceIPC_Action__Resume".equals(paramString));
        localObject = ahav.a(paramBundle);
        localQQAppInterface.a().l((FileManagerEntity)localObject);
        paramString = (String)paramBundle.get("downloadId");
        ((FileManagerEntity)localObject).nOpType = 50;
        ((FileManagerEntity)localObject).cloudType = 2;
        ((FileManagerEntity)localObject).miniAppDownloadId = paramString;
        agmu.a(agmu.this).put(paramString, Long.valueOf(((FileManagerEntity)localObject).nSessionId));
        if (ahav.mI(((FileManagerEntity)localObject).getFilePath()))
        {
          paramString = new Bundle();
          paramString.putString("taskId", ((FileManagerEntity)localObject).miniAppDownloadId);
          paramString.putString("filePath", ((FileManagerEntity)localObject).getFilePath());
          QIPCServerHelper.getInstance().callClient(agmu.bIh, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Suc", paramString, null);
          paramString = new Bundle();
          paramString.putString("taskId", ((FileManagerEntity)localObject).miniAppDownloadId);
          paramString.putInt("retCode", 1);
          paramString.putString("retMsg", "");
          QIPCServerHelper.getInstance().callClient(agmu.bIh, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Complete", paramString, null);
          return null;
        }
        localQQAppInterface.a().v((FileManagerEntity)localObject);
        localQQAppInterface.a().jk(((FileManagerEntity)localObject).nSessionId);
        return null;
      } while (((!"WeiyunDownloadServiceIPC_Action__Cancel".equals(paramString)) && (!"WeiyunDownloadServiceIPC_Action__Pause".equals(paramString))) || (paramBundle == null));
      label213:
      if (QLog.isColorLevel()) {
        QLog.d("WeiyunDownloadServiceIPC", 2, "AIDL : end weiyunDownload");
      }
      label394:
      paramString = paramBundle.getString("downloadId");
      localQQAppInterface.a().bZ(((Long)agmu.a(agmu.this).get(paramString)).longValue());
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agmu
 * JD-Core Version:    0.7.0.1
 */