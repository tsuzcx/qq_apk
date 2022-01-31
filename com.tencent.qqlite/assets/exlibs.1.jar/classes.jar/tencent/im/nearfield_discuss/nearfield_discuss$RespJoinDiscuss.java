package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearfield_discuss$RespJoinDiscuss
  extends MessageMicro
{
  public static final int BOOL_IS_CREATER_FIELD_NUMBER = 5;
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  public static final int STR_NUMBER_FIELD_NUMBER = 2;
  public static final int UINT32_DISCUSS_ID_FIELD_NUMBER = 4;
  public static final int UINT32_SESSION_ID_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "msg_head", "str_number", "uint32_session_id", "uint32_discuss_id", "bool_is_creater" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false) }, RespJoinDiscuss.class);
  public final PBBoolField bool_is_creater = PBField.initBool(false);
  public nearfield_discuss.BusiRespHead msg_head = new nearfield_discuss.BusiRespHead();
  public final PBStringField str_number = PBField.initString("");
  public final PBUInt32Field uint32_discuss_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.nearfield_discuss.nearfield_discuss.RespJoinDiscuss
 * JD-Core Version:    0.7.0.1
 */