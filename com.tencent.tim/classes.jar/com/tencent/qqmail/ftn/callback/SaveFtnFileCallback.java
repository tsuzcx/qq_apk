package com.tencent.qqmail.ftn.callback;

import com.tencent.qqmail.ftn.Ftn.StoreFileOutput;

public abstract interface SaveFtnFileCallback
{
  public abstract void onError(int paramInt);
  
  public abstract void onSuccess(StoreFileOutput paramStoreFileOutput);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.callback.SaveFtnFileCallback
 * JD-Core Version:    0.7.0.1
 */