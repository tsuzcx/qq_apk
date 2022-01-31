import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;

public class vqh
  implements Runnable
{
  public vqh(UnlimitedBladeWorks paramUnlimitedBladeWorks, Activity paramActivity) {}
  
  public void run()
  {
    if (((Build.VERSION.SDK_INT > 16) && (this.jdField_a_of_type_AndroidAppActivity.isDestroyed())) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {}
    View localView;
    do
    {
      return;
      localView = ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).getChildAt(0).findViewById(2131363510);
    } while (localView == null);
    localView.clearAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vqh
 * JD-Core Version:    0.7.0.1
 */