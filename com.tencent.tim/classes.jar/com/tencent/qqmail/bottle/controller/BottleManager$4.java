package com.tencent.qqmail.bottle.controller;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.tencent.qqmail.download.listener.ImageDownloadListener;

class BottleManager$4
  implements ImageDownloadListener
{
  BottleManager$4(BottleManager paramBottleManager, BottleManager.ViewHolderTag paramViewHolderTag, String paramString1, String paramString2, Resources paramResources, int paramInt1, SpannableString paramSpannableString, int paramInt2, int paramInt3, TextView paramTextView) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject) {}
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if ((this.val$viewHolder.bottleid != null) && (this.val$viewHolder.bottleid.equals(this.val$bottleid)) && (((this.val$viewHolder.msgid == null) && (this.val$msgid == null)) || ((this.val$viewHolder.msgid != null) && (this.val$viewHolder.msgid.equals(this.val$msgid)))))
    {
      paramString1 = new BitmapDrawable(this.val$resources, paramBitmap);
      paramString1.setBounds(0, 0, this.val$avatarSize, this.val$avatarSize);
      paramString1 = new ImageSpan(paramString1, 1);
      this.val$ss.setSpan(paramString1, this.val$fBegin, this.val$fEnd, 17);
      this.val$textView.setText(this.val$ss);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleManager.4
 * JD-Core Version:    0.7.0.1
 */