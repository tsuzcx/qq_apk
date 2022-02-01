import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class xxm
  extends wag<xxi, xvl>
{
  xxm(xxi paramxxi)
  {
    super(paramxxi);
  }
  
  public void a(@NonNull xxi paramxxi, @NonNull xvl paramxvl)
  {
    if ((!paramxvl.jdField_a_of_type_JavaLangString.equals(xxi.a(paramxxi))) || (paramxvl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (xxi.a(paramxxi) == null)) {
      ykq.b(this.TAG, "ignore this comment list event. %s.", paramxvl.toString());
    }
    boolean bool2;
    boolean bool1;
    do
    {
      return;
      ykq.a(this.TAG, "receive comment list event. %s.", paramxvl.toString());
      bool2 = xxi.a(paramxxi);
      bool1 = true;
      if (paramxvl.jdField_a_of_type_Int == 0) {
        bool1 = false;
      }
      xxi.a(paramxxi).a(bool1);
      xxi.a(paramxxi).a(bool1, paramxvl.b);
      xxi.a(paramxxi).a(bool1, paramxvl.jdField_a_of_type_Boolean);
      xxi.a(paramxxi).a(paramxvl.jdField_a_of_type_JavaUtilList, paramxvl.c, bool1);
    } while (bool2 != bool1);
    paramxxi.b(paramxvl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return xvl.class;
  }
  
  public void b(@NonNull xxi paramxxi, @NonNull xvl paramxvl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxm
 * JD-Core Version:    0.7.0.1
 */