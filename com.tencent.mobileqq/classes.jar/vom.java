import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AccountNotMatchException;

public class vom
  implements Runnable
{
  public vom(AIOImageProviderService paramAIOImageProviderService, long paramLong, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_JavaUtilList;
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    do
    {
      do
      {
        return;
        localObject = AIOImageProviderService.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
      } while ((localObject == null) || (!MessageForPic.class.isInstance(localObject)));
      localObject = (MessageForPic)localObject;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "payFlow,id:" + this.jdField_a_of_type_Long + ",subId:" + this.jdField_a_of_type_Int);
        }
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localQQAppInterface, (MessageForPic)localObject);
        return;
      }
      catch (AccountNotMatchException localAccountNotMatchException) {}
    } while (!QLog.isColorLevel());
    QLog.d("AIOImageProviderService", 2, "no appRuntime");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vom
 * JD-Core Version:    0.7.0.1
 */