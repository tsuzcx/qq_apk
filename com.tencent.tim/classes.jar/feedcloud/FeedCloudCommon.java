package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudCommon
{
  public static final class BytesEntry
    extends MessageMicro<BytesEntry>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField key = PBField.initString("");
    public final PBBytesField value = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "key", "value" }, new Object[] { "", localByteStringMicro }, BytesEntry.class);
    }
  }
  
  public static final class Entry
    extends MessageMicro<Entry>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "key", "value" }, new Object[] { "", "" }, Entry.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
  }
  
  public static final class Result
    extends MessageMicro<Result>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retCode", "msg" }, new Object[] { Integer.valueOf(0), "" }, Result.class);
    public final PBStringField msg = PBField.initString("");
    public final PBInt32Field retCode = PBField.initInt32(0);
  }
  
  public static final class StCommonExt
    extends MessageMicro<StCommonExt>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "mapInfo", "attachInfo", "mapBytesInfo" }, new Object[] { null, "", null }, StCommonExt.class);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudCommon.BytesEntry> mapBytesInfo = PBField.initRepeatMessage(FeedCloudCommon.BytesEntry.class);
    public final PBRepeatMessageField<FeedCloudCommon.Entry> mapInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     feedcloud.FeedCloudCommon
 * JD-Core Version:    0.7.0.1
 */