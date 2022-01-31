import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class wmc
  extends QQUIEventReceiver<wmb, vck>
{
  public wmc(@NonNull wmb paramwmb)
  {
    super(paramwmb);
  }
  
  public void a(@NonNull wmb paramwmb, @NonNull vck paramvck)
  {
    if (!TextUtils.equals(String.valueOf(paramwmb.hashCode()), paramvck.jdField_a_of_type_JavaLangString)) {
      return;
    }
    wxe.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video collection list. %s.", paramvck);
    if (paramvck.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      if (paramvck.jdField_a_of_type_Int != -1) {
        paramwmb.jdField_a_of_type_Int = paramvck.jdField_a_of_type_Int;
      }
      paramwmb.jdField_a_of_type_Boolean = true;
      paramwmb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = null;
      if (paramvck.e)
      {
        paramwmb.a(paramvck.jdField_a_of_type_JavaUtilList, paramvck.c, paramvck.jdField_a_of_type_Boolean);
        paramwmb.b = paramvck.jdField_a_of_type_Boolean;
      }
    }
    for (;;)
    {
      wmb.a(paramwmb).a(paramvck.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      return;
      paramwmb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramvck.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
    }
  }
  
  public Class acceptEventClass()
  {
    return vck.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wmc
 * JD-Core Version:    0.7.0.1
 */