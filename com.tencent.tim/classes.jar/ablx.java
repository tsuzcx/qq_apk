import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.apollo.game.WebGameFakeView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ablx
  implements View.OnClickListener
{
  public ablx(WebGameFakeView paramWebGameFakeView, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    able.a().cZ(null);
    if (able.a().zD() <= 1) {
      this.val$imageView.setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ablx
 * JD-Core Version:    0.7.0.1
 */