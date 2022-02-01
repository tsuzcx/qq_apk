import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class xir
  extends vll<xin, xgq>
{
  xir(xin paramxin)
  {
    super(paramxin);
  }
  
  public void a(@NonNull xin paramxin, @NonNull xgq paramxgq)
  {
    if ((!paramxgq.jdField_a_of_type_JavaLangString.equals(xin.a(paramxin))) || (paramxgq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (xin.a(paramxin) == null)) {
      xvv.b(this.TAG, "ignore this comment list event. %s.", paramxgq.toString());
    }
    boolean bool2;
    boolean bool1;
    do
    {
      return;
      xvv.a(this.TAG, "receive comment list event. %s.", paramxgq.toString());
      bool2 = xin.a(paramxin);
      bool1 = true;
      if (paramxgq.jdField_a_of_type_Int == 0) {
        bool1 = false;
      }
      xin.a(paramxin).a(bool1);
      xin.a(paramxin).a(bool1, paramxgq.b);
      xin.a(paramxin).a(bool1, paramxgq.jdField_a_of_type_Boolean);
      xin.a(paramxin).a(paramxgq.jdField_a_of_type_JavaUtilList, paramxgq.c, bool1);
    } while (bool2 != bool1);
    paramxin.b(paramxgq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return xgq.class;
  }
  
  public void b(@NonNull xin paramxin, @NonNull xgq paramxgq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xir
 * JD-Core Version:    0.7.0.1
 */