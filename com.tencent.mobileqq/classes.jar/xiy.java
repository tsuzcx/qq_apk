import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

public final class xiy
  extends QQUIEventReceiver<xin, vvc>
{
  public xiy(@NonNull xin paramxin)
  {
    super(paramxin);
  }
  
  public void a(@NonNull xin paramxin, @NonNull vvc paramvvc)
  {
    if (xin.a(paramxin) == null) {
      xvv.b("Q.qqstory.detail.StoryDetailPresenter", "ignore this tag info event. %s.", paramvvc.toString());
    }
    do
    {
      do
      {
        return;
      } while (!paramvvc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      xvv.a("Q.qqstory.detail.StoryDetailPresenter", "receive tag info event. %s.", paramvvc.toString());
      paramvvc = (wei)paramvvc.jdField_a_of_type_JavaUtilMap.get(xin.a(paramxin));
    } while (paramvvc == null);
    paramvvc = ((vva)vux.a(27)).a(xin.a(paramxin).a(), paramvvc.a);
    xin.a(paramxin).b(paramvvc, true);
    paramxin.a();
  }
  
  public Class acceptEventClass()
  {
    return vvc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xiy
 * JD-Core Version:    0.7.0.1
 */