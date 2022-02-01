package tencent.im.oidb.oidb_0x8e7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8e7
{
  public static final class ExtParam
    extends MessageMicro<ExtParam>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x8e7.LoginSig msg_login_sig = new oidb_0x8e7.LoginSig();
    public final PBUInt32Field uint32_client = PBField.initUInt32(0);
    public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "msg_login_sig", "bytes_version", "uint32_portal", "uint32_client" }, new Object[] { null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, ExtParam.class);
    }
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
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56 }, new String[] { "msg_ext_parm", "uint64_uin", "uint64_tinyid", "bool_stock", "bool_is_first", "bool_need_warn", "bool_need_update_url" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false) }, ReqBody.class);
    public final PBBoolField bool_is_first = PBField.initBool(false);
    public final PBBoolField bool_need_update_url = PBField.initBool(false);
    public final PBBoolField bool_need_warn = PBField.initBool(false);
    public final PBBoolField bool_stock = PBField.initBool(false);
    public oidb_0x8e7.ExtParam msg_ext_parm = new oidb_0x8e7.ExtParam();
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_recharge_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_update_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x8e7.StockRsp msg_stock_rsp = new oidb_0x8e7.StockRsp();
    public oidb_0x8e7.WarnMsg msg_warn = new oidb_0x8e7.WarnMsg();
    public oidb_0x8e7.ZanLimitInfo msg_zan_limit = new oidb_0x8e7.ZanLimitInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "msg_stock_rsp", "msg_zan_limit", "bytes_recharge_url", "msg_warn", "bytes_update_url" }, new Object[] { null, null, localByteStringMicro1, null, localByteStringMicro2 }, RspBody.class);
    }
  }
  
  public static final class StockRsp
    extends MessageMicro<StockRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int32_total", "int32_stock", "int32_give_count" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StockRsp.class);
    public final PBInt32Field int32_give_count = PBField.initInt32(0);
    public final PBInt32Field int32_stock = PBField.initInt32(0);
    public final PBInt32Field int32_total = PBField.initInt32(0);
  }
  
  public static final class Text
    extends MessageMicro<Text>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_color = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_context", "uint32_color" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, Text.class);
    }
  }
  
  public static final class UserZanInfo
    extends MessageMicro<UserZanInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_uin", "uint64_tinyid", "uint64_free_zan", "uint64_pay_zan", "uint64_pay_stock" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, UserZanInfo.class);
    public final PBUInt64Field uint64_free_zan = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_pay_stock = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_pay_zan = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class WarnMsg
    extends MessageMicro<WarnMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "rpt_msg_first_info", "rpt_msg_user_num_limit_info", "rpt_msg_zan_limit_info" }, new Object[] { null, null, null }, WarnMsg.class);
    public final PBRepeatMessageField<oidb_0x8e7.Text> rpt_msg_first_info = PBField.initRepeatMessage(oidb_0x8e7.Text.class);
    public final PBRepeatMessageField<oidb_0x8e7.Text> rpt_msg_user_num_limit_info = PBField.initRepeatMessage(oidb_0x8e7.Text.class);
    public final PBRepeatMessageField<oidb_0x8e7.Text> rpt_msg_zan_limit_info = PBField.initRepeatMessage(oidb_0x8e7.Text.class);
  }
  
  public static final class ZanLimitInfo
    extends MessageMicro<ZanLimitInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint64_level", "uint64_can_free_zan_user_limit", "uint64_free_zan_user", "uint64_free_zan_total_limit", "uint64_price", "rpt_msg_user_zan_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null }, ZanLimitInfo.class);
    public final PBRepeatMessageField<oidb_0x8e7.UserZanInfo> rpt_msg_user_zan_info = PBField.initRepeatMessage(oidb_0x8e7.UserZanInfo.class);
    public final PBUInt64Field uint64_can_free_zan_user_limit = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_free_zan_total_limit = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_free_zan_user = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_level = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_price = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x8e7.oidb_0x8e7
 * JD-Core Version:    0.7.0.1
 */