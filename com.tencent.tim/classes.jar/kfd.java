import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class kfd
  implements View.OnClickListener
{
  kfd(kfa paramkfa) {}
  
  public void onClick(View paramView)
  {
    Context localContext = paramView.getContext();
    Intent localIntent = new Intent(localContext, AccountDetailActivity.class);
    localIntent.putExtra("uin", String.valueOf(3434959637L));
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("source", 121);
    localContext.startActivity(localIntent);
    kbp.a(null, "", "0X8009941", "0X8009941", 0, 0, "", "", "", "", false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kfd
 * JD-Core Version:    0.7.0.1
 */