import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class acxi
  extends acuk
{
  public acxi(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean acU()
  {
    i = 0;
    Object localObject = (String)this.attrs.get("guin");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!TroopInfo.isTroopMember(this.app, (String)localObject)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopProfileAction", 2, new Object[] { "illegal goToTroopProfileApp jumpAction. troopUin=", localObject });
      }
      return false;
    }
    String str = (String)this.attrs.get("type");
    if ("group_file".equals(str)) {
      apuh.b(this.app, (Activity)this.context, (String)localObject);
    }
    for (;;)
    {
      return true;
      if ("group_album".equals(str)) {
        str = (String)this.attrs.get("gname");
      }
      try
      {
        j = Integer.parseInt((String)this.attrs.get("unreadnum"));
        i = j;
      }
      catch (NumberFormatException localNumberFormatException4)
      {
        int j;
        label148:
        break label148;
      }
      apuh.a(this.app, (Activity)this.context, (String)localObject, str, i);
      continue;
      if ("group_story".equals(str)) {
        for (;;)
        {
          for (;;)
          {
            int k;
            int m;
            try
            {
              if (this.attrs.containsKey("troopStoryMemoriesFrom")) {
                i = Integer.parseInt((String)this.attrs.get("troopStoryMemoriesFrom"));
              }
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              i = 0;
              j = 0;
            }
            try
            {
              k = Integer.parseInt((String)this.attrs.get("playVideoFrom"));
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              for (;;)
              {
                label292:
                Bundle localBundle;
                k = 0;
                j = i;
                i = k;
              }
            }
            try
            {
              m = Integer.parseInt((String)this.attrs.get("lastOpenFrom"));
              j = i;
              localObject = QQStoryShareGroupProfileActivity.a(this.context, 1, null, (String)localObject, j, k);
              ((Intent)localObject).putExtra("extra_last_open_from", m);
              this.context.startActivity((Intent)localObject);
            }
            catch (NumberFormatException localNumberFormatException3)
            {
              j = i;
              i = k;
              break label292;
            }
          }
          i = 8;
          continue;
          m = 0;
          k = i;
        }
      }
      if (!"bulk_send_message".equals(localNumberFormatException1)) {
        break;
      }
      localObject = (String)this.attrs.get("gc");
      localBundle = new Bundle();
      localBundle.putString("extra.GROUP_UIN", (String)localObject);
      localBundle.putString("selfSet_leftViewText", acfp.m(2131707537));
      BulkSendMessageFragment.p((Activity)this.context, localBundle);
    }
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acU();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("TroopProfileAction", 1, "doAction error: " + localException.getMessage());
      Ge("TroopProfileAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acxi
 * JD-Core Version:    0.7.0.1
 */