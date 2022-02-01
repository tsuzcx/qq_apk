import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xnj
  extends QQUIEventReceiver<xng, wxv>
{
  public xnj(@NonNull xng paramxng)
  {
    super(paramxng);
  }
  
  public void a(@NonNull xng paramxng, @NonNull wxv paramwxv)
  {
    if ((paramwxv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramwxv.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    if (xng.b(paramxng))
    {
      xng.b(paramxng, true);
      yqp.b("VideoCoverListGroupHolder", "base info return , notify list while idle");
      return;
    }
    paramxng.d();
    yqp.b("VideoCoverListGroupHolder", "base info return , notify list now");
  }
  
  public Class acceptEventClass()
  {
    return wxv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnj
 * JD-Core Version:    0.7.0.1
 */