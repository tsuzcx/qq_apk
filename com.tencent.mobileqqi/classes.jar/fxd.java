import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.ListOfflineFile;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;
import com.weiyun.sdk.data.WyOfflineFileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class fxd
  implements IWyFileSystem.IWyCallback
{
  public fxd(WeiYunLogicCenter paramWeiYunLogicCenter) {}
  
  public void a(IWyFileSystem.ListOfflineFile paramListOfflineFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "queryOfflineFileList onSucceed, num[" + paramListOfflineFile.files.size() + "]");
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramListOfflineFile.files.iterator();
    while (localIterator.hasNext())
    {
      WyOfflineFileInfo localWyOfflineFileInfo = (WyOfflineFileInfo)localIterator.next();
      OfflineFileInfo localOfflineFileInfo = new OfflineFileInfo();
      localOfflineFileInfo.jdField_a_of_type_Boolean = localWyOfflineFileInfo.bSend;
      localOfflineFileInfo.jdField_a_of_type_Int = localWyOfflineFileInfo.dangerLevel;
      localOfflineFileInfo.jdField_b_of_type_Long = localWyOfflineFileInfo.fileSize;
      localOfflineFileInfo.c = (MessageCache.a() * 1000L + localWyOfflineFileInfo.lifeTime);
      localOfflineFileInfo.d = localWyOfflineFileInfo.uploadTime;
      localOfflineFileInfo.jdField_b_of_type_JavaLangString = localWyOfflineFileInfo.fileName;
      localOfflineFileInfo.jdField_a_of_type_JavaLangString = localWyOfflineFileInfo.guid;
      localOfflineFileInfo.jdField_a_of_type_Long = localWyOfflineFileInfo.uin;
      localArrayList.add(localOfflineFileInfo);
      if (QLog.isColorLevel()) {
        QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "OfflineFileInfo[" + localOfflineFileInfo.toString() + "]");
      }
    }
    this.a.a.a().a(true, 32, new Object[] { Boolean.valueOf(paramListOfflineFile.isEnd), localArrayList });
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryOfflineFileList onFailed: errcode[" + paramWyErrorStatus.errorCode + "], errmsg[" + paramWyErrorStatus.errorMsg + "]");
    }
    this.a.a.a().a(false, 32, new Object[] { Integer.valueOf(paramWyErrorStatus.errorCode), paramWyErrorStatus.errorMsg });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fxd
 * JD-Core Version:    0.7.0.1
 */