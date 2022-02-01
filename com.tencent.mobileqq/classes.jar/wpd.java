import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class wpd
  extends Subscriber.SingleEventSubscriberNoRefect<wcy>
{
  woz a;
  
  public wpd(@NonNull woz paramwoz)
  {
    this.a = paramwoz;
  }
  
  protected void a(@NonNull wcy paramwcy)
  {
    if (paramwcy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramwcy.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return wcy.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpd
 * JD-Core Version:    0.7.0.1
 */