import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class jtn
  implements View.OnClickListener
{
  jtn(jtg paramjtg, jtg.b paramb) {}
  
  public void onClick(View paramView)
  {
    this.a.errorTips.setText(2131697448);
    this.a.nu.setVisibility(4);
    this.a.hs.setVisibility(4);
    juc.b(this.this$0.app, Long.parseLong(this.this$0.uin), ((AccountDetailActivity)this.this$0.s).a());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jtn
 * JD-Core Version:    0.7.0.1
 */