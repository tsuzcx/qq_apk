import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class xkt
  extends QQUIEventReceiver<xks, wbh>
{
  public xkt(@NonNull xks paramxks)
  {
    super(paramxks);
  }
  
  public void a(@NonNull xks paramxks, @NonNull wbh paramwbh)
  {
    if (!TextUtils.equals(String.valueOf(paramxks.hashCode()), paramwbh.jdField_a_of_type_JavaLangString)) {
      return;
    }
    xvv.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video collection list. %s.", paramwbh);
    if (paramwbh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      if (paramwbh.jdField_a_of_type_Int != -1) {
        paramxks.jdField_a_of_type_Int = paramwbh.jdField_a_of_type_Int;
      }
      paramxks.jdField_a_of_type_Boolean = true;
      paramxks.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = null;
      if (paramwbh.e)
      {
        paramxks.a(paramwbh.jdField_a_of_type_JavaUtilList, paramwbh.c, paramwbh.jdField_a_of_type_Boolean);
        paramxks.b = paramwbh.jdField_a_of_type_Boolean;
      }
    }
    for (;;)
    {
      xks.a(paramxks).a(paramwbh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      return;
      paramxks.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramwbh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
    }
  }
  
  public Class acceptEventClass()
  {
    return wbh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkt
 * JD-Core Version:    0.7.0.1
 */