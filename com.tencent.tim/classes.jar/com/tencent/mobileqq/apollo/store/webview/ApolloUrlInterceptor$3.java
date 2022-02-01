package com.tencent.mobileqq.apollo.store.webview;

import abvc;
import abvd;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApolloUrlInterceptor$3
  implements Runnable
{
  public ApolloUrlInterceptor$3(abvc paramabvc, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 1, "task(" + this.this$0.id + ") onClose:cachedStream size:" + this.f.size());
    }
    if (!abvc.a(this.this$0)) {}
    try
    {
      str = this.f.toString("UTF-8");
      this.f.close();
      if (!TextUtils.isEmpty(str))
      {
        long l = System.currentTimeMillis();
        abvd.a().ar(abvc.a(this.this$0), str);
        abvc.a(this.this$0, true);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.this$0.id + ") onClose:save bridgeStream " + (System.currentTimeMillis() - l) + " ms. htmlString.length:" + str.length());
        }
      }
      abvc.a(this.this$0).set(false);
      if ((abvc.b(this.this$0)) && (QLog.isColorLevel())) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.this$0.id + ") onClose: postForceDestroyIfNeed send destroy message.");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str = null;
        QLog.e("apollo_client_ApolloUrlInterceptor", 1, "task(" + this.this$0.id + ") onClose error:" + localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor.3
 * JD-Core Version:    0.7.0.1
 */