import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import java.util.Observer;

public class wac
  implements Runnable
{
  public wac(TipsManager paramTipsManager, TipsBarTask paramTipsBarTask, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask.a(this.jdField_a_of_type_ArrayOfJavaLangObject);
    TipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager).a(localView);
    TipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask);
    if (TipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager) != null) {
      TipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager).update(null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wac
 * JD-Core Version:    0.7.0.1
 */