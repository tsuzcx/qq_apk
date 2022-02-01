import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.b;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aixl
  implements View.OnClickListener
{
  public aixl(PngFrameManager.1 param1) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.c.progressBar.getVisibility() == 0) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.a.c.sS.getVisibility() == 0)
      {
        this.a.a.cmx = true;
        this.a.a.c.progressBar.setVisibility(0);
        this.a.this$0.e(this.a.a);
        if (this.a.a.a != null) {
          this.a.a.a.e(this.a.a.c);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixl
 * JD-Core Version:    0.7.0.1
 */