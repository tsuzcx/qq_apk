import android.view.View;
import java.lang.ref.WeakReference;

class ybu
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<ybv> b;
  
  public ybu(ybs paramybs, View paramView, ybv paramybv)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramybv);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public ybv a()
  {
    return (ybv)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ybu
 * JD-Core Version:    0.7.0.1
 */