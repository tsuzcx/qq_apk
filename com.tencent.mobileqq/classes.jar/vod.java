import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vod
  extends QQUIEventReceiver<vob, uze>
{
  public vod(@NonNull vob paramvob)
  {
    super(paramvob);
  }
  
  public void a(@NonNull vob paramvob, @NonNull uze paramuze)
  {
    wsv.b("InteractWidgetPageHolder", "receive poll info event.");
    if (paramvob.d()) {
      paramvob.a(paramvob.jdField_a_of_type_Int, paramvob.b, paramvob.jdField_a_of_type_Vpk, paramvob.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return uze.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vod
 * JD-Core Version:    0.7.0.1
 */