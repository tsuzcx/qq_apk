package com.tencent.qqmail.utilities.qmnetwork;

import com.tencent.qqmail.protocol.DataCollector;

public class QMUMAError
  extends QMNetworkError
{
  public QMUMAError(int paramInt, String paramString)
  {
    super(6, paramInt, paramString);
    DataCollector.logException(6, paramInt, "Event_Error", paramString.replaceAll(";", " "), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.QMUMAError
 * JD-Core Version:    0.7.0.1
 */