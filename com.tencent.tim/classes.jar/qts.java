import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class qts
  implements IEventReceiver
{
  protected pxf a;
  protected qts.a a;
  protected boolean aFu;
  protected Set<String> aN = new HashSet();
  protected Map<String, pxd> fZ = new HashMap();
  protected String mContext;
  protected boolean mIsStart;
  protected String mUin;
  
  public qts(String paramString1, String paramString2)
  {
    this.mUin = paramString1;
    this.mContext = paramString2;
  }
  
  public void L(List<VideoCollectionItem> paramList, boolean paramBoolean)
  {
    if (!QQStoryContext.a().eU(this.mUin)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)paramList.next();
      if ((localVideoCollectionItem.collectionType == 1) && ((this.aN.add(localVideoCollectionItem.key)) || (paramBoolean))) {
        localArrayList.add(localVideoCollectionItem.key);
      }
    }
    eB(localArrayList);
  }
  
  public void M(List<String> paramList, boolean paramBoolean)
  {
    if (!QQStoryContext.a().eU(this.mUin)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((VideoCollectionEntry.getCollectionType(str) == 1) && ((this.aN.add(str)) || (paramBoolean))) {
        localArrayList.add(str);
      }
    }
    eB(localArrayList);
  }
  
  protected pxe a(String paramString, List<String> paramList)
  {
    return new pye(paramString, paramList);
  }
  
  protected pxf a()
  {
    return new pxg(this.mUin, this.mContext);
  }
  
  public pxg.b a()
  {
    this.aFu = false;
    long l = System.currentTimeMillis();
    Object localObject = (psn)psx.a(19);
    MemoryInfoEntry localMemoryInfoEntry = ((psn)localObject).a(pxg.fT(this.mUin));
    boolean bool;
    pxg.b localb;
    if ((localMemoryInfoEntry != null) && (localMemoryInfoEntry.isEnd == 1))
    {
      bool = true;
      List localList = ((psn)localObject).a(this.mUin, null, 10L);
      localb = new pxg.b(this.mContext, new ErrorMessage());
      localb.uin = this.mUin;
      localb.aCu = true;
      localb.isFirstPage = true;
      localb.isUpdated = true;
      localb.isEnd = false;
      localb.mL = localList;
      if (localList.size() <= 0) {
        break label225;
      }
      localObject = (VideoCollectionItem)localList.get(localList.size() - 1);
      label155:
      if (localObject != null) {
        break label231;
      }
      localb.isEnd = true;
      this.aFu = true;
      label171:
      L(localList, false);
      if (!localb.isEnd) {
        break label273;
      }
    }
    label273:
    for (localObject = "true";; localObject = "false")
    {
      ram.w("Q.qqstory.memories:MemoryDataPuller", "Req first page local data ,isEnd = %s ,spend time = %d", new Object[] { localObject, Long.valueOf(System.currentTimeMillis() - l) });
      return localb;
      bool = false;
      break;
      label225:
      localObject = null;
      break label155;
      label231:
      if ((localMemoryInfoEntry != null) && (((VideoCollectionItem)localObject).dbIndex >= localMemoryInfoEntry.maxCollectionIndex))
      {
        localb.isEnd = bool;
        this.aFu = true;
        break label171;
      }
      localb.isEnd = false;
      break label171;
    }
  }
  
  public void bqE()
  {
    this.aFu = false;
    Bosses.get().postJob(new qtt(this, "Q.qqstory.memories:MemoryDataPuller"));
  }
  
  public void bqF()
  {
    this.aFu = false;
    this.jdField_a_of_type_Pxf.a(null, 0);
  }
  
  public void c(VideoCollectionItem paramVideoCollectionItem)
  {
    Bosses.get().postJob(new qtu(this, "Q.qqstory.memories:MemoryDataPuller", paramVideoCollectionItem));
  }
  
  protected void eB(List<String> paramList)
  {
    int i = 0;
    if (paramList.size() == 0) {}
    label185:
    for (;;)
    {
      return;
      ram.w("Q.qqstory.memories:MemoryDataPuller", "start update view count : %s", new Object[] { paramList });
      for (;;)
      {
        if (i >= paramList.size()) {
          break label185;
        }
        int j = Math.min(paramList.size(), i + 20);
        if (i >= j) {
          break;
        }
        Object localObject = paramList.subList(i, j);
        pyb localpyb = new pyb(this.mUin);
        ArrayList localArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          pyb.a locala = new pyb.a();
          locala.bln = VideoCollectionEntry.getCollectionId(str);
          locala.collectionType = VideoCollectionEntry.getCollectionType(str);
          if (locala.bln != -1) {
            localArrayList.add(locala);
          }
        }
        localpyb.ek(localArrayList);
        localpyb.sendRequest();
        i = j;
      }
    }
  }
  
  public boolean isValidate()
  {
    return this.mIsStart;
  }
  
  public void onStart()
  {
    this.mIsStart = true;
    this.jdField_a_of_type_Pxf = a();
    this.jdField_a_of_type_Qts$a = new qts.a(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qts$a);
  }
  
  public void onStop()
  {
    this.mIsStart = false;
    if (this.jdField_a_of_type_Qts$a != null)
    {
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qts$a);
      this.jdField_a_of_type_Qts$a = null;
    }
    this.fZ.clear();
  }
  
  public void rZ(String paramString)
  {
    pxd localpxd = (pxd)this.fZ.get(paramString);
    if (localpxd == null) {
      ram.w("Q.qqstory.memories:MemoryDataPuller", String.format("cannot fount pageLoader , which collectionId is %s", new Object[] { paramString }));
    }
    while ((localpxd.Jo()) || (localpxd.isBusy())) {
      return;
    }
    localpxd.run();
  }
  
  public void sa(String paramString)
  {
    Bosses.get().postJob(new qtv(this, "Q.qqstory.memories:MemoryDataPuller", paramString));
  }
  
  static class a
    extends QQUIEventReceiver<qts, pxg.b>
  {
    public a(qts paramqts)
    {
      super();
    }
    
    public void a(qts paramqts, pxg.b paramb)
    {
      if (!TextUtils.equals(paramb.context, paramqts.mContext)) {}
      do
      {
        do
        {
          return;
          paramqts.sa(paramqts.mUin);
        } while ((paramb.b.isFail()) || (!paramb.isUpdated));
        if (paramb.isFirstPage) {
          paramqts.fZ.clear();
        }
        paramb = paramb.mL;
      } while (paramb == null);
      paramb = paramb.iterator();
      label72:
      VideoCollectionItem localVideoCollectionItem;
      Object localObject1;
      ArrayList localArrayList;
      Object localObject2;
      if (paramb.hasNext())
      {
        localVideoCollectionItem = (VideoCollectionItem)paramb.next();
        localObject1 = new ArrayList();
        localArrayList = new ArrayList(localVideoCollectionItem.videoVidList);
        localObject2 = new ArrayList();
        Iterator localIterator = localVideoCollectionItem.videoItemList.iterator();
        while (localIterator.hasNext()) {
          ((ArrayList)localObject2).add(((StoryVideoItem)localIterator.next()).mVid);
        }
        localArrayList.removeAll((Collection)localObject2);
      }
      int j;
      for (int i = 0;; i = j)
      {
        if (i < localArrayList.size())
        {
          j = Math.min(localArrayList.size(), i + 20);
          if (i < j) {}
        }
        else
        {
          localObject1 = new pxd((List)localObject1);
          ((pxd)localObject1).setTag("Q.qqstory.memories:MemoryDataPuller");
          paramqts.fZ.put(localVideoCollectionItem.collectionId, localObject1);
          break label72;
          break;
        }
        localObject2 = localArrayList.subList(i, j);
        ((List)localObject1).add(paramqts.a(localVideoCollectionItem.collectionId, (List)localObject2));
      }
    }
    
    public Class acceptEventClass()
    {
      return pxg.b.class;
    }
  }
  
  public static class b
    extends plt
  {
    public String mContext;
    public boolean mIsEnd;
    public ArrayList<String> ni;
    public List<String> ok = new ArrayList();
    
    public b(String paramString)
    {
      this.mContext = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qts
 * JD-Core Version:    0.7.0.1
 */