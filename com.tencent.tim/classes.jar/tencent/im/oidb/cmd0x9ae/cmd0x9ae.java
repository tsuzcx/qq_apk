package tencent.im.oidb.cmd0x9ae;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x9ae
{
  public static final class AuthTips
    extends MessageMicro<AuthTips>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "string_tips_title", "string_tips_context", "string_tips_action", "string_tips_action_url" }, new Object[] { "", "", "", "" }, AuthTips.class);
    public final PBStringField string_tips_action = PBField.initString("");
    public final PBStringField string_tips_action_url = PBField.initString("");
    public final PBStringField string_tips_context = PBField.initString("");
    public final PBStringField string_tips_title = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqBody.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "bool_has_been_authenticated", "bool_need_auth_tips", "msg_auth_tips" }, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false), null }, RspBody.class);
    public final PBBoolField bool_has_been_authenticated = PBField.initBool(false);
    public final PBBoolField bool_need_auth_tips = PBField.initBool(false);
    public cmd0x9ae.AuthTips msg_auth_tips = new cmd0x9ae.AuthTips();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9ae.cmd0x9ae
 * JD-Core Version:    0.7.0.1
 */