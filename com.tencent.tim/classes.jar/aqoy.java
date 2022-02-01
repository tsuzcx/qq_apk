import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class aqoy
{
  static final aqoy.b jdField_a_of_type_Aqoy$b = new aqoz();
  private final List<aqoy.c> IT;
  private final List<aqpb> IU;
  @Nullable
  private final aqoy.c jdField_a_of_type_Aqoy$c;
  private final aqpa<aqpb, aqoy.c> jdField_a_of_type_Aqpa;
  private final SparseBooleanArray q;
  
  aqoy(List<aqoy.c> paramList, List<aqpb> paramList1)
  {
    this.IT = paramList;
    this.IU = paramList1;
    this.q = new SparseBooleanArray();
    this.jdField_a_of_type_Aqpa = new aqpa();
    this.jdField_a_of_type_Aqoy$c = c();
  }
  
  private float a(aqoy.c paramc, aqpb paramaqpb)
  {
    float f3 = 0.0F;
    float[] arrayOfFloat = paramc.g();
    int i;
    if (this.jdField_a_of_type_Aqoy$c != null)
    {
      i = this.jdField_a_of_type_Aqoy$c.Mp();
      if (paramaqpb.bI() <= 0.0F) {
        break label135;
      }
      f1 = paramaqpb.bI();
    }
    label135:
    for (float f1 = (1.0F - Math.abs(arrayOfFloat[1] - paramaqpb.bD())) * f1;; f1 = 0.0F)
    {
      if (paramaqpb.bJ() > 0.0F) {
        f2 = paramaqpb.bJ();
      }
      for (float f2 = (1.0F - Math.abs(arrayOfFloat[2] - paramaqpb.bG())) * f2;; f2 = 0.0F)
      {
        if (paramaqpb.bK() > 0.0F) {
          f3 = paramaqpb.bK() * (paramc.Mp() / i);
        }
        return f1 + f2 + f3;
        i = 1;
        break;
      }
    }
  }
  
  @NonNull
  public static aqoy.a a(@NonNull Bitmap paramBitmap)
  {
    return new aqoy.a(paramBitmap);
  }
  
  @Nullable
  private aqoy.c a(aqpb paramaqpb)
  {
    aqoy.c localc = b(paramaqpb);
    if ((localc != null) && (paramaqpb.isExclusive())) {
      this.q.append(localc.Mo(), true);
    }
    return localc;
  }
  
  private boolean a(aqoy.c paramc, aqpb paramaqpb)
  {
    float[] arrayOfFloat = paramc.g();
    return (arrayOfFloat[1] >= paramaqpb.bC()) && (arrayOfFloat[1] <= paramaqpb.bE()) && (arrayOfFloat[2] >= paramaqpb.bF()) && (arrayOfFloat[2] <= paramaqpb.bH()) && (!this.q.get(paramc.Mo()));
  }
  
  @Nullable
  private aqoy.c b(aqpb paramaqpb)
  {
    float f1 = 0.0F;
    Object localObject = null;
    int j = this.IT.size();
    int i = 0;
    if (i < j)
    {
      aqoy.c localc = (aqoy.c)this.IT.get(i);
      if (!a(localc, paramaqpb)) {
        break label89;
      }
      float f2 = a(localc, paramaqpb);
      if ((localObject != null) && (f2 <= f1)) {
        break label89;
      }
      f1 = f2;
      localObject = localc;
    }
    label89:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  @Nullable
  private aqoy.c c()
  {
    int i = -2147483648;
    Object localObject = null;
    int k = this.IT.size();
    int j = 0;
    if (j < k)
    {
      aqoy.c localc = (aqoy.c)this.IT.get(j);
      if (localc.Mp() <= i) {
        break label67;
      }
      i = localc.Mp();
      localObject = localc;
    }
    label67:
    for (;;)
    {
      j += 1;
      break;
      return localObject;
    }
  }
  
  @Nullable
  public aqoy.c b()
  {
    return this.jdField_a_of_type_Aqoy$c;
  }
  
  void generate()
  {
    int j = this.IU.size();
    int i = 0;
    while (i < j)
    {
      aqpb localaqpb = (aqpb)this.IU.get(i);
      localaqpb.eeL();
      this.jdField_a_of_type_Aqpa.put(localaqpb, a(localaqpb));
      i += 1;
    }
    this.q.clear();
  }
  
  public static final class a
  {
    @Nullable
    private final List<aqoy.c> IT;
    private final List<aqpb> IU = new ArrayList();
    @Nullable
    private Rect cI;
    private int eaU = 16;
    private int eaV = 12544;
    private int eaW = -1;
    @Nullable
    private final Bitmap mBitmap;
    private final List<aqoy.b> mFilters = new ArrayList();
    
    public a(@NonNull Bitmap paramBitmap)
    {
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        throw new IllegalArgumentException("Bitmap is not valid");
      }
      this.mFilters.add(aqoy.a);
      this.mBitmap = paramBitmap;
      this.IT = null;
      this.IU.add(aqpb.a);
      this.IU.add(aqpb.b);
      this.IU.add(aqpb.c);
      this.IU.add(aqpb.d);
      this.IU.add(aqpb.e);
      this.IU.add(aqpb.f);
    }
    
    private Bitmap V(Bitmap paramBitmap)
    {
      double d2 = -1.0D;
      int i;
      double d1;
      if (this.eaV > 0)
      {
        i = paramBitmap.getWidth() * paramBitmap.getHeight();
        d1 = d2;
        if (i > this.eaV) {
          d1 = Math.sqrt(this.eaV / i);
        }
      }
      while (d1 <= 0.0D)
      {
        return paramBitmap;
        d1 = d2;
        if (this.eaW > 0)
        {
          i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
          d1 = d2;
          if (i > this.eaW) {
            d1 = this.eaW / i;
          }
        }
      }
      return Bitmap.createScaledBitmap(paramBitmap, (int)Math.ceil(paramBitmap.getWidth() * d1), (int)Math.ceil(d1 * paramBitmap.getHeight()), false);
    }
    
    private int[] d(Bitmap paramBitmap)
    {
      int i = 0;
      int j = paramBitmap.getWidth();
      int k = paramBitmap.getHeight();
      int[] arrayOfInt = new int[j * k];
      paramBitmap.getPixels(arrayOfInt, 0, j, 0, 0, j, k);
      if (this.cI == null) {
        return arrayOfInt;
      }
      k = this.cI.width();
      int m = this.cI.height();
      paramBitmap = new int[k * m];
      while (i < m)
      {
        System.arraycopy(arrayOfInt, (this.cI.top + i) * j + this.cI.left, paramBitmap, i * k, k);
        i += 1;
      }
      return paramBitmap;
    }
    
    @NonNull
    public aqoy a()
    {
      Object localObject;
      if (this.mBitmap != null)
      {
        Bitmap localBitmap = V(this.mBitmap);
        if (0 != 0) {
          throw new NullPointerException();
        }
        localObject = this.cI;
        if ((localBitmap != this.mBitmap) && (localObject != null))
        {
          double d = localBitmap.getWidth() / this.mBitmap.getWidth();
          ((Rect)localObject).left = ((int)Math.floor(((Rect)localObject).left * d));
          ((Rect)localObject).top = ((int)Math.floor(((Rect)localObject).top * d));
          ((Rect)localObject).right = Math.min((int)Math.ceil(((Rect)localObject).right * d), localBitmap.getWidth());
          ((Rect)localObject).bottom = Math.min((int)Math.ceil(d * ((Rect)localObject).bottom), localBitmap.getHeight());
        }
        int[] arrayOfInt = d(localBitmap);
        int i = this.eaU;
        if (this.mFilters.isEmpty())
        {
          localObject = null;
          localObject = new aqou(arrayOfInt, i, (aqoy.b[])localObject);
          if (localBitmap != this.mBitmap) {
            localBitmap.recycle();
          }
          localObject = ((aqou)localObject).gH();
          if (0 != 0) {
            throw new NullPointerException();
          }
        }
      }
      for (;;)
      {
        localObject = new aqoy((List)localObject, this.IU);
        ((aqoy)localObject).generate();
        if (0 != 0) {
          throw new NullPointerException();
        }
        return localObject;
        localObject = (aqoy.b[])this.mFilters.toArray(new aqoy.b[this.mFilters.size()]);
        break;
        if (this.IT == null) {
          break label304;
        }
        localObject = this.IT;
      }
      label304:
      throw new AssertionError();
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean b(@ColorInt int paramInt, @NonNull float[] paramArrayOfFloat);
  }
  
  public static final class c
  {
    private boolean cVr;
    @Nullable
    private float[] dy;
    private final int eaN;
    private final int eaX;
    private final int eaY;
    private final int eaZ;
    private final int eba;
    private int ebb;
    private int ebc;
    
    public c(@ColorInt int paramInt1, int paramInt2)
    {
      this.eaX = Color.red(paramInt1);
      this.eaY = Color.green(paramInt1);
      this.eaZ = Color.blue(paramInt1);
      this.eba = paramInt1;
      this.eaN = paramInt2;
    }
    
    private void eeJ()
    {
      int j;
      if (!this.cVr)
      {
        i = aqow.calculateMinimumAlpha(-1, this.eba, 4.5F);
        j = aqow.calculateMinimumAlpha(-1, this.eba, 3.0F);
        if ((i != -1) && (j != -1))
        {
          this.ebc = aqow.setAlphaComponent(-1, i);
          this.ebb = aqow.setAlphaComponent(-1, j);
          this.cVr = true;
        }
      }
      else
      {
        return;
      }
      int m = aqow.calculateMinimumAlpha(-16777216, this.eba, 4.5F);
      int k = aqow.calculateMinimumAlpha(-16777216, this.eba, 3.0F);
      if ((m != -1) && (k != -1))
      {
        this.ebc = aqow.setAlphaComponent(-16777216, m);
        this.ebb = aqow.setAlphaComponent(-16777216, k);
        this.cVr = true;
        return;
      }
      if (i != -1)
      {
        i = aqow.setAlphaComponent(-1, i);
        this.ebc = i;
        if (j == -1) {
          break label175;
        }
      }
      label175:
      for (int i = aqow.setAlphaComponent(-1, j);; i = aqow.setAlphaComponent(-16777216, k))
      {
        this.ebb = i;
        this.cVr = true;
        return;
        i = aqow.setAlphaComponent(-16777216, m);
        break;
      }
    }
    
    @ColorInt
    public int Mo()
    {
      return this.eba;
    }
    
    public int Mp()
    {
      return this.eaN;
    }
    
    @ColorInt
    public int Mq()
    {
      eeJ();
      return this.ebb;
    }
    
    @ColorInt
    public int Mr()
    {
      eeJ();
      return this.ebc;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (c)paramObject;
      } while ((this.eaN == paramObject.eaN) && (this.eba == paramObject.eba));
      return false;
    }
    
    @NonNull
    public float[] g()
    {
      if (this.dy == null) {
        this.dy = new float[3];
      }
      aqow.RGBToHSL(this.eaX, this.eaY, this.eaZ, this.dy);
      return this.dy;
    }
    
    public int hashCode()
    {
      return this.eba * 31 + this.eaN;
    }
    
    @NonNull
    public String toString()
    {
      return getClass().getSimpleName() + " [RGB: #" + Integer.toHexString(Mo()) + ']' + " [HSL: " + Arrays.toString(g()) + ']' + " [Population: " + this.eaN + ']' + " [Title Text: #" + Integer.toHexString(Mq()) + ']' + " [Body Text: #" + Integer.toHexString(Mr()) + ']';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqoy
 * JD-Core Version:    0.7.0.1
 */