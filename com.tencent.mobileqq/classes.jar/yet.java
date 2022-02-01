import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yet
  extends QQUIEventReceiver<yer, wsb>
{
  public yet(@NonNull yer paramyer)
  {
    super(paramyer);
  }
  
  public void a(@NonNull yer paramyer, @NonNull wsb paramwsb)
  {
    if ((paramwsb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramwsb.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    paramyer.b(paramwsb.jdField_a_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return wsb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yet
 * JD-Core Version:    0.7.0.1
 */