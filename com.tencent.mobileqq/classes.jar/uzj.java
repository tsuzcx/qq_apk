import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uzj
  extends QQUIEventReceiver<uzh, uzg>
{
  public uzj(uzh paramuzh)
  {
    super(paramuzh);
  }
  
  public void a(@NonNull uzh paramuzh, @NonNull uzg paramuzg)
  {
    if (paramuzh.a()) {}
    do
    {
      return;
      if (paramuzg.jdField_a_of_type_Boolean)
      {
        uzh.a(paramuzh);
        return;
      }
      if ((paramuzg.a() != null) && (!paramuzg.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("HaloResponseReceiver", 2, "onEvent: failed. Message: exception: " + paramuzg.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    return;
    uzh.a(paramuzh);
  }
  
  public Class acceptEventClass()
  {
    return uzg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uzj
 * JD-Core Version:    0.7.0.1
 */