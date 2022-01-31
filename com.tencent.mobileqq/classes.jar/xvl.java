import android.view.View;
import java.lang.ref.WeakReference;

class xvl
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<amsn> b;
  
  public xvl(xvk paramxvk, View paramView, amsn paramamsn)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramamsn);
  }
  
  public amsn a()
  {
    return (amsn)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     xvl
 * JD-Core Version:    0.7.0.1
 */