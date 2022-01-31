import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.tencent.mobileqq.activity.contacts.fragment.ContactsBaseFragment;

public class wju
  extends View.AccessibilityDelegate
{
  public wju(ContactsBaseFragment paramContactsBaseFragment) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 8) {
      i = 32768;
    }
    super.sendAccessibilityEvent(paramView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wju
 * JD-Core Version:    0.7.0.1
 */