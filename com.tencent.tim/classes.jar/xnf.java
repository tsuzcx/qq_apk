import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xnf
  implements View.OnClickListener
{
  public xnf(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, boolean paramBoolean1, boolean paramBoolean2, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.clickTime != 0L) && (System.currentTimeMillis() - this.this$0.clickTime <= 300L)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.clickTime = System.currentTimeMillis();
      if ((this.bhS) && (this.bhT)) {
        anhq.a().a((Activity)this.this$0.mContext, this.val$app, this.this$0.sessionInfo);
      } else {
        QLog.d("ShortVideoRealItemBuilder", 1, String.format("not support dance Pendant, codec[%s], entry[%s]", new Object[] { Boolean.valueOf(this.bhS), Boolean.valueOf(this.bhT) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xnf
 * JD-Core Version:    0.7.0.1
 */