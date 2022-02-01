package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UserProxyCmdOuterClass$JoinedGuildInfo
  extends MessageMicro<JoinedGuildInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field guild_id = PBField.initUInt64(0L);
  public final PBUInt64Field join_time = PBField.initUInt64(0L);
  public final PBStringField member_nick = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "guild_id", "join_time", "member_nick" }, new Object[] { localLong, localLong, "" }, JoinedGuildInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.JoinedGuildInfo
 * JD-Core Version:    0.7.0.1
 */