import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class qhc
  extends qgz.a
{
  private final MsgTabPlayInfo a;
  private final List<puh> nG;
  
  public qhc(MsgTabPlayInfo paramMsgTabPlayInfo)
  {
    this.a = paramMsgTabPlayInfo;
    puy localpuy = (puy)qem.getQQAppInterface().getManager(251);
    this.nG = new ArrayList();
    if (paramMsgTabPlayInfo.source == 0) {
      pvs.a(localpuy.a().br(), this.nG, paramMsgTabPlayInfo.nodeUnionId);
    }
  }
  
  public static qej a(List<qej> paramList)
  {
    Object localObject1 = null;
    Object localObject2 = localObject1;
    int i;
    if (paramList != null)
    {
      localObject2 = localObject1;
      if (paramList.size() > 0)
      {
        int j = paramList.size();
        i = 0;
        localObject1 = null;
        if (i >= j) {
          break label100;
        }
        localObject2 = (qej)paramList.get(i);
        if (!((qej)localObject2).isLocal) {
          break label60;
        }
      }
    }
    return localObject2;
    label60:
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      i += 1;
      break;
      if ((localObject1.aBR) && (!((qej)localObject2).aBR))
      {
        return (qej)paramList.get(i);
        label100:
        return localObject1;
      }
    }
  }
  
  public void a(int paramInt, qgz.b paramb)
  {
    Object localObject;
    if (this.a.source == 1)
    {
      localObject = ((pmj)qem.getQQAppInterface().getManager(197)).a(this.a.uin);
      if (localObject == null) {
        break label112;
      }
      ((puh)localObject).source = this.a.source;
      this.nG.add(localObject);
    }
    for (;;)
    {
      localObject = new ArrayList();
      Iterator localIterator = this.nG.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(qhc.a.a((puh)localIterator.next()));
      }
      label112:
      ram.w("Q.qqstory.player.data.MsgTabPlayPageLoader", "no data for header group");
    }
    paramb.a(new ErrorMessage(), (List)localObject, true);
  }
  
  public boolean a(qgy.d paramd)
  {
    if ((paramd == null) || (!paramd.JB()))
    {
      ram.i("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. need sync");
      return true;
    }
    rom.assertTrue(paramd.d instanceof qhc.a);
    qhc.a locala = (qhc.a)paramd.d;
    if (locala.mIsEnd)
    {
      ram.b("Q.qqstory.player.data.MsgTabPlayPageLoader", "won't needSyncVidList. groupId %s is end", locala.getUnionId());
      return false;
    }
    int i = locala.bmq;
    if (paramd.bmp != i) {
      ram.a("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList() groupId %s, position not match: %d != %d", locala.getUnionId(), Integer.valueOf(paramd.bmp), Integer.valueOf(i));
    }
    if ((i < 0) || (paramd.nv.size() - i < 10))
    {
      ram.b("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. need sync postion=%d, vidlist.size=%d, group=%s", Integer.valueOf(i), Integer.valueOf(paramd.nv.size()), paramd);
      return true;
    }
    ram.b("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. not need sync postion=%d, vidlist.size=%d, group=%s", Integer.valueOf(i), Integer.valueOf(paramd.nv.size()), paramd);
    return false;
  }
  
  public List<qgz.c> ap(List<qgy.c> paramList)
  {
    ArrayList localArrayList = new ArrayList(1);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new qhc.b((qhc.a)paramList.next()));
    }
    return localArrayList;
  }
  
  public qgy.f b()
  {
    Object localObject = new qhc.a(this.a.nodeUnionId);
    ((qhc.a)localObject).g = ((puy)QQStoryContext.a().getManager(251)).d(this.a.nodeUnionId);
    qgy.f localf = new qgy.f((qgy.c)localObject, this.a.mStartVid, this.a.mStartVideoFeedId);
    if ((this.a.mVids != null) && (!this.a.mVids.isEmpty()) && (this.a.mFeedIdMap != null) && (!this.a.mFeedIdMap.isEmpty()))
    {
      localObject = new qgy.d((qgy.c)localObject);
      ((qgy.d)localObject).nv = this.a.mVids;
      ((qgy.d)localObject).fR = this.a.mFeedIdMap;
      localf.a = ((qgy.d)localObject);
    }
    return localf;
  }
  
  public void create() {}
  
  public void destroy() {}
  
  public static class a
    extends qgy.c
  {
    public int bmq;
    public puh g;
    public String mCookie = "";
    public boolean mIsEnd;
    public String mStartVid = "";
    
    public a(String paramString)
    {
      super();
    }
    
    static a a(puh parampuh)
    {
      a locala = new a(parampuh.unionId);
      locala.g = parampuh;
      if (parampuh.nodeType == 12)
      {
        locala.mStartVid = parampuh.nodeVid;
        locala.mCookie = parampuh.ava;
      }
      return locala;
    }
    
    public boolean JC()
    {
      return (this.g != null) && (this.g.nodeType == 12);
    }
    
    public String getUnionId()
    {
      if (this.g != null) {
        return this.g.unionId;
      }
      return this.groupId;
    }
  }
  
  public static class b
    implements qgz.c
  {
    private final qhc.a b;
    
    public b(qhc.a parama)
    {
      this.b = parama;
    }
    
    public void a(qgz.c.a parama)
    {
      Stream localStream2 = Stream.of(this.b.g).map(new ThreadOffFunction("Q.qqstory.player.data.MsgTabPlayPageLoader", 2)).map(new puv("Q.qqstory.player.data.MsgTabPlayPageLoader", this.b.mCookie, this.b.mStartVid, this.b));
      Stream localStream1 = localStream2;
      if (this.b.g.nodeType == 5) {
        localStream1 = localStream2.map(new pus()).map(new puk(this.b.g));
      }
      localStream1.subscribe(new qhd(this, parama));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qhc
 * JD-Core Version:    0.7.0.1
 */