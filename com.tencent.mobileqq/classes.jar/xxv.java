import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class xxv
  extends wag<xxi, xwg>
{
  xxv(xxi paramxxi)
  {
    super(paramxxi);
  }
  
  public void a(@NonNull xxi paramxxi, @NonNull xwg paramxwg)
  {
    if ((!paramxwg.jdField_a_of_type_Boolean) || (!paramxwg.jdField_a_of_type_JavaLangString.equals(xxi.a(paramxxi))) || (paramxwg.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (xxi.a(paramxxi) == null))
    {
      ykq.b(this.TAG, "ignore this like list event. %s.", paramxwg.toString());
      return;
    }
    ykq.a(this.TAG, "receive like list event. %s.", paramxwg.toString());
    boolean bool2 = xxi.a(paramxxi);
    if (paramxwg.jdField_a_of_type_Int == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      xxi.a(paramxxi).b(bool1, paramxwg.b);
      xxi.a(paramxxi).b(paramxwg.jdField_a_of_type_JavaUtilList, true, bool1);
      if (bool2 != bool1) {
        break;
      }
      paramxxi.a();
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return xwg.class;
  }
  
  public void b(@NonNull xxi paramxxi, @NonNull xwg paramxwg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxv
 * JD-Core Version:    0.7.0.1
 */