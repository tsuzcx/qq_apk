import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;

public class uxf
  extends sth<uwt, uxn>
{
  public uxf(uwt paramuwt)
  {
    super(paramuwt);
  }
  
  public void a(@NonNull uwt paramuwt, @NonNull uxn paramuxn)
  {
    Object localObject = paramuxn.a;
    paramuxn = paramuwt.a(((uxp)localObject).a.feedId);
    if (paramuxn == null)
    {
      veg.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { ((uxp)localObject).a.feedId });
      return;
    }
    if ((!(localObject instanceof uxr)) || (!(paramuxn instanceof uxr)))
    {
      veg.e("Q.qqstory.home.data.HomeFeedPresenter", "SingleFeedInfoEvent error!!");
      return;
    }
    localObject = (uxr)localObject;
    paramuxn = (uxr)paramuxn;
    paramuxn.a = ((uxr)localObject).a;
    paramuxn.a(((uxr)localObject).b(), false);
    paramuxn.b(((uxr)localObject).c(), false);
    paramuxn.c(((uxr)localObject).a(), false);
    uwt.a(paramuwt).b(paramuxn.a.feedId);
    veg.a("Q.qqstory.home.data.HomeFeedPresenter", "single feed update from server %s", paramuxn);
  }
  
  public Class acceptEventClass()
  {
    return uxn.class;
  }
  
  public void b(@NonNull uwt paramuwt, @NonNull uxn paramuxn) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxf
 * JD-Core Version:    0.7.0.1
 */