import android.view.View;
import java.lang.ref.WeakReference;

class ztf
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<apag> b;
  
  public ztf(zte paramzte, View paramView, apag paramapag)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramapag);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public apag a()
  {
    return (apag)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ztf
 * JD-Core Version:    0.7.0.1
 */