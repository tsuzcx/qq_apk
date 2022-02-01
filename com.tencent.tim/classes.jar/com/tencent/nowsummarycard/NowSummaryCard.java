package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowSummaryCard
{
  public static final class NowSummaryCardReq
    extends MessageMicro<NowSummaryCardReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field id = PBField.initUInt64(0L);
    public final PBUInt32Field id_type = PBField.initUInt32(0);
    public final PBBytesField jce_data = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "jce_data", "id", "id_type" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, NowSummaryCardReq.class);
    }
  }
  
  public static final class NowSummaryCardRsp
    extends MessageMicro<NowSummaryCardRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt64Field id = PBField.initUInt64(0L);
    public final PBUInt32Field id_type = PBField.initUInt32(0);
    public final PBBytesField jce_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "jce_data", "id", "id_type", "ret_code", "err_msg" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "" }, NowSummaryCardRsp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard
 * JD-Core Version:    0.7.0.1
 */