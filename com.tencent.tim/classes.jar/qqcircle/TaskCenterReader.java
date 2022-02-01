package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class TaskCenterReader
{
  public static final class FuelDataReq
    extends MessageMicro<FuelDataReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "userId", "reqFrom", "optType" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0) }, FuelDataReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBEnumField optType = PBField.initEnum(0);
    public final PBInt32Field reqFrom = PBField.initInt32(0);
    public final PBRepeatField<String> userId = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class FuelDataRsp
    extends MessageMicro<FuelDataRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "fuelData" }, new Object[] { null, null }, FuelDataRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatMessageField<TaskCenterReader.FuelInfo> fuelData = PBField.initRepeatMessage(TaskCenterReader.FuelInfo.class);
  }
  
  public static final class FuelInfo
    extends MessageMicro<FuelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "userId", "myFuel", "fuelValue" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, FuelInfo.class);
    public final PBUInt32Field fuelValue = PBField.initUInt32(0);
    public final PBUInt32Field myFuel = PBField.initUInt32(0);
    public final PBStringField userId = PBField.initString("");
  }
  
  public static final class FuelListRecord
    extends MessageMicro<FuelListRecord>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "behaviorType", "opName", "optTime", "fuelValue", "leftFuel" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FuelListRecord.class);
    public final PBEnumField behaviorType = PBField.initEnum(0);
    public final PBInt32Field fuelValue = PBField.initInt32(0);
    public final PBInt32Field leftFuel = PBField.initInt32(0);
    public final PBStringField opName = PBField.initString("");
    public final PBUInt32Field optTime = PBField.initUInt32(0);
  }
  
  public static final class FuelListReq
    extends MessageMicro<FuelListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "extInfo", "userId", "reqFrom", "num", "ext" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), "" }, FuelListReq.class);
    public final PBStringField ext = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBInt32Field reqFrom = PBField.initInt32(0);
    public final PBStringField userId = PBField.initString("");
  }
  
  public static final class FuelListRsp
    extends MessageMicro<FuelListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "extInfo", "fuelRecords", "isFinish", "ext" }, new Object[] { null, null, Integer.valueOf(0), "" }, FuelListRsp.class);
    public final PBStringField ext = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatMessageField<TaskCenterReader.FuelListRecord> fuelRecords = PBField.initRepeatMessage(TaskCenterReader.FuelListRecord.class);
    public final PBInt32Field isFinish = PBField.initInt32(0);
  }
  
  public static final class TaskListReq
    extends MessageMicro<TaskListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "extInfo", "userId", "reqFrom", "num", "ext" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), "" }, TaskListReq.class);
    public final PBStringField ext = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBInt32Field reqFrom = PBField.initInt32(0);
    public final PBStringField userId = PBField.initString("");
  }
  
  public static final class TaskListRsp
    extends MessageMicro<TaskListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50 }, new String[] { "extInfo", "myFuel", "taskRecords", "isFinish", "ext", "taskEntranceUrl" }, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(0), "", "" }, TaskListRsp.class);
    public final PBStringField ext = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field isFinish = PBField.initInt32(0);
    public final PBUInt32Field myFuel = PBField.initUInt32(0);
    public final PBStringField taskEntranceUrl = PBField.initString("");
    public final PBRepeatMessageField<TaskCenterReader.TaskRecord> taskRecords = PBField.initRepeatMessage(TaskCenterReader.TaskRecord.class);
  }
  
  public static final class TaskRecord
    extends MessageMicro<TaskRecord>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50 }, new String[] { "taskType", "title", "desc", "haveDone", "maxCnt", "jumpUrl" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "" }, TaskRecord.class);
    public final PBStringField desc = PBField.initString("");
    public final PBInt32Field haveDone = PBField.initInt32(0);
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBInt32Field maxCnt = PBField.initInt32(0);
    public final PBEnumField taskType = PBField.initEnum(0);
    public final PBStringField title = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.TaskCenterReader
 * JD-Core Version:    0.7.0.1
 */