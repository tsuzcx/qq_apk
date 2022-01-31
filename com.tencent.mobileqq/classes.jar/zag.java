import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;

public class zag
  implements Runnable
{
  public zag(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    ActivityLifecycle.onPause(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zag
 * JD-Core Version:    0.7.0.1
 */