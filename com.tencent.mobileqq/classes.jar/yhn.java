import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

public final class yhn
  extends QQUIEventReceiver<yhc, wtm>
{
  public yhn(@NonNull yhc paramyhc)
  {
    super(paramyhc);
  }
  
  public void a(@NonNull yhc paramyhc, @NonNull wtm paramwtm)
  {
    if (yhc.a(paramyhc) == null) {
      yuk.b("Q.qqstory.detail.StoryDetailPresenter", "ignore this tag info event. %s.", paramwtm.toString());
    }
    do
    {
      do
      {
        return;
      } while (!paramwtm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      yuk.a("Q.qqstory.detail.StoryDetailPresenter", "receive tag info event. %s.", paramwtm.toString());
      paramwtm = (xcs)paramwtm.jdField_a_of_type_JavaUtilMap.get(yhc.a(paramyhc));
    } while (paramwtm == null);
    paramwtm = ((wtk)wth.a(27)).a(yhc.a(paramyhc).a(), paramwtm.a);
    yhc.a(paramyhc).b(paramwtm, true);
    paramyhc.a();
  }
  
  public Class acceptEventClass()
  {
    return wtm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhn
 * JD-Core Version:    0.7.0.1
 */