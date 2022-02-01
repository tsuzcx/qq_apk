import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class yfn
  extends QQUIEventReceiver<yfm, wvw>
{
  public yfn(@NonNull yfm paramyfm)
  {
    super(paramyfm);
  }
  
  public void a(@NonNull yfm paramyfm, @NonNull wvw paramwvw)
  {
    if (!TextUtils.equals(String.valueOf(paramyfm.hashCode()), paramwvw.jdField_a_of_type_JavaLangString)) {
      return;
    }
    yqp.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video collection list. %s.", paramwvw);
    if (paramwvw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      if (paramwvw.jdField_a_of_type_Int != -1) {
        paramyfm.jdField_a_of_type_Int = paramwvw.jdField_a_of_type_Int;
      }
      paramyfm.jdField_a_of_type_Boolean = true;
      paramyfm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = null;
      if (paramwvw.e)
      {
        paramyfm.a(paramwvw.jdField_a_of_type_JavaUtilList, paramwvw.c, paramwvw.jdField_a_of_type_Boolean);
        paramyfm.b = paramwvw.jdField_a_of_type_Boolean;
      }
    }
    for (;;)
    {
      yfm.a(paramyfm).a(paramwvw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      return;
      paramyfm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramwvw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
    }
  }
  
  public Class acceptEventClass()
  {
    return wvw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfn
 * JD-Core Version:    0.7.0.1
 */