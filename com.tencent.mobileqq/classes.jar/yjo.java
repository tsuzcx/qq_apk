import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;

public class yjo
  extends wfr<yjc, yjw>
{
  public yjo(yjc paramyjc)
  {
    super(paramyjc);
  }
  
  public void a(@NonNull yjc paramyjc, @NonNull yjw paramyjw)
  {
    Object localObject = paramyjw.a;
    paramyjw = paramyjc.a(((yjy)localObject).a.feedId);
    if (paramyjw == null)
    {
      yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { ((yjy)localObject).a.feedId });
      return;
    }
    if ((!(localObject instanceof yka)) || (!(paramyjw instanceof yka)))
    {
      yqp.e("Q.qqstory.home.data.HomeFeedPresenter", "SingleFeedInfoEvent error!!");
      return;
    }
    localObject = (yka)localObject;
    paramyjw = (yka)paramyjw;
    paramyjw.a = ((yka)localObject).a;
    paramyjw.a(((yka)localObject).b(), false);
    paramyjw.b(((yka)localObject).c(), false);
    paramyjw.c(((yka)localObject).a(), false);
    yjc.a(paramyjc).b(paramyjw.a.feedId);
    yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "single feed update from server %s", paramyjw);
  }
  
  public Class acceptEventClass()
  {
    return yjw.class;
  }
  
  public void b(@NonNull yjc paramyjc, @NonNull yjw paramyjw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjo
 * JD-Core Version:    0.7.0.1
 */