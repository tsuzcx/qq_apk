import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class akuo
  extends achq
{
  public akuo(OpenApiManager paramOpenApiManager) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    a(false, paramString1, paramLong2);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    Intent localIntent;
    if (OpenApiManager.access$300(this.this$0).containsKey(Long.valueOf(paramLong)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.Manager", 2, "onSendResult, isSuccess = " + paramBoolean + ", uniseq = " + paramLong);
      }
      paramString = (String)OpenApiManager.access$300(this.this$0).remove(Long.valueOf(paramLong));
      paramString = (akur)OpenApiManager.access$200(this.this$0).get(paramString);
      if (paramString != null)
      {
        localIntent = new Intent("com.tencent.mobileqq.openapi.ACTION_MSG_SENDED." + paramString.packageName);
        localIntent.putExtra("msgid", paramString.encrypt(String.valueOf(paramLong)));
        if (!paramBoolean) {
          break label171;
        }
      }
    }
    label171:
    for (int i = 0;; i = -9)
    {
      localIntent.putExtra("rs_code", i);
      BaseApplicationImpl.sApplication.sendBroadcast(localIntent, paramString.bUl);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akuo
 * JD-Core Version:    0.7.0.1
 */