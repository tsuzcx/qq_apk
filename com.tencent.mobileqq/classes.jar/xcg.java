import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

class xcg
  implements xcf
{
  private final int jdField_a_of_type_Int;
  @NonNull
  private final WeakReference<xcf> jdField_a_of_type_JavaLangRefWeakReference;
  
  public xcg(@NonNull xcf paramxcf)
  {
    this.jdField_a_of_type_Int = System.identityHashCode(paramxcf);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramxcf);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaLangRefWeakReference.get() != null;
  }
  
  public void a(@NonNull xcd paramxcd)
  {
    xcf localxcf = (xcf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localxcf != null) {
      localxcf.a(paramxcd);
    }
  }
  
  public void b(@NonNull xcd paramxcd)
  {
    xcf localxcf = (xcf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localxcf != null) {
      localxcf.b(paramxcd);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof xcg)) && (((xcg)paramObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcg
 * JD-Core Version:    0.7.0.1
 */