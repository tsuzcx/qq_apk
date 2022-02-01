import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.widget.SwipListView.a;

public class ynj
  implements SwipListView.a
{
  public ynj(AddContactsView paramAddContactsView) {}
  
  public void onRightIconMenuHide(View paramView)
  {
    AddContactsView.b(this.this$0, true);
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    AddContactsView.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ynj
 * JD-Core Version:    0.7.0.1
 */