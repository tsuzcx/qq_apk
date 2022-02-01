package tianshu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleTianShu$AdPosItem
  extends MessageMicro<AdPosItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<QQCircleTianShu.MapEntry> extra_info = PBField.initRepeatMessage(QQCircleTianShu.MapEntry.class);
  public final PBUInt32Field nNeedCnt = PBField.initUInt32(0);
  public final PBUInt32Field posId = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 114 }, new String[] { "posId", "nNeedCnt", "extra_info" }, new Object[] { localInteger, localInteger, null }, AdPosItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tianshu.QQCircleTianShu.AdPosItem
 * JD-Core Version:    0.7.0.1
 */