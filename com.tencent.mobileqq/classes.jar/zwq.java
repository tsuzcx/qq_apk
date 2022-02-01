import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class zwq
  implements TextView.OnEditorActionListener
{
  zwq(zwk paramzwk) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return false;
    }
    if (zwk.a(this.a) != null) {
      zwk.a(this.a).a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwq
 * JD-Core Version:    0.7.0.1
 */