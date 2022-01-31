import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ukz
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ukz(ukt paramukt) {}
  
  public void onGlobalLayout()
  {
    int i = ukt.a(this.a).getHeight();
    if (i != ukt.b(this.a)) {
      ukt.a(this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ukz
 * JD-Core Version:    0.7.0.1
 */