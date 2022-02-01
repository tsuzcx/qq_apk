import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;

public class ofe
{
  private oay.a a;
  private URLDrawableDownListener b = new off(this);
  
  private URLDrawable getDrawable(String paramString, boolean paramBoolean)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = paramBoolean;
    paramString = URLDrawable.getDrawable(oay.d(paramString), (URLDrawable.URLDrawableOptions)localObject);
    if ((paramString.getCurrDrawable() instanceof GifDrawable))
    {
      localObject = ((GifDrawable)paramString.getCurrDrawable()).getImage();
      if (paramBoolean) {
        break label54;
      }
      paramString.setIndividualPause(true);
    }
    for (;;)
    {
      ((AbstractGifImage)localObject).reset();
      return paramString;
      label54:
      paramString.setIndividualPause(false);
    }
  }
  
  public void a(URLImageView paramURLImageView, Drawable paramDrawable, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramURLImageView.setImageDrawable(paramDrawable);
      return;
    }
    paramDrawable = getDrawable(paramString, true);
    if (paramDrawable.getStatus() == 1)
    {
      if ((paramDrawable.getCurrDrawable() instanceof GifDrawable))
      {
        AbstractGifImage localAbstractGifImage = ((GifDrawable)paramDrawable.getCurrDrawable()).getImage();
        if ((localAbstractGifImage instanceof oay.a))
        {
          this.a = ((oay.a)localAbstractGifImage);
          this.a.a(new ofg(this, paramURLImageView, paramString));
        }
      }
      this.b.onLoadSuccessed(paramURLImageView, paramDrawable);
    }
    for (;;)
    {
      paramURLImageView.setURLDrawableDownListener(this.b);
      paramURLImageView.setImageDrawable(paramDrawable);
      return;
      paramDrawable.startDownload();
    }
  }
  
  public void destroy()
  {
    if (this.a != null) {
      this.a.destroy();
    }
    AbstractGifImage.pauseAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofe
 * JD-Core Version:    0.7.0.1
 */