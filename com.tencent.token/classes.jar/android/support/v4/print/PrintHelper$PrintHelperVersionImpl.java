package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;

abstract interface PrintHelper$PrintHelperVersionImpl
{
  public abstract int getColorMode();
  
  public abstract int getOrientation();
  
  public abstract int getScaleMode();
  
  public abstract void printBitmap(String paramString, Bitmap paramBitmap, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback);
  
  public abstract void printBitmap(String paramString, Uri paramUri, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback);
  
  public abstract void setColorMode(int paramInt);
  
  public abstract void setOrientation(int paramInt);
  
  public abstract void setScaleMode(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.print.PrintHelper.PrintHelperVersionImpl
 * JD-Core Version:    0.7.0.1
 */