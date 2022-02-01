import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

class xxa
  implements xwz
{
  private final int jdField_a_of_type_Int;
  @NonNull
  private final WeakReference<xwz> jdField_a_of_type_JavaLangRefWeakReference;
  
  public xxa(@NonNull xwz paramxwz)
  {
    this.jdField_a_of_type_Int = System.identityHashCode(paramxwz);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramxwz);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaLangRefWeakReference.get() != null;
  }
  
  public void a(@NonNull xwx paramxwx)
  {
    xwz localxwz = (xwz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localxwz != null) {
      localxwz.a(paramxwx);
    }
  }
  
  public void b(@NonNull xwx paramxwx)
  {
    xwz localxwz = (xwz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localxwz != null) {
      localxwz.b(paramxwx);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof xxa)) && (((xxa)paramObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxa
 * JD-Core Version:    0.7.0.1
 */