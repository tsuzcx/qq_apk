package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x6f0
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "rpt_uin_list", "uint64_req_torch_info", "enum_req_source" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1) }, ReqBody.class);
    public final PBEnumField enum_req_source = PBField.initEnum(1);
    public final PBRepeatField<Long> rpt_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_req_torch_info = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_torchbearer_list" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<torch_transfer.TorchbearerInfo> rpt_torchbearer_list = PBField.initRepeatMessage(torch_transfer.TorchbearerInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.olympic.cmd0x6f0
 * JD-Core Version:    0.7.0.1
 */