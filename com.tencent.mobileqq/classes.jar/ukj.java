import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;

public class ukj
  extends sgl<ujx, ukr>
{
  public ukj(ujx paramujx)
  {
    super(paramujx);
  }
  
  public void a(@NonNull ujx paramujx, @NonNull ukr paramukr)
  {
    Object localObject = paramukr.a;
    paramukr = paramujx.a(((ukt)localObject).a.feedId);
    if (paramukr == null)
    {
      urk.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { ((ukt)localObject).a.feedId });
      return;
    }
    if ((!(localObject instanceof ukv)) || (!(paramukr instanceof ukv)))
    {
      urk.e("Q.qqstory.home.data.HomeFeedPresenter", "SingleFeedInfoEvent error!!");
      return;
    }
    localObject = (ukv)localObject;
    paramukr = (ukv)paramukr;
    paramukr.a = ((ukv)localObject).a;
    paramukr.a(((ukv)localObject).b(), false);
    paramukr.b(((ukv)localObject).c(), false);
    paramukr.c(((ukv)localObject).a(), false);
    ujx.a(paramujx).b(paramukr.a.feedId);
    urk.a("Q.qqstory.home.data.HomeFeedPresenter", "single feed update from server %s", paramukr);
  }
  
  public Class acceptEventClass()
  {
    return ukr.class;
  }
  
  public void b(@NonNull ujx paramujx, @NonNull ukr paramukr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukj
 * JD-Core Version:    0.7.0.1
 */