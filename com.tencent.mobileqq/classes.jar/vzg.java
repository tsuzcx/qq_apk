import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

class vzg
  implements vzf
{
  private final int jdField_a_of_type_Int;
  @NonNull
  private final WeakReference<vzf> jdField_a_of_type_JavaLangRefWeakReference;
  
  public vzg(@NonNull vzf paramvzf)
  {
    this.jdField_a_of_type_Int = System.identityHashCode(paramvzf);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramvzf);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaLangRefWeakReference.get() != null;
  }
  
  public void a(@NonNull vzd paramvzd)
  {
    vzf localvzf = (vzf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localvzf != null) {
      localvzf.a(paramvzd);
    }
  }
  
  public void b(@NonNull vzd paramvzd)
  {
    vzf localvzf = (vzf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localvzf != null) {
      localvzf.b(paramvzd);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof vzg)) && (((vzg)paramObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vzg
 * JD-Core Version:    0.7.0.1
 */