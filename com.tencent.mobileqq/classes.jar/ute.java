import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class ute
  extends QQUIEventReceiver<utd, tjm>
{
  public ute(@NonNull utd paramutd)
  {
    super(paramutd);
  }
  
  public void a(@NonNull utd paramutd, @NonNull tjm paramtjm)
  {
    if (!TextUtils.equals(String.valueOf(paramutd.hashCode()), paramtjm.jdField_a_of_type_JavaLangString)) {
      return;
    }
    veg.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video collection list. %s.", paramtjm);
    if (paramtjm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      if (paramtjm.jdField_a_of_type_Int != -1) {
        paramutd.jdField_a_of_type_Int = paramtjm.jdField_a_of_type_Int;
      }
      paramutd.jdField_a_of_type_Boolean = true;
      paramutd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = null;
      if (paramtjm.e)
      {
        paramutd.a(paramtjm.jdField_a_of_type_JavaUtilList, paramtjm.c, paramtjm.jdField_a_of_type_Boolean);
        paramutd.b = paramtjm.jdField_a_of_type_Boolean;
      }
    }
    for (;;)
    {
      utd.a(paramutd).a(paramtjm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      return;
      paramutd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramtjm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
    }
  }
  
  public Class acceptEventClass()
  {
    return tjm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ute
 * JD-Core Version:    0.7.0.1
 */