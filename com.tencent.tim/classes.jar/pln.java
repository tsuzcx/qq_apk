import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class pln
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  pln(plh paramplh) {}
  
  public void onGlobalLayout()
  {
    int i = plh.a(this.this$0).getHeight();
    if (i != plh.b(this.this$0)) {
      plh.a(this.this$0, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pln
 * JD-Core Version:    0.7.0.1
 */