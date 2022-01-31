import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ecr
  extends Handler
{
  public ecr(EditActivity paramEditActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          EditActivity.b(this.a, true);
        } while (!EditActivity.a(this.a));
        paramMessage = this.a.app.getPreferences().getString(this.a.app.a() + "sp_hot_status", "");
        if (QLog.isColorLevel()) {
          QLog.d("get_hot_rich_status", 2, "old_hot_action_ids: " + paramMessage);
        }
      } while ((paramMessage == null) || (paramMessage.length() <= 0));
      paramMessage = paramMessage.split(";");
    } while ((paramMessage == null) || (paramMessage.length <= 0));
    int i = 0;
    while ((i < 6) && (i < paramMessage.length))
    {
      if ((paramMessage[i] != null) && (paramMessage[i].length() > 0))
      {
        String[] arrayOfString = paramMessage[i].split(":");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {
          EditActivity.a(this.a).add(Integer.valueOf(Integer.parseInt(arrayOfString[0])));
        }
      }
      i += 1;
    }
    EditActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ecr
 * JD-Core Version:    0.7.0.1
 */