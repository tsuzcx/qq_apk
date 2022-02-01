package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xbe8
{
  public static final class PopupResult
    extends MessageMicro<PopupResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_popup_result", "uint32_popup_fieldid" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, PopupResult.class);
    public final PBUInt32Field uint32_popup_fieldid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_popup_result = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint64_uin", "enum_op_code", "uint32_req_of_popup_flag", "uint32_rst_of_popup_flag", "uint32_mqq808_welcomepage_flag", "rpt_msg_popup_result" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, ReqBody.class);
    public final PBEnumField enum_op_code = PBField.initEnum(1);
    public final PBRepeatMessageField<oidb_0xbe8.PopupResult> rpt_msg_popup_result = PBField.initRepeatMessage(oidb_0xbe8.PopupResult.class);
    public final PBUInt32Field uint32_mqq808_welcomepage_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_of_popup_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rst_of_popup_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_uin", "enum_op_code", "uint32_rsp_of_popup_flag", "uint32_popup_count_now" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    public final PBEnumField enum_op_code = PBField.initEnum(1);
    public final PBUInt32Field uint32_popup_count_now = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rsp_of_popup_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xbe8
 * JD-Core Version:    0.7.0.1
 */