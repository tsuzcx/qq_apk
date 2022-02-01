package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattleMiniGameOuterClass$YoloMiniGamePlayerInfo
  extends MessageMicro<YoloMiniGamePlayerInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uid", "user_access_info" }, new Object[] { Long.valueOf(0L), "" }, YoloMiniGamePlayerInfo.class);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBStringField user_access_info = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleMiniGameOuterClass.YoloMiniGamePlayerInfo
 * JD-Core Version:    0.7.0.1
 */