import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ypq
  extends QQUIEventReceiver<ypb, wor>
{
  public ypq(@NonNull ypb paramypb)
  {
    super(paramypb);
  }
  
  public void a(@NonNull ypb paramypb, @NonNull wor paramwor)
  {
    if (paramwor.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      yqp.d(this.TAG, "deleted story failed");
      paramypb.a(5, paramwor.jdField_a_of_type_JavaLangString);
      return;
    }
    paramypb.a(paramwor.jdField_a_of_type_JavaLangString);
    paramypb.a(new ymk[] { new ymf(yln.a(ypb.a(paramypb).a.jdField_a_of_type_JavaLangString)), (ymk)paramypb.c.a() });
  }
  
  public Class acceptEventClass()
  {
    return wor.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypq
 * JD-Core Version:    0.7.0.1
 */