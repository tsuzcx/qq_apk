import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.ReportWatchVideoEntry;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class psq
  implements psj
{
  private AtomicBoolean aK = new AtomicBoolean(false);
  private AtomicInteger al = new AtomicInteger(0);
  private ConcurrentHashMap<Integer, pzu> bV = new ConcurrentHashMap();
  private final LinkedList<psq.a> z = new LinkedList();
  
  private void aBh()
  {
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    Object localObject = new ArrayList(this.z.size());
    ((ArrayList)localObject).addAll(this.z);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      psq.a locala = (psq.a)((Iterator)localObject).next();
      if (locala.mCreateTime < l - 86400000L)
      {
        this.z.remove(locala);
        localArrayList.add(locala);
      }
    }
    P(localArrayList);
  }
  
  private void bmC()
  {
    Object localObject = QQStoryContext.a().getEntityManagerFactory().createEntityManager().query(ReportWatchVideoEntry.class, ReportWatchVideoEntry.class.getSimpleName(), false, null, null, null, null, null, null);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ReportWatchVideoEntry localReportWatchVideoEntry = (ReportWatchVideoEntry)((Iterator)localObject).next();
        psq.a locala = new psq.a();
        locala.a(localReportWatchVideoEntry);
        this.z.add(locala);
      }
    }
  }
  
  private void bmD()
  {
    Object localObject = new ArrayList(pyf.PAGE_SIZE);
    int i = 0;
    while ((this.z.size() > 0) && (i < pyf.PAGE_SIZE))
    {
      ((ArrayList)localObject).add(this.z.removeFirst());
      i += 1;
    }
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = new pyf().a(this.al.incrementAndGet(), (ArrayList)localObject);
      this.bV.put(Integer.valueOf(((pzu)localObject).mSeq), localObject);
    }
  }
  
  public boolean P(List<psq.a> paramList)
  {
    EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    try
    {
      localEntityTransaction.begin();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        psq.a locala = (psq.a)paramList.next();
        ReportWatchVideoEntry localReportWatchVideoEntry = new ReportWatchVideoEntry();
        localReportWatchVideoEntry.setStatus(1001);
        localEntityManager.remove(localReportWatchVideoEntry, "vid=?", new String[] { locala.mVid });
      }
    }
    finally
    {
      localEntityTransaction.end();
    }
    localEntityTransaction.end();
    return false;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    a(new psq.a(paramString1, paramString2, paramBoolean1, paramLong, paramInt1, paramInt2), paramBoolean2);
  }
  
  public void a(psq.a parama, boolean paramBoolean)
  {
    synchronized (this.z)
    {
      if (!this.z.contains(parama))
      {
        this.z.add(parama);
        ram.w("Q.qqstory:ReportWatchVideoManager", String.format("saveWatchVid vid=%s, videoUid=%s, list size=%d", new Object[] { parama.mVid, parama.auQ, Integer.valueOf(this.z.size()) }));
      }
      if (paramBoolean) {
        QQStoryContext.a().getEntityManagerFactory().createEntityManager().persistOrReplace(parama.a());
      }
      return;
    }
  }
  
  public void a(@NonNull pzu parampzu)
  {
    try
    {
      ram.w("Q.qqstory:ReportWatchVideoManager", "handleResponse. requestHashMap.size()=" + this.bV.size());
      if (this.bV.size() > 0)
      {
        this.bV.remove(Integer.valueOf(parampzu.mSeq));
        if (this.bV.isEmpty())
        {
          parampzu = new psq.b();
          pmi.a().dispatch(parampzu);
        }
      }
      return;
    }
    finally
    {
      parampzu = finally;
      throw parampzu;
    }
  }
  
  public void bmB()
  {
    synchronized (this.z)
    {
      if (this.aK.compareAndSet(false, true))
      {
        bmC();
        ram.w("Q.qqstory:ReportWatchVideoManager", String.format("init. reportWatchVideoList.size=%d", new Object[] { Integer.valueOf(this.z.size()) }));
      }
      aBh();
      ram.w("Q.qqstory:ReportWatchVideoManager", String.format("startSendRequests. data size=%d", new Object[] { Integer.valueOf(this.z.size()) }));
      if (this.z.size() <= 0)
      {
        psq.b localb = new psq.b();
        pmi.a().dispatch(localb);
        return;
      }
      if (this.z.size() > 0) {
        bmD();
      }
    }
  }
  
  public void bme()
  {
    this.bV.clear();
  }
  
  public void onDestroy()
  {
    synchronized (this.z)
    {
      this.z.clear();
      this.bV.clear();
      return;
    }
  }
  
  public void onInit() {}
  
  public static class a
  {
    public boolean aBx;
    public String auQ;
    public int bkb;
    public long mCreateTime;
    public int mSource;
    public String mVid;
    
    public a() {}
    
    public a(String paramString1, String paramString2, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
    {
      this.mVid = paramString1;
      this.auQ = paramString2;
      this.aBx = paramBoolean;
      this.mCreateTime = paramLong;
      this.mSource = paramInt1;
      this.bkb = paramInt2;
    }
    
    public ReportWatchVideoEntry a()
    {
      ReportWatchVideoEntry localReportWatchVideoEntry = new ReportWatchVideoEntry();
      localReportWatchVideoEntry.vid = this.mVid;
      localReportWatchVideoEntry.videoUnionId = this.auQ;
      localReportWatchVideoEntry.isLiveVideo = this.aBx;
      localReportWatchVideoEntry.createTime = this.mCreateTime;
      localReportWatchVideoEntry.source = this.mSource;
      localReportWatchVideoEntry.vidType = this.bkb;
      return localReportWatchVideoEntry;
    }
    
    public void a(ReportWatchVideoEntry paramReportWatchVideoEntry)
    {
      this.mVid = paramReportWatchVideoEntry.vid;
      this.auQ = paramReportWatchVideoEntry.videoUnionId;
      this.aBx = paramReportWatchVideoEntry.isLiveVideo;
      this.mCreateTime = paramReportWatchVideoEntry.createTime;
      this.mSource = paramReportWatchVideoEntry.source;
      this.bkb = paramReportWatchVideoEntry.vidType;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (a)paramObject;
      return this.mVid.equals(paramObject.mVid);
    }
    
    public String toString()
    {
      return "InnerVideoItem { mVid=" + this.mVid + " mVideoUid=" + this.auQ + " mIsLiveVideo=" + this.aBx + " mCreateTime=" + this.mCreateTime + " mSource=" + this.mSource + " mVidType=" + this.bkb + "}";
    }
  }
  
  public static class b
    extends plt
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     psq
 * JD-Core Version:    0.7.0.1
 */