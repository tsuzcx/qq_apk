import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.MultiVideoMembersHolderUI;
import com.tencent.av.utils.MultiVideoMembersClickListener;

public class bkl
  implements View.OnTouchListener
{
  public bkl(MultiVideoMembersHolderUI paramMultiVideoMembersHolderUI) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
    return paramMotionEvent.getAction() == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkl
 * JD-Core Version:    0.7.0.1
 */