import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.resourcesgrab.ResourceGrabFragment;
import com.tencent.tim.resourcesgrab.ResourceGrabView;
import mqq.util.WeakReference;

public class aujn
  implements Application.ActivityLifecycleCallbacks
{
  public aujn(ResourceGrabView paramResourceGrabView) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabView", 2, "onActivityCreated activity: " + paramActivity);
    }
    ResourceGrabView.a(this.b, new WeakReference(paramActivity));
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabView", 2, "onActivityDestroyed activity: " + paramActivity);
    }
    if ((paramActivity instanceof FragmentActivity))
    {
      paramActivity = ((FragmentActivity)paramActivity).getSupportFragmentManager().findFragmentByTag("ResourceGrabFragment");
      if ((paramActivity instanceof ResourceGrabFragment)) {
        ((ResourceGrabFragment)paramActivity).evo();
      }
    }
    ResourceGrabView.a(this.b, null);
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabView", 2, "onActivityResumed activity: " + paramActivity);
    }
    ResourceGrabView.a(this.b, new WeakReference(paramActivity));
    this.b.VR(ResourceGrabView.a(this.b));
    ResourceGrabView.b(this.b);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aujn
 * JD-Core Version:    0.7.0.1
 */