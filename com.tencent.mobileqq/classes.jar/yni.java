import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import java.lang.ref.WeakReference;

public class yni
  implements View.OnClickListener
{
  private WeakReference a;
  
  public yni(BuddyListAdapter paramBuddyListAdapter)
  {
    this.a = new WeakReference(paramBuddyListAdapter);
  }
  
  public void onClick(View paramView)
  {
    BuddyListAdapter localBuddyListAdapter = (BuddyListAdapter)this.a.get();
    if (localBuddyListAdapter != null) {
      localBuddyListAdapter.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yni
 * JD-Core Version:    0.7.0.1
 */