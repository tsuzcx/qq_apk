import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.ProfileFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class tkj
  extends tjg<ProfileFeedPlayInfo>
{
  public tkj(ProfileFeedPlayInfo paramProfileFeedPlayInfo)
  {
    super(paramProfileFeedPlayInfo);
    paramProfileFeedPlayInfo = (uje)sqg.a(11);
    if (paramProfileFeedPlayInfo.b != null) {
      this.a = paramProfileFeedPlayInfo.b;
    }
  }
  
  public uiw a(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      uiw localuiw = (uiw)localIterator.next();
      if (localuiw.a.equals(paramString)) {
        return localuiw;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, tjy paramtjy)
  {
    if (this.a == null)
    {
      paramtjy.a(new ErrorMessage(940001, "null point"), null, true);
      return;
    }
    Object localObject = this.a.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject).size() > 0))
    {
      List localList = b((List)localObject);
      paramtjy.a(new ErrorMessage(), localList, this.a.jdField_a_of_type_Boolean);
      urk.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject).size()));
      return;
    }
    localObject = new szx();
    ((szx)localObject).a = this.a.a();
    ((szx)localObject).b = QQStoryContext.a().b();
    urk.c("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "start request with cookie " + ((szx)localObject).a);
    slv.a().a((slz)localObject, new tkk(this, paramtjy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tkj
 * JD-Core Version:    0.7.0.1
 */