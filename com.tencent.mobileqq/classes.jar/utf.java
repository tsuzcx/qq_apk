import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class utf
  extends QQUIEventReceiver<utd, tlo>
{
  public utf(@NonNull utd paramutd)
  {
    super(paramutd);
  }
  
  public void a(@NonNull utd paramutd, @NonNull tlo paramtlo)
  {
    veg.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video info list. %s.", paramtlo.toString());
    if (paramtlo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      utd.a(paramutd).a(paramtlo.jdField_a_of_type_JavaLangString, paramtlo.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return tlo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utf
 * JD-Core Version:    0.7.0.1
 */