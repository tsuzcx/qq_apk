import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;

public class acwy
  extends acuk
{
  public acwy(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void cOH()
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("fromTranslucent", 1);
    try
    {
      long l1 = Long.parseLong(getAttribute("uin"));
      int i = Integer.parseInt(getAttribute("appid"));
      Object localObject2 = getAttribute("cellid");
      Object localObject3 = getAttribute("subid");
      long l2 = Long.parseLong(getAttribute("time"));
      ((Bundle)localObject1).putLong("targetuin", Long.valueOf(l1).longValue());
      ((Bundle)localObject1).putInt("appid", i);
      ((Bundle)localObject1).putString("cellid", (String)localObject2);
      ((Bundle)localObject1).putString("subid", (String)localObject3);
      ((Bundle)localObject1).putLong("feedtime", l2);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      QzonePluginProxyActivity.x((Intent)localObject2, "com.qzone.detail.ui.activity.StickyNoteDetailActivity");
      if ((this.context instanceof BaseActivity))
      {
        localObject3 = (BaseActivity)this.context;
        localObject1 = null;
        if (((BaseActivity)localObject3).app != null) {
          localObject1 = ((BaseActivity)localObject3).app.getCurrentUin();
        }
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          QLog.e("StickyNoteAction", 1, "action_open_sticky_note_feed_detail  error! get currentUin failed! " + ((BaseActivity)localObject3).app);
          return;
        }
        QzonePluginProxyActivity.a((Activity)localObject3, (String)localObject1, (Intent)localObject2, 7, true);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("StickyNoteAction", 1, "action_open_sticky_note_feed_detail  error!", localThrowable);
    }
  }
  
  public boolean ace()
  {
    try
    {
      if ("feeddetail".equals(this.ctj))
      {
        cOH();
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      QLog.e("StickyNoteAction", 1, "doAction error: " + localException.getMessage());
      Ge("StickyNoteAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acwy
 * JD-Core Version:    0.7.0.1
 */