import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import java.lang.ref.WeakReference;

public class ynj
  implements View.OnLongClickListener
{
  private WeakReference a;
  
  public ynj(BuddyListAdapter paramBuddyListAdapter)
  {
    this.a = new WeakReference(paramBuddyListAdapter);
  }
  
  public boolean onLongClick(View paramView)
  {
    BuddyListAdapter localBuddyListAdapter = (BuddyListAdapter)this.a.get();
    if (localBuddyListAdapter != null) {
      return localBuddyListAdapter.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ynj
 * JD-Core Version:    0.7.0.1
 */