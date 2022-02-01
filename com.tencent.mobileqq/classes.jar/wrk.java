import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wrk
  extends QQUIEventReceiver<wri, wrh>
{
  public wrk(wri paramwri)
  {
    super(paramwri);
  }
  
  public void a(@NonNull wri paramwri, @NonNull wrh paramwrh)
  {
    if (paramwri.a()) {}
    do
    {
      return;
      if (paramwrh.jdField_a_of_type_Boolean)
      {
        wri.a(paramwri);
        return;
      }
      if ((paramwrh.a() != null) && (!paramwrh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("HaloResponseReceiver", 2, "onEvent: failed. Message: exception: " + paramwrh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    return;
    wri.a(paramwri);
  }
  
  public Class acceptEventClass()
  {
    return wrh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrk
 * JD-Core Version:    0.7.0.1
 */