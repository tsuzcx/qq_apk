package tencent.im.oidb.cmd0x6b6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6b6
{
  public static final class AnonymousGroupMsg
    extends MessageMicro<AnonymousGroupMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField str_anon_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_anon_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_rank_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_bubble_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
    public final PBUInt32Field uint32_head_portrait = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58 }, new String[] { "uint32_flags", "str_anon_id", "str_anon_nick", "uint32_head_portrait", "uint32_expire_time", "uint32_bubble_id", "str_rank_color" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, AnonymousGroupMsg.class);
    }
  }
  
  public static final class ExtParam
    extends MessageMicro<ExtParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_login_sig", "uint32_business_id" }, new Object[] { null, Integer.valueOf(0) }, ExtParam.class);
    public oidb_0x6b6.LoginSig msg_login_sig = new oidb_0x6b6.LoginSig();
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
  }
  
  public static final class GPSInfo
    extends MessageMicro<GPSInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int64_longitude", "int64_latitude", "int32_gps_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, GPSInfo.class);
    public final PBInt32Field int32_gps_type = PBField.initInt32(0);
    public final PBInt64Field int64_latitude = PBField.initInt64(0L);
    public final PBInt64Field int64_longitude = PBField.initInt64(0L);
  }
  
  public static final class LoginSig
    extends MessageMicro<LoginSig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_type", "bytes_sig", "uint32_appid" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, LoginSig.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_user_ip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x6b6.AnonymousGroupMsg msg_anony = new oidb_0x6b6.AnonymousGroupMsg();
    public oidb_0x6b6.ExtParam msg_ext_param = new oidb_0x6b6.ExtParam();
    public oidb_0x6b6.GPSInfo msg_gps_info = new oidb_0x6b6.GPSInfo();
    public oidb_0x6b6.SendFlowerReq msg_send_flower = new oidb_0x6b6.SendFlowerReq();
    public oidb_0x6b6.ThrowFlowerReq msg_throw_flower = new oidb_0x6b6.ThrowFlowerReq();
    public oidb_0x6b6.TmpMsgToken msg_tmp_msg_token = new oidb_0x6b6.TmpMsgToken();
    public final PBUInt32Field uint32_c2c_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_instance_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58, 66, 74, 82, 90, 98, 104, 112 }, new String[] { "uint64_group", "bytes_user_ip", "bytes_version", "uint32_portal", "uint32_client", "uint32_instance_id", "msg_ext_param", "msg_send_flower", "msg_throw_flower", "msg_tmp_msg_token", "msg_gps_info", "msg_anony", "uint32_c2c_type", "uint32_group_type" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_notify = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public oidb_0x6b6.SendFlowerRsp msg_send_flower = new oidb_0x6b6.SendFlowerRsp();
    public oidb_0x6b6.ThrowFlowerRsp msg_throw_flower = new oidb_0x6b6.ThrowFlowerRsp();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 34, 42, 50 }, new String[] { "int32_ret", "bytes_msg", "msg_send_flower", "msg_throw_flower", "bytes_error_notify" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, null, localByteStringMicro2 }, RspBody.class);
    }
  }
  
  public static final class SendFlowerReq
    extends MessageMicro<SendFlowerReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_gift_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recv_user_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_send_user_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ticketid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_count = PBField.initInt32(0);
    public final PBInt32Field int32_discount_amount = PBField.initInt32(0);
    public final PBUInt32Field uint32_custom_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gift_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gift_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_play_rule = PBField.initUInt32(0);
    public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 74, 82, 90, 96 }, new String[] { "int32_count", "uint64_to_uin", "uint32_play_rule", "uint32_custom_flag", "uint32_product_id", "uint32_gift_id", "uint32_gift_num", "bytes_gift_text", "bytes_send_user_name", "bytes_recv_user_name", "bytes_ticketid", "int32_discount_amount" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0) }, SendFlowerReq.class);
    }
  }
  
  public static final class SendFlowerRsp
    extends MessageMicro<SendFlowerRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_imagent_package = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_midas_json = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_product_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field int64_give_stock = PBField.initInt64(0L);
    public final PBUInt32Field uint32_balance = PBField.initUInt32(0);
    public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50 }, new String[] { "uint32_product_id", "bytes_midas_json", "int64_give_stock", "uint32_balance", "bytes_product_name", "bytes_imagent_package" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, SendFlowerRsp.class);
    }
  }
  
  public static final class ThrowFlowerReq
    extends MessageMicro<ThrowFlowerReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int32_count", "uint32_play_rule", "uint32_product_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ThrowFlowerReq.class);
    public final PBInt32Field int32_count = PBField.initInt32(0);
    public final PBUInt32Field uint32_play_rule = PBField.initUInt32(0);
    public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);
  }
  
  public static final class ThrowFlowerRsp
    extends MessageMicro<ThrowFlowerRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_product_id" }, new Object[] { Integer.valueOf(0) }, ThrowFlowerRsp.class);
    public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);
  }
  
  public static final class TmpMsgToken
    extends MessageMicro<TmpMsgToken>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field c2c_type = PBField.initUInt32(0);
    public final PBUInt32Field service_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "buf", "c2c_type", "service_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, TmpMsgToken.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6b6.oidb_0x6b6
 * JD-Core Version:    0.7.0.1
 */