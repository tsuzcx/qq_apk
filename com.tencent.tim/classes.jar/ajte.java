import android.text.TextUtils;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class ajte
  implements ardq.a<oidb_0x8e4.RspBody>
{
  public ajte(GameRoomTransActivity paramGameRoomTransActivity, int paramInt) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    Object localObject3 = null;
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "quickStartGame onCallback errorCode = " + paramInt);
    }
    Object localObject2;
    if (paramRspBody.string_err_title.has())
    {
      localObject2 = paramRspBody.string_err_title.get().toStringUtf8();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    }
    for (Object localObject1 = null;; localObject1 = null)
    {
      localObject2 = localObject3;
      if (paramRspBody.string_err_msg.has())
      {
        localObject2 = paramRspBody.string_err_msg.get().toStringUtf8();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label450;
        }
        localObject2 = localObject3;
      }
      label450:
      for (;;)
      {
        if ((paramInt == 1000) || (paramInt == 1001) || (paramInt == 1002) || (paramInt == 1003) || (paramInt == 1007)) {
          this.a.dialog = ajtk.a(this.a, (String)localObject1, (String)localObject2);
        }
        for (;;)
        {
          if (this.a.dialog != null) {
            this.a.dialog.setOnDismissListener(this.a.j);
          }
          return;
          if ((paramInt == 1004) || (paramInt == 1006) || (paramInt == 1010) || (paramInt == 1013))
          {
            this.a.dialog = ajtk.a(this.a, (String)localObject1, (String)localObject2);
          }
          else
          {
            if ((paramInt == 0) || (paramInt == 1009))
            {
              paramRspBody = paramRspBody.poi_info;
              localObject1 = paramRspBody.bytes_uid.get().toStringUtf8();
              ajtk.a(this.a, HotChatInfo.createHotChat(paramRspBody, false, 0), paramRspBody.uint32_group_code.get(), (String)localObject1, paramRspBody.bytes_name.get().toStringUtf8());
              this.a.finish();
              return;
            }
            if (paramInt == 1008)
            {
              localObject1 = paramRspBody.string_invite_id.get().toStringUtf8();
              com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.bSp = (String)localObject1;
              paramInt = this.dkW;
              if (paramRspBody.uint32_max_member_num.has()) {
                paramInt = paramRspBody.uint32_max_member_num.get();
              }
              this.a.dialog = ajtk.a(this.a, (String)localObject1, paramInt);
            }
            else
            {
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break;
              }
              this.a.dialog = ajtk.a(this.a, (String)localObject1, (String)localObject2);
            }
          }
        }
        QQToast.a(this.a, 1, acfp.m(2131706813), 1).show();
        if (QLog.isColorLevel()) {
          QLog.d("qqBaseActivity", 2, "start game failed! code = " + paramInt);
        }
        GameRoomTransActivity.a(this.a);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajte
 * JD-Core Version:    0.7.0.1
 */