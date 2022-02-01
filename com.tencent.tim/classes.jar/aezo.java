import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aezo
  implements View.OnClickListener
{
  public aezo(MessageForArkApp paramMessageForArkApp, QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.e.ark_app_message.appId))
    {
      MessageForArkApp.access$000(this.e, this.val$appInterface, this.val$mContext);
      adqu.a(this.val$appInterface, this.e.ark_app_message.appName, "AIOArkSdkTailClick", 1, 0, 0L, 0L, 0L, this.e.ark_app_message.appView, "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aezo
 * JD-Core Version:    0.7.0.1
 */