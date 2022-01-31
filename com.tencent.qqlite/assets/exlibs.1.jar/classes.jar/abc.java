import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class abc
  extends FMObserver
{
  private abc(BaseChatPie paramBaseChatPie) {}
  
  protected void a()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    FileManagerUtil.a(paramLong, paramInt, paramString);
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
    }
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      FileManagerUtil.a(paramString2);
      return;
    }
    FileManagerUtil.a(paramLong);
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if (paramThumbnailInfo == null) {}
    do
    {
      return;
      if ((paramThumbnailInfo.a instanceof FileManagerEntity))
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramThumbnailInfo.a;
        if ((paramThumbnailInfo.b != null) && (paramThumbnailInfo.b.length() > 0))
        {
          localFileManagerEntity.strThumbPath = paramThumbnailInfo.b;
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
        }
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);
    if (paramBoolean) {
      FileManagerUtil.a(paramLong2);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
      return;
      if ((paramString1.nOpType == 4) || (paramString1.nOpType == 6)) {
        FileManagerUtil.a(paramLong2, paramInt2, paramString2);
      }
    }
  }
  
  protected void b()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     abc
 * JD-Core Version:    0.7.0.1
 */