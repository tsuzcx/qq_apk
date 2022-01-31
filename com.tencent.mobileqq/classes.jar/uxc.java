import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;

public class uxc
  extends ste<uwq, uxk>
{
  public uxc(uwq paramuwq)
  {
    super(paramuwq);
  }
  
  public void a(@NonNull uwq paramuwq, @NonNull uxk paramuxk)
  {
    Object localObject = paramuxk.a;
    paramuxk = paramuwq.a(((uxm)localObject).a.feedId);
    if (paramuxk == null)
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { ((uxm)localObject).a.feedId });
      return;
    }
    if ((!(localObject instanceof uxo)) || (!(paramuxk instanceof uxo)))
    {
      ved.e("Q.qqstory.home.data.HomeFeedPresenter", "SingleFeedInfoEvent error!!");
      return;
    }
    localObject = (uxo)localObject;
    paramuxk = (uxo)paramuxk;
    paramuxk.a = ((uxo)localObject).a;
    paramuxk.a(((uxo)localObject).b(), false);
    paramuxk.b(((uxo)localObject).c(), false);
    paramuxk.c(((uxo)localObject).a(), false);
    uwq.a(paramuwq).b(paramuxk.a.feedId);
    ved.a("Q.qqstory.home.data.HomeFeedPresenter", "single feed update from server %s", paramuxk);
  }
  
  public Class acceptEventClass()
  {
    return uxk.class;
  }
  
  public void b(@NonNull uwq paramuwq, @NonNull uxk paramuxk) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxc
 * JD-Core Version:    0.7.0.1
 */