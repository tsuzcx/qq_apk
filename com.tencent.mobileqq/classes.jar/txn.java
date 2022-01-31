import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class txn
  extends Subscriber.SingleEventSubscriberNoRefect<tch>
{
  txk a;
  
  public txn(@NonNull txk paramtxk)
  {
    this.a = paramtxk;
  }
  
  protected void a(@NonNull tch paramtch)
  {
    if (paramtch.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramtch.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return tch.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txn
 * JD-Core Version:    0.7.0.1
 */