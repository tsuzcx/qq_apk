import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class ajsl
  implements DialogInterface.OnClickListener
{
  public ajsl(GameRoomInviteActivity paramGameRoomInviteActivity, oidb_0x8e4.RspBody paramRspBody) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.poi_info;
    String str = paramDialogInterface.bytes_uid.get().toStringUtf8();
    ajtk.a(this.this$0, HotChatInfo.createHotChat(paramDialogInterface, false, 0), paramDialogInterface.uint32_group_code.get(), str, paramDialogInterface.bytes_name.get().toStringUtf8());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajsl
 * JD-Core Version:    0.7.0.1
 */