package circletaskcenter;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CircleTaskCenterStorage
{
  public static final class FuelList
    extends MessageMicro<FuelList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "records" }, new Object[] { null }, FuelList.class);
    public final PBRepeatMessageField<CircleTaskCenterStorage.FuelRecord> records = PBField.initRepeatMessage(CircleTaskCenterStorage.FuelRecord.class);
  }
  
  public static final class FuelRecord
    extends MessageMicro<FuelRecord>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "optTime", "behaviorType", "fuelValue", "leftFuelValue" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FuelRecord.class);
    public final PBUInt32Field behaviorType = PBField.initUInt32(0);
    public final PBInt32Field fuelValue = PBField.initInt32(0);
    public final PBUInt32Field leftFuelValue = PBField.initUInt32(0);
    public final PBUInt32Field optTime = PBField.initUInt32(0);
  }
  
  public static final class MyFuel
    extends MessageMicro<MyFuel>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "total" }, new Object[] { Integer.valueOf(0) }, MyFuel.class);
    public final PBUInt32Field total = PBField.initUInt32(0);
  }
  
  public static final class RecieveFuel
    extends MessageMicro<RecieveFuel>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "fuels" }, new Object[] { Integer.valueOf(0) }, RecieveFuel.class);
    public final PBUInt32Field fuels = PBField.initUInt32(0);
  }
  
  public static final class UserBehaviorFlow
    extends MessageMicro<UserBehaviorFlow>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "records" }, new Object[] { null }, UserBehaviorFlow.class);
    public final PBRepeatMessageField<CircleTaskCenterStorage.UserBehaviorRecord> records = PBField.initRepeatMessage(CircleTaskCenterStorage.UserBehaviorRecord.class);
  }
  
  public static final class UserBehaviorRecord
    extends MessageMicro<UserBehaviorRecord>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "behaviorType", "optTime" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, UserBehaviorRecord.class);
    public final PBEnumField behaviorType = PBField.initEnum(0);
    public final PBUInt32Field optTime = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     circletaskcenter.CircleTaskCenterStorage
 * JD-Core Version:    0.7.0.1
 */