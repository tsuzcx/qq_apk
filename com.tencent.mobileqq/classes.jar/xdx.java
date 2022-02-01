import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class xdx
  extends Subscriber.SingleEventSubscriberNoRefect<wix>
{
  xdu a;
  
  public xdx(@NonNull xdu paramxdu)
  {
    this.a = paramxdu;
  }
  
  protected void a(@NonNull wix paramwix)
  {
    if (paramwix.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramwix.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return wix.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdx
 * JD-Core Version:    0.7.0.1
 */