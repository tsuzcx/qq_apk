import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class utb
  extends QQUIEventReceiver<uta, tjj>
{
  public utb(@NonNull uta paramuta)
  {
    super(paramuta);
  }
  
  public void a(@NonNull uta paramuta, @NonNull tjj paramtjj)
  {
    if (!TextUtils.equals(String.valueOf(paramuta.hashCode()), paramtjj.jdField_a_of_type_JavaLangString)) {
      return;
    }
    ved.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video collection list. %s.", paramtjj);
    if (paramtjj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      if (paramtjj.jdField_a_of_type_Int != -1) {
        paramuta.jdField_a_of_type_Int = paramtjj.jdField_a_of_type_Int;
      }
      paramuta.jdField_a_of_type_Boolean = true;
      paramuta.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = null;
      if (paramtjj.e)
      {
        paramuta.a(paramtjj.jdField_a_of_type_JavaUtilList, paramtjj.c, paramtjj.jdField_a_of_type_Boolean);
        paramuta.b = paramtjj.jdField_a_of_type_Boolean;
      }
    }
    for (;;)
    {
      uta.a(paramuta).a(paramtjj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      return;
      paramuta.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramtjj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
    }
  }
  
  public Class acceptEventClass()
  {
    return tjj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utb
 * JD-Core Version:    0.7.0.1
 */