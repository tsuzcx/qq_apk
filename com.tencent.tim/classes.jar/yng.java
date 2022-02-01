import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.SwipListView;

public class yng
  implements abex.c
{
  public yng(AddContactsView paramAddContactsView) {}
  
  public void bUJ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "onAllRecommendsCaneled _B");
    }
    this.this$0.il.setVisibility(8);
    this.this$0.o.setVisibility(8);
    this.this$0.g.setVisibility(8);
  }
  
  public void bUK()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "onRecommendsAvailable _B");
    }
    this.this$0.il.setVisibility(0);
    this.this$0.o.setVisibility(0);
    this.this$0.cjS();
    this.this$0.g.getViewTreeObserver().addOnGlobalLayoutListener(new ynh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yng
 * JD-Core Version:    0.7.0.1
 */