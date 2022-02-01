package tencent.im.oidb.cmd0x971;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x971
{
  public static final class NoticeInfo
    extends MessageMicro<NoticeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48 }, new String[] { "rule_id", "title", "summary", "icon", "url", "version" }, new Object[] { Integer.valueOf(0), "", "", "", "", Integer.valueOf(0) }, NoticeInfo.class);
    public final PBStringField icon = PBField.initString("");
    public final PBUInt32Field rule_id = PBField.initUInt32(0);
    public final PBStringField summary = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rule_id" }, new Object[] { Integer.valueOf(0) }, ReqBody.class);
    public final PBRepeatField<Integer> rule_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "notices" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0x971.NoticeInfo> notices = PBField.initRepeatMessage(oidb_0x971.NoticeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x971.oidb_0x971
 * JD-Core Version:    0.7.0.1
 */