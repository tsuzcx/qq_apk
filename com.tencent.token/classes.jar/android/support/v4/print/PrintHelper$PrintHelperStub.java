package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;

final class PrintHelper$PrintHelperStub
  implements PrintHelper.PrintHelperVersionImpl
{
  int mColorMode = 2;
  int mOrientation = 1;
  int mScaleMode = 2;
  
  public int getColorMode()
  {
    return this.mColorMode;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int getScaleMode()
  {
    return this.mScaleMode;
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback) {}
  
  public void printBitmap(String paramString, Uri paramUri, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback) {}
  
  public void setColorMode(int paramInt)
  {
    this.mColorMode = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }
  
  public void setScaleMode(int paramInt)
  {
    this.mScaleMode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.print.PrintHelper.PrintHelperStub
 * JD-Core Version:    0.7.0.1
 */