package com.tencent.biz.pubaccount.readinjoy.viola.adapter;

import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.HttpRequset;
import com.tencent.viola.adapter.HttpResponse;
import com.tencent.viola.adapter.IHttpAdapter.OnHttpListener;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;
import nua;
import nua.a;

public class BaseHttpAdapter$1
  implements Runnable
{
  public BaseHttpAdapter$1(nua paramnua, HttpRequset paramHttpRequset, IHttpAdapter.OnHttpListener paramOnHttpListener) {}
  
  public void run()
  {
    HttpResponse localHttpResponse = new HttpResponse();
    Object localObject = this.this$0.a();
    try
    {
      HttpURLConnection localHttpURLConnection = nua.a(this.this$0, this.jdField_a_of_type_ComTencentViolaAdapterHttpRequset, this.jdField_a_of_type_ComTencentViolaAdapterIHttpAdapter$OnHttpListener);
      ((nua.a)localObject).a(localHttpURLConnection, this.jdField_a_of_type_ComTencentViolaAdapterHttpRequset.body);
      Map localMap = localHttpURLConnection.getHeaderFields();
      int i = localHttpURLConnection.getResponseCode();
      if (this.jdField_a_of_type_ComTencentViolaAdapterIHttpAdapter$OnHttpListener != null) {
        this.jdField_a_of_type_ComTencentViolaAdapterIHttpAdapter$OnHttpListener.onHeadersReceived(i, localMap);
      }
      ((nua.a)localObject).bbv();
      localHttpResponse.statusCode = String.valueOf(i);
      if ((i >= 200) && (i <= 299))
      {
        localObject = ((nua.a)localObject).b(localHttpURLConnection.getInputStream());
        localHttpResponse.originalData = nua.a(this.this$0, (InputStream)localObject, this.jdField_a_of_type_ComTencentViolaAdapterIHttpAdapter$OnHttpListener);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentViolaAdapterIHttpAdapter$OnHttpListener != null) {
          this.jdField_a_of_type_ComTencentViolaAdapterIHttpAdapter$OnHttpListener.onHttpFinish(localHttpResponse);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(nua.TAG, 2, "METHOD_OPEN_REQUEST_NET request url is:" + this.jdField_a_of_type_ComTencentViolaAdapterHttpRequset.url + "  request body is:" + this.jdField_a_of_type_ComTencentViolaAdapterHttpRequset.body + ", response code:" + localHttpResponse.errorCode);
        return;
        localHttpResponse.errorMsg = nua.a(this.this$0, localHttpURLConnection.getErrorStream(), this.jdField_a_of_type_ComTencentViolaAdapterIHttpAdapter$OnHttpListener);
      }
      return;
    }
    catch (Exception localException)
    {
      nua.a(this.this$0, localHttpResponse, this.jdField_a_of_type_ComTencentViolaAdapterIHttpAdapter$OnHttpListener, localException.getMessage());
      QLog.e(nua.TAG, 2, "METHOD_OPEN_REQUEST_NET error! request url is:" + this.jdField_a_of_type_ComTencentViolaAdapterHttpRequset.url + "  request body is:" + this.jdField_a_of_type_ComTencentViolaAdapterHttpRequset.body + ",error msg:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.BaseHttpAdapter.1
 * JD-Core Version:    0.7.0.1
 */