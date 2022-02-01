import android.app.Activity;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.mini.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;

class kon
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  kon(koj paramkoj, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onSoftKeyboardClosed()
  {
    if (System.currentTimeMillis() - koj.a(this.this$0) > 500L)
    {
      this.o.topMargin = wja.dp2px(140.5F, koj.a(this.this$0).getResources());
      koj.a(this.this$0).setLayoutParams(this.o);
      koj.b(this.this$0, System.currentTimeMillis());
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    if (System.currentTimeMillis() - koj.a(this.this$0) > 500L)
    {
      this.o.topMargin = wja.dp2px(40.0F, koj.a(this.this$0).getResources());
      koj.a(this.this$0).setLayoutParams(this.o);
      koj.b(this.this$0, System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kon
 * JD-Core Version:    0.7.0.1
 */