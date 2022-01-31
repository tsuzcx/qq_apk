import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import java.lang.ref.WeakReference;

class vph
  implements URLDrawableDownListener
{
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  private final WeakReference<ProgressBar> b;
  
  public vph(@NonNull String paramString, @NonNull ImageView paramImageView, @NonNull ProgressBar paramProgressBar)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramImageView);
    this.b = new WeakReference(paramProgressBar);
  }
  
  private boolean a(ImageView paramImageView)
  {
    paramImageView = (String)paramImageView.getTag(2131376880);
    return (!TextUtils.isEmpty(paramImageView)) && (paramImageView.equals(this.jdField_a_of_type_JavaLangString));
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    veg.b("LocationFaceAdapter", "onLoadCanceled,url:" + this.jdField_a_of_type_JavaLangString);
    paramView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    paramURLDrawable = (ProgressBar)this.b.get();
    if ((paramView != null) && (paramURLDrawable != null) && (a(paramView)))
    {
      paramURLDrawable.setVisibility(4);
      paramView.setTag(2131376849, Boolean.valueOf(false));
      return;
    }
    veg.b("LocationFaceAdapter", "onLoadCanceled error.");
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    veg.b("LocationFaceAdapter", "onLoadFialed,url:" + this.jdField_a_of_type_JavaLangString);
    paramView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    paramURLDrawable = (ProgressBar)this.b.get();
    if ((paramView != null) && (paramURLDrawable != null) && (a(paramView)))
    {
      paramURLDrawable.setVisibility(0);
      paramView.setTag(2131376849, Boolean.valueOf(false));
      return;
    }
    veg.b("LocationFaceAdapter", "onLoadFialed error.");
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    veg.b("LocationFaceAdapter", "onLoadProgressed,url:" + this.jdField_a_of_type_JavaLangString);
    paramView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    paramURLDrawable = (ProgressBar)this.b.get();
    if ((paramView != null) && (paramURLDrawable != null) && (a(paramView)))
    {
      paramURLDrawable.setVisibility(0);
      paramView.setTag(2131376849, Boolean.valueOf(false));
      return;
    }
    veg.b("LocationFaceAdapter", "onLoadProgressed error.");
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    veg.b("LocationFaceAdapter", "onLoadSuccessed,url:" + this.jdField_a_of_type_JavaLangString);
    paramView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    paramURLDrawable = (ProgressBar)this.b.get();
    if ((paramView != null) && (paramURLDrawable != null) && (a(paramView)))
    {
      paramURLDrawable.setVisibility(4);
      paramView.setTag(2131376849, Boolean.valueOf(true));
      return;
    }
    veg.b("LocationFaceAdapter", "onLoadSuccessed error.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vph
 * JD-Core Version:    0.7.0.1
 */