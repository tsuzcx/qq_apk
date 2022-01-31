import android.view.View;
import java.lang.ref.WeakReference;

class zuz
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<zva> b;
  
  public zuz(zux paramzux, View paramView, zva paramzva)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramzva);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public zva a()
  {
    return (zva)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     zuz
 * JD-Core Version:    0.7.0.1
 */