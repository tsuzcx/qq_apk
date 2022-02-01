package tencent.kandian.flaginfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class flag_info
{
  public static final class FlagInfo
    extends MessageMicro<FlagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 88, 96 }, new String[] { "uint64_uin", "int64_update_time", "uint64_private_flag", "uint32_teenager_flag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, FlagInfo.class);
    public final PBInt64Field int64_update_time = PBField.initInt64(0L);
    public final PBUInt32Field uint32_teenager_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_private_flag = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.kandian.flaginfo.flag_info
 * JD-Core Version:    0.7.0.1
 */