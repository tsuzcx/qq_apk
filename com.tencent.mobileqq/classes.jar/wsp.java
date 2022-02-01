import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wsp
  extends QQUIEventReceiver<wsm, wdg>
{
  public wsp(@NonNull wsm paramwsm)
  {
    super(paramwsm);
  }
  
  public void a(@NonNull wsm paramwsm, @NonNull wdg paramwdg)
  {
    if ((paramwdg.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramwdg.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    if (wsm.b(paramwsm))
    {
      wsm.b(paramwsm, true);
      xvv.b("VideoCoverListGroupHolder", "base info return , notify list while idle");
      return;
    }
    paramwsm.d();
    xvv.b("VideoCoverListGroupHolder", "base info return , notify list now");
  }
  
  public Class acceptEventClass()
  {
    return wdg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsp
 * JD-Core Version:    0.7.0.1
 */