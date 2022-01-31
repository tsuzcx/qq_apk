import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class vmc
  extends Subscriber.SingleEventSubscriberNoRefect<uqw>
{
  vlz a;
  
  public vmc(@NonNull vlz paramvlz)
  {
    this.a = paramvlz;
  }
  
  protected void a(@NonNull uqw paramuqw)
  {
    if (paramuqw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramuqw.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return uqw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmc
 * JD-Core Version:    0.7.0.1
 */