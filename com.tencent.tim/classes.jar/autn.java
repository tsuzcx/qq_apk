import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class autn
{
  private static ArrayList<autn> Er = new ArrayList(5);
  public int cWL;
  public int ccW;
  public int esY;
  public int type;
  
  private static autn a()
  {
    synchronized (Er)
    {
      if (Er.size() > 0)
      {
        localautn = (autn)Er.remove(0);
        localautn.resetState();
        return localautn;
      }
      autn localautn = new autn();
      return localautn;
    }
  }
  
  public static autn a(int paramInt)
  {
    return a(2, paramInt, 0, 0);
  }
  
  public static autn a(int paramInt1, int paramInt2)
  {
    return a(1, paramInt1, paramInt2, 0);
  }
  
  public static autn a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    autn localautn = a();
    localautn.type = paramInt1;
    localautn.ccW = paramInt2;
    localautn.cWL = paramInt3;
    localautn.esY = paramInt4;
    return localautn;
  }
  
  public static autn a(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    autn localautn = a();
    localautn.ccW = ExpandableListView.getPackedPositionGroup(paramLong);
    if (ExpandableListView.getPackedPositionType(paramLong) == 1)
    {
      localautn.type = 1;
      localautn.cWL = ExpandableListView.getPackedPositionChild(paramLong);
      return localautn;
    }
    localautn.type = 2;
    return localautn;
  }
  
  private void resetState()
  {
    this.ccW = 0;
    this.cWL = 0;
    this.esY = 0;
    this.type = 0;
  }
  
  public long iF()
  {
    if (this.type == 1) {
      return ExpandableListView.getPackedPositionForChild(this.ccW, this.cWL);
    }
    return ExpandableListView.getPackedPositionForGroup(this.ccW);
  }
  
  public void recycle()
  {
    synchronized (Er)
    {
      if (Er.size() < 5) {
        Er.add(this);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     autn
 * JD-Core Version:    0.7.0.1
 */