import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.ProfileFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class xjo
  extends xil<ProfileFeedPlayInfo>
{
  public xjo(ProfileFeedPlayInfo paramProfileFeedPlayInfo)
  {
    super(paramProfileFeedPlayInfo);
    paramProfileFeedPlayInfo = (yij)wpm.a(11);
    if (paramProfileFeedPlayInfo.b != null) {
      this.a = paramProfileFeedPlayInfo.b;
    }
  }
  
  public yib a(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      yib localyib = (yib)localIterator.next();
      if (localyib.a.equals(paramString)) {
        return localyib;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, xjd paramxjd)
  {
    if (this.a == null)
    {
      paramxjd.a(new ErrorMessage(940001, "null point"), null, true);
      return;
    }
    Object localObject = this.a.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject).size() > 0))
    {
      List localList = b((List)localObject);
      paramxjd.a(new ErrorMessage(), localList, this.a.jdField_a_of_type_Boolean);
      yqp.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject).size()));
      return;
    }
    localObject = new wzd();
    ((wzd)localObject).a = this.a.a();
    ((wzd)localObject).b = QQStoryContext.a().b();
    yqp.c("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "start request with cookie " + ((wzd)localObject).a);
    wlb.a().a((wlf)localObject, new xjp(this, paramxjd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjo
 * JD-Core Version:    0.7.0.1
 */