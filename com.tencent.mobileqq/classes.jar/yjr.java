import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yjr
  extends QQUIEventReceiver<yjc, wix>
{
  public yjr(@NonNull yjc paramyjc)
  {
    super(paramyjc);
  }
  
  public void a(@NonNull yjc paramyjc, @NonNull wix paramwix)
  {
    if (paramwix.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      ykq.d(this.TAG, "deleted story failed");
      paramyjc.a(5, paramwix.jdField_a_of_type_JavaLangString);
      return;
    }
    paramyjc.a(paramwix.jdField_a_of_type_JavaLangString);
    paramyjc.a(new ygl[] { new ygg(yfo.a(yjc.a(paramyjc).a.jdField_a_of_type_JavaLangString)), (ygl)paramyjc.c.a() });
  }
  
  public Class acceptEventClass()
  {
    return wix.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjr
 * JD-Core Version:    0.7.0.1
 */