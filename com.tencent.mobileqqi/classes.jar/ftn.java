import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.FileViewerImageInfo;
import com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileFileViewerActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ftn
  extends FMObserver
{
  public ftn(QfileFileViewerActivity paramQfileFileViewerActivity) {}
  
  protected void a()
  {
    this.a.f();
  }
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    if (paramLong != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) {
      return;
    }
    FileManagerUtil.a(paramLong, paramInt, paramString);
    this.a.f();
  }
  
  protected void a(int paramInt, String paramString)
  {
    FileManagerUtil.a(paramString);
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    paramString = this.a.b.a().a(paramLong1, paramString, paramInt, paramLong2);
    if (paramString == null) {}
    while (paramLong2 != paramString.nSessionId) {
      return;
    }
    QLog.i("<FileAssistant>QfileFileViewerActivity", 1, "<FileAssistant>QfileFileViewerActivity OnFileTransferStart: mEntity[" + FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity) + "]");
    this.a.f();
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0) && (paramInt != 0)) {
      FileManagerUtil.a(paramString2);
    }
    for (;;)
    {
      this.a.f();
      return;
      FileManagerUtil.a(paramLong);
    }
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if (paramThumbnailInfo == null) {
      QLog.e("<FileAssistant>QfileFileViewerActivity", 1, "<FileAssistant>QfileFileViewerActivityOnThumbDownLoadSuccess why thumbInfo is null?!");
    }
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        return;
        if (paramThumbnailInfo.jdField_a_of_type_JavaLangObject == null)
        {
          QLog.e("<FileAssistant>QfileFileViewerActivity", 1, "<FileAssistant>QfileFileViewerActivityOnThumbDownLoadSuccess why thumbInfo.context is null?!");
          return;
        }
        if (!(paramThumbnailInfo.jdField_a_of_type_JavaLangObject instanceof FileManagerEntity))
        {
          QLog.e("<FileAssistant>QfileFileViewerActivity", 1, "<FileAssistant>QfileFileViewerActivityOnThumbDownLoadSuccess why thumbInfo.context is not instanceof FileManagerEntity ?!");
          return;
        }
        localFileManagerEntity = (FileManagerEntity)paramThumbnailInfo.jdField_a_of_type_JavaLangObject;
        this.a.a(localFileManagerEntity.nSessionId, false);
        this.a.f();
      } while (localFileManagerEntity.nSessionId != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      if (paramThumbnailInfo.b == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("<FileAssistant>QfileFileViewerActivity", 1, "<FileAssistant>QfileFileViewerActivityend pull xlarge  pic thumb faild , fileId or uuid:" + paramThumbnailInfo.jdField_a_of_type_JavaLangString + "endTime:" + MessageCache.a());
        }
        this.a.f();
        return;
      }
      this.a.f();
    } while (!QLog.isColorLevel());
    QLog.i("<FileAssistant>QfileFileViewerActivity", 1, "<FileAssistant>QfileFileViewerActivityend pull xlarge weiyun pic thumb, entity->:" + FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity) + "endTime:" + MessageCache.a());
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    if (paramLong != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) {
      return;
    }
    FileManagerUtil.a(paramLong, paramInteger.intValue(), paramString);
    this.a.f();
  }
  
  protected void a(String paramString1, String paramString2, Integer paramInteger, String paramString3, boolean paramBoolean)
  {
    paramString2 = FileManagerUtil.d(paramString2);
    String str = paramString2 + this.a.getString(2131558762);
    paramString2 = str;
    if (paramInteger.intValue() != -100000)
    {
      paramString2 = str;
      if (paramInteger.intValue() != -100003)
      {
        paramString2 = str;
        if (paramInteger.intValue() != -100002)
        {
          if (paramInteger.intValue() != -100001) {
            break label116;
          }
          paramString2 = str;
        }
      }
    }
    FMToastUtil.a(paramString2);
    if (paramBoolean) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.equals(paramString1)) {
        QfileFileViewerActivity.a(this.a);
      }
    }
    label116:
    while (!this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId.equals(paramString1))
    {
      return;
      paramString2 = str;
      if (paramString3 == null) {
        break;
      }
      paramString2 = str;
      if (paramString3.length() <= 0) {
        break;
      }
      paramString2 = str + "，" + paramString3;
      break;
    }
    QfileFileViewerActivity.b(this.a);
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    FileViewerImageInfo localFileViewerImageInfo;
    FileManagerEntity localFileManagerEntity;
    if (paramBoolean) {
      if (this.a.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        paramString2 = this.a.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString2.hasNext())
        {
          localFileViewerImageInfo = (FileViewerImageInfo)paramString2.next();
          localFileManagerEntity = (FileManagerEntity)localFileViewerImageInfo.jdField_a_of_type_JavaLangObject;
          if ((localFileManagerEntity != null) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.equals(paramString1))) {
            this.a.jdField_a_of_type_JavaUtilList.remove(localFileViewerImageInfo);
          }
        }
        if (this.a.jdField_a_of_type_JavaUtilList.size() == 0) {
          this.a.finish();
        }
      }
    }
    do
    {
      return;
      this.a.f();
      return;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid != null) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.equals(paramString1))) {
        this.a.finish();
      }
      this.a.f();
      return;
      if (this.a.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        paramString2 = this.a.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString2.hasNext())
        {
          localFileViewerImageInfo = (FileViewerImageInfo)paramString2.next();
          localFileManagerEntity = (FileManagerEntity)localFileViewerImageInfo.jdField_a_of_type_JavaLangObject;
          if ((localFileManagerEntity != null) && (localFileManagerEntity.WeiYunFileId != null) && (localFileManagerEntity.WeiYunFileId.equals(paramString1))) {
            this.a.jdField_a_of_type_JavaUtilList.remove(localFileViewerImageInfo);
          }
        }
        if (this.a.jdField_a_of_type_JavaUtilList.size() == 0)
        {
          this.a.finish();
          return;
        }
        this.a.f();
        return;
      }
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId.equals(paramString1)));
    this.a.finish();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if ((paramLong2 != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) && (paramLong2 != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nRelatedSessionId)) {
      return;
    }
    this.a.f();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    QLog.d("<FileAssistant>QfileFileViewerActivity", 1, "<FileAssistant>QfileFileViewerActivityOnFileTransferEnd, isSuccess[" + paramBoolean + "] uniseq[" + paramLong1 + "] nSessionId[" + paramLong2 + "] errCode[" + paramInt2 + "] retMsg[" + paramString2 + "] mEntify:" + FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
    if (this.a.b.a().a(paramLong2) == null) {
      QLog.e("<FileAssistant>QfileFileViewerActivity", 1, "queryEntity is null,nSessionId[" + paramLong2 + "]");
    }
    for (;;)
    {
      return;
      if (paramBoolean) {
        FileManagerUtil.a(paramLong2);
      }
      while (paramLong2 == this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId)
      {
        this.a.f();
        return;
        FileManagerUtil.a(paramLong2, paramInt2, paramString2);
      }
    }
  }
  
  protected void b()
  {
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ftn
 * JD-Core Version:    0.7.0.1
 */