package com.tencent.qapmsdk.impl.instrumentation.okhttp2;

import com.squareup.okhttp.Request;
import com.tencent.qapmsdk.impl.instrumentation.QAPMNetworkProcessHeader;

final class QAPMOkHttp2TransactionStateUtil$1
  implements QAPMNetworkProcessHeader
{
  QAPMOkHttp2TransactionStateUtil$1(Request paramRequest) {}
  
  public String getFilterHeader(String paramString)
  {
    if ((this.val$request != null) && (paramString != null)) {
      return this.val$request.header(paramString);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.QAPMOkHttp2TransactionStateUtil.1
 * JD-Core Version:    0.7.0.1
 */