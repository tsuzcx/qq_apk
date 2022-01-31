import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

class wdp
  implements wdo
{
  private final int jdField_a_of_type_Int;
  @NonNull
  private final WeakReference<wdo> jdField_a_of_type_JavaLangRefWeakReference;
  
  public wdp(@NonNull wdo paramwdo)
  {
    this.jdField_a_of_type_Int = System.identityHashCode(paramwdo);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramwdo);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaLangRefWeakReference.get() != null;
  }
  
  public void a(@NonNull wdm paramwdm)
  {
    wdo localwdo = (wdo)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localwdo != null) {
      localwdo.a(paramwdm);
    }
  }
  
  public void b(@NonNull wdm paramwdm)
  {
    wdo localwdo = (wdo)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localwdo != null) {
      localwdo.b(paramwdm);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof wdp)) && (((wdp)paramObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wdp
 * JD-Core Version:    0.7.0.1
 */