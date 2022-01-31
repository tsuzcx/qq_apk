import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import cooperation.qzone.QZoneHelper;

public class asm
  implements Runnable
{
  public asm(Leba paramLeba) {}
  
  public void run()
  {
    QZoneHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Leba.a(this.a);
    WebProcessManager localWebProcessManager = (WebProcessManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
    if ((localWebProcessManager != null) && (localWebProcessManager.c())) {
      localWebProcessManager.e();
    }
    SearchProtocol.a(this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    SearchProtocol.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a(), this.a.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver);
    this.a.o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     asm
 * JD-Core Version:    0.7.0.1
 */