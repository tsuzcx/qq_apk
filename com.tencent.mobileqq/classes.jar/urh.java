import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class urh
{
  private final int jdField_a_of_type_Int;
  private final List<urk> jdField_a_of_type_JavaUtilList;
  private final urg jdField_a_of_type_Urg;
  private final boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private final int jdField_b_of_type_Int;
  private final int[] jdField_b_of_type_ArrayOfInt;
  
  urh(urg paramurg, List<urk> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt1;
    this.jdField_b_of_type_ArrayOfInt = paramArrayOfInt2;
    Arrays.fill(this.jdField_a_of_type_ArrayOfInt, 0);
    Arrays.fill(this.jdField_b_of_type_ArrayOfInt, 0);
    this.jdField_a_of_type_Urg = paramurg;
    this.jdField_a_of_type_Int = paramurg.a();
    this.jdField_b_of_type_Int = paramurg.b();
    this.jdField_a_of_type_Boolean = paramBoolean;
    a();
    b();
  }
  
  private static uri a(List<uri> paramList, int paramInt, boolean paramBoolean)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      uri localuri2 = (uri)paramList.get(i);
      if ((localuri2.jdField_a_of_type_Int == paramInt) && (localuri2.jdField_a_of_type_Boolean == paramBoolean))
      {
        paramList.remove(i);
        paramInt = i;
        localuri1 = localuri2;
        if (paramInt >= paramList.size()) {
          break label123;
        }
        localuri1 = (uri)paramList.get(paramInt);
        int j = localuri1.jdField_b_of_type_Int;
        if (paramBoolean) {}
        for (i = 1;; i = -1)
        {
          localuri1.jdField_b_of_type_Int = (i + j);
          paramInt += 1;
          break;
        }
      }
      i -= 1;
    }
    uri localuri1 = null;
    label123:
    return localuri1;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {}
    for (urk localurk = null;; localurk = (urk)this.jdField_a_of_type_JavaUtilList.get(0))
    {
      if ((localurk == null) || (localurk.jdField_a_of_type_Int != 0) || (localurk.jdField_b_of_type_Int != 0))
      {
        localurk = new urk();
        localurk.jdField_a_of_type_Int = 0;
        localurk.jdField_b_of_type_Int = 0;
        localurk.jdField_a_of_type_Boolean = false;
        localurk.c = 0;
        localurk.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilList.add(0, localurk);
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
  
  private void a(List<uri> paramList, uru paramuru, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_Boolean) {
      paramuru.a(paramInt1, paramInt2);
    }
    do
    {
      return;
      paramInt2 -= 1;
    } while (paramInt2 < 0);
    int i = this.jdField_b_of_type_ArrayOfInt[(paramInt3 + paramInt2)] & 0x1F;
    Object localObject;
    switch (i)
    {
    default: 
      throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
    case 0: 
      paramuru.a(paramInt1, 1);
      localObject = paramList.iterator();
    case 4: 
    case 8: 
      while (((Iterator)localObject).hasNext())
      {
        uri localuri = (uri)((Iterator)localObject).next();
        localuri.jdField_b_of_type_Int += 1;
        continue;
        int j = this.jdField_b_of_type_ArrayOfInt[(paramInt3 + paramInt2)] >> 5;
        localObject = a(paramList, j, true);
        if (localObject != null)
        {
          paramuru.c(((uri)localObject).jdField_b_of_type_Int, paramInt1);
          if (i == 4) {
            paramuru.a(paramInt1, 1, this.jdField_a_of_type_Urg.a(j, paramInt3 + paramInt2));
          }
        }
      }
    }
    for (;;)
    {
      paramInt2 -= 1;
      break;
      paramList.add(new uri(paramInt3 + paramInt2, paramInt1, false));
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
      urk localurk = (urk)this.jdField_a_of_type_JavaUtilList.get(paramInt3);
      k = localurk.jdField_a_of_type_Int;
      int n = localurk.c;
      int i1 = localurk.jdField_b_of_type_Int;
      int i2 = localurk.c;
      if (paramBoolean)
      {
        paramInt2 -= 1;
        for (;;)
        {
          if (paramInt2 < k + n) {
            break label269;
          }
          if (this.jdField_a_of_type_Urg.a(paramInt2, j))
          {
            if (this.jdField_a_of_type_Urg.b(paramInt2, j)) {}
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
        if (this.jdField_a_of_type_Urg.a(j, paramInt2))
        {
          if (this.jdField_a_of_type_Urg.b(j, paramInt2)) {}
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
      paramInt2 = localurk.jdField_a_of_type_Int;
      i = localurk.jdField_b_of_type_Int;
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
      urk localurk = (urk)this.jdField_a_of_type_JavaUtilList.get(k);
      int i2 = localurk.jdField_a_of_type_Int;
      int i3 = localurk.c;
      int n = localurk.jdField_b_of_type_Int;
      int i1 = localurk.c;
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
      if (i < localurk.c)
      {
        m = localurk.jdField_a_of_type_Int + i;
        n = localurk.jdField_b_of_type_Int + i;
        if (this.jdField_a_of_type_Urg.b(m, n)) {}
        for (j = 1;; j = 2)
        {
          this.jdField_a_of_type_ArrayOfInt[m] = (n << 5 | j);
          this.jdField_b_of_type_ArrayOfInt[n] = (j | m << 5);
          i += 1;
          break;
        }
      }
      j = localurk.jdField_a_of_type_Int;
      i = localurk.jdField_b_of_type_Int;
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
  
  private void b(List<uri> paramList, uru paramuru, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_Boolean) {
      paramuru.b(paramInt1, paramInt2);
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
      paramuru.b(paramInt1 + paramInt2, 1);
      localObject = paramList.iterator();
    case 4: 
    case 8: 
      while (((Iterator)localObject).hasNext())
      {
        uri localuri = (uri)((Iterator)localObject).next();
        localuri.jdField_b_of_type_Int -= 1;
        continue;
        int j = this.jdField_a_of_type_ArrayOfInt[(paramInt3 + paramInt2)] >> 5;
        localObject = a(paramList, j, false);
        if (localObject != null)
        {
          paramuru.c(paramInt1 + paramInt2, ((uri)localObject).jdField_b_of_type_Int - 1);
          if (i == 4) {
            paramuru.a(((uri)localObject).jdField_b_of_type_Int - 1, 1, this.jdField_a_of_type_Urg.a(paramInt3 + paramInt2, j));
          }
        }
      }
    }
    for (;;)
    {
      paramInt2 -= 1;
      break;
      paramList.add(new uri(paramInt3 + paramInt2, paramInt1 + paramInt2, true));
    }
  }
  
  public void a(@NonNull RecyclerView.Adapter paramAdapter)
  {
    a(new urc(paramAdapter));
  }
  
  public void a(@NonNull uru paramuru)
  {
    ArrayList localArrayList;
    int j;
    int k;
    int i;
    if ((paramuru instanceof urd))
    {
      paramuru = (urd)paramuru;
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
      urk localurk = (urk)this.jdField_a_of_type_JavaUtilList.get(i);
      int m = localurk.c;
      int n = localurk.jdField_a_of_type_Int + m;
      int i1 = localurk.jdField_b_of_type_Int + m;
      if (n < j) {
        b(localArrayList, paramuru, n, j - n, n);
      }
      if (i1 < k) {
        a(localArrayList, paramuru, i1, k - i1, i1);
      }
      j = m - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if ((this.jdField_a_of_type_ArrayOfInt[(localurk.jdField_a_of_type_Int + j)] & 0x1F) == 2) {
            paramuru.a(localurk.jdField_a_of_type_Int + j, 1, this.jdField_a_of_type_Urg.a(localurk.jdField_a_of_type_Int + j, localurk.jdField_b_of_type_Int + j));
          }
          j -= 1;
          continue;
          paramuru = new urd(paramuru);
          break;
        }
      }
      j = localurk.jdField_a_of_type_Int;
      k = localurk.jdField_b_of_type_Int;
      i -= 1;
    }
    label234:
    paramuru.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urh
 * JD-Core Version:    0.7.0.1
 */