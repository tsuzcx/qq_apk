import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class udh
{
  private static final Comparator<udn> a = new udi();
  
  @NonNull
  public static udk a(@NonNull udj paramudj)
  {
    return a(paramudj, true);
  }
  
  @NonNull
  public static udk a(@NonNull udj paramudj, boolean paramBoolean)
  {
    int i = paramudj.a();
    int j = paramudj.b();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new udm(0, i, 0, j));
    i = i + j + Math.abs(i - j);
    int[] arrayOfInt1 = new int[i * 2];
    int[] arrayOfInt2 = new int[i * 2];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      udm localudm2 = (udm)localArrayList2.remove(localArrayList2.size() - 1);
      udn localudn = a(paramudj, localudm2.jdField_a_of_type_Int, localudm2.jdField_b_of_type_Int, localudm2.c, localudm2.d, arrayOfInt1, arrayOfInt2, i);
      if (localudn != null)
      {
        if (localudn.c > 0) {
          localArrayList1.add(localudn);
        }
        localudn.jdField_a_of_type_Int += localudm2.jdField_a_of_type_Int;
        localudn.jdField_b_of_type_Int += localudm2.c;
        udm localudm1;
        if (localArrayList3.isEmpty())
        {
          localudm1 = new udm();
          label217:
          localudm1.jdField_a_of_type_Int = localudm2.jdField_a_of_type_Int;
          localudm1.c = localudm2.c;
          if (!localudn.jdField_b_of_type_Boolean) {
            break label362;
          }
          localudm1.jdField_b_of_type_Int = localudn.jdField_a_of_type_Int;
          localudm1.d = localudn.jdField_b_of_type_Int;
          label265:
          localArrayList2.add(localudm1);
          if (!localudn.jdField_b_of_type_Boolean) {
            break label457;
          }
          if (!localudn.jdField_a_of_type_Boolean) {
            break label420;
          }
          localudm2.jdField_a_of_type_Int = (localudn.jdField_a_of_type_Int + localudn.c + 1);
          localudm2.c = (localudn.jdField_b_of_type_Int + localudn.c);
        }
        for (;;)
        {
          localArrayList2.add(localudm2);
          break;
          localudm1 = (udm)localArrayList3.remove(localArrayList3.size() - 1);
          break label217;
          label362:
          if (localudn.jdField_a_of_type_Boolean)
          {
            localudm1.jdField_b_of_type_Int = (localudn.jdField_a_of_type_Int - 1);
            localudm1.d = localudn.jdField_b_of_type_Int;
            break label265;
          }
          localudm1.jdField_b_of_type_Int = localudn.jdField_a_of_type_Int;
          localudm1.d = (localudn.jdField_b_of_type_Int - 1);
          break label265;
          label420:
          localudm2.jdField_a_of_type_Int = (localudn.jdField_a_of_type_Int + localudn.c);
          localudm2.c = (localudn.jdField_b_of_type_Int + localudn.c + 1);
          continue;
          label457:
          localudm2.jdField_a_of_type_Int = (localudn.jdField_a_of_type_Int + localudn.c);
          localudm2.c = (localudn.jdField_b_of_type_Int + localudn.c);
        }
      }
      localArrayList3.add(localudm2);
    }
    Collections.sort(localArrayList1, a);
    return new udk(paramudj, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  private static udn a(udj paramudj, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
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
          while ((k < m) && (paramInt2 < n) && (paramudj.a(paramInt1 + k, paramInt3 + paramInt2)))
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
          paramudj = new udn();
          paramudj.jdField_a_of_type_Int = paramArrayOfInt2[(paramInt5 + j)];
          paramudj.jdField_b_of_type_Int = (paramudj.jdField_a_of_type_Int - j);
          paramudj.c = (paramArrayOfInt1[(paramInt5 + j)] - paramArrayOfInt2[(paramInt5 + j)]);
          paramudj.jdField_a_of_type_Boolean = bool;
          paramudj.jdField_b_of_type_Boolean = false;
          return paramudj;
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
          while ((k > 0) && (paramInt2 > 0) && (paramudj.a(paramInt1 + k - 1, paramInt3 + paramInt2 - 1)))
          {
            k -= 1;
            paramInt2 -= 1;
          }
          paramInt2 = paramArrayOfInt2[(paramInt5 + i3 + 1)] - 1;
        }
        paramArrayOfInt2[(paramInt5 + i3)] = k;
        if ((paramInt4 == 0) && (j + i1 >= -i) && (j + i1 <= i) && (paramArrayOfInt1[(paramInt5 + i3)] >= paramArrayOfInt2[(paramInt5 + i3)]))
        {
          paramudj = new udn();
          paramudj.jdField_a_of_type_Int = paramArrayOfInt2[(paramInt5 + i3)];
          paramudj.jdField_b_of_type_Int = (paramudj.jdField_a_of_type_Int - i3);
          paramudj.c = (paramArrayOfInt1[(paramInt5 + i3)] - paramArrayOfInt2[(paramInt5 + i3)]);
          paramudj.jdField_a_of_type_Boolean = bool;
          paramudj.jdField_b_of_type_Boolean = true;
          return paramudj;
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
 * Qualified Name:     udh
 * JD-Core Version:    0.7.0.1
 */