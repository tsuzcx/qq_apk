package android.support.v4.print;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.PrintDocumentInfo.Builder;

class PrintHelper$PrintHelperApi19$3
  extends PrintDocumentAdapter
{
  private PrintAttributes mAttributes;
  Bitmap mBitmap = null;
  AsyncTask mLoadBitmap;
  
  PrintHelper$PrintHelperApi19$3(PrintHelper.PrintHelperApi19 paramPrintHelperApi19, String paramString, Uri paramUri, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback, int paramInt) {}
  
  private void cancelLoad()
  {
    synchronized (PrintHelper.PrintHelperApi19.access$700(this.this$0))
    {
      if (this.this$0.mDecodeOptions != null)
      {
        this.this$0.mDecodeOptions.requestCancelDecode();
        this.this$0.mDecodeOptions = null;
      }
      return;
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    cancelLoad();
    if (this.mLoadBitmap != null) {
      this.mLoadBitmap.cancel(true);
    }
    if (this.val$callback != null) {
      this.val$callback.onFinish();
    }
    if (this.mBitmap != null)
    {
      this.mBitmap.recycle();
      this.mBitmap = null;
    }
  }
  
  public void onLayout(PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback, Bundle paramBundle)
  {
    boolean bool = true;
    try
    {
      this.mAttributes = paramPrintAttributes2;
      if (paramCancellationSignal.isCanceled())
      {
        paramLayoutResultCallback.onLayoutCancelled();
        return;
      }
    }
    finally {}
    if (this.mBitmap != null)
    {
      paramCancellationSignal = new PrintDocumentInfo.Builder(this.val$jobName).setContentType(1).setPageCount(1).build();
      if (!paramPrintAttributes2.equals(paramPrintAttributes1)) {}
      for (;;)
      {
        paramLayoutResultCallback.onLayoutFinished(paramCancellationSignal, bool);
        return;
        bool = false;
      }
    }
    this.mLoadBitmap = new PrintHelper.PrintHelperApi19.3.1(this, paramCancellationSignal, paramPrintAttributes2, paramPrintAttributes1, paramLayoutResultCallback).execute(new Uri[0]);
  }
  
  public void onWrite(PageRange[] paramArrayOfPageRange, ParcelFileDescriptor paramParcelFileDescriptor, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
  {
    PrintHelper.PrintHelperApi19.access$000(this.this$0, this.mAttributes, this.val$fittingMode, this.mBitmap, paramParcelFileDescriptor, paramCancellationSignal, paramWriteResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.print.PrintHelper.PrintHelperApi19.3
 * JD-Core Version:    0.7.0.1
 */