import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xmg
  implements View.OnClickListener
{
  xmg(xmb paramxmb) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = (String)paramView.getTag();
      if (!TextUtils.isEmpty(str))
      {
        Intent localIntent = new Intent(this.a.mContext, QQBrowserActivity.class);
        localIntent.putExtra("hide_more_button", true);
        localIntent.putExtra("hide_operation_bar", true);
        localIntent.putExtra("url", str);
        this.a.mContext.startActivity(localIntent);
        ((Activity)this.a.mContext).overridePendingTransition(2130772009, 0);
      }
      anot.a(this.a.app, "dc00899", "Grp_talk", "", "obj", "link_msg", 0, 0, this.a.sessionInfo.aTl, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xmg
 * JD-Core Version:    0.7.0.1
 */