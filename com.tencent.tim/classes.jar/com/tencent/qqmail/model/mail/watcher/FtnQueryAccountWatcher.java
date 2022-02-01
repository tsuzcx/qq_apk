package com.tencent.qqmail.model.mail.watcher;

import java.util.HashMap;

public abstract interface FtnQueryAccountWatcher
{
  public abstract void onError();
  
  public abstract void onSuccess(HashMap<String, Object> paramHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.FtnQueryAccountWatcher
 * JD-Core Version:    0.7.0.1
 */