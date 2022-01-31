import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ShowReactiveActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.statistics.ReportController;

public class vyl
  implements View.OnTouchListener
{
  public vyl(FriendChatPie paramFriendChatPie) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.a.e.setImageAlpha(127);
      }
      else
      {
        this.a.e.setAlpha(127);
        continue;
        if (Build.VERSION.SDK_INT >= 16) {
          this.a.e.setImageAlpha(255);
        }
        for (;;)
        {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007602", "0X8007602", 0, 0, "", "", "", "");
          paramView = new Intent(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ShowReactiveActivity.class);
          paramView.putExtra("friendUin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramView);
          break;
          this.a.e.setAlpha(255);
        }
        if (Build.VERSION.SDK_INT >= 16) {
          this.a.e.setImageAlpha(255);
        } else {
          this.a.e.setAlpha(255);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyl
 * JD-Core Version:    0.7.0.1
 */