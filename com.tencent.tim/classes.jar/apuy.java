import android.graphics.Color;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.widget.HotChatPostItemView;
import com.tencent.mobileqq.troop.widget.HotChatPostItemView.1.1;

public final class apuy
  implements URLDrawable.URLDrawableListener
{
  public apuy(ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, String paramString, URLDrawable paramURLDrawable, float paramFloat, int paramInt4) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.val$imageView.setImageDrawable(null);
    this.val$imageView.setBackgroundColor(Color.parseColor("#e7e7e7"));
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (this.dWW != 0)
    {
      this.val$imageView.setBackgroundResource(this.dWW);
      return;
    }
    this.val$imageView.setImageDrawable(null);
    this.val$imageView.setBackgroundColor(Color.parseColor("#e7e7e7"));
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.val$imageView.setImageDrawable(null);
    if ((this.ber != 0) && (this.dWV != 0) && (this.val$screenWidth != 0))
    {
      ThreadManager.post(new HotChatPostItemView.1.1(this), 5, null, true);
      return;
    }
    this.val$imageView.setImageDrawable(HotChatPostItemView.a(this.g, this.Ax));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apuy
 * JD-Core Version:    0.7.0.1
 */