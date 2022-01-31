import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;

public class ywz
  implements Runnable
{
  public ywz(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    ActivityLifecycle.onResume(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ywz
 * JD-Core Version:    0.7.0.1
 */