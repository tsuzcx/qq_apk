package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;

public final class BitmapCompat
{
  static final BitmapCompatBaseImpl IMPL = new BitmapCompatBaseImpl();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      IMPL = new BitmapCompatApi19Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      IMPL = new BitmapCompatApi18Impl();
      return;
    }
  }
  
  public static int getAllocationByteCount(Bitmap paramBitmap)
  {
    return IMPL.getAllocationByteCount(paramBitmap);
  }
  
  public static boolean hasMipMap(Bitmap paramBitmap)
  {
    return IMPL.hasMipMap(paramBitmap);
  }
  
  public static void setHasMipMap(Bitmap paramBitmap, boolean paramBoolean)
  {
    IMPL.setHasMipMap(paramBitmap, paramBoolean);
  }
  
  @RequiresApi(18)
  static class BitmapCompatApi18Impl
    extends BitmapCompat.BitmapCompatBaseImpl
  {
    public boolean hasMipMap(Bitmap paramBitmap)
    {
      return paramBitmap.hasMipMap();
    }
    
    public void setHasMipMap(Bitmap paramBitmap, boolean paramBoolean)
    {
      paramBitmap.setHasMipMap(paramBoolean);
    }
  }
  
  @RequiresApi(19)
  static class BitmapCompatApi19Impl
    extends BitmapCompat.BitmapCompatApi18Impl
  {
    public int getAllocationByteCount(Bitmap paramBitmap)
    {
      return paramBitmap.getAllocationByteCount();
    }
  }
  
  static class BitmapCompatBaseImpl
  {
    public int getAllocationByteCount(Bitmap paramBitmap)
    {
      return paramBitmap.getByteCount();
    }
    
    public boolean hasMipMap(Bitmap paramBitmap)
    {
      return false;
    }
    
    public void setHasMipMap(Bitmap paramBitmap, boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     android.support.v4.graphics.BitmapCompat
 * JD-Core Version:    0.7.0.1
 */