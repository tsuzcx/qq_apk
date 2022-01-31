import android.view.View;
import java.lang.ref.WeakReference;

public class xsx
{
  public WeakReference<View> a;
  public WeakReference<amsl> b;
  
  public xsx(xsw paramxsw, View paramView, amsl paramamsl)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramamsl);
  }
  
  public amsl a()
  {
    return (amsl)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     xsx
 * JD-Core Version:    0.7.0.1
 */