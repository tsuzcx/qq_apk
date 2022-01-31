import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.ProfileFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class vlu
  extends vkr<ProfileFeedPlayInfo>
{
  public vlu(ProfileFeedPlayInfo paramProfileFeedPlayInfo)
  {
    super(paramProfileFeedPlayInfo);
    paramProfileFeedPlayInfo = (wkp)urr.a(11);
    if (paramProfileFeedPlayInfo.b != null) {
      this.a = paramProfileFeedPlayInfo.b;
    }
  }
  
  public wkh a(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      wkh localwkh = (wkh)localIterator.next();
      if (localwkh.a.equals(paramString)) {
        return localwkh;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, vlj paramvlj)
  {
    if (this.a == null)
    {
      paramvlj.a(new ErrorMessage(940001, "null point"), null, true);
      return;
    }
    Object localObject = this.a.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject).size() > 0))
    {
      List localList = b((List)localObject);
      paramvlj.a(new ErrorMessage(), localList, this.a.jdField_a_of_type_Boolean);
      wsv.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject).size()));
      return;
    }
    localObject = new vbi();
    ((vbi)localObject).a = this.a.a();
    ((vbi)localObject).b = QQStoryContext.a().b();
    wsv.c("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "start request with cookie " + ((vbi)localObject).a);
    ung.a().a((unk)localObject, new vlv(this, paramvlj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vlu
 * JD-Core Version:    0.7.0.1
 */