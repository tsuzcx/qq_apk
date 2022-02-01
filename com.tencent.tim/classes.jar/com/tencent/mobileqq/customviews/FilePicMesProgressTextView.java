package com.tencent.mobileqq.customviews;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import wyf;

public class FilePicMesProgressTextView
  extends MessageProgressTextView
{
  public boolean bWO = true;
  private boolean bot = true;
  FileManagerEntity c;
  private final QQAppInterface mApp;
  int textColor;
  int textSize;
  
  public FilePicMesProgressTextView(Context paramContext, QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramContext);
    this.mApp = paramQQAppInterface;
    this.c = paramFileManagerEntity;
  }
  
  public void setDisplayInTextView(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.bWO = paramBoolean;
    this.textSize = paramInt1;
    this.textColor = paramInt2;
  }
  
  public void setProgress(int paramInt)
  {
    if ((this.bot) && (this.bWO)) {
      setText(paramInt + "%");
    }
    for (;;)
    {
      Drawable localDrawable = getBackground();
      if (localDrawable != null)
      {
        localDrawable.setLevel((100 - paramInt) * 100);
        if (((localDrawable instanceof wyf)) && (!this.bWO)) {
          ((wyf)localDrawable).fH(this.textSize, this.textColor);
        }
      }
      return;
      setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.FilePicMesProgressTextView
 * JD-Core Version:    0.7.0.1
 */