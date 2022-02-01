import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeShareView;

public class ltl
  implements View.OnTouchListener
{
  public ltl(NativeShareView paramNativeShareView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getAction() == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ltl
 * JD-Core Version:    0.7.0.1
 */