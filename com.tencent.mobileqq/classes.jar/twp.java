import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class twp
{
  private static final Comparator<twv> a = new twq();
  
  @NonNull
  public static tws a(@NonNull twr paramtwr)
  {
    return a(paramtwr, true);
  }
  
  @NonNull
  public static tws a(@NonNull twr paramtwr, boolean paramBoolean)
  {
    int i = paramtwr.a();
    int j = paramtwr.b();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new twu(0, i, 0, j));
    i = i + j + Math.abs(i - j);
    int[] arrayOfInt1 = new int[i * 2];
    int[] arrayOfInt2 = new int[i * 2];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      twu localtwu2 = (twu)localArrayList2.remove(localArrayList2.size() - 1);
      twv localtwv = a(paramtwr, localtwu2.jdField_a_of_type_Int, localtwu2.jdField_b_of_type_Int, localtwu2.c, localtwu2.d, arrayOfInt1, arrayOfInt2, i);
      if (localtwv != null)
      {
        if (localtwv.c > 0) {
          localArrayList1.add(localtwv);
        }
        localtwv.jdField_a_of_type_Int += localtwu2.jdField_a_of_type_Int;
        localtwv.jdField_b_of_type_Int += localtwu2.c;
        twu localtwu1;
        if (localArrayList3.isEmpty())
        {
          localtwu1 = new twu();
          label217:
          localtwu1.jdField_a_of_type_Int = localtwu2.jdField_a_of_type_Int;
          localtwu1.c = localtwu2.c;
          if (!localtwv.jdField_b_of_type_Boolean) {
            break label362;
          }
          localtwu1.jdField_b_of_type_Int = localtwv.jdField_a_of_type_Int;
          localtwu1.d = localtwv.jdField_b_of_type_Int;
          label265:
          localArrayList2.add(localtwu1);
          if (!localtwv.jdField_b_of_type_Boolean) {
            break label457;
          }
          if (!localtwv.jdField_a_of_type_Boolean) {
            break label420;
          }
          localtwu2.jdField_a_of_type_Int = (localtwv.jdField_a_of_type_Int + localtwv.c + 1);
          localtwu2.c = (localtwv.jdField_b_of_type_Int + localtwv.c);
        }
        for (;;)
        {
          localArrayList2.add(localtwu2);
          break;
          localtwu1 = (twu)localArrayList3.remove(localArrayList3.size() - 1);
          break label217;
          label362:
          if (localtwv.jdField_a_of_type_Boolean)
          {
            localtwu1.jdField_b_of_type_Int = (localtwv.jdField_a_of_type_Int - 1);
            localtwu1.d = localtwv.jdField_b_of_type_Int;
            break label265;
          }
          localtwu1.jdField_b_of_type_Int = localtwv.jdField_a_of_type_Int;
          localtwu1.d = (localtwv.jdField_b_of_type_Int - 1);
          break label265;
          label420:
          localtwu2.jdField_a_of_type_Int = (localtwv.jdField_a_of_type_Int + localtwv.c);
          localtwu2.c = (localtwv.jdField_b_of_type_Int + localtwv.c + 1);
          continue;
          label457:
          localtwu2.jdField_a_of_type_Int = (localtwv.jdField_a_of_type_Int + localtwv.c);
          localtwu2.c = (localtwv.jdField_b_of_type_Int + localtwv.c);
        }
      }
      localArrayList3.add(localtwu2);
    }
    Collections.sort(localArrayList1, a);
    return new tws(paramtwr, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  private static twv a(twr paramtwr, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
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
          while ((k < m) && (paramInt2 < n) && (paramtwr.a(paramInt1 + k, paramInt3 + paramInt2)))
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
          paramtwr = new twv();
          paramtwr.jdField_a_of_type_Int = paramArrayOfInt2[(paramInt5 + j)];
          paramtwr.jdField_b_of_type_Int = (paramtwr.jdField_a_of_type_Int - j);
          paramtwr.c = (paramArrayOfInt1[(paramInt5 + j)] - paramArrayOfInt2[(paramInt5 + j)]);
          paramtwr.jdField_a_of_type_Boolean = bool;
          paramtwr.jdField_b_of_type_Boolean = false;
          return paramtwr;
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
          while ((k > 0) && (paramInt2 > 0) && (paramtwr.a(paramInt1 + k - 1, paramInt3 + paramInt2 - 1)))
          {
            k -= 1;
            paramInt2 -= 1;
          }
          paramInt2 = paramArrayOfInt2[(paramInt5 + i3 + 1)] - 1;
        }
        paramArrayOfInt2[(paramInt5 + i3)] = k;
        if ((paramInt4 == 0) && (j + i1 >= -i) && (j + i1 <= i) && (paramArrayOfInt1[(paramInt5 + i3)] >= paramArrayOfInt2[(paramInt5 + i3)]))
        {
          paramtwr = new twv();
          paramtwr.jdField_a_of_type_Int = paramArrayOfInt2[(paramInt5 + i3)];
          paramtwr.jdField_b_of_type_Int = (paramtwr.jdField_a_of_type_Int - i3);
          paramtwr.c = (paramArrayOfInt1[(paramInt5 + i3)] - paramArrayOfInt2[(paramInt5 + i3)]);
          paramtwr.jdField_a_of_type_Boolean = bool;
          paramtwr.jdField_b_of_type_Boolean = true;
          return paramtwr;
        }
        j += 2;
      }
      i += 1;
    }
    label664:
    throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     twp
 * JD-Core Version:    0.7.0.1
 */