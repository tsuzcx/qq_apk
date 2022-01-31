import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;

public class zhg
  implements Runnable
{
  public zhg(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    ActivityLifecycle.onPause(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhg
 * JD-Core Version:    0.7.0.1
 */