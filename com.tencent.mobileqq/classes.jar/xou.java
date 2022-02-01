import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;

public class xou
  extends vll<xoi, xpc>
{
  public xou(xoi paramxoi)
  {
    super(paramxoi);
  }
  
  public void a(@NonNull xoi paramxoi, @NonNull xpc paramxpc)
  {
    Object localObject = paramxpc.a;
    paramxpc = paramxoi.a(((xpe)localObject).a.feedId);
    if (paramxpc == null)
    {
      xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { ((xpe)localObject).a.feedId });
      return;
    }
    if ((!(localObject instanceof xpg)) || (!(paramxpc instanceof xpg)))
    {
      xvv.e("Q.qqstory.home.data.HomeFeedPresenter", "SingleFeedInfoEvent error!!");
      return;
    }
    localObject = (xpg)localObject;
    paramxpc = (xpg)paramxpc;
    paramxpc.a = ((xpg)localObject).a;
    paramxpc.a(((xpg)localObject).b(), false);
    paramxpc.b(((xpg)localObject).c(), false);
    paramxpc.c(((xpg)localObject).a(), false);
    xoi.a(paramxoi).b(paramxpc.a.feedId);
    xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "single feed update from server %s", paramxpc);
  }
  
  public Class acceptEventClass()
  {
    return xpc.class;
  }
  
  public void b(@NonNull xoi paramxoi, @NonNull xpc paramxpc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xou
 * JD-Core Version:    0.7.0.1
 */