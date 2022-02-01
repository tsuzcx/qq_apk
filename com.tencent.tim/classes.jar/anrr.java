import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;

public class anrr
  extends URLDrawableDownListener.Adapter
{
  public anrr(StructMsgForHypertext paramStructMsgForHypertext) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView.setBackgroundDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anrr
 * JD-Core Version:    0.7.0.1
 */