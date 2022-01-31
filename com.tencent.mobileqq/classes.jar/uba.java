import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uba
  extends QQUIEventReceiver<uax, tll>
{
  public uba(@NonNull uax paramuax)
  {
    super(paramuax);
  }
  
  public void a(@NonNull uax paramuax, @NonNull tll paramtll)
  {
    if ((paramtll.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramtll.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    if (uax.b(paramuax))
    {
      uax.b(paramuax, true);
      veg.b("VideoCoverListGroupHolder", "base info return , notify list while idle");
      return;
    }
    paramuax.d();
    veg.b("VideoCoverListGroupHolder", "base info return , notify list now");
  }
  
  public Class acceptEventClass()
  {
    return tll.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uba
 * JD-Core Version:    0.7.0.1
 */