import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import java.lang.ref.WeakReference;

public class ydt
  implements View.OnLongClickListener
{
  private WeakReference a;
  
  public ydt(BuddyListAdapter paramBuddyListAdapter)
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
 * Qualified Name:     ydt
 * JD-Core Version:    0.7.0.1
 */