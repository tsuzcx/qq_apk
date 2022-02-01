import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyHeaderPresenter.3.1;
import java.util.ArrayList;

public class lks
  implements Animation.AnimationListener
{
  lks(lko paramlko, nhk paramnhk, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt, Object paramObject) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.b.getView().post(new ReadInJoyHeaderPresenter.3.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lks
 * JD-Core Version:    0.7.0.1
 */