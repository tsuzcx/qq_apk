import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class twr
{
  private static final Comparator<twx> a = new tws();
  
  @NonNull
  public static twu a(@NonNull twt paramtwt)
  {
    return a(paramtwt, true);
  }
  
  @NonNull
  public static twu a(@NonNull twt paramtwt, boolean paramBoolean)
  {
    int i = paramtwt.a();
    int j = paramtwt.b();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new tww(0, i, 0, j));
    i = i + j + Math.abs(i - j);
    int[] arrayOfInt1 = new int[i * 2];
    int[] arrayOfInt2 = new int[i * 2];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      tww localtww2 = (tww)localArrayList2.remove(localArrayList2.size() - 1);
      twx localtwx = a(paramtwt, localtww2.jdField_a_of_type_Int, localtww2.jdField_b_of_type_Int, localtww2.c, localtww2.d, arrayOfInt1, arrayOfInt2, i);
      if (localtwx != null)
      {
        if (localtwx.c > 0) {
          localArrayList1.add(localtwx);
        }
        localtwx.jdField_a_of_type_Int += localtww2.jdField_a_of_type_Int;
        localtwx.jdField_b_of_type_Int += localtww2.c;
        tww localtww1;
        if (localArrayList3.isEmpty())
        {
          localtww1 = new tww();
          label217:
          localtww1.jdField_a_of_type_Int = localtww2.jdField_a_of_type_Int;
          localtww1.c = localtww2.c;
          if (!localtwx.jdField_b_of_type_Boolean) {
            break label362;
          }
          localtww1.jdField_b_of_type_Int = localtwx.jdField_a_of_type_Int;
          localtww1.d = localtwx.jdField_b_of_type_Int;
          label265:
          localArrayList2.add(localtww1);
          if (!localtwx.jdField_b_of_type_Boolean) {
            break label457;
          }
          if (!localtwx.jdField_a_of_type_Boolean) {
            break label420;
          }
          localtww2.jdField_a_of_type_Int = (localtwx.jdField_a_of_type_Int + localtwx.c + 1);
          localtww2.c = (localtwx.jdField_b_of_type_Int + localtwx.c);
        }
        for (;;)
        {
          localArrayList2.add(localtww2);
          break;
          localtww1 = (tww)localArrayList3.remove(localArrayList3.size() - 1);
          break label217;
          label362:
          if (localtwx.jdField_a_of_type_Boolean)
          {
            localtww1.jdField_b_of_type_Int = (localtwx.jdField_a_of_type_Int - 1);
            localtww1.d = localtwx.jdField_b_of_type_Int;
            break label265;
          }
          localtww1.jdField_b_of_type_Int = localtwx.jdField_a_of_type_Int;
          localtww1.d = (localtwx.jdField_b_of_type_Int - 1);
          break label265;
          label420:
          localtww2.jdField_a_of_type_Int = (localtwx.jdField_a_of_type_Int + localtwx.c);
          localtww2.c = (localtwx.jdField_b_of_type_Int + localtwx.c + 1);
          continue;
          label457:
          localtww2.jdField_a_of_type_Int = (localtwx.jdField_a_of_type_Int + localtwx.c);
          localtww2.c = (localtwx.jdField_b_of_type_Int + localtwx.c);
        }
      }
      localArrayList3.add(localtww2);
    }
    Collections.sort(localArrayList1, a);
    return new twu(paramtwt, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  private static twx a(twt paramtwt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
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
          while ((k < m) && (paramInt2 < n) && (paramtwt.a(paramInt1 + k, paramInt3 + paramInt2)))
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
          paramtwt = new twx();
          paramtwt.jdField_a_of_type_Int = paramArrayOfInt2[(paramInt5 + j)];
          paramtwt.jdField_b_of_type_Int = (paramtwt.jdField_a_of_type_Int - j);
          paramtwt.c = (paramArrayOfInt1[(paramInt5 + j)] - paramArrayOfInt2[(paramInt5 + j)]);
          paramtwt.jdField_a_of_type_Boolean = bool;
          paramtwt.jdField_b_of_type_Boolean = false;
          return paramtwt;
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
          while ((k > 0) && (paramInt2 > 0) && (paramtwt.a(paramInt1 + k - 1, paramInt3 + paramInt2 - 1)))
          {
            k -= 1;
            paramInt2 -= 1;
          }
          paramInt2 = paramArrayOfInt2[(paramInt5 + i3 + 1)] - 1;
        }
        paramArrayOfInt2[(paramInt5 + i3)] = k;
        if ((paramInt4 == 0) && (j + i1 >= -i) && (j + i1 <= i) && (paramArrayOfInt1[(paramInt5 + i3)] >= paramArrayOfInt2[(paramInt5 + i3)]))
        {
          paramtwt = new twx();
          paramtwt.jdField_a_of_type_Int = paramArrayOfInt2[(paramInt5 + i3)];
          paramtwt.jdField_b_of_type_Int = (paramtwt.jdField_a_of_type_Int - i3);
          paramtwt.c = (paramArrayOfInt1[(paramInt5 + i3)] - paramArrayOfInt2[(paramInt5 + i3)]);
          paramtwt.jdField_a_of_type_Boolean = bool;
          paramtwt.jdField_b_of_type_Boolean = true;
          return paramtwt;
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
 * Qualified Name:     twr
 * JD-Core Version:    0.7.0.1
 */