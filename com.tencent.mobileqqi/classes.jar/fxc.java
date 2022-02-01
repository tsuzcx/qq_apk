import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
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

public class fxc
  implements IWyFileSystem.IWyCallback
{
  public fxc(WeiYunLogicCenter paramWeiYunLogicCenter, String paramString) {}
  
  public void a(IWyFileSystem.ListFiles paramListFiles)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList onSucceed, num[" + paramListFiles.files.size() + "]");
    }
    Object localObject = paramListFiles.files;
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WyFileInfo localWyFileInfo = (WyFileInfo)((Iterator)localObject).next();
      WeiYunFileInfo localWeiYunFileInfo = new WeiYunFileInfo();
      localWeiYunFileInfo.jdField_b_of_type_Long = localWyFileInfo.mtime;
      localWeiYunFileInfo.jdField_a_of_type_Long = localWyFileInfo.fileSize;
      localWeiYunFileInfo.jdField_c_of_type_Int = localWyFileInfo.source;
      localWeiYunFileInfo.jdField_a_of_type_JavaLangString = localWyFileInfo.fileId;
      localWeiYunFileInfo.jdField_b_of_type_JavaLangString = localWyFileInfo.fileName;
      localWeiYunFileInfo.e = localWyFileInfo.cookieName;
      localWeiYunFileInfo.f = localWyFileInfo.cookieValue;
      localWeiYunFileInfo.jdField_d_of_type_JavaLangString = localWyFileInfo.encodeUrl;
      localWeiYunFileInfo.jdField_c_of_type_JavaLangString = localWyFileInfo.hostName;
      localWeiYunFileInfo.jdField_d_of_type_Int = localWyFileInfo.serverPort;
      localWeiYunFileInfo.h = localWyFileInfo.md5;
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localWeiYunFileInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.jdField_a_of_type_JavaUtilLinkedHashMap.put(localWeiYunFileInfo.jdField_a_of_type_JavaLangString, localWeiYunFileInfo);
        localArrayList.add(localWeiYunFileInfo);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 31, new Object[] { paramListFiles.categoryId, Boolean.valueOf(paramListFiles.isEnd), Integer.valueOf(paramListFiles.totalNum), Long.valueOf(paramListFiles.timestamp), localArrayList, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.jdField_a_of_type_Int) });
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList onFailed: errcode[" + paramWyErrorStatus.errorCode + "], errmsg[" + paramWyErrorStatus.errorMsg + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 31, new Object[] { Integer.valueOf(paramWyErrorStatus.errorCode), paramWyErrorStatus.errorMsg, this.jdField_a_of_type_JavaLangString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fxc
 * JD-Core Version:    0.7.0.1
 */