package tencent.im.oidb.cmd0xc76;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xc76
{
  public static final class Item
    extends MessageMicro<Item>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48 }, new String[] { "id", "name", "icon", "value", "type", "puin" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, Item.class);
    public final PBStringField icon = PBField.initString("");
    public final PBUInt64Field id = PBField.initUInt64(0L);
    public final PBStringField name = PBField.initString("");
    public final PBUInt64Field puin = PBField.initUInt64(0L);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field value = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "cmd", "apps" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
    public final PBRepeatMessageField<oidb_cmd0xc76.Item> apps = PBField.initRepeatMessage(oidb_cmd0xc76.Item.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "cmd", "main", "apps" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
    public oidb_cmd0xc76.Setting apps = new oidb_cmd0xc76.Setting();
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public oidb_cmd0xc76.Setting main = new oidb_cmd0xc76.Setting();
  }
  
  public static final class Setting
    extends MessageMicro<Setting>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "desc", "item" }, new Object[] { "", null }, Setting.class);
    public final PBStringField desc = PBField.initString("");
    public final PBRepeatMessageField<oidb_cmd0xc76.Item> item = PBField.initRepeatMessage(oidb_cmd0xc76.Item.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc76.oidb_cmd0xc76
 * JD-Core Version:    0.7.0.1
 */