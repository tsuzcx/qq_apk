import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;

public class vmd
  extends Subscriber.SingleEventSubscriberNoRefect<uzs>
{
  vlz a;
  
  public vmd(@NonNull vlz paramvlz)
  {
    this.a = paramvlz;
  }
  
  protected void a(@NonNull uzs paramuzs)
  {
    if (paramuzs.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      this.a.a(paramuzs.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Class acceptEventClass()
  {
    return uzs.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmd
 * JD-Core Version:    0.7.0.1
 */