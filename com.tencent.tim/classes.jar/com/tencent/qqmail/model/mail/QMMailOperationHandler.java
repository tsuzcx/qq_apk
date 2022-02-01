package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import java.util.ArrayList;
import java.util.List;

public class QMMailOperationHandler
{
  List<QMNetworkRequest> request;
  
  public QMMailOperationHandler(QMNetworkRequest paramQMNetworkRequest)
  {
    if (this.request == null) {
      this.request = new ArrayList();
    }
    this.request.add(paramQMNetworkRequest);
  }
  
  public QMMailOperationHandler(List<QMNetworkRequest> paramList)
  {
    if (this.request == null) {
      this.request = new ArrayList();
    }
    int i = 0;
    while (i < paramList.size())
    {
      if (paramList.get(i) != null) {
        this.request.add(paramList.get(i));
      }
      i += 1;
    }
  }
  
  public void cancel()
  {
    int i = 0;
    while (i < this.request.size())
    {
      ((QMNetworkRequest)this.request.get(i)).abort();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailOperationHandler
 * JD-Core Version:    0.7.0.1
 */