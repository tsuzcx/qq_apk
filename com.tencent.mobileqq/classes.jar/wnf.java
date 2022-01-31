import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class wnf
  implements TextView.OnEditorActionListener
{
  wnf(wnb paramwnb) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return false;
    }
    if (wnb.a(this.a) != null) {
      wnb.a(this.a).a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wnf
 * JD-Core Version:    0.7.0.1
 */