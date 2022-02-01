import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment;

public class aorc
  implements View.OnTouchListener
{
  public aorc(TribeVideoPreviewFragment paramTribeVideoPreviewFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.this$0.getActivity().finish();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aorc
 * JD-Core Version:    0.7.0.1
 */