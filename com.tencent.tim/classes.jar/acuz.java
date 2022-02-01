import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class acuz
  extends acuk
{
  public acuz(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean acr()
  {
    int j = 0;
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131696273, 1).show();
      return false;
    }
    Object localObject = (String)this.attrs.get("invitorId");
    int i = 10;
    for (;;)
    {
      try
      {
        k = Integer.parseInt((String)this.attrs.get("roomNum"));
        i = k;
      }
      catch (Exception localException3)
      {
        int k;
        long l1;
        long l2;
        label106:
        continue;
      }
      try
      {
        k = Integer.parseInt((String)this.attrs.get("zoneId"));
        j = k;
      }
      catch (Exception localException2) {}
    }
    l1 = -1L;
    try
    {
      l2 = Long.parseLong((String)this.attrs.get("gc"));
      l1 = l2;
    }
    catch (Exception localException1)
    {
      break label106;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new Intent(this.context, GameRoomTransActivity.class);
      ((Intent)localObject).putExtra("roomNum", i);
      ((Intent)localObject).putExtra("action", 3);
      ((Intent)localObject).putExtra("zoneId", j);
      ((Intent)localObject).putExtra("gc", l1);
      this.context.startActivity((Intent)localObject);
    }
    for (;;)
    {
      return true;
      Intent localIntent = new Intent(this.context, GameRoomTransActivity.class);
      localIntent.putExtra("inviteId", (String)localObject);
      localIntent.putExtra("roomNum", i);
      localIntent.putExtra("zoneId", j);
      localIntent.putExtra("action", 2);
      this.context.startActivity(localIntent);
    }
  }
  
  private boolean acs()
  {
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131696273, 1).show();
      return false;
    }
    int i = 10;
    for (;;)
    {
      try
      {
        j = Integer.parseInt((String)this.attrs.get("roomNum"));
        i = j;
      }
      catch (Exception localException2)
      {
        int j;
        Intent localIntent;
        continue;
      }
      try
      {
        j = Integer.parseInt((String)this.attrs.get("zoneId"));
        localIntent = new Intent(this.context, GameRoomTransActivity.class);
        localIntent.putExtra("roomNum", i);
        localIntent.putExtra("zoneId", j);
        localIntent.putExtra("action", 1);
        this.context.startActivity(localIntent);
        return true;
      }
      catch (Exception localException1)
      {
        j = 0;
      }
    }
  }
  
  public boolean ace()
  {
    try
    {
      if (this.ctj.equals("openInvitationRoom")) {
        return acr();
      }
      if (this.ctj.equals("enterGameRoom"))
      {
        boolean bool = acs();
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e("OpenWereWolfAction", 1, "doAction error: " + localException.getMessage());
      Ge("OpenWereWolfAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acuz
 * JD-Core Version:    0.7.0.1
 */