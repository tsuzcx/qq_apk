package com.tencent.qqmail.ftn.callback;

import com.tencent.qqmail.ftn.model.FtnUploadInfo;

public abstract interface FileSignCallback
{
  public abstract void onError();
  
  public abstract void onSuccess(FtnUploadInfo paramFtnUploadInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.callback.FileSignCallback
 * JD-Core Version:    0.7.0.1
 */