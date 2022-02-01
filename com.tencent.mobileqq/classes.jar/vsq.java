import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import rx.Observable;
import rx.functions.Func1;

public class vsq
  implements Func1<Drawable, Bitmap>
{
  public vsq(RoundImageView paramRoundImageView) {}
  
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
 * Qualified Name:     vsq
 * JD-Core Version:    0.7.0.1
 */