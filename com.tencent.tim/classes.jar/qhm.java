import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.TroopAssistantHomeFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class qhm
  extends qgr<TroopAssistantHomeFeedPlayInfo>
{
  public qhm(TroopAssistantHomeFeedPlayInfo paramTroopAssistantHomeFeedPlayInfo)
  {
    super(paramTroopAssistantHomeFeedPlayInfo);
    paramTroopAssistantHomeFeedPlayInfo = (qvf)psx.a(11);
    if (paramTroopAssistantHomeFeedPlayInfo.d != null) {
      this.a = paramTroopAssistantHomeFeedPlayInfo.d;
    }
  }
  
  public qvd a(String paramString)
  {
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
    Object localObject = this.a.nk;
    if ((paramBoolean) && (((List)localObject).size() > 0))
    {
      List localList = aq((List)localObject);
      paramb.a(new ErrorMessage(), localList, this.a.mIsEnd);
      ram.b("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject).size()));
      return;
    }
    localObject = new pzk();
    ((pzk)localObject).cookie = this.a.mP();
    ram.b("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "start request next feed id list with cookie %s", ((pzk)localObject).cookie);
    ppv.a().a((ppw)localObject, new qhn(this, paramb));
  }
  
  public void create() {}
  
  public void destroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qhm
 * JD-Core Version:    0.7.0.1
 */