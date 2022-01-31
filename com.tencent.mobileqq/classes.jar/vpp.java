import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vpp
  extends QQUIEventReceiver<vpm, vaa>
{
  public vpp(@NonNull vpm paramvpm)
  {
    super(paramvpm);
  }
  
  public void a(@NonNull vpm paramvpm, @NonNull vaa paramvaa)
  {
    if ((paramvaa.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramvaa.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    if (vpm.b(paramvpm))
    {
      vpm.b(paramvpm, true);
      wsv.b("VideoCoverListGroupHolder", "base info return , notify list while idle");
      return;
    }
    paramvpm.d();
    wsv.b("VideoCoverListGroupHolder", "base info return , notify list now");
  }
  
  public Class acceptEventClass()
  {
    return vaa.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vpp
 * JD-Core Version:    0.7.0.1
 */