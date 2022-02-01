package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameCommon$PKUserRankInfo
  extends MessageMicro<PKUserRankInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field rank = PBField.initUInt32(0);
  public final PBUInt32Field score = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "rank", "uin", "score" }, new Object[] { localInteger, Long.valueOf(0L), localInteger }, PKUserRankInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.common.AvGameCommon.PKUserRankInfo
 * JD-Core Version:    0.7.0.1
 */