import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

class ukr
  implements ukq
{
  private final int jdField_a_of_type_Int;
  @NonNull
  private final WeakReference<ukq> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ukr(@NonNull ukq paramukq)
  {
    this.jdField_a_of_type_Int = System.identityHashCode(paramukq);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramukq);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaLangRefWeakReference.get() != null;
  }
  
  public void a(@NonNull uko paramuko)
  {
    ukq localukq = (ukq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localukq != null) {
      localukq.a(paramuko);
    }
  }
  
  public void b(@NonNull uko paramuko)
  {
    ukq localukq = (ukq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localukq != null) {
      localukq.b(paramuko);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof ukr)) && (((ukr)paramObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukr
 * JD-Core Version:    0.7.0.1
 */