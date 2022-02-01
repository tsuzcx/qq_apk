import java.lang.ref.WeakReference;

public class yhw
  implements ygf
{
  private int jdField_a_of_type_Int;
  private WeakReference<yfg> jdField_a_of_type_JavaLangRefWeakReference;
  
  public yhw(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString, int paramInt)
  {
    yuk.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    if ((paramInt == 1002) || (paramInt == 1003)) {}
    while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    ((yfg)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_Int, paramString);
  }
  
  public void a(yfg paramyfg)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramyfg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhw
 * JD-Core Version:    0.7.0.1
 */