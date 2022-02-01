import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody.WifiPOIInfo;

class ajsd
  extends arec
{
  ajsd(ajrz paramajrz) {}
  
  public void a(submsgtype0xdd.MsgBody paramMsgBody)
  {
    switch (paramMsgBody.uint32_msg_type.get())
    {
    }
    do
    {
      return;
      paramMsgBody = (submsgtype0xdd.MsgBody.WifiPOIInfo)paramMsgBody.msg_poi_info.get();
      String str = paramMsgBody.bytes_uid.get().toStringUtf8();
      this.b.a(HotChatInfo.createHotChat(paramMsgBody, false, 0), paramMsgBody.uint32_group_code.get(), str, paramMsgBody.bytes_name.get().toStringUtf8());
      return;
      QQToast.a(this.b.mContext, acfp.m(2131706764), 0).show();
      paramMsgBody = BaseApplicationImpl.getApplication().getRuntime();
    } while ((paramMsgBody == null) || (!(paramMsgBody instanceof QQAppInterface)));
    paramMsgBody = (QQAppInterface)paramMsgBody;
    aqmj.a(this.b.mContext, paramMsgBody.getCurrentAccountUin(), false, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajsd
 * JD-Core Version:    0.7.0.1
 */