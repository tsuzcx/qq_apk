import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

class yaf
  implements ardq.a<oidb_0x8e4.RspBody>
{
  yaf(xzp paramxzp) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if (paramRspBody == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "startAnotherRound failed! errorCode = " + paramInt);
      }
    }
    do
    {
      QQToast.a(this.this$0.a(), 1, acfp.m(2131706793), 1).show();
      return;
      while ((!paramRspBody.getBooleanExtra("finishAIO", false)) || (!(this.this$0.mActivity instanceof ChatActivity)))
      {
        Common.WifiPOIInfo localWifiPOIInfo = paramRspBody.poi_info;
        HotChatInfo localHotChatInfo = HotChatInfo.createHotChat(localWifiPOIInfo, false, 0);
        localHotChatInfo.isGameRoom = true;
        paramRspBody = this.this$0.app.a(true);
        Object localObject = paramRspBody.dX();
        if ((localObject != null) && (!((List)localObject).contains(localHotChatInfo))) {
          ((List)localObject).add(localHotChatInfo);
        }
        paramRspBody.a(localHotChatInfo, 4);
        localObject = this.this$0.a().getIntent();
        paramRspBody = (oidb_0x8e4.RspBody)localObject;
        if (localObject == null) {
          paramRspBody = new Intent();
        }
        localObject = localWifiPOIInfo.bytes_uid.get().toStringUtf8();
        paramRspBody.putExtra("uin", localHotChatInfo.troopUin + "");
        paramRspBody.putExtra("uintype", 1);
        paramRspBody.putExtra("troop_uin", localHotChatInfo.troopUin + "");
        paramRspBody.putExtra("uinname", localHotChatInfo.name);
        paramRspBody.putExtra("hotnamecode", (String)localObject);
        paramRspBody.putExtra("isNeedShowLoading", false);
        paramRspBody.putExtra("leftViewText", this.this$0.a().getString(2131690700));
        ajrb.c(this.this$0.app.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(anaz.gQ()));
        paramInt = wja.a(this.this$0.app, this.this$0.mActivity, paramRspBody);
        if (paramInt != 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.TAG, 2, "openAIO by start SplashAct");
        }
        localObject = this.this$0.a.a();
        if (localObject != null) {
          ((ared)localObject).onDestroy();
        }
        this.this$0.mActivity.startActivity(paramRspBody);
      }
      this.this$0.mActivity.finish();
      return;
    } while (paramInt != 2);
    QLog.e(this.this$0.TAG, 1, "openAIO rediectToAIOWithMt 2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     yaf
 * JD-Core Version:    0.7.0.1
 */