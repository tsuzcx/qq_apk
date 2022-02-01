import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xfy
  extends QQUIEventReceiver<xfw, wrf>
{
  public xfy(@NonNull xfw paramxfw)
  {
    super(paramxfw);
  }
  
  public void a(@NonNull xfw paramxfw, @NonNull wrf paramwrf)
  {
    ykq.b("InteractWidgetPageHolder", "receive poll info event.");
    if (paramxfw.d()) {
      paramxfw.a(paramxfw.jdField_a_of_type_Int, paramxfw.b, paramxfw.jdField_a_of_type_Xhf, paramxfw.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return wrf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfy
 * JD-Core Version:    0.7.0.1
 */