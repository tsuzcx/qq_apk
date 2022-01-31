import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxView;

public class zaz
  implements TextView.OnEditorActionListener
{
  public zaz(GdtFormItemTextBoxView paramGdtFormItemTextBoxView) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      yxs.b("GdtFormItemTextBoxView", "onEditorActionDone " + GdtFormItemTextBoxView.b(this.a));
      GdtFormItemTextBoxView.a(this.a).clearFocus();
      GdtFormItemTextBoxView.a(paramTextView);
    }
    for (;;)
    {
      return false;
      yxs.b("GdtFormItemTextBoxView", "onEditorAction " + paramInt + " " + GdtFormItemTextBoxView.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zaz
 * JD-Core Version:    0.7.0.1
 */