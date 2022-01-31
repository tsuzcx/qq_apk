import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class txl
  extends Subscriber.SingleEventSubscriberNoRefect<tla>
{
  txh a;
  
  public txl(@NonNull txh paramtxh)
  {
    this.a = paramtxh;
  }
  
  protected void a(@NonNull tla paramtla)
  {
    if (paramtla.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramtla.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return tla.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txl
 * JD-Core Version:    0.7.0.1
 */