package com.tencent.protofile.homework.hw_recite_score;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hw_recite_score
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
  
  public static final class ReqReciteScore
    extends MessageMicro<ReqReciteScore>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "error_times", "remind_times", "total_time", "total_word" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqReciteScore.class);
    public final PBUInt32Field error_times = PBField.initUInt32(0);
    public final PBUInt32Field remind_times = PBField.initUInt32(0);
    public final PBUInt32Field total_time = PBField.initUInt32(0);
    public final PBUInt32Field total_word = PBField.initUInt32(0);
  }
  
  public static final class RspReciteScore
    extends MessageMicro<RspReciteScore>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "score_grade" }, new Object[] { Integer.valueOf(0) }, RspReciteScore.class);
    public final PBUInt32Field score_grade = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.protofile.homework.hw_recite_score.hw_recite_score
 * JD-Core Version:    0.7.0.1
 */