import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class wig
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  wig(wia paramwia) {}
  
  public void onGlobalLayout()
  {
    int i = wia.a(this.a).getHeight();
    if (i != wia.b(this.a)) {
      wia.a(this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wig
 * JD-Core Version:    0.7.0.1
 */