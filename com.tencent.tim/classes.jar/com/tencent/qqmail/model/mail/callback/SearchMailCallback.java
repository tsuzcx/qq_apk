package com.tencent.qqmail.model.mail.callback;

import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

public abstract interface SearchMailCallback
{
  public abstract void onSearchComplete(int paramInt, int[] paramArrayOfInt);
  
  public abstract void onSearchError(SearchInfo paramSearchInfo, QMProtocolError paramQMProtocolError);
  
  public abstract void onSearchMail(Mail paramMail);
  
  public abstract void onSearchSuccess(int paramInt, int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.SearchMailCallback
 * JD-Core Version:    0.7.0.1
 */