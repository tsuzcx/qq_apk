package com.tencent.protofile.cmd0xe23;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xe23
{
  public static final class GetConsumeInfoItem
    extends MessageMicro<GetConsumeInfoItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 24, 32, 40, 48, 56 }, new String[] { "current_progress", "total_progress", "need_record", "next_request_time", "continue_finish_day", "today_ad_count" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GetConsumeInfoItem.class);
    public final PBUInt32Field continue_finish_day = PBField.initUInt32(0);
    public final PBUInt32Field current_progress = PBField.initUInt32(0);
    public final PBUInt32Field need_record = PBField.initUInt32(0);
    public final PBUInt64Field next_request_time = PBField.initUInt64(0L);
    public final PBUInt32Field today_ad_count = PBField.initUInt32(0);
    public final PBUInt32Field total_progress = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin", "continue_finish_day", "today_ad_count" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field continue_finish_day = PBField.initUInt32(0);
    public final PBUInt32Field today_ad_count = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "result_code", "rpt_consume_info_item", "task_config" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
    public final PBInt32Field result_code = PBField.initInt32(0);
    public cmd0xe23.GetConsumeInfoItem rpt_consume_info_item = new cmd0xe23.GetConsumeInfoItem();
    public cmd0xe23.TaskConfig task_config = new cmd0xe23.TaskConfig();
  }
  
  public static final class TaskConfig
    extends MessageMicro<TaskConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "total_progress", "total_cycle", "article_max_time", "article_still_max_time", "rpt_record_article_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, TaskConfig.class);
    public final PBUInt32Field article_max_time = PBField.initUInt32(0);
    public final PBUInt32Field article_still_max_time = PBField.initUInt32(0);
    public final PBRepeatField<Integer> rpt_record_article_type = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBUInt32Field total_cycle = PBField.initUInt32(0);
    public final PBUInt32Field total_progress = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.protofile.cmd0xe23.cmd0xe23
 * JD-Core Version:    0.7.0.1
 */