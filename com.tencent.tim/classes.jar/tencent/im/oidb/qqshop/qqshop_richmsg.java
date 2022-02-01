package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqshop_richmsg
{
  public static final class SQQSHPFolderAdMsg
    extends MessageMicro<SQQSHPFolderAdMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 72, 82 }, new String[] { "ad_id", "begin_time", "end_time", "puin", "ad_url", "title", "pic_url", "name", "verify_flag", "ad_content_url" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", "", "", "", Integer.valueOf(0), "" }, SQQSHPFolderAdMsg.class);
    public final PBStringField ad_content_url = PBField.initString("");
    public final PBUInt64Field ad_id = PBField.initUInt64(0L);
    public final PBStringField ad_url = PBField.initString("");
    public final PBUInt32Field begin_time = PBField.initUInt32(0);
    public final PBUInt32Field end_time = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBRepeatField<String> pic_url = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt64Field puin = PBField.initUInt64(0L);
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field verify_flag = PBField.initUInt32(0);
  }
  
  public static final class SQQSHPRichMsg
    extends MessageMicro<SQQSHPRichMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "puin", "msg_id", "sendtime", "img_url" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "" }, SQQSHPRichMsg.class);
    public final PBRepeatField<String> img_url = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt64Field msg_id = PBField.initUInt64(0L);
    public final PBUInt64Field puin = PBField.initUInt64(0L);
    public final PBUInt64Field sendtime = PBField.initUInt64(0L);
  }
  
  public static final class SQQSHPRichMsgReq
    extends MessageMicro<SQQSHPRichMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rich_msgs" }, new Object[] { null }, SQQSHPRichMsgReq.class);
    public final PBRepeatMessageField<qqshop_richmsg.SQQSHPRichMsg> rich_msgs = PBField.initRepeatMessage(qqshop_richmsg.SQQSHPRichMsg.class);
  }
  
  public static final class SQQSHPRichMsgRsp
    extends MessageMicro<SQQSHPRichMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rich_msgs", "ad_msgs" }, new Object[] { null, null }, SQQSHPRichMsgRsp.class);
    public final PBRepeatMessageField<qqshop_richmsg.SQQSHPFolderAdMsg> ad_msgs = PBField.initRepeatMessage(qqshop_richmsg.SQQSHPFolderAdMsg.class);
    public final PBRepeatMessageField<qqshop_richmsg.SQQSHPRichMsg> rich_msgs = PBField.initRepeatMessage(qqshop_richmsg.SQQSHPRichMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop_richmsg
 * JD-Core Version:    0.7.0.1
 */