import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.a;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;

public class qpu
  extends pxf
  implements ppv.b<pzc, qal>
{
  protected long AA;
  protected qpu.a a;
  protected String avJ = "";
  protected final String avK;
  protected final String axY;
  protected final String mContext;
  protected int mDataType;
  
  public qpu(String paramString1, int paramInt, String paramString2)
  {
    this.axY = paramString1;
    this.mDataType = paramInt;
    this.mContext = paramString2;
    this.avK = paramString1;
  }
  
  private void sendRequest()
  {
    int i = rpq.tP();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    if (this.a.blg != i)
    {
      ram.w("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.a.blg), Integer.valueOf(i) });
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
        break label232;
      }
    }
    label232:
    for (long l = this.a.mSeq;; l = 0L)
    {
      this.AA = l;
      localObject = new pzc();
      ((pzc)localObject).aaK = 10;
      ((pzc)localObject).blv = 10;
      ((pzc)localObject).avV = this.avJ;
      ((pzc)localObject).seq = l;
      ((pzc)localObject).blp = this.a.blg;
      ((pzc)localObject).groupId = this.axY;
      ((pzc)localObject).dateType = this.mDataType;
      ppv.a().a((ppw)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((psn)localObject).a(localMemoryInfoEntry);
      break;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new qpv(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
  
  public void a(@NonNull pzc parampzc, @Nullable qal paramqal, @NonNull ErrorMessage paramErrorMessage)
  {
    int i = 1;
    if (parampzc.seq != this.AA)
    {
      ram.b("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(parampzc.seq), Long.valueOf(this.AA));
      return;
    }
    psn localpsn = (psn)psx.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localpsn.a(this.avK);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.avK);
    }
    for (;;)
    {
      boolean bool2 = fj(parampzc.avV);
      paramErrorMessage = new pxg.b(this.mContext, paramErrorMessage);
      paramErrorMessage.isFirstPage = bool2;
      paramErrorMessage.aCu = false;
      if (paramqal == null)
      {
        pmi.a().dispatch(paramErrorMessage);
        return;
      }
      paramErrorMessage.isEnd = paramqal.isEnd;
      paramErrorMessage.blh = -9527;
      paramErrorMessage.mL = paramqal.mT;
      boolean bool1;
      ArrayList localArrayList;
      label236:
      long l;
      String str;
      if (paramqal.seq != parampzc.seq)
      {
        bool1 = true;
        paramErrorMessage.isUpdated = bool1;
        if (paramErrorMessage.isUpdated)
        {
          localArrayList = paramqal.mT;
          if (localArrayList != null)
          {
            Collections.sort(localArrayList, new VideoCollectionItem.a());
            localpsn.c(localArrayList, parampzc.groupId, bool2);
          }
          localMemoryInfoEntry.seq = paramqal.seq;
          localMemoryInfoEntry.cookie = paramqal.nextCookie;
          if (!paramqal.isEnd) {
            break label331;
          }
          localMemoryInfoEntry.isEnd = i;
          l = this.a.mSeq;
          str = this.a.mCookie;
          if (!paramqal.isEnd) {
            break label337;
          }
        }
      }
      label331:
      label337:
      for (parampzc = "true";; parampzc = "false")
      {
        ram.a("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s , %s", Long.valueOf(l), str, parampzc, localArrayList);
        parampzc = localpsn.a(localMemoryInfoEntry);
        this.a.a(parampzc);
        this.avJ = this.a.mCookie;
        pmi.a().dispatch(paramErrorMessage);
        return;
        bool1 = false;
        break;
        i = 0;
        break label236;
      }
    }
  }
  
  public void aPh()
  {
    super.aPh();
    Bosses.get().postJob(new qpw(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
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
      if (qpu.this != null) {
        a(qpu.this);
      }
    }
    
    public void a(@NonNull MemoryInfoEntry paramMemoryInfoEntry)
    {
      this.mSeq = paramMemoryInfoEntry.seq;
      this.mCookie = paramMemoryInfoEntry.cookie;
      this.blg = paramMemoryInfoEntry.timeZone;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qpu
 * JD-Core Version:    0.7.0.1
 */