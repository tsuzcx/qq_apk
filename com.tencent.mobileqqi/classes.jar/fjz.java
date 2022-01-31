import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.av.gaudio.GAudioNotifyCenter;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.voip.VoipContact;
import com.tencent.mobileqq.activity.voip.VoipPhoneNumber;
import com.tencent.mobileqq.activity.voip.VoipQCallTimeOutActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class fjz
  extends BroadcastReceiver
{
  public fjz(QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    int i;
    int j;
    boolean bool3;
    String str2;
    boolean bool4;
    boolean bool5;
    boolean bool1;
    boolean bool2;
    if (str1.equals("tencent.video.v2q.AddVideoMsg"))
    {
      i = paramIntent.getIntExtra("uinType", 0);
      j = paramIntent.getIntExtra("msgType", 5);
      bool3 = paramIntent.getBooleanExtra("isVideoMsg", true);
      str1 = paramIntent.getStringExtra("friendUin");
      str2 = paramIntent.getStringExtra("senderUin");
      bool4 = paramIntent.getBooleanExtra("isSender", true);
      bool5 = paramIntent.getBooleanExtra("isRead", false);
      paramIntent = paramIntent.getStringExtra("extra");
      if ((j != 2) || (paramIntent != null) || (!QQUtils.a(this.a.a()))) {
        break label1787;
      }
      this.a.i = true;
      bool1 = SettingCloneUtil.readValue(this.a.a(), this.a.a(), this.a.a().getString(2131562309), "qqsetting_lock_screen_whenexit_key", true);
      bool2 = SettingCloneUtil.readValue(this.a.a(), this.a.a(), this.a.a().getString(2131563430), "qqsetting_notify_showcontent_key", true);
      if ((bool1) && (bool2))
      {
        Handler localHandler = this.a.a(ChatActivity.class);
        if (localHandler != null) {
          localHandler.sendMessage(localHandler.obtainMessage(16711696));
        }
      }
    }
    for (;;)
    {
      VideoMsgTools.a(this.a, i, j, bool3, str1, str2, bool4, paramIntent, bool5);
      if ((bool1) && (bool2) && (SettingCloneUtil.readValue(this.a.a(), this.a.a(), null, "qqsetting_msg_lockscreen_key", true)))
      {
        QQLSRecentManager.a().a(this.a, str1, i);
        paramIntent = new Intent(this.a.a(), QQLSActivity.class);
        paramIntent.addFlags(67108864);
        paramIntent.addFlags(268435456);
        paramIntent.addFlags(262144);
        paramIntent.addFlags(1073741824);
        this.a.a().startActivity(paramIntent);
      }
      if (j == 12)
      {
        paramIntent = (PhoneContactManager)this.a.getManager(10);
        if (paramIntent != null)
        {
          paramIntent = paramIntent.a(str1, null, null);
          if (paramIntent.phoneNumber != null) {
            break label388;
          }
        }
      }
      label387:
      label388:
      label730:
      do
      {
        long l1;
        long l2;
        do
        {
          do
          {
            break label387;
            break label387;
            break label387;
            break label387;
            do
            {
              return;
            } while (paramIntent.phoneNumber.a.length() <= 0);
            paramIntent = new Intent(paramContext, VoipQCallTimeOutActivity.class);
            paramIntent.addFlags(268435456);
            paramIntent.addFlags(536870912);
            paramIntent.addFlags(67108864);
            paramIntent.addFlags(131072);
            paramIntent.putExtra("senderUin", str2);
            paramIntent.putExtra("friendUin", str1);
            paramIntent.putExtra("isVideoMsg", bool3);
            paramIntent.putExtra("uinType", i);
            paramContext.startActivity(paramIntent);
            return;
            if (str1.equals("tencent.video.v2q.VideoFlowSize"))
            {
              l1 = paramIntent.getLongExtra("size", 0L);
              if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
                QLog.d(QQAppInterface.a, 2, "ACTION_VIDEO_FLOW_SIZE: " + l1);
              }
              this.a.a(this.a.getAccount(), new String[] { "param_XGVideoFlow", "param_XGFlow", "param_Flow" }, l1);
              return;
            }
            if (!str1.equals("tencent.av.v2q.MultiVideo")) {
              break;
            }
            i = paramIntent.getIntExtra("type", 20);
            bool1 = paramIntent.getBooleanExtra("isStart", false);
            if (i == 22)
            {
              l1 = paramIntent.getLongExtra("discussId", 0L);
              l2 = paramIntent.getLongExtra("friendUin", 0L);
              j = paramIntent.getIntExtra("roomUserNum", 0);
              this.a.a().a(3);
              if (l2 == Long.valueOf(this.a.a()).longValue())
              {
                this.a.j = true;
                this.a.a().a(3);
                this.a.a().a(Long.valueOf(l1), true);
                this.a.a().a(l1);
                if (j == 1)
                {
                  this.a.a().a(true);
                  paramContext = this.a.a().a();
                  if (paramContext != null)
                  {
                    paramIntent = paramContext.a(String.valueOf(l1), 3000);
                    if (paramIntent != null)
                    {
                      paramIntent.lastmsgtime = MessageCache.a();
                      paramContext.a(paramIntent);
                    }
                  }
                  ((QCallFacade)this.a.getManager(36)).a(l1, l2, true, -1L, bool1);
                }
              }
              for (;;)
              {
                this.a.a().a(i, l1, l2);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d(QQAppInterface.a, 2, "member join discussId: " + l1 + ", friendUin: " + l2);
                return;
                this.a.a().a(false);
                this.a.a().b(true);
                break label730;
                if ((this.a.a().a() == l1) && (this.a.a().b()))
                {
                  this.a.a().a(false);
                  this.a.a().b(true);
                }
              }
            }
          } while (i != 23);
          l1 = paramIntent.getLongExtra("discussId", 0L);
          l2 = paramIntent.getLongExtra("friendUin", 0L);
          j = paramIntent.getIntExtra("roomUserNum", 0);
          if (l2 == Long.valueOf(this.a.a()).longValue())
          {
            long l3 = paramIntent.getLongExtra("time", 0L);
            this.a.a().a(0);
            this.a.a().b(false);
            this.a.a().a(Long.valueOf(l1), false);
            this.a.a().b(l1);
            this.a.a().a(0);
            this.a.j = false;
            ((QCallFacade)this.a.getManager(36)).a(l1, l2, false, l3, bool1);
          }
          if (j == 1) {
            this.a.a().a(true);
          }
          this.a.a().a(i, l1, l2);
        } while (!QLog.isColorLevel());
        QLog.d(QQAppInterface.a, 2, "member quit discussId: " + l1 + ", friendUin: " + l2);
        return;
        if (str1.equals("tencent.av.v2q.StartVideoChat"))
        {
          this.a.j = true;
          i = paramIntent.getIntExtra("sessionType", 0);
          j = paramIntent.getIntExtra("uinType", 0);
          paramContext = paramIntent.getStringExtra("peerUin");
          str1 = paramIntent.getStringExtra("extraUin");
          bool2 = paramIntent.getBooleanExtra("updateTime", false);
          bool1 = paramIntent.getBooleanExtra("showTime", false);
          if (bool2)
          {
            this.a.a().d(true);
            this.a.a().b(true);
          }
          this.a.a().a(i);
          paramIntent = this.a.a();
          if (!bool1) {}
          for (bool1 = true;; bool1 = false)
          {
            paramIntent.a(bool1);
            this.a.a().a(j, paramContext, str1);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(QQAppInterface.a, 2, "start video chat sessionType: " + i + ", updateTime: " + bool2);
            return;
          }
        }
        if (str1.equals("tencent.av.v2q.StopVideoChat"))
        {
          if (QLog.isColorLevel()) {
            QLog.d(QQAppInterface.a, 2, "stop video chat");
          }
          i = paramIntent.getIntExtra("uinType", 0);
          paramContext = paramIntent.getStringExtra("peerUin");
          str1 = paramIntent.getStringExtra("extraUin");
          j = paramIntent.getIntExtra("stopReason", -1);
          if ((j == 3) || (j == 5) || (j == 1))
          {
            this.a.j = true;
            this.a.a().a(3);
          }
          for (;;)
          {
            this.a.a().a(i, paramContext, str1);
            this.a.a().a(28, i, paramContext, str1);
            if ((j != 2) && (j != 3) && (j != 4) && (j != 5)) {
              break;
            }
            ((QCallFacade)this.a.getManager(36)).a(str1, paramContext);
            return;
            this.a.j = false;
            this.a.a().b(false);
            this.a.a().a(0);
          }
        }
        if (str1.equals("tencent.av.v2q.AvSwitch"))
        {
          i = paramIntent.getIntExtra("sessionType", 0);
          if (QLog.isColorLevel()) {
            QLog.d(QQAppInterface.a, 2, "av swith to " + i);
          }
          this.a.a().a(i);
          return;
        }
        if (str1.equals("tencent.video.v2q.AddMsgSig"))
        {
          i = paramIntent.getIntExtra("uinType", 0);
          paramContext = paramIntent.getStringExtra("peerUin");
          str1 = paramIntent.getStringExtra("extraUin");
          paramIntent = paramIntent.getByteArrayExtra("sig");
          VideoMsgTools.a(this.a, i, paramContext, str1, paramIntent);
          return;
        }
        if (str1.equals("tencent.video.v2q.AddContactsToDiscuss"))
        {
          if (QLog.isColorLevel()) {
            QLog.d(QQAppInterface.a, 2, "addDiscussMember");
          }
          paramContext = paramIntent.getStringExtra("discussUin");
          VideoMsgTools.a(this.a, paramContext);
          return;
        }
      } while (!str1.equals("tencent.video.v2q.AddContactsFromC2C"));
      if (QLog.isColorLevel()) {
        QLog.d(QQAppInterface.a, 2, "addDiscussMemberFromC2C");
      }
      paramContext = paramIntent.getStringExtra("peerUin");
      VideoMsgTools.b(this.a, paramContext);
      return;
      label1787:
      bool1 = false;
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fjz
 * JD-Core Version:    0.7.0.1
 */