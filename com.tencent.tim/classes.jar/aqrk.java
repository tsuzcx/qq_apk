import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class aqrk
{
  private static int eaV = 57600;
  private static int eaW = -1;
  
  private static Bitmap V(Bitmap paramBitmap)
  {
    double d2 = -1.0D;
    int i;
    double d1;
    if (eaV > 0)
    {
      i = paramBitmap.getWidth() * paramBitmap.getHeight();
      d1 = d2;
      if (i > eaV) {
        d1 = Math.sqrt(eaV / i);
      }
    }
    while (d1 <= 0.0D)
    {
      return paramBitmap;
      d1 = d2;
      if (eaW > 0)
      {
        i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
        d1 = d2;
        if (i > eaW) {
          d1 = eaW / i;
        }
      }
    }
    try
    {
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)Math.ceil(paramBitmap.getWidth() * d1), (int)Math.ceil(d1 * paramBitmap.getHeight()), false);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      QLog.e("VasPalette", 1, "scaleBitmapDown failed.", paramBitmap);
    }
    return null;
  }
  
  public static List<aqrk.a> a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramBitmap = V(paramBitmap);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        aqrk.c localc = new aqrk.c();
        try
        {
          localc.g(d(paramBitmap), 16);
          paramBitmap.recycle();
          return localc.gK();
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            QLog.e("VasPalette", 1, localOutOfMemoryError.getMessage());
          }
        }
      }
    }
    return null;
  }
  
  private static int[] d(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int[] arrayOfInt = new int[i * j];
    paramBitmap.getPixels(arrayOfInt, 0, i, 0, 0, i, j);
    return arrayOfInt;
  }
  
  public static class a
  {
    public long b;
    public byte bB;
    public boolean cVI;
    public int count;
    public SparseArray<a> dL;
    public long g;
    public int index;
    public long r;
    
    public static a a()
    {
      return new a();
    }
    
    public static a a(int paramInt, byte paramByte)
    {
      a locala = new a();
      locala.index = paramInt;
      locala.bB = paramByte;
      return locala;
    }
    
    public int Mo()
    {
      return Color.rgb((int)this.r, (int)this.g, (int)this.b);
    }
  }
  
  public static class b
  {
    public List<aqrk.a> IZ = new ArrayList();
    aqrk.a a = aqrk.a.a();
    public SparseArray<List<aqrk.a>> dM = new SparseArray();
    
    public aqrk.a a(int paramInt)
    {
      aqrk.a locala1 = this.a;
      int m = Color.red(paramInt);
      int n = Color.green(paramInt);
      int i1 = Color.blue(paramInt);
      paramInt = 128;
      byte b = 1;
      while (b <= 8)
      {
        int i;
        int j;
        label55:
        int k;
        label65:
        aqrk.a locala2;
        boolean bool;
        if ((m & paramInt) == 0)
        {
          i = 0;
          if ((n & paramInt) != 0) {
            break label247;
          }
          j = 0;
          if ((i1 & paramInt) != 0) {
            break label253;
          }
          k = 0;
          i = i * 4 + j * 2 + k;
          if (locala1.dL == null) {
            locala1.dL = new SparseArray();
          }
          if (locala1.dL.get(i) == null)
          {
            locala2 = aqrk.a.a(i, b);
            locala1.dL.put(i, locala2);
            if (b != 8) {
              break label259;
            }
            bool = true;
            label136:
            locala2.cVI = bool;
            if (!locala2.cVI) {
              break label265;
            }
            this.IZ.add(locala2);
          }
        }
        for (;;)
        {
          locala1 = (aqrk.a)locala1.dL.get(i);
          if (!locala1.cVI) {
            break label313;
          }
          locala1.r += m;
          locala1.g += n;
          locala1.b += i1;
          locala1.count += 1;
          return locala1;
          i = 1;
          break;
          label247:
          j = 1;
          break label55;
          label253:
          k = 1;
          break label65;
          label259:
          bool = false;
          break label136;
          label265:
          if (this.dM.get(b) == null) {
            this.dM.put(b, new ArrayList());
          }
          ((List)this.dM.get(b)).add(locala2);
        }
        label313:
        b = (byte)(b + 1);
        paramInt >>= 1;
      }
      return locala1;
    }
    
    public void efj()
    {
      int i = 7;
      while ((i > 0) && (((List)this.dM.get(i)).isEmpty())) {
        i -= 1;
      }
      Object localObject = (List)this.dM.get(i);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        aqrk.a locala = (aqrk.a)((List)localObject).get(((List)localObject).size() - 1);
        ((List)localObject).remove(locala);
        i = 0;
        while (i < 8)
        {
          localObject = (aqrk.a)locala.dL.get(i);
          if (localObject != null)
          {
            locala.r += ((aqrk.a)localObject).r;
            locala.g += ((aqrk.a)localObject).g;
            locala.b += ((aqrk.a)localObject).b;
            locala.count += ((aqrk.a)localObject).count;
            this.IZ.remove(localObject);
          }
          i += 1;
        }
        locala.dL.clear();
        locala.dL = null;
        locala.cVI = true;
        this.IZ.add(locala);
      }
    }
  }
  
  public static class c
  {
    private static final Comparator<aqrk.a> ak = new aqrl();
    private List<aqrk.a> IT;
    
    public void g(int[] paramArrayOfInt, int paramInt)
    {
      Object localObject = new aqrk.b();
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        ((aqrk.b)localObject).a(paramArrayOfInt[i]);
        while (((aqrk.b)localObject).IZ.size() > paramInt) {
          ((aqrk.b)localObject).efj();
        }
        i += 1;
      }
      this.IT = new ArrayList();
      paramArrayOfInt = ((aqrk.b)localObject).IZ.iterator();
      while (paramArrayOfInt.hasNext())
      {
        localObject = (aqrk.a)paramArrayOfInt.next();
        ((aqrk.a)localObject).r = ((int)((float)((aqrk.a)localObject).r / ((aqrk.a)localObject).count));
        ((aqrk.a)localObject).g = ((int)((float)((aqrk.a)localObject).g / ((aqrk.a)localObject).count));
        ((aqrk.a)localObject).b = ((int)((float)((aqrk.a)localObject).b / ((aqrk.a)localObject).count));
        this.IT.add(localObject);
      }
      Collections.sort(this.IT, ak);
    }
    
    public List<aqrk.a> gK()
    {
      if (this.IT == null) {
        return null;
      }
      return Collections.unmodifiableList(this.IT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqrk
 * JD-Core Version:    0.7.0.1
 */