package trpc.yes.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GameDataServerOuterClass$AgreeSmobaAuthReq
  extends MessageMicro<AgreeSmobaAuthReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField a2_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field sense = PBField.initInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uid", "a2_key", "sense" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, AgreeSmobaAuthReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.AgreeSmobaAuthReq
 * JD-Core Version:    0.7.0.1
 */