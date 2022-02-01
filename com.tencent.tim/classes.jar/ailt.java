import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.jsp.WebRecordApiPlugin;
import com.tencent.mobileqq.jsp.WebRecordApiPlugin.a;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ailt
  extends Handler
{
  public ailt(WebRecordApiPlugin.a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 16711687: 
      this.b.ap(0);
      return;
    case 16711686: 
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
      }
      WebRecordApiPlugin.a.a(this.b).stop();
      aqge.ce(2131230757, false);
      aqge.m(this.b.i, false);
      return;
    case 1: 
      this.b.ap(1);
      return;
    case 16711689: 
      localObject = (JSONObject)paramMessage.obj;
      paramMessage = ((JSONObject)localObject).optString("msg", "");
      localObject = ((JSONObject)localObject).optString("path", "");
      this.b.this$0.callJs(WebRecordApiPlugin.a(this.b.this$0), new String[] { "{'code':0,'recordID':'" + (String)localObject + "','result':" + paramMessage + "}" });
      return;
    }
    Object localObject = (JSONObject)paramMessage.obj;
    paramMessage = ((JSONObject)localObject).optString("msg", "");
    localObject = ((JSONObject)localObject).optString("path", "");
    this.b.this$0.callJs(WebRecordApiPlugin.a(this.b.this$0), new String[] { "{'code':1,'recordID':'" + (String)localObject + "','msg':'" + paramMessage + "'}" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ailt
 * JD-Core Version:    0.7.0.1
 */