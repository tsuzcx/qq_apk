import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class txo
  extends Subscriber.SingleEventSubscriberNoRefect<tld>
{
  txk a;
  
  public txo(@NonNull txk paramtxk)
  {
    this.a = paramtxk;
  }
  
  protected void a(@NonNull tld paramtld)
  {
    if (paramtld.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramtld.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return tld.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txo
 * JD-Core Version:    0.7.0.1
 */