import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.mobileqq.widget.ContextMenuTextView;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

@TargetApi(16)
public class hge
  implements BubblePopupWindow.OnDismissListener
{
  hge(ContextMenuTextView paramContextMenuTextView) {}
  
  public void a()
  {
    if (Build.VERSION.SDK_INT < 16) {
      ContextMenuTextView.a(this.a, null);
    }
    for (;;)
    {
      this.a.a = null;
      return;
      ContextMenuTextView.b(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hge
 * JD-Core Version:    0.7.0.1
 */