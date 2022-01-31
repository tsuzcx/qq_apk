import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class ugj
  extends QQUIEventReceiver<ugh, sys>
{
  public ugj(@NonNull ugh paramugh)
  {
    super(paramugh);
  }
  
  public void a(@NonNull ugh paramugh, @NonNull sys paramsys)
  {
    urk.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video info list. %s.", paramsys.toString());
    if (paramsys.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      ugh.a(paramugh).a(paramsys.jdField_a_of_type_JavaLangString, paramsys.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return sys.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugj
 * JD-Core Version:    0.7.0.1
 */