package com.tencent.qqmail.utilities.qmnetwork;

import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.protocol.ProtocolResult;

public class QMProtocolError
  extends QMNetworkError
{
  public QMProtocolError(int paramInt)
  {
    super(5, paramInt, ProtocolResult.getErrorDesp(paramInt));
    DataCollector.logException(5, paramInt, "Event_Error", this.desp.replaceAll(";", " "), true);
  }
  
  public QMProtocolError(int paramInt, String paramString)
  {
    super(5, paramInt, paramString);
    DataCollector.logException(5, paramInt, "Event_Error", this.desp.replaceAll(";", " "), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.QMProtocolError
 * JD-Core Version:    0.7.0.1
 */