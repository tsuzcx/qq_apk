package com.tencent.qqmail.activity.media;

import com.tencent.qqmail.utilities.ui.QMTips.QMTipsCallback;

public abstract interface IMediaInterface
{
  public abstract void finishMedia();
  
  public abstract void onSizeTooLarge();
  
  public abstract void resetAddButton(boolean paramBoolean);
  
  public abstract void showUpload(QMTips.QMTipsCallback paramQMTipsCallback);
  
  public abstract void updateUploadProcess(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.IMediaInterface
 * JD-Core Version:    0.7.0.1
 */