import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

public final class wkh
  extends QQUIEventReceiver<wjw, uwf>
{
  public wkh(@NonNull wjw paramwjw)
  {
    super(paramwjw);
  }
  
  public void a(@NonNull wjw paramwjw, @NonNull uwf paramuwf)
  {
    if (wjw.a(paramwjw) == null) {
      wxe.b("Q.qqstory.detail.StoryDetailPresenter", "ignore this tag info event. %s.", paramuwf.toString());
    }
    do
    {
      do
      {
        return;
      } while (!paramuwf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      wxe.a("Q.qqstory.detail.StoryDetailPresenter", "receive tag info event. %s.", paramuwf.toString());
      paramuwf = (vfl)paramuwf.jdField_a_of_type_JavaUtilMap.get(wjw.a(paramwjw));
    } while (paramuwf == null);
    paramuwf = ((uwd)uwa.a(27)).a(wjw.a(paramwjw).a(), paramuwf.a);
    wjw.a(paramwjw).b(paramuwf, true);
    paramwjw.a();
  }
  
  public Class acceptEventClass()
  {
    return uwf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkh
 * JD-Core Version:    0.7.0.1
 */