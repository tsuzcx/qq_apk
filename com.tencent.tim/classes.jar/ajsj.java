import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.a;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.b;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody.PlayerState;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody.WifiPOIInfo;

public class ajsj
  extends arec
{
  public ajsj(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void DC(int paramInt)
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView == null) || (this.this$0.isFinishing())) {}
    do
    {
      return;
      if (paramInt == 0)
      {
        this.this$0.isLoading = false;
        this.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.ehz();
        this.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setComplete(new ajsk(this));
        this.this$0.report("load_page", "suc_cnt");
        return;
      }
    } while (paramInt == 4);
    if (this.this$0.retryTimes > 3)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.my.setText(acfp.m(2131706795));
      this.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.ehz();
      this.this$0.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setProgress(0);
      this.this$0.isLoading = false;
      return;
    }
    this.this$0.isLoading = true;
    this.this$0.jdField_a_of_type_Aree.cgp();
    GameRoomInviteActivity localGameRoomInviteActivity = this.this$0;
    localGameRoomInviteActivity.retryTimes += 1;
  }
  
  public void a(submsgtype0xdd.MsgBody paramMsgBody)
  {
    Object localObject;
    switch (paramMsgBody.uint32_msg_type.get())
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("GameRoomInviteActivity", 2, "the 0xdd push type is wrong:" + paramMsgBody.uint32_msg_type.get());
      }
    case 1: 
      do
      {
        return;
        localObject = this.this$0;
        int i;
        if ((!paramMsgBody.uint64_invite_leader.has()) || (paramMsgBody.uint64_invite_leader.get() == this.this$0.app.getLongAccountUin()))
        {
          bool = true;
          ((GameRoomInviteActivity)localObject).ni = bool;
          this.this$0.mUsers = new ArrayList();
          i = 0;
          if (i >= paramMsgBody.rpt_msg_player_state.size()) {
            continue;
          }
          localObject = new GameRoomInviteActivity.a(this.this$0);
          submsgtype0xdd.MsgBody.PlayerState localPlayerState = (submsgtype0xdd.MsgBody.PlayerState)paramMsgBody.rpt_msg_player_state.get(i);
          ((GameRoomInviteActivity.a)localObject).uin = (localPlayerState.uint64_uin.get() + "");
          if (localPlayerState.uint32_state.get() != 1) {
            break label250;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          ((GameRoomInviteActivity.a)localObject).isPrepared = bool;
          this.this$0.mUsers.add(localObject);
          i += 1;
          break label135;
          bool = false;
          break;
        }
      } while (this.this$0.isLoading);
      this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity$b.notifyDataSetChanged();
      this.this$0.refreshUI();
      return;
    case 2: 
      paramMsgBody = (submsgtype0xdd.MsgBody.WifiPOIInfo)paramMsgBody.msg_poi_info.get();
      localObject = paramMsgBody.bytes_uid.get().toStringUtf8();
      this.this$0.a(HotChatInfo.createHotChat(paramMsgBody, false, 0), paramMsgBody.uint32_group_code.get(), (String)localObject, paramMsgBody.bytes_name.get().toStringUtf8());
      ajrb.c(this.this$0.app.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(anaz.gQ()));
      return;
    case 3: 
      label135:
      label250:
      QQToast.a(this.this$0, acfp.m(2131706820), 0).show();
      this.this$0.finish();
      this.this$0.mUsers = null;
      aqmj.a(this.this$0, this.this$0.app.getCurrentAccountUin(), false, System.currentTimeMillis());
      return;
    }
    this.this$0.P(null, acfp.m(2131706797), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajsj
 * JD-Core Version:    0.7.0.1
 */