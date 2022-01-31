import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;

public class gov
  extends URLDrawableDownListener.Adapter
{
  public gov(AbsShareMsg paramAbsShareMsg) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView.setBackgroundDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gov
 * JD-Core Version:    0.7.0.1
 */