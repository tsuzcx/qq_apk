package tencent.im.oidb.cmd0x6e5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x6e5
{
  public static final class InterestLabelInfo
    extends MessageMicro<InterestLabelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_interest_label_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_interest_label_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_interest_label_id", "bytes_interest_label_name" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, InterestLabelInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 88, 96, 104 }, new String[] { "uint64_uin", "uint32_req_all_interest_label_list", "uint32_req_default_interest_label_id_list", "uint32_req_last_interest_label_id_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_req_all_interest_label_list = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_default_interest_label_id_list = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_last_interest_label_id_list = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 96, 104 }, new String[] { "uint64_uin", "rpt_interest_label_list", "rpt_uint32_default_interest_label_id_list", "rpt_uint64_last_interest_label_id_list" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), Long.valueOf(0L) }, RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0x6e5.InterestLabelInfo> rpt_interest_label_list = PBField.initRepeatMessage(oidb_cmd0x6e5.InterestLabelInfo.class);
    public final PBRepeatField<Integer> rpt_uint32_default_interest_label_id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Long> rpt_uint64_last_interest_label_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6e5.oidb_cmd0x6e5
 * JD-Core Version:    0.7.0.1
 */