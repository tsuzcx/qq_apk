package tencent.im.oidb.cmd0xbe6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbe6
{
  public static final class MsgChannelInfo
    extends MessageMicro<MsgChannelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "string_name", "uint32_channel_id", "uint32_channel_type" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, MsgChannelInfo.class);
    public final PBStringField string_name = PBField.initString("");
    public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
  }
  
  public static final class MsgGetChannelInfoReq
    extends MessageMicro<MsgGetChannelInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], MsgGetChannelInfoReq.class);
  }
  
  public static final class MsgGetChannelInfoRsp
    extends MessageMicro<MsgGetChannelInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_channel_info" }, new Object[] { null }, MsgGetChannelInfoRsp.class);
    public final PBRepeatMessageField<oidb_cmd0xbe6.MsgChannelInfo> rpt_msg_channel_info = PBField.initRepeatMessage(oidb_cmd0xbe6.MsgChannelInfo.class);
  }
  
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
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_phone_info", "msg_get_channel_info_req", "string_channel_version" }, new Object[] { null, null, "" }, ReqBody.class);
    public oidb_cmd0xbe6.MsgGetChannelInfoReq msg_get_channel_info_req = new oidb_cmd0xbe6.MsgGetChannelInfoReq();
    public oidb_cmd0xbe6.PhoneInfo msg_phone_info = new oidb_cmd0xbe6.PhoneInfo();
    public final PBStringField string_channel_version = PBField.initString("");
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_get_channel_info_rsp", "string_channel_version" }, new Object[] { null, "" }, RspBody.class);
    public oidb_cmd0xbe6.MsgGetChannelInfoRsp msg_get_channel_info_rsp = new oidb_cmd0xbe6.MsgGetChannelInfoRsp();
    public final PBStringField string_channel_version = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6
 * JD-Core Version:    0.7.0.1
 */