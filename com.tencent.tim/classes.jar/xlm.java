import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xlm
  implements View.OnClickListener
{
  public xlm(QQStoryItemBuilder paramQQStoryItemBuilder) {}
  
  public void onClick(View paramView)
  {
    QQStoryItemBuilder.b localb = (QQStoryItemBuilder.b)wja.a(paramView);
    if (paramView == localb.be) {
      this.this$0.b(localb);
    }
    for (;;)
    {
      anot.a(this.this$0.app, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "5", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == localb.X) {
        this.this$0.a(localb);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xlm
 * JD-Core Version:    0.7.0.1
 */