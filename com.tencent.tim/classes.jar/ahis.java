import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel.b;

class ahis
  implements EmoticonMainPanel.b
{
  ahis(ahio paramahio) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (ahio.a(this.this$0)))
    {
      ahio.a(this.this$0).removeView(ahio.a(this.this$0));
      ahio.a(this.this$0, false);
      paramKeyEvent = this.this$0.getWindow().getAttributes();
      paramKeyEvent.y = 0;
      this.this$0.getWindow().setAttributes(paramKeyEvent);
      ahio.a(this.this$0);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahis
 * JD-Core Version:    0.7.0.1
 */