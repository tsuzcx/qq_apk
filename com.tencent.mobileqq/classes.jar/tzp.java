import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tzp
  extends QQUIEventReceiver<tzm, tlh>
{
  public tzp(@NonNull tzm paramtzm)
  {
    super(paramtzm);
  }
  
  public void a(@NonNull tzm paramtzm, @NonNull tlh paramtlh)
  {
    veg.b("InteractWidgetPageHolder", "receive send vid rate data result event.");
    if (paramtzm.d()) {
      paramtzm.a(paramtzm.jdField_a_of_type_Int, paramtzm.b, paramtzm.jdField_a_of_type_Uav, paramtzm.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return tlh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzp
 * JD-Core Version:    0.7.0.1
 */