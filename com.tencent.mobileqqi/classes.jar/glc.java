import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;

public class glc
  extends URLDrawableDownListener.Adapter
{
  public glc(StructMsgItemCover paramStructMsgItemCover) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView.setBackgroundDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     glc
 * JD-Core Version:    0.7.0.1
 */