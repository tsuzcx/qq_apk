import android.view.View;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;

public class bvx
  implements AnimationTextView.OnDoubleClick
{
  public bvx(MixedMsgItemBuilder paramMixedMsgItemBuilder) {}
  
  public void a(View paramView)
  {
    if (MixedMsgItemBuilder.b(this.a)) {
      return;
    }
    ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (ChatActivity)this.a.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bvx
 * JD-Core Version:    0.7.0.1
 */