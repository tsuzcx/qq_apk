import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.ShakeItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.qphone.base.util.QLog;

public class bxr
  implements View.OnClickListener
{
  public bxr(ShakeItemBuilder paramShakeItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "shake msg onClick() is called");
    }
    if (ShakeItemBuilder.a(this.a)) {
      return;
    }
    paramView = (MessageForShakeWindow)AIOUtils.a(paramView);
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof ChatActivity))
    {
      ((ChatActivity)this.a.jdField_a_of_type_AndroidContentContext).a().T();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramView.frienduin, false);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramView.frienduin, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bxr
 * JD-Core Version:    0.7.0.1
 */