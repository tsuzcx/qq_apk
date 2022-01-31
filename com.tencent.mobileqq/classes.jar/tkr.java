import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class tkr
  extends Subscriber.SingleEventSubscriberNoRefect<spl>
{
  tko a;
  
  public tkr(@NonNull tko paramtko)
  {
    this.a = paramtko;
  }
  
  protected void a(@NonNull spl paramspl)
  {
    if (paramspl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramspl.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return spl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tkr
 * JD-Core Version:    0.7.0.1
 */