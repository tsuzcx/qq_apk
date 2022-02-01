import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class yji
  extends QQUIEventReceiver<yjh, wzr>
{
  public yji(@NonNull yjh paramyjh)
  {
    super(paramyjh);
  }
  
  public void a(@NonNull yjh paramyjh, @NonNull wzr paramwzr)
  {
    if (!TextUtils.equals(String.valueOf(paramyjh.hashCode()), paramwzr.jdField_a_of_type_JavaLangString)) {
      return;
    }
    yuk.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video collection list. %s.", paramwzr);
    if (paramwzr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      if (paramwzr.jdField_a_of_type_Int != -1) {
        paramyjh.jdField_a_of_type_Int = paramwzr.jdField_a_of_type_Int;
      }
      paramyjh.jdField_a_of_type_Boolean = true;
      paramyjh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = null;
      if (paramwzr.e)
      {
        paramyjh.a(paramwzr.jdField_a_of_type_JavaUtilList, paramwzr.c, paramwzr.jdField_a_of_type_Boolean);
        paramyjh.b = paramwzr.jdField_a_of_type_Boolean;
      }
    }
    for (;;)
    {
      yjh.a(paramyjh).a(paramwzr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      return;
      paramyjh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramwzr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
    }
  }
  
  public Class acceptEventClass()
  {
    return wzr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yji
 * JD-Core Version:    0.7.0.1
 */