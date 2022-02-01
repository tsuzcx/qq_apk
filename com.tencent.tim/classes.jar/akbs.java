import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;

class akbs
  implements URLDrawableDownListener
{
  akbs(akbr paramakbr, akbr.a parama, int paramInt) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.b.onLoadFinish(this.val$position, false);
    this.b.AY(this.val$position);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 10000)) {
      this.b.onLoadProgressUpdate(this.val$position, paramInt / 100);
    }
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.b.onLoadFinish(this.val$position, true);
    this.b.AY(this.val$position);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbs
 * JD-Core Version:    0.7.0.1
 */