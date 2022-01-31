import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;

public class cav
  implements Runnable
{
  public cav(TipsManager paramTipsManager, TipsBarTask paramTipsBarTask, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask.a(this.jdField_a_of_type_ArrayOfJavaLangObject);
    TipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager).a(localView);
    TipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cav
 * JD-Core Version:    0.7.0.1
 */