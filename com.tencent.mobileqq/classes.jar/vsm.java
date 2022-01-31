import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vsm
  extends QQUIEventReceiver<vsk, vdn>
{
  public vsm(@NonNull vsk paramvsk)
  {
    super(paramvsk);
  }
  
  public void a(@NonNull vsk paramvsk, @NonNull vdn paramvdn)
  {
    wxe.b("InteractWidgetPageHolder", "receive poll info event.");
    if (paramvsk.d()) {
      paramvsk.a(paramvsk.jdField_a_of_type_Int, paramvsk.b, paramvsk.jdField_a_of_type_Vtt, paramvsk.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return vdn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vsm
 * JD-Core Version:    0.7.0.1
 */