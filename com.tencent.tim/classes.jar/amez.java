import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amez
  implements View.OnClickListener
{
  amez(amey paramamey) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(amey.a(this.this$0).mActivity, PublicFragmentActivity.class);
    localIntent.putExtra("key_uin", amey.a(this.this$0).sessionInfo.aTl);
    localIntent.putExtra("key_uin_name", amey.a(this.this$0).sessionInfo.aTn);
    localIntent.putExtra("key_open_via", "history-liaotian");
    PublicFragmentActivity.b.start(amey.a(this.this$0).mActivity, localIntent, PublicFragmentActivity.class, SignatureHistoryFragment.class);
    amey.a(this.this$0).app.reportClickEvent("CliOper", "0X800A66B");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amez
 * JD-Core Version:    0.7.0.1
 */