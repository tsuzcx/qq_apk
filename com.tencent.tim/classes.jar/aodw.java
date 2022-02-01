import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.3;
import com.tencent.mobileqq.webprocess.WebProcessManager.a;
import com.tencent.qphone.base.util.QLog;

public class aodw
  implements WebProcessManager.a
{
  public aodw(GroupTeamWorkListActivity.3 param3) {}
  
  public void onResult(boolean paramBoolean)
  {
    if ((paramBoolean) && (QLog.isColorLevel())) {
      QLog.i("Tag_webView", 1, "Web_qqbrowser_web TeamWorkList preloadWebProcess success! ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aodw
 * JD-Core Version:    0.7.0.1
 */