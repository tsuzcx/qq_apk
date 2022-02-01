import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xly
  extends QQUIEventReceiver<xlv, wxr>
{
  public xly(@NonNull xlv paramxlv)
  {
    super(paramxlv);
  }
  
  public void a(@NonNull xlv paramxlv, @NonNull wxr paramwxr)
  {
    yqp.b("InteractWidgetPageHolder", "receive send vid rate data result event.");
    if (paramxlv.d()) {
      paramxlv.a(paramxlv.jdField_a_of_type_Int, paramxlv.b, paramxlv.jdField_a_of_type_Xne, paramxlv.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return wxr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xly
 * JD-Core Version:    0.7.0.1
 */