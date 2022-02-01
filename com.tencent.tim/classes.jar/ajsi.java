import android.util.SparseArray;
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
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.PlayerState;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class ajsi
  implements ardq.a<oidb_0x8e4.RspBody>
{
  public ajsi(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    boolean bool2 = false;
    if (this.this$0.isFinishing()) {}
    label192:
    do
    {
      return;
      if ((paramInt == 0) || (paramInt == 1008) || (paramInt == 1009) || (paramInt == 1010))
      {
        if ((paramInt == 1009) && (this.this$0.OG != null) && (this.this$0.OG.equals(GameRoomInviteActivity.bSp)))
        {
          paramRspBody = paramRspBody.poi_info;
          localObject = paramRspBody.bytes_uid.get().toStringUtf8();
          this.this$0.a(HotChatInfo.createHotChat(paramRspBody, false, 0), paramRspBody.uint32_group_code.get(), (String)localObject, paramRspBody.bytes_name.get().toStringUtf8());
          return;
        }
        Object localObject = this.this$0;
        if (paramRspBody.uint32_refresh_interval.has())
        {
          paramInt = paramRspBody.uint32_refresh_interval.get() * 1000;
          ((GameRoomInviteActivity)localObject).dkV = paramInt;
          this.this$0.dkV = Math.max(1000, this.this$0.dkV);
          this.this$0.mUsers = new ArrayList();
          paramInt = 0;
          if (paramInt >= paramRspBody.rpt_msg_player_state.size()) {
            break label314;
          }
          localObject = new GameRoomInviteActivity.a(this.this$0);
          oidb_0x8e4.PlayerState localPlayerState = (oidb_0x8e4.PlayerState)paramRspBody.rpt_msg_player_state.get(paramInt);
          ((GameRoomInviteActivity.a)localObject).uin = (localPlayerState.uint64_uin.get() + "");
          if (localPlayerState.uint32_state.get() != 1) {
            break label309;
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          ((GameRoomInviteActivity.a)localObject).isPrepared = bool1;
          this.this$0.mUsers.add(localObject);
          paramInt += 1;
          break label192;
          paramInt = 1000;
          break;
        }
        if (paramRspBody.uint32_max_member_num.has()) {
          this.this$0.dkT = paramRspBody.uint32_max_member_num.get();
        }
        if (paramRspBody.uint32_zone_id.has()) {
          this.this$0.dkU = paramRspBody.uint32_zone_id.get();
        }
        this.this$0.mOwnerUin = paramRspBody.uint64_leader_uin.get();
        localObject = this.this$0;
        if ((paramRspBody.uint64_leader_uin.has()) && (this.this$0.mOwnerUin != this.this$0.app.getLongAccountUin()))
        {
          bool1 = bool2;
          if (!this.this$0.mUsers.isEmpty()) {}
        }
        else
        {
          bool1 = true;
        }
        ((GameRoomInviteActivity)localObject).ni = bool1;
        this.this$0.a.notifyDataSetChanged();
        this.this$0.refreshUI();
        this.this$0.dze();
        this.this$0.dzg();
        return;
      }
    } while (!this.this$0.cqb);
    label309:
    label314:
    this.this$0.a(paramInt, paramRspBody, (String)GameRoomInviteActivity.cY.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajsi
 * JD-Core Version:    0.7.0.1
 */