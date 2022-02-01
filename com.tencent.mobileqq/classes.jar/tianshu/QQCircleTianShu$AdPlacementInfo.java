package tianshu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleTianShu$AdPlacementInfo
  extends MessageMicro<AdPlacementInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField ctlInfo = PBField.initString("");
  public final PBStringField extInfo = PBField.initString("");
  public final PBRepeatMessageField<QQCircleTianShu.AdItem> lst = PBField.initRepeatMessage(QQCircleTianShu.AdItem.class);
  public final PBUInt32Field next_query_ts = PBField.initUInt32(0);
  public final PBInt32Field type = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "type", "lst", "next_query_ts", "extInfo", "ctlInfo" }, new Object[] { localInteger, null, localInteger, "", "" }, AdPlacementInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tianshu.QQCircleTianShu.AdPlacementInfo
 * JD-Core Version:    0.7.0.1
 */