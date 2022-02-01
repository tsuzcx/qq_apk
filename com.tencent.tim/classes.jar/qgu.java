import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class qgu
  extends qgr<HomeFeedPlayInfo>
{
  public qve.b a = new qve.b();
  private int bmm;
  
  public qgu(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    super(paramHomeFeedPlayInfo);
    paramHomeFeedPlayInfo = (qvf)psx.a(11);
    if (paramHomeFeedPlayInfo.d != null) {
      this.a = paramHomeFeedPlayInfo.d;
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
    Object localObject1 = this.a.nk;
    if ((paramBoolean) && (((List)localObject1).size() > 0))
    {
      localObject2 = aq((List)localObject1);
      paramb.a(new ErrorMessage(), (List)localObject2, this.a.mIsEnd);
      ram.b("Q.qqstory.player.data.HomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject1).size()));
      return;
    }
    localObject1 = (qvf)psx.a(11);
    Object localObject2 = new pzh();
    ((pzh)localObject2).b = ((qvf)localObject1).c;
    ((pzh)localObject2).cookie = this.a.mP();
    ram.b("Q.qqstory.player.data.HomeFeedPlayPageLoader", "start request next feed id list with cookie %s", ((pzh)localObject2).cookie);
    this.bmm = 0;
    ppv.a().a((ppw)localObject2, new qgv(this, paramb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qgu
 * JD-Core Version:    0.7.0.1
 */