package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xbcb
{
  public static final class CheckUrlReq
    extends MessageMicro<CheckUrlReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 64, 72, 82, 90 }, new String[] { "url", "refer", "plateform", "qq_pf_to", "msg_type", "msg_from", "msg_chatid", "service_type", "send_uin", "req_type", "original_url" }, new Object[] { "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "" }, CheckUrlReq.class);
    public final PBUInt64Field msg_chatid = PBField.initUInt64(0L);
    public final PBUInt32Field msg_from = PBField.initUInt32(0);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBStringField original_url = PBField.initString("");
    public final PBStringField plateform = PBField.initString("");
    public final PBStringField qq_pf_to = PBField.initString("");
    public final PBStringField refer = PBField.initString("");
    public final PBStringField req_type = PBField.initString("");
    public final PBUInt64Field send_uin = PBField.initUInt64(0L);
    public final PBUInt64Field service_type = PBField.initUInt64(0L);
    public final PBRepeatField<String> url = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class CheckUrlReqItem
    extends MessageMicro<CheckUrlReqItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 64, 72, 82 }, new String[] { "url", "refer", "plateform", "qq_pf_to", "msg_type", "msg_from", "msg_chatid", "service_type", "send_uin", "req_type" }, new Object[] { "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "" }, CheckUrlReqItem.class);
    public final PBUInt64Field msg_chatid = PBField.initUInt64(0L);
    public final PBUInt32Field msg_from = PBField.initUInt32(0);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBStringField plateform = PBField.initString("");
    public final PBStringField qq_pf_to = PBField.initString("");
    public final PBStringField refer = PBField.initString("");
    public final PBStringField req_type = PBField.initString("");
    public final PBUInt64Field send_uin = PBField.initUInt64(0L);
    public final PBUInt64Field service_type = PBField.initUInt64(0L);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class CheckUrlRsp
    extends MessageMicro<CheckUrlRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "results", "next_req_duration" }, new Object[] { null, Integer.valueOf(0) }, CheckUrlRsp.class);
    public final PBUInt32Field next_req_duration = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xbcb.UrlCheckResult> results = PBField.initRepeatMessage(oidb_0xbcb.UrlCheckResult.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 72, 82 }, new String[] { "not_use_cache", "check_url_req" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
    public oidb_0xbcb.CheckUrlReq check_url_req = new oidb_0xbcb.CheckUrlReq();
    public final PBInt32Field not_use_cache = PBField.initInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82 }, new String[] { "wording", "check_url_rsp" }, new Object[] { "", null }, RspBody.class);
    public oidb_0xbcb.CheckUrlRsp check_url_rsp = new oidb_0xbcb.CheckUrlRsp();
    public final PBStringField wording = PBField.initString("");
  }
  
  public static final class UrlCheckResult
    extends MessageMicro<UrlCheckResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 56, 64, 72 }, new String[] { "url", "result", "jump_result", "jump_url", "uint32_level", "uint32_sub_level", "uint32_umrtype", "ret_from", "operation_bit" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, UrlCheckResult.class);
    public final PBUInt32Field jump_result = PBField.initUInt32(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBUInt64Field operation_bit = PBField.initUInt64(0L);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field ret_from = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_umrtype = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xbcb
 * JD-Core Version:    0.7.0.1
 */