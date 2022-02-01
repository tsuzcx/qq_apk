import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.widget.BounceScrollView.c;
import com.tencent.mobileqq.widget.FormMutiItem;

public class yne
  implements BounceScrollView.c
{
  public yne(AddContactsView paramAddContactsView) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.this$0.j != null)
    {
      if (paramInt2 < this.this$0.j.getY() + this.this$0.j.getHeight() * 2 / 3) {
        break label74;
      }
      if ((this.this$0.h != null) && (this.this$0.h.isShowing())) {
        AddContactsView.a(this.this$0, false);
      }
    }
    return;
    label74:
    AddContactsView.a(this.this$0);
  }
  
  public void w(float paramFloat1, float paramFloat2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yne
 * JD-Core Version:    0.7.0.1
 */