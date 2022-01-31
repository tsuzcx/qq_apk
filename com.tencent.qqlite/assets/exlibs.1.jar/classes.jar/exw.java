import android.content.Context;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ContextMenuTextView;

public class exw
  implements View.OnClickListener
{
  public exw(ContextMenuTextView paramContextMenuTextView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131298937)
    {
      paramView = ContextMenuTextView.a(this.a);
      ContextMenuTextView.a(this.a);
      ((ClipboardManager)paramView.getSystemService("clipboard")).setText(this.a.getText().toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     exw
 * JD-Core Version:    0.7.0.1
 */