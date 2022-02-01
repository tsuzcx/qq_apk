import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

final class aqou
{
  private static final Comparator<aqou.a> aj = new aqov();
  final List<aqoy.c> IS;
  @Nullable
  final TimingLogger jdField_a_of_type_AndroidUtilTimingLogger = null;
  @Nullable
  final aqoy.b[] jdField_a_of_type_ArrayOfAqoy$b;
  private final float[] dx = new float[3];
  final int[] mColors;
  final int[] mHistogram;
  
  aqou(int[] paramArrayOfInt, int paramInt, @Nullable aqoy.b[] paramArrayOfb)
  {
    this.jdField_a_of_type_ArrayOfAqoy$b = paramArrayOfb;
    paramArrayOfb = new int[32768];
    this.mHistogram = paramArrayOfb;
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      j = kn(paramArrayOfInt[i]);
      paramArrayOfInt[i] = j;
      paramArrayOfb[j] += 1;
      i += 1;
    }
    int j = 0;
    for (i = 0; j < paramArrayOfb.length; i = k)
    {
      if ((paramArrayOfb[j] > 0) && (mD(j))) {
        paramArrayOfb[j] = 0;
      }
      k = i;
      if (paramArrayOfb[j] > 0) {
        k = i + 1;
      }
      j += 1;
    }
    paramArrayOfInt = new int[i];
    this.mColors = paramArrayOfInt;
    j = 0;
    int m;
    for (int k = 0; j < paramArrayOfb.length; k = m)
    {
      m = k;
      if (paramArrayOfb[j] > 0)
      {
        paramArrayOfInt[k] = j;
        m = k + 1;
      }
      j += 1;
    }
    if (i <= paramInt)
    {
      this.IS = new ArrayList();
      i = paramArrayOfInt.length;
      paramInt = n;
      while (paramInt < i)
      {
        j = paramArrayOfInt[paramInt];
        this.IS.add(new aqoy.c(ko(j), paramArrayOfb[j]));
        paramInt += 1;
      }
    }
    this.IS = an(paramInt);
  }
  
  private void a(PriorityQueue<aqou.a> paramPriorityQueue, int paramInt)
  {
    while (paramPriorityQueue.size() < paramInt)
    {
      aqou.a locala = (aqou.a)paramPriorityQueue.poll();
      if ((locala == null) || (!locala.aFt())) {
        break;
      }
      paramPriorityQueue.offer(locala.a());
      paramPriorityQueue.offer(locala);
    }
  }
  
  static void a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return;
      int j;
      while (i <= paramInt3)
      {
        paramInt1 = paramArrayOfInt[i];
        paramInt2 = kq(paramInt1);
        j = kp(paramInt1);
        paramArrayOfInt[i] = (kr(paramInt1) | paramInt2 << 10 | j << 5);
        i += 1;
      }
      while (paramInt2 <= paramInt3)
      {
        paramInt1 = paramArrayOfInt[paramInt2];
        i = kr(paramInt1);
        j = kq(paramInt1);
        paramArrayOfInt[paramInt2] = (kp(paramInt1) | i << 10 | j << 5);
        paramInt2 += 1;
      }
    }
  }
  
  private boolean a(int paramInt, float[] paramArrayOfFloat)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (this.jdField_a_of_type_ArrayOfAqoy$b != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ArrayOfAqoy$b.length > 0)
      {
        j = this.jdField_a_of_type_ArrayOfAqoy$b.length;
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (!this.jdField_a_of_type_ArrayOfAqoy$b[i].b(paramInt, paramArrayOfFloat)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean a(aqoy.c paramc)
  {
    return a(paramc.Mo(), paramc.g());
  }
  
  private List<aqoy.c> an(int paramInt)
  {
    PriorityQueue localPriorityQueue = new PriorityQueue(paramInt, aj);
    localPriorityQueue.offer(new aqou.a(0, this.mColors.length - 1));
    a(localPriorityQueue, paramInt);
    return b(localPriorityQueue);
  }
  
  private List<aqoy.c> b(Collection<aqou.a> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      aqoy.c localc = ((aqou.a)paramCollection.next()).a();
      if (!a(localc)) {
        localArrayList.add(localc);
      }
    }
    return localArrayList;
  }
  
  private static int kn(int paramInt)
  {
    return t(Color.red(paramInt), 8, 5) << 10 | t(Color.green(paramInt), 8, 5) << 5 | t(Color.blue(paramInt), 8, 5);
  }
  
  private static int ko(int paramInt)
  {
    return s(kp(paramInt), kq(paramInt), kr(paramInt));
  }
  
  static int kp(int paramInt)
  {
    return paramInt >> 10 & 0x1F;
  }
  
  static int kq(int paramInt)
  {
    return paramInt >> 5 & 0x1F;
  }
  
  static int kr(int paramInt)
  {
    return paramInt & 0x1F;
  }
  
  private boolean mD(int paramInt)
  {
    paramInt = ko(paramInt);
    aqow.colorToHSL(paramInt, this.dx);
    return a(paramInt, this.dx);
  }
  
  static int s(int paramInt1, int paramInt2, int paramInt3)
  {
    return Color.rgb(t(paramInt1, 5, 8), t(paramInt2, 5, 8), t(paramInt3, 5, 8));
  }
  
  private static int t(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > paramInt2) {
      paramInt1 <<= paramInt3 - paramInt2;
    }
    for (;;)
    {
      return paramInt1 & (1 << paramInt3) - 1;
      paramInt1 >>= paramInt2 - paramInt3;
    }
  }
  
  List<aqoy.c> gH()
  {
    return this.IS;
  }
  
  class a
  {
    private int eaL;
    private int eaM;
    private int eaN;
    private int eaO;
    private int eaP;
    private int eaQ;
    private int eaR;
    private int eaS;
    private int eaT;
    
    a(int paramInt1, int paramInt2)
    {
      this.eaL = paramInt1;
      this.eaM = paramInt2;
      eeI();
    }
    
    final int Ml()
    {
      return this.eaM + 1 - this.eaL;
    }
    
    final int Mm()
    {
      int i = this.eaP - this.eaO;
      int j = this.eaR - this.eaQ;
      int k = this.eaT - this.eaS;
      if ((i >= j) && (i >= k)) {
        return -3;
      }
      if ((j >= i) && (j >= k)) {
        return -2;
      }
      return -1;
    }
    
    final int Mn()
    {
      int i = Mm();
      int[] arrayOfInt1 = aqou.this.mColors;
      int[] arrayOfInt2 = aqou.this.mHistogram;
      aqou.a(arrayOfInt1, i, this.eaL, this.eaM);
      Arrays.sort(arrayOfInt1, this.eaL, this.eaM + 1);
      aqou.a(arrayOfInt1, i, this.eaL, this.eaM);
      int k = this.eaN / 2;
      i = this.eaL;
      int j = 0;
      while (i <= this.eaM)
      {
        j += arrayOfInt2[arrayOfInt1[i]];
        if (j >= k) {
          return Math.min(this.eaM - 1, i);
        }
        i += 1;
      }
      return this.eaL;
    }
    
    final a a()
    {
      if (!aFt()) {
        throw new IllegalStateException("Can not split a box with only 1 color");
      }
      int i = Mn();
      a locala = new a(aqou.this, i + 1, this.eaM);
      this.eaM = i;
      eeI();
      return locala;
    }
    
    final aqoy.c a()
    {
      int n = 0;
      int[] arrayOfInt1 = aqou.this.mColors;
      int[] arrayOfInt2 = aqou.this.mHistogram;
      int m = this.eaL;
      int i = 0;
      int j = 0;
      int k = 0;
      while (m <= this.eaM)
      {
        int i1 = arrayOfInt1[m];
        int i2 = arrayOfInt2[i1];
        n += i2;
        k += aqou.kp(i1) * i2;
        j += aqou.kq(i1) * i2;
        i += aqou.kr(i1) * i2;
        m += 1;
      }
      return new aqoy.c(aqou.s(Math.round(k / n), Math.round(j / n), Math.round(i / n)), n);
    }
    
    final boolean aFt()
    {
      return Ml() > 1;
    }
    
    final void eeI()
    {
      int[] arrayOfInt1 = aqou.this.mColors;
      int[] arrayOfInt2 = aqou.this.mHistogram;
      int i5 = -2147483648;
      int i4 = 0;
      int m = this.eaL;
      int j = -2147483648;
      int i2 = 2147483647;
      int k = 2147483647;
      int i = 2147483647;
      int n = -2147483648;
      while (m <= this.eaM)
      {
        int i1 = arrayOfInt1[m];
        int i8 = i4 + arrayOfInt2[i1];
        int i6 = aqou.kp(i1);
        int i7 = aqou.kq(i1);
        i4 = aqou.kr(i1);
        i1 = i5;
        if (i6 > i5) {
          i1 = i6;
        }
        int i3 = i2;
        if (i6 < i2) {
          i3 = i6;
        }
        i2 = n;
        if (i7 > n) {
          i2 = i7;
        }
        i6 = k;
        if (i7 < k) {
          i6 = i7;
        }
        k = j;
        if (i4 > j) {
          k = i4;
        }
        i7 = i;
        if (i4 < i) {
          i7 = i4;
        }
        m += 1;
        i4 = i8;
        i5 = i1;
        n = i2;
        j = k;
        i2 = i3;
        k = i6;
        i = i7;
      }
      this.eaO = i2;
      this.eaP = i5;
      this.eaQ = k;
      this.eaR = n;
      this.eaS = i;
      this.eaT = j;
      this.eaN = i4;
    }
    
    final int getVolume()
    {
      return (this.eaP - this.eaO + 1) * (this.eaR - this.eaQ + 1) * (this.eaT - this.eaS + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqou
 * JD-Core Version:    0.7.0.1
 */