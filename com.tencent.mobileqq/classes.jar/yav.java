import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

class yav
  implements yau
{
  private final int jdField_a_of_type_Int;
  @NonNull
  private final WeakReference<yau> jdField_a_of_type_JavaLangRefWeakReference;
  
  public yav(@NonNull yau paramyau)
  {
    this.jdField_a_of_type_Int = System.identityHashCode(paramyau);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramyau);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaLangRefWeakReference.get() != null;
  }
  
  public void a(@NonNull yas paramyas)
  {
    yau localyau = (yau)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localyau != null) {
      localyau.a(paramyas);
    }
  }
  
  public void b(@NonNull yas paramyas)
  {
    yau localyau = (yau)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localyau != null) {
      localyau.b(paramyas);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof yav)) && (((yav)paramObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yav
 * JD-Core Version:    0.7.0.1
 */