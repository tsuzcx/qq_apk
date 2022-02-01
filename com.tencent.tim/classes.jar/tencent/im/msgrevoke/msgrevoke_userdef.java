package tencent.im.msgrevoke;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msgrevoke_userdef
{
  public static final class MsgInfoUserDef
    extends MessageMicro<MsgInfoUserDef>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_long_message_flag", "long_msg_info", "str_file_uuid" }, new Object[] { Integer.valueOf(0), null, "" }, MsgInfoUserDef.class);
    public final PBRepeatMessageField<MsgInfoDef> long_msg_info = PBField.initRepeatMessage(MsgInfoDef.class);
    public final PBRepeatField<String> str_file_uuid = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field uint32_long_message_flag = PBField.initUInt32(0);
    
    public static final class MsgInfoDef
      extends MessageMicro<MsgInfoDef>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_msg_seq", "long_msg_id", "long_msg_num", "long_msg_index" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MsgInfoDef.class);
      public final PBUInt32Field long_msg_id = PBField.initUInt32(0);
      public final PBUInt32Field long_msg_index = PBField.initUInt32(0);
      public final PBUInt32Field long_msg_num = PBField.initUInt32(0);
      public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
    }
  }
  
  public static final class UinTypeUserDef
    extends MessageMicro<UinTypeUserDef>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_from_uin_type", "uint64_from_group_code", "str_file_uuid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "" }, UinTypeUserDef.class);
    public final PBRepeatField<String> str_file_uuid = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field uint32_from_uin_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_group_code = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.msgrevoke.msgrevoke_userdef
 * JD-Core Version:    0.7.0.1
 */