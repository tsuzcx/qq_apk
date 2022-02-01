package tencent.im.oidb.cmd0xc32;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xc32
{
  public static final class CheckTriad
    extends MessageMicro<CheckTriad>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_feeds_id", "uint64_uin", "uint32_visible" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, CheckTriad.class);
    public final PBUInt32Field uint32_visible = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class CheckVisibilityReqBody
    extends MessageMicro<CheckVisibilityReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_triads" }, new Object[] { null }, CheckVisibilityReqBody.class);
    public final PBRepeatMessageField<oidb_cmd0xc32.CheckTriad> rpt_triads = PBField.initRepeatMessage(oidb_cmd0xc32.CheckTriad.class);
  }
  
  public static final class CheckVisibilityRspBody
    extends MessageMicro<CheckVisibilityRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_triads" }, new Object[] { null }, CheckVisibilityRspBody.class);
    public final PBRepeatMessageField<oidb_cmd0xc32.CheckTriad> rpt_triads = PBField.initRepeatMessage(oidb_cmd0xc32.CheckTriad.class);
  }
  
  public static final class GetVisibleListReqBody
    extends MessageMicro<GetVisibleListReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_feeds_id", "uint32_start_ix", "uint32_want_num" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GetVisibleListReqBody.class);
    public final PBUInt32Field uint32_start_ix = PBField.initUInt32(0);
    public final PBUInt32Field uint32_want_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  }
  
  public static final class GetVisibleListRspBody
    extends MessageMicro<GetVisibleListRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint64_feeds_id", "rpt_uint64_visible_uins", "uint32_total_count", "uint32_next_ix", "uint32_is_end", "uint64_feeds_author" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, GetVisibleListRspBody.class);
    public final PBRepeatField<Long> rpt_uint64_visible_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_ix = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_author = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "enum_op", "msg_set_req_body", "msg_get_req_body", "msg_check_req_body" }, new Object[] { Integer.valueOf(1), null, null, null }, ReqBody.class);
    public final PBEnumField enum_op = PBField.initEnum(1);
    public oidb_cmd0xc32.CheckVisibilityReqBody msg_check_req_body = new oidb_cmd0xc32.CheckVisibilityReqBody();
    public oidb_cmd0xc32.GetVisibleListReqBody msg_get_req_body = new oidb_cmd0xc32.GetVisibleListReqBody();
    public oidb_cmd0xc32.SetVisibleListReqBody msg_set_req_body = new oidb_cmd0xc32.SetVisibleListReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_set_rsp_body", "msg_get_rsp_body", "msg_check_rsp_body" }, new Object[] { null, null, null }, RspBody.class);
    public oidb_cmd0xc32.CheckVisibilityRspBody msg_check_rsp_body = new oidb_cmd0xc32.CheckVisibilityRspBody();
    public oidb_cmd0xc32.GetVisibleListRspBody msg_get_rsp_body = new oidb_cmd0xc32.GetVisibleListRspBody();
    public oidb_cmd0xc32.SetVisibleListRspBody msg_set_rsp_body = new oidb_cmd0xc32.SetVisibleListRspBody();
  }
  
  public static final class SetVisibleListReqBody
    extends MessageMicro<SetVisibleListReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_operator", "uint64_feeds_id", "rpt_uint64_visible_uins" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, SetVisibleListReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_visible_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_operator = PBField.initUInt64(0L);
  }
  
  public static final class SetVisibleListRspBody
    extends MessageMicro<SetVisibleListRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SetVisibleListRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc32.oidb_cmd0xc32
 * JD-Core Version:    0.7.0.1
 */