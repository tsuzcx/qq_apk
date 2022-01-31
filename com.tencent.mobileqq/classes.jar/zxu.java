import android.view.View;
import java.lang.ref.WeakReference;

class zxu
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<apep> b;
  
  public zxu(zxt paramzxt, View paramView, apep paramapep)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramapep);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public apep a()
  {
    return (apep)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     zxu
 * JD-Core Version:    0.7.0.1
 */