import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class yjj
  extends QQUIEventReceiver<yjh, xbt>
{
  public yjj(@NonNull yjh paramyjh)
  {
    super(paramyjh);
  }
  
  public void a(@NonNull yjh paramyjh, @NonNull xbt paramxbt)
  {
    yuk.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video info list. %s.", paramxbt.toString());
    if (paramxbt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      yjh.a(paramyjh).a(paramxbt.jdField_a_of_type_JavaLangString, paramxbt.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return xbt.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjj
 * JD-Core Version:    0.7.0.1
 */