import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class toe
  extends QQUIEventReceiver<tob, syp>
{
  public toe(@NonNull tob paramtob)
  {
    super(paramtob);
  }
  
  public void a(@NonNull tob paramtob, @NonNull syp paramsyp)
  {
    if ((paramsyp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramsyp.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    if (tob.b(paramtob))
    {
      tob.b(paramtob, true);
      urk.b("VideoCoverListGroupHolder", "base info return , notify list while idle");
      return;
    }
    paramtob.d();
    urk.b("VideoCoverListGroupHolder", "base info return , notify list now");
  }
  
  public Class acceptEventClass()
  {
    return syp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     toe
 * JD-Core Version:    0.7.0.1
 */