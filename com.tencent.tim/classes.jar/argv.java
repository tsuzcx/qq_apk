import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class argv
  implements View.OnKeyListener
{
  argv(argu paramargu) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      argu.a(this.b);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     argv
 * JD-Core Version:    0.7.0.1
 */