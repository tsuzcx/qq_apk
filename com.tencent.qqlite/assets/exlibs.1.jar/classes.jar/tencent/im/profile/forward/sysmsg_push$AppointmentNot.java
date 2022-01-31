package tencent.im.profile.forward;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class sysmsg_push$AppointmentNot
  extends MessageMicro
{
  public static final int BYTES_TIPS_CONTENT_FIELD_NUMBER = 3;
  public static final int UINT32_NOTIFYTYPE_FIELD_NUMBER = 2;
  public static final int UINT64_FROM_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_tips_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_notifytype = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_from_uin", "uint32_notifytype", "bytes_tips_content" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, AppointmentNot.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.profile.forward.sysmsg_push.AppointmentNot
 * JD-Core Version:    0.7.0.1
 */