import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class twu
{
  private final int jdField_a_of_type_Int;
  private final List<twx> jdField_a_of_type_JavaUtilList;
  private final twt jdField_a_of_type_Twt;
  private final boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private final int jdField_b_of_type_Int;
  private final int[] jdField_b_of_type_ArrayOfInt;
  
  twu(twt paramtwt, List<twx> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt1;
    this.jdField_b_of_type_ArrayOfInt = paramArrayOfInt2;
    Arrays.fill(this.jdField_a_of_type_ArrayOfInt, 0);
    Arrays.fill(this.jdField_b_of_type_ArrayOfInt, 0);
    this.jdField_a_of_type_Twt = paramtwt;
    this.jdField_a_of_type_Int = paramtwt.a();
    this.jdField_b_of_type_Int = paramtwt.b();
    this.jdField_a_of_type_Boolean = paramBoolean;
    a();
    b();
  }
  
  private static twv a(List<twv> paramList, int paramInt, boolean paramBoolean)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      twv localtwv2 = (twv)paramList.get(i);
      if ((localtwv2.jdField_a_of_type_Int == paramInt) && (localtwv2.jdField_a_of_type_Boolean == paramBoolean))
      {
        paramList.remove(i);
        paramInt = i;
        localtwv1 = localtwv2;
        if (paramInt >= paramList.size()) {
          break label123;
        }
        localtwv1 = (twv)paramList.get(paramInt);
        int j = localtwv1.jdField_b_of_type_Int;
        if (paramBoolean) {}
        for (i = 1;; i = -1)
        {
          localtwv1.jdField_b_of_type_Int = (i + j);
          paramInt += 1;
          break;
        }
      }
      i -= 1;
    }
    twv localtwv1 = null;
    label123:
    return localtwv1;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {}
    for (twx localtwx = null;; localtwx = (twx)this.jdField_a_of_type_JavaUtilList.get(0))
    {
      if ((localtwx == null) || (localtwx.jdField_a_of_type_Int != 0) || (localtwx.jdField_b_of_type_Int != 0))
      {
        localtwx = new twx();
        localtwx.jdField_a_of_type_Int = 0;
        localtwx.jdField_b_of_type_Int = 0;
        localtwx.jdField_a_of_type_Boolean = false;
        localtwx.c = 0;
        localtwx.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilList.add(0, localtwx);
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
  
  private void a(List<twv> paramList, txi paramtxi, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_Boolean) {
      paramtxi.a(paramInt1, paramInt2);
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
      paramtxi.a(paramInt1, 1);
      localIterator = paramList.iterator();
    case 4: 
    case 8: 
      while (localIterator.hasNext())
      {
        twv localtwv = (twv)localIterator.next();
        localtwv.jdField_b_of_type_Int += 1;
        continue;
        int j = this.jdField_b_of_type_ArrayOfInt[(paramInt3 + paramInt2)] >> 5;
        paramtxi.c(a(paramList, j, true).jdField_b_of_type_Int, paramInt1);
        if (i == 4) {
          paramtxi.a(paramInt1, 1, this.jdField_a_of_type_Twt.a(j, paramInt3 + paramInt2));
        }
      }
    }
    for (;;)
    {
      paramInt2 -= 1;
      break;
      paramList.add(new twv(paramInt3 + paramInt2, paramInt1, false));
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
      twx localtwx = (twx)this.jdField_a_of_type_JavaUtilList.get(paramInt3);
      k = localtwx.jdField_a_of_type_Int;
      int n = localtwx.c;
      int i1 = localtwx.jdField_b_of_type_Int;
      int i2 = localtwx.c;
      if (paramBoolean)
      {
        paramInt2 -= 1;
        for (;;)
        {
          if (paramInt2 < k + n) {
            break label269;
          }
          if (this.jdField_a_of_type_Twt.a(paramInt2, j))
          {
            if (this.jdField_a_of_type_Twt.b(paramInt2, j)) {}
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
        if (this.jdField_a_of_type_Twt.a(j, paramInt2))
        {
          if (this.jdField_a_of_type_Twt.b(j, paramInt2)) {}
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
      paramInt2 = localtwx.jdField_a_of_type_Int;
      i = localtwx.jdField_b_of_type_Int;
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
      twx localtwx = (twx)this.jdField_a_of_type_JavaUtilList.get(k);
      int i2 = localtwx.jdField_a_of_type_Int;
      int i3 = localtwx.c;
      int n = localtwx.jdField_b_of_type_Int;
      int i1 = localtwx.c;
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
      if (i < localtwx.c)
      {
        m = localtwx.jdField_a_of_type_Int + i;
        n = localtwx.jdField_b_of_type_Int + i;
        if (this.jdField_a_of_type_Twt.b(m, n)) {}
        for (j = 1;; j = 2)
        {
          this.jdField_a_of_type_ArrayOfInt[m] = (n << 5 | j);
          this.jdField_b_of_type_ArrayOfInt[n] = (j | m << 5);
          i += 1;
          break;
        }
      }
      j = localtwx.jdField_a_of_type_Int;
      i = localtwx.jdField_b_of_type_Int;
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
  
  private void b(List<twv> paramList, txi paramtxi, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_Boolean) {
      paramtxi.b(paramInt1, paramInt2);
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
      paramtxi.b(paramInt1 + paramInt2, 1);
      localObject = paramList.iterator();
    case 4: 
    case 8: 
      while (((Iterator)localObject).hasNext())
      {
        twv localtwv = (twv)((Iterator)localObject).next();
        localtwv.jdField_b_of_type_Int -= 1;
        continue;
        int j = this.jdField_a_of_type_ArrayOfInt[(paramInt3 + paramInt2)] >> 5;
        localObject = a(paramList, j, false);
        paramtxi.c(paramInt1 + paramInt2, ((twv)localObject).jdField_b_of_type_Int - 1);
        if (i == 4) {
          paramtxi.a(((twv)localObject).jdField_b_of_type_Int - 1, 1, this.jdField_a_of_type_Twt.a(paramInt3 + paramInt2, j));
        }
      }
    }
    for (;;)
    {
      paramInt2 -= 1;
      break;
      paramList.add(new twv(paramInt3 + paramInt2, paramInt1 + paramInt2, true));
    }
  }
  
  public void a(@NonNull RecyclerView.Adapter paramAdapter)
  {
    a(new twp(paramAdapter));
  }
  
  public void a(@NonNull txi paramtxi)
  {
    ArrayList localArrayList;
    int j;
    int k;
    int i;
    if ((paramtxi instanceof twq))
    {
      paramtxi = (twq)paramtxi;
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
      twx localtwx = (twx)this.jdField_a_of_type_JavaUtilList.get(i);
      int m = localtwx.c;
      int n = localtwx.jdField_a_of_type_Int + m;
      int i1 = localtwx.jdField_b_of_type_Int + m;
      if (n < j) {
        b(localArrayList, paramtxi, n, j - n, n);
      }
      if (i1 < k) {
        a(localArrayList, paramtxi, n, k - i1, i1);
      }
      j = m - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if ((this.jdField_a_of_type_ArrayOfInt[(localtwx.jdField_a_of_type_Int + j)] & 0x1F) == 2) {
            paramtxi.a(localtwx.jdField_a_of_type_Int + j, 1, this.jdField_a_of_type_Twt.a(localtwx.jdField_a_of_type_Int + j, localtwx.jdField_b_of_type_Int + j));
          }
          j -= 1;
          continue;
          paramtxi = new twq(paramtxi);
          break;
        }
      }
      j = localtwx.jdField_a_of_type_Int;
      k = localtwx.jdField_b_of_type_Int;
      i -= 1;
    }
    label234:
    paramtxi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     twu
 * JD-Core Version:    0.7.0.1
 */