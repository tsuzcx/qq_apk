import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wrd
  extends QQUIEventReceiver<wrb, wck>
{
  public wrd(@NonNull wrb paramwrb)
  {
    super(paramwrb);
  }
  
  public void a(@NonNull wrb paramwrb, @NonNull wck paramwck)
  {
    xvv.b("InteractWidgetPageHolder", "receive poll info event.");
    if (paramwrb.d()) {
      paramwrb.a(paramwrb.jdField_a_of_type_Int, paramwrb.b, paramwrb.jdField_a_of_type_Wsk, paramwrb.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder);
    }
  }
  
  public Class acceptEventClass()
  {
    return wck.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrd
 * JD-Core Version:    0.7.0.1
 */