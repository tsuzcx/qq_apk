import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xaz
  extends QQUIEventReceiver<xax, xaw>
{
  public xaz(xax paramxax)
  {
    super(paramxax);
  }
  
  public void a(@NonNull xax paramxax, @NonNull xaw paramxaw)
  {
    if (paramxax.a()) {}
    do
    {
      return;
      if (paramxaw.jdField_a_of_type_Boolean)
      {
        xax.a(paramxax);
        return;
      }
      if ((paramxaw.a() != null) && (!paramxaw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("HaloResponseReceiver", 2, "onEvent: failed. Message: exception: " + paramxaw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    return;
    xax.a(paramxax);
  }
  
  public Class acceptEventClass()
  {
    return xaw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xaz
 * JD-Core Version:    0.7.0.1
 */