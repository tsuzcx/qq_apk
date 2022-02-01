package cooperation.qqfav.globalsearch;

import amjm;
import amow;
import amwd;
import amwe;
import amwt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FunctionSearchEngine
  implements amwd<amow>
{
  public static final String TAG = FunctionSearchEngine.class.getSimpleName();
  protected SearchRunnable a = new FunctionSearchEngine.1(this);
  protected QQAppInterface mApp;
  private int mFromType = -1;
  
  public FunctionSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.mApp = paramQQAppInterface;
    this.mFromType = paramInt;
  }
  
  public List<amow> a(amwt paramamwt)
  {
    if ((paramamwt == null) || (paramamwt.keyword == null) || (paramamwt.keyword.trim().length() == 0)) {
      return null;
    }
    if (this.mApp == null)
    {
      QLog.e(TAG, 1, "search, app is null.");
      return null;
    }
    paramamwt = ((amjm)this.mApp.getManager(222)).v("" + paramamwt.keyword, this.mFromType);
    if ((paramamwt == null) || (paramamwt.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramamwt.size());
    int i = 0;
    while (i < paramamwt.size())
    {
      localArrayList.add((amow)paramamwt.get(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(amwt paramamwt, amwe<amow> paramamwe)
  {
    if ((paramamwt == null) || (paramamwt.keyword == null) || (paramamwt.keyword.trim().length() == 0)) {
      return;
    }
    synchronized (this.a)
    {
      this.a.a = paramamwt;
      this.a.b = paramamwe;
      ThreadManager.removeJobFromThreadPool(this.a, 32);
      ThreadManager.excute(this.a, 32, null, false);
      return;
    }
  }
  
  public void cancel()
  {
    synchronized (this.a)
    {
      this.a.a = null;
      this.a.b = null;
      ThreadManager.removeJobFromThreadPool(this.a, 32);
      return;
    }
  }
  
  public void destroy() {}
  
  public void init() {}
  
  public void pause() {}
  
  public void resume() {}
  
  public class SearchRunnable
    implements Runnable
  {
    public amwt a;
    public amwe<amow> b;
    
    protected SearchRunnable() {}
    
    public void run()
    {
      if ((this.a == null) || (this.b == null)) {
        if (QLog.isColorLevel()) {
          QLog.e(FunctionSearchEngine.TAG, 2, "mSearchRunnable.run, innerSearchRequest == null or innerListener == null");
        }
      }
      ArrayList localArrayList;
      do
      {
        List localList;
        do
        {
          return;
          if (FunctionSearchEngine.this.mApp == null)
          {
            QLog.e(FunctionSearchEngine.TAG, 1, "mSearchRunnable.run, app is null.");
            this.b.s(null, 6);
            return;
          }
          localList = ((amjm)FunctionSearchEngine.this.mApp.getManager(222)).v("" + this.a.keyword, FunctionSearchEngine.a(FunctionSearchEngine.this));
          if ((localList != null) && (localList.size() != 0)) {
            break;
          }
        } while (this.b == null);
        this.b.s(null, 1);
        return;
        localArrayList = new ArrayList(localList.size());
        int i = 0;
        while (i < localList.size())
        {
          localArrayList.add((amow)localList.get(i));
          i += 1;
        }
      } while (this.b == null);
      this.b.s(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FunctionSearchEngine
 * JD-Core Version:    0.7.0.1
 */