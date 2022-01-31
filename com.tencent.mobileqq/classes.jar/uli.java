import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

public class uli
  extends vpk
  implements URLDrawable.URLDrawableListener
{
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private ulh jdField_a_of_type_Ulh;
  
  public uli(ImageView paramImageView, ulh paramulh)
  {
    super(paramImageView);
    this.jdField_a_of_type_Ulh = paramulh;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Ulh.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    ulq.c("Q.qqstory.newImageLoader", new Object[] { "runOnBackGround url= ", this.jdField_a_of_type_Ulh.jdField_a_of_type_JavaLangString });
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    try
    {
      new URL(this.jdField_a_of_type_Ulh.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_Ulh.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
      if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
      {
        ulq.c("Q.qqstory.newImageLoader", new Object[] { "drawable have urlDrawable cache" });
        onLoadSuccessed(this.jdField_a_of_type_ComTencentImageURLDrawable);
        return;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
      ulq.a("Q.qqstory.newImageLoader", new Object[] { localMalformedURLException.getMessage() });
      a(this.jdField_a_of_type_Ulh.jdField_a_of_type_AndroidGraphicsDrawableDrawable, "url is error:" + localMalformedURLException);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 2) || (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 3))
    {
      ulq.c("Q.qqstory.newImageLoader", new Object[] { "drawable restartDownload" });
      this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
      return;
    }
    ulq.c("Q.qqstory.newImageLoader", new Object[] { "drawable startDownload" });
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload(true);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    ulq.c("Q.qqstory.newImageLoader", new Object[] { "onLoadCanceled url= ", paramURLDrawable.getURL() });
    super.a(paramURLDrawable, "task have been cancel!");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    ulq.c("Q.qqstory.newImageLoader", new Object[] { "onLoadFialed url= ", paramURLDrawable.getURL() });
    super.a(paramURLDrawable, paramThrowable.getMessage());
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ulq.c("Q.qqstory.newImageLoader", new Object[] { "onLoadSuccessed url= ", paramURLDrawable.getURL() });
    if (this.jdField_a_of_type_Boolean)
    {
      super.a(paramURLDrawable);
      return;
    }
    if (this.jdField_a_of_type_Ulh.jdField_a_of_type_Uld != null)
    {
      Bitmap localBitmap = ulr.a(paramURLDrawable.getCurrDrawable(), this.jdField_a_of_type_Ulh.jdField_a_of_type_Int, this.jdField_a_of_type_Ulh.b, vms.a, this.jdField_a_of_type_Ulh.jdField_a_of_type_Uld);
      if ((localBitmap == null) || (localBitmap.isRecycled()))
      {
        super.a(paramURLDrawable, "drawable transform failed!");
        return;
      }
      paramURLDrawable = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramURLDrawable != null) {
        paramURLDrawable.setTag(2131303172, localBitmap);
      }
      super.a(new BitmapDrawable(localBitmap));
      return;
    }
    super.a(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uli
 * JD-Core Version:    0.7.0.1
 */