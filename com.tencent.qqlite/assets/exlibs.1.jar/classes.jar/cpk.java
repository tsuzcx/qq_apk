import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class cpk
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public cpk(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onGlobalLayout()
  {
    ShortVideoPreviewActivity.a(this.a, ShortVideoUtils.a(this.a, ShortVideoPreviewActivity.a(this.a)));
    ShortVideoPreviewActivity.a(this.a).setImageBitmap(ShortVideoPreviewActivity.a(this.a));
    ShortVideoPreviewActivity.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cpk
 * JD-Core Version:    0.7.0.1
 */