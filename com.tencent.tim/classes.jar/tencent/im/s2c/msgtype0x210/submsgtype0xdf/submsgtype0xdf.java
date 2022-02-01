package tencent.im.s2c.msgtype0x210.submsgtype0xdf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.apollo_game_status.STCMGameMessage;

public final class submsgtype0xdf
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_game_state", "rpt_uint32_uinList" }, new Object[] { null, Integer.valueOf(0) }, MsgBody.class);
    public apollo_game_status.STCMGameMessage msg_game_state = new apollo_game_status.STCMGameMessage();
    public final PBRepeatField<Integer> rpt_uint32_uinList = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xdf.submsgtype0xdf
 * JD-Core Version:    0.7.0.1
 */