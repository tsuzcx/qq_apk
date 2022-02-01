package unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UnifySearchCommon$Meaning
  extends MessageMicro<Meaning>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field eflag = PBField.initUInt32(0);
  public final PBBytesField words = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "words", "eflag" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, Meaning.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     unify.search.UnifySearchCommon.Meaning
 * JD-Core Version:    0.7.0.1
 */