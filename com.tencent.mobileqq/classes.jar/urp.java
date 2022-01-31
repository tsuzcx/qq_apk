import java.lang.ref.WeakReference;

public class urp
  implements upy
{
  private int jdField_a_of_type_Int;
  private WeakReference<uoz> jdField_a_of_type_JavaLangRefWeakReference;
  
  public urp(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString, int paramInt)
  {
    ved.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    if ((paramInt == 1002) || (paramInt == 1003)) {}
    while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    ((uoz)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_Int, paramString);
  }
  
  public void a(uoz paramuoz)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramuoz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urp
 * JD-Core Version:    0.7.0.1
 */