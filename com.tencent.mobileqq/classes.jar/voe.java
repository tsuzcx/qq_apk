import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class voe
  extends QQUIEventReceiver<vob, uzw>
{
  public voe(@NonNull vob paramvob)
  {
    super(paramvob);
  }
  
  public void a(@NonNull vob paramvob, @NonNull uzw paramuzw)
  {
    wsv.b("InteractWidgetPageHolder", "receive send vid rate data result event.");
    if (paramvob.d()) {
      paramvob.a(paramvob.jdField_a_of_type_Int, paramvob.b, paramvob.jdField_a_of_type_Vpk, paramvob.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return uzw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     voe
 * JD-Core Version:    0.7.0.1
 */