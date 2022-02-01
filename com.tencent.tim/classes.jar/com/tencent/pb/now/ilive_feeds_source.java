package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class ilive_feeds_source
{
  public static final class CollectFeedsDataReq
    extends MessageMicro<CollectFeedsDataReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField client_type = PBField.initEnum(1);
    public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField feeds_source = PBField.initEnum(1);
    public final PBRepeatField<ByteStringMicro> feeds_topic = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "feeds_id", "feeds_source", "feeds_topic", "client_type" }, new Object[] { localByteStringMicro1, Integer.valueOf(1), localByteStringMicro2, Integer.valueOf(1) }, CollectFeedsDataReq.class);
    }
  }
  
  public static final class CollectFeedsDataRsp
    extends MessageMicro<CollectFeedsDataRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "error_code" }, new Object[] { Integer.valueOf(0) }, CollectFeedsDataRsp.class);
    public final PBInt32Field error_code = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_source
 * JD-Core Version:    0.7.0.1
 */