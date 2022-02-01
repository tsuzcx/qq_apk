import java.lang.ref.WeakReference;

public class xyc
  implements xwl
{
  private int jdField_a_of_type_Int;
  private WeakReference<xvm> jdField_a_of_type_JavaLangRefWeakReference;
  
  public xyc(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString, int paramInt)
  {
    ykq.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    if ((paramInt == 1002) || (paramInt == 1003)) {}
    while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    ((xvm)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_Int, paramString);
  }
  
  public void a(xvm paramxvm)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramxvm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyc
 * JD-Core Version:    0.7.0.1
 */