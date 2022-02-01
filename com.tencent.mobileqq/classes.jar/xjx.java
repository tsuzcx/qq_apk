import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class xjx
  extends Subscriber.SingleEventSubscriberNoRefect<wxn>
{
  xjt a;
  
  public xjx(@NonNull xjt paramxjt)
  {
    this.a = paramxjt;
  }
  
  protected void a(@NonNull wxn paramwxn)
  {
    if (paramwxn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramwxn.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return wxn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjx
 * JD-Core Version:    0.7.0.1
 */