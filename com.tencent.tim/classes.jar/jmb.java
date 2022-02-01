import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.widget.RatingBar;
import com.tencent.av.widget.RatingBar.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jmb
  implements View.OnClickListener
{
  public jmb(RatingBar paramRatingBar) {}
  
  public void onClick(View paramView)
  {
    if (RatingBar.a(this.a))
    {
      RatingBar.a(this.a, this.a.indexOfChild(paramView) + 1);
      this.a.setStar(RatingBar.a(this.a), true);
      if (RatingBar.a(this.a) != null) {
        RatingBar.a(this.a).c(RatingBar.a(this.a), RatingBar.a(this.a));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jmb
 * JD-Core Version:    0.7.0.1
 */