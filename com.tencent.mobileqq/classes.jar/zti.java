import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.RouterHandler;
import java.util.HashMap;

public class zti
  implements Runnable
{
  public zti(RouterHandler paramRouterHandler, Session paramSession) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.e.put(Long.valueOf(this.jdField_a_of_type_ComTencentLitetransfersdkSession.uSessionID), this.jdField_a_of_type_ComTencentLitetransfersdkSession);
    this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a(3, this.jdField_a_of_type_ComTencentLitetransfersdkSession, 0.0D, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zti
 * JD-Core Version:    0.7.0.1
 */