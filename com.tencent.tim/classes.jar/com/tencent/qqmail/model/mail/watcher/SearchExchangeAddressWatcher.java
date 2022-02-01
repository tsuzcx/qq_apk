package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.protocol.ASContact;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import java.util.List;
import moai.core.watcher.Watchers.Watcher;

public abstract interface SearchExchangeAddressWatcher
  extends Watchers.Watcher
{
  public abstract void onError(String paramString, QMProtocolError paramQMProtocolError);
  
  public abstract void onSuccess(String paramString, List<ASContact> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.SearchExchangeAddressWatcher
 * JD-Core Version:    0.7.0.1
 */