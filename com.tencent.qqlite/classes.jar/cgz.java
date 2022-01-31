import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;

public class cgz
  implements View.OnKeyListener, TextView.OnEditorActionListener
{
  private cgz(MessageSearchDialog paramMessageSearchDialog) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 3)
    {
      MessageSearchDialog.a(this.a);
      return true;
    }
    return false;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 66) || (paramKeyEvent.getKeyCode() == 84))
    {
      if (paramKeyEvent.getAction() == 1) {
        MessageSearchDialog.a(this.a);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cgz
 * JD-Core Version:    0.7.0.1
 */