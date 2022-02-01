package tencent.im.oidb.cmd0x934;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x934
{
  public static final class Item
    extends MessageMicro<Item>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58 }, new String[] { "off_info", "on_info", "hot", "id", "version", "mark", "setting_url" }, new Object[] { null, null, Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "" }, Item.class);
    public final PBBoolField hot = PBField.initBool(false);
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBUInt64Field mark = PBField.initUInt64(0L);
    public cmd0x934.ItemInfo off_info = new cmd0x934.ItemInfo();
    public cmd0x934.ItemInfo on_info = new cmd0x934.ItemInfo();
    public final PBStringField setting_url = PBField.initString("");
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class ItemInfo
    extends MessageMicro<ItemInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "title", "icon", "url", "color", "font_color", "border_color" }, new Object[] { "", "", "", "", "", "" }, ItemInfo.class);
    public final PBStringField border_color = PBField.initString("");
    public final PBStringField color = PBField.initString("");
    public final PBStringField font_color = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class List
    extends MessageMicro<List>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "name", "items" }, new Object[] { "", null }, List.class);
    public final PBRepeatMessageField<cmd0x934.Item> items = PBField.initRepeatMessage(cmd0x934.Item.class);
    public final PBStringField name = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "cmd", "group_id", "version", "keyword", "robot_uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBStringField keyword = PBField.initString("");
    public final PBUInt64Field robot_uin = PBField.initUInt64(0L);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "version", "lists", "robot_uin" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, RspBody.class);
    public final PBRepeatMessageField<cmd0x934.List> lists = PBField.initRepeatMessage(cmd0x934.List.class);
    public final PBUInt64Field robot_uin = PBField.initUInt64(0L);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x934.cmd0x934
 * JD-Core Version:    0.7.0.1
 */