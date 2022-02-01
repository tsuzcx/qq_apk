import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yig
  extends QQUIEventReceiver<yhn, wsb>
{
  public yig(@NonNull yhn paramyhn)
  {
    super(paramyhn);
  }
  
  public void a(@NonNull yhn paramyhn, @NonNull wsb paramwsb)
  {
    if ((paramwsb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramwsb.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    paramyhn.a(paramwsb);
  }
  
  public Class acceptEventClass()
  {
    return wsb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yig
 * JD-Core Version:    0.7.0.1
 */