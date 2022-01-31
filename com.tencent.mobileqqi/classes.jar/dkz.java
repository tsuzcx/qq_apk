import com.tencent.mobileqq.activity.StrangerManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerHandler;
import java.util.ArrayList;

public class dkz
  implements Runnable
{
  public dkz(StrangerManageActivity paramStrangerManageActivity) {}
  
  public void run()
  {
    StrangerHandler localStrangerHandler = (StrangerHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(28);
    if (this.a.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    localStrangerHandler.a(this.a.jdField_b_of_type_JavaUtilArrayList);
    this.a.jdField_b_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dkz
 * JD-Core Version:    0.7.0.1
 */