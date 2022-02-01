import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xpt
  extends QQUIEventReceiver<xpq, xbm>
{
  public xpt(@NonNull xpq paramxpq)
  {
    super(paramxpq);
  }
  
  public void a(@NonNull xpq paramxpq, @NonNull xbm paramxbm)
  {
    yuk.b("InteractWidgetPageHolder", "receive send vid rate data result event.");
    if (paramxpq.d()) {
      paramxpq.a(paramxpq.jdField_a_of_type_Int, paramxpq.b, paramxpq.jdField_a_of_type_Xqz, paramxpq.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return xbm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpt
 * JD-Core Version:    0.7.0.1
 */