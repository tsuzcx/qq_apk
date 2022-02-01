package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SafeOuterClass$QQGMForbiddenUserReq
  extends MessageMicro<QQGMForbiddenUserReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field forbidden_time = PBField.initUInt32(0);
  public final PBEnumField forbidden_type = PBField.initEnum(0);
  public final PBBoolField is_gm = PBField.initBool(false);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBEnumField scene_type = PBField.initEnum(0);
  public final PBEnumField source_type = PBField.initEnum(0);
  public final PBUInt64Field visitor_uid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "room_id", "visitor_uid", "forbidden_type", "forbidden_time", "scene_type", "source_type", "is_gm" }, new Object[] { localLong, localLong, localInteger, localInteger, localInteger, localInteger, Boolean.valueOf(false) }, QQGMForbiddenUserReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.SafeOuterClass.QQGMForbiddenUserReq
 * JD-Core Version:    0.7.0.1
 */