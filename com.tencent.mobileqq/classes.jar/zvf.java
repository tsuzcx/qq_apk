import android.view.View;
import java.lang.ref.WeakReference;

public class zvf
{
  public WeakReference<View> a;
  public WeakReference<apen> b;
  
  public zvf(zve paramzve, View paramView, apen paramapen)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramapen);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public apen a()
  {
    return (apen)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     zvf
 * JD-Core Version:    0.7.0.1
 */