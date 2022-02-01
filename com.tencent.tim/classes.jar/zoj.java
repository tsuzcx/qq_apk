import android.app.Activity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel.b;

class zoj
  implements EmoticonMainPanel.b
{
  zoj(zof paramzof) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.this$0.brS))
    {
      this.this$0.mWindowManager.removeView(this.this$0.b);
      this.this$0.brS = false;
      paramKeyEvent = ((Activity)this.this$0.mContext).getWindow().getAttributes();
      paramKeyEvent.y = 0;
      ((Activity)this.this$0.mContext).getWindow().setAttributes(paramKeyEvent);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zoj
 * JD-Core Version:    0.7.0.1
 */