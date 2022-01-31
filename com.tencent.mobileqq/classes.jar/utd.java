import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.item.DeviceTextItemBuilder;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;

public class utd
  implements AnimationTextView.OnDoubleClick
{
  public utd(DeviceTextItemBuilder paramDeviceTextItemBuilder) {}
  
  public void a(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.m = true;
    if (DeviceTextItemBuilder.a(this.a)) {
      return;
    }
    ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     utd
 * JD-Core Version:    0.7.0.1
 */