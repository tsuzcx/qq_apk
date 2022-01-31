import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanager.data.WeiYunClassificationType;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;
import com.weiyun.sdk.data.WyCategoryInfo;
import java.util.Iterator;
import java.util.List;

public class drq
  implements IWyFileSystem.IWyCallback
{
  public drq(WeiYunLogicCenter paramWeiYunLogicCenter) {}
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunTypeList onSucceed, num[" + paramList.size() + "]");
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      WyCategoryInfo localWyCategoryInfo = (WyCategoryInfo)paramList.next();
      WeiYunClassificationType localWeiYunClassificationType = new WeiYunClassificationType();
      localWeiYunClassificationType.jdField_a_of_type_JavaLangString = localWyCategoryInfo.categoryId;
      localWeiYunClassificationType.b = localWyCategoryInfo.name;
      localWeiYunClassificationType.jdField_a_of_type_Long = localWyCategoryInfo.timestamp;
      localWeiYunClassificationType.jdField_a_of_type_Int = localWyCategoryInfo.totalNum;
      this.a.b.add(localWeiYunClassificationType);
    }
    this.a.a.a().a(true, 30, this.a.b);
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunTypeList onFailed: errcode[" + paramWyErrorStatus.errorCode + "], errmsg[" + paramWyErrorStatus.errorMsg + "]");
    }
    this.a.a.a().a(false, 30, new Object[] { Integer.valueOf(paramWyErrorStatus.errorCode), paramWyErrorStatus.errorMsg });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     drq
 * JD-Core Version:    0.7.0.1
 */