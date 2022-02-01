import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.util.SparseIntArray;
import java.util.HashMap;

public class h
{
  private static SparseIntArray b = new SparseIntArray();
  private static SparseIntArray f = new SparseIntArray();
  private static SparseIntArray g = new SparseIntArray();
  private static SparseIntArray h = new SparseIntArray();
  private static SparseIntArray i = new SparseIntArray();
  private static SparseIntArray j = new SparseIntArray();
  private static SparseIntArray k = new SparseIntArray();
  private static HashMap<String, BitmapShader> m = new HashMap();
  private static HashMap<String, BitmapShader> p = new HashMap();
  private static HashMap<String, Bitmap> q = new HashMap();
  private static HashMap<String, Bitmap> r = new HashMap();
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (Bitmap)q.get(paramInt1 + "_" + paramInt2 + "_" + paramInt3 + "_" + paramInt4);
  }
  
  public static BitmapShader a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (BitmapShader)m.get(paramInt1 + "_" + paramInt2 + "_" + paramInt3 + "_" + paramInt4);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap paramBitmap)
  {
    String str = paramInt1 + "_" + paramInt2 + "_" + paramInt3 + "_" + paramInt4;
    if ((!q.containsKey(str)) && (paramBitmap != null)) {
      q.put(str, paramBitmap);
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitmapShader paramBitmapShader)
  {
    String str = paramInt1 + "_" + paramInt2 + "_" + paramInt3 + "_" + paramInt4;
    if ((!m.containsKey(str)) && (paramBitmapShader != null)) {
      m.put(str, paramBitmapShader);
    }
  }
  
  public static Bitmap b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (Bitmap)r.get(paramInt1 + "_" + paramInt2 + "_" + paramInt3 + "_" + paramInt4);
  }
  
  public static void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap paramBitmap)
  {
    String str = paramInt1 + "_" + paramInt2 + "_" + paramInt3 + "_" + paramInt4;
    if ((!r.containsKey(str)) && (paramBitmap != null)) {
      r.put(str, paramBitmap);
    }
  }
  
  public static int g(int paramInt)
  {
    return g.get(paramInt);
  }
  
  public static void g(int paramInt1, int paramInt2)
  {
    g.put(paramInt1, paramInt2);
  }
  
  public static int h(int paramInt)
  {
    return b.get(paramInt, 0);
  }
  
  public static void h(int paramInt1, int paramInt2)
  {
    b.put(paramInt1, paramInt2);
  }
  
  public static int i(int paramInt)
  {
    return f.get(paramInt, 0);
  }
  
  public static void i(int paramInt1, int paramInt2)
  {
    f.put(paramInt1, paramInt2);
  }
  
  public static int j(int paramInt)
  {
    return i.get(paramInt, 256);
  }
  
  public static void j(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      i.put(paramInt1, paramInt2);
    }
  }
  
  public static int k(int paramInt)
  {
    return h.get(paramInt, 256);
  }
  
  public static void k(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      h.put(paramInt1, paramInt2);
    }
  }
  
  public static int l(int paramInt)
  {
    return j.get(paramInt, 0);
  }
  
  public static void l(int paramInt1, int paramInt2)
  {
    j.put(paramInt1, paramInt2);
  }
  
  public static int m(int paramInt)
  {
    return k.get(paramInt, 0);
  }
  
  public static void m(int paramInt1, int paramInt2)
  {
    k.put(paramInt1, paramInt2);
  }
  
  public static void x(int paramInt)
  {
    int n = b.indexOfKey(paramInt);
    if (n >= 0) {
      b.removeAt(n);
    }
    n = f.indexOfKey(paramInt);
    if (n >= 0) {
      f.removeAt(n);
    }
    n = g.indexOfKey(paramInt);
    if (n >= 0) {
      g.removeAt(n);
    }
    n = h.indexOfKey(paramInt);
    if (n >= 0) {
      h.removeAt(n);
    }
    n = i.indexOfKey(paramInt);
    if (n >= 0) {
      i.removeAt(n);
    }
    n = j.indexOfKey(paramInt);
    if (n >= 0) {
      j.removeAt(n);
    }
    paramInt = k.indexOfKey(paramInt);
    if (paramInt >= 0) {
      k.removeAt(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     h
 * JD-Core Version:    0.7.0.1
 */