import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class xzo
  extends QQUIEventReceiver<xzn, wqc>
{
  public xzo(@NonNull xzn paramxzn)
  {
    super(paramxzn);
  }
  
  public void a(@NonNull xzn paramxzn, @NonNull wqc paramwqc)
  {
    if (!TextUtils.equals(String.valueOf(paramxzn.hashCode()), paramwqc.jdField_a_of_type_JavaLangString)) {
      return;
    }
    ykq.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video collection list. %s.", paramwqc);
    if (paramwqc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      if (paramwqc.jdField_a_of_type_Int != -1) {
        paramxzn.jdField_a_of_type_Int = paramwqc.jdField_a_of_type_Int;
      }
      paramxzn.jdField_a_of_type_Boolean = true;
      paramxzn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = null;
      if (paramwqc.e)
      {
        paramxzn.a(paramwqc.jdField_a_of_type_JavaUtilList, paramwqc.c, paramwqc.jdField_a_of_type_Boolean);
        paramxzn.b = paramwqc.jdField_a_of_type_Boolean;
      }
    }
    for (;;)
    {
      xzn.a(paramxzn).a(paramwqc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      return;
      paramxzn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramwqc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
    }
  }
  
  public Class acceptEventClass()
  {
    return wqc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzo
 * JD-Core Version:    0.7.0.1
 */