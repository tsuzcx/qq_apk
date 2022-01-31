package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x346$DelMessageReq
  extends MessageMicro
{
  public static final int UINT32_MSG_RANDOM_FIELD_NUMBER = 20;
  public static final int UINT32_MSG_SEQ_NO_FIELD_NUMBER = 30;
  public static final int UINT32_MSG_TIME_FIELD_NUMBER = 10;
  public static final int UINT64_UIN_RECEIVER_FIELD_NUMBER = 2;
  public static final int UINT64_UIN_SENDER_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 80, 160, 240 }, new String[] { "uint64_uin_sender", "uint64_uin_receiver", "uint32_msg_time", "uint32_msg_random", "uint32_msg_seq_no" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, DelMessageReq.class);
  public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_seq_no = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin_receiver = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin_sender = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.DelMessageReq
 * JD-Core Version:    0.7.0.1
 */