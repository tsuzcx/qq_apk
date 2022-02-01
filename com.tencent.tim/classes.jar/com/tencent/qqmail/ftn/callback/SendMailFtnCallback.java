package com.tencent.qqmail.ftn.callback;

import com.tencent.qqmail.ftn.model.FtnUploadInfo;

public abstract interface SendMailFtnCallback
{
  public abstract void onFtnAttachStratUpload(FtnUploadInfo paramFtnUploadInfo);
  
  public abstract void onNormalAttachStratUpload(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.callback.SendMailFtnCallback
 * JD-Core Version:    0.7.0.1
 */