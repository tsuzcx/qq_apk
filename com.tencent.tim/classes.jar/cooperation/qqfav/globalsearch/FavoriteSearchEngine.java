package cooperation.qqfav.globalsearch;

import alld;
import amwd;
import amwe;
import amwt;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import avja;
import avjs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class FavoriteSearchEngine
  implements amwd<avjs>
{
  private static boolean dnj;
  private Thread B;
  private Thread C;
  private final QueryRunnable jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable = new QueryRunnable(null);
  private final SearchRunnable jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable = new SearchRunnable(null);
  private List<avjs> aE = new ArrayList();
  private long azy;
  private String cLq;
  private final QQAppInterface mApp;
  private int mState;
  
  public FavoriteSearchEngine(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public List<avjs> a(amwt paramamwt)
  {
    if (paramamwt != null) {}
    int i;
    long l;
    boolean bool2;
    boolean bool1;
    label111:
    Object localObject1;
    for (;;)
    {
      try
      {
        if (paramamwt.keyword != null)
        {
          i = paramamwt.keyword.trim().length();
          if (i != 0) {}
        }
        else
        {
          paramamwt = null;
          return paramamwt;
        }
        if (!dnj) {
          dnj = avja.bN(false);
        }
        this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.a = paramamwt;
        if (paramamwt.extra == null) {
          break label1092;
        }
        i = paramamwt.extra.getInt("iNumber", 1);
        l = paramamwt.extra.getLong("lModifyTime", 9223372036854775807L);
        bool2 = paramamwt.extra.getBoolean("bMore", false);
        bool1 = paramamwt.extra.getBoolean("bSearchNet", false);
        if ((!paramamwt.keyword.equals(this.cLq)) || ((bool1) && (this.mState == 1)))
        {
          this.cLq = paramamwt.keyword;
          this.azy = 9223372036854775807L;
          this.aE.clear();
          this.mState = 0;
        }
        if ((this.mState != 2) && ((bool1) || (this.mState != 1))) {
          break;
        }
        localObject1 = new ArrayList(this.aE);
        paramamwt = (amwt)localObject1;
        if (!bool2) {
          if (this.aE.size() > 1)
          {
            ((ArrayList)localObject1).remove(((ArrayList)localObject1).size() - 1);
            paramamwt = (amwt)localObject1;
          }
          else
          {
            paramamwt = null;
          }
        }
      }
      finally {}
    }
    label279:
    label427:
    boolean bool3;
    label627:
    int j;
    label764:
    int m;
    label795:
    int k;
    if ((bool2) && (this.aE.size() > 0))
    {
      l = Math.min(l, this.azy);
      this.mState = 0;
      this.B = Thread.currentThread();
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.keyword = this.cLq;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.number = i;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.modifyTime = l;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.dnk = bool1;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.a = null;
      for (;;)
      {
        synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable)
        {
          this.C = new Thread(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable);
          this.C.start();
          try
          {
            this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.wait();
            localObject1 = this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.a;
            if (localObject1 == null) {
              break label1076;
            }
            if (!((Cursor)localObject1).moveToFirst()) {
              break;
            }
            if ((this.aE.size() >= 5) || (((Cursor)localObject1).getCount() <= 1)) {
              break label1136;
            }
            i = 1;
            if (this.aE.size() > 0) {
              this.aE.remove(this.aE.size() - 1);
            }
            ??? = new avjs();
            ((avjs)???).keyword = paramamwt.keyword;
            ((avjs)???).favId = ((Cursor)localObject1).getLong(0);
            ((avjs)???).azz = ((Cursor)localObject1).getLong(4);
            ((avjs)???).azA = ((Cursor)localObject1).getLong(5);
            ((avjs)???).title = ((Cursor)localObject1).getString(1);
            ((avjs)???).source = ((Cursor)localObject1).getString(2);
            ((avjs)???).cLr = ((Cursor)localObject1).getString(3);
            ((avjs)???).exf = ((Cursor)localObject1).getInt(6);
            ((avjs)???).exe = ((Cursor)localObject1).getInt(8);
            ((avjs)???).hX = ((Cursor)localObject1).getBlob(7);
            ((avjs)???).exg = ((Cursor)localObject1).getInt(9);
            if (((Cursor)localObject1).getInt(10) <= 0) {
              break label1141;
            }
            bool3 = true;
            ((avjs)???).playable = bool3;
            ((avjs)???).exc = ((Cursor)localObject1).getInt(11);
            ((avjs)???).exd = ((Cursor)localObject1).getInt(12);
            ((avjs)???).exb = ((Cursor)localObject1).getInt(13);
            ((avjs)???).exh = ((Cursor)localObject1).getInt(14);
            ((avjs)???).postion = this.aE.size();
            this.aE.add(???);
            if (((Cursor)localObject1).moveToNext()) {
              continue;
            }
            if (((avjs)???).favId < 0L)
            {
              if (((avjs)???).favId != -2L) {
                break label920;
              }
              this.azy = ((avjs)???).azz;
              if (!bool1) {
                break label1147;
              }
              j = 2;
              this.mState = j;
            }
            if (i == 0) {
              break label967;
            }
            m = Math.min(4, this.aE.size() - 1);
            i = 0;
          }
          catch (InterruptedException localInterruptedException)
          {
            int n;
            if (!QLog.isColorLevel()) {
              break label1130;
            }
          }
          if (j <= 0) {
            break label1152;
          }
          n = k - j;
          paramamwt = (avjs)this.aE.get(n);
          if (paramamwt.exh > ((avjs)this.aE.get(n + 1)).exh)
          {
            this.aE.set(n, this.aE.get(n + 1));
            this.aE.set(n + 1, paramamwt);
          }
          j -= 1;
          continue;
          QLog.d("qqfav", 2, "InterruptedException, search cancel.");
        }
        label920:
        if ((localInterruptedException.getCount() > 1) || (l > ((avjs)???).azz)) {
          this.azy = ((avjs)???).azz;
        } else {
          this.mState = -1;
        }
      }
      this.mState = -1;
    }
    label1152:
    label1157:
    for (;;)
    {
      label967:
      localInterruptedException.close();
      ArrayList localArrayList;
      for (;;)
      {
        if ((this.mState == -1) && (this.aE.size() > 0)) {
          ((avjs)this.aE.get(this.aE.size() - 1)).favId = -3L;
        }
        localArrayList = new ArrayList(this.aE);
        paramamwt = localArrayList;
        if (bool2) {
          break;
        }
        if (this.aE.size() <= 1) {
          break label1084;
        }
        localArrayList.remove(localArrayList.size() - 1);
        paramamwt = localArrayList;
        break;
        label1076:
        this.mState = -1;
      }
      label1084:
      paramamwt = null;
      break;
      break label279;
      label1092:
      bool2 = false;
      i = 1;
      bool1 = false;
      l = 9223372036854775807L;
      break label111;
      for (;;)
      {
        if (i >= m - 1) {
          break label1157;
        }
        k = m - i - 1;
        j = k;
        break label795;
        label1130:
        localArrayList = null;
        break;
        label1136:
        i = 0;
        break label427;
        label1141:
        bool3 = false;
        break label627;
        label1147:
        j = 1;
        break label764;
        i += 1;
      }
    }
  }
  
  public void a(amwt paramamwt, amwe<avjs> paramamwe)
  {
    if ((paramamwt == null) || (paramamwt.keyword == null) || (paramamwt.keyword.trim().length() == 0)) {
      return;
    }
    synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.a = paramamwt;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.b = paramamwe;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable, 32);
      ThreadManager.excute(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable, 32, null, false);
      return;
    }
  }
  
  public void cancel()
  {
    synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.a = null;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.b = null;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable, 32);
      if (this.B != null) {
        this.B.interrupt();
      }
      return;
    }
  }
  
  public void destroy() {}
  
  public void init()
  {
    if (!dnj) {
      dnj = avja.bN(false);
    }
  }
  
  public void pause() {}
  
  public void resume() {}
  
  class QueryRunnable
    implements Runnable
  {
    protected Cursor a;
    protected boolean dnk;
    protected String keyword;
    protected long modifyTime;
    protected int number;
    
    private QueryRunnable() {}
    
    public void run()
    {
      Object localObject1 = FavoriteSearchEngine.a(FavoriteSearchEngine.this).getApplication().getContentResolver();
      ??? = Uri.parse("content://tim.favorites/global_search/" + FavoriteSearchEngine.a(FavoriteSearchEngine.this).getAccount());
      try
      {
        localObject1 = alld.query((ContentResolver)localObject1, (Uri)???, null, null, new String[] { this.keyword, "" + this.number, "" + this.modifyTime, "" + this.dnk }, null);
      }
      catch (Exception localException)
      {
        synchronized (FavoriteSearchEngine.a(FavoriteSearchEngine.this))
        {
          if (FavoriteSearchEngine.a(FavoriteSearchEngine.this) == Thread.currentThread())
          {
            this.a = ((Cursor)localObject1);
            FavoriteSearchEngine.a(FavoriteSearchEngine.this).notify();
          }
          Object localObject2;
          while (localObject2 == null)
          {
            return;
            localException = localException;
            localException.printStackTrace();
            localObject2 = null;
            break;
          }
          localObject2.close();
        }
      }
    }
  }
  
  class SearchRunnable
    implements Runnable
  {
    amwt a;
    amwe<avjs> b;
    
    private SearchRunnable() {}
    
    public void run()
    {
      amwt localamwt = this.a;
      String str = this.a.keyword;
      List localList = FavoriteSearchEngine.this.a(localamwt);
      try
      {
        if ((this.b != null) && (localamwt == this.a) && (str.equals(this.a.keyword))) {
          this.b.s(localList, 1);
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchEngine
 * JD-Core Version:    0.7.0.1
 */