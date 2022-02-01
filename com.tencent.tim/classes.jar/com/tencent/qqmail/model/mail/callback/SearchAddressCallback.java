package com.tencent.qqmail.model.mail.callback;

import com.tencent.qqmail.protocol.ASContact;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import java.util.ArrayList;

public abstract interface SearchAddressCallback
{
  public abstract void searchError(QMProtocolError paramQMProtocolError);
  
  public abstract void searchSuccess(ArrayList<ASContact> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.SearchAddressCallback
 * JD-Core Version:    0.7.0.1
 */