import android.graphics.Paint;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aiwn
{
  private aiwp b;
  private int dfv;
  private int dfw;
  @Deprecated
  public int mOffset;
  public int mType;
  public ArrayList<aiwp> xs;
  public ArrayList<aiwr> xt = new ArrayList();
  
  public aiwn(int paramInt1, int paramInt2, ArrayList<aiwp> paramArrayList)
  {
    this.mType = paramInt1;
    this.mOffset = paramInt2;
    this.xs = paramArrayList;
  }
  
  public int Ga()
  {
    return this.dfv;
  }
  
  public void a(aiwn paramaiwn)
  {
    this.mType = paramaiwn.mType;
    this.mOffset = paramaiwn.mOffset;
    if (this.xs == null) {
      this.xs = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = paramaiwn.xs.iterator();
      while (localIterator.hasNext())
      {
        aiwp localaiwp = (aiwp)localIterator.next();
        this.xs.add(localaiwp.a());
      }
      this.xs.clear();
    }
    this.dfv = paramaiwn.Ga();
    Log.d("Lyric", "copy -> mType : " + this.mType);
  }
  
  public void a(Paint paramPaint1, Paint paramPaint2, int paramInt)
  {
    a(paramPaint1, paramPaint2, paramInt, false, false);
  }
  
  public void a(Paint paramPaint1, Paint paramPaint2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.xt.clear();
    this.dfv = 0;
    if (this.xs != null)
    {
      Iterator localIterator = this.xs.iterator();
      while (localIterator.hasNext())
      {
        aiwp localaiwp = (aiwp)localIterator.next();
        localaiwp.a(paramPaint1, paramPaint2, paramInt, paramBoolean1, paramBoolean2);
        this.dfv += localaiwp.Ga();
        this.xt.addAll(localaiwp.xu);
      }
    }
  }
  
  public List<aiwp> fw()
  {
    return this.xs;
  }
  
  public int jdMethod_if(int paramInt)
  {
    return ig(paramInt);
  }
  
  public int ig(int paramInt)
  {
    if (paramInt < 0)
    {
      Log.w("Lyric", "findLineNoByStartTime -> illegal time");
      return -1;
    }
    if ((this.xs == null) || (this.xs.size() == 0))
    {
      Log.w("Lyric", "findLineNoByStartTime -> lyric is empty");
      return -1;
    }
    if ((this.b != null) && (this.b.mStartTime < paramInt) && (this.b.mStartTime + this.b.mDuration > paramInt)) {
      return this.dfw;
    }
    ArrayList localArrayList = this.xs;
    int k = localArrayList.size();
    int j = 0;
    if (j < k)
    {
      aiwp localaiwp = (aiwp)localArrayList.get(j);
      if (localaiwp == null) {}
      while (localaiwp.mStartTime <= paramInt)
      {
        j += 1;
        break;
      }
    }
    for (paramInt = j - 1;; paramInt = 0)
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      if (j == k) {}
      for (paramInt = k - 1;; paramInt = i)
      {
        this.dfw = paramInt;
        this.b = ((aiwp)localArrayList.get(paramInt));
        return paramInt;
      }
    }
  }
  
  public int ih(int paramInt)
  {
    int i;
    if (paramInt < 0)
    {
      Log.w("Lyric", "findEndLineByStartTime -> illegal time");
      i = 0;
      return i;
    }
    ArrayList localArrayList = this.xs;
    if (localArrayList == null)
    {
      Log.w("Lyric", "findEndLineByStartTime -> sentence data not found");
      return -1;
    }
    int k = localArrayList.size();
    int j = 0;
    if (j < k)
    {
      aiwp localaiwp = (aiwp)localArrayList.get(j);
      if (localaiwp == null) {}
      while (paramInt > localaiwp.mStartTime)
      {
        j += 1;
        break;
      }
    }
    for (paramInt = j - 1;; paramInt = 0)
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      if (j != k) {
        break;
      }
      return k - 1;
    }
  }
  
  public boolean isEmpty()
  {
    return (this.xs == null) || (this.xs.size() == 0);
  }
  
  public void reset()
  {
    this.b = null;
  }
  
  public int sK()
  {
    if (isEmpty()) {
      return 0;
    }
    aiwp localaiwp = (aiwp)this.xs.get(this.xs.size() - 1);
    long l = localaiwp.mStartTime;
    return (int)(localaiwp.mDuration + l);
  }
  
  public int size()
  {
    if (this.xs != null) {
      return this.xs.size();
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.xs == null) {
      return null;
    }
    int i = 0;
    while (i < this.xs.size())
    {
      aiwp localaiwp = (aiwp)this.xs.get(i);
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(localaiwp.mStartTime);
      localStringBuilder.append(":");
      localStringBuilder.append(localaiwp.mText);
      localStringBuilder.append(":");
      localStringBuilder.append(localaiwp.mDuration + localaiwp.mStartTime);
      localStringBuilder.append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiwn
 * JD-Core Version:    0.7.0.1
 */