import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class yfo
  extends QQUIEventReceiver<yfm, wxy>
{
  public yfo(@NonNull yfm paramyfm)
  {
    super(paramyfm);
  }
  
  public void a(@NonNull yfm paramyfm, @NonNull wxy paramwxy)
  {
    yqp.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video info list. %s.", paramwxy.toString());
    if (paramwxy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      yfm.a(paramyfm).a(paramwxy.jdField_a_of_type_JavaLangString, paramwxy.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return wxy.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfo
 * JD-Core Version:    0.7.0.1
 */