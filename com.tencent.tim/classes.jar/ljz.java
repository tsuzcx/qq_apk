import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class ljz
{
  private volatile ljz.a b;
  private ExecutorService mExecutorService;
  
  public ljz(ExecutorService paramExecutorService)
  {
    this.mExecutorService = paramExecutorService;
  }
  
  public static ljz b()
  {
    Object localObject = (QQAppInterface)kxm.getAppRuntime();
    if (localObject != null)
    {
      localObject = ((lcd)((QQAppInterface)localObject).getManager(163)).b();
      if (localObject != null) {
        return ((lbz)localObject).a();
      }
    }
    return null;
  }
  
  private boolean d(List<Long> paramList1, List<Long> paramList2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramList1 == null) || (paramList2 == null)) {
      if (paramList1 == paramList2) {
        bool1 = true;
      }
    }
    do
    {
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
      bool1 = bool2;
    } while (paramList1.size() != paramList2.size());
    int i = 0;
    for (;;)
    {
      if (i >= paramList1.size()) {
        break label93;
      }
      bool1 = bool2;
      if (!((Long)paramList1.get(i)).equals(paramList2.get(i))) {
        break;
      }
      i += 1;
    }
    label93:
    return true;
  }
  
  ljz.a a(luq.b paramb)
  {
    if (paramb != null) {}
    for (;;)
    {
      try
      {
        if ((this.b != null) && (this.b.h != null))
        {
          Object localObject = this.b.h;
          Long localLong1 = (Long)((ToServiceMsg)localObject).getAttribute(lir.afg);
          Long localLong2 = (Long)((ToServiceMsg)localObject).getAttribute(lir.afh);
          long l1;
          if (localLong1 != null)
          {
            l1 = localLong1.longValue();
            if (localLong2 != null)
            {
              l2 = localLong2.longValue();
              QLog.d("FeedsPreloadDataModule", 1, new Object[] { "isReqEqual: ", "cache bSeq = ", Long.valueOf(l1), ", request bSeq = ", Long.valueOf(paramb.uH), "\n", "cache eSeq = ", Long.valueOf(l2), ", request eSeq = ", Long.valueOf(paramb.uI) });
              if ((l1 == paramb.uH) && (l2 == paramb.uI)) {
                continue;
              }
              QLog.d("FeedsPreloadDataModule", 1, "getCache, the seq is not equal.");
              paramb = null;
              return paramb;
            }
          }
          else
          {
            l1 = -1L;
            continue;
          }
          long l2 = -1L;
          continue;
          paramb = paramb.iu;
          localObject = (List)((ToServiceMsg)localObject).getAttribute("SubscriptionArticles");
          if ((paramb != null) && (paramb.size() > 0))
          {
            if (d(paramb, (List)localObject))
            {
              QLog.d("FeedsPreloadDataModule", 1, "two subscriptionLists are the same.");
              paramb = this.b.a();
              continue;
            }
            QLog.d("FeedsPreloadDataModule", 1, "two subscriptionList are different.");
          }
          else
          {
            if ((localObject == null) || (((List)localObject).size() == 0))
            {
              QLog.d("FeedsPreloadDataModule", 1, "two subscriptionLists both are empty.");
              paramb = this.b.a();
              continue;
            }
            QLog.d("FeedsPreloadDataModule", 1, "cache subscriptionList is not empty.");
          }
        }
      }
      finally {}
      paramb = null;
    }
  }
  
  public void a(ljz.a parama)
  {
    if (parama != null) {}
    try
    {
      this.b = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void aEL()
  {
    this.b = null;
  }
  
  void clearCache()
  {
    try
    {
      QLog.d("FeedsPreloadDataModule", 2, "clearCache.");
      this.b = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static class a
  {
    public String afq;
    public boolean akF;
    public byte[] bm;
    public int channelID;
    public ToServiceMsg h;
    public List<ArticleInfo> il;
    public List<ArticleInfo> im;
    public int result;
    public boolean success;
    
    public a a()
    {
      a locala = new a();
      locala.a(this.h).a(this.channelID).b(this.result).a(this.il).b(this.im).a(this.success).b(this.akF).a(this.bm).a(this.afq);
      return locala;
    }
    
    public a a(int paramInt)
    {
      this.channelID = paramInt;
      return this;
    }
    
    public a a(ToServiceMsg paramToServiceMsg)
    {
      this.h = paramToServiceMsg;
      return this;
    }
    
    public a a(String paramString)
    {
      this.afq = paramString;
      return this;
    }
    
    public a a(List<ArticleInfo> paramList)
    {
      this.il = paramList;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.success = paramBoolean;
      return this;
    }
    
    public a a(byte[] paramArrayOfByte)
    {
      this.bm = paramArrayOfByte;
      return this;
    }
    
    public a b(int paramInt)
    {
      this.result = paramInt;
      return this;
    }
    
    public a b(List<ArticleInfo> paramList)
    {
      this.im = paramList;
      return this;
    }
    
    public a b(boolean paramBoolean)
    {
      this.akF = paramBoolean;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ljz
 * JD-Core Version:    0.7.0.1
 */