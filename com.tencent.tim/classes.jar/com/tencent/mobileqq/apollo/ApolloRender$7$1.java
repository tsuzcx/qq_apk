package com.tencent.mobileqq.apollo;

import abig;
import com.tencent.qphone.base.util.QLog;

public class ApolloRender$7$1
  extends IApolloRunnableTask
{
  public ApolloRender$7$1(abig paramabig, byte[] paramArrayOfByte, int paramInt) {}
  
  public String aV()
  {
    return "httpRequestData_httpCallBack";
  }
  
  public void run()
  {
    if ((QLog.isColorLevel()) && (this.cI != null)) {
      QLog.d("sava_ApolloRender", 2, "httpLog httpCallBack data.len=" + this.cI.length);
    }
    ((ApolloSurfaceView)this.this$0.val$view).getRender().getSavaWrapper().a(this.this$0.Ns, this.val$resCode, this.cI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.7.1
 * JD-Core Version:    0.7.0.1
 */