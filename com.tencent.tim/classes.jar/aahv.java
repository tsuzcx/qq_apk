import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;

class aahv
  implements View.OnClickListener
{
  aahv(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(aahb.a(this.this$0), QQBrowserActivity.class);
    localIntent.putExtra("uin", ((QQAppInterface)aahb.a(this.this$0).getAppRuntime()).getCurrentAccountUin());
    Pair localPair = (Pair)paramView.getTag();
    if (localPair != null) {
      aahb.a(this.this$0).startActivity(localIntent.putExtra("url", "https://qzs.qq.com/iot/mobile/xiaowei-qq-proxy/index.html?din=" + ((Long)localPair.first).longValue() + "&deviceRemark=" + (String)localPair.second));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aahv
 * JD-Core Version:    0.7.0.1
 */