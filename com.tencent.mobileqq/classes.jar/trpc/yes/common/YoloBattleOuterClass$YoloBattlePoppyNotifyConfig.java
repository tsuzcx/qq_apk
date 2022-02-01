package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattleOuterClass$YoloBattlePoppyNotifyConfig
  extends MessageMicro<YoloBattlePoppyNotifyConfig>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field cmd = PBField.initInt32(0);
  public final PBUInt64Field serial_key = PBField.initUInt64(0L);
  public final PBStringField server_address = PBField.initString("");
  public final PBInt64Field server_route_id = PBField.initInt64(0L);
  public final PBInt64Field thread_route_id = PBField.initInt64(0L);
  public final PBUInt32Field timeout = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48 }, new String[] { "cmd", "server_address", "thread_route_id", "server_route_id", "serial_key", "timeout" }, new Object[] { localInteger, "", localLong, localLong, localLong, localInteger }, YoloBattlePoppyNotifyConfig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.YoloBattlePoppyNotifyConfig
 * JD-Core Version:    0.7.0.1
 */