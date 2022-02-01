import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class ufo
  implements TextView.OnEditorActionListener
{
  ufo(ufj paramufj) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return false;
    }
    if (ufj.a(this.a) != null) {
      ufj.a(this.a).a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufo
 * JD-Core Version:    0.7.0.1
 */