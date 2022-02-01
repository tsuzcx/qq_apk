package com.tencent.qqmail.utilities.richeditor;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.EditText;
import com.tencent.qqmail.download.listener.ImageDownloadListener;

class QMEditor$2
  implements ImageDownloadListener
{
  QMEditor$2(QMEditor paramQMEditor, EditText paramEditText, ImageSpan paramImageSpan, String paramString, int paramInt1, int paramInt2) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject) {}
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    paramString1 = (SpannableStringBuilder)this.val$editText.getText();
    paramString2 = new BitmapDrawable(this.this$0.getResources(), paramBitmap);
    paramString2.setBounds(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    paramString1.removeSpan(this.val$temp);
    paramString1.setSpan(new ImageSpan(paramString2, this.val$src), this.val$start, this.val$end, 33);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.richeditor.QMEditor.2
 * JD-Core Version:    0.7.0.1
 */