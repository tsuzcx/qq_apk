package trpc.qq_vgame.resultshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameResultShare$UserScoreInfo
  extends MessageMicro<UserScoreInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "score" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, UserScoreInfo.class);
  public final PBUInt32Field score = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.resultshare.AvGameResultShare.UserScoreInfo
 * JD-Core Version:    0.7.0.1
 */