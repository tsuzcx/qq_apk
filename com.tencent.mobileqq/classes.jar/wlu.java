import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;

public class wlu
  extends uhw<wli, wmc>
{
  public wlu(wli paramwli)
  {
    super(paramwli);
  }
  
  public void a(@NonNull wli paramwli, @NonNull wmc paramwmc)
  {
    Object localObject = paramwmc.a;
    paramwmc = paramwli.a(((wme)localObject).a.feedId);
    if (paramwmc == null)
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { ((wme)localObject).a.feedId });
      return;
    }
    if ((!(localObject instanceof wmg)) || (!(paramwmc instanceof wmg)))
    {
      wsv.e("Q.qqstory.home.data.HomeFeedPresenter", "SingleFeedInfoEvent error!!");
      return;
    }
    localObject = (wmg)localObject;
    paramwmc = (wmg)paramwmc;
    paramwmc.a = ((wmg)localObject).a;
    paramwmc.a(((wmg)localObject).b(), false);
    paramwmc.b(((wmg)localObject).c(), false);
    paramwmc.c(((wmg)localObject).a(), false);
    wli.a(paramwli).b(paramwmc.a.feedId);
    wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "single feed update from server %s", paramwmc);
  }
  
  public Class acceptEventClass()
  {
    return wmc.class;
  }
  
  public void b(@NonNull wli paramwli, @NonNull wmc paramwmc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlu
 * JD-Core Version:    0.7.0.1
 */