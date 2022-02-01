import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.ListFiles;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;
import com.weiyun.sdk.data.WyFileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

class atuy
  implements IWyFileSystem.IWyCallback<IWyFileSystem.ListFiles>
{
  atuy(atuw paramatuw, String paramString, int paramInt) {}
  
  public void a(IWyFileSystem.ListFiles paramListFiles)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList onSucceed, num[" + paramListFiles.files.size() + "]");
    }
    Object localObject = paramListFiles.files;
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    label277:
    while (((Iterator)localObject).hasNext())
    {
      WyFileInfo localWyFileInfo = (WyFileInfo)((Iterator)localObject).next();
      WeiYunFileInfo localWeiYunFileInfo = new WeiYunFileInfo();
      localWeiYunFileInfo.mtime = localWyFileInfo.mtime;
      localWeiYunFileInfo.nFileSize = localWyFileInfo.fileSize;
      localWeiYunFileInfo.cYi = localWyFileInfo.source;
      localWeiYunFileInfo.bIk = localWyFileInfo.fileId;
      localWeiYunFileInfo.strFileName = localWyFileInfo.fileName;
      localWeiYunFileInfo.cookieName = localWyFileInfo.cookieName;
      localWeiYunFileInfo.cookieValue = localWyFileInfo.cookieValue;
      localWeiYunFileInfo.encodeUrl = localWyFileInfo.encodeUrl;
      localWeiYunFileInfo.hostName = localWyFileInfo.hostName;
      localWeiYunFileInfo.port = localWyFileInfo.serverPort;
      if (!localWyFileInfo.md5.equalsIgnoreCase("00000000000000000000000000000000")) {}
      for (localWeiYunFileInfo.md5 = localWyFileInfo.md5;; localWeiYunFileInfo.md5 = "")
      {
        if (this.b.ad.containsKey(localWeiYunFileInfo.bIk)) {
          break label277;
        }
        this.b.ad.put(localWeiYunFileInfo.bIk, localWeiYunFileInfo);
        localArrayList.add(localWeiYunFileInfo);
        break;
      }
    }
    if ((localArrayList.isEmpty()) || (this.val$count > paramListFiles.totalNum)) {}
    for (boolean bool = true;; bool = false)
    {
      this.b.app.a().b(true, 31, new Object[] { paramListFiles.categoryId, Boolean.valueOf(bool), Integer.valueOf(paramListFiles.totalNum), Long.valueOf(paramListFiles.timestamp), localArrayList, Integer.valueOf(this.b.alY) });
      return;
    }
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList onFailed: errcode[" + paramWyErrorStatus.errorCode + "], errmsg[" + paramWyErrorStatus.errorMsg + "]");
    }
    this.b.app.a().b(false, 31, new Object[] { Integer.valueOf(paramWyErrorStatus.errorCode), paramWyErrorStatus.errorMsg, this.bIf });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atuy
 * JD-Core Version:    0.7.0.1
 */