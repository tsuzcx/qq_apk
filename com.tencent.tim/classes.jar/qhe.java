import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.ProfileFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class qhe
  extends qgr<ProfileFeedPlayInfo>
{
  public qhe(ProfileFeedPlayInfo paramProfileFeedPlayInfo)
  {
    super(paramProfileFeedPlayInfo);
    paramProfileFeedPlayInfo = (qvf)psx.a(11);
    if (paramProfileFeedPlayInfo.d != null) {
      this.a = paramProfileFeedPlayInfo.d;
    }
  }
  
  public qvd a(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    Iterator localIterator = this.a.nk.iterator();
    while (localIterator.hasNext())
    {
      qvd localqvd = (qvd)localIterator.next();
      if (localqvd.mFeedId.equals(paramString)) {
        return localqvd;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, qgz.b paramb)
  {
    if (this.a == null)
    {
      paramb.a(new ErrorMessage(940001, "null point"), null, true);
      return;
    }
    Object localObject = this.a.nk;
    if ((paramBoolean) && (((List)localObject).size() > 0))
    {
      List localList = aq((List)localObject);
      paramb.a(new ErrorMessage(), localList, this.a.mIsEnd);
      ram.b("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject).size()));
      return;
    }
    localObject = new pza();
    ((pza)localObject).cookie = this.a.mP();
    ((pza)localObject).unionId = QQStoryContext.a().getCurrentUid();
    ram.i("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "start request with cookie " + ((pza)localObject).cookie);
    ppv.a().a((ppw)localObject, new qhf(this, paramb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qhe
 * JD-Core Version:    0.7.0.1
 */