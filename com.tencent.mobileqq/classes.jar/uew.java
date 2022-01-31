import java.lang.ref.WeakReference;

public class uew
  implements udf
{
  private int jdField_a_of_type_Int;
  private WeakReference<ucg> jdField_a_of_type_JavaLangRefWeakReference;
  
  public uew(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString, int paramInt)
  {
    urk.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    if ((paramInt == 1002) || (paramInt == 1003)) {}
    while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    ((ucg)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_Int, paramString);
  }
  
  public void a(ucg paramucg)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramucg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uew
 * JD-Core Version:    0.7.0.1
 */