import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xcj
  implements View.OnClickListener
{
  xcj(xci paramxci, long paramLong) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uinType", this.this$0.sessionInfo.cZ);
    localIntent.putExtra("uniseq", this.rJ);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.b.start(paramView.getContext(), localIntent, PublicTransFragmentActivity.class, ScoreQAVFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xcj
 * JD-Core Version:    0.7.0.1
 */