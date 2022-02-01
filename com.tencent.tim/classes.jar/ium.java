import android.content.Intent;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class ium
  extends acnd
{
  public ium(QQServiceForAV paramQQServiceForAV) {}
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    QLog.w("QQServiceForAV", 1, "onOIDB0X899_0_Ret, isSuccess[" + paramBoolean + "], troopuin[" + paramLong1 + "], nFlag[" + paramInt1 + "], lStartUin[" + paramLong2 + "], result[" + paramInt2 + "], strErrorMsg[" + paramString + "]");
    paramString = (QQAppInterface)this.a.getAppRuntime();
    if ((paramBoolean) && (paramInt1 == 2))
    {
      if (TextUtils.isEmpty(this.a.nS)) {
        this.a.nS = paramString.getCurrentAccountUin();
      }
      paramLong2 = Long.valueOf(this.a.nS).longValue();
      label152:
      oidb_0x899.memberlist localmemberlist;
      if (paramList == null)
      {
        paramInt1 = 0;
        paramInt2 = 0;
        if (paramInt2 >= paramInt1) {
          break label237;
        }
        localmemberlist = (oidb_0x899.memberlist)paramList.get(paramInt2);
        if ((localmemberlist != null) && (localmemberlist.uint64_member_uin.has())) {
          break label210;
        }
      }
      for (;;)
      {
        paramInt2 += 1;
        break label152;
        paramInt1 = paramList.size();
        break;
        label210:
        if (localmemberlist.uint64_member_uin.get() == paramLong2) {
          this.a.E(paramLong1, paramLong2);
        }
      }
      label237:
      paramList = paramString;
      if (paramString == null) {
        paramList = (QQAppInterface)this.a.getAppRuntime();
      }
      paramList.removeObserver(this.a.a);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4, int paramInt5, long paramLong)
  {
    paramString3 = (QQAppInterface)this.a.getAppRuntime();
    if (paramBoolean)
    {
      paramString4 = new Intent();
      paramString4.setAction("tencent.video.v2q.hide.webConfig");
      paramString4.putExtra("troopUin", paramString1);
      paramString4.putExtra("color", paramInt1);
      paramString4.putExtra("url", paramString2);
      paramString4.putExtra("grayFlag", paramInt2);
      paramString3.getApp().sendBroadcast(paramString4);
    }
    paramString3.removeObserver(this.a.a);
  }
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, int paramInt3)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.getAppRuntime();
    String str = localQQAppInterface.getApp().getString(paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, String.format("onJoinOrExitOpenTroop --> success: %b, troopUin: %s, errorTips: %s isJoin: %b , visitorSpeakEnabled: %b, speakInterval: %d, startSpeakInterval: %d", new Object[] { Boolean.valueOf(paramBoolean1), paramString, str, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    if (paramBoolean2)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.q2v.JoinOpenGroup");
      localIntent.putExtra("troopUin", paramString);
      localIntent.putExtra("success", paramBoolean1);
      localIntent.putExtra("errorTips", str);
      localIntent.putExtra("visitorSpeakEnabled", paramBoolean3);
      localIntent.putExtra("speakInterval", paramInt2);
      localIntent.putExtra("startSpeakInterval", paramInt3);
      localQQAppInterface.getApp().sendBroadcast(localIntent);
    }
    localQQAppInterface.removeObserver(this.a.a);
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.video.follow", 2, "QQServiceForAV, onGetFollowStatus:" + paramBoolean1 + "," + paramString + "," + paramBoolean2);
    }
    synchronized (this.a.mCallbacks)
    {
      int j = this.a.mCallbacks.beginBroadcast();
      int i = 0;
      if (i < j)
      {
        if (paramBoolean2) {}
        for (String str = "1";; str = "2") {
          try
          {
            ((itz)this.a.mCallbacks.getBroadcastItem(i)).d(paramBoolean1, paramString, str, "getFollowStatus");
            i += 1;
          }
          catch (RemoteException paramString)
          {
            if (!QLog.isColorLevel()) {
              break label168;
            }
            QLog.e("nearby.video.follow", 2, "QQServiceForAV, onGetFollowStatus:" + paramString.toString());
          }
        }
      }
      label168:
      this.a.mCallbacks.finishBroadcast();
      return;
    }
  }
  
  protected void b(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo)
  {
    synchronized (this.a.mCallbacks)
    {
      int j = this.a.mCallbacks.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((itz)this.a.mCallbacks.getBroadcastItem(i)).a(paramArrayOfRecvGVideoLevelInfo);
            i += 1;
          }
          catch (RemoteException paramArrayOfRecvGVideoLevelInfo)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQServiceForAV", 2, "callBack RemoteException", paramArrayOfRecvGVideoLevelInfo);
            }
          }
        }
      }
      this.a.mCallbacks.finishBroadcast();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ium
 * JD-Core Version:    0.7.0.1
 */