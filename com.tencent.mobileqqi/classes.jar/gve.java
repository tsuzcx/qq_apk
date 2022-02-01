import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.troop.data.TroopBarPostAbsLayout;

public class gve
  extends URLDrawableDownListener.Adapter
{
  public gve(TroopBarPostAbsLayout paramTroopBarPostAbsLayout) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView.setVisibility(8);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gve
 * JD-Core Version:    0.7.0.1
 */