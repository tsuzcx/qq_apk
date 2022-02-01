import java.lang.ref.WeakReference;

public class xjh
  implements xhq
{
  private int jdField_a_of_type_Int;
  private WeakReference<xgr> jdField_a_of_type_JavaLangRefWeakReference;
  
  public xjh(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString, int paramInt)
  {
    xvv.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    if ((paramInt == 1002) || (paramInt == 1003)) {}
    while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    ((xgr)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_Int, paramString);
  }
  
  public void a(xgr paramxgr)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramxgr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjh
 * JD-Core Version:    0.7.0.1
 */