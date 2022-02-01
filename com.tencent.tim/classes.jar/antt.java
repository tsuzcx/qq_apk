import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;

class antt
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  antt(ants paramants, LinearLayout paramLinearLayout) {}
  
  public void onGlobalLayout()
  {
    this.kE.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    ants.a(this.a, this.kE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     antt
 * JD-Core Version:    0.7.0.1
 */