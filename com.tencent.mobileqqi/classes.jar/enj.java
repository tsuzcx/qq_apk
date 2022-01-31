import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.main.MainAssistObserver;

public class enj
  implements Runnable
{
  public enj(MainAssistObserver paramMainAssistObserver) {}
  
  public void run()
  {
    if ((!BaseApplicationImpl.a(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl)) && (MainAssistObserver.a(this.a) < 5)) {
      BaseApplicationImpl.jdField_a_of_type_AndroidOsHandler.postDelayed(MainAssistObserver.a(this.a), MainAssistObserver.b(this.a) * 30000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     enj
 * JD-Core Version:    0.7.0.1
 */