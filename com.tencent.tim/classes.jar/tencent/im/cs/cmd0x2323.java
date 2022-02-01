package tencent.im.cs;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x2323
{
  public static final class BodyMsg
    extends MessageMicro<BodyMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "group_code", "user_num", "action", "video_user_list", "stage_mode", "live_extra_mode", "game_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, BodyMsg.class);
    public final PBUInt32Field action = PBField.initUInt32(0);
    public final PBUInt32Field game_id = PBField.initUInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBUInt32Field live_extra_mode = PBField.initUInt32(0);
    public final PBUInt32Field stage_mode = PBField.initUInt32(0);
    public final PBUInt32Field user_num = PBField.initUInt32(0);
    public final PBRepeatField<Long> video_user_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "group_code_list" }, new Object[] { Long.valueOf(0L) }, ReqBody.class);
    public final PBRepeatField<Long> group_code_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret", "body_msg" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
    public final PBRepeatMessageField<cmd0x2323.BodyMsg> body_msg = PBField.initRepeatMessage(cmd0x2323.BodyMsg.class);
    public final PBInt32Field ret = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.cmd0x2323
 * JD-Core Version:    0.7.0.1
 */