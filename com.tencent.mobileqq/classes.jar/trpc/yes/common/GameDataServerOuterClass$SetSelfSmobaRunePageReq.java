package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GameDataServerOuterClass$SetSelfSmobaRunePageReq
  extends MessageMicro<SetSelfSmobaRunePageReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field area = PBField.initUInt32(0);
  public final PBUInt32Field partition = PBField.initUInt32(0);
  public final PBUInt32Field rune_page_idx = PBField.initUInt32(0);
  public final PBStringField rune_str = PBField.initString("");
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uid", "rune_page_idx", "rune_str", "area", "partition" }, new Object[] { Long.valueOf(0L), localInteger, "", localInteger, localInteger }, SetSelfSmobaRunePageReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.SetSelfSmobaRunePageReq
 * JD-Core Version:    0.7.0.1
 */