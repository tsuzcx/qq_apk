import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class qhg
  extends qgz.a
{
  private ShareFromMemoryPlayInfo b;
  private qgy.c d;
  private String mCookie = "";
  
  public qhg(ShareFromMemoryPlayInfo paramShareFromMemoryPlayInfo)
  {
    this.b = paramShareFromMemoryPlayInfo;
    this.d = new qgy.c(this.b.feedId);
  }
  
  public void a(int paramInt, qgz.b paramb)
  {
    paramb.a(new ErrorMessage(), Collections.singletonList(this.d), true);
  }
  
  public List<qgz.c> ap(List<qgy.c> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new qhg.a((qgy.c)paramList.next()));
    }
    return localArrayList;
  }
  
  public qgy.f b()
  {
    if (this.b.videoListOrder == 0)
    {
      localObject = ((qvi)psx.a(12)).a(this.b.feedId, 1);
      if ((localObject == null) || (((FeedVideoInfo)localObject).mVideoItemList.size() <= 0)) {}
    }
    for (Object localObject = ((StoryVideoItem)((FeedVideoInfo)localObject).mVideoItemList.get(0)).mVid;; localObject = null)
    {
      ram.w("Q.qqstory.player.data.ShareFromMemoryPlayPageLoader", "getStartInfo GroupId=" + this.d + ",vid=" + (String)localObject + ",feedId=" + this.b.feedId);
      return new qgy.f(this.d, (String)localObject, this.b.feedId);
    }
  }
  
  public void create() {}
  
  public void destroy() {}
  
  class a
    implements qgz.c
  {
    qgy.c d;
    private int mRequestCount;
    private List<String> mVidList = new ArrayList();
    
    public a(qgy.c paramc)
    {
      this.d = paramc;
    }
    
    protected void a(String paramString, qgz.c.a parama)
    {
      pyp localpyp = new pyp();
      localpyp.avU = qhg.a(qhg.this).uid;
      if (qhg.a(qhg.this).collectionKey != null) {
        localpyp.bln = VideoCollectionEntry.getCollectionId(qhg.a(qhg.this).collectionKey);
      }
      localpyp.avV = paramString;
      localpyp.count = 20;
      localpyp.blp = qhg.a(qhg.this).shareTimeZone;
      localpyp.feedId = qhg.a(qhg.this).feedId;
      localpyp.identify = qhg.a(qhg.this).identify;
      localpyp.videoListOrder = qhg.a(qhg.this).videoListOrder;
      ppv.a().a(localpyp, new qhh(this, parama));
    }
    
    public void a(qgz.c.a parama)
    {
      this.mVidList.clear();
      a(qhg.a(qhg.this), parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qhg
 * JD-Core Version:    0.7.0.1
 */