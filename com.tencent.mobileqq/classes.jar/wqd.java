import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;

public class wqd
  extends umf<wpr, wql>
{
  public wqd(wpr paramwpr)
  {
    super(paramwpr);
  }
  
  public void a(@NonNull wpr paramwpr, @NonNull wql paramwql)
  {
    Object localObject = paramwql.a;
    paramwql = paramwpr.a(((wqn)localObject).a.feedId);
    if (paramwql == null)
    {
      wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { ((wqn)localObject).a.feedId });
      return;
    }
    if ((!(localObject instanceof wqp)) || (!(paramwql instanceof wqp)))
    {
      wxe.e("Q.qqstory.home.data.HomeFeedPresenter", "SingleFeedInfoEvent error!!");
      return;
    }
    localObject = (wqp)localObject;
    paramwql = (wqp)paramwql;
    paramwql.a = ((wqp)localObject).a;
    paramwql.a(((wqp)localObject).b(), false);
    paramwql.b(((wqp)localObject).c(), false);
    paramwql.c(((wqp)localObject).a(), false);
    wpr.a(paramwpr).b(paramwql.a.feedId);
    wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "single feed update from server %s", paramwql);
  }
  
  public Class acceptEventClass()
  {
    return wql.class;
  }
  
  public void b(@NonNull wpr paramwpr, @NonNull wql paramwql) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqd
 * JD-Core Version:    0.7.0.1
 */