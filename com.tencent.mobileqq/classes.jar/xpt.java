import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

public class xpt
  extends yrv
  implements URLDrawable.URLDrawableListener
{
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private xps jdField_a_of_type_Xps;
  
  public xpt(ImageView paramImageView, xps paramxps)
  {
    super(paramImageView);
    this.jdField_a_of_type_Xps = paramxps;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Xps.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    xqb.c("Q.qqstory.newImageLoader", new Object[] { "runOnBackGround url= ", this.jdField_a_of_type_Xps.jdField_a_of_type_JavaLangString });
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    try
    {
      new URL(this.jdField_a_of_type_Xps.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_Xps.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
      if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
      {
        xqb.c("Q.qqstory.newImageLoader", new Object[] { "drawable have urlDrawable cache" });
        onLoadSuccessed(this.jdField_a_of_type_ComTencentImageURLDrawable);
        return;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
      xqb.a("Q.qqstory.newImageLoader", new Object[] { localMalformedURLException.getMessage() });
      a(this.jdField_a_of_type_Xps.jdField_a_of_type_AndroidGraphicsDrawableDrawable, "url is error:" + localMalformedURLException);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 2) || (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 3))
    {
      xqb.c("Q.qqstory.newImageLoader", new Object[] { "drawable restartDownload" });
      this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
      return;
    }
    xqb.c("Q.qqstory.newImageLoader", new Object[] { "drawable startDownload" });
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload(true);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    xqb.c("Q.qqstory.newImageLoader", new Object[] { "onLoadCanceled url= ", paramURLDrawable.getURL() });
    super.a(paramURLDrawable, "task have been cancel!");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    xqb.c("Q.qqstory.newImageLoader", new Object[] { "onLoadFialed url= ", paramURLDrawable.getURL() });
    super.a(paramURLDrawable, paramThrowable.getMessage());
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    xqb.c("Q.qqstory.newImageLoader", new Object[] { "onLoadSuccessed url= ", paramURLDrawable.getURL() });
    if (this.jdField_a_of_type_Boolean)
    {
      super.a(paramURLDrawable);
      return;
    }
    if (this.jdField_a_of_type_Xps.jdField_a_of_type_Xpo != null)
    {
      Bitmap localBitmap = xqc.a(paramURLDrawable.getCurrDrawable(), this.jdField_a_of_type_Xps.jdField_a_of_type_Int, this.jdField_a_of_type_Xps.b, UIUtils.RecycleBitmapMap, this.jdField_a_of_type_Xps.jdField_a_of_type_Xpo);
      if ((localBitmap == null) || (localBitmap.isRecycled()))
      {
        super.a(paramURLDrawable, "drawable transform failed!");
        return;
      }
      paramURLDrawable = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramURLDrawable != null) {
        paramURLDrawable.setTag(2131369550, localBitmap);
      }
      super.a(new BitmapDrawable(localBitmap));
      return;
    }
    super.a(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpt
 * JD-Core Version:    0.7.0.1
 */