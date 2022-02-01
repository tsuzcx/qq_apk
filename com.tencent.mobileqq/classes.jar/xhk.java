import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xhk
  extends QQUIEventReceiver<xhh, wsb>
{
  public xhk(@NonNull xhh paramxhh)
  {
    super(paramxhh);
  }
  
  public void a(@NonNull xhh paramxhh, @NonNull wsb paramwsb)
  {
    if ((paramwsb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramwsb.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    if (xhh.b(paramxhh))
    {
      xhh.b(paramxhh, true);
      ykq.b("VideoCoverListGroupHolder", "base info return , notify list while idle");
      return;
    }
    paramxhh.d();
    ykq.b("VideoCoverListGroupHolder", "base info return , notify list now");
  }
  
  public Class acceptEventClass()
  {
    return wsb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhk
 * JD-Core Version:    0.7.0.1
 */