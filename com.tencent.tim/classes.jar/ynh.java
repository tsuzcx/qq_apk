import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.widget.SwipListView;

class ynh
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ynh(yng paramyng) {}
  
  public void onGlobalLayout()
  {
    this.a.this$0.g.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.a.this$0.setListViewHeightBasedOnChildren(this.a.this$0.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ynh
 * JD-Core Version:    0.7.0.1
 */