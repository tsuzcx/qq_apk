package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GroupOpenSysMsg
{
  public static final class LightApp
    extends MessageMicro<LightApp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "app", "view", "desc", "prompt", "ver", "meta", "config", "source" }, new Object[] { "", "", "", "", "", "", "", null }, LightApp.class);
    public final PBStringField app = PBField.initString("");
    public final PBStringField config = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField meta = PBField.initString("");
    public final PBStringField prompt = PBField.initString("");
    public GroupOpenSysMsg.Source source = new GroupOpenSysMsg.Source();
    public final PBStringField ver = PBField.initString("");
    public final PBStringField view = PBField.initString("");
  }
  
  public static final class RichMsg
    extends MessageMicro<RichMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "title", "desc", "brief", "cover", "url", "source" }, new Object[] { "", "", "", "", "", null }, RichMsg.class);
    public final PBStringField brief = PBField.initString("");
    public final PBStringField cover = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public GroupOpenSysMsg.Source source = new GroupOpenSysMsg.Source();
    public final PBStringField title = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class Sender
    extends MessageMicro<Sender>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uin", "nick", "avatar", "url" }, new Object[] { Long.valueOf(0L), "", "", "" }, Sender.class);
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class Source
    extends MessageMicro<Source>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "name", "icon", "url" }, new Object[] { "", "", "" }, Source.class);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class SysMsgBody
    extends MessageMicro<SysMsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 58 }, new String[] { "group_id", "appid", "sender", "msg_type", "content", "rich_msg", "light_app" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0), "", null, null }, SysMsgBody.class);
    public final PBUInt64Field appid = PBField.initUInt64(0L);
    public final PBStringField content = PBField.initString("");
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public GroupOpenSysMsg.LightApp light_app = new GroupOpenSysMsg.LightApp();
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public GroupOpenSysMsg.RichMsg rich_msg = new GroupOpenSysMsg.RichMsg();
    public GroupOpenSysMsg.Sender sender = new GroupOpenSysMsg.Sender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.GroupOpenSysMsg
 * JD-Core Version:    0.7.0.1
 */