package tencent.im.oidb.cmd0xbbc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.channel_button.channel_button.Channel;
import tencent.im.oidb.channel_button.channel_button.Section;

public final class oidb_cmd0xbbc
{
  public static final class PhoneInfo
    extends MessageMicro<PhoneInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_appid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_client_ip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_muid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_os_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_qq_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_carrier = PBField.initUInt32(0);
    public final PBUInt32Field uint32_conn = PBField.initUInt32(0);
    public final PBUInt32Field uint32_muid_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_os_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 66, 72 }, new String[] { "bytes_muid", "uint32_conn", "uint32_carrier", "uint32_muid_type", "bytes_os_ver", "bytes_qq_ver", "bytes_client_ip", "bytes_appid", "uint32_os_type" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0) }, PhoneInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "rpt_me_channel", "rpt_recomm_channel", "rpt_msg_section", "uint32_set_type", "msg_phone_type" }, new Object[] { null, null, null, Integer.valueOf(0), null }, ReqBody.class);
    public oidb_cmd0xbbc.PhoneInfo msg_phone_type = new oidb_cmd0xbbc.PhoneInfo();
    public final PBRepeatMessageField<channel_button.Channel> rpt_me_channel = PBField.initRepeatMessage(channel_button.Channel.class);
    public final PBRepeatMessageField<channel_button.Section> rpt_msg_section = PBField.initRepeatMessage(channel_button.Section.class);
    public final PBRepeatMessageField<channel_button.Channel> rpt_recomm_channel = PBField.initRepeatMessage(channel_button.Channel.class);
    public final PBUInt32Field uint32_set_type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbbc.oidb_cmd0xbbc
 * JD-Core Version:    0.7.0.1
 */