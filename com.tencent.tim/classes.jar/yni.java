import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.widget.SwipListView;

public class yni
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public yni(AddContactsView paramAddContactsView) {}
  
  public void onGlobalLayout()
  {
    this.this$0.g.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.this$0.setListViewHeightBasedOnChildren(this.this$0.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yni
 * JD-Core Version:    0.7.0.1
 */