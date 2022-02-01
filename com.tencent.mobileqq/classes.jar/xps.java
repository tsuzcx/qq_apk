import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xps
  extends QQUIEventReceiver<xpq, xau>
{
  public xps(@NonNull xpq paramxpq)
  {
    super(paramxpq);
  }
  
  public void a(@NonNull xpq paramxpq, @NonNull xau paramxau)
  {
    yuk.b("InteractWidgetPageHolder", "receive poll info event.");
    if (paramxpq.d()) {
      paramxpq.a(paramxpq.jdField_a_of_type_Int, paramxpq.b, paramxpq.jdField_a_of_type_Xqz, paramxpq.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return xau.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xps
 * JD-Core Version:    0.7.0.1
 */