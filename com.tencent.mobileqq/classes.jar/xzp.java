import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class xzp
  extends QQUIEventReceiver<xzn, wse>
{
  public xzp(@NonNull xzn paramxzn)
  {
    super(paramxzn);
  }
  
  public void a(@NonNull xzn paramxzn, @NonNull wse paramwse)
  {
    ykq.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video info list. %s.", paramwse.toString());
    if (paramwse.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      xzn.a(paramxzn).a(paramwse.jdField_a_of_type_JavaLangString, paramwse.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return wse.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzp
 * JD-Core Version:    0.7.0.1
 */