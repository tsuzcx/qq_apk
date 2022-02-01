package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameNotify$NotifyPKUserFail
  extends MessageMicro<NotifyPKUserFail>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField award_delay = PBField.initBool(false);
  public final PBBytesField award_str = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField award_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField award_url_str = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBoolField both_lose = PBField.initBool(false);
  public final PBBoolField delay_award = PBField.initBool(false);
  public final PBBytesField delay_award_tip = PBField.initBytes(ByteStringMicro.EMPTY);
  public AvGameNotify.PKDrawRes draw_res = new AvGameNotify.PKDrawRes();
  public final PBBoolField has_consolation_award = PBField.initBool(false);
  public final PBUInt32Field rank = PBField.initUInt32(0);
  public final PBUInt32Field score = PBField.initUInt32(0);
  public final PBUInt32Field total = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 58, 64, 74, 82, 88, 96 }, new String[] { "rank", "total", "has_consolation_award", "award_str", "award_url", "award_delay", "award_url_str", "delay_award", "delay_award_tip", "draw_res", "both_lose", "score" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), localByteStringMicro1, localByteStringMicro2, Boolean.valueOf(false), localByteStringMicro3, Boolean.valueOf(false), localByteStringMicro4, null, Boolean.valueOf(false), Integer.valueOf(0) }, NotifyPKUserFail.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserFail
 * JD-Core Version:    0.7.0.1
 */