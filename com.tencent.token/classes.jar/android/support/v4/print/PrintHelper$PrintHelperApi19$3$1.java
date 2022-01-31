package android.support.v4.print;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentInfo.Builder;
import java.io.FileNotFoundException;

class PrintHelper$PrintHelperApi19$3$1
  extends AsyncTask
{
  PrintHelper$PrintHelperApi19$3$1(PrintHelper.PrintHelperApi19.3 param3, CancellationSignal paramCancellationSignal, PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback) {}
  
  protected Bitmap doInBackground(Uri... paramVarArgs)
  {
    try
    {
      paramVarArgs = PrintHelper.PrintHelperApi19.access$400(this.this$1.this$0, this.this$1.val$imageFile);
      return paramVarArgs;
    }
    catch (FileNotFoundException paramVarArgs) {}
    return null;
  }
  
  protected void onCancelled(Bitmap paramBitmap)
  {
    this.val$layoutResultCallback.onLayoutCancelled();
    this.this$1.mLoadBitmap = null;
  }
  
  protected void onPostExecute(Bitmap paramBitmap)
  {
    boolean bool = true;
    super.onPostExecute(paramBitmap);
    Object localObject = paramBitmap;
    if (paramBitmap != null) {
      if (this.this$1.this$0.mPrintActivityRespectsOrientation)
      {
        localObject = paramBitmap;
        if (this.this$1.this$0.mOrientation != 0) {
          break label110;
        }
      }
    }
    for (;;)
    {
      try
      {
        PrintAttributes.MediaSize localMediaSize = PrintHelper.PrintHelperApi19.3.access$500(this.this$1).getMediaSize();
        localObject = paramBitmap;
        if (localMediaSize != null)
        {
          localObject = paramBitmap;
          if (localMediaSize.isPortrait() != PrintHelper.PrintHelperApi19.access$600(paramBitmap))
          {
            localObject = new Matrix();
            ((Matrix)localObject).postRotate(90.0F);
            localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
          }
        }
        label110:
        this.this$1.mBitmap = ((Bitmap)localObject);
        if (localObject == null) {
          break label190;
        }
        paramBitmap = new PrintDocumentInfo.Builder(this.this$1.val$jobName).setContentType(1).setPageCount(1).build();
        if (!this.val$newPrintAttributes.equals(this.val$oldPrintAttributes))
        {
          this.val$layoutResultCallback.onLayoutFinished(paramBitmap, bool);
          this.this$1.mLoadBitmap = null;
          return;
        }
      }
      finally {}
      bool = false;
      continue;
      label190:
      this.val$layoutResultCallback.onLayoutFailed(null);
    }
  }
  
  protected void onPreExecute()
  {
    this.val$cancellationSignal.setOnCancelListener(new PrintHelper.PrintHelperApi19.3.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.print.PrintHelper.PrintHelperApi19.3.1
 * JD-Core Version:    0.7.0.1
 */