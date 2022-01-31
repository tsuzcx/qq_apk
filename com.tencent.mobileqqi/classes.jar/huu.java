import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;
import com.tencent.widget.AbsListView;

public class huu
  extends InputConnectionWrapper
{
  public huu(AbsListView paramAbsListView, InputConnection paramInputConnection, boolean paramBoolean)
  {
    super(paramInputConnection, paramBoolean);
  }
  
  public boolean performEditorAction(int paramInt)
  {
    if (paramInt == 6)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)this.a.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(this.a.getWindowToken(), 0);
      }
      return true;
    }
    return false;
  }
  
  public boolean reportFullscreenMode(boolean paramBoolean)
  {
    return AbsListView.a(this.a).reportFullscreenMode(paramBoolean);
  }
  
  public boolean sendKeyEvent(KeyEvent paramKeyEvent)
  {
    return AbsListView.a(this.a).sendKeyEvent(paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     huu
 * JD-Core Version:    0.7.0.1
 */