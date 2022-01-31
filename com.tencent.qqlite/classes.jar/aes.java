import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.widget.XListView;

public class aes
  implements Runnable
{
  public aes(ChatSettingForTroop paramChatSettingForTroop, int paramInt) {}
  
  public void run()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ArrayOfAndroidViewView[this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.ap];
    if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentWidgetXListView != null))
    {
      Object localObject = new DisplayMetrics();
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getWindow().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      int[] arrayOfInt = new int[2];
      localView.getLocationOnScreen(arrayOfInt);
      if (arrayOfInt[1] + localView.getMeasuredHeight() >= ((DisplayMetrics)localObject).heightPixels) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_Int);
      }
      localObject = new AlphaAnimation(0.1F, 1.0F);
      ((AlphaAnimation)localObject).setDuration(1500L);
      localView.startAnimation((Animation)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     aes
 * JD-Core Version:    0.7.0.1
 */