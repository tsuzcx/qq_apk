import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class txk
  extends Subscriber.SingleEventSubscriberNoRefect<tce>
{
  txh a;
  
  public txk(@NonNull txh paramtxh)
  {
    this.a = paramtxh;
  }
  
  protected void a(@NonNull tce paramtce)
  {
    if (paramtce.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramtce.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return tce.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txk
 * JD-Core Version:    0.7.0.1
 */