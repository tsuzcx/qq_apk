import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import rx.Observable;
import rx.functions.Func1;

public class uwc
  implements Func1<Drawable, Bitmap>
{
  public uwc(RoundImageView paramRoundImageView) {}
  
  public Bitmap a(Drawable paramDrawable)
  {
    paramDrawable = RoundImageView.a(this.a, paramDrawable);
    if (paramDrawable == null) {
      Observable.error(new Throwable("bitmap is null"));
    }
    return paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwc
 * JD-Core Version:    0.7.0.1
 */