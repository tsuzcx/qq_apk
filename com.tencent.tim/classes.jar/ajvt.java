import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.nearby.now.StoryPlayController;

public class ajvt
  implements URLDrawable.URLDrawableListener
{
  public ajvt(StoryPlayController paramStoryPlayController, ImageView paramImageView, ajzo paramajzo) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.bI.setImageDrawable(null);
    this.bI.setImageDrawable(paramURLDrawable);
    if (this.a != null) {
      this.a.E(paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight(), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajvt
 * JD-Core Version:    0.7.0.1
 */