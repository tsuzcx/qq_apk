package com.tencent.qapmsdk.impl.instrumentation;

import org.apache.http.Header;
import org.apache.http.HttpRequest;

final class QAPMHttpClientUtil$1
  implements QAPMNetworkProcessHeader
{
  QAPMHttpClientUtil$1(HttpRequest paramHttpRequest) {}
  
  public String getFilterHeader(String paramString)
  {
    paramString = this.val$request.getFirstHeader(paramString);
    if (paramString != null) {
      return paramString.getValue();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMHttpClientUtil.1
 * JD-Core Version:    0.7.0.1
 */