import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class xns
  extends Subscriber.SingleEventSubscriberNoRefect<xbi>
{
  xno a;
  
  public xns(@NonNull xno paramxno)
  {
    this.a = paramxno;
  }
  
  protected void a(@NonNull xbi paramxbi)
  {
    if (paramxbi.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramxbi.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return xbi.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xns
 * JD-Core Version:    0.7.0.1
 */