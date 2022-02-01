import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xsd
  extends QQUIEventReceiver<IEventReceiver, wrn>
{
  public xsd(@NonNull IEventReceiver paramIEventReceiver)
  {
    super(paramIEventReceiver);
  }
  
  public void a(@NonNull IEventReceiver paramIEventReceiver, @NonNull wrn paramwrn)
  {
    if (paramwrn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      QQToast.a(wzk.a(), 2, anvx.a(2131710491), 0).a();
      ykv.a("play_video", "report_suc", 0, 0, new String[] { String.valueOf(paramwrn.jdField_a_of_type_Int), "5" });
      return;
    }
    QQToast.a(wzk.a(), 1, anvx.a(2131710486), 0).a();
    ykv.a("play_video", "report_fail", 0, 0, new String[] { "", "5" });
  }
  
  public Class acceptEventClass()
  {
    return wrn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsd
 * JD-Core Version:    0.7.0.1
 */