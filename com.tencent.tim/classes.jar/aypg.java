import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class aypg
  implements TextView.OnEditorActionListener
{
  aypg(aypf paramaypf) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      paramTextView = this.b.cL;
      if (paramTextView != null) {
        paramTextView.onClick(this.b.yG);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aypg
 * JD-Core Version:    0.7.0.1
 */