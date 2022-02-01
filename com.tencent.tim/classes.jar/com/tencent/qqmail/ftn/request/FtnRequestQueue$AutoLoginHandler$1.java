package com.tencent.qqmail.ftn.request;

import android.os.Message;
import com.tencent.qqmail.ftn.FtnDefine.FtnCallback;
import com.tencent.qqmail.utilities.log.QMLog;

class FtnRequestQueue$AutoLoginHandler$1
  extends FtnDefine.FtnCallback
{
  FtnRequestQueue$AutoLoginHandler$1(FtnRequestQueue.AutoLoginHandler paramAutoLoginHandler) {}
  
  public void onError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (FtnRequestQueue.AutoLoginHandler.access$1204(this.this$1) > 3)
    {
      FtnRequestQueue.access$600(this.this$1.this$0);
      FtnRequestQueue.AutoLoginHandler.access$1202(this.this$1, 0);
      return;
    }
    QMLog.log(6, "FtnRequestQueue", "ftn login error  code: " + paramInt1 + " subcode: " + paramInt2 + " errtype: " + paramInt3 + " desc: " + paramString);
    if ((paramInt3 == 4) && (paramInt2 == 2))
    {
      paramString = Message.obtain();
      paramString.obj = Integer.valueOf(5);
      paramString.what = 1;
      this.this$1.sendMessage(paramString);
      QMLog.log(6, "FtnRequestQueue", "ftn login error try autologin qqmail");
      return;
    }
    this.this$1.sendEmptyMessage(4);
    QMLog.log(6, "FtnRequestQueue", "ftn login error try again");
  }
  
  public void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    FtnRequestQueue.AutoLoginHandler.access$1202(this.this$1, 0);
    this.this$1.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.request.FtnRequestQueue.AutoLoginHandler.1
 * JD-Core Version:    0.7.0.1
 */