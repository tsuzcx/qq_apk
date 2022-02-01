import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class plb<T>
{
  private List<T> lR;
  private List<List<T>> mResult;
  private List<T> mc;
  
  private String a(long[] paramArrayOfLong, List<List<List<T>>> paramList, List<List<T>> paramList1)
  {
    int j = 0;
    String[] arrayOfString = new String[paramArrayOfLong.length];
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (List)paramList.next();
      arrayOfString[i] = ("k=" + i + ":");
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        List localList = (List)((Iterator)localObject).next();
        arrayOfString[i] = (arrayOfString[i] + "+" + String.valueOf(localList.size()));
      }
      i += 1;
    }
    paramArrayOfLong = Arrays.toString(paramArrayOfLong);
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.K_means", "kmeans run k=" + paramList1.size() + " sse : " + paramArrayOfLong + " temp=" + Arrays.toString(arrayOfString));
    paramList1 = "(k=" + paramList1.size() + " " + paramArrayOfLong + ");";
    paramArrayOfLong = (String)((psr)psx.a(10)).c("key_album_debug_sse", "");
    if (!TextUtils.isEmpty(paramArrayOfLong))
    {
      arrayOfString = paramArrayOfLong.split(";");
      paramArrayOfLong = "";
      i = j;
      for (;;)
      {
        paramList = paramArrayOfLong;
        if (i < arrayOfString.length)
        {
          paramArrayOfLong = arrayOfString[i] + paramArrayOfLong;
          if (i == 8) {
            paramList = paramArrayOfLong;
          }
        }
        else
        {
          return paramList1 + paramList;
        }
        i += 1;
      }
    }
    return paramList1;
  }
  
  private List<T> ai(List<List<T>> paramList)
  {
    if ((paramList == null) || (paramList.size() < 2)) {
      return this.mc;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      if (((List)paramList.get(i)).size() > 0) {
        localArrayList.add(a((List)paramList.get(i)));
      }
      for (;;)
      {
        i += 1;
        break;
        ram.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.kmeans", "点位置相同时，有空的堆出现");
      }
    }
    return localArrayList;
  }
  
  private T b(List<T> paramList)
  {
    int j = 0;
    long l2 = -1L;
    int i = 0;
    long l1;
    int k;
    label30:
    long l4;
    if (i < this.lR.size())
    {
      l1 = -1L;
      k = 0;
      if (k >= paramList.size()) {
        break label153;
      }
      l4 = a(paramList.get(k), this.lR.get(i));
      if (l4 == 0L) {
        l1 = -1L;
      }
    }
    label153:
    for (;;)
    {
      long l3 = l2;
      if (l1 > l2)
      {
        j = i;
        l3 = l1;
      }
      i += 1;
      l2 = l3;
      break;
      if (l1 >= 0L)
      {
        l3 = l1;
        if (l4 >= l1) {}
      }
      else
      {
        l3 = l4;
      }
      k += 1;
      l1 = l3;
      break label30;
      return this.lR.get(j);
    }
  }
  
  private List<List<T>> c(List<T> paramList1, List<T> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList2 == null) || (paramList2.size() < 2))
    {
      localArrayList.add(paramList1);
      return localArrayList;
    }
    int j = paramList2.size();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new ArrayList());
      i += 1;
    }
    j = 0;
    while (j < paramList1.size())
    {
      Object localObject = paramList1.get(j);
      i = 0;
      int k = 0;
      long l2;
      for (long l1 = -1L; i < paramList2.size(); l1 = l2)
      {
        long l3 = a(localObject, paramList2.get(i));
        if (l1 != -1L)
        {
          l2 = l1;
          if (l1 <= l3) {}
        }
        else
        {
          k = i;
          l2 = l3;
        }
        i += 1;
      }
      ((List)localArrayList.get(k)).add(localObject);
      j += 1;
    }
    return localArrayList;
  }
  
  private boolean e(List<T> paramList1, List<T> paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList1.size()) {
        break label57;
      }
      if (!b(paramList1.get(i), paramList2.get(i))) {
        break;
      }
      i += 1;
    }
    label57:
    return true;
  }
  
  protected abstract long a(T paramT1, T paramT2);
  
  protected abstract T a(List<T> paramList);
  
  public List<List<T>> a(int paramInt1, List<T> paramList, long[] paramArrayOfLong, int paramInt2)
  {
    this.mc = paramList;
    paramInt1 = 0;
    long l;
    if (paramInt1 < 50)
    {
      this.mResult = c(this.lR, this.mc);
      paramList = ai(this.mResult);
      if (!e(this.mc, paramList)) {}
    }
    else
    {
      l = 0L;
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 >= this.mResult.size()) {
        break label155;
      }
      paramList = (List)this.mResult.get(paramInt1);
      Object localObject = this.mc.get(paramInt1);
      int i = 0;
      for (;;)
      {
        if (i < paramList.size())
        {
          l += a(localObject, paramList.get(i));
          i += 1;
          continue;
          this.mc = paramList;
          paramInt1 += 1;
          break;
        }
      }
      paramInt1 += 1;
    }
    label155:
    if (paramArrayOfLong != null) {
      paramArrayOfLong[paramInt2] = l;
    }
    return this.mResult;
  }
  
  public List<List<T>> a(int paramInt1, long[] paramArrayOfLong, int paramInt2)
  {
    this.mc = new ArrayList();
    this.mc.add(this.lR.get(0));
    int i = 1;
    while (i < paramInt1)
    {
      Object localObject = b(this.mc);
      this.mc.add(localObject);
      i += 1;
    }
    this.mResult = a(paramInt1, this.mc, paramArrayOfLong, paramInt2);
    return this.mResult;
  }
  
  protected boolean aW(long paramLong)
  {
    return false;
  }
  
  public List<List<T>> b(List<T> paramList, String[] paramArrayOfString)
  {
    if (this.lR == null) {}
    this.lR = paramList;
    int i = Math.min(Math.min(this.lR.size() - 2, 20), sj());
    if (i > 0) {}
    ArrayList localArrayList;
    int j;
    for (;;)
    {
      paramList = new long[i];
      localArrayList = new ArrayList(i);
      j = 0;
      while (j < i)
      {
        localArrayList.add(a(j + 1, paramList, j));
        j += 1;
      }
      i = 1;
    }
    int i1 = (paramList.length - 1) / 2;
    int i2 = 1;
    int n = 0;
    int k = 0;
    if (k < paramList.length)
    {
      int m;
      if (k == 0)
      {
        j = i1;
        i = i2;
        m = n;
      }
      for (;;)
      {
        k += 1;
        n = m;
        i2 = i;
        i1 = j;
        break;
        if (aW(paramList[(k - 1)] - paramList[k]))
        {
          m = n;
          i = i2;
          j = i1;
          if (n != 0) {}
        }
        else
        {
          double d = (paramList[(k - 1)] - paramList[k]) / paramList[(k - 1)];
          if (((d < u()) || (aW(paramList[(k - 1)] - paramList[k]))) && (i2 != 0))
          {
            j = k - 1;
            i = 0;
            m = 1;
          }
          else
          {
            m = n;
            i = i2;
            j = i1;
            if (d > u())
            {
              i = 1;
              j = k - 1;
              m = n;
            }
          }
        }
      }
    }
    this.mResult = ((List)localArrayList.get(i1));
    paramList = a(paramList, localArrayList, this.mResult);
    if (paramArrayOfString != null) {
      paramArrayOfString[0] = paramList;
    }
    return this.mResult;
  }
  
  protected abstract boolean b(T paramT1, T paramT2);
  
  public void dK(List<T> paramList)
  {
    if (this.lR == null) {}
    this.lR = paramList;
  }
  
  protected int sj()
  {
    return 100;
  }
  
  protected int sk()
  {
    if (this.lR == null) {
      return 0;
    }
    return this.lR.size();
  }
  
  protected abstract double u();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     plb
 * JD-Core Version:    0.7.0.1
 */