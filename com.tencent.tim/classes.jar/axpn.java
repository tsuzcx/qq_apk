import android.app.Activity;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class axpn
{
  public int eGB;
  public ArrayList<axpo> mListeners = new ArrayList();
  protected SegmentKeeper mSegmentKeeper;
  protected int mTemplateId;
  public int outState = 2;
  public Object target;
  
  public axpn(Object paramObject)
  {
    this.target = paramObject;
  }
  
  public abstract void A(Activity paramActivity, int paramInt);
  
  public void B(Activity paramActivity, int paramInt) {}
  
  public int Rq()
  {
    return 1;
  }
  
  public void a(axpo paramaxpo)
  {
    synchronized (this.mListeners)
    {
      if (!this.mListeners.contains(paramaxpo)) {
        this.mListeners.add(paramaxpo);
      }
      return;
    }
  }
  
  public void a(SegmentKeeper paramSegmentKeeper)
  {
    this.mSegmentKeeper = paramSegmentKeeper;
  }
  
  public void aeD(int paramInt)
  {
    synchronized (this.mListeners)
    {
      Iterator localIterator = this.mListeners.iterator();
      if (localIterator.hasNext()) {
        ((axpo)localIterator.next()).a(this, paramInt);
      }
    }
  }
  
  public abstract int b(Activity paramActivity, int paramInt);
  
  public void eNI()
  {
    synchronized (this.mListeners)
    {
      Iterator localIterator = this.mListeners.iterator();
      if (localIterator.hasNext()) {
        ((axpo)localIterator.next()).a(this);
      }
    }
  }
  
  public void eNJ()
  {
    synchronized (this.mListeners)
    {
      Iterator localIterator = this.mListeners.iterator();
      if (localIterator.hasNext()) {
        ((axpo)localIterator.next()).b(this);
      }
    }
  }
  
  public abstract float getProgress();
  
  public abstract int getState();
  
  public String getUniqueKey()
  {
    return String.valueOf(this.target.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axpn
 * JD-Core Version:    0.7.0.1
 */