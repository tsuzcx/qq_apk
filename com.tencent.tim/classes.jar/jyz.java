import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class jyz
  implements View.OnClickListener
{
  jyz(jyy paramjyy) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.a.mJumpType == 2)
    {
      Intent localIntent = new Intent((FragmentActivity)this.this$0.mContext, QQBrowserActivity.class);
      localIntent.putExtra("url", this.this$0.a.hL);
      this.this$0.mContext.startActivity(localIntent);
      jzk.a(this.this$0.mApp, this.this$0.Uv, this.this$0.mChannelId, this.this$0.mInfo, 3, 3, 0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.this$0.a.mJumpType == 1) {
        switch (this.this$0.aED)
        {
        case 3: 
        default: 
          break;
        case 0: 
          jyy.a(this.this$0);
          break;
        case 1: 
          jzk.launchApp(this.this$0.mContext, this.this$0.a.mPackageName);
          jzk.a(this.this$0.mApp, this.this$0.Uv, this.this$0.mChannelId, this.this$0.mInfo, 3, 1, 0);
          break;
        case 2: 
          jzk.a(this.this$0.a);
          jzk.a(this.this$0.mApp, this.this$0.Uv, this.this$0.mChannelId, this.this$0.mInfo, 3, 4, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jyz
 * JD-Core Version:    0.7.0.1
 */