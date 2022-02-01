import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

final class opp
  implements URLDrawable.URLDrawableListener
{
  opp(String paramString, RoundImageView paramRoundImageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    ooz.e("AvatarImageLog", "WeishiUtils loadAvatarImage onFail url:" + this.aot + ", imageView:" + this.f);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ooz.d("AvatarImageLog", "WeishiUtils loadAvatarImage onSuccess url:" + this.aot + ", imageView:" + this.f);
    this.f.setImageDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     opp
 * JD-Core Version:    0.7.0.1
 */