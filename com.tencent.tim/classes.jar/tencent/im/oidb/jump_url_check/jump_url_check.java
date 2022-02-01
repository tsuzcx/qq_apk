package tencent.im.oidb.jump_url_check;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class jump_url_check
{
  public static final class ActivityInfo
    extends MessageMicro<ActivityInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "item_pkg_name", "item_name" }, new Object[] { "", "" }, ActivityInfo.class);
    public final PBStringField item_name = PBField.initString("");
    public final PBStringField item_pkg_name = PBField.initString("");
  }
  
  public static final class ReqJumpUrlCheckRecmd
    extends MessageMicro<ReqJumpUrlCheckRecmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "uin", "jump_url", "pkg_name", "schema", "action", "activity_list" }, new Object[] { Long.valueOf(0L), "", "", "", "", null }, ReqJumpUrlCheckRecmd.class);
    public final PBStringField action = PBField.initString("");
    public final PBRepeatMessageField<jump_url_check.ActivityInfo> activity_list = PBField.initRepeatMessage(jump_url_check.ActivityInfo.class);
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField pkg_name = PBField.initString("");
    public final PBStringField schema = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class RspJumpUrlCheckRecmd
    extends MessageMicro<RspJumpUrlCheckRecmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "err_code", "err_msg", "can_jump" }, new Object[] { Integer.valueOf(0), "", Boolean.valueOf(true) }, RspJumpUrlCheckRecmd.class);
    public final PBBoolField can_jump = PBField.initBool(true);
    public final PBInt32Field err_code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.jump_url_check.jump_url_check
 * JD-Core Version:    0.7.0.1
 */