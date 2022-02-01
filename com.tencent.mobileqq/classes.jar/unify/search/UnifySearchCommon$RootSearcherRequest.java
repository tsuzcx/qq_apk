package unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UnifySearchCommon$RootSearcherRequest
  extends MessageMicro<RootSearcherRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field business = PBField.initUInt32(0);
  public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField json_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField ocean_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field page_size = PBField.initUInt32(0);
  public final PBBytesField qua = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<ByteStringMicro> query_cate = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field query_rewrite = PBField.initUInt32(0);
  public final PBRepeatField<Long> rpt_busi_mask = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field use_all_mask = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 32, 80, 90, 402, 408, 418, 424, 434, 442 }, new String[] { "business", "page_size", "rpt_busi_mask", "cookie", "ocean_data", "use_all_mask", "query_cate", "query_rewrite", "qua", "json_data" }, new Object[] { localInteger, localInteger, Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localInteger, localByteStringMicro3, localInteger, localByteStringMicro4, localByteStringMicro5 }, RootSearcherRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     unify.search.UnifySearchCommon.RootSearcherRequest
 * JD-Core Version:    0.7.0.1
 */