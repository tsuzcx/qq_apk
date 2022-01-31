import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.aio.tips.HomeworkTroopSurveyBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.TroopMemberInfo;

public class wie
  implements TroopManager.ITroopMemberInfoCallBack
{
  public wie(HomeworkTroopSurveyBar paramHomeworkTroopSurveyBar, TroopManager paramTroopManager, TipsManager paramTipsManager) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new wif(this, paramTroopMemberInfo));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopSurveyBar.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, paramTroopMemberInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wie
 * JD-Core Version:    0.7.0.1
 */