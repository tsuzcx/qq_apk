import java.lang.ref.WeakReference;

public class wgh
  implements weq
{
  private int jdField_a_of_type_Int;
  private WeakReference<wdr> jdField_a_of_type_JavaLangRefWeakReference;
  
  public wgh(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString, int paramInt)
  {
    wsv.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    if ((paramInt == 1002) || (paramInt == 1003)) {}
    while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    ((wdr)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_Int, paramString);
  }
  
  public void a(wdr paramwdr)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramwdr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgh
 * JD-Core Version:    0.7.0.1
 */