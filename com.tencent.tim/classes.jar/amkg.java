import android.annotation.TargetApi;
import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class amkg
  extends AsyncTask<Void, Void, Void>
{
  private static Comparator<amka> U = new amkj();
  private static Comparator<amka> V = new amkk();
  private static final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 3, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new amkh());
  private List<? extends amka> FF;
  private List<Future<List<amka>>> FG;
  private List<amka> FH;
  private amkg.a a;
  boolean bBW = false;
  private String caD;
  private final int dCx = 300;
  private ExecutorService executor;
  private String keyWord;
  
  public amkg(String paramString1, String paramString2, List<? extends amka> paramList, amkg.a parama)
  {
    this.keyWord = paramString1;
    this.caD = paramString2;
    this.FF = paramList;
    this.a = parama;
    this.executor = Executors.newFixedThreadPool(20);
    this.FG = new ArrayList();
    this.FH = new ArrayList();
  }
  
  private void A(List<amka> paramList, String paramString)
  {
    if (paramList.size() > 20) {}
    for (int i = 20;; i = paramList.size())
    {
      int j = 0;
      while (j < i)
      {
        amjz localamjz = (amjz)paramList.get(j);
        if (QLog.isColorLevel()) {
          QLog.d("SearchTask", 2, "printSearchResultData " + paramString + "matchDegree : " + localamjz.gN() + " message time : " + localamjz.ajK);
        }
        j += 1;
      }
    }
  }
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    int j;
    if (this.FF != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchTask", 2, "Start doInBackground , keyword = " + this.keyWord);
      }
      int k = this.FF.size();
      int n = k / 300;
      int i = 0;
      int i1;
      if (i < n + 1)
      {
        i1 = i * 300;
        if (i1 + 300 <= k) {
          break label168;
        }
        j = k;
        label91:
        if ((!isCancelled()) && (!this.executor.isShutdown())) {
          break label178;
        }
      }
      for (;;)
      {
        try
        {
          this.FH.clear();
          l1 = System.currentTimeMillis();
          i = 0;
          if ((i >= this.FG.size()) || (isCancelled()))
          {
            this.FG.clear();
            boolean bool = isCancelled();
            if (!bool) {
              continue;
            }
            return null;
            label168:
            j = i1 + 300;
            break label91;
            label178:
            paramVarArgs = this.executor.submit(new amki(this, i1, j));
            this.FG.add(paramVarArgs);
            i += 1;
            break;
          }
          paramVarArgs = (List)((Future)this.FG.get(i)).get();
          if (i == 0)
          {
            this.FH.addAll(paramVarArgs);
            paramVarArgs.clear();
            i += 1;
            continue;
          }
          localIterator = paramVarArgs.iterator();
        }
        catch (InterruptedException paramVarArgs)
        {
          Iterator localIterator;
          amka localamka;
          paramVarArgs.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SearchTask", 2, "InterruptedException happens, keyword = " + this.keyWord + " : ");
          this.bBW = false;
          return null;
          if (((amka)this.FH.get(j)).gN() >= localamka.gN()) {
            continue;
          }
          this.FH.set(j, localamka);
          continue;
        }
        catch (ExecutionException paramVarArgs)
        {
          long l1;
          paramVarArgs.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SearchTask", 2, "InterruptedException happens, keyword = " + this.keyWord + " : ");
          continue;
          lZ(this.FH);
          l2 = System.currentTimeMillis();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SearchTask", 2, "SearchTask ======= doInBackground time = " + (l2 - l1) + " , keyword = " + this.keyWord);
          continue;
        }
        if (localIterator.hasNext())
        {
          localamka = (amka)localIterator.next();
          if (!isCancelled())
          {
            j = this.FH.indexOf(localamka);
            if (-1 != j) {
              continue;
            }
            this.FH.add(localamka);
          }
        }
      }
    }
    for (;;)
    {
      long l2;
      this.bBW = true;
      if (QLog.isColorLevel()) {
        QLog.d("SearchTask", 2, "doInBackground:: inputSet is null.");
      }
    }
  }
  
  protected void lZ(List<amka> paramList)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SearchTask", 2, "start sortResultSet(), keyword = " + this.keyWord);
    }
    Collections.sort(paramList, U);
    int i = Math.min(paramList.size(), 30);
    List localList = paramList.subList(0, i);
    Collections.sort(localList, V);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(localList);
    localArrayList.addAll(paramList.subList(i, paramList.size()));
    A(paramList, "after sort ");
    if (QLog.isColorLevel()) {
      QLog.d("SearchTask", 2, "sortResultSet() time = " + (System.currentTimeMillis() - l) + " , keyword = " + this.keyWord);
    }
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    if (isCancelled())
    {
      this.FH.clear();
      this.executor.shutdown();
      if (QLog.isColorLevel()) {
        QLog.d("SearchTask", 2, "onPostExecute:: isCancelled.");
      }
    }
    while (this.a == null) {
      return;
    }
    int i = 1;
    if (this.bBW) {
      i = 0;
    }
    this.a.M(i, this.FH);
    this.executor.shutdown();
  }
  
  @TargetApi(11)
  public void start()
  {
    executeOnExecutor(m, new Void[0]);
    if (QLog.isColorLevel()) {
      QLog.d("SearchTask", 2, "Start execute , keyword = " + this.keyWord);
    }
  }
  
  public static abstract interface a
  {
    public abstract void M(int paramInt, List<? extends amka> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amkg
 * JD-Core Version:    0.7.0.1
 */