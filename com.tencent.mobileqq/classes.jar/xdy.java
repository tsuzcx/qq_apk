import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class xdy
  extends Subscriber.SingleEventSubscriberNoRefect<wrt>
{
  xdu a;
  
  public xdy(@NonNull xdu paramxdu)
  {
    this.a = paramxdu;
  }
  
  protected void a(@NonNull wrt paramwrt)
  {
    if (paramwrt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramwrt.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return wrt.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdy
 * JD-Core Version:    0.7.0.1
 */