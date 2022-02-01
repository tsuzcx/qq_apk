package tencent.nearby.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearby_now_anchor
{
  public static final class AnchorStatus
    extends MessageMicro<AnchorStatus>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "enum_stat" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1) }, AnchorStatus.class);
    public final PBEnumField enum_stat = PBField.initEnum(1);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBatchGetAnchorStatus
    extends MessageMicro<ReqBatchGetAnchorStatus>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uin" }, new Object[] { Long.valueOf(0L) }, ReqBatchGetAnchorStatus.class);
    public final PBRepeatField<Long> uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class RspBatchGetAnchorStatus
    extends MessageMicro<RspBatchGetAnchorStatus>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "msg_anchor_stats" }, new Object[] { Integer.valueOf(0), null }, RspBatchGetAnchorStatus.class);
    public final PBRepeatMessageField<nearby_now_anchor.AnchorStatus> msg_anchor_stats = PBField.initRepeatMessage(nearby_now_anchor.AnchorStatus.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.nearby.now.nearby_now_anchor
 * JD-Core Version:    0.7.0.1
 */