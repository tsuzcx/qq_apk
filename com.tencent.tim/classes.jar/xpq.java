import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xpq
  implements View.OnClickListener
{
  public xpq(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder) {}
  
  public void onClick(View paramView)
  {
    TribeShortVideoItemBuilder.b localb = (TribeShortVideoItemBuilder.b)wja.a(paramView);
    if (paramView == localb.be) {
      this.this$0.b(localb);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == localb.X) {
        this.this$0.a(localb);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpq
 * JD-Core Version:    0.7.0.1
 */