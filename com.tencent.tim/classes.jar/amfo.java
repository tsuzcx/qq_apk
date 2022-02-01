import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;

public class amfo
  implements TextView.OnEditorActionListener
{
  public amfo(SignTextEditFragment paramSignTextEditFragment) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)) {
      aurd.hide(paramTextView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amfo
 * JD-Core Version:    0.7.0.1
 */