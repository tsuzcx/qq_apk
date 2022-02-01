import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;

public class udh
{
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new udi(this);
  private txe jdField_a_of_type_Txe;
  private boolean jdField_a_of_type_Boolean;
  
  private URLDrawable a(String paramString, boolean paramBoolean)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = paramBoolean;
    paramString = URLDrawable.getDrawable(txd.a(paramString), (URLDrawable.URLDrawableOptions)localObject);
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
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Txe != null) {
      this.jdField_a_of_type_Txe.a();
    }
    AbstractGifImage.pauseAll();
  }
  
  public void a(URLImageView paramURLImageView, Drawable paramDrawable, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramURLImageView.setImageDrawable(paramDrawable);
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean2;
    paramDrawable = a(paramString, paramBoolean1);
    if (paramDrawable.getStatus() == 1)
    {
      if ((paramDrawable.getCurrDrawable() instanceof GifDrawable))
      {
        AbstractGifImage localAbstractGifImage = ((GifDrawable)paramDrawable.getCurrDrawable()).getImage();
        if ((localAbstractGifImage instanceof txe))
        {
          this.jdField_a_of_type_Txe = ((txe)localAbstractGifImage);
          this.jdField_a_of_type_Txe.a(new udj(this, paramURLImageView, paramString));
        }
      }
      this.jdField_a_of_type_ComTencentImageURLDrawableDownListener.onLoadSuccessed(paramURLImageView, paramDrawable);
    }
    for (;;)
    {
      paramURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
      paramURLImageView.setImageDrawable(paramDrawable);
      return;
      paramDrawable.startDownload();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udh
 * JD-Core Version:    0.7.0.1
 */