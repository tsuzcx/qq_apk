import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.ProfileFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class txc
  extends tvz<ProfileFeedPlayInfo>
{
  public txc(ProfileFeedPlayInfo paramProfileFeedPlayInfo)
  {
    super(paramProfileFeedPlayInfo);
    paramProfileFeedPlayInfo = (uvx)tcz.a(11);
    if (paramProfileFeedPlayInfo.b != null) {
      this.a = paramProfileFeedPlayInfo.b;
    }
  }
  
  public uvp a(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      uvp localuvp = (uvp)localIterator.next();
      if (localuvp.a.equals(paramString)) {
        return localuvp;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, twr paramtwr)
  {
    if (this.a == null)
    {
      paramtwr.a(new ErrorMessage(940001, "null point"), null, true);
      return;
    }
    Object localObject = this.a.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject).size() > 0))
    {
      List localList = b((List)localObject);
      paramtwr.a(new ErrorMessage(), localList, this.a.jdField_a_of_type_Boolean);
      ved.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject).size()));
      return;
    }
    localObject = new tmq();
    ((tmq)localObject).a = this.a.a();
    ((tmq)localObject).b = QQStoryContext.a().b();
    ved.c("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "start request with cookie " + ((tmq)localObject).a);
    syo.a().a((sys)localObject, new txd(this, paramtwr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txc
 * JD-Core Version:    0.7.0.1
 */