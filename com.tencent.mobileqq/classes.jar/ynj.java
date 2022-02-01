import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;

public class ynj
  extends wjm<ymx, ynr>
{
  public ynj(ymx paramymx)
  {
    super(paramymx);
  }
  
  public void a(@NonNull ymx paramymx, @NonNull ynr paramynr)
  {
    Object localObject = paramynr.a;
    paramynr = paramymx.a(((ynt)localObject).a.feedId);
    if (paramynr == null)
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { ((ynt)localObject).a.feedId });
      return;
    }
    if ((!(localObject instanceof ynv)) || (!(paramynr instanceof ynv)))
    {
      yuk.e("Q.qqstory.home.data.HomeFeedPresenter", "SingleFeedInfoEvent error!!");
      return;
    }
    localObject = (ynv)localObject;
    paramynr = (ynv)paramynr;
    paramynr.a = ((ynv)localObject).a;
    paramynr.a(((ynv)localObject).b(), false);
    paramynr.b(((ynv)localObject).c(), false);
    paramynr.c(((ynv)localObject).a(), false);
    ymx.a(paramymx).b(paramynr.a.feedId);
    yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "single feed update from server %s", paramynr);
  }
  
  public Class acceptEventClass()
  {
    return ynr.class;
  }
  
  public void b(@NonNull ymx paramymx, @NonNull ynr paramynr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynj
 * JD-Core Version:    0.7.0.1
 */