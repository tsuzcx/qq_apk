import android.view.View;
import java.lang.ref.WeakReference;

class yep
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<aniu> b;
  
  public yep(yeo paramyeo, View paramView, aniu paramaniu)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramaniu);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public aniu a()
  {
    return (aniu)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yep
 * JD-Core Version:    0.7.0.1
 */