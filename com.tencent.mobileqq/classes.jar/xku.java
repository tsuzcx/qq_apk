import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class xku
  extends QQUIEventReceiver<xks, wdj>
{
  public xku(@NonNull xks paramxks)
  {
    super(paramxks);
  }
  
  public void a(@NonNull xks paramxks, @NonNull wdj paramwdj)
  {
    xvv.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video info list. %s.", paramwdj.toString());
    if (paramwdj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      xks.a(paramxks).a(paramwdj.jdField_a_of_type_JavaLangString, paramwdj.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return wdj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xku
 * JD-Core Version:    0.7.0.1
 */