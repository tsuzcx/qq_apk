import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class utc
  extends QQUIEventReceiver<uta, tll>
{
  public utc(@NonNull uta paramuta)
  {
    super(paramuta);
  }
  
  public void a(@NonNull uta paramuta, @NonNull tll paramtll)
  {
    ved.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video info list. %s.", paramtll.toString());
    if (paramtll.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      uta.a(paramuta).a(paramtll.jdField_a_of_type_JavaLangString, paramtll.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return tll.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utc
 * JD-Core Version:    0.7.0.1
 */