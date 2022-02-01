import android.app.Application;
import android.content.Intent;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.service.QQServiceForAV.e;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.QQAppInterface;

public class iup
  implements IBinder.DeathRecipient
{
  public iup(QQServiceForAV.e parame) {}
  
  public void binderDied()
  {
    igd.aK("QQServiceForAV", "binderDied, video process died!");
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a.getAppRuntime();
    if (localQQAppInterface != null) {
      localQQAppInterface.gi = null;
    }
    try
    {
      this.a.aqJ();
      if ((TextUtils.isEmpty(this.a.a.nS)) && (localQQAppInterface != null)) {
        this.a.a.nS = localQQAppInterface.getCurrentAccountUin();
      }
      str3 = this.a.a.mFriendUin;
      str4 = this.a.a.nS;
      if ((this.a.a.mUinType == 1004) || (this.a.a.mUinType == 1000) || (this.a.a.mUinType == 1020))
      {
        str2 = this.a.a.OD;
        Object localObject = str3;
        if ((localQQAppInterface != null) && (localQQAppInterface.bF()))
        {
          igd.aK("QQServiceForAV", "video chatting!");
          igd.aK("QQServiceForAV", "linkToVideoProcessDeath-->uinType=" + this.a.a.mUinType + " friendUin=" + (String)localObject + " senderUin=" + str2);
          if ((localObject == null) || (((String)localObject).length() <= 2)) {
            break label1060;
          }
          i = 1;
          if ((this.a.a.Vh) && (i != 0)) {
            VideoMsgTools.a(localQQAppInterface, this.a.a.mUinType, 45, true, (String)localObject, str2, true, null, true, new Object[0]);
          }
        }
        if (QQServiceForAV.a(this.a.a))
        {
          if (localQQAppInterface != null)
          {
            ihq.m("MobileQQ:BootAction", 5000L);
            localObject = new Intent("com.tencent.av.ui.VChatActivity");
            ((Intent)localObject).putExtra("uin", localQQAppInterface.getCurrentUin());
            ((Intent)localObject).putExtra("type", 1);
            ((Intent)localObject).putExtra("processExitTimestamp", System.currentTimeMillis());
            ((Intent)localObject).putExtra("source", 1);
            ((Intent)localObject).setPackage(this.a.a.getPackageName());
            ((Intent)localObject).setFlags(32);
            this.a.a.sendBroadcast((Intent)localObject);
          }
          QQServiceForAV.a(this.a.a, false);
        }
        localObject = new Intent();
        ((Intent)localObject).setAction("tencent.av.v2q.StopVideoChat");
        ((Intent)localObject).putExtra("uinType", this.a.a.mUinType);
        ((Intent)localObject).putExtra("bindType", this.a.a.mBindType);
        ((Intent)localObject).putExtra("bindId", this.a.a.mBindId);
        ((Intent)localObject).putExtra("peerUin", this.a.a.mFriendUin);
        ((Intent)localObject).putExtra("extraUin", this.a.a.OD);
        ((Intent)localObject).putExtra("stopReason", 0);
        ((Intent)localObject).putExtra("selfUin", localQQAppInterface.getCurrentUin());
        ((Intent)localObject).setPackage(this.a.a.getApplication().getPackageName());
        if ((this.a.a.mFriendUin != null) && ((this.a.a.mUinType != 1006) || (this.a.a.OD != null)))
        {
          igd.aK("QQServiceForAV", "ACTION_STOP_VIDEO_CHAT, stopReason = VideoConstants.CLOSE_DOUBLE, mUinType = " + this.a.a.mUinType + ", peerUin = " + this.a.a.mFriendUin);
          this.a.a.sendBroadcast((Intent)localObject);
        }
        if (localQQAppInterface != null)
        {
          long l1 = localQQAppInterface.a().bG();
          i = localQQAppInterface.a().lg();
          int j = (int)localQQAppInterface.a().d(i, l1);
          if ((l1 > 0L) && (this.a.a.Vh))
          {
            long l2 = Long.valueOf(localQQAppInterface.getCurrentAccountUin()).longValue();
            localObject = new Intent();
            ((Intent)localObject).setAction("tencent.av.v2q.MultiVideo");
            ((Intent)localObject).putExtra("type", 23);
            ((Intent)localObject).putExtra("friendUin", l2);
            ((Intent)localObject).putExtra("relationType", i);
            ((Intent)localObject).putExtra("relationId", l1);
            ((Intent)localObject).putExtra("from", "QQServiceForAV");
            ((Intent)localObject).putExtra("MultiAVType", localQQAppInterface.a().z(l1));
            if (j <= 1) {
              break label1065;
            }
            ((Intent)localObject).putExtra("roomUserNum", j - 1);
            ((Intent)localObject).setPackage(this.a.a.getApplication().getPackageName());
            igd.aK("QQServiceForAV", "linkToVideoProcessDeath MULTI_VIDEO_V2Q -->uinType=" + this.a.a.mUinType + " roomNum=" + j);
            this.a.a.sendBroadcast((Intent)localObject);
          }
          this.a.a.Vh = false;
          localQQAppInterface.a().bC(0, 0);
        }
        jko.bD(this.a.a.getApplicationContext());
        QQServiceForAV.b = null;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        String str3;
        String str4;
        int i;
        localRemoteException.printStackTrace();
        igd.aL("QQServiceForAV", "linkToDeath stopPumpMessage exception msg = " + localRemoteException.getMessage());
        continue;
        String str1 = str3;
        String str2 = str4;
        if (this.a.a.mUinType == 1006)
        {
          str1 = str3;
          str2 = str4;
          if (!str3.startsWith("+"))
          {
            str1 = this.a.a.OD;
            str2 = str4;
            continue;
            label1060:
            i = 0;
            continue;
            label1065:
            str1.putExtra("roomUserNum", 0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iup
 * JD-Core Version:    0.7.0.1
 */