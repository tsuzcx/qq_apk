import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel.a;

class aqkq
  implements SystemEmoticonPanel.a
{
  aqkq(aqkk paramaqkk) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.this$0.brS))
    {
      this.this$0.mWindowManager.removeView(this.this$0.c);
      this.this$0.brS = false;
      paramKeyEvent = this.this$0.getWindow().getAttributes();
      paramKeyEvent.y = 0;
      this.this$0.getWindow().setAttributes(paramKeyEvent);
      aqkk.a(this.this$0);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqkq
 * JD-Core Version:    0.7.0.1
 */