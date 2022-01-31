import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import org.json.JSONObject;

class zaz
  extends Handler
{
  zaz(zay paramzay, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject;
    int i;
    if ((paramMessage.what == 203) && ((paramMessage.obj instanceof Bundle)))
    {
      paramMessage = (Bundle)paramMessage.obj;
      localObject = paramMessage.getString("url");
      if ((paramMessage.getInt("req_state", 0) == 2) && (!TextUtils.isEmpty(zay.a(this.a))) && (!TextUtils.isEmpty(zay.b(this.a))) && (zay.b(this.a).equals(localObject)))
      {
        i = paramMessage.getInt("result_code");
        localObject = new JSONObject();
        if (i != 0) {
          break label158;
        }
      }
    }
    try
    {
      ((JSONObject)localObject).put("code", 0);
      for (;;)
      {
        label113:
        this.a.callJs(zay.a(this.a) + "(" + ((JSONObject)localObject).toString() + ");");
        return;
        label158:
        ((JSONObject)localObject).put("code", i);
        ((JSONObject)localObject).put("msg", paramMessage.getString("error_message"));
      }
    }
    catch (Exception paramMessage)
    {
      break label113;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zaz
 * JD-Core Version:    0.7.0.1
 */