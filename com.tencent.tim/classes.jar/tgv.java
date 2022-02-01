import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class tgv
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  tgv(tgq paramtgq, ImageView paramImageView) {}
  
  public void onGlobalLayout()
  {
    this.val$image.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    tld.a().g(this.val$image);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tgv
 * JD-Core Version:    0.7.0.1
 */