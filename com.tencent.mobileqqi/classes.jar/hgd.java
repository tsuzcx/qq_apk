import android.app.Dialog;
import android.content.Context;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ContextMenuTextView;

public class hgd
  implements View.OnClickListener
{
  public hgd(ContextMenuTextView paramContextMenuTextView) {}
  
  public void onClick(View paramView)
  {
    if ((ContextMenuTextView.a(this.a) != null) && (ContextMenuTextView.a(this.a).isShowing())) {
      ContextMenuTextView.a(this.a).dismiss();
    }
    if (paramView.getId() == 2131234879)
    {
      paramView = ContextMenuTextView.a(this.a);
      ContextMenuTextView.a(this.a);
      ((ClipboardManager)paramView.getSystemService("clipboard")).setText(this.a.getText().toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hgd
 * JD-Core Version:    0.7.0.1
 */