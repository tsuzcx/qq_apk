package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QSecCloudAVEngineMsg
{
  public static final class QSecCloudQuery
    extends MessageMicro<QSecCloudQuery>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "head", "body" }, new Object[] { null, null }, QSecCloudQuery.class);
    public QSecCloudAVEngineMsg.QSecCloudQueryBody body = new QSecCloudAVEngineMsg.QSecCloudQueryBody();
    public QQProtectCommon.QQProtectQueryHead head = new QQProtectCommon.QQProtectQueryHead();
  }
  
  public static final class QSecCloudQueryBody
    extends MessageMicro<QSecCloudQueryBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "version", "queryEntry" }, new Object[] { Integer.valueOf(0), null }, QSecCloudQueryBody.class);
    public final PBRepeatMessageField<QSecCloudAVEngineMsg.QSecCloudQueryEntry> queryEntry = PBField.initRepeatMessage(QSecCloudAVEngineMsg.QSecCloudQueryEntry.class);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class QSecCloudQueryEntry
    extends MessageMicro<QSecCloudQueryEntry>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField appName = PBField.initString("");
    public final PBStringField certMd5 = PBField.initString("");
    public final PBUInt32Field entryId = PBField.initUInt32(0);
    public final PBBytesField extraInfo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField fileMd5 = PBField.initString("");
    public final PBStringField fileName = PBField.initString("");
    public final PBUInt32Field fileSize = PBField.initUInt32(0);
    public final PBUInt32Field fileType = PBField.initUInt32(0);
    public final PBStringField packageName = PBField.initString("");
    public final PBUInt32Field scenarioType = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 74, 82 }, new String[] { "entryId", "fileType", "scenarioType", "fileSize", "packageName", "fileName", "appName", "fileMd5", "certMd5", "extraInfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", localByteStringMicro }, QSecCloudQueryEntry.class);
    }
  }
  
  public static final class QSecCloudRespBody
    extends MessageMicro<QSecCloudRespBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "status", "version", "respEntry" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, QSecCloudRespBody.class);
    public final PBRepeatMessageField<QSecCloudAVEngineMsg.QSecCloudRespEntry> respEntry = PBField.initRepeatMessage(QSecCloudAVEngineMsg.QSecCloudRespEntry.class);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class QSecCloudRespEntry
    extends MessageMicro<QSecCloudRespEntry>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field actionType = PBField.initUInt32(0);
    public final PBUInt32Field attrType = PBField.initUInt32(0);
    public final PBUInt32Field category = PBField.initUInt32(0);
    public final PBUInt32Field entryId = PBField.initUInt32(0);
    public final PBBytesField extraInfo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field subCategory = PBField.initUInt32(0);
    public final PBUInt32Field timeToLive = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58 }, new String[] { "entryId", "attrType", "category", "subCategory", "timeToLive", "actionType", "extraInfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, QSecCloudRespEntry.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ims.QSecCloudAVEngineMsg
 * JD-Core Version:    0.7.0.1
 */