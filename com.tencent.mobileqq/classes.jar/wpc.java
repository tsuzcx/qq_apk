import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class wpc
  extends Subscriber.SingleEventSubscriberNoRefect<vuc>
{
  woz a;
  
  public wpc(@NonNull woz paramwoz)
  {
    this.a = paramwoz;
  }
  
  protected void a(@NonNull vuc paramvuc)
  {
    if (paramvuc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramvuc.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return vuc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpc
 * JD-Core Version:    0.7.0.1
 */