package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Result;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class TaskCenterWrite
{
  public static final class FuelConsumeReq
    extends MessageMicro<FuelConsumeReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField behaviorType = PBField.initEnum(0);
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "extInfo", "behaviorType", "busiReqData" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro }, FuelConsumeReq.class);
    }
  }
  
  public static final class FuelConsumeRsp
    extends MessageMicro<FuelConsumeRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudCommon.Result ret = new FeedCloudCommon.Result();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "ret", "busiRspData" }, new Object[] { null, null, localByteStringMicro }, FuelConsumeRsp.class);
    }
  }
  
  public static final class FuelProduceData
    extends MessageMicro<FuelProduceData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 48 }, new String[] { "hostUid", "optTime", "optType", "feedsid", "srcuid", "optCnt" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) }, FuelProduceData.class);
    public final PBStringField feedsid = PBField.initString("");
    public final PBStringField hostUid = PBField.initString("");
    public final PBUInt32Field optCnt = PBField.initUInt32(0);
    public final PBUInt32Field optTime = PBField.initUInt32(0);
    public final PBEnumField optType = PBField.initEnum(0);
    public final PBStringField srcuid = PBField.initString("");
  }
  
  public static final class FuelProduceKafkaData
    extends MessageMicro<FuelProduceKafkaData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBEnumField optType = PBField.initEnum(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "optType", "busiReqData", "extInfo" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, FuelProduceKafkaData.class);
    }
  }
  
  public static final class FuelProduceReq
    extends MessageMicro<FuelProduceReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField behaviorType = PBField.initEnum(0);
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "extInfo", "behaviorType", "busiReqData" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro }, FuelProduceReq.class);
    }
  }
  
  public static final class FuelProduceRsp
    extends MessageMicro<FuelProduceRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudCommon.Result ret = new FeedCloudCommon.Result();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "ret", "busiRspData" }, new Object[] { null, null, localByteStringMicro }, FuelProduceRsp.class);
    }
  }
  
  public static final class PushFeedReq
    extends MessageMicro<PushFeedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "hostUserId", "srcUserId", "optTime", "feedsId", "optCnt" }, new Object[] { "", "", Integer.valueOf(0), "", Integer.valueOf(0) }, PushFeedReq.class);
    public final PBStringField feedsId = PBField.initString("");
    public final PBStringField hostUserId = PBField.initString("");
    public final PBUInt32Field optCnt = PBField.initUInt32(0);
    public final PBUInt32Field optTime = PBField.initUInt32(0);
    public final PBStringField srcUserId = PBField.initString("");
  }
  
  public static final class PushFeedRsp
    extends MessageMicro<PushFeedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "consumeFuel", "myFuel" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, PushFeedRsp.class);
    public final PBUInt32Field consumeFuel = PBField.initUInt32(0);
    public final PBUInt32Field myFuel = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.TaskCenterWrite
 * JD-Core Version:    0.7.0.1
 */