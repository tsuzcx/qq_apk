import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wcp
  extends QQUIEventReceiver<wcn, wcm>
{
  public wcp(wcn paramwcn)
  {
    super(paramwcn);
  }
  
  public void a(@NonNull wcn paramwcn, @NonNull wcm paramwcm)
  {
    if (paramwcn.a()) {}
    do
    {
      return;
      if (paramwcm.jdField_a_of_type_Boolean)
      {
        wcn.a(paramwcn);
        return;
      }
      if ((paramwcm.a() != null) && (!paramwcm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("HaloResponseReceiver", 2, "onEvent: failed. Message: exception: " + paramwcm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    return;
    wcn.a(paramwcn);
  }
  
  public Class acceptEventClass()
  {
    return wcm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcp
 * JD-Core Version:    0.7.0.1
 */