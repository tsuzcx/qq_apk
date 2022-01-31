import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.ProfileFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class txf
  extends twc<ProfileFeedPlayInfo>
{
  public txf(ProfileFeedPlayInfo paramProfileFeedPlayInfo)
  {
    super(paramProfileFeedPlayInfo);
    paramProfileFeedPlayInfo = (uwa)tdc.a(11);
    if (paramProfileFeedPlayInfo.b != null) {
      this.a = paramProfileFeedPlayInfo.b;
    }
  }
  
  public uvs a(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      uvs localuvs = (uvs)localIterator.next();
      if (localuvs.a.equals(paramString)) {
        return localuvs;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, twu paramtwu)
  {
    if (this.a == null)
    {
      paramtwu.a(new ErrorMessage(940001, "null point"), null, true);
      return;
    }
    Object localObject = this.a.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject).size() > 0))
    {
      List localList = b((List)localObject);
      paramtwu.a(new ErrorMessage(), localList, this.a.jdField_a_of_type_Boolean);
      veg.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject).size()));
      return;
    }
    localObject = new tmt();
    ((tmt)localObject).a = this.a.a();
    ((tmt)localObject).b = QQStoryContext.a().b();
    veg.c("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "start request with cookie " + ((tmt)localObject).a);
    syr.a().a((syv)localObject, new txg(this, paramtwu));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txf
 * JD-Core Version:    0.7.0.1
 */