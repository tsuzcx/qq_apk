import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vsn
  extends QQUIEventReceiver<vsk, vef>
{
  public vsn(@NonNull vsk paramvsk)
  {
    super(paramvsk);
  }
  
  public void a(@NonNull vsk paramvsk, @NonNull vef paramvef)
  {
    wxe.b("InteractWidgetPageHolder", "receive send vid rate data result event.");
    if (paramvsk.d()) {
      paramvsk.a(paramvsk.jdField_a_of_type_Int, paramvsk.b, paramvsk.jdField_a_of_type_Vtt, paramvsk.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return vef.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vsn
 * JD-Core Version:    0.7.0.1
 */