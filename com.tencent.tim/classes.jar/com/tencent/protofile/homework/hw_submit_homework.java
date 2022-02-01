package com.tencent.protofile.homework;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hw_submit_homework
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
  
  public static final class HwCommentInfo
    extends MessageMicro<HwCommentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field createts = PBField.initUInt64(0L);
    public final PBStringField id = PBField.initString("");
    public final PBUInt64Field modifyts = PBField.initUInt64(0L);
    public final PBBytesField text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 32, 40, 48 }, new String[] { "id", "text", "createts", "modifyts", "uin" }, new Object[] { "", localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, HwCommentInfo.class);
    }
  }
  
  public static final class HwExamAnswer
    extends MessageMicro<HwExamAnswer>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "questionid", "answer", "result", "score" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0) }, HwExamAnswer.class);
    public final PBStringField answer = PBField.initString("");
    public final PBStringField questionid = PBField.initString("");
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBUInt32Field score = PBField.initUInt32(0);
  }
  
  public static final class HwExamination
    extends MessageMicro<HwExamination>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 82, 90, 402 }, new String[] { "total_count", "correct_count", "error_count", "undone_count", "total_score", "elapsed_time", "avg_elapsed_time", "difficult", "answer_status", "answer_analyse", "difficult_desc", "answer" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", null }, HwExamination.class);
    public final PBRepeatMessageField<hw_submit_homework.HwExamAnswer> answer = PBField.initRepeatMessage(hw_submit_homework.HwExamAnswer.class);
    public final PBStringField answer_analyse = PBField.initString("");
    public final PBUInt32Field answer_status = PBField.initUInt32(0);
    public final PBUInt32Field avg_elapsed_time = PBField.initUInt32(0);
    public final PBUInt32Field correct_count = PBField.initUInt32(0);
    public final PBUInt32Field difficult = PBField.initUInt32(0);
    public final PBStringField difficult_desc = PBField.initString("");
    public final PBUInt32Field elapsed_time = PBField.initUInt32(0);
    public final PBUInt32Field error_count = PBField.initUInt32(0);
    public final PBUInt32Field total_count = PBField.initUInt32(0);
    public final PBUInt32Field total_score = PBField.initUInt32(0);
    public final PBUInt32Field undone_count = PBField.initUInt32(0);
  }
  
  public static final class ReqSubmitHomework
    extends MessageMicro<ReqSubmitHomework>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "hw_id", "gid", "status", "comment_info", "examination", "openId" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, null, "" }, ReqSubmitHomework.class);
    public hw_submit_homework.HwCommentInfo comment_info = new hw_submit_homework.HwCommentInfo();
    public hw_submit_homework.HwExamination examination = new hw_submit_homework.HwExamination();
    public final PBUInt64Field gid = PBField.initUInt64(0L);
    public final PBUInt64Field hw_id = PBField.initUInt64(0L);
    public final PBStringField openId = PBField.initString("");
    public final PBInt32Field status = PBField.initInt32(0);
  }
  
  public static final class RspSubmitHomework
    extends MessageMicro<RspSubmitHomework>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "errinfo", "status" }, new Object[] { null, Integer.valueOf(0) }, RspSubmitHomework.class);
    public hw_submit_homework.ErrorInfo errinfo = new hw_submit_homework.ErrorInfo();
    public final PBInt32Field status = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.protofile.homework.hw_submit_homework
 * JD-Core Version:    0.7.0.1
 */