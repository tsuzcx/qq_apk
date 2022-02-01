package tianshu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleTianShu$RspEntry
  extends MessageMicro<RspEntry>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "key", "value" }, new Object[] { Integer.valueOf(0), null }, RspEntry.class);
  public final PBUInt32Field key = PBField.initUInt32(0);
  public QQCircleTianShu.AdPlacementInfo value = new QQCircleTianShu.AdPlacementInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tianshu.QQCircleTianShu.RspEntry
 * JD-Core Version:    0.7.0.1
 */