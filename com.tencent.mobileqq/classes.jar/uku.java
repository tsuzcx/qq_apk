import android.support.annotation.UiThread;
import java.lang.ref.WeakReference;

public class uku<V extends uch>
  implements uck<V>
{
  private WeakReference<V> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  @UiThread
  public V a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (uch)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  @UiThread
  public void a(V paramV)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramV);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uku
 * JD-Core Version:    0.7.0.1
 */