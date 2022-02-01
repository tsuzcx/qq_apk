package tianshu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleTianShu$AdItem
  extends MessageMicro<AdItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 42, 82, 90, 98, 106, 114, 122, 162 }, new String[] { "iAdId", "traceinfo", "title", "desc", "jumpurl", "iconurl", "lstPic", "argList", "ext_info" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", "", null, "" }, AdItem.class);
  public final PBRepeatMessageField<QQCircleTianShu.MapEntry> argList = PBField.initRepeatMessage(QQCircleTianShu.MapEntry.class);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField ext_info = PBField.initString("");
  public final PBUInt32Field iAdId = PBField.initUInt32(0);
  public final PBStringField iconurl = PBField.initString("");
  public final PBStringField jumpurl = PBField.initString("");
  public final PBRepeatField<String> lstPic = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField title = PBField.initString("");
  public final PBStringField traceinfo = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tianshu.QQCircleTianShu.AdItem
 * JD-Core Version:    0.7.0.1
 */