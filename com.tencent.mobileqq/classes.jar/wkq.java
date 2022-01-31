import java.lang.ref.WeakReference;

public class wkq
  implements wiz
{
  private int jdField_a_of_type_Int;
  private WeakReference<wia> jdField_a_of_type_JavaLangRefWeakReference;
  
  public wkq(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString, int paramInt)
  {
    wxe.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    if ((paramInt == 1002) || (paramInt == 1003)) {}
    while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    ((wia)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_Int, paramString);
  }
  
  public void a(wia paramwia)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramwia);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkq
 * JD-Core Version:    0.7.0.1
 */