import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class tws
{
  private final int jdField_a_of_type_Int;
  private final List<twv> jdField_a_of_type_JavaUtilList;
  private final twr jdField_a_of_type_Twr;
  private final boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private final int jdField_b_of_type_Int;
  private final int[] jdField_b_of_type_ArrayOfInt;
  
  tws(twr paramtwr, List<twv> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt1;
    this.jdField_b_of_type_ArrayOfInt = paramArrayOfInt2;
    Arrays.fill(this.jdField_a_of_type_ArrayOfInt, 0);
    Arrays.fill(this.jdField_b_of_type_ArrayOfInt, 0);
    this.jdField_a_of_type_Twr = paramtwr;
    this.jdField_a_of_type_Int = paramtwr.a();
    this.jdField_b_of_type_Int = paramtwr.b();
    this.jdField_a_of_type_Boolean = paramBoolean;
    a();
    b();
  }
  
  private static twt a(List<twt> paramList, int paramInt, boolean paramBoolean)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      twt localtwt2 = (twt)paramList.get(i);
      if ((localtwt2.jdField_a_of_type_Int == paramInt) && (localtwt2.jdField_a_of_type_Boolean == paramBoolean))
      {
        paramList.remove(i);
        paramInt = i;
        localtwt1 = localtwt2;
        if (paramInt >= paramList.size()) {
          break label123;
        }
        localtwt1 = (twt)paramList.get(paramInt);
        int j = localtwt1.jdField_b_of_type_Int;
        if (paramBoolean) {}
        for (i = 1;; i = -1)
        {
          localtwt1.jdField_b_of_type_Int = (i + j);
          paramInt += 1;
          break;
        }
      }
      i -= 1;
    }
    twt localtwt1 = null;
    label123:
    return localtwt1;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {}
    for (twv localtwv = null;; localtwv = (twv)this.jdField_a_of_type_JavaUtilList.get(0))
    {
      if ((localtwv == null) || (localtwv.jdField_a_of_type_Int != 0) || (localtwv.jdField_b_of_type_Int != 0))
      {
        localtwv = new twv();
        localtwv.jdField_a_of_type_Int = 0;
        localtwv.jdField_b_of_type_Int = 0;
        localtwv.jdField_a_of_type_Boolean = false;
        localtwv.c = 0;
        localtwv.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilList.add(0, localtwv);
      }
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ArrayOfInt[(paramInt1 - 1)] != 0) {
      return;
    }
    a(paramInt1, paramInt2, paramInt3, false);
  }
  
  private void a(List<twt> paramList, txg paramtxg, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_Boolean) {
      paramtxg.a(paramInt1, paramInt2);
    }
    do
    {
      return;
      paramInt2 -= 1;
    } while (paramInt2 < 0);
    int i = this.jdField_b_of_type_ArrayOfInt[(paramInt3 + paramInt2)] & 0x1F;
    Iterator localIterator;
    switch (i)
    {
    default: 
      throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
    case 0: 
      paramtxg.a(paramInt1, 1);
      localIterator = paramList.iterator();
    case 4: 
    case 8: 
      while (localIterator.hasNext())
      {
        twt localtwt = (twt)localIterator.next();
        localtwt.jdField_b_of_type_Int += 1;
        continue;
        int j = this.jdField_b_of_type_ArrayOfInt[(paramInt3 + paramInt2)] >> 5;
        paramtxg.c(a(paramList, j, true).jdField_b_of_type_Int, paramInt1);
        if (i == 4) {
          paramtxg.a(paramInt1, 1, this.jdField_a_of_type_Twr.a(j, paramInt3 + paramInt2));
        }
      }
    }
    for (;;)
    {
      paramInt2 -= 1;
      break;
      paramList.add(new twt(paramInt3 + paramInt2, paramInt1, false));
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
      twv localtwv = (twv)this.jdField_a_of_type_JavaUtilList.get(paramInt3);
      k = localtwv.jdField_a_of_type_Int;
      int n = localtwv.c;
      int i1 = localtwv.jdField_b_of_type_Int;
      int i2 = localtwv.c;
      if (paramBoolean)
      {
        paramInt2 -= 1;
        for (;;)
        {
          if (paramInt2 < k + n) {
            break label269;
          }
          if (this.jdField_a_of_type_Twr.a(paramInt2, j))
          {
            if (this.jdField_a_of_type_Twr.b(paramInt2, j)) {}
            for (paramInt1 = 8;; paramInt1 = 4)
            {
              this.jdField_b_of_type_ArrayOfInt[j] = (paramInt2 << 5 | 0x10);
              this.jdField_a_of_type_ArrayOfInt[paramInt2] = (paramInt1 | j << 5);
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
        if (this.jdField_a_of_type_Twr.a(j, paramInt2))
        {
          if (this.jdField_a_of_type_Twr.b(j, paramInt2)) {}
          for (paramInt3 = m;; paramInt3 = 4)
          {
            this.jdField_a_of_type_ArrayOfInt[(paramInt1 - 1)] = (paramInt2 << 5 | 0x10);
            this.jdField_b_of_type_ArrayOfInt[paramInt2] = (paramInt1 - 1 << 5 | paramInt3);
            return true;
          }
        }
        paramInt2 -= 1;
      }
      label269:
      paramInt2 = localtwv.jdField_a_of_type_Int;
      i = localtwv.jdField_b_of_type_Int;
      paramInt3 -= 1;
    }
    label289:
    return false;
  }
  
  private void b()
  {
    int j = this.jdField_a_of_type_Int;
    int i = this.jdField_b_of_type_Int;
    int k = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (k >= 0)
    {
      twv localtwv = (twv)this.jdField_a_of_type_JavaUtilList.get(k);
      int i2 = localtwv.jdField_a_of_type_Int;
      int i3 = localtwv.c;
      int n = localtwv.jdField_b_of_type_Int;
      int i1 = localtwv.c;
      int m;
      if (this.jdField_a_of_type_Boolean)
      {
        for (;;)
        {
          m = i;
          if (j <= i2 + i3) {
            break;
          }
          a(j, i, k);
          j -= 1;
        }
        while (m > n + i1)
        {
          b(j, m, k);
          m -= 1;
        }
      }
      i = 0;
      if (i < localtwv.c)
      {
        m = localtwv.jdField_a_of_type_Int + i;
        n = localtwv.jdField_b_of_type_Int + i;
        if (this.jdField_a_of_type_Twr.b(m, n)) {}
        for (j = 1;; j = 2)
        {
          this.jdField_a_of_type_ArrayOfInt[m] = (n << 5 | j);
          this.jdField_b_of_type_ArrayOfInt[n] = (j | m << 5);
          i += 1;
          break;
        }
      }
      j = localtwv.jdField_a_of_type_Int;
      i = localtwv.jdField_b_of_type_Int;
      k -= 1;
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_ArrayOfInt[(paramInt2 - 1)] != 0) {
      return;
    }
    a(paramInt1, paramInt2, paramInt3, true);
  }
  
  private void b(List<twt> paramList, txg paramtxg, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_Boolean) {
      paramtxg.b(paramInt1, paramInt2);
    }
    do
    {
      return;
      paramInt2 -= 1;
    } while (paramInt2 < 0);
    int i = this.jdField_a_of_type_ArrayOfInt[(paramInt3 + paramInt2)] & 0x1F;
    Object localObject;
    switch (i)
    {
    default: 
      throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
    case 0: 
      paramtxg.b(paramInt1 + paramInt2, 1);
      localObject = paramList.iterator();
    case 4: 
    case 8: 
      while (((Iterator)localObject).hasNext())
      {
        twt localtwt = (twt)((Iterator)localObject).next();
        localtwt.jdField_b_of_type_Int -= 1;
        continue;
        int j = this.jdField_a_of_type_ArrayOfInt[(paramInt3 + paramInt2)] >> 5;
        localObject = a(paramList, j, false);
        paramtxg.c(paramInt1 + paramInt2, ((twt)localObject).jdField_b_of_type_Int - 1);
        if (i == 4) {
          paramtxg.a(((twt)localObject).jdField_b_of_type_Int - 1, 1, this.jdField_a_of_type_Twr.a(paramInt3 + paramInt2, j));
        }
      }
    }
    for (;;)
    {
      paramInt2 -= 1;
      break;
      paramList.add(new twt(paramInt3 + paramInt2, paramInt1 + paramInt2, true));
    }
  }
  
  public void a(@NonNull RecyclerView.Adapter paramAdapter)
  {
    a(new twn(paramAdapter));
  }
  
  public void a(@NonNull txg paramtxg)
  {
    ArrayList localArrayList;
    int j;
    int k;
    int i;
    if ((paramtxg instanceof two))
    {
      paramtxg = (two)paramtxg;
      localArrayList = new ArrayList();
      j = this.jdField_a_of_type_Int;
      k = this.jdField_b_of_type_Int;
      i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    }
    for (;;)
    {
      if (i < 0) {
        break label234;
      }
      twv localtwv = (twv)this.jdField_a_of_type_JavaUtilList.get(i);
      int m = localtwv.c;
      int n = localtwv.jdField_a_of_type_Int + m;
      int i1 = localtwv.jdField_b_of_type_Int + m;
      if (n < j) {
        b(localArrayList, paramtxg, n, j - n, n);
      }
      if (i1 < k) {
        a(localArrayList, paramtxg, n, k - i1, i1);
      }
      j = m - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if ((this.jdField_a_of_type_ArrayOfInt[(localtwv.jdField_a_of_type_Int + j)] & 0x1F) == 2) {
            paramtxg.a(localtwv.jdField_a_of_type_Int + j, 1, this.jdField_a_of_type_Twr.a(localtwv.jdField_a_of_type_Int + j, localtwv.jdField_b_of_type_Int + j));
          }
          j -= 1;
          continue;
          paramtxg = new two(paramtxg);
          break;
        }
      }
      j = localtwv.jdField_a_of_type_Int;
      k = localtwv.jdField_b_of_type_Int;
      i -= 1;
    }
    label234:
    paramtxg.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tws
 * JD-Core Version:    0.7.0.1
 */