import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class oat
{
  private static final Comparator<oat.e> t = new oau();
  
  @NonNull
  public static oat.b a(@NonNull oat.a parama)
  {
    return a(parama, true);
  }
  
  @NonNull
  public static oat.b a(@NonNull oat.a parama, boolean paramBoolean)
  {
    int i = parama.hV();
    int j = parama.hW();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new oat.d(0, i, 0, j));
    i = i + j + Math.abs(i - j);
    int[] arrayOfInt1 = new int[i * 2];
    int[] arrayOfInt2 = new int[i * 2];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      oat.d locald2 = (oat.d)localArrayList2.remove(localArrayList2.size() - 1);
      oat.e locale = a(parama, locald2.bdI, locald2.bdJ, locald2.bdK, locald2.bdL, arrayOfInt1, arrayOfInt2, i);
      if (locale != null)
      {
        if (locale.size > 0) {
          localArrayList1.add(locale);
        }
        locale.x += locald2.bdI;
        locale.y += locald2.bdK;
        oat.d locald1;
        if (localArrayList3.isEmpty())
        {
          locald1 = new oat.d();
          label217:
          locald1.bdI = locald2.bdI;
          locald1.bdK = locald2.bdK;
          if (!locale.reverse) {
            break label362;
          }
          locald1.bdJ = locale.x;
          locald1.bdL = locale.y;
          label265:
          localArrayList2.add(locald1);
          if (!locale.reverse) {
            break label457;
          }
          if (!locale.awb) {
            break label420;
          }
          locald2.bdI = (locale.x + locale.size + 1);
          locald2.bdK = (locale.y + locale.size);
        }
        for (;;)
        {
          localArrayList2.add(locald2);
          break;
          locald1 = (oat.d)localArrayList3.remove(localArrayList3.size() - 1);
          break label217;
          label362:
          if (locale.awb)
          {
            locald1.bdJ = (locale.x - 1);
            locald1.bdL = locale.y;
            break label265;
          }
          locald1.bdJ = locale.x;
          locald1.bdL = (locale.y - 1);
          break label265;
          label420:
          locald2.bdI = (locale.x + locale.size);
          locald2.bdK = (locale.y + locale.size + 1);
          continue;
          label457:
          locald2.bdI = (locale.x + locale.size);
          locald2.bdK = (locale.y + locale.size);
        }
      }
      localArrayList3.add(locald2);
    }
    Collections.sort(localArrayList1, t);
    return new oat.b(parama, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  private static oat.e a(oat.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
  {
    int m = paramInt2 - paramInt1;
    int n = paramInt4 - paramInt3;
    if ((paramInt2 - paramInt1 < 1) || (paramInt4 - paramInt3 < 1)) {
      return null;
    }
    int i1 = m - n;
    int i2 = (m + n + 1) / 2;
    Arrays.fill(paramArrayOfInt1, paramInt5 - i2 - 1, paramInt5 + i2 + 1, 0);
    Arrays.fill(paramArrayOfInt2, paramInt5 - i2 - 1 + i1, paramInt5 + i2 + 1 + i1, m);
    int i;
    if (i1 % 2 != 0)
    {
      paramInt4 = 1;
      i = 0;
    }
    for (;;)
    {
      if (i > i2) {
        break label664;
      }
      int j = -i;
      boolean bool;
      int k;
      for (;;)
      {
        if (j > i) {
          break label382;
        }
        if ((j == -i) || ((j != i) && (paramArrayOfInt1[(paramInt5 + j - 1)] < paramArrayOfInt1[(paramInt5 + j + 1)]))) {
          paramInt2 = paramArrayOfInt1[(paramInt5 + j + 1)];
        }
        for (bool = false;; bool = true)
        {
          k = paramInt2;
          paramInt2 -= j;
          while ((k < m) && (paramInt2 < n) && (parama.C(paramInt1 + k, paramInt3 + paramInt2)))
          {
            k += 1;
            paramInt2 += 1;
          }
          paramInt4 = 0;
          break;
          paramInt2 = paramArrayOfInt1[(paramInt5 + j - 1)] + 1;
        }
        paramArrayOfInt1[(paramInt5 + j)] = k;
        if ((paramInt4 != 0) && (j >= i1 - i + 1) && (j <= i1 + i - 1) && (paramArrayOfInt1[(paramInt5 + j)] >= paramArrayOfInt2[(paramInt5 + j)]))
        {
          parama = new oat.e();
          parama.x = paramArrayOfInt2[(paramInt5 + j)];
          parama.y = (parama.x - j);
          parama.size = (paramArrayOfInt1[(paramInt5 + j)] - paramArrayOfInt2[(paramInt5 + j)]);
          parama.awb = bool;
          parama.reverse = false;
          return parama;
        }
        j += 2;
      }
      label382:
      j = -i;
      while (j <= i)
      {
        int i3 = j + i1;
        if ((i3 == i + i1) || ((i3 != -i + i1) && (paramArrayOfInt2[(paramInt5 + i3 - 1)] < paramArrayOfInt2[(paramInt5 + i3 + 1)]))) {
          paramInt2 = paramArrayOfInt2[(paramInt5 + i3 - 1)];
        }
        for (bool = false;; bool = true)
        {
          k = paramInt2;
          paramInt2 -= i3;
          while ((k > 0) && (paramInt2 > 0) && (parama.C(paramInt1 + k - 1, paramInt3 + paramInt2 - 1)))
          {
            k -= 1;
            paramInt2 -= 1;
          }
          paramInt2 = paramArrayOfInt2[(paramInt5 + i3 + 1)] - 1;
        }
        paramArrayOfInt2[(paramInt5 + i3)] = k;
        if ((paramInt4 == 0) && (j + i1 >= -i) && (j + i1 <= i) && (paramArrayOfInt1[(paramInt5 + i3)] >= paramArrayOfInt2[(paramInt5 + i3)]))
        {
          parama = new oat.e();
          parama.x = paramArrayOfInt2[(paramInt5 + i3)];
          parama.y = (parama.x - i3);
          parama.size = (paramArrayOfInt1[(paramInt5 + i3)] - paramArrayOfInt2[(paramInt5 + i3)]);
          parama.awb = bool;
          parama.reverse = true;
          return parama;
        }
        j += 2;
      }
      i += 1;
    }
    label664:
    throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
  }
  
  public static abstract class a
  {
    public abstract boolean C(int paramInt1, int paramInt2);
    
    public abstract boolean D(int paramInt1, int paramInt2);
    
    @Nullable
    public Object a(int paramInt1, int paramInt2)
    {
      return null;
    }
    
    public abstract int hV();
    
    public abstract int hW();
  }
  
  public static class b
  {
    private final oat.a a;
    private final boolean awa;
    private final int bdF;
    private final int bdG;
    private final int[] dD;
    private final int[] dE;
    private final List<oat.e> kP;
    
    b(oat.a parama, List<oat.e> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
    {
      this.kP = paramList;
      this.dD = paramArrayOfInt1;
      this.dE = paramArrayOfInt2;
      Arrays.fill(this.dD, 0);
      Arrays.fill(this.dE, 0);
      this.a = parama;
      this.bdF = parama.hV();
      this.bdG = parama.hW();
      this.awa = paramBoolean;
      bcW();
      bcX();
    }
    
    private void U(int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.dD[(paramInt1 - 1)] != 0) {
        return;
      }
      a(paramInt1, paramInt2, paramInt3, false);
    }
    
    private void V(int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.dE[(paramInt2 - 1)] != 0) {
        return;
      }
      a(paramInt1, paramInt2, paramInt3, true);
    }
    
    private static oat.c a(List<oat.c> paramList, int paramInt, boolean paramBoolean)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        oat.c localc2 = (oat.c)paramList.get(i);
        if ((localc2.bdH == paramInt) && (localc2.awb == paramBoolean))
        {
          paramList.remove(i);
          paramInt = i;
          localc1 = localc2;
          if (paramInt >= paramList.size()) {
            break label123;
          }
          localc1 = (oat.c)paramList.get(paramInt);
          int j = localc1.currentPos;
          if (paramBoolean) {}
          for (i = 1;; i = -1)
          {
            localc1.currentPos = (i + j);
            paramInt += 1;
            break;
          }
        }
        i -= 1;
      }
      oat.c localc1 = null;
      label123:
      return localc1;
    }
    
    private void a(List<oat.c> paramList, obb paramobb, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!this.awa) {
        paramobb.du(paramInt1, paramInt2);
      }
      do
      {
        return;
        paramInt2 -= 1;
      } while (paramInt2 < 0);
      int i = this.dE[(paramInt3 + paramInt2)] & 0x1F;
      Iterator localIterator;
      switch (i)
      {
      default: 
        throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
      case 0: 
        paramobb.du(paramInt1, 1);
        localIterator = paramList.iterator();
      case 4: 
      case 8: 
        while (localIterator.hasNext())
        {
          oat.c localc = (oat.c)localIterator.next();
          localc.currentPos += 1;
          continue;
          int j = this.dE[(paramInt3 + paramInt2)] >> 5;
          paramobb.dw(a(paramList, j, true).currentPos, paramInt1);
          if (i == 4) {
            paramobb.c(paramInt1, 1, this.a.a(j, paramInt3 + paramInt2));
          }
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        paramList.add(new oat.c(paramInt3 + paramInt2, paramInt1, false));
      }
    }
    
    private boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      int m = 8;
      int j;
      int k;
      int i;
      if (paramBoolean)
      {
        j = paramInt2 - 1;
        k = paramInt2 - 1;
        i = paramInt1;
        paramInt2 = j;
        j = k;
        k = i;
        i = paramInt2;
        paramInt2 = k;
      }
      for (;;)
      {
        if (paramInt3 < 0) {
          break label289;
        }
        oat.e locale = (oat.e)this.kP.get(paramInt3);
        k = locale.x;
        int n = locale.size;
        int i1 = locale.y;
        int i2 = locale.size;
        if (paramBoolean)
        {
          paramInt2 -= 1;
          for (;;)
          {
            if (paramInt2 < k + n) {
              break label269;
            }
            if (this.a.C(paramInt2, j))
            {
              if (this.a.D(paramInt2, j)) {}
              for (paramInt1 = 8;; paramInt1 = 4)
              {
                this.dE[j] = (paramInt2 << 5 | 0x10);
                this.dD[paramInt2] = (paramInt1 | j << 5);
                return true;
                j = paramInt1 - 1;
                i = paramInt1 - 1;
                break;
              }
            }
            paramInt2 -= 1;
          }
        }
        paramInt2 = i - 1;
        while (paramInt2 >= i1 + i2)
        {
          if (this.a.C(j, paramInt2))
          {
            if (this.a.D(j, paramInt2)) {}
            for (paramInt3 = m;; paramInt3 = 4)
            {
              this.dD[(paramInt1 - 1)] = (paramInt2 << 5 | 0x10);
              this.dE[paramInt2] = (paramInt1 - 1 << 5 | paramInt3);
              return true;
            }
          }
          paramInt2 -= 1;
        }
        label269:
        paramInt2 = locale.x;
        i = locale.y;
        paramInt3 -= 1;
      }
      label289:
      return false;
    }
    
    private void b(List<oat.c> paramList, obb paramobb, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!this.awa) {
        paramobb.dv(paramInt1, paramInt2);
      }
      do
      {
        return;
        paramInt2 -= 1;
      } while (paramInt2 < 0);
      int i = this.dD[(paramInt3 + paramInt2)] & 0x1F;
      Object localObject;
      switch (i)
      {
      default: 
        throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
      case 0: 
        paramobb.dv(paramInt1 + paramInt2, 1);
        localObject = paramList.iterator();
      case 4: 
      case 8: 
        while (((Iterator)localObject).hasNext())
        {
          oat.c localc = (oat.c)((Iterator)localObject).next();
          localc.currentPos -= 1;
          continue;
          int j = this.dD[(paramInt3 + paramInt2)] >> 5;
          localObject = a(paramList, j, false);
          paramobb.dw(paramInt1 + paramInt2, ((oat.c)localObject).currentPos - 1);
          if (i == 4) {
            paramobb.c(((oat.c)localObject).currentPos - 1, 1, this.a.a(paramInt3 + paramInt2, j));
          }
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        paramList.add(new oat.c(paramInt3 + paramInt2, paramInt1 + paramInt2, true));
      }
    }
    
    private void bcW()
    {
      if (this.kP.isEmpty()) {}
      for (oat.e locale = null;; locale = (oat.e)this.kP.get(0))
      {
        if ((locale == null) || (locale.x != 0) || (locale.y != 0))
        {
          locale = new oat.e();
          locale.x = 0;
          locale.y = 0;
          locale.awb = false;
          locale.size = 0;
          locale.reverse = false;
          this.kP.add(0, locale);
        }
        return;
      }
    }
    
    private void bcX()
    {
      int j = this.bdF;
      int i = this.bdG;
      int k = this.kP.size() - 1;
      while (k >= 0)
      {
        oat.e locale = (oat.e)this.kP.get(k);
        int i2 = locale.x;
        int i3 = locale.size;
        int n = locale.y;
        int i1 = locale.size;
        int m;
        if (this.awa)
        {
          for (;;)
          {
            m = i;
            if (j <= i2 + i3) {
              break;
            }
            U(j, i, k);
            j -= 1;
          }
          while (m > n + i1)
          {
            V(j, m, k);
            m -= 1;
          }
        }
        i = 0;
        if (i < locale.size)
        {
          m = locale.x + i;
          n = locale.y + i;
          if (this.a.D(m, n)) {}
          for (j = 1;; j = 2)
          {
            this.dD[m] = (n << 5 | j);
            this.dE[n] = (j | m << 5);
            i += 1;
            break;
          }
        }
        j = locale.x;
        i = locale.y;
        k -= 1;
      }
    }
    
    public void a(@NonNull RecyclerView.Adapter paramAdapter)
    {
      a(new oar(paramAdapter));
    }
    
    public void a(@NonNull obb paramobb)
    {
      ArrayList localArrayList;
      int j;
      int k;
      int i;
      if ((paramobb instanceof oas))
      {
        paramobb = (oas)paramobb;
        localArrayList = new ArrayList();
        j = this.bdF;
        k = this.bdG;
        i = this.kP.size() - 1;
      }
      for (;;)
      {
        if (i < 0) {
          break label234;
        }
        oat.e locale = (oat.e)this.kP.get(i);
        int m = locale.size;
        int n = locale.x + m;
        int i1 = locale.y + m;
        if (n < j) {
          b(localArrayList, paramobb, n, j - n, n);
        }
        if (i1 < k) {
          a(localArrayList, paramobb, n, k - i1, i1);
        }
        j = m - 1;
        for (;;)
        {
          if (j >= 0)
          {
            if ((this.dD[(locale.x + j)] & 0x1F) == 2) {
              paramobb.c(locale.x + j, 1, this.a.a(locale.x + j, locale.y + j));
            }
            j -= 1;
            continue;
            paramobb = new oas(paramobb);
            break;
          }
        }
        j = locale.x;
        k = locale.y;
        i -= 1;
      }
      label234:
      paramobb.bcV();
    }
  }
  
  static class c
  {
    boolean awb;
    int bdH;
    int currentPos;
    
    public c(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.bdH = paramInt1;
      this.currentPos = paramInt2;
      this.awb = paramBoolean;
    }
  }
  
  static class d
  {
    int bdI;
    int bdJ;
    int bdK;
    int bdL;
    
    public d() {}
    
    public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.bdI = paramInt1;
      this.bdJ = paramInt2;
      this.bdK = paramInt3;
      this.bdL = paramInt4;
    }
  }
  
  static class e
  {
    boolean awb;
    boolean reverse;
    int size;
    int x;
    int y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oat
 * JD-Core Version:    0.7.0.1
 */