import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.apollo.drawer.CardDrawerStatus;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class yvj
  implements Runnable
{
  public yvj(CardDrawerStatus paramCardDrawerStatus, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == null)) {
      QLog.w("CardDrawerStatus", 1, "MediaPlayerManager is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yvj
 * JD-Core Version:    0.7.0.1
 */