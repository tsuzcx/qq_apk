import android.view.View;
import java.lang.ref.WeakReference;

class ybr
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<ybs> b;
  
  public ybr(ybp paramybp, View paramView, ybs paramybs)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramybs);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public ybs a()
  {
    return (ybs)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ybr
 * JD-Core Version:    0.7.0.1
 */