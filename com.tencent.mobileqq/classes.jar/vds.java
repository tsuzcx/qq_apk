import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vds
  extends QQUIEventReceiver<vdq, vdp>
{
  public vds(vdq paramvdq)
  {
    super(paramvdq);
  }
  
  public void a(@NonNull vdq paramvdq, @NonNull vdp paramvdp)
  {
    if (paramvdq.a()) {}
    do
    {
      return;
      if (paramvdp.jdField_a_of_type_Boolean)
      {
        vdq.a(paramvdq);
        return;
      }
      if ((paramvdp.a() != null) && (!paramvdp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("HaloResponseReceiver", 2, "onEvent: failed. Message: exception: " + paramvdp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    return;
    vdq.a(paramvdq);
  }
  
  public Class acceptEventClass()
  {
    return vdp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vds
 * JD-Core Version:    0.7.0.1
 */