import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

public final class xxt
  extends QQUIEventReceiver<xxi, wjx>
{
  public xxt(@NonNull xxi paramxxi)
  {
    super(paramxxi);
  }
  
  public void a(@NonNull xxi paramxxi, @NonNull wjx paramwjx)
  {
    if (xxi.a(paramxxi) == null) {
      ykq.b("Q.qqstory.detail.StoryDetailPresenter", "ignore this tag info event. %s.", paramwjx.toString());
    }
    do
    {
      do
      {
        return;
      } while (!paramwjx.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      ykq.a("Q.qqstory.detail.StoryDetailPresenter", "receive tag info event. %s.", paramwjx.toString());
      paramwjx = (wtd)paramwjx.jdField_a_of_type_JavaUtilMap.get(xxi.a(paramxxi));
    } while (paramwjx == null);
    paramwjx = ((wjv)wjs.a(27)).a(xxi.a(paramxxi).a(), paramwjx.a);
    xxi.a(paramxxi).b(paramwjx, true);
    paramxxi.a();
  }
  
  public Class acceptEventClass()
  {
    return wjx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxt
 * JD-Core Version:    0.7.0.1
 */