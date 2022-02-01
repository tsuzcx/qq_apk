import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class xnr
  extends Subscriber.SingleEventSubscriberNoRefect<wsm>
{
  xno a;
  
  public xnr(@NonNull xno paramxno)
  {
    this.a = paramxno;
  }
  
  protected void a(@NonNull wsm paramwsm)
  {
    if (paramwsm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramwsm.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return wsm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnr
 * JD-Core Version:    0.7.0.1
 */