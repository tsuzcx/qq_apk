import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class vql
  extends Subscriber.SingleEventSubscriberNoRefect<uvf>
{
  vqi a;
  
  public vql(@NonNull vqi paramvqi)
  {
    this.a = paramvqi;
  }
  
  protected void a(@NonNull uvf paramuvf)
  {
    if (paramuvf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramuvf.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return uvf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vql
 * JD-Core Version:    0.7.0.1
 */