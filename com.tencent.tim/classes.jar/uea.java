import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class uea
  implements URLDrawable.URLDrawableListener
{
  public uea(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      paramURLDrawable = aqhu.g(paramURLDrawable);
      QQAppInterface localQQAppInterface = this.this$0.app;
      paramURLDrawable = QQAppInterface.getCircleFaceBitmap(paramURLDrawable, 50, 50);
      this.this$0.pn.setImageDrawable(new BitmapDrawable(paramURLDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uea
 * JD-Core Version:    0.7.0.1
 */