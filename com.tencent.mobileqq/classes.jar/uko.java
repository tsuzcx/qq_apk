import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

class uko
  implements ukn
{
  private final int jdField_a_of_type_Int;
  @NonNull
  private final WeakReference<ukn> jdField_a_of_type_JavaLangRefWeakReference;
  
  public uko(@NonNull ukn paramukn)
  {
    this.jdField_a_of_type_Int = System.identityHashCode(paramukn);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramukn);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaLangRefWeakReference.get() != null;
  }
  
  public void a(@NonNull ukl paramukl)
  {
    ukn localukn = (ukn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localukn != null) {
      localukn.a(paramukl);
    }
  }
  
  public void b(@NonNull ukl paramukl)
  {
    ukn localukn = (ukn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localukn != null) {
      localukn.b(paramukl);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof uko)) && (((uko)paramObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uko
 * JD-Core Version:    0.7.0.1
 */