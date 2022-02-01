import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxView;

public class tmh
  implements TextView.OnEditorActionListener
{
  public tmh(GdtFormItemTextBoxView paramGdtFormItemTextBoxView) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      tkw.i("GdtFormItemTextBoxView", "onEditorActionDone " + GdtFormItemTextBoxView.b(this.a));
      GdtFormItemTextBoxView.a(this.a).clearFocus();
      GdtFormItemTextBoxView.r(paramTextView);
    }
    for (;;)
    {
      return false;
      tkw.i("GdtFormItemTextBoxView", "onEditorAction " + paramInt + " " + GdtFormItemTextBoxView.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tmh
 * JD-Core Version:    0.7.0.1
 */