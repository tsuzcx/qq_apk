import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.ProfileFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class wou
  extends wnr<ProfileFeedPlayInfo>
{
  public wou(ProfileFeedPlayInfo paramProfileFeedPlayInfo)
  {
    super(paramProfileFeedPlayInfo);
    paramProfileFeedPlayInfo = (xnp)vux.a(11);
    if (paramProfileFeedPlayInfo.b != null) {
      this.a = paramProfileFeedPlayInfo.b;
    }
  }
  
  public xnh a(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      xnh localxnh = (xnh)localIterator.next();
      if (localxnh.a.equals(paramString)) {
        return localxnh;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, woj paramwoj)
  {
    if (this.a == null)
    {
      paramwoj.a(new ErrorMessage(940001, "null point"), null, true);
      return;
    }
    Object localObject = this.a.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject).size() > 0))
    {
      List localList = b((List)localObject);
      paramwoj.a(new ErrorMessage(), localList, this.a.jdField_a_of_type_Boolean);
      xvv.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject).size()));
      return;
    }
    localObject = new weo();
    ((weo)localObject).a = this.a.a();
    ((weo)localObject).b = QQStoryContext.a().b();
    xvv.c("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "start request with cookie " + ((weo)localObject).a);
    vqn.a().a((vqr)localObject, new wov(this, paramwoj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wou
 * JD-Core Version:    0.7.0.1
 */