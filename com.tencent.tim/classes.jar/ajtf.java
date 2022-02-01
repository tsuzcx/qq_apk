import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class ajtf
  implements ardq.a<oidb_0x8e4.RspBody>
{
  public ajtf(GameRoomTransActivity paramGameRoomTransActivity, String paramString, int paramInt) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    String str3 = null;
    String str2;
    if (paramRspBody.string_err_title.has())
    {
      str2 = paramRspBody.string_err_title.get().toStringUtf8();
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {}
    }
    for (String str1 = null;; str1 = null)
    {
      str2 = str3;
      if (paramRspBody.string_err_msg.has())
      {
        str2 = paramRspBody.string_err_msg.get().toStringUtf8();
        if (!TextUtils.isEmpty(str2)) {
          break label578;
        }
        str2 = str3;
      }
      label578:
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqBaseActivity", 2, "onAcceptInvite invitedId = " + this.bSo + " errorCode = " + paramInt + " ,errTitle = " + str1 + " ,errMsgFromServer = " + str2);
        }
        if ((paramInt == 1000) || (paramInt == 1001) || (paramInt == 1002) || (paramInt == 1003) || (paramInt == 1007)) {
          this.a.dialog = ajtk.a(this.a, str1, str2);
        }
        for (;;)
        {
          if (this.a.dialog != null) {
            this.a.dialog.setOnDismissListener(this.a.j);
          }
          return;
          if ((paramInt == 1004) || (paramInt == 1006) || (paramInt == 1010) || (paramInt == 1013))
          {
            this.a.dialog = ajtk.a(this.a, str1, str2);
          }
          else
          {
            if ((paramInt == 0) || (paramInt == 1005))
            {
              paramRspBody = new Intent(this.a, GameRoomInviteActivity.class);
              paramRspBody.putExtra("inviteId", this.bSo);
              paramRspBody.putExtra("roomNum", this.dkW);
              GameRoomInviteActivity.bSp = this.bSo;
              this.a.startActivity(paramRspBody);
              this.a.finish();
              return;
            }
            if (paramInt == 1008)
            {
              str3 = paramRspBody.string_invite_id.get().toStringUtf8();
              GameRoomInviteActivity.bSp = str3;
              paramInt = this.dkW;
              if (paramRspBody.uint32_max_member_num.has()) {
                paramInt = paramRspBody.uint32_max_member_num.get();
              }
              this.a.dialog = ajtk.a(this.a, str1, str2, str3, paramInt);
            }
            else if (paramInt == 1009)
            {
              this.a.dialog = aqha.a(this.a, 230);
              this.a.dialog.setTitle(str1);
              this.a.dialog.setMessage(str2);
              this.a.dialog.setPositiveButton(acfp.m(2131706833), new ajtg(this, paramRspBody));
              this.a.dialog.setNegativeButton(2131690700, new ajth(this));
              if (!this.a.isFinishing()) {
                this.a.dialog.show();
              }
            }
            else
            {
              if (TextUtils.isEmpty(str2)) {
                break;
              }
              this.a.dialog = ajtk.a(this.a, str1, str2);
            }
          }
        }
        QQToast.a(this.a, 1, acfp.m(2131706809), 1).show();
        this.a.finish();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajtf
 * JD-Core Version:    0.7.0.1
 */