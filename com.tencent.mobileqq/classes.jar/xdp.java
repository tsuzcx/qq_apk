import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.ProfileFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class xdp
  extends xcm<ProfileFeedPlayInfo>
{
  public xdp(ProfileFeedPlayInfo paramProfileFeedPlayInfo)
  {
    super(paramProfileFeedPlayInfo);
    paramProfileFeedPlayInfo = (yck)wjs.a(11);
    if (paramProfileFeedPlayInfo.b != null) {
      this.a = paramProfileFeedPlayInfo.b;
    }
  }
  
  public ycc a(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ycc localycc = (ycc)localIterator.next();
      if (localycc.a.equals(paramString)) {
        return localycc;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, xde paramxde)
  {
    if (this.a == null)
    {
      paramxde.a(new ErrorMessage(940001, "null point"), null, true);
      return;
    }
    Object localObject = this.a.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject).size() > 0))
    {
      List localList = b((List)localObject);
      paramxde.a(new ErrorMessage(), localList, this.a.jdField_a_of_type_Boolean);
      ykq.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject).size()));
      return;
    }
    localObject = new wtj();
    ((wtj)localObject).a = this.a.a();
    ((wtj)localObject).b = QQStoryContext.a().b();
    ykq.c("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "start request with cookie " + ((wtj)localObject).a);
    wfi.a().a((wfm)localObject, new xdq(this, paramxde));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdp
 * JD-Core Version:    0.7.0.1
 */