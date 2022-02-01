import android.view.View;
import android.widget.TextView;
import com.tencent.widget.BubblePopupWindow.b;

class uzk
  implements BubblePopupWindow.b
{
  uzk(uzi paramuzi, View paramView) {}
  
  public void onDismiss()
  {
    this.a.Bw = false;
    if ((this.val$view instanceof TextView)) {
      this.a.h((TextView)this.val$view);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uzk
 * JD-Core Version:    0.7.0.1
 */