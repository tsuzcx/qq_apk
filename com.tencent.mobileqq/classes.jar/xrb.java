import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

class xrb
  implements xra
{
  private final int jdField_a_of_type_Int;
  @NonNull
  private final WeakReference<xra> jdField_a_of_type_JavaLangRefWeakReference;
  
  public xrb(@NonNull xra paramxra)
  {
    this.jdField_a_of_type_Int = System.identityHashCode(paramxra);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramxra);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaLangRefWeakReference.get() != null;
  }
  
  public void a(@NonNull xqy paramxqy)
  {
    xra localxra = (xra)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localxra != null) {
      localxra.a(paramxqy);
    }
  }
  
  public void b(@NonNull xqy paramxqy)
  {
    xra localxra = (xra)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localxra != null) {
      localxra.b(paramxqy);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof xrb)) && (((xrb)paramObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xrb
 * JD-Core Version:    0.7.0.1
 */