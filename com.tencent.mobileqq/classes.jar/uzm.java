import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

final class uzm
  implements View.OnKeyListener
{
  uzm(uzl paramuzl) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.a.dismiss();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzm
 * JD-Core Version:    0.7.0.1
 */