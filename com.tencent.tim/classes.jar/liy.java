import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class liy
{
  private static liy a;
  private HashSet<Integer> O = new HashSet();
  private SparseArray<ChannelInfo> af = new SparseArray();
  private boolean aky = true;
  
  public static liy a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new liy();
      }
      return a;
    }
    finally {}
  }
  
  public void cy(List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        int i = ((Integer)paramList.next()).intValue();
        this.af.remove(i);
        this.O.remove(Integer.valueOf(i));
      }
    }
  }
  
  public void cz(List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      int j = this.af.size();
      int i = 0;
      while (i < j)
      {
        int k = this.af.keyAt(i);
        if ((!kxm.dq(k)) && (!paramList.contains(Integer.valueOf(k)))) {
          localArrayList.add(Integer.valueOf(k));
        }
        i += 1;
      }
      paramList = localArrayList.iterator();
      while (paramList.hasNext())
      {
        i = ((Integer)paramList.next()).intValue();
        this.af.remove(i);
        this.O.remove(Integer.valueOf(i));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     liy
 * JD-Core Version:    0.7.0.1
 */