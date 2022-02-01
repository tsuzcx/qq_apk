import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;

public class ammp
  implements View.OnTouchListener
{
  public ammp(AssociateSearchWordsFragment paramAssociateSearchWordsFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.b.getActivity();
    if ((paramView instanceof ActiveEntitySearchActivity)) {
      ((ActiveEntitySearchActivity)paramView).gR();
    }
    for (;;)
    {
      return false;
      if ((paramView instanceof UniteSearchActivity)) {
        ((UniteSearchActivity)paramView).gR();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ammp
 * JD-Core Version:    0.7.0.1
 */