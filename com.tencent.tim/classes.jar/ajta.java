import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

class ajta
  implements ardq.a<oidb_0x8e4.RspBody>
{
  ajta(ajsz paramajsz) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if (paramInt == 0)
    {
      paramRspBody = paramRspBody.poi_info;
      String str = paramRspBody.bytes_uid.get().toStringUtf8();
      this.a.this$0.a(HotChatInfo.createHotChat(paramRspBody, false, 0), paramRspBody.uint32_group_code.get(), str, paramRspBody.bytes_name.get().toStringUtf8());
    }
    do
    {
      return;
      this.a.this$0.a(paramInt, paramRspBody, acfp.m(2131706763));
    } while (!QLog.isColorLevel());
    QLog.d("GameRoomInviteActivity", 2, "start game failed! code = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajta
 * JD-Core Version:    0.7.0.1
 */