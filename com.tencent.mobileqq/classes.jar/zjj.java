import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.RouterHandler;
import java.util.HashMap;

public class zjj
  implements Runnable
{
  public zjj(RouterHandler paramRouterHandler, long paramLong, int paramInt) {}
  
  public void run()
  {
    Session localSession = (Session)this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.e.get(Long.valueOf(this.jdField_a_of_type_Long));
    if ((this.jdField_a_of_type_Int == 2) && (localSession != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.e.remove(Long.valueOf(this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a(2, localSession, 0.0D, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zjj
 * JD-Core Version:    0.7.0.1
 */