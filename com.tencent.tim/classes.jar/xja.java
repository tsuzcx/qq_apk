import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xja
  implements View.OnClickListener
{
  xja(xiz paramxiz) {}
  
  public void onClick(View paramView)
  {
    wja.bcO = true;
    if (this.a.Rk()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localMessageForText = (MessageForText)wja.a(paramView);
      try
      {
        ((FragmentActivity)this.a.mContext).getChatFragment().a().bIs();
        Intent localIntent = new Intent(paramView.getContext(), PoiMapActivity.class).putExtra("lat", localMessageForText.latitude).putExtra("lon", localMessageForText.longitude).putExtra("url", localMessageForText.url).putExtra("loc", localMessageForText.location).putExtra("uin", this.a.app.getAccount());
        ((BaseActivity)this.a.mContext).startActivityForResult(localIntent, 18);
        i = 1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          try
          {
            ((Activity)this.a.mContext).startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(localMessageForText.url)), 0);
            i = 1;
          }
          catch (Exception localException1)
          {
            int i = 0;
          }
        }
      }
      if ((i != 0) && (((this.a.mContext instanceof SplashActivity)) || ((this.a.mContext instanceof ChatActivity)))) {
        ((BaseActivity)this.a.mContext).setCanLock(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xja
 * JD-Core Version:    0.7.0.1
 */