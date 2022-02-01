import android.content.Context;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ContextMenuTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arfa
  implements View.OnClickListener
{
  public arfa(ContextMenuTextView paramContextMenuTextView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365509)
    {
      Context localContext = ContextMenuTextView.a(this.b);
      ContextMenuTextView.a(this.b);
      ((ClipboardManager)localContext.getSystemService("clipboard")).setText(this.b.getText().toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arfa
 * JD-Core Version:    0.7.0.1
 */