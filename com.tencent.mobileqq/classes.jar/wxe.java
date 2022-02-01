import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wxe
  extends QQUIEventReceiver<wxc, wxb>
{
  public wxe(wxc paramwxc)
  {
    super(paramwxc);
  }
  
  public void a(@NonNull wxc paramwxc, @NonNull wxb paramwxb)
  {
    if (paramwxc.a()) {}
    do
    {
      return;
      if (paramwxb.jdField_a_of_type_Boolean)
      {
        wxc.a(paramwxc);
        return;
      }
      if ((paramwxb.a() != null) && (!paramwxb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("HaloResponseReceiver", 2, "onEvent: failed. Message: exception: " + paramwxb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    return;
    wxc.a(paramwxc);
  }
  
  public Class acceptEventClass()
  {
    return wxb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxe
 * JD-Core Version:    0.7.0.1
 */