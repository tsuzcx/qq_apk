import com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.e;
import mqq.os.MqqHandler;

public class wxl
  implements RobotPanelLayoutBase.e
{
  wxl(wxk paramwxk) {}
  
  public void xP(String paramString)
  {
    ThreadManager.getUIHandler().post(new TroopRobotHelper.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wxl
 * JD-Core Version:    0.7.0.1
 */