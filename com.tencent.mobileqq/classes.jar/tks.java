import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class tks
  extends Subscriber.SingleEventSubscriberNoRefect<syh>
{
  tko a;
  
  public tks(@NonNull tko paramtko)
  {
    this.a = paramtko;
  }
  
  protected void a(@NonNull syh paramsyh)
  {
    if (paramsyh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramsyh.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return syh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tks
 * JD-Core Version:    0.7.0.1
 */