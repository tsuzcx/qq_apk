import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

class txv
  implements txu
{
  private final int jdField_a_of_type_Int;
  @NonNull
  private final WeakReference<txu> jdField_a_of_type_JavaLangRefWeakReference;
  
  public txv(@NonNull txu paramtxu)
  {
    this.jdField_a_of_type_Int = System.identityHashCode(paramtxu);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramtxu);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaLangRefWeakReference.get() != null;
  }
  
  public void a(@NonNull txs paramtxs)
  {
    txu localtxu = (txu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localtxu != null) {
      localtxu.a(paramtxs);
    }
  }
  
  public void b(@NonNull txs paramtxs)
  {
    txu localtxu = (txu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localtxu != null) {
      localtxu.b(paramtxs);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof txv)) && (((txv)paramObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txv
 * JD-Core Version:    0.7.0.1
 */