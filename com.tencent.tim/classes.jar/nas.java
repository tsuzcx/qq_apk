import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoLoadingFooter;

public class nas
  implements View.OnLayoutChangeListener
{
  public nas(MultiVideoLoadingFooter paramMultiVideoLoadingFooter) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.b.removeOnLayoutChangeListener(this);
    this.b.getLayoutParams().height = (((View)this.b.getParent()).getHeight() * 2 / 3);
    this.b.setLayoutParams(this.b.getLayoutParams());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nas
 * JD-Core Version:    0.7.0.1
 */