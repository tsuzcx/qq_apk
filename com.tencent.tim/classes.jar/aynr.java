import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import java.util.ArrayList;

public class aynr
  implements TypeEvaluator<ArrayList<Integer>>
{
  private ArrayList<aynr.a> Gq = new ArrayList();
  private ArrayList<Integer> Gr = new ArrayList();
  private ArrayList<Integer> Gs = new ArrayList();
  private ArrayList<Integer> Gt = new ArrayList();
  private ArrayList<TimeInterpolator> Gu = new ArrayList();
  private long mTotalDuration;
  
  public int a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, TimeInterpolator paramTimeInterpolator)
  {
    int i = this.Gs.size();
    paramString = new aynr.a(paramLong1, paramLong2, i);
    this.Gq.add(paramString);
    this.Gs.add(Integer.valueOf(paramInt1));
    this.Gt.add(Integer.valueOf(paramInt2));
    this.Gu.add(paramTimeInterpolator);
    if (paramLong1 + paramLong2 > this.mTotalDuration) {
      this.mTotalDuration = (paramLong1 + paramLong2);
    }
    return i;
  }
  
  public ArrayList<Integer> a(float paramFloat, ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2)
  {
    if ((paramArrayList1.isEmpty()) || (paramArrayList2.isEmpty())) {
      return null;
    }
    if (paramArrayList1.size() != paramArrayList2.size()) {
      return null;
    }
    int j = paramArrayList1.size();
    if (this.Gr == null) {
      this.Gr = new ArrayList();
    }
    this.Gr.clear();
    int i = 0;
    if (i < j)
    {
      int k = ((Integer)paramArrayList1.get(i)).intValue();
      int m = ((Integer)paramArrayList2.get(i)).intValue();
      long l1 = ((aynr.a)this.Gq.get(i)).startTime;
      long l2 = ((aynr.a)this.Gq.get(i)).duration;
      int n = (int)((float)this.mTotalDuration * paramFloat);
      if (n < l1) {
        this.Gr.add(Integer.valueOf(0));
      }
      for (;;)
      {
        i += 1;
        break;
        if (n > l1 + l2)
        {
          this.Gr.add(Integer.valueOf(m));
        }
        else
        {
          float f1 = ((TimeInterpolator)this.Gu.get(i)).getInterpolation((float)(n - l1) / (float)l2);
          ArrayList localArrayList = this.Gr;
          float f2 = k;
          localArrayList.add(Integer.valueOf((int)(f1 * (m - k) + f2)));
        }
      }
    }
    return this.Gr;
  }
  
  public ArrayList<Integer> eP()
  {
    return this.Gt;
  }
  
  public ArrayList<Integer> eQ()
  {
    return this.Gs;
  }
  
  public long getDuration()
  {
    return this.mTotalDuration;
  }
  
  public ArrayList<Integer> s(long paramLong)
  {
    return a((float)paramLong / (float)this.mTotalDuration, this.Gs, this.Gt);
  }
  
  static class a
  {
    public long duration;
    public long index;
    public long startTime;
    
    public a(long paramLong1, long paramLong2, int paramInt)
    {
      this.startTime = paramLong1;
      this.duration = paramLong2;
      this.index = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aynr
 * JD-Core Version:    0.7.0.1
 */