import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqkw
  implements View.OnClickListener
{
  aqkw(aqku paramaqku, int paramInt, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    long l2 = System.currentTimeMillis();
    Object localObject = paramView.getTag();
    if ((localObject instanceof Long)) {}
    for (long l1 = ((Long)localObject).longValue();; l1 = 0L)
    {
      if (l2 - l1 < 300L)
      {
        QLog.i("QQCustomDialogWithForwardAvatar", 2, "click in 300ms clickTime: " + l1 + " newTime :" + l2);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      paramView.setTag(Long.valueOf(l2));
      if ((this.alR == 1) || (this.alR == 3000)) {
        anot.a(this.val$app, "CliOper", "", "", "0X8009BE8", "0X8009BE8", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        this.a.hideSoftInputFromWindow();
        MiniChatActivity.a(this.val$activity, this.alR, this.val$uin, this.ctZ, 0.86F, this.a.a(this.val$activity, 0.78F));
        break;
        anot.a(this.val$app, "CliOper", "", "", "0X8009BE6", "0X8009BE6", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqkw
 * JD-Core Version:    0.7.0.1
 */