import com.tencent.biz.pubaccount.readinjoy.ugc.PageLoadManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class miw<T>
{
  private miw.a<T> a;
  private boolean amY;
  private boolean mHasMore = true;
  private int mOffset;
  private int oH = 100;
  
  public void a(miw.a<T> parama)
  {
    this.a = parama;
  }
  
  public void aPh()
  {
    miw.a locala = this.a;
    if (locala == null) {
      if (QLog.isColorLevel()) {
        QLog.e("PageLoadManager", 2, "mQueryProvider is not registered, can't query data...");
      }
    }
    do
    {
      return;
      if (this.mHasMore) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("PageLoadManager", 2, "requestNextPage cancel for mHasMore is false");
    return;
    this.amY = true;
    if (QLog.isColorLevel()) {
      QLog.i("PageLoadManager", 2, "requestNextPage mOffset:" + this.mOffset + " mPageSize:$mPageSize");
    }
    ThreadManager.executeOnSubThread(new PageLoadManager.1(this, locala));
  }
  
  public void rP(int paramInt)
  {
    if (!this.mHasMore) {
      if (QLog.isColorLevel()) {
        QLog.w("PageLoadManager", 2, "onPositionShow return for mHasMore is false");
      }
    }
    do
    {
      do
      {
        return;
        if (!this.amY) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("PageLoadManager", 2, "query is doing...");
      return;
    } while (paramInt < (this.mOffset + (this.mOffset - this.oH)) / 2);
    aPh();
  }
  
  public static abstract interface a<T>
  {
    public abstract List<T> a(int paramInt1, int paramInt2);
    
    public abstract void p(List<T> paramList, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     miw
 * JD-Core Version:    0.7.0.1
 */