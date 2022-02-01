package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RecommendProxyOuterClass$KuolieRoomInfo
  extends MessageMicro<KuolieRoomInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBUInt64Field room_index = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "room_id", "room_index" }, new Object[] { localLong, localLong }, KuolieRoomInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.RecommendProxyOuterClass.KuolieRoomInfo
 * JD-Core Version:    0.7.0.1
 */