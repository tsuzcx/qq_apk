import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.a;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class pxg
  extends pxf
  implements ppv.b<pyq, qad>
{
  protected long AA;
  protected pxg.a a;
  protected String avJ = "";
  protected final String avK;
  protected String mContext;
  protected String mUin;
  
  public pxg(String paramString1, String paramString2)
  {
    this.mUin = paramString1;
    this.mContext = paramString2;
    this.avK = fT(this.mUin);
  }
  
  public static String fT(String paramString)
  {
    return paramString;
  }
  
  private void sendRequest()
  {
    int i = rpq.tP();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    long l;
    if (this.a.blg != i)
    {
      ram.w("Q.qqstory.net:DateCollectionListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.a.blg), Integer.valueOf(i) });
      localObject = (psn)psx.a(19);
      localMemoryInfoEntry = ((psn)localObject).a(this.avK);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.avK);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.a.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!fj(this.avJ)) {
        break label264;
      }
      l = this.a.mSeq;
      label125:
      this.AA = l;
      localObject = new pyq();
      ((pyq)localObject).blq = 10;
      ((pyq)localObject).blr = 10;
      ((pyq)localObject).avV = this.avJ;
      ((pyq)localObject).seq = l;
      ((pyq)localObject).blp = this.a.blg;
      ((pyq)localObject).uin = this.mUin;
      localMemoryInfoEntry = ((psn)psx.a(19)).a(this.avK);
      if (localMemoryInfoEntry != null) {
        if (localMemoryInfoEntry.isFriend != 1) {
          break label269;
        }
      }
    }
    label264:
    label269:
    for (boolean bool = true;; bool = false)
    {
      ((pyq)localObject).isFriend = bool;
      ppv.a().a((ppw)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((psn)localObject).a(localMemoryInfoEntry);
      break;
      l = 0L;
      break label125;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new pxh(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
  
  public void a(@NonNull pyq parampyq, @Nullable qad paramqad, @NonNull ErrorMessage paramErrorMessage)
  {
    if (parampyq.seq != this.AA)
    {
      ram.b("Q.qqstory.net:DateCollectionListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(parampyq.seq), Long.valueOf(this.AA));
      return;
    }
    psn localpsn = (psn)psx.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localpsn.a(this.avK);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.avK);
    }
    for (;;)
    {
      boolean bool2 = fj(parampyq.avV);
      pxg.b localb = new pxg.b(this.mContext, paramErrorMessage);
      localb.uin = parampyq.uin;
      localb.isFirstPage = bool2;
      localb.aCu = false;
      if ((paramqad == null) || ((paramErrorMessage.isFail()) && (paramErrorMessage.errorCode != 11111)))
      {
        pmi.a().dispatch(localb);
        return;
      }
      int i;
      boolean bool1;
      label231:
      Object localObject1;
      label293:
      label312:
      long l;
      Object localObject2;
      if ((localMemoryInfoEntry.isFriend != -1) && (localMemoryInfoEntry.isFriend != paramqad.blD))
      {
        i = 1;
        localMemoryInfoEntry.isFriend = paramqad.blD;
        localb.isEnd = paramqad.isEnd;
        localb.mL = paramqad.mT;
        localb.blh = paramqad.aEs;
        if ((paramqad.seq == parampyq.seq) && (i == 0)) {
          break label489;
        }
        bool1 = true;
        localb.isUpdated = bool1;
        if (!localb.isUpdated) {
          break label526;
        }
        localObject1 = paramqad.mT;
        if (localObject1 != null)
        {
          Collections.sort((List)localObject1, new VideoCollectionItem.a());
          localpsn.c((List)localObject1, parampyq.uin, bool2);
        }
        if (i == 0) {
          break label495;
        }
        localMemoryInfoEntry.seq = 0L;
        localMemoryInfoEntry.cookie = paramqad.nextCookie;
        if (!paramqad.isEnd) {
          break label507;
        }
        i = 1;
        localMemoryInfoEntry.isEnd = i;
        l = this.a.mSeq;
        localObject2 = this.a.mCookie;
        if (!paramqad.isEnd) {
          break label513;
        }
      }
      label513:
      for (parampyq = "true";; parampyq = "false")
      {
        ram.a("Q.qqstory.net:DateCollectionListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s", Long.valueOf(l), localObject2, parampyq);
        parampyq = (qvf)psx.a(11);
        if (localObject1 == null) {
          break label526;
        }
        paramqad = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VideoCollectionItem)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(((VideoCollectionItem)localObject2).feedId))
          {
            FeedItem localFeedItem = parampyq.a(((VideoCollectionItem)localObject2).feedId);
            if (localFeedItem != null)
            {
              if ((localFeedItem instanceof VideoListFeedItem)) {
                ((VideoListFeedItem)localFeedItem).mViewTotalTime = ((VideoCollectionItem)localObject2).viewTimes;
              }
              paramqad.add(localFeedItem);
            }
          }
        }
        i = 0;
        break;
        label489:
        bool1 = false;
        break label231;
        label495:
        localMemoryInfoEntry.seq = paramqad.seq;
        break label293;
        label507:
        i = 0;
        break label312;
      }
      parampyq.au(paramqad);
      label526:
      if (paramErrorMessage.errorCode == 11111) {
        localMemoryInfoEntry.seq = 0L;
      }
      parampyq = localpsn.a(localMemoryInfoEntry);
      this.a.a(parampyq);
      this.avJ = this.a.mCookie;
      pmi.a().dispatch(localb);
      return;
    }
  }
  
  public void aPh()
  {
    super.aPh();
    Bosses.get().postJob(new pxi(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
  
  protected boolean fj(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (paramString.equals("0"));
  }
  
  public class a
  {
    public int blg;
    public String mCookie = "";
    public long mSeq;
    
    public a(String paramString)
    {
      this$1 = ((psn)psx.a(19)).a(paramString);
      if (pxg.this != null) {
        a(pxg.this);
      }
    }
    
    public void a(@NonNull MemoryInfoEntry paramMemoryInfoEntry)
    {
      this.mSeq = paramMemoryInfoEntry.seq;
      this.mCookie = paramMemoryInfoEntry.cookie;
      this.blg = paramMemoryInfoEntry.timeZone;
    }
  }
  
  public static class b
    extends pxc
  {
    public int blh = -1;
    public String context;
    public boolean isUpdated = true;
    public List<VideoCollectionItem> mL = new ArrayList();
    public String uin;
    
    public b(String paramString, ErrorMessage paramErrorMessage)
    {
      super();
      this.context = paramString;
    }
    
    public String toString()
    {
      return "GetCollectionListEvent{isEnd=" + this.isEnd + ", isUpdated=" + this.isUpdated + ", isLocalData=" + this.aCu + ", isFirstPage=" + this.isFirstPage + ", isRefreshFromLoadMore=" + this.aCv + ", collectionList=" + this.mL + ", totalVideoCount=" + this.blh + ", context='" + this.context + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxg
 * JD-Core Version:    0.7.0.1
 */