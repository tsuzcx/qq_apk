import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.ProfileFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class vqd
  extends vpa<ProfileFeedPlayInfo>
{
  public vqd(ProfileFeedPlayInfo paramProfileFeedPlayInfo)
  {
    super(paramProfileFeedPlayInfo);
    paramProfileFeedPlayInfo = (woy)uwa.a(11);
    if (paramProfileFeedPlayInfo.b != null) {
      this.a = paramProfileFeedPlayInfo.b;
    }
  }
  
  public woq a(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      woq localwoq = (woq)localIterator.next();
      if (localwoq.a.equals(paramString)) {
        return localwoq;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, vps paramvps)
  {
    if (this.a == null)
    {
      paramvps.a(new ErrorMessage(940001, "null point"), null, true);
      return;
    }
    Object localObject = this.a.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject).size() > 0))
    {
      List localList = b((List)localObject);
      paramvps.a(new ErrorMessage(), localList, this.a.jdField_a_of_type_Boolean);
      wxe.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject).size()));
      return;
    }
    localObject = new vfr();
    ((vfr)localObject).a = this.a.a();
    ((vfr)localObject).b = QQStoryContext.a().b();
    wxe.c("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "start request with cookie " + ((vfr)localObject).a);
    urp.a().a((urt)localObject, new vqe(this, paramvps));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqd
 * JD-Core Version:    0.7.0.1
 */