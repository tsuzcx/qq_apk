import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ure
{
  private static final Comparator<urk> a = new urf();
  
  @NonNull
  public static urh a(@NonNull urg paramurg)
  {
    return a(paramurg, true);
  }
  
  @NonNull
  public static urh a(@NonNull urg paramurg, boolean paramBoolean)
  {
    int i = paramurg.a();
    int j = paramurg.b();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new urj(0, i, 0, j));
    i = i + j + Math.abs(i - j);
    int[] arrayOfInt1 = new int[i * 2];
    int[] arrayOfInt2 = new int[i * 2];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      urj localurj2 = (urj)localArrayList2.remove(localArrayList2.size() - 1);
      urk localurk = a(paramurg, localurj2.jdField_a_of_type_Int, localurj2.jdField_b_of_type_Int, localurj2.c, localurj2.d, arrayOfInt1, arrayOfInt2, i);
      if (localurk != null)
      {
        if (localurk.c > 0) {
          localArrayList1.add(localurk);
        }
        localurk.jdField_a_of_type_Int += localurj2.jdField_a_of_type_Int;
        localurk.jdField_b_of_type_Int += localurj2.c;
        urj localurj1;
        if (localArrayList3.isEmpty())
        {
          localurj1 = new urj();
          label217:
          localurj1.jdField_a_of_type_Int = localurj2.jdField_a_of_type_Int;
          localurj1.c = localurj2.c;
          if (!localurk.jdField_b_of_type_Boolean) {
            break label362;
          }
          localurj1.jdField_b_of_type_Int = localurk.jdField_a_of_type_Int;
          localurj1.d = localurk.jdField_b_of_type_Int;
          label265:
          localArrayList2.add(localurj1);
          if (!localurk.jdField_b_of_type_Boolean) {
            break label457;
          }
          if (!localurk.jdField_a_of_type_Boolean) {
            break label420;
          }
          localurj2.jdField_a_of_type_Int = (localurk.jdField_a_of_type_Int + localurk.c + 1);
          localurj2.c = (localurk.jdField_b_of_type_Int + localurk.c);
        }
        for (;;)
        {
          localArrayList2.add(localurj2);
          break;
          localurj1 = (urj)localArrayList3.remove(localArrayList3.size() - 1);
          break label217;
          label362:
          if (localurk.jdField_a_of_type_Boolean)
          {
            localurj1.jdField_b_of_type_Int = (localurk.jdField_a_of_type_Int - 1);
            localurj1.d = localurk.jdField_b_of_type_Int;
            break label265;
          }
          localurj1.jdField_b_of_type_Int = localurk.jdField_a_of_type_Int;
          localurj1.d = (localurk.jdField_b_of_type_Int - 1);
          break label265;
          label420:
          localurj2.jdField_a_of_type_Int = (localurk.jdField_a_of_type_Int + localurk.c);
          localurj2.c = (localurk.jdField_b_of_type_Int + localurk.c + 1);
          continue;
          label457:
          localurj2.jdField_a_of_type_Int = (localurk.jdField_a_of_type_Int + localurk.c);
          localurj2.c = (localurk.jdField_b_of_type_Int + localurk.c);
        }
      }
      localArrayList3.add(localurj2);
    }
    Collections.sort(localArrayList1, a);
    return new urh(paramurg, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  private static urk a(urg paramurg, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
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
          while ((k < m) && (paramInt2 < n) && (paramurg.a(paramInt1 + k, paramInt3 + paramInt2)))
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
          paramurg = new urk();
          paramurg.jdField_a_of_type_Int = paramArrayOfInt2[(paramInt5 + j)];
          paramurg.jdField_b_of_type_Int = (paramurg.jdField_a_of_type_Int - j);
          paramurg.c = (paramArrayOfInt1[(paramInt5 + j)] - paramArrayOfInt2[(paramInt5 + j)]);
          paramurg.jdField_a_of_type_Boolean = bool;
          paramurg.jdField_b_of_type_Boolean = false;
          return paramurg;
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
          while ((k > 0) && (paramInt2 > 0) && (paramurg.a(paramInt1 + k - 1, paramInt3 + paramInt2 - 1)))
          {
            k -= 1;
            paramInt2 -= 1;
          }
          paramInt2 = paramArrayOfInt2[(paramInt5 + i3 + 1)] - 1;
        }
        paramArrayOfInt2[(paramInt5 + i3)] = k;
        if ((paramInt4 == 0) && (j + i1 >= -i) && (j + i1 <= i) && (paramArrayOfInt1[(paramInt5 + i3)] >= paramArrayOfInt2[(paramInt5 + i3)]))
        {
          paramurg = new urk();
          paramurg.jdField_a_of_type_Int = paramArrayOfInt2[(paramInt5 + i3)];
          paramurg.jdField_b_of_type_Int = (paramurg.jdField_a_of_type_Int - i3);
          paramurg.c = (paramArrayOfInt1[(paramInt5 + i3)] - paramArrayOfInt2[(paramInt5 + i3)]);
          paramurg.jdField_a_of_type_Boolean = bool;
          paramurg.jdField_b_of_type_Boolean = true;
          return paramurg;
        }
        j += 2;
      }
      i += 1;
    }
    label664:
    throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ure
 * JD-Core Version:    0.7.0.1
 */