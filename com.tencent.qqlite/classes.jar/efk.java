import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;

public class efk
  extends URLDrawableDownListener.Adapter
{
  public efk(StructMsgForHypertext paramStructMsgForHypertext) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView.setBackgroundDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     efk
 * JD-Core Version:    0.7.0.1
 */