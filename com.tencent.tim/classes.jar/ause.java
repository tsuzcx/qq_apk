import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;
import com.tencent.widget.AbsListView;

public class ause
  extends InputConnectionWrapper
{
  public ause(AbsListView paramAbsListView, InputConnection paramInputConnection, boolean paramBoolean)
  {
    super(paramInputConnection, paramBoolean);
  }
  
  public boolean performEditorAction(int paramInt)
  {
    if (paramInt == 6)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)this.this$0.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(this.this$0.getWindowToken(), 0);
      }
      return true;
    }
    return false;
  }
  
  public boolean reportFullscreenMode(boolean paramBoolean)
  {
    return AbsListView.access$3400(this.this$0).reportFullscreenMode(paramBoolean);
  }
  
  public boolean sendKeyEvent(KeyEvent paramKeyEvent)
  {
    return AbsListView.access$3400(this.this$0).sendKeyEvent(paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ause
 * JD-Core Version:    0.7.0.1
 */