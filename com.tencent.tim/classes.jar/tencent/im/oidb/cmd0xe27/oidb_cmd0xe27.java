package tencent.im.oidb.cmd0xe27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xe27
{
  public static final class InOutQQ
    extends MessageMicro<InOutQQ>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "enum_biz_id", "uint32_timestamp" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0) }, InOutQQ.class);
    public final PBEnumField enum_biz_id = PBField.initEnum(1);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_in_out_qq" }, new Object[] { null }, ReqBody.class);
    public final PBRepeatMessageField<oidb_cmd0xe27.InOutQQ> rpt_msg_in_out_qq = PBField.initRepeatMessage(oidb_cmd0xe27.InOutQQ.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_test_keep_silence_sec" }, new Object[] { Integer.valueOf(0) }, RspBody.class);
    public final PBUInt32Field uint32_test_keep_silence_sec = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe27.oidb_cmd0xe27
 * JD-Core Version:    0.7.0.1
 */