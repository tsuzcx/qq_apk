import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vty
  extends QQUIEventReceiver<vtv, vej>
{
  public vty(@NonNull vtv paramvtv)
  {
    super(paramvtv);
  }
  
  public void a(@NonNull vtv paramvtv, @NonNull vej paramvej)
  {
    if ((paramvej.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramvej.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    if (vtv.b(paramvtv))
    {
      vtv.b(paramvtv, true);
      wxe.b("VideoCoverListGroupHolder", "base info return , notify list while idle");
      return;
    }
    paramvtv.d();
    wxe.b("VideoCoverListGroupHolder", "base info return , notify list now");
  }
  
  public Class acceptEventClass()
  {
    return vej.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vty
 * JD-Core Version:    0.7.0.1
 */