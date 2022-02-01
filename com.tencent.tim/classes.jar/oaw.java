import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public abstract class oaw
{
  private oaw.a a;
  private final String tag = "FeedExposureHelper";
  
  public int Y(int paramInt1, int paramInt2)
  {
    return paramInt1 + paramInt2;
  }
  
  public oaw.a a(AbsListView paramAbsListView)
  {
    int j = 0;
    oaw.a locala = new oaw.a();
    locala.time = System.currentTimeMillis();
    int k = paramAbsListView.getHeight();
    int m = paramAbsListView.getFirstVisiblePosition();
    int n = paramAbsListView.getChildCount();
    int i = j;
    if (n == 0)
    {
      locala.bdM = 0;
      locala.bdN = 10;
      i = j;
    }
    if (i < n)
    {
      if (d(paramAbsListView.getChildAt(i), k)) {
        locala.bdM = Y(m, i);
      }
    }
    else {
      i = paramAbsListView.getLastVisiblePosition() - m;
    }
    for (;;)
    {
      if (i >= 0)
      {
        if (d(paramAbsListView.getChildAt(i), k)) {
          locala.bdN = Y(m, i);
        }
      }
      else
      {
        return locala;
        i += 1;
        break;
      }
      i -= 1;
    }
  }
  
  public oaw.a a(oaw.a parama1, oaw.a parama2)
  {
    if ((parama1 == null) || (parama2 == null)) {}
    while ((parama1.bdN < parama2.bdM) || (parama1.bdM > parama2.bdN)) {
      return null;
    }
    oaw.a locala = new oaw.a();
    if (parama1.bdM > parama2.bdM)
    {
      i = parama1.bdM;
      locala.bdM = i;
      if (parama1.bdN >= parama2.bdN) {
        break label113;
      }
    }
    label113:
    for (int i = parama1.bdN;; i = parama2.bdN)
    {
      locala.bdN = i;
      locala.time = Math.abs(parama1.time - parama2.time);
      return locala;
      i = parama2.bdM;
      break;
    }
  }
  
  public abstract void a(oaw.a parama);
  
  public boolean d(View paramView, int paramInt)
  {
    if (paramView == null) {
      return false;
    }
    if (paramView.getBottom() > paramInt) {}
    for (;;)
    {
      int i = paramInt;
      if (paramView.getTop() > 0) {
        i = paramInt - paramView.getTop();
      }
      if (i <= paramView.getHeight() * 0.5F) {
        break;
      }
      return true;
      paramInt = paramView.getBottom();
    }
  }
  
  public void n(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      paramAbsListView = a(paramAbsListView);
      QLog.d("FeedExposureHelper", 2, "thisRange: " + paramAbsListView);
      if (this.a != null)
      {
        oaw.a locala = a(this.a, paramAbsListView);
        if ((locala != null) && (locala.time > 1000L))
        {
          QLog.d("FeedExposureHelper", 2, "sameRange: " + locala);
          a(locala);
        }
      }
      this.a = paramAbsListView;
    } while (paramInt != 5);
    this.a = null;
  }
  
  public static class a
  {
    public int bdM = -1;
    public int bdN = -1;
    public long time;
    
    public String toString()
    {
      return "time: " + this.time + " starPosition: " + this.bdM + "  endPostition: " + this.bdN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oaw
 * JD-Core Version:    0.7.0.1
 */