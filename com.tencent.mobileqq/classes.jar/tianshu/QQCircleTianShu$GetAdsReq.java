package tianshu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleTianShu$GetAdsReq
  extends MessageMicro<GetAdsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "stComminfo", "lstPos" }, new Object[] { null, null }, GetAdsReq.class);
  public final PBRepeatMessageField<QQCircleTianShu.AdPosItem> lstPos = PBField.initRepeatMessage(QQCircleTianShu.AdPosItem.class);
  public QQCircleTianShu.CommInfo stComminfo = new QQCircleTianShu.CommInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tianshu.QQCircleTianShu.GetAdsReq
 * JD-Core Version:    0.7.0.1
 */