import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tzl
  extends QQUIEventReceiver<tzj, tkm>
{
  public tzl(@NonNull tzj paramtzj)
  {
    super(paramtzj);
  }
  
  public void a(@NonNull tzj paramtzj, @NonNull tkm paramtkm)
  {
    ved.b("InteractWidgetPageHolder", "receive poll info event.");
    if (paramtzj.d()) {
      paramtzj.a(paramtzj.jdField_a_of_type_Int, paramtzj.b, paramtzj.jdField_a_of_type_Uas, paramtzj.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return tkm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzl
 * JD-Core Version:    0.7.0.1
 */