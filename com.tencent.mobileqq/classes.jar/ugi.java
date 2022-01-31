import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class ugi
  extends QQUIEventReceiver<ugh, swq>
{
  public ugi(@NonNull ugh paramugh)
  {
    super(paramugh);
  }
  
  public void a(@NonNull ugh paramugh, @NonNull swq paramswq)
  {
    if (!TextUtils.equals(String.valueOf(paramugh.hashCode()), paramswq.jdField_a_of_type_JavaLangString)) {
      return;
    }
    urk.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video collection list. %s.", paramswq);
    if (paramswq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      if (paramswq.jdField_a_of_type_Int != -1) {
        paramugh.jdField_a_of_type_Int = paramswq.jdField_a_of_type_Int;
      }
      paramugh.jdField_a_of_type_Boolean = true;
      paramugh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = null;
      if (paramswq.e)
      {
        paramugh.a(paramswq.jdField_a_of_type_JavaUtilList, paramswq.c, paramswq.jdField_a_of_type_Boolean);
        paramugh.b = paramswq.jdField_a_of_type_Boolean;
      }
    }
    for (;;)
    {
      ugh.a(paramugh).a(paramswq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      return;
      paramugh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramswq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
    }
  }
  
  public Class acceptEventClass()
  {
    return swq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugi
 * JD-Core Version:    0.7.0.1
 */