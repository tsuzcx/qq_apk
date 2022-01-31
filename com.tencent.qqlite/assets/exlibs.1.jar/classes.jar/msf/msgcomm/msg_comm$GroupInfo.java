package msf.msgcomm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_comm$GroupInfo
  extends MessageMicro
{
  public static final int GROUP_CARD_FIELD_NUMBER = 4;
  public static final int GROUP_CODE_FIELD_NUMBER = 1;
  public static final int GROUP_INFO_SEQ_FIELD_NUMBER = 3;
  public static final int GROUP_LEVEL_FIELD_NUMBER = 6;
  public static final int GROUP_RANK_FIELD_NUMBER = 5;
  public static final int GROUP_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField group_card = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field group_info_seq = PBField.initUInt64(0L);
  public final PBUInt32Field group_level = PBField.initUInt32(0);
  public final PBBytesField group_rank = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field group_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48 }, new String[] { "group_code", "group_type", "group_info_seq", "group_card", "group_rank", "group_level" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, GroupInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.msgcomm.msg_comm.GroupInfo
 * JD-Core Version:    0.7.0.1
 */