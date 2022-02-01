import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController.4.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class njg
  implements View.OnClickListener
{
  public njg(SlideActiveAnimController paramSlideActiveAnimController) {}
  
  public void onClick(View paramView)
  {
    this.this$0.asz = true;
    SlideActiveAnimController.a(this.this$0, new SlideActiveAnimController.4.1(this));
    SlideActiveAnimController.a(this.this$0).postDelayed(SlideActiveAnimController.a(this.this$0), 5000L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     njg
 * JD-Core Version:    0.7.0.1
 */