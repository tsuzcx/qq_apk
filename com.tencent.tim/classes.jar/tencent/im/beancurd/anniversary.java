package tencent.im.beancurd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class anniversary
{
  public static final class Anniversary
    extends MessageMicro<Anniversary>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_anniversary_info" }, new Object[] { null }, Anniversary.class);
    public final PBRepeatMessageField<anniversary.AnniversaryInfo> rpt_anniversary_info = PBField.initRepeatMessage(anniversary.AnniversaryInfo.class);
  }
  
  public static final class AnniversaryInfo
    extends MessageMicro<AnniversaryInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66 }, new String[] { "uint64_type", "uint64_uin", "uint64_frd_uin", "uint64_bind_time", "uint64_n", "uint64_level", "str_bg_url", "str_text_color" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "" }, AnniversaryInfo.class);
    public final PBStringField str_bg_url = PBField.initString("");
    public final PBStringField str_text_color = PBField.initString("");
    public final PBUInt64Field uint64_bind_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_frd_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_level = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_n = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_type = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.beancurd.anniversary
 * JD-Core Version:    0.7.0.1
 */