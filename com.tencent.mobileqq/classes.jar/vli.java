import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.VIPDonateMsgItemBuilder;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.VIPDonateMsg;
import com.tencent.qphone.base.util.QLog;

public class vli
  implements View.OnClickListener
{
  public vli(VIPDonateMsgItemBuilder paramVIPDonateMsgItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (VIPDonateMsgItemBuilder.a(this.a)) {
      return;
    }
    paramView = (MessageForVIPDonate)((vlj)AIOUtils.a(paramView)).a;
    Object localObject = paramView.donateMsg;
    if ((localObject != null) && (!TextUtils.isEmpty(((VIPDonateMsg)localObject).jumpUrl)))
    {
      paramView = paramView.donateMsg.jumpUrl;
      localObject = new Intent(VIPDonateMsgItemBuilder.a(this.a), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      VIPDonateMsgItemBuilder.a(this.a).startActivity((Intent)localObject);
      return;
    }
    QLog.e("VIPDonateMsgItemBuilder", 1, "donatemsg jumpurl empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vli
 * JD-Core Version:    0.7.0.1
 */