import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;

public class byt
  implements Runnable
{
  public byt(AIOImageProviderService paramAIOImageProviderService, long paramLong, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a == null) {
      return;
    }
    do
    {
      Object localObject;
      do
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a.iterator();
      } while (!((Iterator)localObject).hasNext());
      MessageForPic localMessageForPic = (MessageForPic)((Iterator)localObject).next();
      if ((localMessageForPic.uniseq != this.jdField_a_of_type_Long) || (localMessageForPic.subMsgId != this.jdField_a_of_type_Int)) {
        break;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "payFlow,id:" + this.jdField_a_of_type_Long + ",subId:" + this.jdField_a_of_type_Int);
        }
        localObject = (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.b);
        AIOImageProviderService.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService, (QQAppInterface)localObject, localMessageForPic);
        return;
      }
      catch (AccountNotMatchException localAccountNotMatchException) {}
    } while (!QLog.isColorLevel());
    QLog.d("AIOImageProviderService", 2, "no appRuntime");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     byt
 * JD-Core Version:    0.7.0.1
 */