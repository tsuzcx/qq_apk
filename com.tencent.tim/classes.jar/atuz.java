import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.ListOfflineFile;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;
import com.weiyun.sdk.data.WyOfflineFileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class atuz
  implements IWyFileSystem.IWyCallback<IWyFileSystem.ListOfflineFile>
{
  atuz(atuw paramatuw) {}
  
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
      localOfflineFileInfo.bSend = localWyOfflineFileInfo.bSend;
      localOfflineFileInfo.cYg = localWyOfflineFileInfo.dangerLevel;
      localOfflineFileInfo.nFileSize = localWyOfflineFileInfo.fileSize;
      localOfflineFileInfo.Zm = (anaz.gQ() * 1000L + localWyOfflineFileInfo.lifeTime);
      localOfflineFileInfo.Zn = localWyOfflineFileInfo.uploadTime;
      localOfflineFileInfo.strFileName = localWyOfflineFileInfo.fileName;
      localOfflineFileInfo.bHK = localWyOfflineFileInfo.guid;
      localOfflineFileInfo.uFriendUin = localWyOfflineFileInfo.uin;
      localArrayList.add(localOfflineFileInfo);
      if (QLog.isColorLevel()) {
        QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "OfflineFileInfo[" + localOfflineFileInfo.toString() + "]");
      }
    }
    this.b.app.a().b(true, 32, new Object[] { Boolean.valueOf(paramListOfflineFile.isEnd), localArrayList });
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryOfflineFileList onFailed: errcode[" + paramWyErrorStatus.errorCode + "], errmsg[" + paramWyErrorStatus.errorMsg + "]");
    }
    this.b.app.a().b(false, 32, new Object[] { Integer.valueOf(paramWyErrorStatus.errorCode), paramWyErrorStatus.errorMsg });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atuz
 * JD-Core Version:    0.7.0.1
 */