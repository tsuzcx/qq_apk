import android.view.View;
import java.lang.ref.WeakReference;

class yem
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<aniz> b;
  
  public yem(yel paramyel, View paramView, aniz paramaniz)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramaniz);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public aniz a()
  {
    return (aniz)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yem
 * JD-Core Version:    0.7.0.1
 */