import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;

public class ydp
  extends wag<ydd, ydx>
{
  public ydp(ydd paramydd)
  {
    super(paramydd);
  }
  
  public void a(@NonNull ydd paramydd, @NonNull ydx paramydx)
  {
    Object localObject = paramydx.a;
    paramydx = paramydd.a(((ydz)localObject).a.feedId);
    if (paramydx == null)
    {
      ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { ((ydz)localObject).a.feedId });
      return;
    }
    if ((!(localObject instanceof yeb)) || (!(paramydx instanceof yeb)))
    {
      ykq.e("Q.qqstory.home.data.HomeFeedPresenter", "SingleFeedInfoEvent error!!");
      return;
    }
    localObject = (yeb)localObject;
    paramydx = (yeb)paramydx;
    paramydx.a = ((yeb)localObject).a;
    paramydx.a(((yeb)localObject).b(), false);
    paramydx.b(((yeb)localObject).c(), false);
    paramydx.c(((yeb)localObject).a(), false);
    ydd.a(paramydd).b(paramydx.a.feedId);
    ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "single feed update from server %s", paramydx);
  }
  
  public Class acceptEventClass()
  {
    return ydx.class;
  }
  
  public void b(@NonNull ydd paramydd, @NonNull ydx paramydx) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydp
 * JD-Core Version:    0.7.0.1
 */