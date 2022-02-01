import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.1;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.JobSegment;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class qve<T extends qve.a>
  extends pxf
{
  public qve.b a;
  protected qve.d<T> a;
  public pua c;
  private Stream<T> d;
  
  public qve(@NonNull qve.d<T> paramd)
  {
    this.jdField_a_of_type_Qve$b = new qve.b();
    this.jdField_a_of_type_Qve$d = paramd;
    rom.checkNotNull(this.jdField_a_of_type_Qve$d);
  }
  
  private void bpZ()
  {
    aTA();
    Bosses.get().postLightWeightJob(new FeedListPageLoaderBase.1(this), 0);
  }
  
  protected abstract void K(List<String> paramList, boolean paramBoolean);
  
  public abstract JobSegment<qve.c, T> a();
  
  public abstract JobSegment<Integer, qve.c> a(qve.b paramb);
  
  protected abstract T a();
  
  protected abstract T a(ErrorMessage paramErrorMessage);
  
  public qve.b a()
  {
    return this.jdField_a_of_type_Qve$b;
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.jdField_a_of_type_Qve$b.reset();
    bpZ();
  }
  
  public void a(qve.b paramb)
  {
    this.jdField_a_of_type_Qve$b = paramb;
    ram.b("Q.qqstory.home.position", "restore last time cache:%s", paramb);
  }
  
  public void aPh()
  {
    super.aPh();
    bpZ();
  }
  
  public T b()
  {
    return a();
  }
  
  public static class a
    extends pxc
  {
    public List<String> np = new ArrayList();
    
    public a(ErrorMessage paramErrorMessage)
    {
      super();
    }
    
    public String toString()
    {
      return "FeedData{" + super.toString() + '}';
    }
  }
  
  public static class b
  {
    private static qvd.a a = new qvd.a();
    private String ayW = "";
    public int bol;
    private int bom;
    public boolean mIsEnd;
    public List<qvd> nk = new ArrayList();
    
    public b() {}
    
    public b(b paramb)
    {
      this.nk.addAll(paramb.nk);
      this.ayW = paramb.ayW;
      this.mIsEnd = paramb.mIsEnd;
      this.bol = paramb.bol;
      this.bom = paramb.bom;
    }
    
    private boolean isEnd()
    {
      return this.mIsEnd;
    }
    
    public qve.c a(int paramInt1, int paramInt2)
    {
      boolean bool = true;
      int i;
      ArrayList localArrayList;
      for (;;)
      {
        try
        {
          qve.c localc1 = new qve.c();
          if (paramInt1 == 0)
          {
            localc1.aFJ = bool;
            if (this.nk.size() <= paramInt1) {
              break label330;
            }
            i = paramInt2;
            if (paramInt1 + paramInt2 > this.nk.size()) {
              i = this.nk.size() - paramInt1;
            }
            if ((paramInt1 + i >= this.nk.size()) && (isEnd())) {
              localc1.mIsEnd = true;
            }
            localArrayList = new ArrayList(this.nk);
            localc1.oq = localArrayList.subList(paramInt1, paramInt1 + i);
            paramInt2 = paramInt1 + i;
            if (paramInt2 >= this.nk.size()) {
              break label309;
            }
            qvd localqvd1 = (qvd)this.nk.get(paramInt2);
            Iterator localIterator = localc1.oq.iterator();
            if (!localqvd1.aFI) {
              break label309;
            }
            if (!localIterator.hasNext()) {
              break;
            }
            qvd localqvd2 = (qvd)localIterator.next();
            if ((!localqvd2.aFI) || (!localqvd2.ayV.equals(localqvd1.ayV))) {
              continue;
            }
            localIterator.remove();
            ram.w("Q.qqstory.home.data.FeedListPageLoaderBase", "remove one fail info:%s", new Object[] { localqvd2 });
            continue;
          }
          bool = false;
        }
        finally {}
      }
      if (localc2.oq.isEmpty())
      {
        localc2.oq = localArrayList.subList(paramInt1, paramInt1 + i);
        ram.w("Q.qqstory.home.data.FeedListPageLoaderBase", "bad luck for you have too much fail %s", new Object[] { localc2.oq });
      }
      for (;;)
      {
        label309:
        this.bom = (localc2.oq.size() + paramInt1);
        return localc2;
        label330:
        localc2.mIsEnd = isEnd();
      }
    }
    
    public void brd()
    {
      try
      {
        this.bol = this.bom;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void e(List<qvd> paramList, String paramString, boolean paramBoolean)
    {
      try
      {
        this.nk.addAll(paramList);
        this.ayW = paramString;
        this.mIsEnd = paramBoolean;
        ram.w("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId list:set next cookie data count:%d, cookie:%s, isEnd:%b", new Object[] { Integer.valueOf(paramList.size()), paramString, Boolean.valueOf(paramBoolean) });
        ram.b("Q.qqstory.home.data.FeedListPageLoaderBase", "add feed list:%s", paramList);
        return;
      }
      finally
      {
        paramList = finally;
        throw paramList;
      }
    }
    
    public String mP()
    {
      return this.ayW;
    }
    
    public void reset()
    {
      try
      {
        this.nk.clear();
        this.ayW = "";
        this.mIsEnd = false;
        this.bol = 0;
        this.bom = 0;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void sortList()
    {
      try
      {
        if (ram.isColorLevel()) {
          ram.b("Q.qqstory.home.data.FeedListPageLoaderBase", "before sort curpos:%d -- %s", Integer.valueOf(this.bol), this.nk);
        }
        Collections.sort(this.nk, a);
        if (ram.isColorLevel()) {
          ram.b("Q.qqstory.home.data.FeedListPageLoaderBase", "after* sort curpos:%d -- %s", Integer.valueOf(this.bol), this.nk);
        }
        return;
      }
      finally {}
    }
    
    public String toString()
    {
      try
      {
        String str = "FeedIdListCache{mFeedIdListCache=" + this.nk + ", mFeedIdNextCookie='" + this.ayW + '\'' + ", mIsEnd=" + this.mIsEnd + ", mCurFeedIdPosition=" + this.bol + ", mTempFeedIdPosition=" + this.bom + '}';
        return str;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  public static class c
  {
    public boolean aFJ;
    public boolean mIsEnd;
    public List<qvd> oq = new ArrayList(0);
  }
  
  public static abstract interface d<T>
  {
    public abstract void am(T paramT);
  }
  
  public class e
    extends SimpleObserver<T>
  {
    public e() {}
    
    public void a(T paramT)
    {
      super.onNext(paramT);
      qve.this.bnx();
      ram.d("Q.qqstory.home.data.FeedListPageLoaderBase", "refresh data finish %s", paramT);
      paramT.aCv = qve.this.aCx;
      qve.this.K(paramT.np, paramT.isFirstPage);
      qve.this.jdField_a_of_type_Qve$b.brd();
      qve.this.jdField_a_of_type_Qve$d.am(paramT);
      qve.this.rw("Q.qqstory.home.data.FeedListPageLoaderBase");
    }
    
    public void onCancel()
    {
      super.onCancel();
      ram.w("Q.qqstory.home.data.FeedListPageLoaderBase", "refresh data cancel");
    }
    
    public void onError(@NonNull Error paramError)
    {
      super.onError(paramError);
      paramError = (ErrorMessage)paramError;
      paramError = qve.this.a(paramError);
      paramError.aCv = qve.this.aCx;
      qve.this.jdField_a_of_type_Qve$d.am(paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qve
 * JD-Core Version:    0.7.0.1
 */