package com.tencent.qqmail.utilities.richeditor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.log.QMLog;
import java.lang.ref.WeakReference;

class QMEditText$2
  implements ImageDownloadListener
{
  QMEditText$2(QMEditText paramQMEditText, WeakReference paramWeakReference, ImageSpan paramImageSpan, String paramString, boolean paramBoolean, int paramInt) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    QMLog.log(6, "QMEditText", "addAttachImg2 err : " + paramString);
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    QMLog.log(4, "QMEditText", "addAttachImg2 : " + paramString1);
    paramString1 = (SpannableStringBuilder)this.val$editTextReference.get();
    BitmapDrawable localBitmapDrawable;
    int j;
    if ((paramString1 != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramString2 = QMApplicationContext.sharedInstance();
      localBitmapDrawable = new BitmapDrawable(paramString2.getResources(), paramBitmap);
      int i = (int)(((WindowManager)paramString2.getSystemService("window")).getDefaultDisplay().getWidth() - 1 - paramString2.getResources().getDimension(2131296986) * 2.0F);
      if (290 > paramBitmap.getWidth()) {
        i = paramBitmap.getWidth();
      }
      j = paramBitmap.getHeight() * i / paramBitmap.getWidth();
      localBitmapDrawable.setBounds(0, 0, i, j);
      if ((paramString1.getSpanStart(this.val$imageSpan) != -1) && (paramString1.getSpanEnd(this.val$imageSpan) != -1)) {}
    }
    do
    {
      do
      {
        return;
        paramString1.setSpan(new ImageSpan(localBitmapDrawable, this.val$src, 1), paramString1.getSpanStart(this.val$imageSpan), paramString1.getSpanEnd(this.val$imageSpan), 33);
        paramString1.removeSpan(this.val$imageSpan);
      } while ((QMEditText.access$000(this.this$0) == null) || (this.val$isNotScroll));
      QMEditText.access$000(this.this$0).onPasteMediaFile(this.val$end1, j);
      return;
      if (paramString1 == null)
      {
        QMLog.log(6, "QMEditText", "addAttachImg2 error : (text1 == null)");
        return;
      }
      if (paramBitmap == null)
      {
        QMLog.log(6, "QMEditText", "addAttachImg2 error : (bitmap == null)");
        return;
      }
    } while (!paramBitmap.isRecycled());
    QMLog.log(6, "QMEditText", "addAttachImg2 error : (bitmap.isRecycled())");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.richeditor.QMEditText.2
 * JD-Core Version:    0.7.0.1
 */