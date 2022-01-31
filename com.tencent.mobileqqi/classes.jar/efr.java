import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.ShakeItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.qphone.base.util.QLog;

public class efr
  implements View.OnClickListener
{
  public efr(ShakeItemBuilder paramShakeItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "shake msg onClick() is called");
    }
    paramView = (MessageForShakeWindow)AIOUtils.a(paramView);
    if ((ShakeItemBuilder.a(this.a) instanceof ChatActivity))
    {
      ((ChatActivity)ShakeItemBuilder.b(this.a)).u();
      ShakeItemBuilder.a(this.a).b(paramView.frienduin, false);
      return;
    }
    ShakeItemBuilder.b(this.a).b(paramView.frienduin, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     efr
 * JD-Core Version:    0.7.0.1
 */