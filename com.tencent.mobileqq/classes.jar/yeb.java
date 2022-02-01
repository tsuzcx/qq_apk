import java.lang.ref.WeakReference;

public class yeb
  implements yck
{
  private int jdField_a_of_type_Int;
  private WeakReference<ybl> jdField_a_of_type_JavaLangRefWeakReference;
  
  public yeb(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString, int paramInt)
  {
    yqp.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    if ((paramInt == 1002) || (paramInt == 1003)) {}
    while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    ((ybl)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_Int, paramString);
  }
  
  public void a(ybl paramybl)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramybl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yeb
 * JD-Core Version:    0.7.0.1
 */