import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.galleryactivity.UrlGalleryAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;

public class bqk
  extends URLDrawableDownListener.Adapter
{
  public bqk(UrlGalleryAdapter paramUrlGalleryAdapter, int paramInt, ViewGroup paramViewGroup) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityUrlGalleryAdapter.a(this.jdField_a_of_type_Int, false);
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityUrlGalleryAdapter.b(this.jdField_a_of_type_Int, paramInt / 100);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityUrlGalleryAdapter.a(this.jdField_a_of_type_Int, true);
    paramView = this.jdField_a_of_type_ComTencentCommonGalleryactivityUrlGalleryAdapter.a(paramURLDrawable.getURL(), this.jdField_a_of_type_AndroidViewViewGroup);
    if (paramView != null) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityUrlGalleryAdapter.a(paramView, paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bqk
 * JD-Core Version:    0.7.0.1
 */