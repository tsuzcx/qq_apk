import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yof
  extends QQUIEventReceiver<ynm, wxv>
{
  public yof(@NonNull ynm paramynm)
  {
    super(paramynm);
  }
  
  public void a(@NonNull ynm paramynm, @NonNull wxv paramwxv)
  {
    if ((paramwxv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramwxv.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    paramynm.a(paramwxv);
  }
  
  public Class acceptEventClass()
  {
    return wxv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yof
 * JD-Core Version:    0.7.0.1
 */