package com.tencent.qapmsdk.impl.instrumentation;

import java.net.HttpURLConnection;

final class QAPMTransactionStateUtil$1
  implements QAPMNetworkProcessHeader
{
  QAPMTransactionStateUtil$1(HttpURLConnection paramHttpURLConnection) {}
  
  public String getFilterHeader(String paramString)
  {
    return this.val$conn.getRequestProperty(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMTransactionStateUtil.1
 * JD-Core Version:    0.7.0.1
 */