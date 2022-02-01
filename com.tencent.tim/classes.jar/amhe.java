import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.ConcurrentHashMap;

class amhe
  implements EIPCResultCallback
{
  amhe(amhd paramamhd) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.data == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramEIPCResult.data.getInt("notify_type"))
          {
          default: 
            return;
          }
        } while (paramEIPCResult.code != 0);
        i = paramEIPCResult.data.getInt("id");
        paramEIPCResult = paramEIPCResult.data.getString("url");
        if (QLog.isColorLevel()) {
          QLog.d("Signature.TOOL", 2, "mSignatureManagerIPCCallback get action id = " + i + " url = " + paramEIPCResult);
        }
      } while (TextUtils.isEmpty(paramEIPCResult));
      amhd.b(this.this$0).put(Integer.valueOf(i), paramEIPCResult);
      amhd.b(this.this$0);
      this.this$0.notifyObservers(Integer.valueOf(4));
      return;
    } while (paramEIPCResult.code != 0);
    int i = paramEIPCResult.data.getInt("id");
    this.this$0.a(i, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amhe
 * JD-Core Version:    0.7.0.1
 */