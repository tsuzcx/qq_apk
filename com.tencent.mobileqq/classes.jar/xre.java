import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xre
  extends QQUIEventReceiver<xrb, xbq>
{
  public xre(@NonNull xrb paramxrb)
  {
    super(paramxrb);
  }
  
  public void a(@NonNull xrb paramxrb, @NonNull xbq paramxbq)
  {
    if ((paramxbq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramxbq.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    if (xrb.b(paramxrb))
    {
      xrb.b(paramxrb, true);
      yuk.b("VideoCoverListGroupHolder", "base info return , notify list while idle");
      return;
    }
    paramxrb.d();
    yuk.b("VideoCoverListGroupHolder", "base info return , notify list now");
  }
  
  public Class acceptEventClass()
  {
    return xbq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xre
 * JD-Core Version:    0.7.0.1
 */