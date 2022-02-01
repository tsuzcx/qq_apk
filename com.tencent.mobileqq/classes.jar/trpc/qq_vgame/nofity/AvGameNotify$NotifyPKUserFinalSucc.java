package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.PKUserRankInfo;
import trpc.qq_vgame.common.AvGameCommon.UinWrap;

public final class AvGameNotify$NotifyPKUserFinalSucc
  extends MessageMicro<NotifyPKUserFinalSucc>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField award_str = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField award_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField award_url_str = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBoolField delay_award = PBField.initBool(false);
  public final PBBytesField delay_award_tip = PBField.initBytes(ByteStringMicro.EMPTY);
  public AvGameNotify.PKDrawRes draw_res = new AvGameNotify.PKDrawRes();
  public final PBRepeatMessageField<AvGameCommon.UinWrap> final_ranking = PBField.initRepeatMessage(AvGameCommon.UinWrap.class);
  public final PBRepeatMessageField<AvGameCommon.PKUserRankInfo> ranking = PBField.initRepeatMessage(AvGameCommon.PKUserRankInfo.class);
  public final PBUInt32Field reason = PBField.initUInt32(0);
  public final PBUInt32Field total = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 58, 66, 72, 82, 90 }, new String[] { "reason", "total", "final_ranking", "award_str", "award_url", "ranking", "award_url_str", "delay_award", "delay_award_tip", "draw_res" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2, null, localByteStringMicro3, Boolean.valueOf(false), localByteStringMicro4, null }, NotifyPKUserFinalSucc.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserFinalSucc
 * JD-Core Version:    0.7.0.1
 */