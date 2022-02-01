import java.util.ArrayList;
import java.util.Iterator;

public class obe
  implements jox
{
  public int aCy;
  public String aoQ;
  public String aoR;
  public String aoS;
  public String aoT;
  public String mBusinessId;
  public String mDownloadUrl;
  private ArrayList<jqh> mObservers = new ArrayList();
  private int mProgress;
  private int mStatus;
  
  public obe(String paramString)
  {
    this.mBusinessId = paramString;
  }
  
  public void a(jqh paramjqh)
  {
    if (!this.mObservers.contains(paramjqh)) {
      this.mObservers.add(paramjqh);
    }
  }
  
  public void b(jqh paramjqh)
  {
    this.mObservers.remove(paramjqh);
  }
  
  public void doRefresh()
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((jqh)localIterator.next()).doRefresh();
    }
  }
  
  public int getObserverCount()
  {
    return this.mObservers.size();
  }
  
  public int getProgress()
  {
    return this.mProgress;
  }
  
  public int getStatus()
  {
    return this.mStatus;
  }
  
  public void loaded(String paramString, int paramInt)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((jqh)localIterator.next()).loaded(paramString, paramInt);
    }
  }
  
  public void progress(int paramInt)
  {
    this.mProgress = paramInt;
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((jqh)localIterator.next()).progress(paramInt);
    }
  }
  
  public void setStatus(int paramInt)
  {
    this.mStatus = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     obe
 * JD-Core Version:    0.7.0.1
 */