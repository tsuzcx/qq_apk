package com.tencent.mobileqq.troop.homework.arithmetic.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MathHWNetWorkPB
{
  public static final class ErrorInfo
    extends MessageMicro<ErrorInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field error_code = PBField.initUInt32(0);
    public final PBBytesField error_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "error_code", "error_desc" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ErrorInfo.class);
    }
  }
  
  public static final class ReqCheckHomework
    extends MessageMicro<ReqCheckHomework>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "group_id", "hw_id", "uin", "pics" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null }, ReqCheckHomework.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt64Field hw_id = PBField.initUInt64(0L);
    public final PBRepeatMessageField<MathHWNetWorkPB.YoutuPicInfo> pics = PBField.initRepeatMessage(MathHWNetWorkPB.YoutuPicInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class RspCheckHomework
    extends MessageMicro<RspCheckHomework>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "errinfo" }, new Object[] { null }, RspCheckHomework.class);
    public MathHWNetWorkPB.ErrorInfo errinfo = new MathHWNetWorkPB.ErrorInfo();
  }
  
  public static final class YoutuPicInfo
    extends MessageMicro<YoutuPicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField new_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField new_url = PBField.initString("");
    public final PBStringField old_url = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "old_url", "new_url", "new_data" }, new Object[] { "", "", localByteStringMicro }, YoutuPicInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.pb.MathHWNetWorkPB
 * JD-Core Version:    0.7.0.1
 */