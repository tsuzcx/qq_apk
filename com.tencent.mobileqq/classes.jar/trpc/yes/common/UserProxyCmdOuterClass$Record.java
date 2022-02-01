package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class UserProxyCmdOuterClass$Record
  extends MessageMicro<Record>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<UserProxyCmdOuterClass.UserHeroInfo> best_heros = PBField.initRepeatMessage(UserProxyCmdOuterClass.UserHeroInfo.class);
  public final PBEnumField best_occupation = PBField.initEnum(0);
  public final PBInt64Field games_total = PBField.initInt64(0L);
  public final PBInt64Field grade = PBField.initInt64(0L);
  public final PBInt64Field mvp_total = PBField.initInt64(0L);
  public final PBDoubleField win_rate = PBField.initDouble(0.0D);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 17, 24, 32, 40, 50 }, new String[] { "grade", "win_rate", "games_total", "mvp_total", "best_occupation", "best_heros" }, new Object[] { localLong, Double.valueOf(0.0D), localLong, localLong, Integer.valueOf(0), null }, Record.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.Record
 * JD-Core Version:    0.7.0.1
 */