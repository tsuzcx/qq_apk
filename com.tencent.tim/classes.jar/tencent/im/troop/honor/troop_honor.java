package tencent.im.troop.honor;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class troop_honor
{
  public static final class GroupUserCardHonor
    extends MessageMicro<GroupUserCardHonor>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "id" }, new Object[] { Integer.valueOf(0) }, GroupUserCardHonor.class);
    public final PBRepeatField<Integer> id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class HonorChangeGrayTipsReserved
    extends MessageMicro<HonorChangeGrayTipsReserved>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "user_honor" }, new Object[] { null }, HonorChangeGrayTipsReserved.class);
    public final PBRepeatMessageField<troop_honor.UserHonor> user_honor = PBField.initRepeatMessage(troop_honor.UserHonor.class);
  }
  
  public static final class UserHonor
    extends MessageMicro<UserHonor>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, UserHonor.class);
    public final PBRepeatField<Integer> id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.troop.honor.troop_honor
 * JD-Core Version:    0.7.0.1
 */