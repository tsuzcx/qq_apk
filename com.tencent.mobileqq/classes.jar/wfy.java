import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

public final class wfy
  extends QQUIEventReceiver<wfn, urw>
{
  public wfy(@NonNull wfn paramwfn)
  {
    super(paramwfn);
  }
  
  public void a(@NonNull wfn paramwfn, @NonNull urw paramurw)
  {
    if (wfn.a(paramwfn) == null) {
      wsv.b("Q.qqstory.detail.StoryDetailPresenter", "ignore this tag info event. %s.", paramurw.toString());
    }
    do
    {
      do
      {
        return;
      } while (!paramurw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      wsv.a("Q.qqstory.detail.StoryDetailPresenter", "receive tag info event. %s.", paramurw.toString());
      paramurw = (vbc)paramurw.jdField_a_of_type_JavaUtilMap.get(wfn.a(paramwfn));
    } while (paramurw == null);
    paramurw = ((uru)urr.a(27)).a(wfn.a(paramwfn).a(), paramurw.a);
    wfn.a(paramwfn).b(paramurw, true);
    paramwfn.a();
  }
  
  public Class acceptEventClass()
  {
    return urw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wfy
 * JD-Core Version:    0.7.0.1
 */