import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tms
  extends QQUIEventReceiver<tmq, sxt>
{
  public tms(@NonNull tmq paramtmq)
  {
    super(paramtmq);
  }
  
  public void a(@NonNull tmq paramtmq, @NonNull sxt paramsxt)
  {
    urk.b("InteractWidgetPageHolder", "receive poll info event.");
    if (paramtmq.d()) {
      paramtmq.a(paramtmq.jdField_a_of_type_Int, paramtmq.b, paramtmq.jdField_a_of_type_Tnz, paramtmq.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return sxt.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tms
 * JD-Core Version:    0.7.0.1
 */