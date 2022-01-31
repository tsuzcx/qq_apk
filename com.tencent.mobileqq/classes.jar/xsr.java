import android.view.View;
import java.lang.ref.WeakReference;

class xsr
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<xss> b;
  
  public xsr(xsp paramxsp, View paramView, xss paramxss)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramxss);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public xss a()
  {
    return (xss)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     xsr
 * JD-Core Version:    0.7.0.1
 */