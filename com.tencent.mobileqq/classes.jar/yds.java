import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

public final class yds
  extends QQUIEventReceiver<ydh, wpr>
{
  public yds(@NonNull ydh paramydh)
  {
    super(paramydh);
  }
  
  public void a(@NonNull ydh paramydh, @NonNull wpr paramwpr)
  {
    if (ydh.a(paramydh) == null) {
      yqp.b("Q.qqstory.detail.StoryDetailPresenter", "ignore this tag info event. %s.", paramwpr.toString());
    }
    do
    {
      do
      {
        return;
      } while (!paramwpr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      yqp.a("Q.qqstory.detail.StoryDetailPresenter", "receive tag info event. %s.", paramwpr.toString());
      paramwpr = (wyx)paramwpr.jdField_a_of_type_JavaUtilMap.get(ydh.a(paramydh));
    } while (paramwpr == null);
    paramwpr = ((wpp)wpm.a(27)).a(ydh.a(paramydh).a(), paramwpr.a);
    ydh.a(paramydh).b(paramwpr, true);
    paramydh.a();
  }
  
  public Class acceptEventClass()
  {
    return wpr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yds
 * JD-Core Version:    0.7.0.1
 */