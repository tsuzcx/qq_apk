package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UgcRight$UgcDataKey
  extends MessageMicro<UgcDataKey>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "uin", "platform", "dataID", "check_rightflag" }, new Object[] { "", Integer.valueOf(0), "", Long.valueOf(0L) }, UgcDataKey.class);
  public final PBUInt64Field check_rightflag = PBField.initUInt64(0L);
  public final PBStringField dataID = PBField.initString("");
  public final PBInt32Field platform = PBField.initInt32(0);
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     ufo.UgcRight.UgcDataKey
 * JD-Core Version:    0.7.0.1
 */