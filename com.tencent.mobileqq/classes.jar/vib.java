import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationSet;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;

public class vib
  implements Runnable
{
  public vib(UnlimitedBladeWorks paramUnlimitedBladeWorks, Activity paramActivity, int paramInt) {}
  
  public void run()
  {
    if (((Build.VERSION.SDK_INT > 16) && (this.jdField_a_of_type_AndroidAppActivity.isDestroyed())) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {}
    View localView;
    AnimationSet localAnimationSet;
    do
    {
      return;
      localView = ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).getChildAt(0).findViewById(2131363473);
      localAnimationSet = UnlimitedBladeWorks.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks, this.jdField_a_of_type_Int);
    } while (localView == null);
    localView.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vib
 * JD-Core Version:    0.7.0.1
 */