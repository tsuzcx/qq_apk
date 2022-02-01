package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameStrangerMatch$DelMatchUserReq
  extends MessageMicro<DelMatchUserReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field gender = PBField.initUInt32(0);
  public final PBUInt32Field shard_id = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uin", "type", "shard_id", "gender" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger }, DelMatchUserReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.stranger_match.AvGameStrangerMatch.DelMatchUserReq
 * JD-Core Version:    0.7.0.1
 */