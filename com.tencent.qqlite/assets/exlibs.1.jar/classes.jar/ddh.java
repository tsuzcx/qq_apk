import android.os.Message;
import com.tencent.mobileqq.activity.IndividuationSetActivity.EmojiJsBridgeListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emoji.EmojiJsHandler;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ddh
  extends TransProcessorHandler
{
  public ddh(EmojiJsHandler paramEmojiJsHandler) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (!((FileMsg)paramMessage.obj).e.startsWith(AppConstants.bw)) {
      if (QLog.isColorLevel()) {
        QLog.d("Emoji.EmojiJsHandler", 2, "not download emoji file message" + AppConstants.bw);
      }
    }
    label52:
    do
    {
      do
      {
        do
        {
          break label52;
          do
          {
            return;
          } while (paramMessage.what == 2002);
          if (paramMessage.what != 2003) {
            break;
          }
          try
          {
            if ((this.a.b != null) && (this.a.b.isShowing())) {
              this.a.b.dismiss();
            }
            EmojiJsHandler.a(this.a, "0");
            paramMessage = new JSONObject();
            paramMessage.put("result", 0);
            paramMessage.put("message", "ok, Emoji downloaded.");
            paramMessage.put("what", 1016);
            EmojiJsHandler.a(this.a).a(paramMessage);
            return;
          }
          catch (Exception paramMessage)
          {
            paramMessage.printStackTrace();
          }
        } while (EmojiJsHandler.a(this.a) == null);
        EmojiJsHandler.a(this.a).a("File download finish Exception:" + paramMessage.getMessage());
        return;
        if (paramMessage.what != 2005) {
          break;
        }
        if ((this.a.b != null) && (this.a.b.isShowing())) {
          this.a.b.dismiss();
        }
        try
        {
          EmojiJsHandler.a(this.a, "2");
          paramMessage = new JSONObject();
          paramMessage.put("result", -1);
          paramMessage.put("message", "recv error");
          paramMessage.put("what", 1017);
          EmojiJsHandler.a(this.a).a(paramMessage);
          return;
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
        }
      } while (EmojiJsHandler.a(this.a) == null);
      EmojiJsHandler.a(this.a).a("File download revice error Exception:" + paramMessage.getMessage());
      return;
    } while (!QLog.isColorLevel());
    QLog.d("Emoji.EmojiJsHandler", 2, "" + paramMessage.what);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ddh
 * JD-Core Version:    0.7.0.1
 */