import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xne
  implements View.OnClickListener
{
  public xne(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.clickTime != 0L) && (System.currentTimeMillis() - this.this$0.clickTime <= 500L)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.clickTime = System.currentTimeMillis();
      anjo.a(this.val$app).ce((Activity)this.this$0.mContext);
      aaqi.ec("", "0X8008CEB");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xne
 * JD-Core Version:    0.7.0.1
 */