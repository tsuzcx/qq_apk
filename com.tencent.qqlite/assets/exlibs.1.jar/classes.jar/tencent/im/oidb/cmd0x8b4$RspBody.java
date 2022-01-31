package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x8b4$RspBody
  extends MessageMicro
{
  public static final int BYTES_TAG_FIELD_NUMBER = 21;
  public static final int RPT_GROUP_INFO_FIELD_NUMBER = 22;
  public static final int UINT32_FLAG_FIELD_NUMBER = 2;
  public static final int UINT32_RESULT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_tag = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField rpt_group_info = PBField.initRepeatMessage(cmd0x8b4.GroupInfo.class);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 170, 178 }, new String[] { "uint32_result", "uint32_flag", "bytes_tag", "rpt_group_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8b4.RspBody
 * JD-Core Version:    0.7.0.1
 */