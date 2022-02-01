import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xfz
  extends QQUIEventReceiver<xfw, wrx>
{
  public xfz(@NonNull xfw paramxfw)
  {
    super(paramxfw);
  }
  
  public void a(@NonNull xfw paramxfw, @NonNull wrx paramwrx)
  {
    ykq.b("InteractWidgetPageHolder", "receive send vid rate data result event.");
    if (paramxfw.d()) {
      paramxfw.a(paramxfw.jdField_a_of_type_Int, paramxfw.b, paramxfw.jdField_a_of_type_Xhf, paramxfw.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return wrx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfz
 * JD-Core Version:    0.7.0.1
 */