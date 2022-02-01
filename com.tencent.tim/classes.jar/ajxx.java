import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajxx
  implements View.OnClickListener
{
  ajxx(ajxw paramajxw, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getContext();
    if ((localObject instanceof BaseActivity))
    {
      localObject = (BaseActivity)localObject;
      if ((((BaseActivity)localObject).app == null) || (this.adD != Long.parseLong(((BaseActivity)localObject).app.getCurrentAccountUin()))) {}
    }
    for (int i = 2;; i = 3)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("&from=3");
      ((StringBuilder)localObject).append("&mode=" + i);
      ((StringBuilder)localObject).append("&now_id=" + this.adE);
      ((StringBuilder)localObject).append("&now_user_type=" + this.adF);
      localObject = "mqq://card/show_pslcard/?uin=" + this.adD + "&card_type=nearby" + ((StringBuilder)localObject).toString();
      paramView.getContext().startActivity(new Intent(paramView.getContext(), JumpActivity.class).setData(Uri.parse((String)localObject)));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajxx
 * JD-Core Version:    0.7.0.1
 */