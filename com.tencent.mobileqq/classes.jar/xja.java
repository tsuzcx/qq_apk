import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class xja
  extends vll<xin, xhl>
{
  xja(xin paramxin)
  {
    super(paramxin);
  }
  
  public void a(@NonNull xin paramxin, @NonNull xhl paramxhl)
  {
    if ((!paramxhl.jdField_a_of_type_Boolean) || (!paramxhl.jdField_a_of_type_JavaLangString.equals(xin.a(paramxin))) || (paramxhl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (xin.a(paramxin) == null))
    {
      xvv.b(this.TAG, "ignore this like list event. %s.", paramxhl.toString());
      return;
    }
    xvv.a(this.TAG, "receive like list event. %s.", paramxhl.toString());
    boolean bool2 = xin.a(paramxin);
    if (paramxhl.jdField_a_of_type_Int == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      xin.a(paramxin).b(bool1, paramxhl.b);
      xin.a(paramxin).b(paramxhl.jdField_a_of_type_JavaUtilList, true, bool1);
      if (bool2 != bool1) {
        break;
      }
      paramxin.a();
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return xhl.class;
  }
  
  public void b(@NonNull xin paramxin, @NonNull xhl paramxhl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xja
 * JD-Core Version:    0.7.0.1
 */