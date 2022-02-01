import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class xjw
  extends Subscriber.SingleEventSubscriberNoRefect<wor>
{
  xjt a;
  
  public xjw(@NonNull xjt paramxjt)
  {
    this.a = paramxjt;
  }
  
  protected void a(@NonNull wor paramwor)
  {
    if (paramwor.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramwor.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return wor.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjw
 * JD-Core Version:    0.7.0.1
 */