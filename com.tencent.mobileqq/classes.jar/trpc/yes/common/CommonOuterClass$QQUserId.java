package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CommonOuterClass$QQUserId
  extends MessageMicro<QQUserId>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field guild_id = PBField.initUInt64(0L);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBInt32Field user_from = PBField.initInt32(0);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uid", "user_from", "guild_id" }, new Object[] { localLong, Integer.valueOf(0), localLong }, QQUserId.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.CommonOuterClass.QQUserId
 * JD-Core Version:    0.7.0.1
 */