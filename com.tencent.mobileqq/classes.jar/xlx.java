import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xlx
  extends QQUIEventReceiver<xlv, wwz>
{
  public xlx(@NonNull xlv paramxlv)
  {
    super(paramxlv);
  }
  
  public void a(@NonNull xlv paramxlv, @NonNull wwz paramwwz)
  {
    yqp.b("InteractWidgetPageHolder", "receive poll info event.");
    if (paramxlv.d()) {
      paramxlv.a(paramxlv.jdField_a_of_type_Int, paramxlv.b, paramxlv.jdField_a_of_type_Xne, paramxlv.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return wwz.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlx
 * JD-Core Version:    0.7.0.1
 */