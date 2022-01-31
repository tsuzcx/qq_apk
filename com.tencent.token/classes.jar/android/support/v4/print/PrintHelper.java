package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;

public final class PrintHelper
{
  public static final int COLOR_MODE_COLOR = 2;
  public static final int COLOR_MODE_MONOCHROME = 1;
  public static final int ORIENTATION_LANDSCAPE = 1;
  public static final int ORIENTATION_PORTRAIT = 2;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  private final PrintHelper.PrintHelperVersionImpl mImpl;
  
  public PrintHelper(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.mImpl = new PrintHelper.PrintHelperApi24(paramContext);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.mImpl = new PrintHelper.PrintHelperApi23(paramContext);
      return;
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      this.mImpl = new PrintHelper.PrintHelperApi20(paramContext);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.mImpl = new PrintHelper.PrintHelperApi19(paramContext);
      return;
    }
    this.mImpl = new PrintHelper.PrintHelperStub(null);
  }
  
  public static boolean systemSupportsPrint()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public int getColorMode()
  {
    return this.mImpl.getColorMode();
  }
  
  public int getOrientation()
  {
    return this.mImpl.getOrientation();
  }
  
  public int getScaleMode()
  {
    return this.mImpl.getScaleMode();
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap)
  {
    this.mImpl.printBitmap(paramString, paramBitmap, null);
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    this.mImpl.printBitmap(paramString, paramBitmap, paramOnPrintFinishCallback);
  }
  
  public void printBitmap(String paramString, Uri paramUri)
  {
    this.mImpl.printBitmap(paramString, paramUri, null);
  }
  
  public void printBitmap(String paramString, Uri paramUri, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    this.mImpl.printBitmap(paramString, paramUri, paramOnPrintFinishCallback);
  }
  
  public void setColorMode(int paramInt)
  {
    this.mImpl.setColorMode(paramInt);
  }
  
  public void setOrientation(int paramInt)
  {
    this.mImpl.setOrientation(paramInt);
  }
  
  public void setScaleMode(int paramInt)
  {
    this.mImpl.setScaleMode(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.print.PrintHelper
 * JD-Core Version:    0.7.0.1
 */