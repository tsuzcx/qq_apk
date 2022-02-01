import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wre
  extends QQUIEventReceiver<wrb, wdc>
{
  public wre(@NonNull wrb paramwrb)
  {
    super(paramwrb);
  }
  
  public void a(@NonNull wrb paramwrb, @NonNull wdc paramwdc)
  {
    xvv.b("InteractWidgetPageHolder", "receive send vid rate data result event.");
    if (paramwrb.d()) {
      paramwrb.a(paramwrb.jdField_a_of_type_Int, paramwrb.b, paramwrb.jdField_a_of_type_Wsk, paramwrb.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return wdc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wre
 * JD-Core Version:    0.7.0.1
 */