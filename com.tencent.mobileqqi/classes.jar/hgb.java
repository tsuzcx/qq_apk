import android.content.Context;
import android.text.Selection;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.tencent.mobileqq.widget.ContainerView.SelectableTextView;

public class hgb
  implements View.OnLongClickListener
{
  public hgb(ContainerView.SelectableTextView paramSelectableTextView) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.getSelectionEnd() - this.a.getSelectionStart() > 0)
    {
      this.a.onTextContextMenuItem(16908321);
      Toast.makeText(this.a.getContext(), this.a.getContext().getString(2131559338), 0).show();
    }
    for (;;)
    {
      return true;
      try
      {
        Selection.setSelection((Spannable)this.a.getText(), Math.max(ContainerView.SelectableTextView.a(this.a) - 50, 0), Math.min(ContainerView.SelectableTextView.a(this.a) + 50, this.a.getText().length()));
        this.a.onTextContextMenuItem(16908328);
        ((InputMethodManager)this.a.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          Selection.setSelection((Spannable)this.a.getText(), ContainerView.SelectableTextView.a(this.a), ContainerView.SelectableTextView.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hgb
 * JD-Core Version:    0.7.0.1
 */