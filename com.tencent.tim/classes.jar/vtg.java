import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.activity.SelectedAndSearchBar.a;

public class vtg
  implements View.OnKeyListener
{
  public vtg(SelectedAndSearchBar paramSelectedAndSearchBar) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 67)
    {
      if (paramKeyEvent.getAction() != 0) {
        break label36;
      }
      SelectedAndSearchBar.a(this.this$0, TextUtils.isEmpty(SelectedAndSearchBar.a(this.this$0).getText()));
    }
    for (;;)
    {
      return false;
      label36:
      if ((paramKeyEvent.getAction() == 1) && (SelectedAndSearchBar.a(this.this$0))) {
        SelectedAndSearchBar.a(this.this$0).bLZ();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     vtg
 * JD-Core Version:    0.7.0.1
 */