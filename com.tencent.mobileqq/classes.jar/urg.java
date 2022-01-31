import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

public final class urg
  extends QQUIEventReceiver<uqv, tde>
{
  public urg(@NonNull uqv paramuqv)
  {
    super(paramuqv);
  }
  
  public void a(@NonNull uqv paramuqv, @NonNull tde paramtde)
  {
    if (uqv.a(paramuqv) == null) {
      ved.b("Q.qqstory.detail.StoryDetailPresenter", "ignore this tag info event. %s.", paramtde.toString());
    }
    do
    {
      do
      {
        return;
      } while (!paramtde.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      ved.a("Q.qqstory.detail.StoryDetailPresenter", "receive tag info event. %s.", paramtde.toString());
      paramtde = (tmk)paramtde.jdField_a_of_type_JavaUtilMap.get(uqv.a(paramuqv));
    } while (paramtde == null);
    paramtde = ((tdc)tcz.a(27)).a(uqv.a(paramuqv).a(), paramtde.a);
    uqv.a(paramuqv).b(paramtde, true);
    paramuqv.a();
  }
  
  public Class acceptEventClass()
  {
    return tde.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urg
 * JD-Core Version:    0.7.0.1
 */