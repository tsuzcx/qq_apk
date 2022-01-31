package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearfield_discuss$ReqExit
  extends MessageMicro
{
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  public static final int MSG_LBS_INFO_FIELD_NUMBER = 2;
  public static final int STR_NUMBER_FIELD_NUMBER = 3;
  public static final int UINT32_SESSION_ID_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "msg_head", "msg_lbs_info", "str_number", "uint32_session_id" }, new Object[] { null, null, "", Integer.valueOf(0) }, ReqExit.class);
  public nearfield_discuss.BusiReqHead msg_head = new nearfield_discuss.BusiReqHead();
  public nearfield_discuss.LBSInfo msg_lbs_info = new nearfield_discuss.LBSInfo();
  public final PBStringField str_number = PBField.initString("");
  public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.nearfield_discuss.nearfield_discuss.ReqExit
 * JD-Core Version:    0.7.0.1
 */