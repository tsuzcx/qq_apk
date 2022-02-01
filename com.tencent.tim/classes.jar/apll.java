import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

class apll
  implements View.OnKeyListener
{
  apll(aplj paramaplj, aplj.a parama) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramInt == 67) && (this.a.mEditText.getSelectionStart() == 0))
    {
      this.this$0.a.i(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apll
 * JD-Core Version:    0.7.0.1
 */