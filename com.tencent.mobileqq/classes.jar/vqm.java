import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class vqm
  extends Subscriber.SingleEventSubscriberNoRefect<veb>
{
  vqi a;
  
  public vqm(@NonNull vqi paramvqi)
  {
    this.a = paramvqi;
  }
  
  protected void a(@NonNull veb paramveb)
  {
    if (paramveb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramveb.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return veb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqm
 * JD-Core Version:    0.7.0.1
 */