import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tzo
  extends QQUIEventReceiver<tzm, tkp>
{
  public tzo(@NonNull tzm paramtzm)
  {
    super(paramtzm);
  }
  
  public void a(@NonNull tzm paramtzm, @NonNull tkp paramtkp)
  {
    veg.b("InteractWidgetPageHolder", "receive poll info event.");
    if (paramtzm.d()) {
      paramtzm.a(paramtzm.jdField_a_of_type_Int, paramtzm.b, paramtzm.jdField_a_of_type_Uav, paramtzm.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return tkp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzo
 * JD-Core Version:    0.7.0.1
 */