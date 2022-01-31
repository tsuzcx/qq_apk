import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class wht
  extends QQUIEventReceiver<whs, uyb>
{
  public wht(@NonNull whs paramwhs)
  {
    super(paramwhs);
  }
  
  public void a(@NonNull whs paramwhs, @NonNull uyb paramuyb)
  {
    if (!TextUtils.equals(String.valueOf(paramwhs.hashCode()), paramuyb.jdField_a_of_type_JavaLangString)) {
      return;
    }
    wsv.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video collection list. %s.", paramuyb);
    if (paramuyb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      if (paramuyb.jdField_a_of_type_Int != -1) {
        paramwhs.jdField_a_of_type_Int = paramuyb.jdField_a_of_type_Int;
      }
      paramwhs.jdField_a_of_type_Boolean = true;
      paramwhs.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = null;
      if (paramuyb.e)
      {
        paramwhs.a(paramuyb.jdField_a_of_type_JavaUtilList, paramuyb.c, paramuyb.jdField_a_of_type_Boolean);
        paramwhs.b = paramuyb.jdField_a_of_type_Boolean;
      }
    }
    for (;;)
    {
      whs.a(paramwhs).a(paramuyb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      return;
      paramwhs.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramuyb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
    }
  }
  
  public Class acceptEventClass()
  {
    return uyb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wht
 * JD-Core Version:    0.7.0.1
 */