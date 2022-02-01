package trpc.yes.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomBlackListReq
  extends MessageMicro<YoloRoomBlackListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField client_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "room_id", "client_key" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, YoloRoomBlackListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomBlackListReq
 * JD-Core Version:    0.7.0.1
 */