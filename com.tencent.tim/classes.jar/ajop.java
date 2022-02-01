import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class ajop
{
  WeakReference<QQAppInterface> ar;
  int interval = 1800;
  
  public ajop(QQAppInterface paramQQAppInterface)
  {
    this.ar = new WeakReference(paramQQAppInterface);
  }
  
  public void MF(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.ar.get();
    if (localQQAppInterface == null) {}
    acff localacff;
    ExtensionInfo localExtensionInfo;
    boolean bool1;
    int i;
    int j;
    long l1;
    boolean bool2;
    label144:
    do
    {
      do
      {
        return;
        localacff = (acff)localQQAppInterface.getManager(51);
        localExtensionInfo = localacff.a(paramString, true);
        bool1 = localacff.aL(false);
      } while ((bool1) || (localExtensionInfo == null));
      i = ajol.a(6, paramString, localExtensionInfo, bool1);
      j = ajol.a(5, paramString, localExtensionInfo, bool1);
      l1 = localExtensionInfo.lastFriendshipTime;
      l2 = localExtensionInfo.lastChatTime;
      int k = ajol.Gx();
      bool1 = ajol.q(k, l2 * 1000L);
      bool2 = ajol.q(k, l1 * 1000L);
      if (((i <= 0) || (!bool2)) && ((j <= 0) || (!bool1))) {
        break;
      }
      bool1 = true;
      if (!bool1) {
        break label499;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendReactive.ReCheckInHelper", 2, String.format("startCheck bRemind=%b frdshipType=%d fire=%d uin=%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), Integer.valueOf(j), paramString }));
      }
      l2 = localExtensionInfo.lastHotReactiveReCheckInTs;
      this.interval = BaseApplicationImpl.getContext().getSharedPreferences(localQQAppInterface.getCurrentAccountUin(), 0).getInt("hotreactive_recheckin_interval", 1800);
      l1 = SystemClock.elapsedRealtime();
    } while (l1 - l2 < this.interval * 1000);
    long l2 = localExtensionInfo.localChatSendTs;
    long l3 = localExtensionInfo.localChatRecTs;
    if (aqmu.J(l2) == 2131721204)
    {
      bool1 = true;
      label279:
      if (aqmu.J(l3) != 2131721204) {
        break label507;
      }
      bool2 = true;
      label292:
      if (QLog.isColorLevel()) {
        QLog.i("FriendReactive.ReCheckInHelper", 2, String.format("startCheck msg bSendToday=%b bRecToday=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      if (bool1) {
        break label530;
      }
      l2 = c(paramString, true);
      if (aqmu.J(l2) != 2131721204) {
        break label513;
      }
      bool1 = true;
      label355:
      if (!bool1) {
        break label525;
      }
      localExtensionInfo.localChatSendTs = l2;
      i = 1;
    }
    for (;;)
    {
      j = i;
      boolean bool3 = bool2;
      if (!bool2)
      {
        l2 = c(paramString, false);
        if (aqmu.J(l2) != 2131721204) {
          break label519;
        }
      }
      label513:
      label519:
      for (bool2 = true;; bool2 = false)
      {
        j = i;
        bool3 = bool2;
        if (bool2)
        {
          localExtensionInfo.localChatRecTs = l2;
          j = 1;
          bool3 = bool2;
        }
        i = j;
        if (bool3)
        {
          i = j;
          if (bool1)
          {
            i = j;
            if (AppNetConnInfo.isNetSupport())
            {
              localExtensionInfo.lastHotReactiveReCheckInTs = l1;
              i = 1;
              if (QLog.isColorLevel()) {
                QLog.i("FriendReactive.ReCheckInHelper", 2, "startCheck recheckin");
              }
              ((FriendListHandler)localQQAppInterface.getBusinessHandler(1)).DL(paramString);
            }
          }
        }
        if (i == 0) {
          break;
        }
        localacff.a(localExtensionInfo);
        return;
        bool1 = false;
        break label144;
        label499:
        break;
        bool1 = false;
        break label279;
        label507:
        bool2 = false;
        break label292;
        bool1 = false;
        break label355;
      }
      label525:
      i = 0;
      continue;
      label530:
      i = 0;
    }
  }
  
  public long c(String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.ar.get();
    if (localQQAppInterface == null) {
      return 0L;
    }
    String str;
    if (paramBoolean)
    {
      str = "issend<>0";
      paramString = localQQAppInterface.b().b(paramString, 0, str);
      if (paramString != null) {
        break label59;
      }
    }
    label59:
    for (long l = 0L;; l = paramString.time)
    {
      return 1000L * l;
      str = "issend=0";
      break;
    }
  }
  
  public void e(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if ((QQAppInterface)this.ar.get() == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("FriendReactive.ReCheckInHelper", 2, String.format("onRecheckInResp isSuc=%b selfUin=%s frdUin=%s interval=%d", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2, Integer.valueOf(paramInt) }));
      }
    } while ((!paramBoolean) || (paramInt <= 0) || (paramInt == this.interval));
    BaseApplicationImpl.getContext().getSharedPreferences(paramString1, 0).edit().putInt("hotreactive_recheckin_interval", paramInt).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajop
 * JD-Core Version:    0.7.0.1
 */