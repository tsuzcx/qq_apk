import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class lda
  implements View.OnClickListener
{
  lda(lcz paramlcz, FrameLayout paramFrameLayout, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    lcz.a(this.this$0).onDestroy();
    this.W.removeView(lcz.a(this.this$0));
    lcz.a(this.this$0, null);
    if (261 == this.aJg) {
      aqmj.ag(lcz.a(this.this$0), this.val$app.getCurrentAccountUin(), null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lda
 * JD-Core Version:    0.7.0.1
 */