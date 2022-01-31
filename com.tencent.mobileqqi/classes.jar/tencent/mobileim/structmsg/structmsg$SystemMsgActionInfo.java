package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$SystemMsgActionInfo
  extends MessageMicro
{
  public static final int BLACKLIST_FIELD_NUMBER = 53;
  public static final int GROUP_CODE_FIELD_NUMBER = 2;
  public static final int GROUP_ID_FIELD_NUMBER = 51;
  public static final int MSG_FIELD_NUMBER = 50;
  public static final int REMARK_FIELD_NUMBER = 52;
  public static final int SIG_FIELD_NUMBER = 3;
  public static final int TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField blacklist = PBField.initBool(false);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt32Field group_id = PBField.initUInt32(0);
  public final PBStringField msg = PBField.initString("");
  public final PBStringField remark = PBField.initString("");
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField type = PBField.initEnum(1);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 402, 408, 418, 424 }, new String[] { "type", "group_code", "sig", "msg", "group_id", "remark", "blacklist" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), localByteStringMicro, "", Integer.valueOf(0), "", Boolean.valueOf(false) }, SystemMsgActionInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo
 * JD-Core Version:    0.7.0.1
 */