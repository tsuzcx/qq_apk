import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import java.util.List;

public class cym
  implements Runnable
{
  public cym(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void run()
  {
    LebaShowListManager.a().a(this.a, this.a.b);
    List localList = LebaShowListManager.a().a();
    this.a.runOnUiThread(new cyn(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cym
 * JD-Core Version:    0.7.0.1
 */