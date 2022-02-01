package com.tencent.qqmail.utilities.richeditor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.log.QMLog;
import java.lang.ref.WeakReference;

class QMEditText$1
  implements ImageDownloadListener
{
  QMEditText$1(QMEditText paramQMEditText, SpannableStringBuilder paramSpannableStringBuilder, WeakReference paramWeakReference, String paramString, ImageSpan paramImageSpan, boolean paramBoolean) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject) {}
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    paramString2 = (ImageSpan[])this.val$text.getSpans(0, this.val$text.length(), ImageSpan.class);
    int n = paramString2.length;
    int k = 0;
    int j = 0;
    int i = 0;
    Object localObject;
    if (k < n)
    {
      localObject = paramString2[k];
      if (!((ImageSpan)localObject).getSource().equals("file://localhost" + paramString1)) {
        break label400;
      }
      j = this.val$text.getSpanStart(localObject);
      i = this.val$text.getSpanEnd(localObject);
    }
    for (;;)
    {
      int m = k + 1;
      k = j;
      j = i;
      i = k;
      k = m;
      break;
      if ((i == 0) && (j == 0)) {}
      do
      {
        do
        {
          return;
          QMLog.log(4, "QMEditText", "addAttachImg2 : " + paramString1);
          paramString1 = (SpannableStringBuilder)this.val$editTextReference.get();
        } while ((paramString1 == null) || (paramBitmap == null) || (paramBitmap.isRecycled()));
        paramString2 = QMApplicationContext.sharedInstance();
        localObject = new BitmapDrawable(paramString2.getResources(), paramBitmap);
        k = (int)(((WindowManager)paramString2.getSystemService("window")).getDefaultDisplay().getWidth() - 1 - paramString2.getResources().getDimension(2131296986) * 2.0F) - 1;
        if (290 > paramBitmap.getWidth()) {
          k = paramBitmap.getWidth();
        }
        m = paramBitmap.getHeight() * k / paramBitmap.getWidth();
        ((BitmapDrawable)localObject).setBounds(0, 0, k, m);
        paramString1.setSpan(new ImageSpan((Drawable)localObject, this.val$src, 1), i, j, 33);
        paramString1.removeSpan(this.val$imageSpan);
        if ((j < this.val$text.length()) && (this.val$text.charAt(j) == '\n'))
        {
          this.val$text.insert(j, " ");
          this.val$text.delete(j, j + 1);
        }
      } while ((QMEditText.access$000(this.this$0) == null) || (this.val$isNotScroll));
      QMEditText.access$000(this.this$0).onPasteMediaFile(j, m);
      return;
      label400:
      m = i;
      i = j;
      j = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.richeditor.QMEditText.1
 * JD-Core Version:    0.7.0.1
 */