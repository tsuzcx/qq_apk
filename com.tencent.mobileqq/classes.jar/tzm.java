import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tzm
  extends QQUIEventReceiver<tzj, tle>
{
  public tzm(@NonNull tzj paramtzj)
  {
    super(paramtzj);
  }
  
  public void a(@NonNull tzj paramtzj, @NonNull tle paramtle)
  {
    ved.b("InteractWidgetPageHolder", "receive send vid rate data result event.");
    if (paramtzj.d()) {
      paramtzj.a(paramtzj.jdField_a_of_type_Int, paramtzj.b, paramtzj.jdField_a_of_type_Uas, paramtzj.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return tle.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzm
 * JD-Core Version:    0.7.0.1
 */