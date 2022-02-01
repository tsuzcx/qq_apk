package tencent.im.oidb.cmd0x814;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x814
{
  public static final class Activity
    extends MessageMicro<Activity>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "id", "name", "cover", "url" }, new Object[] { "", "", "", "" }, Activity.class);
    public final PBStringField cover = PBField.initString("");
    public final PBStringField id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "show_uin", "start", "num", "history" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field history = PBField.initUInt32(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt64Field show_uin = PBField.initUInt64(0L);
    public final PBUInt32Field start = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "total", "activity_list", "url" }, new Object[] { Integer.valueOf(0), null, "" }, RspBody.class);
    public final PBRepeatMessageField<oidb_0x814.Activity> activity_list = PBField.initRepeatMessage(oidb_0x814.Activity.class);
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x814.oidb_0x814
 * JD-Core Version:    0.7.0.1
 */