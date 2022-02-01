import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yks
  extends QQUIEventReceiver<ykq, wxv>
{
  public yks(@NonNull ykq paramykq)
  {
    super(paramykq);
  }
  
  public void a(@NonNull ykq paramykq, @NonNull wxv paramwxv)
  {
    if ((paramwxv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramwxv.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    paramykq.b(paramwxv.jdField_a_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return wxv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yks
 * JD-Core Version:    0.7.0.1
 */