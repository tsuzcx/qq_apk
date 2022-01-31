import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class wmd
  extends QQUIEventReceiver<wmb, vem>
{
  public wmd(@NonNull wmb paramwmb)
  {
    super(paramwmb);
  }
  
  public void a(@NonNull wmb paramwmb, @NonNull vem paramvem)
  {
    wxe.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video info list. %s.", paramvem.toString());
    if (paramvem.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      wmb.a(paramwmb).a(paramvem.jdField_a_of_type_JavaLangString, paramvem.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return vem.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wmd
 * JD-Core Version:    0.7.0.1
 */