import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class whu
  extends QQUIEventReceiver<whs, vad>
{
  public whu(@NonNull whs paramwhs)
  {
    super(paramwhs);
  }
  
  public void a(@NonNull whs paramwhs, @NonNull vad paramvad)
  {
    wsv.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video info list. %s.", paramvad.toString());
    if (paramvad.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      whs.a(paramwhs).a(paramvad.jdField_a_of_type_JavaLangString, paramvad.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return vad.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     whu
 * JD-Core Version:    0.7.0.1
 */