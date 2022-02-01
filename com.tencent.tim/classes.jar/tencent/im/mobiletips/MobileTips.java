package tencent.im.mobiletips;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MobileTips
{
  public static final class MobileTipsPkg
    extends MessageMicro<MobileTipsPkg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "req", "rsp" }, new Object[] { null, null }, MobileTipsPkg.class);
    public MobileTips.ReqBody req = new MobileTips.ReqBody();
    public MobileTips.RspBody rsp = new MobileTips.RspBody();
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int TYPE_C2C = 1;
    public static final int TYPE_DISCUSS = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "peer_type", "peer_uin", "task_list" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), null }, ReqBody.class);
    public final PBEnumField peer_type = PBField.initEnum(1);
    public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
    public final PBRepeatMessageField<MobileTips.TaskInfo> task_list = PBField.initRepeatMessage(MobileTips.TaskInfo.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "err" }, new Object[] { Integer.valueOf(0), "" }, RspBody.class);
    public final PBStringField err = PBField.initString("");
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
  
  public static final class TaskInfo
    extends MessageMicro<TaskInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "task_id", "msgcnt", "keywords" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, TaskInfo.class);
    public final PBRepeatField<String> keywords = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field msgcnt = PBField.initUInt32(0);
    public final PBUInt32Field task_id = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.mobiletips.MobileTips
 * JD-Core Version:    0.7.0.1
 */