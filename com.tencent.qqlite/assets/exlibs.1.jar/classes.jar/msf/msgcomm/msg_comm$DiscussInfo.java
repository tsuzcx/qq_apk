package msf.msgcomm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_comm$DiscussInfo
  extends MessageMicro
{
  public static final int DISCUSS_INFO_SEQ_FIELD_NUMBER = 3;
  public static final int DISCUSS_REMARK_FIELD_NUMBER = 4;
  public static final int DISCUSS_TYPE_FIELD_NUMBER = 2;
  public static final int DISCUSS_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field discuss_info_seq = PBField.initUInt64(0L);
  public final PBBytesField discuss_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field discuss_type = PBField.initUInt32(0);
  public final PBUInt64Field discuss_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "discuss_uin", "discuss_type", "discuss_info_seq", "discuss_remark" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, DiscussInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.msgcomm.msg_comm.DiscussInfo
 * JD-Core Version:    0.7.0.1
 */