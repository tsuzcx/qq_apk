import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

class ajtg
  implements DialogInterface.OnClickListener
{
  ajtg(ajtf paramajtf, oidb_0x8e4.RspBody paramRspBody) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_TencentImOidbCmd0x8e4Oidb_0x8e4$RspBody.poi_info;
    String str = paramDialogInterface.bytes_uid.get().toStringUtf8();
    ajtk.a(this.jdField_a_of_type_Ajtf.a, HotChatInfo.createHotChat(paramDialogInterface, false, 0), paramDialogInterface.uint32_group_code.get(), str, paramDialogInterface.bytes_name.get().toStringUtf8());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajtg
 * JD-Core Version:    0.7.0.1
 */