import android.view.View;
import java.lang.ref.WeakReference;

class zqk
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<zql> b;
  
  public zqk(zqi paramzqi, View paramView, zql paramzql)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramzql);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public zql a()
  {
    return (zql)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zqk
 * JD-Core Version:    0.7.0.1
 */