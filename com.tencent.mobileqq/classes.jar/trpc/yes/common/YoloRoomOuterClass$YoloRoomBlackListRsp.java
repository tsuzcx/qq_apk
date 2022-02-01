package trpc.yes.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomBlackListRsp
  extends MessageMicro<YoloRoomBlackListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField has_more = PBField.initBool(false);
  public final PBBytesField server_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Long> uid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uid_list", "server_key", "has_more" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Boolean.valueOf(false) }, YoloRoomBlackListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomBlackListRsp
 * JD-Core Version:    0.7.0.1
 */