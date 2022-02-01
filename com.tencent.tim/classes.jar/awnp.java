import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class awnp
  implements View.OnKeyListener
{
  awnp(awnm paramawnm) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramInt == 4)) {
      this.a.aiK();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awnp
 * JD-Core Version:    0.7.0.1
 */