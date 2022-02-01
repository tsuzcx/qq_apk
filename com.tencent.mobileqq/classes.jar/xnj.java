import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.ProfileFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class xnj
  extends xmg<ProfileFeedPlayInfo>
{
  public xnj(ProfileFeedPlayInfo paramProfileFeedPlayInfo)
  {
    super(paramProfileFeedPlayInfo);
    paramProfileFeedPlayInfo = (yme)wth.a(11);
    if (paramProfileFeedPlayInfo.b != null) {
      this.a = paramProfileFeedPlayInfo.b;
    }
  }
  
  public ylw a(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ylw localylw = (ylw)localIterator.next();
      if (localylw.a.equals(paramString)) {
        return localylw;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, xmy paramxmy)
  {
    if (this.a == null)
    {
      paramxmy.a(new ErrorMessage(940001, "null point"), null, true);
      return;
    }
    Object localObject = this.a.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject).size() > 0))
    {
      List localList = b((List)localObject);
      paramxmy.a(new ErrorMessage(), localList, this.a.jdField_a_of_type_Boolean);
      yuk.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject).size()));
      return;
    }
    localObject = new xcy();
    ((xcy)localObject).a = this.a.a();
    ((xcy)localObject).b = QQStoryContext.a().b();
    yuk.c("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "start request with cookie " + ((xcy)localObject).a);
    wow.a().a((wpa)localObject, new xnk(this, paramxmy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnj
 * JD-Core Version:    0.7.0.1
 */